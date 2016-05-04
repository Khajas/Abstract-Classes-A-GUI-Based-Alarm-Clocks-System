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
import javax.swing.JFrame;
// Implementing the clockMenu by creating an object.
public class hw04{
    public static void main(String[] args){
        ClockMenu menuframe=new ClockMenu();    // Creating an object of clockMenu
        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Program should exit on close.
        menuframe.setSize(620,300);     //Frame size.
        menuframe.setVisible(true);     //Visiblity
    }
}
//////////////////////// END OF SOURCE FILE ////////////////////////////