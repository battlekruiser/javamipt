package com.kruiser;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileIterator implements Iterator<String>, AutoCloseable {
    private BufferedReader br; private FileReader fr;
    private String next;

    public FileIterator(String path) throws IOException {
        this(Paths.get(path));
    }

    public FileIterator(File f) throws IOException {
        this(f.getPath());
    }

    public FileIterator(Path path) throws IOException{
        br = new BufferedReader(fr = new FileReader(path.toFile()));
        next = br.readLine();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String next() {
        String tmp = next;
        try {
            next = br.readLine();
        } catch(IOException e) {
            System.err.println(e);
            throw new UncheckedIOException(e);
        }
        return tmp;
    }

    @Override
    public void close() throws IOException{
        br.close();
    }

}