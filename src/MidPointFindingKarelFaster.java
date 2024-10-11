import stanford.karel.SuperKarel;

public class MidPointFindingKarelFaster extends SuperKarel {

    // This solution only works for square worlds

    public void run() {
        while (noBeepersPresent()) {
            moveUp();
        }
    }

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
