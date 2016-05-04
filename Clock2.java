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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//Creating a class for clock type2 by extending it to Clock abstract class.
public class Clock2 extends Clock{
    private final JComboBox<String> minsBox;
    private final JComboBox<String> hrsBox;
    private final JLabel labelMins;
    private final JLabel labelHrs;
    private final String[] minsList, hrsList;
    protected static int clock2Count=0;  //Current count of the clocks created.
    public Clock2(String clockName){
        super(clockName);
        clock2Count++;
        minsList=new String[60];        //String with valid values for the minutes and hours.
        hrsList=new String[24];
        for(int i=0;i<60;i++){
            if(i<24) hrsList[i]=String.valueOf(i);  //Insert the minutes and hours in the array.
            minsList[i]=String.valueOf(i);
        }
        minsBox= new JComboBox<>(minsList);     //Create a drop down with the array of minutes and hours.
        hrsBox=new JComboBox<>(hrsList);
        labelMins=new JLabel("Minutes: ");
        labelHrs=new JLabel("Hours: ");
        minsBox.setMaximumRowCount(6);      //Set the row count for the drop down list.
        hrsBox.setMaximumRowCount(6);
        //Add the components.
        super.add(labelHrs); super.add(hrsBox);
        super.add(colon);
        super.add(labelMins); super.add(minsBox);
        super.add(timeLabel); super.add(alarmTime);
        super.add(setAlarm); super.add(resetAlarm);
        super.add(status); super.add(statusInfo);
        //Build the frame.
        super.buildFrame(350,100);
        Container c = super.getContentPane();
        c.setBackground(Color.YELLOW);
        ///////////////////////////////
        Clock2ComboBoxStatus handler=new Clock2ComboBoxStatus();        //Creat the objects for the handling events.
        ClockAlarm handler1=new ClockAlarm();
        hrsBox.addItemListener(handler);            //Add the components to listeners.
        minsBox.addItemListener(handler);
        setAlarm.addActionListener(handler1);
        resetAlarm.addActionListener(handler1);
        WindowActions winHandler=new WindowActions();
        super.addWindowListener(winHandler);
    }
    //To catch the event from the drop down buttons.
    private class Clock2ComboBoxStatus implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event){
            if(event.getSource()==minsBox)
                if(event.getStateChange()==ItemEvent.SELECTED)
                   minutes=minsList[minsBox.getSelectedIndex()];    //Set the flag if minutes radio button is selected.
            if(event.getSource()==hrsBox)
                if(event.getStateChange()==ItemEvent.SELECTED)
                    hours=hrsList[hrsBox.getSelectedIndex()];       //Set the flag for the hours, if selected
        }
    }
    //To catch events from the button.
    private class ClockAlarm implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==setAlarm){
                if((hours==null) || (hours.equals(""))) hours="00"; 
                if((minutes==null) || (minutes.equals(""))) minutes= " 00";
                    set();            //If the value is valid, set the time.
            }
            else if(event.getSource()==resetAlarm){   //If the user clicks on Reset, call the reset method.
                reset();
            }
        }
    }
    private class WindowActions extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            clock2Count--;          //If a clock is closed, decrement the clock count.
        }

        @Override
        public void windowClosed(WindowEvent e) {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  //Hide the frame, when closed.
        }
    }
}
//////////////////////// END OF SOURCE FILE ////////////////////////////