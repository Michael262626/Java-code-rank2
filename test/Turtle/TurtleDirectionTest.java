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

}