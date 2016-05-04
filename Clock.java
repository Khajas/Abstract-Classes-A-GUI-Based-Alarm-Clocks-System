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
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// Abstract class for clock, contains common variables/GUI containers to all the clocks.
public abstract class Clock extends JFrame{
    protected final int MAX_MINS=59;    //Max values for minutes and hours.
    protected final int MAX_HRS=23;
    protected final JLabel colon;
    protected final JButton setAlarm;       //Buttons for setting and resetting the alarms.
    protected final JButton resetAlarm;
    protected final JLabel status;          //To show the label status.
    protected final JLabel statusInfo;      //Info of the label.
    protected final JLabel timeLabel;       //To display lable Time.
    protected final JLabel alarmTime;       //To store the time of the alarm.
    protected String minutes;               //String to get the values of minutes and hours.
    protected String hours;
    // Constructor.
    public Clock(String clockName){
        super(clockName);
        timeLabel= new JLabel("Alarm Time: ");  //Setting the default values.
        alarmTime= new JLabel("10 : 09");
        colon=new JLabel(":");
        setAlarm=new JButton("Set");
        resetAlarm=new JButton("Reset");
        status=new JLabel("Status : ");
        statusInfo=new JLabel("Alarm Not Set");
        Font f=new Font("Serif", Font.ITALIC , 15); //Using Font: One feature from colors and fonts.
        statusInfo.setFont(f);
    }
    // Method for building the frame.  This can be overrided in the subclasses.
    protected void buildFrame(int width, int height){
        setLayout(new FlowLayout());    //Setting the layout manager.
        setSize(width,height);          //Width and height for the frame.
        setVisible(true);               //Setting the visiblity to true.
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Hide the clock on close.
    }
    // Method for resetting the time. This can be overrided in the subclasses.
    protected void reset(){
        statusInfo.setText(" OFF");         //Set the alarm OFF
    }
    // Method for setting the alarm time. This can be overrided in the subclasses.
    protected void set(){
        alarmTime.setText(hours+ " : "+minutes);    //Get the current time.
        statusInfo.setText(" ON");                  //Update the status to ON/Active
    }
}
///////////////////     END of Abstract Class   ////////////////////////////