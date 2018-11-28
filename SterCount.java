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

        getWorld().showText("x " + getWorld().getObjects(Hero.class).get(0).getSter(), 950,33);

    }    
}

