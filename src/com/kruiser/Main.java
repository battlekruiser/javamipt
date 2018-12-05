package com.kruiser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.kruiser.FileUtils.*;

public class Main {

    public static void main(String[] args) {
        int a = (int)(Math.random()*100+1);
        int b = (int)(Math.random()*100+1);
        int t = a > b ? a : b;
        int t2= a + b - t;
        List<String> raw, input;
        try {
            raw = readAll("words.txt");
        } catch(IOException e) {
            System.out.println("ну щито поделать");
            e.printStackTrace();
            return;
            //System.out.println("А хотя можно ещё раз попробовать");
        }
        input = new ArrayList<String>();
        for(String s : raw)
            input.addAll(Arrays.asList(s.split(";")));
        for(String s : input)
            System.out.println(s);
    }
}
