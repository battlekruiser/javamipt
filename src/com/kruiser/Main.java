package com.kruiser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> egor = new ArrayList<String>();
        for(int i = 0; i < 1; i++) {
            egor.add(Integer.toOctalString(i));
        }
        FileIterator iterr;
        try {
            iterr = new FileIterator("empty.txt");
            while(iterr.hasNext())
                System.out.println(iterr.next());
            System.out.println("and now a non-empty file");
            FileUtils.writeAll(new File("test.txt"), egor);
            iterr = new FileIterator("test.txt");
            while(iterr.hasNext())
                System.out.println(iterr.next());
        } catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        //System.out.println(FileUtils.exists("bepis.txt") + " " + FileUtils.exists("benis.txt"));
    }
}
