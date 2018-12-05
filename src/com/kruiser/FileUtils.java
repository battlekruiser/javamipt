package com.kruiser;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public final class FileUtils {
    private FileUtils() {

    }

    public static boolean exists(File file) {
        return file.exists();
    }

    public static boolean exists(String path) {
        return Files.exists(Paths.get(path));
    }

    public static boolean exists(Path p) {
        return Files.exists(p);
    }

    public static List<String> readAll(String path) throws IOException {
        return readAll(Paths.get(path));
    }

    public static List<String> readAll(File file) throws IOException{
        return readAll(Paths.get(file.getPath()));
    }

    public static List<String> readAll(Path path) {
        List<String> res = new ArrayList<String>();
        try(Scanner scan = new Scanner(path)) {
            while (scan.hasNextLine()) {
                res.add(scan.nextLine());
            }
        } catch(IOException e) {
            System.err.println(e);
            throw new UncheckedIOException(e);
        }
        return res;
    }

    public static void writeAll(String path, List<String> list) throws IOException {
        writeAll(Paths.get(path), list);
    }

    public static void writeAll(File f, List<String> l) throws IOException {
        writeAll(Paths.get(f.getPath()), l);

    }

    //перезаписывает файл целиком
    public static void writeAll(Path path, List<String> list){
        try(BufferedWriter bw = Files.newBufferedWriter(path)) {
            for(String item: list) {
                bw.write(item);
                bw.newLine();
            }
        } catch(IOException e) {
            System.err.println(e);
            throw new UncheckedIOException(e);
        }
    }


}
