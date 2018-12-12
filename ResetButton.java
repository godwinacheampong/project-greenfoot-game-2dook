
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
     */String worldN;
     
     
     public ResetButton() {
         try {
        this.worldN = getWorld().getObjects(Hero.class).get(0).worldName;
    }catch(Exception e) {
    } finally { this.worldN = ""; }
        
        GreenfootImage img = new GreenfootImage(this.getImage());
        img.scale(200, 100);
        setImage(img);
    }
    public ResetButton(String worldN) {
        this.worldN = worldN;
        GreenfootImage img = new GreenfootImage(this.getImage());
        img.scale(200, 100);
        setImage(img);
    }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            switch(worldN) {
                case "World1":
            Greenfoot.setWorld(new World1());
            break;
            case "World2":
            Greenfoot.setWorld(new World2());
            break;
            default: 
            Greenfoot.setWorld(new World1());
        }
    }
  }
}
