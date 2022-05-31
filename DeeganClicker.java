// H
// 5/24/22
// It's NOT cookie clicker, It's Deegan Clicker.


// Java imports
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;  
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.BufferedReader;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class DeeganClicker{ 
    
   // Variable necessary for the core aspects of the game.
   static int count = 0;
   static int multiplier = 1;
   static int prestigeMultiplier = 1;
   static int price1 = 5;
   static int price2 = 5000;
   static int price3 = 500000;
   static boolean clicker = false;
   static String IDNumber = "";
   
   public static void main(String[] args){
   
   
   
      // Creates new frame for user ID number.
      JFrame IDFrame = new JFrame();
      IDFrame.setTitle("ID Number");
      
      IDFrame.setLocation(200, 200);
      IDFrame.setSize(new Dimension(300, 200));
      IDFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JTextArea IDInputArea = new JTextArea("Input your ID Number here, delete this text.");
      JButton startBTN = new JButton("Start Game");
      IDFrame.add(startBTN);
      IDFrame.add(IDInputArea);
   
      // Frame creation
      JFrame myFrame = new JFrame();
      myFrame.setTitle("Deegan Clicker");
      
      myFrame.setLocation(200, 200);
      myFrame.setSize(new Dimension(300, 200));
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JFrame myFrame2 = new JFrame();
      myFrame2.setTitle("Upgrades");
      
      myFrame2.setLocation(400, 400);
      myFrame2.setSize(new Dimension(350, 200));
      myFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JFrame myFrame3 = new JFrame();
      myFrame3.setTitle("Deeganless :(");
      
      myFrame3.setLocation(450, 10);
      myFrame3.setSize(new Dimension(350, 650));
      myFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
      //Frame layout      
      IDFrame.setLayout(new BoxLayout(IDFrame.getContentPane(), BoxLayout.Y_AXIS));
      myFrame.setLayout(new BoxLayout(myFrame.getContentPane(), BoxLayout.Y_AXIS));
      myFrame2.setLayout(new BoxLayout(myFrame2.getContentPane(), BoxLayout.Y_AXIS));
      myFrame3.setLayout(new BoxLayout(myFrame3.getContentPane(), BoxLayout.Y_AXIS));
      
      //Buttons 
      JButton deeganClicker = new JButton("The Deegan");
      JButton upgradeBTN = new JButton("Upgrades  ");
      JButton upgradesExitBTN = new JButton("Exit");
      JButton dblDeegansBTN = new JButton("Double Deegans (-" + price1 + ")");
      JButton autoClickerBTN = new JButton("Auto Clicker (-" + price2 + ")");
      JButton gameCompleteBTN = new JButton("Sell all your Deegans and win the game! (-" + price3 + ")");
      JButton restartBTN = new JButton("Prestige");       
            
      myFrame.add(deeganClicker);
      myFrame.add(upgradeBTN);
      myFrame2.add(upgradesExitBTN);
      myFrame2.add(dblDeegansBTN);
      myFrame2.add(autoClickerBTN);
      myFrame2.add(gameCompleteBTN);
      myFrame3.add(restartBTN);
      
      // Panels and labels
      JPanel myPanel = new JPanel();
      myPanel.setLayout(new GridLayout(1,2));
      
      JPanel myPanel2 = new JPanel();
      myPanel2.setLayout(new GridLayout(1,2));
      
      JLabel myLabel = new JLabel("Deegans: " + count);
      myPanel.add(myLabel);
      
      JLabel myLabel2 = new JLabel("Wow! You have 0 deegans!");
      myPanel2.add(myLabel2);
      
      
         
      
      
      
      // Action listeners
      
      startBTN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            IDNumber = IDInputArea.getText();
            System.out.println(IDNumber);
            
            
            
         // Creates file for keeping track of users score.
      try {
         File scoreKeeper = new File("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\scoreKeeper.txt");
         if (scoreKeeper.createNewFile()) {
            System.out.println("File created: " + scoreKeeper.getName());
         } else {
            System.out.println("File already exists. scoreKeeper");
         }
      } catch (IOException a) {
         System.out.println("An error occurred. scoreKeeper");
         a.printStackTrace();
         System.exit(0);
      }
      
      // Creates file for keeping track of multiplier
      try {
         File multiplierKeeper = new File("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\multiplierKeeper.txt");
         if (multiplierKeeper.createNewFile()) {
            System.out.println("File created: " + multiplierKeeper.getName());
         } else {
            System.out.println("File already exists. multiplierKeeper");
         }
      } catch (IOException d) {
         System.out.println("An error occurred. Multiplier");
         d.printStackTrace();
         System.exit(0);
      }
      
      // Creates file for keeping track of multiplier
      try {
         File pmultiplierKeeper = new File("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\pmultiplierKeeper.txt");
         if (pmultiplierKeeper.createNewFile()) {
            System.out.println("File created: " + pmultiplierKeeper.getName());
         } else {
            System.out.println("File already exists. pmultiplierKeeper");
         }
      } catch (IOException aa) {
         System.out.println("An error occurred. pMultiplier");
         aa.printStackTrace();
         System.exit(0);
      }
               IDFrame.setVisible(false);
               myFrame.setVisible(true);
               
               
         try { 
            BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\" + IDNumber + "\\Desktop\\deegan_50_2_70.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            myPanel2.add(picLabel); 
         } 
         catch (IOException b) { 
            b.printStackTrace();
         }
         
         
         
         try {
      File myObj = new File("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\scoreKeeper.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        //System.out.println(data);
        count = Integer.parseInt(data);  
      }
      myReader.close();
    } catch (FileNotFoundException c) {
      System.out.println("Hey this is their first playthrough!.");
      c.printStackTrace();
    }
    
    try {
      File theObj = new File("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\multiplierKeeper.txt");
      Scanner myReader = new Scanner(theObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        //System.out.println(data);
        multiplier = Integer.parseInt(data);  
      }
      myReader.close();
    } catch (FileNotFoundException h) {
      System.out.println("Hey this is their first playthrough!.");
      h.printStackTrace();
    }
    
    try {
      File ourObj = new File("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\pmultiplierKeeper.txt");
      Scanner myReader = new Scanner(ourObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        //System.out.println(data);
        prestigeMultiplier = Integer.parseInt(data);  
      }
      myReader.close();
    } catch (FileNotFoundException z) {
      System.out.println("Hey this is their first playthrough!.");
      z.printStackTrace();
    }
         
            }
            
      }); 
      
      
      restartBTN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
               clicker = false;
               prestigeMultiplier = prestigeMultiplier + 1;
               multiplier = prestigeMultiplier;
               price1 = 5;
               price2 = 5000;
               price3 = price3 * 3;
               
               // Reset Count
               try {
                  FileWriter myWriter = new FileWriter("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\scoreKeeper.txt");
                  myWriter.write("" + 0);
                  myWriter.close();
                  //System.out.println("Successfully wrote to the file. Prestiged.");
               } 
               catch (IOException f) {
                  System.out.println("An error occurred. Prestiged.");
                  f.printStackTrace();
                  System.exit(0);
               }
               
                try {
                  FileWriter myWriter = new FileWriter("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\multiplierKeeper.txt");
                  myWriter.write("" + 1);
                  myWriter.close();
                  //System.out.println("Successfully wrote to the file. Prestiged.");
               } 
               catch (IOException y) {
                  System.out.println("An error occurred. Prestiged.");
                  y.printStackTrace();
                  System.exit(0);
               }
               
               myFrame3.setVisible(false);
               myFrame.setVisible(true);
            }
      });
      
      //Open upgrade pane
      upgradeBTN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
               myFrame2.setVisible(true);
               dblDeegansBTN.setText("Double Deegans (-" + price1 + ")");
               gameCompleteBTN.setText("Sell all your Deegans and win the game! (-" + price3 + ")");
               if (clicker == false) {
                  autoClickerBTN.setText("Auto Clicker (-" + price2 + ")");
               }
               myFrame.setVisible(false);
            }
      }); 
      
      // Complete game, allow for prestige.
      gameCompleteBTN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
               if (count >= price3) {
                  count = count - count;            //Comment this out for testing purposes &/Or easy wins
                  myFrame2.setVisible(false);
                  myFrame3.setVisible(true);
                  AudioPlayerExample1 audioPlayer = new AudioPlayerExample1();
                  audioPlayer.playAudioFile("C:/Users/" + IDNumber + "/downloads/Video.wav");
               }
               else if (price3 >= 1093500000) {
                  myFrame2.setVisible(false);
                  myFrame3.setVisible(true);
                  restartBTN.setVisible(false);
               }
               else {
                  gameCompleteBTN.setText("Not enough Deegans!");
                  return;
               }
            }
      }); 
      
      // Double the amount of deegans generated by clicks and the auto clicker.
      dblDeegansBTN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
         if (count >= price1) {
               count = count - price1;
               multiplier = multiplier * 2;
               price1 = price1 * 7;
               dblDeegansBTN.setText("Double Deegans (-" + price1 + ")");
               myFrame2.setVisible(false);
               myFrame.setVisible(true);
            }
         else {
         dblDeegansBTN.setText("Not enough Deegans!");
            return;
         }
        }
      }); 
      
      // Purchase auto clicker
      autoClickerBTN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
         if (count >= price2 && clicker == false) {
               count = count - price2;
               clicker = true;
               autoClickerBTN.setText("Auto Clicker Purchased");
               myFrame2.setVisible(false);
               myFrame.setVisible(true);
            }
         else if (count < price2 && clicker == false) {
         autoClickerBTN.setText("Not enough Deegans!");
            return;
         }
         else if (count < price2 && clicker == true) {
         autoClickerBTN.setText("Already Purchased!");
            return;
         }
        }
      }); 
      
      //Leave upgrades page without closing game
      upgradesExitBTN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
               dblDeegansBTN.setText("Double Deegans (-" + price1 + ")");
               myFrame2.setVisible(false);
               myFrame.setVisible(true);
            }
      });
      
      //The "cookie" (deegan)
      deeganClicker.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
               count = count + multiplier;
               // AutoClicker Code
               if (clicker == true) {
                  long startTime = System.nanoTime();
                  long endTime   = System.nanoTime();
                  long totalTime = (endTime - startTime)/100;
                  int timeInt = (int)totalTime;
                  count = count + (timeInt * multiplier);     
                  timeInt = 0;
               } 
               myLabel.setText("Deegans: " + count);
               
               // Write Deegan Count
               try {
                  FileWriter myWriter = new FileWriter("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\scoreKeeper.txt");
                  myWriter.write("" + count);
                  myWriter.close();
                  //System.out.println("Successfully wrote to the file. Deegan");
               } 
               catch (IOException f) {
                  System.out.println("An error occurred. Deegan");
                  f.printStackTrace();
                  System.exit(0);
               }
               
               // Write multiplier count
               try {
                  FileWriter myWriter = new FileWriter("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\multiplierKeeper.txt");
                  myWriter.write("" + multiplier);
                  myWriter.close();
                  //System.out.println("Successfully wrote to the file. Multiplier deegan");
               } 
               catch (IOException g) {
                  System.out.println("An error occurred. Deegan Multiplier");
                  g.printStackTrace();
                  System.exit(0);
               }
               
               try {
                  FileWriter myWriter = new FileWriter("C:\\Users\\" + IDNumber + "\\Documents\\DeeganClickerLibs\\pmultiplierKeeper.txt");
                  myWriter.write("" + prestigeMultiplier);
                  myWriter.close();
                  //System.out.println("Successfully wrote to the file. Multiplier deegan");
               } 
               catch (IOException x) {
                  System.out.println("An error occurred. Deegan prestige Multiplier");
                  x.printStackTrace();
                  System.exit(0);
               }
            }
      });
     
      
      // Start game
      myFrame.add(myPanel);
      myFrame3.add(myPanel2);
      IDFrame.setVisible(true);
      
   }

}
