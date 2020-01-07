
import greenfoot.*;
import java.util.List;

public class Hero extends Mover {

    public Data heroData;
    // Stats
    private final double gravity;
    private final double acc;
    private final double drag;
    int charNum;
    private int ster;
    // Data
    public boolean alive = true;
    public String worldName;
    // private boolean inAir;
    public int direction = 2;
    public int animationTimer = 0;
    public int PicNum = 1;

    // Inventory
    public boolean hasRedKey;
    public boolean hasBlueKey;
    public boolean hasGreenKey;
    public boolean hasYellowKey;
    public boolean hasDiamond;
    // Sounds    
    GreenfootSound coinCollect = new GreenfootSound("sounds/star.wav");
    GreenfootSound keyCollect = new GreenfootSound("sounds/key.wav");
    GreenfootSound jmp = new GreenfootSound("sounds/jump.wav");
    GreenfootSound bgm = new GreenfootSound("sounds/bgm.wav");

    // Misc
    /*
    ID: 1 -> Groene hero
    ID: 2 -> Blauwe hero
    ID: 3 -> Roze hero // Klein en langzaam
     */
    public Hero(String worldName, int charNum) {
        super();
        adjustVolume();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        this.worldName = worldName;
        this.charNum = charNum;
        bgm.play();
    }

    @Override
    public void act() {
        handleInput();
        ster();
        door();
        key();
        customGedrag();
        _float();
        unlock();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        checkForIntersectingObjects();
    }

    public void customGedrag() {

        if (charNum == 3) {
            GreenfootImage img = new GreenfootImage(this.getImage());
            img.scale(40, 50);
            setImage(img);
        }
    }
    public void get3() {
        ster = 3;
    }
    public void _float() {
        if (isTouching(Platform.class)) {
            velocityY = -2;
            if (keySpace() || keyUp()) {
                velocityY = -15;
            }
        }
    }

    public void checkForIntersectingObjects() {
        for (Diamond dt : getIntersectingObjects(Diamond.class)) {
            if (dt != null) {
                List<Display> displays = getWorld().getObjects(Display.class);
                for (int i = 0; i < displays.size(); i++) {
                    if (displays.get(i).dispname.equals("DiamondHUD")) {
                        displays.get(i).setImage("HUD/hud_gem_blue.png");
                        coinCollect.play();
                        getWorld().removeObject(dt);
                    }
                }
            }
        }
        for (WaterTop wt : getIntersectingObjects(WaterTop.class)) {
            if (wt != null) {
                Greenfoot.setWorld(new GameOverScreen(this.worldName));
                // getWorld().removeObject(this);
                break;
            }
        }
        for (LavaTop lt : getIntersectingObjects(LavaTop.class)) {
            if (lt != null) {
                Greenfoot.setWorld(new GameOverScreen(this.worldName));
              //  getWorld().removeObject(this);
                break;
            }
        }
        for (Rope rp : getIntersectingObjects(Rope.class)) {
            if (rp != null) {
                if (keySpace() || keyUp()) {
                    velocityY = -7;
                } else if (Greenfoot.isKeyDown("down")) {
                    velocityY = 7;
                }
            }
        }
        for (Teleporter tp : getIntersectingObjects(Teleporter.class)) {
            if (tp != null) {
                setLocation(1900, 2200);
            }
        }
        for (Teleporter2 tp2 : getIntersectingObjects(Teleporter2.class)) {
            if (tp2 != null) {
                setLocation(2800, 500);
            }
        }
        for (Enemy enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                if (alive) {
                    alive = false;
                    Greenfoot.setWorld(new GameOverScreen(this.worldName));

                    // getWorld().removeObject(this);
                }
                // setLocation(300, 200);
                break;
            }
        }
    }

    public boolean keyUp() {
        return Greenfoot.isKeyDown("up");
    }

    public void unlock() {
        List<Lock> locks = this.getNeighbours(100, true, Lock.class);
        if (!locks.isEmpty()) {
            for (int i = 0; i < locks.size(); i++) {
                if (hasRedKey && locks.get(i).kleur == "RED") {
                    locks.get(i).setLocation(1000, 1000);
                } else if (hasBlueKey && locks.get(i).kleur == "BLUE") {
                    locks.get(i).setLocation(1000, 1000);
                } else {
                    // System.out.println("No key.");
                }
            }
        }
    }

    public void hideHero() {
        this.setImage(new GreenfootImage(1, 1));
    }

    public void door() {
        for (Door d1 : getIntersectingObjects(Door.class)) {
            if (d1 != null) {
                switch(this.worldName)
                {
                 case "World1":
                 Greenfoot.setWorld(new World2());
                 break;
                 case "World2":
                 Greenfoot.setWorld(new LevelSelect());
                 break;
            }
        }
    }
}

    public void adjustVolume() {
        keyCollect.setVolume(85);
        bgm.setVolume(45);
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
            switch (charNum) {
                case 1:
                    velocityY = -15; // MOET NOG VERANDERD WORDEN
                    jmp.play();
                    break;
                case 2:
                    velocityY = -15; // MOET NOG VERANDERD WORDEN
                    jmp.play();
                    break;
                case 3:
                    velocityY = -10; // MOET NOG VERANDERD WORDEN
                    jmp.play();
                    break;
            }
        } else if (Greenfoot.isKeyDown("up") && opGrond()) {
            jmp.play();
            velocityY = -15;

        }
        if (Greenfoot.isKeyDown("h")) { // Vliegen (Debug)
            velocityY = -15;
        }
        if (keyLeft() && !keyRight()) {
            switch (charNum) {
                case 1:
                    velocityX = -4;
                    direction = 1;
                    if (animationTimer % 10 == 0 && velocityY == 0) {
                        animatie();
                    }
                    animationTimer++;
                    break;
                case 2:
                    velocityX = -2;
                    direction = 1;
                    if (animationTimer % 10 == 0 && velocityY == 0) {
                        animatie();
                    }
                    animationTimer++;
                    break;
                case 3:
                    velocityX = -1;
                    direction = 1;
                    if (animationTimer % 10 == 0 && velocityY == 0) {
                        animatie();
                    }
                    animationTimer++;
                    break;

                default:
                    break;
            }

        } else if (keyRight()) {
            switch (charNum) {

                case 1:
                    velocityX = 4;
                    direction = 2;
                    if (animationTimer % 10 == 0 && velocityY == 0) {
                        animatie();
                    }
                    animationTimer++;
                    break;
                case 2:
                    velocityX = 2;
                    direction = 2;
                    if (animationTimer % 10 == 0 && velocityY == 0) {
                        animatie();
                    }
                    animationTimer++;
                case 3:
                    velocityX = 1;
                    direction = 2;
                    if (animationTimer % 10 == 0 && velocityY == 0) {
                        animatie();
                    }
                    animationTimer++;

                default:
                    break;
            }
        }
    }

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

    public int ster() {
        if (isTouching(Ster.class)) {
            removeTouching(Ster.class);
            coinCollect.play();
            getWorld().getObjects(SterCount.class).get(0).starsCollected++;
        }
        return this.ster;
    }

    public void key() {
        for (Key kn : getIntersectingObjects(Key.class)) {
            if (kn != null) {
                switch (kn.keyColor) {

                    case "RED":
                        hasRedKey = true;
                        keyCollect.play();
                        removeTouching(Key.class);
                        break;

                    case "GREEN":
                        hasGreenKey = true;
                        keyCollect.play();
                        removeTouching(Key.class);
                        break;

                    case "BLUE":
                        hasBlueKey = true;
                        keyCollect.play();
                        removeTouching(Key.class);
                        break;

                    default:
                        System.out.println("No key color specified in constructor. Check Key.java");
                }
            }
        }
        for (KeySpawnable ks : getIntersectingObjects(KeySpawnable.class)) {
            if (ks != null) {
                switch (ks.keyColor) {

                    case "RED":
                        hasRedKey = true;
                        keyCollect.play();
                        removeTouching(KeySpawnable.class);
                        break;

                    case "GREEN":
                        hasGreenKey = true;
                        keyCollect.play();
                        removeTouching(KeySpawnable.class);
                        break;
                    case "BLUE":
                        hasBlueKey = true;
                        keyCollect.play();
                        removeTouching(KeySpawnable.class);
                        break;

                    default:
                        System.out.println("No key color specified in constructor. Check KeySpawnable.java");
                }
            }
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
