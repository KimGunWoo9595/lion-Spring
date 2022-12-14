package com.lion.refactoring6;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class UserDaoFactory {

    @Bean
    public UserDao awsUserDao() {
        return new UserDao(new AwsConnectionMaker());
    }



}