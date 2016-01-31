package com.prlargest;


import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class DirectoryIterator {

    private DirectoryIterator() {
        throw new AssertionError();
    }

    public static File getBiggestFile(File initPath) {
        checkNotNull(initPath);

        File biggestFile = new File("");
        Deque<File> stack = new ArrayDeque<>();
        stack.push(initPath);
        while (!stack.isEmpty()) {
            File current = stack.pop();
            File[] files = current.listFiles();
            if (files != null) {
                for (File file : files) {
                    stack.push(file);
                }
            } else if (current.length() > biggestFile.length()) {
                biggestFile = current;
            }
        }
        return biggestFile;
    }

    private static File getBiggestFileRec(File current, File biggest) {
        File[] files = current.listFiles();
        if (files != null) {
            for (File file : files) {
                biggest = getBiggestFileRec(file, biggest);
            }
        } else if (current.length() > biggest.length()) {
            biggest = current;
        }
        return biggest;
    }

    public static File getBiggestFileRec(File current) {
        checkNotNull(current);
        return getBiggestFileRec(current, new File(""));
    }

    private static void checkNotNull(File file) {
        if (file == null) {
            throw new IllegalArgumentException("The init path cannot be null");
        }
    }

}