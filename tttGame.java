package TTT;      // creating the package called TTT
import java.awt.Color;                    //importing the color class to get color for the given window
import java.awt.GridLayout;               // importing gridlayout from the java.awt package to get the layout for the game
import java.awt.event.ActionEvent;        //
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.*;                        //importing all the classes of java.awt package
import java.awt.event.*;                  //importing all the classes from the java.awt.event package

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class tttGame extends JPanel{
  char playerMark = 'x';
  JButton[] b = new JButton[9];
  public tttGame(){
    setLayout(new GridLayout(3,3));
    initializerButtons();
  }
  public void initializerButtons(){
    for(int i=0;i<9;i++){
      b[i]=new JButton();
      b[i]=setText("-");
      b[i]=setBAckground(Color.white);
      b[i].addActionListener(new ActionListener(){
        JButton buttonClicked=(JButton)e.getSource();
        buttonClicked.setText(String.valueOf(playerMark));
        
        if(playerMarks=='x'){
          playerMark='o';
          buttonClicked.setBackground(Color.CYAN);
        }
        else{
          playerMark='x';
          buttonClicked.setBackground(Color.PINK);
        }
        
