import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectableLevel here.
 * 
 * @author Godwin A. 
 * @version 0.1
 */
public class SelectableLevel extends Actor
{
    int worldNumber;
    /**
     * Act - do whatever the SelectableLevel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public SelectableLevel(String image, int worldNumber) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(300, 200);
        setImage(img);   
    }

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            switch(worldNumber) {
                case 0:
                Greenfoot.setWorld(new World1());
                break;
                case 1:
                Greenfoot.setWorld(new World2());
                break;

                default:
                break;
            }
        }
    }
}    

