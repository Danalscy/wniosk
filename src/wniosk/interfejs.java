/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wniosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Dan
 */
public class interfejs {
    String sciezka_dane;
    String sciezka_wzory;
    dane fakty;
    wzory rownania;
    HashMap<String, ArrayList<String>> drzewo =  new HashMap<String, ArrayList<String>>();
    public int przod(String szukana){
        if(fakty.tablica.containsKey(szukana)){
           System.out.println("Znaleziono "+ szukana +" o wartości " + fakty.tablica.get(szukana)+ "(było podane w danych)");
           return 1;
        }
       for(String test : rownania.tablica){
        String[]parts=test.split("[=>]");
        String nowe = parts[0];
        String napis=parts[parts.length-1];
        napis=napis.replaceAll("\\s+","");
        for (String key : fakty.tablica.keySet()) {
            if(test.contains(key)){
                //System.out.println(key);
                nowe=nowe.replace((String)key,Integer.toString(fakty.tablica.get(key)));
            }
        }
        nowe=nowe.replace("&&","&");
        nowe=nowe.replace("||","|");
        System.out.println(test);
        System.out.println(nowe);
        converter convert = new converter();
        String ONP=convert.convert(nowe);
        System.out.println(ONP);
        int wartosc=convert.wnioskuj(ONP);
        
        System.out.println(napis+" = "+wartosc);
        System.out.println();
        if(wartosc==1){
            if(napis.charAt(0)=='!'){
                String tmp=napis.substring(1);
                fakty.tablica.put(tmp,0);
                //System.out.println(napis);
                if(tmp.equals(szukana)){
                    System.out.println("Znaleziono "+ tmp +" o wartosci 0");
                    return 1;
                }
            }
            else{
                fakty.tablica.put(napis,1);
                if(napis.equals(szukana)){
                    System.out.println("Znaleziono "+ szukana +" o wartosci 1");
                    return 1;
                }
            }
        }
       
      }
       System.out.println("Nie znaleziono "+ szukana );
        return 1;
    } 
    
     public int tyl(String szukana,Stack stos){
        if(fakty.tablica.containsKey(szukana)){
           System.out.println("Znaleziono "+ szukana +" o wartości " + fakty.tablica.get(szukana)+ "(było podane w danych)");
           return 1;
        }
        int indexy[]=new int[rownania.tablica.size()];
        int czyjest=0,czyznowu=1;
        int k=0;
       for(String test : rownania.tablica){
        String[]parts=test.split("[=>]");
        String nowe = parts[0];
        String napis=parts[parts.length-1];
        napis=napis.replaceAll("\\s+","");
         if(napis.charAt(0)=='!') napis=napis.substring(1);
        if(napis.equals(szukana)){
            indexy[k]=1;
            czyjest=1;
        }
        //System.out.println(test);
      //  String[]przeslanki=nowe.split("[ !()|&]+");
        //System.out.println(Arrays.toString(przeslanki)+ " " +napis +"\n");      
       k++;
      }
       if (czyjest==0){
            System.out.println(szukana+ " nie istnieje jako wynik funkcji\n\n");
		System.exit(0);
       }
       String temp;
       for(int i=0;i<rownania.tablica.size();i++){
           if(indexy[i]==1){
                temp=rownania.tablica.get(i);
                String[]parts=temp.split("[=>]");
                String nowe = parts[0];
                String napis=parts[parts.length-1];
                napis=napis.replaceAll("\\s+","");
                if(napis.charAt(0)=='!') napis=napis.substring(1);
                String[]przeslanki=nowe.replaceFirst("^"+"[ !()|&]+","").split("[ !()|&]+");
                System.out.println(temp+"\n");
                System.out.println(Arrays.toString(przeslanki));
                 ArrayList<String> arraylist = new ArrayList<String>();
                for(String x : przeslanki){
                stos.push(x);
                arraylist.add(x);
                }
                drzewo.put(napis, arraylist);
         
      // System.out.println(Arrays.toString(stos.toArray()));
       for (String key : fakty.tablica.keySet()) {
            if(nowe.contains(key)){
                //System.out.println(key);
                nowe=nowe.replace((String)key,Integer.toString(fakty.tablica.get(key)));
            }
        }
        nowe=nowe.replace("&&","&");
        nowe=nowe.replace("||","|");
       converter convert = new converter();
        String ONP=convert.convert(nowe);
        System.out.println(ONP);
        if(ONP!=""){
        int wartosc=convert.wnioskuj(ONP);
         String lololol=parts[parts.length-1];
         lololol=lololol.replaceAll("\\s+","");
        if(wartosc==1){
             
            if(lololol.charAt(0)=='!'){
                String tmp=lololol.substring(1);
                fakty.tablica.put(tmp,0);
               // System.out.println(napis);
                if(tmp.equals(szukana)){
                    System.out.println("Znaleziono "+ tmp +" o wartosci 0");
                    return 1;
                }
            }
            else{
                fakty.tablica.put(napis,1);
                if(napis.equals(szukana)){
                    System.out.println("Znaleziono "+ szukana +" o wartosci 1");
                    return 1;
                }
            }
        }
        }
		while(!stos.empty()){
			//printf("%d: %s\n",i,topst(queue));		
			if(tyl((String)stos.pop(),stos)==0){
				czyznowu=0;
				}
		//	pomoc[i]=NULL;
		}
		//printf("Dupa\n\n");
		//k=0;
		}
		
	}	
	if(czyznowu==1){
		return 1;
	}  
       return 0;
     }
     }
