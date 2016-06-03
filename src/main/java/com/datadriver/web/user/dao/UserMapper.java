package com.datadriver.web.user.dao;

import java.util.List;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.user.dto.UserDto;
import com.datadriver.web.user.model.User;

public interface UserMapper extends GenericDao<User, Long> {
	List<User> selectPageByUserName(Object userName);

	int insert(User record);

	int updateByPrimaryKeySelective(User record);

	User selectByPrimaryKey(String UserId);

	int deleteByPrimaryKey(String UserId);

	List<ZtreeNode> selectRoleTree(String UserId) throws UnitedException;

	void saveUserRole(List<User> listUser);

	void deleteUserRole(String UserId);

	String getPwdIsCorrect(UserDto userDto);

	void updatePwdById(UserDto userDto);

	int updateUserByUserId(User record);

	void updatePassword(String id, String password);

	int findUserInsert(User user);

	int findUserUpdate(User user);
}
