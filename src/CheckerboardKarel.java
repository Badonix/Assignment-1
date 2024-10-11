import stanford.karel.SuperKarel;

public class CheckerboardKarel extends SuperKarel {
    @Override
    public void run() {
        fillFromFirst();
        turnLeft();

        // Checking if upper row exists
        while (frontIsClear()) {
            moveUp();
            fillFromSecond();
            turnLeft();
            if (frontIsClear()) {
                moveUp();
                fillFromFirst();
                turnLeft();
            }
        }

        returnHome();
    }

    /*
    Return karel to 1x1

    Pre=> top left corner, facing north
    Post=> 1x1, facing east
     */
    private void returnHome() {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }

    /*
    This type of fill puts beeper on first cell and starts from there

    Pre=> First column, facing east
    Post=> First column, facing east
     */
    private void fillFromFirst() {
        putBeeper();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
        returnBack();
    }


    /*
    This type of fill puts beeper on second cell and starts from there

    Pre=> First column, facing east
    Post=> First column, facing east
     */
    private void fillFromSecond() {
        while (frontIsClear()) {
            move();
            putBeeper();
            if (frontIsClear()) {
                move();
            }
        }
        returnBack();
    }


    /*
    Return to the first cell of the row

    Pre=> Last column, facing east
    Post=> First column, facing east
     */
    private void returnBack() {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnAround();
    }

    /*
    Pre=> facing north
    Post=> facing east, one row up
     */
    private void moveUp() {
        move();
        turnRight();
    }
}
