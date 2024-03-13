package Turtle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Turtle.CurrentPosition.*;
import static org.junit.jupiter.api.Assertions.*;

class TurtleDirectionTest {
    private TurtleDirection myTurtle;
    @BeforeEach
    public void initializer(){
        myTurtle = new TurtleDirection();
    }
    @Test
    public void testThatPenIsUp(){
        assertTrue(myTurtle.penIsUp());
    }
    @Test
    public void testThatPenIsDown() {
        assertFalse(myTurtle.penIsDown());
    }
    @Test
    public void testThatTurtleFaceEastTurnLeftTurtleFaceNorth(){
        assertSame(EAST, myTurtle.getCurrentPosition());
        myTurtle.turnLeft();
        assertSame(NORTH, myTurtle.getCurrentPosition());
    }
    @Test
    public void testThatTurtleFaceNorthTurnLeftTurtleFaceWest(){
        assertSame(EAST, myTurtle.getCurrentPosition());
        myTurtle.turnLeft();
        assertSame(NORTH, myTurtle.getCurrentPosition());
        myTurtle.turnLeft();
        assertSame(WEST, myTurtle.getCurrentPosition());
    }
    @Test
    public void testThatTurtleFaceWestTurnLeftTurtleFaceSouth(){
        assertSame(EAST, myTurtle.getCurrentPosition());
        myTurtle.turnLeft();
        myTurtle.turnLeft();
        assertSame(WEST, myTurtle.getCurrentPosition());
        myTurtle.turnLeft();
        assertSame(SOUTH, myTurtle.getCurrentPosition());
    }
    @Test
    public void testThatTurtleFaceSouthTurnLeftTurtleFaceEast() {
        assertSame(EAST, myTurtle.getCurrentPosition());
        myTurtle.turnLeft();
        myTurtle.turnLeft();
        myTurtle.turnLeft();
        assertSame(SOUTH, myTurtle.getCurrentPosition());
        myTurtle.turnLeft();
        assertSame(EAST, myTurtle.getCurrentPosition());

    }
}