package com.example.config;

import com.example.mapper.UserMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

public class XmlMyBatisModuleImpl extends XMLMyBatisModule {

  protected void initialize() {
//    setEnvironmentId("prod");
    setClassPathResource("mybatis-config.xml");

  }
}
