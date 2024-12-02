package org.example;

import java.util.HashMap;
import java.util.Set;

public class MySet<E> implements Set<E> {
    private transient HashMap<E,Object> map;
    private int size;
}
