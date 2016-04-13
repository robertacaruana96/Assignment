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

    //a test to validate setName method
    @Test
    public void testUserId() {
        user.setName("Nina");
        String result = user.getName();
        assertEquals("Nina", result);
    }
}