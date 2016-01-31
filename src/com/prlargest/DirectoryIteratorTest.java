package com.prlargest;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class DirectoryIteratorTest {

    private String mTestDir = "C:\\Users\\Maksim\\Downloads\\Test" + File.separatorChar;

    @Test
    public void singleFileIsInit() {
        File initPath = new File(mTestDir + "Android_Accelerometer.jpg");
        Assert.assertEquals(initPath, DirectoryIterator.getBiggestFileRec(initPath));
        Assert.assertEquals(initPath, DirectoryIterator.getBiggestFile(initPath));
    }

    @Test
    public void onlyDirs() {
        File initPath = new File(mTestDir + "only_dirs");
        File empty = new File("");
        Assert.assertEquals(empty, DirectoryIterator.getBiggestFileRec(initPath));
        Assert.assertEquals(empty, DirectoryIterator.getBiggestFile(initPath));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPath() {
        Assert.assertEquals(null, DirectoryIterator.getBiggestFile(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPathRec() {
        Assert.assertEquals(null, DirectoryIterator.getBiggestFileRec(null));
    }

    @Test
    public void emptyPath() {
        File empty = new File("");
        Assert.assertEquals(empty, DirectoryIterator.getBiggestFileRec(empty));
        Assert.assertEquals(empty, DirectoryIterator.getBiggestFile(empty));
    }

    @Test
    public void programsFiles() {
        File initPath = new File("C:\\Program Files");
        File expectedBiggest = new File("C:\\Program Files\\NVIDIA Corporation\\Installer2\\Display.Driver.{4C1A3FB4-2B00-4F89-9EE0-D1BC24B6B509}\\NvCplSetupInt.exe");
        Assert.assertEquals(expectedBiggest, DirectoryIterator.getBiggestFileRec(initPath));
        Assert.assertEquals(expectedBiggest, DirectoryIterator.getBiggestFile(initPath));
    }
}
