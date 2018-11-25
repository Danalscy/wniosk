/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wniosk;

import java.util.Stack;

/**
 *
 * @author Dan
 */
public class converter {
     public int wnioskuj(String output){
         if(output==""){
             return -1;
         }
        Stack st = new Stack();
        for(int i =0;i<output.length();i++)  {
	char c = output.charAt(i);
        int x,y,z;
	System.out.println(st);
	if(c=='0' || c=='1')  {
                st.push((int)c-48);
        }
       else System.out.println(c);
	if(c=='!'){
		x=((int)st.pop()) ^1;
		st.push((int)x);
	}
	if(c=='&'){
		x=(int)st.pop();
		y=(int)st.pop();
                z=x & y;
		st.push(z);
	}
	if(c=='|'){
		x=(int)st.pop();
		y=(int)st.pop();
                z=x | y;
		st.push(z);
	}
	
    }
        return (int)st.pop();
    }
    
    public boolean is_operator(char c){
        if (c == '!' || c == '&' || c == '|')
            return true;
        else
            return false;
    }
    
    int priority(char c){
        switch(c)    {
            case '|':
            return 1;
            case '&':
            return 2;
            case '!':
            return 3;
        }
    return 0;
    }
    
    public String convert(String output){
	Stack stos= new Stack();
        String zdanie="";	
	char temp;
         for(int i =0;i<output.length();i++)  {
             char c = output.charAt(i);
             if (c != ' '){
                 if(c == '0' || c == '1'){
                     zdanie+=c;
                }
             else if (is_operator(c)){
                 while(!stos.empty()){
                     temp=(char)stos.peek();
                     if(is_operator(temp) && (priority(c)<priority(temp))){
                         char tmp=(char)stos.pop();
                         zdanie+=tmp;
                     }
                     else{
                         break;
                     }
                 }
                 stos.push((char)c);
             }
             else if (c=='('){
                 stos.push(c);
             }
             else if (c==')'){
                 boolean closed = false;
                 while(!stos.empty()){
                     temp=(char)stos.peek();
                     if(temp=='('){
                         closed=true;
                         break;
                     }
                     else{
                         char tmp=(char)stos.pop();
                         zdanie+=tmp;
                     }
                 }
                  if(!closed)  {
                    System.out.println("Error: NAWIASY");
                    return "";
                }
                  stos.pop();   
             }
              else  {
                System.out.println("Error: ZLE ZNAKI" + c);
                return ""; 
            }
        }        
       }
          while(!stos.empty() )  {
        temp = (char)stos.peek();
        if(temp == '(' || temp == ')')   {
            System.out.println("Error: NAWIASY");
            return "";
        }
	char tmp=(char)stos.pop();
        zdanie+=tmp;
        }
         return zdanie;
    }
}
