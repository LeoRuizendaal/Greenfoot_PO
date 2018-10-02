import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * A man can be moved around with the arrow-keys.
 * A man can push a crate, but only one at a time.
 * Each step is counted.
 */
public class Man extends BlockActor
{
    // Images that show the man walking up, down, left and right
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    private GreenfootImage imageDown;
    private GreenfootImage imageUp;

    // Field: the current direction of the man
    // the the static fields in BlockActor for definition
    private int direction;

    // Field: the number of steps taken so far.
    protected int nrOfSteps;
    private boolean IsPowerUp = false;
    private boolean IsPoisoned = false;
    private int PoisonTimeout = 0;
    private int PowerUpTimeout = 0;

    /**
     * Constructor. Make sure all images (up, down, left, right) are opened.
     * Initial direction is down
     */
    public Man () {
        imageLeft = new GreenfootImage("me_strip4_4.png");
        imageRight = new GreenfootImage("me_strip4_3.png");
        imageDown = new GreenfootImage("me_strip4_1.png");
        imageUp = new GreenfootImage("me_strip4_2.png");
        setImage(imageDown);
        direction = DOWN;
        nrOfSteps = 0;
    }

    /**
     * The player wants to move the man into a certain direction
     * Make sure the man can push a crate, but only one at a time.
     */
    private void wantsToMoveTo (int direction) {
        // hier moet de code komen om het mannetje de kratjes te laten verplaatsen.

        if (isFree(direction)) {
            moveTo(direction);
            nrOfSteps++;
        } else {
            Crate crate = getLinkToCrate(direction);
            if (!(crate == null)) {
                if (crate.isFree(direction)) {
                    crate.moveTo(direction);
                    moveTo(direction);
                    nrOfSteps++;
                }
            }
        }
       //moveTo(direction);
       showNumberOfSteps ();
    }

    /**
     * Act-method. Check if one of the arrow-keys is pressed
     * Then check if the all crates are in place.
     */
    public void act()
    {
       checkKeypress();
       checkGewonnen();
       checkTouching();
       Timers();
    }

    /**
     * Check to see if all crates are in place.
     */
    private void checkGewonnen(){
        ((SokoBanWorld)getWorld()).endOfLevel();
    }

    /**
     * Show the number of steps
     */
    private void showNumberOfSteps (){
        getWorld().showText ("Aantal stappen = " + nrOfSteps, 3, 0);
    }

    /**
     * Select the right image of the man based on the direction
     */
    private void setImage (int direction) {
        switch (direction) {
            case UP:
                setImage(imageUp);
                break;
            case DOWN:
                setImage(imageDown);
                break;
            case LEFT:
                setImage(imageLeft);
                break;
            case RIGHT:
                setImage(imageRight);
                break;
            default:
                break;
        }
    }

   /**
    * Check to see if the key is pressed
    */
   private void checkKeypress() {
        //String key = Greenfoot.getKey();
        int newDirection = -1;
        if (Greenfoot.isKeyDown("left")) {
           newDirection = LEFT;
        }
        if (Greenfoot.isKeyDown("right")) {
           newDirection = RIGHT;
        }
        if (Greenfoot.isKeyDown("up")) {
           newDirection = UP;
        }
        if (Greenfoot.isKeyDown("down")) {
           newDirection = DOWN;
        }

        // if one of the arrow keys has been pressed
        if (newDirection != -1) {
            // if the man was already in the same direction
            if (direction == newDirection){
                // see if we can move the man
                wantsToMoveTo(direction);
            }
            // the man wants to move in a new direction
            // change the image of the man
            else {
                setImage(newDirection);
                direction = newDirection;
            }
        }
   }

   private void checkTouching(){
     List<PowerUp> PowerUps = getIntersectingObjects(PowerUp.class);
     List<Bee> Bees = getIntersectingObjects(Bee.class);
     SokoBanWorld world = (SokoBanWorld) getWord();
     if ((PowerUps.size > 0) && (!IsPowerUp)) {
       PowerUp TPowerUp = PowerUps.get(0);
       world.removeObject(TPowerUp);
       IsPowerUp = true;
       PowerUpTimeout = 50;
     }
     if (Bees.size > 0) {
       Bee TBee = Bees.get(0);
       if (IsPowerUp){
         world.removeObject(TBee);
       } else {
         IsPoisoned = true;
         PoisonTimeout = 50;
       }
     }
   }

   private void Timers(){
      if (PowerUpTimeout > 0) {
        PowerUpTimeout--;
      } else if (PowerUpTimeout == 0){
        IsPowerUp = false;
      }
      if (IsPoisoned) {
        if (PoisonTimeout > 0) {
            //removeHealth(1);
            PoisonTimeout--;
        } else {
          IsPoisoned = false;
        }
      }
   }
 }
