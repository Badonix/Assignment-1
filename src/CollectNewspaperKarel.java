/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	// You fill in this part

  public void run(){
    goToDoor();
    move(); // 6x6
    takeNewspaperAndReturn();
    returnToCorner();
  }

  /*
  Pre => 3x4, facing east
  Post => 5x3, facing east
   */
  private void goToDoor(){
    doubleMove();
    turnRight();
    move();
    turnLeft();
  }
  /*
    Pre => 6x3, facing east
    Post => 5x3, facing west
   */
  private void takeNewspaperAndReturn(){
    if(beepersPresent()){
      pickBeeper();
    }
    turnAround();
    move();
  }

  /*
    Pre => 5x3 facing west
    Post => 3x4 facing east
   */
  private void returnToCorner(){
    turnRight();
    move();
    turnLeft();
    doubleMove();
    turnAround();
  }

  private void doubleMove(){
    move();
    move();
  }
}
