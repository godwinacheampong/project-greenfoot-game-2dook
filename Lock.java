import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lock here.
 * 
 * @author Godwin A. 
 * @version 0.1
 */
public class Lock extends Tile
{
    String kleur;
    /**
     * Act - do whatever the lock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Lock(String image, int width, int height, String kleur) {
        super(image, width, height);
        this.kleur = kleur;
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
