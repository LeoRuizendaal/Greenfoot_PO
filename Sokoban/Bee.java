import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends BlockActor
{
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int direction = UP;
    public int mode = 0;
    static final int HORIZ = 0;
    static final int VERTI = 1;
    static final int LOOP = 2;
    public void act() 
    {
        switch (mode){
            case HORIZ:
            break;
            case VERTI:
                if (isFree(direction)){
                    moveTo(direction);
                } else {
                    switch (direction) {
                        case UP: direction = DOWN;
                        break;
                        case DOWN: direction = UP;
                        break;
                    }
                }
            break;
            case LOOP:
            break;
        }
    }    
}
