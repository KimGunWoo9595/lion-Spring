package com.lion.refactoring7;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.util.Map;

@Configurable
public class UserDaoFactory {

    @Bean
    public UserDao awsUserDao() {
        return new UserDao(new AwsConnectionMaker());
    }


    @Bean
    public DataSource awsDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        Map<String, String> env = System.getenv();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(env.get("DB_HOST"));
        dataSource.setUsername(env.get("DB_USER"));
        dataSource.setPassword(env.get("DB_PASSWORD"));
        return dataSource;
    }


}