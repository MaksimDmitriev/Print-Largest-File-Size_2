package com.prlargest;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class DirectoryIteratorTest {

    private String mTestDir = "C:\\Users\\Maksim\\Downloads\\Test" + File.separatorChar;

    @Test
    public void singleFileIsInit() {
        File initPath = new File(mTestDir + "Android_Accelerometer.jpg");
        Assert.assertEquals(initPath.getAbsolutePath(), DirectoryIterator.getLargestFilePath(initPath));
    }

    @Test
    public void onlyDirs() {
        File initPath = new File(mTestDir + "only_dirs");
        Assert.assertEquals(null, DirectoryIterator.getLargestFilePath(initPath));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPath() {
        Assert.assertEquals(null, DirectoryIterator.getLargestFilePath(null));
    }

    @Test
    public void emptyPath() {
        File initPath = new File("");
        Assert.assertEquals(null, DirectoryIterator.getLargestFilePath(initPath));
    }

    @Test
    public void programsFiles() {
        File initPath = new File("C:\\Program Files");
        Assert.assertEquals("C:\\Program Files\\NVIDIA Corporation\\Installer2\\Display.Driver.{4C1A3FB4-2B00-4F89-9EE0-D1BC24B6B509}\\NvCplSetupInt.exe", DirectoryIterator.getLargestFilePath(initPath));
    }
}
