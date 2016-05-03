package com.User;

/**
 * Created by Bobby on 03-May-16.
 */
public class FilterFactory {

    public Filter getFilter(String filterType)
    {
        if(filterType == null)
        {
            return null;
        }
        if(filterType == "TITLE")
        {
            return new searchByTitle();
        }
        else if(filterType == "GENRE")
        {
            return new SearchByGenre();
        }
        else if(filterType == "YEAROFPUBLICATION")
        {
            return new SearchByYearOfPublication();
        }
        return null;
    }
}
