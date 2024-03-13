package Turtle;

import static Turtle.CurrentPosition.*;

public class TurtleDirection {
    private boolean penIsUp = true;
    private CurrentPosition currentPosition = EAST;
    public boolean penIsUp() {
        return penIsUp;
    }
    public boolean penIsDown(){
        return false;
    }

public CurrentPosition getCurrentPosition() {
        return currentPosition;
    }

    public void turnLeft() {
        switch (currentPosition) {
            case NORTH -> currentPosition = WEST;
            case EAST -> currentPosition = NORTH;

        }
    }
}
