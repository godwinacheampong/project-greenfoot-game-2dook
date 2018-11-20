import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CopyOfSter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SterCount extends UI
{
    /**
     * Act - do whatever the CopyOfSter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       int sterren = getWorld().getObjects(Hero.class).get(0).getSter();
       getWorld().showText("x " + sterren, 950,33);
       // getWorld().getObjects(Hero.class).get(0).getSter();
    }    
}
