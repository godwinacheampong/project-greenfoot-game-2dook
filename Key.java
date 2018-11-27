
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 *
 * @author Godwin A.
 * @version 0.1
 */
public class Key extends Tile {
    
    String keyColor;
    /**
     * Act - do whatever the Key wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    public Key(String image, int width, int height, String keyColor) {
        super(image,width,height);   
        this.keyColor = keyColor;
    }

    public void act() {
        // applyVelocity();
    }
}
