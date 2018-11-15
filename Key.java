
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Key extends Mover {

    /**
     * Act - do whatever the Key wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    String keyType;

    public Key Key(String keyColor) {
        switch (keyColor) {
            case "Red":
                setImage("keyRed.png");
                this.keyType = keyColor;
                break;
            case "Green":
                setImage("keyGreen.png");
                this.keyType = keyColor;
                break;
            case "Blue":
                setImage("keyBlue.png");
                this.keyType = keyColor;
                break;
            case "Yellow":
                setImage("keyYellow.png");
                this.keyType = keyColor;
                break;
            default:
                break;

        }
        return this;
    }

    public void act() {
        // Add your action code here.
    }
}
