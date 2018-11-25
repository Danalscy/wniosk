/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wniosk;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Dan
 */
public class Editor extends JFrame{   

    public Editor(String sciezka){
        fileRead(sciezka);
        panels(sciezka);         
    }

    private String storeAllString="";
    private JButton saveCloseBtn = new JButton("Zapisz i Wyjdz");
    private JButton closeButton = new JButton("Wyjdz bez zapisywania");
    private JFrame frame=new JFrame("Edytor Tekstowy");
    private JTextArea textArea = new JTextArea();


    private JButton getCloseButton(){
        return closeButton;
     }     

    private void fileRead(String sciezka){
        try{    
          FileReader read = new FileReader(sciezka);
          Scanner scan = new Scanner(read);
             while(scan.hasNextLine()){
              String temp=scan.nextLine()+"\n";
              storeAllString=storeAllString+temp;
             }
             textArea.setText(storeAllString);
      }
        catch (Exception exception)
         {
         exception.printStackTrace();
         }
    }      



    private void panels(final String sciezka){        
         JPanel panel = new JPanel(new GridLayout(1,1));
         panel.setBorder(new EmptyBorder(5, 5, 5, 5));
         JPanel rightPanel = new JPanel(new GridLayout(15,0,10,10));
         rightPanel.setBorder(new EmptyBorder(15, 5, 5, 10));
        // JTextArea textArea = new JTextArea(storeAllString,0,70);
          JScrollPane scrollBarForTextArea=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          panel.add(scrollBarForTextArea); 
          frame.add(panel);
         frame.getContentPane().add(rightPanel,BorderLayout.EAST);
         rightPanel.add(saveCloseBtn);
          rightPanel.add(closeButton);
          closeButton.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e)
                    {
                        frame.dispose();

                    }
        });
          saveCloseBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                saveBtn(sciezka);
                frame.dispose();

            }
        });
           frame.setSize(1000, 700);
           frame.setVisible(true);   
           frame.setLocationRelativeTo(null);

}

    private void saveBtn(String sciezka){
        File file = null;
        FileWriter out=null;


        try {
            file = new File(sciezka);
            out = new FileWriter(file);     
            String text=textArea.getText();
            text = text.replaceAll("(?!\\r)\\n", "\r\n");
            out.write(text);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
}
    

