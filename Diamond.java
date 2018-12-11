
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Diamond extends Tile {

    public Diamond(String image, int width, int height) {
        super(image, width, height);
        GreenfootImage img = new GreenfootImage(image);
        img.scale(46, 36);
        setImage(img);
    }

    /**
     * Act - do whatever the Diamond wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }
}
