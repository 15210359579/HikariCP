package com.test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author didi
 * @DESCRIPTION main
 * @create 2018-04-18 下午8:39
 **/

public class Main {
   public static void main(String[] args) throws Exception{
      HikariConfig config = new HikariConfig(
         "/Users/didi/yangzhuo/project/javaproject/HikariCP/src/test/resources/jdbc.properties");
      System.out.println(config.getJdbcUrl());
      System.out.println(config.getConnectionTimeout());
      System.out.println(config.getMaximumPoolSize());
      System.out.println(config.getMinimumIdle());
      System.out.println(config.getUsername());
      System.out.println(config.getPassword());
      System.out.println(config.getDriverClassName());
      HikariDataSource  ds         = new HikariDataSource(config);
      long start = System.currentTimeMillis();

      Connection        connection = ds.getConnection();
      PreparedStatement statement = connection.prepareStatement("select * from config limit 1");
      ResultSet         set = statement.executeQuery();
      long end =System.currentTimeMillis();
      System.out.println(end -start);
      // while (set.next()) {
      //    System.out.println(set.getString(1));
      // }
   }
}
