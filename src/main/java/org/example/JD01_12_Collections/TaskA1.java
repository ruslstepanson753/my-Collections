package org.example.JD01_12_Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10) + 1;
            System.out.println(randomNumber);
            list.add(randomNumber);
        }
        System.out.println("-----------------------------------------------");
        TaskA1 taskA1 = new TaskA1();
        taskA1.clearbad(list);
        list.forEach(System.out::println);
    }
    
    public void clearbad(List<Integer> grades){
        for (int i = 0; i < grades.size(); i++) {
            if(grades.get(i) <= 3){
                list.remove(i);
            }
        }

    }
}
