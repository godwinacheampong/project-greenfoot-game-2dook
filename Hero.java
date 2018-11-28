
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
    int charNum;
    private int ster;

    public int direction = 2;
    public int animationTimer = 0;
    public int PicNum = 1;

    /*
    ID: 0 -> Groene hero
    ID: 1 -> Blauwe hero
    ID: 2 -> Roze hero
     */
    public Hero(String worldName, int charNum) {
        super();
        gravity = 8;
        acc = 0.6;
        drag = 0.8;
        // setImage("p" + charNum + "_front.png");
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
        getWorld().getObjects(Hero.class).get(0).setImage(new GreenfootImage(1, 1));
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

    public boolean keySpace() {
        boolean keySpace = Greenfoot.isKeyDown("space");
        return keySpace;
    }

    public boolean keyRight() {
        boolean keyRight = Greenfoot.isKeyDown("right");
        return keyRight;
    }

    public boolean keyLeft() {
        boolean keyLeft = Greenfoot.isKeyDown("left");
        return keyLeft;
    }

    public void animatieStanding() {
        if (keySpace() == false && keyLeft() == false && keyRight() == false && velocityY == 0) {
            setImage("alien" + charNum + "_stand" + direction + ".png");
        }
    }

    public void animatieJump() {
        if (velocityY != 0) {
            setImage("alien" + charNum + "_jump" + direction + ".png");
        }
    }

    public boolean opGrond() {
        Actor onder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Tile.class);
        Tile tile = (Tile) onder;
        return tile != null && tile.isSolid == true;
    }

    public void handleInput() {
        animatieStanding();
        animatieJump();
        if (keySpace() && opGrond() == true) {
            velocityY = -14;
        } else if (Greenfoot.isKeyDown("up") && opGrond() == true) {
            velocityY = -14;
        }

        if (keyLeft() && keyRight() == false) {
            velocityX = -4;
            direction = 1;
            if (animationTimer % 10 == 0 && velocityY == 0) {
                animatie();
            }
            animationTimer++;

        } else if (keyRight()) {
            velocityX = 4;
            direction = 2;
            if (animationTimer % 10 == 0 && velocityY == 0) {
                animatie();
            }
            animationTimer++;
        }
    }

    /* public void frames2() {
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
    } */
 /*
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
    } */
    public void animatie() {

        if (PicNum == 1) {
            setImage("alien" + charNum + "_walk" + direction + "1.png");
        } else if (PicNum == 2) {
            setImage("alien" + charNum + "_walk" + direction + "2.png");
            PicNum = 1;
            return;
        }
        PicNum++;
    }

    public int getSter() {
        return this.ster;
    }

    public void ster() {
        if (isTouching(Ster.class)) {
            removeTouching(Ster.class);
            ster++;
        }
    }

    public void key() {
        if (isTouching(KeySpawnable.class)) {
            removeTouching(KeySpawnable.class);
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
