package com.rentacar.rentacar_api;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Value("${MYSQLDB_DOCKER_PORT}")
    private String mySQLDockerPort;

    @Value("${MYSQLDB_DATABASE}")
    private String mySQLDatabase;

    @Value("${MYSQLDB_USER}")
    private String mySQLUser;

    @Value("${MYSQLDB_PASSWORD}")
    private String mySQLPassword;
    
    @Bean
    public DataSource getDataSource() {
      System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!GET DATA SOURCE CALLED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      System.out.println("mySQLDatabase > > " + mySQLDatabase);
      System.out.println("jdbc:mysql://mysqldb:"+mySQLDockerPort+"/"+mySQLDatabase+"?useSSL=false");
      DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
      dataSourceBuilder.url("jdbc:mysql://mysqldb:"+mySQLDockerPort+"/"+mySQLDatabase+"?useSSL=false");
      dataSourceBuilder.username(mySQLUser);
      dataSourceBuilder.password(mySQLPassword);
      return dataSourceBuilder.build();
    }
}
