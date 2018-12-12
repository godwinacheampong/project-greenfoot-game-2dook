import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HOME here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HOME extends Mover
{
    /**
     * Act - do whatever the HOME wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HOME() {
        GreenfootImage img = new GreenfootImage("home.png");
        img.scale(400,400);
        setImage(img);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
         Greenfoot.setWorld(new StartScherm());   
        }
    }    
}
