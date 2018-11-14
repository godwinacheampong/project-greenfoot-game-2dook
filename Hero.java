
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private boolean inAir;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }

    @Override
    public void act() {
        handleInput();

        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                // getWorld().removeObject(this);
                setLocation(300, 200);
                break;
            }
        }
    }

    public int acqX() {
        return this.getX();
    }

    public String getCoords() {
        return "X: " + this.getX() + " Y: " + this.getY();
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space")) {
            for (Tile tile : getIntersectingObjects(Tile.class)) {
                if (tile != null) {
                    inAir = false;
                    velocityY = -15;
                } else {
                    inAir = true;
                }
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -2;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 2;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
