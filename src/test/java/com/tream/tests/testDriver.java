package com.tream.tests;

import javax.swing.*;
import java.io.File;
import java.io.FileFilter;

public class testDriver {


    public void test_JDK8_lambda() {
        FileFilter java = (File f) -> f.getName().endsWith("*.java");

    }
    {

        JButton b = new JButton();
        b.addActionListener(e -> {
            System.out.println("clicked");
        });
    }















}
