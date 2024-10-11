import stanford.karel.SuperKarel;

public class MidPointFindingKarel extends SuperKarel {
    @Override
    public void run() {
        placePointers();

        // Karel checks if there is no beeper between those 2 pointers, if there is then he needs to stop as we reached middle
        while (noBeepersPresent()) {
            bringPointersCloser();
        }
        removeOneBeeperIfNecessary();
    }

    // Just placing pointers in corners
    private void placePointers() {
        putBeeper();
        while (frontIsClear()) {
            move();
        }
        putBeeper();
        returnHome();
        move();
    }

    /*
        Karel is in between 2 pointers, facing east
     */
    private void bringPointersCloser() {
        turnAround();
        move();
        turnAround();
        moveLeftPointer();
        traverseBetweenPointers();
        moveRightPointer();
    }

    // Karel takes the right pointer and goes left by 1, if there is no beeper he puts it and goes back to left pointer, if there is beeper it means that karel is already in the center and needs to face east (turnAround)
    private void moveRightPointer() {
        pickBeeper();
        turnAround();
        move();
        if (noBeepersPresent()) {
            putBeeper();
            traverseBetweenPointers();
            turnAround();
            move();
        } else {
            turnAround();
        }
    }

    // Need to be facing to pointer which karel must traverse to
    private void traverseBetweenPointers() {
        move();
        while (noBeepersPresent()) {
            move();
        }
    }


    // Must be on beeper
    private void moveLeftPointer() {
        pickBeeper();
        move();
        putBeeper();
    }

    // If there are two pointers in the middle, karel is on the right one facing west, we check if there is beeper behind karel and pick it, then return to previous beeper
    private void removeOneBeeperIfNecessary() {
        turnAround();
        move();
        if (beepersPresent()) {
            pickBeeper();
        }
        turnAround();
        move();
    }

    /*
    Pre=> facing west
    Post=> 1x1, facing east
     */
    private void returnHome() {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnAround();
    }
}
