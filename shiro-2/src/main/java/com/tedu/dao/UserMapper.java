package com.tedu.dao;

import com.tedu.bean.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
	/**
	 * 插入一个用户信息
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 根据用户名查询
	 * @param username
	 * @return 如果查到了，把记录封装成user对象返回
	 *         如果没查到，返回null
	 */
	User selectByUsername(String username);
	/**
	 * 通过邮箱查询
	 * @param email
	 * @return：如果存在，那么返回行数；
	 * 			如果不存在，返回0；
	 */
	Integer selectByEmail(String email);
	/**
	 * 通过电话查询
	 * @param phone
	 * @return：如果存在，那么返回行数；
	 * 			如果不存在，返回0；
	 */
	Integer selectByPhone(String phone);
	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return 如果有，返回当前记录封装成user对象
	 * 		      如果没有，返回null
	 */
	User selectUserById(Integer id);
	/**
	 * 更新图片（参数超过两个，必须做映射）
	 * @param id
	 * @param image
	 */
	void updateImage(@Param("id") Integer id, @Param("image") String image);
}






