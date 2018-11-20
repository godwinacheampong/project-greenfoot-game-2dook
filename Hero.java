
import greenfoot.*;
import java.util.List;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public String worldName;
    private boolean inAir;
    public boolean hasRedKey;
    public boolean hasBlueKey;
    public boolean hasGreenKey;
    public boolean hasYellowKey;
    private int ster;

    public Hero(String worldName) {
        super();
        gravity = 8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        this.worldName = worldName;
    }

    @Override
    public void act() {
        // setImage("v");
        handleInput();
        ster();
        door();
        key();
        // unlockRed();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        List<Lock> locks = this.getNeighbours(100, true, Lock.class);
        // System.out.println(locks.size());
        if (this.hasRedKey && !locks.isEmpty()) {
            // locks.get(0).isSolid = false;
            for (int i = 0; i < locks.size(); i++) {
                locks.get(i).setLocation(1000, 1000);
            }
        }

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                // getWorld().removeObject(this);
                getWorld().addObject(new GameOver(), 500, 200);
                getWorld().removeObject(this);
                // setLocation(300, 200);
                break;
            }
        }
        for (WaterTop wt : getIntersectingObjects(WaterTop.class)) {
            if (wt != null) {
                getWorld().addObject(new GameOver(), 500, 200);
                getWorld().removeObject(this);
                break;
            }
        }

    }

    public void door() {
        for (Door d1 : getIntersectingObjects(Door.class)) {
            if (d1 != null) {
                System.out.println(d1);
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
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("up")) {
            for (Actor hero : getIntersectingObjects(JumpTile.class)) { // Normaal springen
                if (hero != null) {
                    inAir = false;
                    velocityY = -20;
                } else {
                    inAir = true;
                }
            }
        }
        if (Greenfoot.isKeyDown("k")) { // Vliegen
            velocityY = -10;
        }
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            velocityX = -2;
        } else if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            velocityX = 2;
        }
    }

    public int getSter() {
        return this.ster;
    }

    public int ster() {
        if (isTouching(Ster.class)) {
            removeTouching(Ster.class);
            ster++;
        }
        return ster;
    }

    public void key() {
        if (isTouching(Key.class)) {
            removeTouching(Key.class);
            hasRedKey = true;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
