
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 *
 * @author Godwin A.
 * @version 0.1
 */
public class KeySpawnable extends Mover {

    String keyColor;

    public KeySpawnable(String keyColor) {
        this.keyColor = keyColor;
        switch (this.keyColor) {
            case "GREEN":
                this.setImage("keyGreen.png");
                break;
            case "RED":
                this.setImage("keyRed.png");
                break;
            case "BLUE":
                this.setImage("keyBlue.png");
                break;

            default:
                break;
        }
    }

    /**
     * Act - do whatever the Key wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        applyVelocity();
    }
}
