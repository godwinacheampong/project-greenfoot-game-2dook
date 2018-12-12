import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public String worldName = "";
    public GameOverScreen(String worldName)
    {
        super(1000, 800, 1, false);
        this.setBackground("GOS.png");
        this.worldName = worldName;
        addObject(new HOME(), 200, 500);
        addObject(new ResetButton(worldName), 800, 500);
        // System.out.println(worldName);
        // LevelMap lm = new LevelMap();
    }
}
