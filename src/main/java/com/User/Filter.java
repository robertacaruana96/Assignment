package com.User;

/**
 * Created by Bobby on 03-May-16.
 */
// Factory design pattern - interface class
public interface Filter<T> {
    Book search(T data);
}
