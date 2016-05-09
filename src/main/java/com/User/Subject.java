package com.User;

import java.util.Observer;

/**
 * Created by Bobby on 05-May-16.
 */
public interface Subject
{
    public void addObserver(com.User.Observer observer);
    public void removeObserver(com.User.Observer observer);
    public String notifyObserver(Book book, User user);
}
