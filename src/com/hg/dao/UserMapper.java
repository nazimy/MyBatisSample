/**
 * 
 */
package com.hg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hg.pojo.UserPojo;
import com.hg.pojo.UserPojo1;

/**
 * @author 96458
 *
 */
public interface UserMapper {
	UserPojo selectById(int id);
	UserPojo selectById2(@Param(value="id")int id,@Param(value="psw")String psw);
	
	List<UserPojo> selectAll();
	int updataUser(UserPojo pojo);
	
	List<UserPojo1> selectAll1();
	
	List<UserPojo1> selectAll2();
	
	int insertUserpojo(List<UserPojo> list); 
}	
