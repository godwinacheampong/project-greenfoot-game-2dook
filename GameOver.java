
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Actor {

    /**
     * Act - do whatever the GameOver wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GameOver() {
        setImage(new GreenfootImage("Game Over. Druk op F om het level te resetten.", 48, Color.WHITE, Color.BLACK));
        //getWorld().removeObjects(getWorld().getObjects(Hero.class));

    }

    public void act() {
        if (Greenfoot.isKeyDown("F")) {
            Greenfoot.setWorld(new World1());
        }
    }
}
