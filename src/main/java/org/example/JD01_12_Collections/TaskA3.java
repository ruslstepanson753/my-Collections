package org.example.JD01_12_Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> listNegative = new ArrayList<Integer>();
        while (true){
            String line = sc.nextLine();
            if (line.equals("end")){
                break;
            }
            Integer number = Integer.parseInt(line);
            if(number>0){
                list.add(number);
            }else {
                listNegative.add(number);
            }

        }
        System.out.print(list.toString());
        System.out.println(listNegative.toString());

    }
}
