/* ******************************************************************
Class:     CSCI 470-1
Program:   Assignment 4
Author:    Khaja Anwar Ali, Siddiqui
Z-number:  z1778291
Date Due:  04/28/16

Purpose:   Inheritance, polymorphism and interfaces.

Execution: java hw4-sidd

           java hw4

*********************************************************************/
//Package name.
package hw04.sidd;
// Required imports:
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
//Creating a class for clock type 4 by extending it to Clock abstract class.
public class Clock4 extends Clock3{
    private final JButton decrement;    //Additional button for the decrement operation.
    protected static int clock4Count=0;  //Current count of the clocks created.
    public Clock4(String clockName){    //Constructor for the clock4
        super(clockName);           //Since the constructor for the clock 3 is called, so decrement the clock3 count.
        clock3Count--;
        clock4Count++;      
        decrement=new JButton("-");
        //Build up the layout for the clock 4
        super.add(txtHrs); super.txtHrs.setSize(15, 5); 
        super.add(colon); 
        super.add(txtMins); txtMins.setSize(10, 5);
        super.add(checkHrs); super.add(checkMins);
        super.add(increment); super.add(decrement);
        super.add(timeLabel); super.add(alarmTime);
        super.add(setAlarm); super.add(resetAlarm); 
        super.add(status); super.add(statusInfo);
        super.buildFrame(300,150);
        Container c = super.getContentPane();
        c.setBackground(Color.ORANGE);
        Clock4Action handler2=new Clock4Action();
        decrement.addActionListener(handler2);
        
        WindowActions winHandler=new WindowActions();
        super.addWindowListener(winHandler);
    }
    private class Clock4Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==decrement) this.decValues();    //If decrement is presssed, call to routine to decrement the values.
        }
        //Sub routine to decrement the values.
        public void decValues(){
           int minsInt = 0, hoursInt = 0;
           minutes=txtMins.getText();
           hours=txtHrs.getText();
           try{
               minsInt=Integer.parseInt(minutes);
               if(minsFlag) minsInt+=-1; 
               if(minsInt==MAX_MINS) minsInt%=(MAX_MINS+1);
               if(minsInt==-1) minsInt=59;
               hoursInt=Integer.parseInt(hours);
               if(hoursFlag) hoursInt+=-1; 
               if(hoursInt==MAX_HRS) hoursInt%=(MAX_HRS+1);
               if(hoursInt==-1) hoursInt=23;
           }
           catch(Exception e){
               statusInfo.setText("Invalid Selection");
           }
           minutes=String.valueOf(minsInt);
           txtMins.setText(minutes);
           hours=String.valueOf(hoursInt);
           txtHrs.setText(hours);
        }
    }
    private class WindowActions extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            clock4Count--;          //If a clock is closed, decrement the clock count.
            clock3Count++;
        }
        @Override
        public void windowClosed(WindowEvent e) {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //Hide the frame, when closed.
        }
    }    
}
//////////////////////// END OF SOURCE FILE ////////////////////////////