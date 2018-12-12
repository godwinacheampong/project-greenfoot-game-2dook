import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScherm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScherm extends World
{

    /**
     * Constructor for objects of class StartScherm.
     * 
     */
    public StartScherm()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        setBackground("StartSchermBG.jpg");
        showText("Invade Escape", getWidth() / 2, (getHeight() / 2) / 2);
        addObject(new StartBtn(), getWidth() / 2, ((getHeight() / 2) / 2) + 100);
    }
}
