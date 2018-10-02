import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FLevel1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FLevel1 extends SokoBanWorld
{
    private TargetSpot spot1;
    /**
     * Constructor for objects of class FLevel1.
     *
     */
    public FLevel1()
    {
      super(11, 11, 32);
      //Make sure the man and the crates appear in front of the targetspots
      setPaintOrder(Man.class, Crate.class);
      populateWorld();
    }

    private void populateWorld()
    {
        addObject(new Man(), 5, 6);
        addCrates();
        addBricks();
        addTargetSpots();
        addBees();
        addPowerUps();
    }

    public void endOfLevel(){
        if (spot1.hasCrate()){
            showText ("Level klaar", 5, 4);
            Greenfoot.delay(25);
            nextLevel();
        }
        if (Greenfoot.isKeyDown("shift")) {
            nextLevel();
        }
    }

    public void nextLevel(){
        //Greenfoot.setWorld(new FLevel2());
    }

    private void addCrates(){
        addObject(new Crate(), 9, 9);
    }

    /**
     * Add all the targetSpots for this level
     */
    private void addTargetSpots(){
        spot1 = new TargetSpot();
        addObject(spot1, 1, 9);
    }

    /**
     * Add all the bricks for this level
     */
    private void addBricks () {
        addObject(new Brick(), 2, 0);
        addObject(new Brick(), 5, 0);
        addObject(new Brick(), 8, 0);
        addObject(new Brick(), 5, 1);
        addObject(new Brick(), 0, 2);
        addObject(new Brick(), 1, 2);
        addObject(new Brick(), 2, 2);
        addObject(new Brick(), 8, 2);
        addObject(new Brick(), 2, 3);
        addObject(new Brick(), 5, 3);
        addObject(new Brick(), 8, 3);
        addObject(new Brick(), 2, 4);
        addObject(new Brick(), 3, 4);
        addObject(new Brick(), 4, 4);
        addObject(new Brick(), 5, 4);
        addObject(new Brick(), 6, 4);
        addObject(new Brick(), 7, 4);
        addObject(new Brick(), 8, 4);
        addObject(new Brick(), 1, 7);
        addObject(new Brick(), 2, 7);
        addObject(new Brick(), 3, 7);
        addObject(new Brick(), 3, 8);
        addObject(new Brick(), 5, 8);
        addObject(new Brick(), 7, 8);
        addObject(new Brick(), 8, 8);
        addObject(new Brick(), 9, 8);
        addObject(new Brick(), 3, 9);
        addObject(new Brick(), 5, 9);
        addObject(new Brick(), 3, 10);
        addObject(new Brick(), 7, 10);
        addObject(new Brick(), 8, 10);
        addObject(new Brick(), 9, 10);
        addObject(new Brick(), 10, 10);
    }
    private void addBees(){
        addObject(new Bee(), 3, 3);
        addObject(new Bee(), 6, 0);
        addObject(new Bee(), 4, 9);
    }
    private void addPowerUps(){
        addObject(new PowerUp(), 0, 0);
    }
}
