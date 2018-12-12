import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EZRESET here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EZRESET extends Mover
{
    /**
     * Act - do whatever the EZRESET wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public EZRESET() {
        GreenfootImage img = new GreenfootImage(this.getImage());
        img.scale(100, 100);
        setImage(img);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) { Greenfoot.setWorld(new World2()); }
    }    
}
