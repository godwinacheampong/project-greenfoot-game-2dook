
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Enemy extends Mover {
    private String enemyName;
    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    public Enemy() {
        super();
        setImage("pokerMad.png");
        getImage().mirrorHorizontally();
        walkRange = 180;
        firstAct = true;
        speed = 1;
    }

    public Enemy(String enemyName) {
        super();
        this.enemyName = enemyName;
        if(enemyName.equals("Enemies/fireball")) {
            setImage(enemyName + ".png");
            // getImage().mirrorHorizontally();
            walkRange = 180;
            firstAct = true;
            speed = 1;
        } else {
            setImage(enemyName + ".png");
            getImage().mirrorHorizontally();
            walkRange = 180;
            firstAct = true;
            speed = 1;
        }
    }

    @Override
    public void act() {
        int x = getX();
        int y = getY();

        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }

        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
            getImage().mirrorHorizontally();
        } else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
            getImage().mirrorHorizontally();
        }
    }
}
