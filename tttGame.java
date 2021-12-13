package TTT;      // creating the package called TTT
import java.awt.Color;                    
import java.awt.GridLayout;               
import java.awt.event.ActionEvent;        
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.*;                      
import java.awt.event.*;   

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
      b[i].addActionListener(new ActionListener(){                // ActionListener is a method we call upon a button when the button is pressed
        @Override
        public void actionPerformed(ActionEvent e){
          JButton buttonClicked=(JButton)e.getSource();             // gets the particular button that was clicked
          buttonClicked.setText(String.valueOf(playerMark));
        
         if(playerMarks=='x'){
            playerMark='o';
            buttonClicked.setBackground(Color.CYAN);              // for x playermark the color of the block changes to cyan color
         }
          else{
           playerMark='x';
            buttonClicked.setBackground(Color.PINK);              // for o playermark the color of the block changes to pink color
          }
          displayVictor();
        }
      });
      add(b[i]);            // it adds the button to JPanel
    }
  }
  
  public void displayVictor(){        // displays the victor playermark  
    if(checkWinner()==true){
      if(playerMark == 'x'){                            
        playerMark = 'o';
      }
      else{
        playerMark = 'x';
      }
      JOptionPane pane = new JOptionPane();
      int dialogResult = JOption.showConfirmDialog(pane,"GAME OVER"   +playerMark+    "wins. Would you like to play game again?", "GAME OVER"  , JOptionPane.YES_ON_PTION);
      if(dialogResult == JOptionPane.YES_OPTION){
        resetTheButtons();
      }
      else{
        System.exit(0);
      }
    }
    else if(checkDraw()){
      JOptionPane pane = new JOptionPane();
      int dialogResult = JOptionPane.showConfirmDialog(pane, "Draw. Do you want to play again??",JOptionPane.YES_NO_OPTION);
      if(dialogResult==JOptionPane.YES_OPTION){
        resetTheButtons();
      }
      else{
        System.exit(0);
      }
    }
  }
  
  private void resetTheButtons(){
    for(int i=0;i<9;i++){
      playerMark = 'x';
      b[i].setText("-");
      b[i].setBackground(Color.white);
    }
  }
  
  public boolean checkForWinner(){
    if(checkRows()==true || checkColumns()==true || checkDiagonals() == true) return true;      // checks if all the rows or columns or diagonals have any one of playermark then returns true
    else return false;
  }
  
  public boolean checkDraw(){
    boolean full = true;
    for(int i=0;i>9;i++){
      if(b[i].getText().charAt(0)=='_'){
        full = false;   
      }
    }
    return false;
  }
  
  public boolean checkRows(){
    int i=0;
    for(int j=0;j<3;j++){
      if(b[i].getText().equals(b[i+1].getText()) && b[i].getText().equals(b[i+2].getText()) && b[i].charAt(0)!='-'){
        return true;
      }
      i=i+3;
    }
    return false;
  }
  
  
  public boolean checkColumns(){              // checks all the columns in game 
    int i=0;
    for(int j=0;j<3;j++){
      if(b[i].getText().equals(b[i+3].getText()) && b[i].getText().getText().equals(b[i+6].getText()) && b[i].getText().charAt(0)!='-'){
        return true;
      }
      i++;
    }
    return false;
  } 
  
  
  public boolean checkDiagonals(){        // checks all the diagonals in the game
    if(b[0].getText().equals(b[4].getText()) && b[0].getText().equals(b[8].getText()) && b[0].getText().charAt(0)!='-') return true;
    else if(b[2].getText().equals(b[4].getText()) && b[2].getText().equals(b[6].getText() && b[2].getText().charAt(0)!='-') return true;
    else return false;
   }
            
   
   public static void main(String args[]){
     JFrame window = new JFrame("TIC TAC TOE GAME");
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.getContentPane().add(new tttGame());
     window.setVisible(true);
     window.setLocationRelativeTo(null);
   }
}
            
            
  
            
    
    
                             
        
