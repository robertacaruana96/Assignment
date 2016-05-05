package com.User;

/**
 * Created by Bobby on 03-May-16.
 */
public class FilterFactory {

    public Filter getFilter() {
        return new SearchBy();
    }
}
