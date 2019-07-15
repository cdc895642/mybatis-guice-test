package com.example.mapper;

import com.example.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

//  @Results(id = "findByIdResult", value = {
//      @Result(property = "id", column = "user_id", id = true),
//      @Result(property = "name", column = "user_name")
//  })
@ResultMap("UserResultMap")
  @Select("SELECT * FROM USERS WHERE user_id = #{userId}")
User findById(@Param("userId") String userId);

  @ResultMap("UserResultMap")
  @Select("SELECT * FROM USERS ")
  List<User> findAll();
}
