package com.User;

/**
 * Created by Bobby on 03-May-16.
 */
// Factory design pattern - interface class
public interface Filter{
    Book search(String title);
    Book search(Genre genre);
    Book search(int year);
    Book search(String title, Genre genre);
    Book search(String title, int year);
    Book search(int year, Genre genre);
    Book search(String title, Genre genre, int year);
}
