
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResetButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ResetButton extends Mover {

    /**
     * Act - do whatever the ResetButton wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new World1());
            /*xf*/
            // getWorld().addObject(new GameOver(), 500, 200);
            // getWorld().removeObject();
        }

    }
}
