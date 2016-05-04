/* ******************************************************************
Author:    Khaja Anwar Ali, Siddiqui
Usage:   Inheritance, polymorphism and interfaces.

*********************************************************************/
// Required imports:
import javax.swing.JFrame;
// Implementing the clockMenu by creating an object.
public class ClockMenuRun{
    public static void main(String[] args){
        ClockMenu menuframe=new ClockMenu();    // Creating an object of clockMenu
        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Program should exit on close.
        menuframe.setSize(620,300);     //Frame size.
        menuframe.setVisible(true);     //Visiblity
    }
}
//////////////////////// END OF SOURCE FILE ////////////////////////////
