package wniosk;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dan
 */
public class wzory {
    FileReader file; 
    ArrayList<String> tablica = new ArrayList<String>();
    public wzory(String sciezka) {
        try{
            this.file = new FileReader(sciezka);
            Scanner input = new Scanner (this.file);
            while(input.hasNextLine()){
               tablica.add(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e){ }
       
    }
   
}
