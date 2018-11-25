/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wniosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Dan
 */
public class Wniosk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        interfejs interfejs = new interfejs();
        interfejs.fakty = new dane("C:\\Users\\lenovo_T510\\Documents\\NetBeansProjects\\wniosk\\src\\wniosk\\dane.txt");
        System.out.println("\nwczytano dane\n");
        interfejs.rownania = new wzory("C:\\Users\\lenovo_T510\\Documents\\NetBeansProjects\\wniosk\\src\\wniosk\\wzory.txt");
        System.out.println("\nwczytano wzory\n");
        Stack st= new Stack();
       //interfejs.przod("podZlOdLd");
       //interfejs.tyl("mozKoln",st);
       interfejs.tyl("mosUnrch",st);
       interfejs.tyl("mosUnrch",st);
      // System.out.println("dupa" +asd);
      if(interfejs.fakty.tablica.containsKey("mosUnrch")){  
       /* for (String key : interfejs.fakty.tablica.keySet()) {
            System.out.println(key + " " + interfejs.fakty.tablica.get(key));
        }*/
       int i=0;
       ArrayList<String> czybylo=new ArrayList<String>();   
       System.out.println("digraph g{\n" +
"node [shape = record,height=.1];");
       for (String key : interfejs.drzewo.keySet()) {
            ArrayList<String> przeslanki=interfejs.drzewo.get(key);
            System.out.println(key +"[label = \"<0> 0| <f1> "+key+"|<1>1 \"];");
            czybylo.add(key);
            //System.out.println(key+ " "+ przeslanki);
            //i++;
            for(String napis: przeslanki){
                if(!czybylo.contains(napis)){
                System.out.println(napis+"[label = \"<0> 0| <f1> "+napis+"|<1>1 \"];");
               // i++;
                czybylo.add(napis);
            }
               System.out.println("\""+key+"\":"+interfejs.fakty.tablica.get(key)+" -> \""+ napis+"\":"+interfejs.fakty.tablica.get(napis)+";");
            }
      
       }
    System.out.println("}");
    }
       else
          System.out.println("Nie znaleziono"); 
    }
}
