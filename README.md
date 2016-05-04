# Abstract-Classes-A-GUI-Based-Alarm-Clocks-System
A GUI based alarm clocks system: Demonstrates interfaces, polymorphic processing of arrays, abstract class usage, over

Goal:
There are many kinds of digital alarm clocks, some of them with truly user-unfriendly alarm interfaces. In this assignment we will implement several different alarm interfaces, both to study the many ways that Java provides to display and update GUI components and to practice subclassing, polymorphic processing of an array, and interface definition.

Method:

1. Define your classes.
a) Define a Clock class. This is an abstract class, i.e., there will be no objects of type Clock, only objects of its subclasses.
b) Each clock should display the time in hours, minutes and seconds using a digital 24-hour display. Since these clocks are for display purposes only (they do not have to run), set the time to 10:09:00 AM. (Analogue clocks in retail stores were traditionally set to 10:10 so as not to obscure the manufacturer’s logo at the bottom of the clock. The time here has no real significance.)
c) Every clock should display an alarm time in hours and minutes, also on a 24-hour basis.
d) Every clock needs a way to set the alarm. Define a subclass for each of these types of alarm mechanism below.
1)	The user can type in the hour and minutes.
2)	The hour and minutes can be set from drop-down lists. This is bad design, since a 60-item drop-down list is too long for convenience, but designers do this kind of thing. For example, you have probably seen drop-down lists covering every country in the world even though most users will be coming from a small number of countries.
3)	There is a radio button that switches between hours and minutes. There is a ‘+’ button that increases the hours or minutes by 1 every time it is pressed, depending on which radio button has been chosen. When it reaches the maximum count, it resets to zero on the next click and keeps counting.
4)	(graduate students only) Same as c), except there are ‘+’ and ‘-’ buttons that go forwards and backwards respectively. This class should be a subclass of the previous class.
d) Every clock should have an label or icon that is displayed when the alarm is active and a different one when the alarm is inactive. It can be as simple as the words “alarm on” and “alarm off”, or can use a symbol or graphic. If you would like to use a graphic but don’t have a graphic editor, you can use an icon from the sample code.
e) Each leaf node class, i.e., each class that is not a superclass of another class, should contain two static variables, one for the maximum number of clocks of the subclass that the user is allowed to create, and one for the number of clocks of the subclass that the user has created. The maximum should be a final variable.
f) Use at least two features from Chapter 13 to make your clocks look attractive and different. Options include the use of background color, including the use of gradient color; shapes, such as the rounded rectangle look; edge characteristics; and fonts.
g) Define a ClockAlarm interface with two functions, one to set the alarm and one to reset it. Each leaf node class, i.e., each class that is not a superclass of another class, should implement the ClockAlarm interface.
	Note: In the real world, one of the most important features about interfaces is that they can be used to implement consistent functionality among classes that do not necessarily have an is a relationship. In this assignment the classes do happen to have an is a relationship.

2. Build your screen.
a) Define a window with a menu bar.
b) The menu bar should contain two items, Create and Reset All.
c) The Create menu should have an item for creating each kind of clock.
d) The Reset All menu should enable the user to reset all the alarms at once by looping through the list of clocks.
3. Add the required functionality.
a) When the user tries to create a clock, check the maximum count for that type of clock. If the limit has not been reached, create an object of the correct type and increase the actual count; otherwise display an error message in a modal dialogue box. The user can dismiss the modal dialogue by clicking OK or pressing the Enter key.
b) As part of creating a clock, display the clock on the screen and add a reference to it to an ArrayList of Clock objects. Set the time to 10:09:00 AM and set the alarm to “off”.
c) Allow the user to set the alarm on each type of clock according to the description above.
d) Allow the user to reset the alarm on each type of clock.
e) When the user clicks on the Reset All item from the menu, reset all the alarms.
