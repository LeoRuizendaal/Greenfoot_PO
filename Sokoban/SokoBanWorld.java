import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * SokobanWorld, keeps track of the score. For each level there should be 
 * one subclass which determines the layout of the specific level.
 */
public class SokoBanWorld extends World
{   
    /**
     * Constructor, starts the first level
     */
    public SokoBanWorld()
    {    
        super(10, 10, 32);
        Greenfoot.setWorld(new Level1());
    }
    
    /**
     * Constructor, should be called from subclass
     */
    public SokoBanWorld (int width, int height, int cellSize) {
        super (width, height, cellSize, true);
    }

    /**
     * Check to see if all of the crates are on a targetspot.
     * If so, go to next level, or stop the game.
     * Should be implemented for each level (each subclass).
     */
    public void endOfLevel(){
    }
    
}
