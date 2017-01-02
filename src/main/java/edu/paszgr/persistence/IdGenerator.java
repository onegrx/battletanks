package edu.paszgr.persistence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by onegrx on 02.01.17.
 */
public class IdGenerator {

    private static final AtomicInteger id = new AtomicInteger(1);

    public static int next() {
        return id.getAndIncrement();
    }
}
