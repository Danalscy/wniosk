package wniosk;


import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class dane {
    FileReader file; 
    HashMap <String,Integer>tablica = new HashMap<String, Integer>();
    public dane(String sciezka) {
        try{
            this.file = new FileReader(sciezka);//"C:\\Users\\lenovo_T510\\Documents\\NetBeansProjects\\wniosk\\src\\wniosk\\dane.txt");
            Scanner input = new Scanner (this.file);
            while(input.hasNextLine()){
                String napis = input.next();
                input.next();
                char litera = input.next().charAt(0);
                //System.out.println(napis+" "+ litera);
                int stan;
                if(litera=='T')
                    stan=1;
                else
                    stan=0;
                
                if(!tablica.containsKey(napis))
                tablica.put(napis,stan);
                else
                   System.out.println("ISTNIEJE");
            }
            input.close();
        } catch (FileNotFoundException e){ }
        
       for (String key : tablica.keySet()) {
            System.out.println(key + " " + tablica.get(key));
        }
    }
   

}
 

 
