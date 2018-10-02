import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Simple level with 4 crates
 */
public class Level5 extends SokoBanWorld
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
    public Level5()
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
        addObject(new Man(), 9, 5);
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
        List <Brick> Bricks = getObjectsAt(7, 5, Brick.class);
        if (spot1.hasCrate() && spot2.hasCrate() && Bricks.size() > 0) {
            removeObject(Bricks.get(0));
        }
        if (Greenfoot.isKeyDown("shift")) {
            nextLevel();
        }
    }    
    
    public void nextLevel(){
        Greenfoot.setWorld(new FLevel1());
    }
    
    /**
     * Add all the creates for this level
     */
    private void addCrates(){
        addObject(new Crate(), 7, 3);
        addObject(new Crate(), 7, 7);
        
        addObject(new Crate(), 8, 5);
    }
    
    /**
     * Add all the targetSpots for this level
     */
    private void addTargetSpots(){
        spot1 = new TargetSpot();
        spot2 = new TargetSpot();    
        spot3 = new TargetSpot();   
        addObject(spot1, 0, 1);
        addObject(spot2, 0, 8);   
        addObject(spot3, 9, 5);  
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
        
        addObject(new Brick(), 0, 2);
        addObject(new Brick(), 0, 3);
        addObject(new Brick(), 0, 4);
        addObject(new Brick(), 0, 5);
        addObject(new Brick(), 0, 6);
        addObject(new Brick(), 0, 7);
        addObject(new Brick(), 2, 2);
        addObject(new Brick(), 2, 3);
        addObject(new Brick(), 2, 4);
        addObject(new Brick(), 2, 6);
        addObject(new Brick(), 2, 7); 
        addObject(new Brick(), 4, 1);
        addObject(new Brick(), 4, 2);
        addObject(new Brick(), 4, 3);
        addObject(new Brick(), 4, 7);
        addObject(new Brick(), 4, 8);
        
        addObject(new Brick(), 7, 4);
        
        addObject(new Brick(), 7, 5);
        
        addObject(new Brick(), 7, 6);
        addObject(new Brick(), 8, 4);
        addObject(new Brick(), 8, 6);
    }
}
