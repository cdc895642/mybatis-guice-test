package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import java.util.List;
import javax.inject.Inject;
import org.mybatis.guice.transactional.Transactional;

public class UserService {
  @Inject
  private UserMapper userMapper;

  @Transactional
  public User doSomeBusinessStuff(String userId) {
    return this.userMapper.findById(userId);
  }

  @Transactional
  public List<User> findAll() {
    return this.userMapper.findAll();
  }
}
