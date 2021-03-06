package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String INCORRECT_PASSWORD = "testdata.user.password";


    public static User loginWithCorrectData(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User loginWithIncorrectData(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),INCORRECT_PASSWORD);
    }}
