package Turtle;

public enum CurrentPosition {
    EAST("SOUTH", "NORTH"), NORTH("EAST", "WEST"), WEST("SOUTH", "NORTH"), SOUTH("WEST", "EAST");

    private String right;
    private String left;

    CurrentPosition(String right, String left){
        this.left = left;
        this.right = right;
    }
    public CurrentPosition turnLeft(){
        return CurrentPosition.valueOf(left);
    }
}
