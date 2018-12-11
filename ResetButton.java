
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResetButton here.
 *
 * @author Godwin A.
 * @version 0.1
 */
public class ResetButton extends UI {

    /**
     * Act - do whatever the ResetButton wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ResetButton() {
        GreenfootImage img = new GreenfootImage(this.getImage());
        img.scale(200, 100);
        setImage(img);
    }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            // getWorld().addObject(new GameOver(), 500, 200);
        }

    }
}
