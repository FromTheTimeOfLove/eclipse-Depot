package com.datadriver.web.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.Result;
import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.user.dao.UserMapper;
import com.datadriver.web.user.dto.UserDto;
import com.datadriver.web.user.model.User;
import com.datadriver.web.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements
		UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public PageInfo<User> selectPageByUserName(UserDto userDto)
			throws UnitedException {
		PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize(), true);
		List<User> list = userMapper.selectPageByUserName(userDto);
		return new PageInfo<User>(list);
	}

	@Override
	public int insert(User model) throws UnitedException {
		return userMapper.insert(model);
	}

	@Override
	public int update(User model) throws UnitedException {
		return userMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public User selectById(Long id) throws UnitedException {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delete(Long id) throws UnitedException {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ZtreeNode> selectRoleTree(String id) throws UnitedException {
		return userMapper.selectRoleTree(id);
	}

	@Override
	public void saveUserRole(User user) throws UnitedException {
		List<User> listUser = new ArrayList<User>();
		String[] id = user.getUserName().split(",");
		String userId = user.getUserId();
		for (int i = 0; i < id.length; i++) {
			user = new User();
			if ("0".equals(id[i]))
				continue;
			user.setUserId(userId);
			user.setLeave(id[i]);
			listUser.add(user);
		}
		userMapper.deleteUserRole(userId);
		userMapper.saveUserRole(listUser);
	}

	@Override
	public GenericDao<User, Long> getDao() {
		return userMapper;
	}

	@Override
	public Result updatePwdByUserId(UserDto userDto) throws UnitedException {
		Result result = new Result();
		// 1、到数据库中校验旧密码是否正确
		String isCorrect = userMapper.getPwdIsCorrect(userDto);
		// 2、如果正确，则更新密码，如果错误，则提示错误
		if ("TRUE".equals(isCorrect)) {
			userMapper.updatePwdById(userDto);
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} else {
			result.setResultCode(ResultEnum.ERROR.getValue());
		}
		return result;
	}

	@Override
	public int updateUserByUserId(User record) throws UnitedException {
		return userMapper.updateUserByUserId(record);
	}

	@Override
	public void updatePassword(String id) throws UnitedException {
		String[] idps = id.split(";");
		UserDto userDto = new UserDto();
		userDto.setUserId(idps[0]);
		userDto.setNewPassword(idps[1]);
		userMapper.updatePwdById(userDto);
	}

	@Override
	public int findUserName(User user, String type) {
		// TODO Auto-generated method stub
		int count = 0;
		if ("insert".equals(type)) {// 标示新增
			count = userMapper.findUserInsert(user);
		} else {
			count = userMapper.findUserUpdate(user);
		}
		return count;
	}
}
