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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ClockMenu extends Clock{
    private final JMenuItem createClock1;   //Menu items for clocks
    private final JMenuItem createClock2;
    private final JMenuItem createClock3;
    private final JMenuItem createClock4;
    private final JMenuItem exitItem;       //Menu item for exiting out of the program.
    private final JMenuItem resetAll;       //Menu item for resetting all clocks.
    private final JMenuBar bar;             //To define a menu bar.
    private final JTextArea displayText;    //Help/Body of the panel to display help/usage.
    protected static final int MAX_COUNT=2;         //Max clocks for each kind.
    protected final ArrayList<Clock> clocksArray;   //To store the array of clocks object.

    public ClockMenu(){                 //Constructor to create the clock menu.
        super("Create Alarm Clocks");
        clocksArray=new ArrayList<>();
        JMenu createMenu=new JMenu("Create");
        createMenu.setMnemonic('C');
        
        createClock1=new JMenuItem("AlarmClock 1"); //Creating a new menuitem
        createClock1.setMnemonic('1');              //Adding the mnemonic.
        createMenu.add(createClock1);               //Adding the menuutem to menu.
        
        createClock2=new JMenuItem("AlarmClock 2");
        createClock2.setMnemonic('2');
        createMenu.add(createClock2);

        createClock3=new JMenuItem("AlarmClock 3");
        createClock3.setMnemonic('3');
        createMenu.add(createClock3);

        createClock4=new JMenuItem("AlarmClock 4");
        createClock4.setMnemonic('4');
        createMenu.add(createClock4);
        
        JMenu reset=new JMenu("Reset/Exit");    //Adding a submenu
        reset.setMnemonic('r');
        
        resetAll=new JMenuItem("Reset All");
        resetAll.setMnemonic('s');
        reset.add(resetAll);
        
        exitItem=new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        reset.add(exitItem);
        
        bar= new JMenuBar();        //Creating a menu bar.
        super.setJMenuBar(bar);     //Set the menu bar.
        bar.add(createMenu);        //Add the menu to menu bar.
        bar.add(reset);
        
        displayText = new JTextArea("Alarm Clocks:\n"
                + "\n1. To create a new alarm clock click in Create and select the type, only 2 of each kind can be created."
                + "\n Type 1: You can enter the alarm time as text."
                + "\n Type 2: You select time from the drop down."
                + "\n Type 3: You can increase minutes/hours from an increment button."
                + "\n Type 4: This is same as above except you've an additional button for decrement."
                + "\n2. Once, you've selected the time. Click on \"Set\" to make the alarm active."
                + "\n3. You can inactive the alarm by clicking on \"Reset\" in each kind of clock."
                + "\n4. If you want to reset all clocks, click on \"Reset All\""
                + "\n5. You can exit the application either by selecting \"Exit\" from menu or Close the window.");
        displayText.setLineWrap(true);          //Formatting the JTextArea.
        displayText.setEditable(false);
        displayText.setForeground(Color.BLUE);
        displayText.setFont(new Font("Serif", Font.PLAIN, 15));
        displayText.setBackground(Color.LIGHT_GRAY);   
        super.add(displayText);
        //Creating the object to handle menu items.
        MenuHandler handler=new MenuHandler();
        exitItem.addActionListener(handler);
        createClock1.addActionListener(handler);
        createClock2.addActionListener(handler);
        createClock3.addActionListener(handler);
        createClock4.addActionListener(handler);
        resetAll.addActionListener(handler);
    }
    //To catch the events for the menu bar.
    private class MenuHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==exitItem)
                System.exit(0);
            else if(event.getSource()==createClock1){   //Get the source and implement the appropriate action.
                if(Clock1.clock1Count==MAX_COUNT){
                    this.showMessage("Max Limit reached for Clock 1", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Clock1 clock1= new Clock1("Alarm Clock 1");
                    clocksArray.add(clock1);
                }
            }
            else if(event.getSource()==createClock2){
                if(Clock2.clock2Count==MAX_COUNT){      //If the max count is reached display the error message.
                    this.showMessage("Max Limit reached for Clock 2", JOptionPane.ERROR_MESSAGE);
                }
                else{                                   //If more clocks can be created, make a new clock of the selected type.
                    Clock2 clock2= new Clock2("Alarm Clock 2");
                    clocksArray.add(clock2);
                }
            }
            else if(event.getSource()==createClock3){
                if(Clock3.clock3Count==MAX_COUNT){
                    this.showMessage("Max Limit reached for Clock 3", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Clock3 clock3= new Clock3("Alarm Clock 3");
                    clocksArray.add(clock3);
                }
            }
            else if(event.getSource()==createClock4){
                if(Clock4.clock4Count==MAX_COUNT){
                    this.showMessage("Max Limit reached for Clock 4", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Clock4 clock4= new Clock4("Alarm Clock 4");
                    clocksArray.add(clock4);
                }
            }
            else if(event.getSource()==resetAll){
                this.resetClocks(clocksArray);
            }
        }
        private void showMessage(String errMessage, int option){    //To display the error message.
            JOptionPane.showMessageDialog(null,errMessage,"Error! ",option);
        }
        private void resetClocks(ArrayList<Clock> clocksArray){     //To reset all the clocks.
            clocksArray.stream().forEach((currentClock) -> {        //Get the object from the array.
                if(currentClock instanceof Clock1){                 //Check for the instance of clock.
                    Clock1 ck=(Clock1) currentClock;                //Downcast to the proper object.
                    ck.reset();                                     //Call the reset for that object type.
                }
                else if(currentClock instanceof Clock2){
                    Clock2 ck=(Clock2) currentClock;
                    ck.reset();
                }
                else if(currentClock instanceof Clock3){
                    Clock3 ck=(Clock3) currentClock;
                    ck.reset();                         //Since clock4 extends Clock3, all objects of Clock4 are also objects of Clock3.
                }
            });
        }
    }
}
//////////////////////// END OF SOURCE FILE ////////////////////////////