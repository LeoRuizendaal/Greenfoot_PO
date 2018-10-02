import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TargetSpot: this is the place where a crate should go to
 */
public class TargetSpot extends Actor
{  
    /**
     * Check to see if there is a crate on this targetSpot
     */
    public boolean hasCrate(){
        if (getOneIntersectingObject(Crate.class) != null)
            return true;
        else
            return false;
    }
}
