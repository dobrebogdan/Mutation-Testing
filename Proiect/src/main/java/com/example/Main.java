package com.example;

import java.util.LinkedList;

public class Main {
    // toate numerele care sunt divizor al lui num1, nu sunt divizor al lui num2, sunt multipu
    // al lui num3 si nu sunt multiplu al lui num4 ordonate crescator
    public Integer[] numberSearh(Integer num1, Integer num2, Integer num3, Integer num4) {
        LinkedList<Integer> foundNumbers = new LinkedList();
        for(int i = 1; i <= num1; i++) {
            if(num1 % i ==0 && num2 % i != 0 && i % num3 == 0 && i % num4!=0) {
                foundNumbers.add(i);
            }
        }

        int numbersCount = foundNumbers.size();
        Integer[] numbersList = new Integer[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            numbersList[i] = foundNumbers.peekLast();
            foundNumbers.removeLast();
        }

        for(int i = 0; i < numbersCount; i++) {
            for(int j = i+1; j < numbersCount; j++) {
                if(numbersList[i] > numbersList[j]) {
                    int x = numbersList[i];
                    numbersList[i] = numbersList[j];
                    numbersList[j] = x;
                }
            }
        }
        return numbersList;

    }

}
