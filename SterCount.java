import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CopyOfSter here.
 * 
 * @author Godwin A. 
 * @version 0.1
 */
public class SterCount extends UI
{
    /**
     * Act - do whatever the CopyOfSter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getWorld().getObjects(Hero.class) == null) { return; } else {
        try {
            
                int sterren = getWorld().getObjects(Hero.class).get(0).getSter();
                getWorld().showText("x " + sterren, 950,33);
            } catch(IndexOutOfBoundsException e) {
           return;

        }
    }
    // getWorld().getObjects(Hero.class).get(0).getSter();
}    
}
