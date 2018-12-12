
import greenfoot.Actor;

/**
 * Write a description of class randomBlockTile here.
 *
 * @author Godwin A.
 * @version 0.1
 */
public class RandomBlockTile extends JumpableTiles {

    // instance variables - replace the example below with your own
    private boolean keyUsed;

    /**
     * Constructor for objects of class randomBlockTile
     */
    public RandomBlockTile(String image, int width, int height) {
        super(image, width, height);
    }

    public void act() {
        if (!keyUsed) {
            for (Hero hero : getIntersectingObjects(Hero.class)) {
                if (hero != null) {
                    switch(hero.worldName) {
                        case "World1":
                        getWorld().addObject(new KeySpawnable("RED"), 1300,1455);
                        keyUsed = true;
                        break;
                        case "World2":
                        break;

                    }
                }
            }
        }
    }
}
