import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamant extends Tile
{
    
    public Diamant(String image, int width, int height) {
        super(image, width, height);
        GreenfootImage img = new GreenfootImage(image);
        img.scale(30, 30);
        setImage(img);
    }
    /**
     * Act - do whatever the Diamant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
