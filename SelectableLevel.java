import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectableLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectableLevel extends Mover
{
    /**
     * Act - do whatever the SelectableLevel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int num;
    public SelectableLevel(int num) {
        this.num = num;
        switch(num) {
            case 1:
            setImage("1.png");
            break;
            case 2: 
            setImage("2.png");
            break;
            default:
            break;
        }
    }

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            switch(num)
            {
                case 1:
                Greenfoot.setWorld(new World1());
                break;
                
                case 2:
                Greenfoot.setWorld(new World2());
                break;
                
                default:
                break;
            }
        }    
    }
}
