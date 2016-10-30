package com.sketchproject;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // read and write binary file rather than text file
        try(FileInputStream in = new FileInputStream("flower.jpg");
            FileOutputStream out = new FileOutputStream("new.jpg")
        ){
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read and write text file, this is better
        try(FileReader in = new FileReader("textfile.txt");
            FileWriter out = new FileWriter("new.txt")
        ){
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // buffer is best for managing memory for writing and reading
        try(BufferedReader in = new BufferedReader(new FileReader("hamlet.xml"));
            BufferedWriter out = new BufferedWriter(new FileWriter("newhamlet.xml"))
        ){
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }
            System.out.println("All done");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read the tokenize text
        try(Scanner s = new Scanner(new BufferedReader(new FileReader("tokenizedtext.txt")))
        ){
            s.useDelimiter(",");
            while(s.hasNext()){
                System.out.println(s.next());
            }
            System.out.println("All done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
