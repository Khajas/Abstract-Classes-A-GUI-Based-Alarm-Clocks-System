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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
//Creating a class for clock type 3 by extending it to Clock abstract class.
public class Clock3 extends Clock{
    protected final JRadioButton checkMins;
    protected final JRadioButton checkHrs;
    protected final ButtonGroup radioButton;
    protected final JButton increment;
    protected static int clock3Count=0;  //Current count of the clocks created.
    protected JLabel txtMins;
    protected JLabel txtHrs;
    protected boolean minsFlag;
    protected boolean hoursFlag;
    public Clock3(String clockName){    //Constructor for the clock 4
        super(clockName);
        clock3Count++;
        txtHrs=new JLabel("10");
        txtMins= new JLabel("09");
        checkMins=new JRadioButton("Minutes");
        checkHrs=new JRadioButton("Hours");
        radioButton=new ButtonGroup();
        radioButton.add(checkHrs);
        radioButton.add(checkMins);
        increment= new JButton("+");
        //Add components.
        super.add(txtHrs); super.add(colon); super.add(txtMins);
        super.add(checkHrs); super.add(checkMins);
        super.add(increment);
        super.add(timeLabel); super.add(alarmTime); super.alarmTime.setSize(10,5);
        super.add(setAlarm); super.add(resetAlarm); 
        super.add(status); super.add(statusInfo);
        super.buildFrame(300,150);
        Container c = super.getContentPane();
        c.setBackground(Color.GREEN);
        //Define the action Listener for radio buttons.
        Clock3RadioButonStatus handler= new Clock3RadioButonStatus();
        // Events to be captured.
        checkMins.addItemListener(handler); checkHrs.addItemListener(handler);
        // To Catch the events of buttons.
        ClockAlarm handler2=new ClockAlarm();
        increment.addActionListener(handler2);setAlarm.addActionListener(handler2); resetAlarm.addActionListener(handler2);
        
        WindowActions winHandler=new WindowActions();
        super.addWindowListener(winHandler);
    }
    private class Clock3RadioButonStatus implements ItemListener{ //To catch the events from radion buttons.
        @Override
        public void itemStateChanged(ItemEvent event){
            minsFlag = checkMins.isSelected();
            hoursFlag = checkHrs.isSelected();
        }
    }
    private class ClockAlarm implements ActionListener{  //To catch the event from the normal buttons.
        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==increment){   //If increment is presssed, call to routine to increment the values.
                this.incValues();
            }
            if(event.getSource()==setAlarm){
                minutes=txtMins.getText();
                hours=txtHrs.getText();
                set();           //If the value is valid, set the time.
            }
            if(event.getSource()==resetAlarm){    //If the user clicks on Reset, call the reset method.
                reset();
            }
        }
        //Sub routine to increment the values.
        protected void incValues(){
           int minsInt = 0, hoursInt = 0;
           minutes=txtMins.getText();
           hours=txtHrs.getText();
           try{
               minsInt=Integer.parseInt(minutes);
               if(minsFlag) minsInt+=1; minsInt%=(MAX_MINS+1);
               hoursInt=Integer.parseInt(hours);
               if(hoursFlag) hoursInt+=1; hoursInt%=(MAX_HRS+1);
           }
           catch(Exception e){      //This will never be executed.
               statusInfo.setText("Invalid Selection");
           }
           minutes=String.valueOf(minsInt);
           txtMins.setText(minutes);
           hours=String.valueOf(hoursInt);
           txtHrs.setText(hours);
        }
    }
    // To handle window actions.
    private class WindowActions extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            clock3Count--;          //If a clock is closed, decrement the clock count.
        }
        @Override
        public void windowClosed(WindowEvent e) {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  //Hide the frame, when closed.
        }
    }    
}
//////////////////////// END OF SOURCE FILE ////////////////////////////