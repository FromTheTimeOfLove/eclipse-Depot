package com.datadriver.web.user.service;

import java.util.List;

import com.datadriver.core.entity.Result;
import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.user.dto.UserDto;
import com.datadriver.web.user.model.User;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: UserService
 * @Description: 业务 接口
 */
public interface UserService extends GenericService<User, Long> {
	/**
	 * 根据用户名查询
	 * 
	 * @param roleDto
	 * @return
	 */
	PageInfo<User> selectPageByUserName(UserDto userDto) throws UnitedException;

	/**
	 * 查询当前用户的权限
	 * 
	 * @param id
	 * @return
	 * @throws UnitedException
	 */
	List<ZtreeNode> selectRoleTree(String id) throws UnitedException;

	/**
	 * 角色授权
	 * 
	 * @param user
	 * @return
	 * @throws UnitedException
	 */
	void saveUserRole(User user) throws UnitedException;

	/**
	 * @Title: updatePwdByUserId
	 * @Description: 修改用户密码
	 * @param @param userDto
	 * @param @return
	 * @param @throws UnitedException 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	Result updatePwdByUserId(UserDto userDto) throws UnitedException;

	/**
	 * @Title: updateUserByUserId
	 * @Description: 修改用户(不包含修改用户密码)
	 * @param @param user
	 * @param @return
	 * @param @throws UnitedException 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	int updateUserByUserId(User record) throws UnitedException;

	/**
	 * 重置密碼
	 * 
	 * @param id
	 * @return
	 * @throws UnitedException
	 */
	void updatePassword(String id) throws UnitedException;

	/**
	 * 判断数据库中是否存在该登录账号
	 * 
	 * @param username
	 * @param type
	 * @return
	 */
	int findUserName(User user, String type);

}
