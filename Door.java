
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Door extends Tile {

    int worldNum;

    public Door(String image, int width, int height, int worldNum) {
        super(image, width, height);
        this.worldNum = worldNum;
    }

    public void act() {
        for (Actor hero : getIntersectingObjects(Hero.class)) {
            if (hero != null) {
                switch (this.worldNum) {
                    case 0:
                        Greenfoot.setWorld(new World2());
                        break;

                    // Greenfoot.setWorld(new World1());
                }
            }
        }
    }
}
