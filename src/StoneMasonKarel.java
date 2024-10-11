import stanford.karel.SuperKarel;

public class StoneMasonKarel extends SuperKarel {
    @Override
    public void run() {
        fixCurrentColumn();
        while (frontIsClear()) {
            moveToNextColumn();
            fixCurrentColumn();
        }
    }

    /*
    Pre => First row, facing east
    Post => First row, facing east
     */
    private void fixCurrentColumn() {
        turnLeft();
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
        }
        if (noBeepersPresent()) {
            putBeeper();
        }
        returnToFirstRow();
    }

    /*
    Pre => Nth column, first row, facing east
    Post => (N+4)th column, first row, facing east
     */
    private void moveToNextColumn() {
        // 4 is the distance between columns
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

    /*
    Pre => Last row of column, facing north
    Post => First row of column, facing east
     */
    private void returnToFirstRow() {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }
}
