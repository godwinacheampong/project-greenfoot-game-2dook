
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
    public int frame = 1;
    public int jumpFrame = 1;
    public boolean hasYellowKey;
    int charNum;
    private int ster;

    public Hero(String worldName, int charNum) {
        super();
        gravity = 8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        this.worldName = worldName;
        this.charNum = charNum;
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

    public void hideHero() {
        getWorld().getObjects(Hero.class).get(0).setImage(new GreenfootImage(1,1));
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
        for (Actor hero : getIntersectingObjects(JumpableTiles.class)) {
            if (Greenfoot.isKeyDown("space")) {
                inAir = true;
                velocityY = -14;
                setImage("p" + charNum + "_jump.png");
            } else {
                inAir = false;
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -4;
            frames2();
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 4;
            frames();
        }
    }

    public void frames2() {
        if (frame == 1) {
            setImage("p" + charNum + "_walk2_01.png");
        }
        if (frame == 2) {
            setImage("p" + charNum + "_walk2_02.png");
        }
        if (frame == 3) {
            setImage("p" + charNum + "_walk2_03.png");
        }
        if (frame == 4) {
            setImage("p" + charNum + "_walk2_04.png");
        }
        if (frame == 5) {
            setImage("p" + charNum + "_walk2_05.png");
        }
        if (frame == 6) {
            setImage("p" + charNum + "_walk2_06.png");
        }
        if (frame == 7) {
            setImage("p" + charNum + "_walk2_07.png");
        }
        if (frame == 8) {
            setImage("p" + charNum + "_walk2_08.png");
        }
        if (frame == 9) {
            setImage("p" + charNum + "_walk2_09.png");
        }
        if (frame == 10) {
            setImage("p" + charNum + "_walk2_10.png");
        }
        if (frame == 11) {
            setImage("p" + charNum + "_walk2_11.png");
            frame = 1;
            return;
        }
        frame++;
    }

    public void frames() {
        if (frame == 1) {
            setImage("p" + charNum + "_walk01.png");
        }
        if (frame == 2) {
            setImage("p" + charNum + "_walk02.png");
        }
        if (frame == 3) {
            setImage("p" + charNum + "_walk03.png");
        }
        if (frame == 4) {
            setImage("p" + charNum + "_walk04.png");
        }
        if (frame == 5) {
            setImage("p" + charNum + "_walk05.png");
        }
        if (frame == 6) {
            setImage("p" + charNum + "_walk06.png");
        }
        if (frame == 7) {
            setImage("p" + charNum + "_walk07.png");
        }
        if (frame == 8) {
            setImage("p" + charNum + "_walk08.png");
        }
        if (frame == 9) {
            setImage("p" + charNum + "_walk09.png");
        }
        if (frame == 10) {
            setImage("p" + charNum + "_walk10.png");
        }
        if (frame == 11) {
            setImage("p" + charNum + "_walk11.png");
            frame = 1;
            return;
        }
        frame++;
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
