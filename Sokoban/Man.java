import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
 }
