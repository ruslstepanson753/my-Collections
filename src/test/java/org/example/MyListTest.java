package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    private List<Integer> list;
    private MyList<Integer> myList;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        myList = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
    }

    @Test
    void addTest() {
        assertEquals(myList.size(), 5);
    }

    @Test
    void size() {
        assertEquals(myList.size(), 5);
    }

    @Test
    void isEmpty() {
        assertEquals(myList.isEmpty(), false);
    }

    @Test
    void contains() {
        assertEquals(myList.contains(new Integer(1)), true);
        assertEquals(myList.contains(2), true);
    }

    @Test
    void toArray() {
        assertEquals(myList.toArray()[0], list.toArray()[0]);
        assertEquals(myList.toArray()[1], list.toArray()[1]);
        assertEquals(myList.toArray()[2], list.toArray()[2]);
        assertEquals(myList.toArray()[3], list.toArray()[3]);
        assertEquals(myList.toArray()[4], list.toArray()[4]);
    }

    @Test
    void remove() {
        myList.remove(2);
        assertEquals(myList.size(), 4);
        assertEquals(myList.remove(new Integer(1)), list.remove(new Integer(1)));

    }

    @Test
    void containsAll() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(8);
        assertEquals(myList.containsAll(myList), true);
        assertEquals(myList.containsAll(list1), false);
    }

    @Test
    void addAll() {
        myList.addAll(list);
        assertEquals(myList.size(), 10);
    }

    @Test
    void removeAll() {
        list.remove(1);
        myList.removeAll(list);
        assertEquals(myList.size(), 1);
    }

    @Test
    void removeIf() {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        myList.removeIf(isEven);
        assertEquals(myList.size(), 3);

    }

    @Test
    void retainAll() {
        myList.add(8);
        myList.add(11);
        myList.add(13);
        myList.retainAll(list);
        assertEquals(myList.size(), 5);
    }

    @Test
    void replaceAll() {
        UnaryOperator<Integer> multiplyByTwo = x -> x * 2;
        myList.replaceAll(multiplyByTwo);
        assertEquals(myList.size(), 5);
        assertEquals(myList.get(4), 10);
    }

    @Test
    void sort() {
        Comparator<Integer> lengthComparator = Comparator.comparingInt(Integer::intValue).reversed();
        myList.sort(lengthComparator);
        assertEquals(myList.get(0), 5);
    }

    @Test
    void clear() {
        myList.clear();
        assertEquals(myList.size(), 0);
    }

    @Test
    void get() {
        assertEquals(myList.get(3), 4);
    }

    @Test
    void set() {
        myList.set(3, 111);
        assertEquals(myList.get(3), 111);
    }

    @Test
    void indexOf() {
        myList.add(69);
        assertEquals(myList.indexOf(69), 5);
    }

    @Test
    void lastIndexOf() {
        myList.add(69);
        myList.add(1);
        assertEquals(myList.lastIndexOf(1), 6);
    }

    @Test
    void listIterator() {
        ListIterator<Integer> iterator = myList.listIterator();
        iterator.next();
        iterator.set(666);
        assertEquals(myList.get(0), 666);
        assertEquals(iterator.next(), 2);
    }

    @Test
    void subList() {
        list = myList.subList(0, 2);
        assertEquals(list.size(), 2);
    }

    @Test
    void spliterator() {
        // Получаем Spliterator
        Spliterator<Integer> spliterator = myList.spliterator();

        // Проверяем, что Spliterator не null
        assertNotNull(spliterator);

        // Проверяем размер списка
        assertEquals(5, spliterator.getExactSizeIfKnown());

        // Проверяем, что Spliterator поддерживает операции forEachRemaining
        spliterator.forEachRemaining(element -> {
            assertTrue(myList.contains(element));
        });


    }

    @Test
    public void testStream() {
        // Получаем поток из списка
        Stream<Integer> stream = myList.stream();

        // Проверяем, что поток не null
        assertNotNull(stream);

        // Преобразуем поток в список и проверяем содержимое
        List<Integer> streamList = stream.collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3,4,5), streamList);
    }

    @Test
    public void testStreamOperations() {
        // Получаем поток из списка
        Stream<Integer> stream = myList.stream();

        // Применяем операции к потоку
        List<Integer> filteredList = stream
                .filter(s -> s.equals(2))
                .collect(Collectors.toList());

        // Проверяем результат фильтрации
        assertEquals(Arrays.asList(2), filteredList);
    }

    @Test
    public void testStreamParallel() {
        // Получаем параллельный поток из списка
        Stream<Integer> parallelStream = myList.parallelStream();

        // Проверяем, что поток параллельный
        assertTrue(parallelStream.isParallel());

        // Преобразуем поток в список и проверяем содержимое
        List<Integer> parallelStreamList = parallelStream.collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3,4,5), parallelStreamList);
    }



}