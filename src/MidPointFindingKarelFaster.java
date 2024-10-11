import stanford.karel.SuperKarel;

public class MidPointFindingKarelFaster extends SuperKarel {

    // This solution only works for square worlds

    public void run() {
        while (noBeepersPresent()) {
            moveUp();
        }
    }

    // Move up by 2 cells and right by one, when top is reached u are in the middle of the X axis
    private void moveUp() {
        turnLeft();
        if (frontIsClear()) {
            move();
        } else {
            returnOnFirstRow();
        }
        if (noBeepersPresent()) {

            if (frontIsClear()) {
                move();
            } else {
                returnOnFirstRow();
            }
        }
        if (noBeepersPresent()) {
            turnRight();
            move();
        }
    }

    private void returnOnFirstRow() {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        putBeeper();
        turnRight();
    }

}
