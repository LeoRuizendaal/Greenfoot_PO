import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Simple level with 4 crates
 */
public class Level1 extends SokoBanWorld
{
    // Fields with the targetspots. These are used to check if the level had been completed
    // see method: endOfGame
    private TargetSpot spot1;
    private TargetSpot spot2;
    private TargetSpot spot3;
    private TargetSpot spot4;
    private CopyOfTargetSpot spotCheat;

    /**
     * Constructor for level 1. Make sure the world is initialized properly.
     * Add the man, the creates, the bricks and the targetspots to the world
     */
    public Level1()
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
        addObject(new Man(), 5, 5);
        addCrates();
        addBricks();
        addTargetSpots();
    }


    /**
     * Check to see if all of the crates are on a targetspot.
     * If so, go to next level, or stop the game.
     */
    public void endOfLevel(){
        if ((spot1.hasCrate() && spot2.hasCrate() && spot3.hasCrate() && spot4.hasCrate()) || spotCheat.hasCrate()){
            showText ("Level klaar", 5, 4);
            Greenfoot.delay(25);
            nextLevel();
        }
        if (Greenfoot.isKeyDown("shift")) {
            nextLevel();
        }
        if (Greenfoot.isKeyDown("`")) {
            Greenfoot.setWorld(new FLevel1());
        }
    }

    public void nextLevel(){
        Greenfoot.setWorld(new Level2());
    }

    /**
     * Add all the creates for this level
     */
    private void addCrates(){
        addObject(new Crate(), 5, 2);
        addObject(new Crate(), 6, 2);
        addObject(new Crate(), 7, 2);
        addObject(new Crate(), 8, 2);
    }

    /**
     * Add all the targetSpots for this level
     */
    private void addTargetSpots(){
        spot1 = new TargetSpot();
        spot2 = new TargetSpot();
        spot3 = new TargetSpot();
        spot4 = new TargetSpot();
        spotCheat = new CopyOfTargetSpot();
        addObject(spot1, 5, 7);
        addObject(spot2, 6, 7);
        addObject(spot3, 5, 8);
        addObject(spot4, 6, 8);
        addObject(spotCheat, 0, 0);
    }

    /**
     * Add all the bricks for this level
     */
    private void addBricks () {
        addObject(new Brick(), 3, 3);
        addObject(new Brick(), 3, 4);
        addObject(new Brick(), 3, 5);
        addObject(new Brick(), 3, 6);
        addObject(new Brick(), 4, 6);
        addObject(new Brick(), 5, 6);
        addObject(new Brick(), 6, 6);
        addObject(new Brick(), 7, 6);
        addObject(new Brick(), 7, 5);
        addObject(new Brick(), 7, 4);
        addObject(new Brick(), 7, 3);
    }
}
