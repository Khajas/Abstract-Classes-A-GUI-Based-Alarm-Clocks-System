/* ******************************************************************
Author:    Khaja Anwar Ali, Siddiqui
Usage:   Inheritance, polymorphism and interfaces.

*********************************************************************/
//Package name.
package default;
// Required imports:
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
//Creating a class for clock type1 by extending it to Clock abstract class.
public class Clock1 extends Clock{
    protected static int clock1Count=0; //Current count of the clocks created.
    private final JTextField mins;      //Input fields for the clock type 1.
    private final JTextField hrs;
    public Clock1(String clockName) {   //Constructor for the clock 1.
        super(clockName); clock1Count++;    //Call the super class constrcutor and increment the count.
        hrs=new JTextField("10", 5);       //Label the initiavalues.
        mins=new JTextField("09", 5);
        Font f = new Font("Serif", Font.ITALIC, 15);    //Font setting for the text field.
        hrs.setFont(f); mins.setFont(f);
        //Build the layout for the clock type 1.
        super.add(hrs); super.add(colon); super.add(mins);
        super.add(timeLabel); super.add(alarmTime);
        super.add(setAlarm); super.add(resetAlarm);
        super.add(status); super.add(statusInfo);
        //Call the method to create the frame.
        super.buildFrame(290,120);
        Container c = super.getContentPane();
        c.setBackground(Color.RED);             //Setting the backgroud.
        ClockAlarm handler=new ClockAlarm();    //Object the action handler.
        setAlarm.addActionListener(handler); resetAlarm.addActionListener(handler); //Add the actionlistener object to components.
        WindowActions winHandler=new WindowActions();   //Create an object to handler window action events.
        super.addWindowListener(winHandler);    //Add the window listener to the current frame.
    }
    //Insterface to set/reset alarm.
    private class ClockAlarm implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            int min=0, hr=0;
            if(event.getSource()==setAlarm){    //If user clicks on set, parse the text to validate.
                minutes=mins.getText();             
                hours=hrs.getText();
                try{
                    min=Integer.parseInt(minutes);
                    hr=Integer.parseInt(hours);
                }
                catch(Exception e){
                    statusInfo.setText("Invalid Time");
                    return; //If the exception is caught return.
                }
                if(min>MAX_MINS || min<0 || hr>MAX_HRS || hr<0){    //Validate the input.
                         statusInfo.setText("Invalid Time");
                }
                else{           //If the value is valid, set the time.
                    set();
                }
            }
            if(event.getSource()==resetAlarm){  //If the user clicks on Reset, call the reset method.
                reset();
            }
        }
    }
        private class WindowActions extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            clock1Count--;          //If a clock is closed, decrement the clock count.
        }

        @Override
        public void windowClosed(WindowEvent e) {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Hide the frame, when closed.
        }
    }
}
//////////////////////// END OF SOURCE FILE ////////////////////////////
