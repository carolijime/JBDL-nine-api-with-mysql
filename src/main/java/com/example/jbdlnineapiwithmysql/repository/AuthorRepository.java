package com.example.jbdlnineapiwithmysql.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class AuthorRepository {

    //Autowired below makes the code to be using the same connection here in author and in person repositories
    @Autowired
    Connection connection;

    //Code below creates a new connection (different to the person one)
//    Connection connection;
//    public AuthorRepository(){
//        this.connection = DriverManager.getConnection();
//    }
}
