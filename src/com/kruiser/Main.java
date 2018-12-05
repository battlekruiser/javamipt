package com.kruiser;

import javafx.util.Pair;

import java.io.IOException;
import java.util.*;

import static com.kruiser.FileUtils.*;

public class Main {

    public static void main(String[] args) {
        //init
        int a = (int) (Math.random() * 100 + 1);
        int b = (int) (Math.random() * 100 + 1);
        int t = a > b ? a : b;
        int t2 = a + b - t;
        List<String> raw, input;

        //input
        try {
            raw = readAll("words.txt");
        } catch (IOException e) {
            System.out.println("ну щито поделать");
            e.printStackTrace();
            return;
            //System.out.println("А хотя можно ещё раз попробовать");
        }

        //randomness
        input = new ArrayList<String>();
        for (String s : raw) {
            input.addAll(Arrays.asList(s.split(";")));
        }
        Collections.shuffle(input);
        List<Integer> numbers = new ArrayList<>();
        /*for (int i = 0; i < b; i++) {
            numbers.add((int) (Math.random() * 1024)); //- так могут повторяться ключи
        }*/
        for(int i = 0; i < b; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); //вот так хорошооо

        //map
        Map result;
        if (a > b) {
            result = new HashMap<String, Integer>();
            for(int i = 0; i < a; i++) {
                result.put(input.get(i), i <= b ? numbers.get(i) : null);
            }
        } else {
            result = new HashMap<Integer, String>();
            for(int i = 0; i < b; i++) {
                result.put(numbers.get(i), i <= a ? numbers.get(i) : null);
            }
        }

        //делаем что-нибудь с результатом
        //туду//туду// тудудуду
    }
}
