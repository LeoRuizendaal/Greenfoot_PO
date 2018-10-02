import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Simple level with 4 crates
 */
public class Level4 extends SokoBanWorld
{
    // Fields with the targetspots. These are used to check if the level had been completed
    // see method: endOfGame
    private TargetSpot spot1;
    private TargetSpot spot2;
    
    /**
     * Constructor for level 1. Make sure the world is initialized properly.
     * Add the man, the creates, the bricks and the targetspots to the world 
     */
    public Level4()
    {    
        super(10, 10, 32);
        //Make sure the man and the crates appear in front of the targetspots        
        setPaintOrder(Man.class, Crate.class);  
        populateWorld();
    }

    /**
     * Add the man, the creates, the bricks and the targetspots to the world
     * 
     */
    private void populateWorld()
    {
        addObject(new Man(), 4,4);
        addCrates();
        addBricks();
        addTargetSpots();
    }
    
    
    /**
     * Check to see if all of the crates are on a targetspot.
     * If so, go to next level, or stop the game.
     */
    public void endOfLevel(){
        if (spot1.hasCrate() && spot2.hasCrate()){           
            showText ("Level klaar", 5, 4);
            Greenfoot.delay(25);
            nextLevel();
        }
        if (Greenfoot.isKeyDown("shift")) {
            nextLevel();
        }
    }    
    
    public void nextLevel(){
        Greenfoot.setWorld(new Level5());
    }
    
    /**
     * Add all the creates for this level
     */
    private void addCrates(){
        addObject(new Crate(), 2, 3);
        addObject(new Crate(), 2, 6);
    }
    
    /**
     * Add all the targetSpots for this level
     */
    private void addTargetSpots(){
        spot1 = new TargetSpot();
        spot2 = new TargetSpot();    
        addObject(spot1, 8, 1);
        addObject(spot2, 8, 8);   
    }
    
    /**
     * Add all the bricks for this level
     */
    private void addBricks () {
        for (int i = 0; i < 10; i++){
            addObject(new Brick(), i, 0);
        }
        for (int i = 0; i < 10; i++){
            addObject(new Brick(), i, 9);
        }
        for (int i = 1; i < 9; i++){
            addObject(new Brick(), 0, i);
        }
        for (int i = 1; i < 9; i++){
            addObject(new Brick(), 9, i);
        }
        addObject(new Brick(), 5, 1);
        addObject(new Brick(), 6, 1);
        addObject(new Brick(), 2, 4);
        addObject(new Brick(), 2, 5);
        addObject(new Brick(), 5, 3);
        addObject(new Brick(), 5, 4);
        addObject(new Brick(), 5, 5);
        addObject(new Brick(), 5, 6);
        addObject(new Brick(), 5, 8);
        addObject(new Brick(), 6, 8);
        addObject(new Brick(), 7, 4); 
        addObject(new Brick(), 7, 5);
    }
}
