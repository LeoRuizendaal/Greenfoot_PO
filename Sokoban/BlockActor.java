import greenfoot.*;

/**
 * A BlockActor is a specific kind of Actor:
 * There can be only one BlockActor on a specific spot at the same time. 
 * So, a BlockActor cannot move to a spot where already another BlockActor resides
 */
public class BlockActor extends Actor
{
    // Fields for determing up, down, left and right
    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;
    
    /**
     * Move the blockactor to the given direction, but only
     * if there is no other blockactor in that direction.
     */
    public void moveTo (int direction) {
        switch (direction) {
            case UP:
                moveTo (0,-1);
                break;
            case DOWN:
                moveTo (0,1);
                break;
            case LEFT:
                moveTo (-1,0);
                break;
            case RIGHT:
                moveTo (1,0);
                break;
            default:
                break;
        }     
    }
    
    /**
     * Private method: move the blockactor to a new location,
     * based on the offset
     */
    private void moveTo (int offsetX, int offsetY) {
        if (isFree (offsetX, offsetY)) {
            setLocation (getX() + offsetX, getY() + offsetY);
        }
    }
    
    /**
     * Private method: check to see if the new location is free
     * (there is no other blockactor at that location),
     * based on the given offset
     */
    private boolean isFree (int offsetX, int offsetY) {
        if (getX()+offsetX < getWorld().getWidth() && getX()+offsetX >=0 && getY()+offsetY < getWorld().getHeight() && getY()+offsetY >=0) { 
            return (getObjectsAtOffset(offsetX,offsetY,BlockActor.class).isEmpty());
        }
        else {
            return false;
        }
    }
    
    /**
     * Get an objectreference to the crate, relative to the current location
     * If there is no crate, the return value will be null
     */
    public Crate getLinkToCrate (int direction) {
        Crate returnValue = null;
        switch (direction) {
            case UP:
                returnValue = (Crate)getOneObjectAtOffset (0,-1, Crate.class);
                break;
            case DOWN:
                returnValue = (Crate)getOneObjectAtOffset (0,1, Crate.class);
                break;
            case LEFT:
                returnValue = (Crate)getOneObjectAtOffset (-1,0, Crate.class);
                break;
            case RIGHT:
                returnValue = (Crate)getOneObjectAtOffset (1,0, Crate.class);
                break;
            default:
                break;
        }  
        return returnValue;
    }
    
    /**
     * Private method: see if there is a crate at the given offset
     */
    private boolean canSeeCrate (int offsetX, int offsetY) {
        return !getObjectsAtOffset(offsetX,offsetY,Crate.class).isEmpty();
    }
    
    /**
     * Check to see if there is a crate in the given direction
     * Return true if there is a crate in the given direction
     * Return false if there is no crate in the given direction
     */
    public boolean canSeeCrate (int direction) {
        boolean returnValue = false;
        switch (direction) {
            case UP:
                returnValue = canSeeCrate (0,-1);
                break;
            case DOWN:
                returnValue = canSeeCrate (0,1);
                break;
            case LEFT:
                returnValue = canSeeCrate (-1,0);
                break;
            case RIGHT:
                returnValue = canSeeCrate (1,0);
                break;
            default:
                break;
        }         
        return returnValue;
    }
    
    /**
     * Check to see if the location in the given direction is free
     * (there is no blockactor)
     * Return true if there is no blockactor in the given direction
     * Return false if the location is already taken
     */
    public boolean isFree (int direction) {
        boolean returnValue = false;
        switch (direction) {
            case UP:
                returnValue = isFree (0,-1);
                break;
            case DOWN:
                returnValue = isFree (0,1);
                break;
            case LEFT:
                returnValue = isFree (-1,0);
                break;
            case RIGHT:
                returnValue = isFree (1,0);
                break;
            default:
                break;
        }         
        return returnValue;
    }    
}
