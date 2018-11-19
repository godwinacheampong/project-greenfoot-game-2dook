
import greenfoot.Actor;

/**
 * Write a description of class randomBlockTile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomBlockTile extends Tile {

    // instance variables - replace the example below with your own
    private boolean keyUsed;

    /**
     * Constructor for objects of class randomBlockTile
     */
    public RandomBlockTile(String image, int width, int heigth) {
        super(image, width, heigth);
    }

    public void act() {
        if (!keyUsed) {
            for (Actor hero : getIntersectingObjects(Hero.class)) {
                if (hero != null) {
                    getWorld().addObject(new Key(), 1301, 493);
                    keyUsed = true;
                    break;
                }
            }
        }
    }
}
