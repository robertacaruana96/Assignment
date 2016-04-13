package com.User;

import java.io.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by leann on 13/04/2016.
 */
public class UserTest {

    //creating a user instance
    User user;

    @Before
    public void setUp() throws Exception {

        //creating the instance
        user = new User();
    }

    @After
    public void tearDown() throws Exception {

        //dereferencing the instance
        user = null;

    }

    //a test to validate setId method
    @Test
    public void testUserId() {
        user.setUserId("12345");
        String result = user.getUserId();
        assertEquals("12345", result);
    }

    //a test to validate setName method
    @Test
    public void testUserName() {
        user.setName("Nina");
        String result = user.getName();
        assertEquals("Nina", result);
    }

    //a test to validate setSurname method
    @Test
    public void testUserSurname() {
        user.setSurname("Vella");
        String result = user.getSurname();
        assertEquals("Vella", result);
    }

    //a test to validate setContactNumber method
    @Test
    public void testUserContactNumber() {
        user.setContactNumber(21212121);
        int result = user.getContactNumber();
        assertEquals(21212121, result);
    }

    //a test to validate setEmail method
    @Test
    public void testUserEmail() {
        user.setEmail("nina.vella@gmail.com");
        String result = user.getEmail();
        assertEquals("nina.vella@gmail.com", result);
    }

    //a test to validate setAddress method
    @Test
    public void testUserAddress(){
        user.setAddress("67,Bkara");
        String result = user.getAddress();
        assertEquals("67,Bkara", result);
    }
}