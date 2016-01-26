package com.prlargest;


import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class DirectoryIterator {

    private DirectoryIterator() {
        throw new AssertionError();
    }

    public static String getLargestFilePath(File initPath) {
        if (initPath == null) {
            throw new IllegalArgumentException("The init path cannot be null");
        }
        long maxFileLength = 0;
        String maxFilePath = null;
        Deque<File> stack = new ArrayDeque<>();
        stack.push(initPath);
        while (!stack.isEmpty()) {
            File current = stack.pop();
            File[] files = current.listFiles();
            if (files != null) {
                for (File file : files) {
                    stack.push(file);
                }
            } else if (current.length() > maxFileLength) {
                maxFileLength = current.length();
                maxFilePath = current.getAbsolutePath();
            }
        }
        return maxFilePath;
    }

}