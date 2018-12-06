import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class START here.
 *
 * @author G. A
 * @version 0.2
 */
public class Start extends World {

    /**
     * Constructor for objects of class Start.
     *
     */
    SelectableLevel sl1 = new SelectableLevel("_lvl1.png", 0);
    GreenfootSound bgm = new GreenfootSound("sounds/bgm.wav");
    public Start() {
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");
        getWidth();
        showText("Invade Escape", 520, 100);
        prepare();
    }

    public void prepare() {
        addObject(sl1, 175, 300);
        // LevelButton levelButton = new LevelButton();
        // addObject(levelButton, 500, 400);
    }
    public void act() {
        if(Greenfoot.mouseClicked(sl1)) {
            bgm.stop();
        }
    }
}
