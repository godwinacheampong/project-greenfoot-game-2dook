
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Door extends Tile {


    public Door(String image, int width, int height) {
        super(image, width, height);
    }

    public void act() {
        for (Hero hero : getIntersectingObjects(Hero.class)) {
            if (hero != null && hero.ster() == 3) {
                switch (hero.worldName) {
                    case "World1":
                        Greenfoot.setWorld(new World2());
                        break;
                    case "World2":
                         Greenfoot.setWorld(new Victory());
                         break;
                    default:
                          break;

                    // Greenfoot.setWorld(new World1());
                }
            }
        }
    }
}
