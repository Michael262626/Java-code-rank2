package Turtle;

import static Turtle.CurrentPosition.*;

public class TurtleDirection {
    private final boolean penIsUp = true;
    private CurrentPosition currentPosition = EAST;

    public boolean penIsUp() {
        return penIsUp;
    }
    public boolean penIsDown() {
        return false;
    }

    public CurrentPosition getCurrentPosition() {
        return currentPosition;
    }

    public void turnLeft() {
        switch (currentPosition) {
            case SOUTH -> currentPosition = EAST;
            case WEST -> currentPosition = SOUTH;
            case NORTH -> currentPosition = WEST;
            case EAST -> currentPosition = NORTH;
        }
    }
}

