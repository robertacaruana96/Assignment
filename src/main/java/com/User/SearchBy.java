package com.User;

/**
 * Created by Bobby on 04-May-16.
 */
public class SearchBy implements Filter
{
    Catalogue c = Catalogue.getInstance();

    @Override
        public Book search(String title)
        {
            Book result = null;
            for (int i = 0; i < c.bookList.size(); i++)
            {
                if (c.bookList.get(i).getTitle().equalsIgnoreCase(title))
                {
                    result = c.bookList.get(i);
                }
            }
            return result;
        }
    @Override
    public Book search(int year)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++){
            if (c.bookList.get(i).getYearOfPublication() == year)
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }

    @Override
    public Book search(Genre genre)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++)
        {
            if (c.bookList.get(i).getGenre().getGenreType().equals(genre.getGenreType()))
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }

    @Override
    public Book search(String title, Genre genre)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++)
        {
            if ((c.bookList.get(i).getGenre().getGenreType().equals(genre.getGenreType())) && (c.bookList.get(i).getTitle().equalsIgnoreCase(title)))
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }

    @Override
    public Book search(String title, int year)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++)
        {
            if ( (c.bookList.get(i).getTitle().equalsIgnoreCase(title)) && (c.bookList.get(i).getYearOfPublication() == year))
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }

    @Override
    public Book search(int year, Genre genre)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++)
        {
            if ( (c.bookList.get(i).getYearOfPublication() == year) && (c.bookList.get(i).getGenre().getGenreType().equals(genre.getGenreType())) )
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }

    @Override
    public Book search(String title, Genre genre, int year)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++)
        {
            if ( (c.bookList.get(i).getTitle().equalsIgnoreCase(title)) && (c.bookList.get(i).getGenre().getGenreType().equals(genre.getGenreType())) && (c.bookList.get(i).getYearOfPublication() == year))
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }
}
