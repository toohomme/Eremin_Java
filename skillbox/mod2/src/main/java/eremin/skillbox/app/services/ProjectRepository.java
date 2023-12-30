package eremin.skillbox.app.services;

import eremin.skillbox.app.exceptions.BookShelfQueryRegexException;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItemById(Integer bookIdToRemove);

    void removeItemByRegex(String queryRegex) throws BookShelfQueryRegexException;
}
