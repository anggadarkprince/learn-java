package com.sketchproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Testing
 * Created by Angga on 26/07/2016.
 */
public class Reader {
    public static void main(String[] args) throws IOException {
        try {
            String file = readFile("ATextFile.txt");
            if (file.equals("This is file")) {
                System.out.println(file);
            } else {
                throw (new WrongFileException());
            }
        } catch (WrongFileException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String filename) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
        }
        return sb.toString();
    }
}
