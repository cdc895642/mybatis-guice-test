package com.example;

import com.example.config.DbModule;
import com.example.config.MyBatisModuleImpl;
import com.example.config.XmlMyBatisModuleImpl;
import com.example.model.User;
import com.example.service.UserService;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.util.ArrayList;
import java.util.List;
import org.flywaydb.core.Flyway;

import org.mybatis.guice.datasource.helper.JdbcHelper;

public class App {

  public static void main(String[] args) {
    Flyway.configure()
        .dataSource("jdbc:hsqldb:mem:appmemdb", "admin", "password")
        .load()
        .migrate();

    List<Module> modules = createMyBatisModule();
    Injector injector = Guice.createInjector(modules);
    UserService instance = injector.getInstance(UserService.class);
    List<User> all = instance.findAll();
    User u1 = instance.doSomeBusinessStuff("u1");
System.out.println(u1);
  }

  private static List<Module> createMyBatisModule() {
    List<Module> modules = new ArrayList<>();
//    modules.add(new XmlMyBatisModuleImpl());
//    modules.add(JdbcHelper.HSQLDB_IN_MEMORY_NAMED);
    modules.add(new DbModule());
    modules.add(new MyBatisModuleImpl());

    return modules;
  }
}
