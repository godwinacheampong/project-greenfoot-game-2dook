import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ster here.
 * 
 * @author Godwin A. 
 * @version 0.1
 */
public class Ster extends Tile
{
    /**
     * Act - do whatever the Ster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Ster(String image, int width, int heigth) {
        super(image, width, heigth);
    }
    public void act() 
    {
        for (Hero hero : getIntersectingObjects(Hero.class)) {
            if (hero != null) {
                // getWorld().removeObject(this);
                // getWorld().addObject(new GameOver(), 500, 200);
                // getWorld().removeObject(this);
                // setLocation(300, 200);
                break;
            }
        }
    }    
}
