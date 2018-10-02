import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Simple level with 4 crates
 */
public class Level2 extends SokoBanWorld
{
    // Fields with the targetspots. These are used to check if the level had been completed
    // see method: endOfGame
    private TargetSpot spot1;
    private TargetSpot spot2;
    private TargetSpot spot3;
    
    /**
     * Constructor for level 1. Make sure the world is initialized properly.
     * Add the man, the creates, the bricks and the targetspots to the world 
     */
    public Level2()
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
        addObject(new Man(), 5, 3);
        addCrates();
        addBricks();
        addTargetSpots();
    }
    
    
    /**
     * Check to see if all of the crates are on a targetspot.
     * If so, go to next level, or stop the game.
     */
    public void endOfLevel(){
        if (spot1.hasCrate() && spot2.hasCrate() && spot3.hasCrate()){           
            showText ("Level klaar", 5, 4);
            Greenfoot.delay(25);
            nextLevel();
        }
        if (Greenfoot.isKeyDown("shift")) {
            nextLevel();
        }
    }    
    
    public void nextLevel(){
        Greenfoot.setWorld(new Level3());
    }
    
    /**
     * Add all the creates for this level
     */
    private void addCrates(){
        addObject(new Crate(), 7, 6);
        addObject(new Crate(), 3, 7);
        addObject(new Crate(), 7, 7);
    }
    
    /**
     * Add all the targetSpots for this level
     */
    private void addTargetSpots(){
        spot1 = new TargetSpot();
        spot2 = new TargetSpot();
        spot3 = new TargetSpot();       
        addObject(spot1, 0, 7);
        addObject(spot2, 2, 7);
        addObject(spot3, 4, 7);       
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
            addObject(new Brick(), 9, i);
        }
        addObject(new Brick(), 0, 1);
        addObject(new Brick(), 0, 2);
        addObject(new Brick(), 0, 3);
        addObject(new Brick(), 0, 4);
        addObject(new Brick(), 0, 5);
        addObject(new Brick(), 0, 6);
        addObject(new Brick(), 0, 8);
        
        addObject(new Brick(), 2, 2);
        addObject(new Brick(), 2, 3);
        addObject(new Brick(), 2, 4);
        addObject(new Brick(), 2, 5); 
        addObject(new Brick(), 2, 6);
        addObject(new Brick(), 2, 8);
        
        addObject(new Brick(), 3, 2);
        
        addObject(new Brick(), 4, 2);
        addObject(new Brick(), 4, 3);
        addObject(new Brick(), 4, 4);
        addObject(new Brick(), 4, 5); 
        addObject(new Brick(), 4, 6);
        addObject(new Brick(), 4, 8);
        
        addObject(new Brick(), 5, 2);
        
        addObject(new Brick(), 6, 2);
        addObject(new Brick(), 6, 3);
        addObject(new Brick(), 6, 4);
        addObject(new Brick(), 6, 5); 
        addObject(new Brick(), 6, 6);
        addObject(new Brick(), 6, 8);
    }
}
