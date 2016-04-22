package com.User;
import java.util.*;
import java.io.*;

/**
 * Created by Bobby on 19-Apr-16
 */
public class BookLoans {
    private int bookId;
    private String userId;
    private Date dateLoan;

    public BookLoans(){
        bookId = 0;
        userId = null;
        dateLoan = null;
    }

    public BookLoans(int bookId, String userId, Date dateLoan) {
        this.bookId = bookId;
        this.userId = userId;
        this.dateLoan = dateLoan;
    }

    // Getters and Setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }
}
