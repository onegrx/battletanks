package edu.paszgr.persistence;

import java.util.ListIterator;

public interface ListIterable<T> {
    ListIterator<T> listIterator();
}
