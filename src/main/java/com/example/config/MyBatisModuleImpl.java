package com.example.config;

import com.example.mapper.UserMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

public class MyBatisModuleImpl extends MyBatisModule {

  protected void initialize() {
//    environmentId("prod");
    bindDataSourceProviderType(PooledDataSourceProvider.class);
    bindTransactionFactoryType(JdbcTransactionFactory.class);
    addMapperClass(UserMapper.class);
  }
}
