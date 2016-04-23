package com.User;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class BookLoans
{
    private int bookId;
    private String userId;
    private java.time.LocalDate dateLoan;
    private boolean isOverdue;

    public BookLoans()
    {
        bookId = 0;
        userId = null;
        dateLoan = null;
        isOverdue = false;
    }

    public BookLoans(int bookId, String userId, java.time.LocalDate dateLoan, boolean isOverdue)
    {
        this.bookId = bookId;
        this.userId = userId;
        this.dateLoan = dateLoan;
        this.isOverdue = isOverdue;
    }

    // Getters and Setters

    public int getBookId()
    {
        return bookId;
    }

    public java.time.LocalDate getDateLoan()
    {
        return dateLoan;
    }

    public void setDateLoan(java.time.LocalDate dateLoan)
    {
        this.dateLoan = dateLoan;
    }

    public void setIsOverdue(boolean overdue)
    {
        isOverdue = overdue;
    }
}
