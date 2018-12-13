import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{

    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    public LevelSelect()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        setBackground("SLBG.png");
        showText("Selecteer het level die je wilt spelen.", getWidth() / 2, getHeight() / 2 - 300);
        addObject(new SelectableLevel(1), getWidth() / 2 - 100, getHeight() / 2 - 200);
        addObject(new SelectableLevel(2), getWidth() / 2 + 75, getHeight() / 2 - 200);
        
    }
}
