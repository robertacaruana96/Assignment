package com.User;

import java.util.*;
import java.io.*;
import org.joda.time.*;

public class BookLoans
{
    private int bookId;
    private String userId;
    private org.joda.time.LocalDate dateLoan;
    private boolean isOverdue;

    public BookLoans()
    {
        bookId = 0;
        userId = null;
        dateLoan = null;
        isOverdue = false;
    }

    public BookLoans(int bookId, String userId, org.joda.time.LocalDate dateLoan, boolean isOverdue)
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

    public org.joda.time.LocalDate  getDateLoan()
    {
        return dateLoan;
    }

    public void setDateLoan(org.joda.time.LocalDate  dateLoan)
    {
        this.dateLoan = dateLoan;
    }

    public void setIsOverdue(boolean overdue)
    {
        isOverdue = overdue;
    }
}
