package org.example.JD01_12_Collections;

import java.util.*;
import java.util.stream.Collectors;

public class TaskA2 {
    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        TreeSet<Integer> b = new TreeSet<>() {{
            add(4);
            add(5);
            add(6);
            add(7);
        }};

        Collection<Integer> result = new ArrayList<>(a);
        result = getCross(a, b);
        result.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        TaskA2 obj = new TaskA2();
        result = obj.getUnion(a, b);
        result.forEach(System.out::println);

    }

    public static Collection<Integer> getCross(Collection<Integer> a, Collection<Integer> b) {
        Collection<Integer> intersection = a.stream()
                .filter(b::contains)
                .collect(Collectors.toList());
        return intersection;
    }

    public static Collection<Integer> getUnion(Collection<Integer> a, Collection<Integer> b) {
        Set<Integer> intersection = new HashSet<>(a);
        intersection.addAll(b);
        intersection.addAll(a);
        return intersection;
    }
}
