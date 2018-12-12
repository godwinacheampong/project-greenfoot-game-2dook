
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 *
 * @author R. Springer
 */
public class World1 extends World {

   // public int starsCollected = 0;
    private CollisionEngine ce;
    public String worldName = "World1";
    int heroSpawnX = 84;
    int heroSpawnY = 687;
    int KEY_HUD_X = 25;
    int KEY_HUD_Y = 760;
    int DIAMOND_HUD_X = 950;
    int DIAMOND_HUD_Y = 760;
    int resetBtnX = 882;
    int resetBtnY = 740;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public World1() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");

        int[][] map = {
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 10, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, 243},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 257, 264, 264, 264, -1, -1, -1, -1, -1, -1, -1, 264, 264, 259, -1, -1, -1, -1, -1, 186, -1, -1, -1, -1, -1, -1, -1, -1, -1, 242},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, 257, 258, 286, 286, 286, 277, 277, 277, 277, 277, 277, 277, 286, 286, 260, 259, -1, -1, -1, -1, 280, -1, -1, -1, 310, 323, 323, 323, 323, 323, 323},
            {-1, -1, -1, -1, -1, -1, -1, -1, 257, 258, 247, 286, 286, 286, 275, 275, 275, 275, 275, 275, 275, 286, 286, 286, 260, 259, -1, -1, -1, 280, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 257, 258, 286, 286, 286, 286, 286, 275, 275, 275, 275, 275, 275, 275, 286, 286, 286, 247, 260, 259, -1, -1, 280, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {264, 264, 264, 264, 264, 264, 264, 258, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 286, 260, 264, 264, 264, 264, 277, 277, 277, 277, 277, 277, 277, 277, 277},};
        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declareren en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero("World1", 1);
        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);
        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(hero, heroSpawnX, heroSpawnY);

        addObject(new SterCount(), 907, 30);
        // addObject(new ResetButton(), resetBtnX, resetBtnY);
        addObject(new Display(KEY_HUD_X + 20, KEY_HUD_Y, "HUD/hud_keyRed_disabled.png", "RedKeyHUD"), 0, 0);
        addObject(new Display(KEY_HUD_X + 80, KEY_HUD_Y, "HUD/hud_keyGreen_disabled.png", "GreenKeyHUD"), 0, 0);
        addObject(new Display(KEY_HUD_X + 140, KEY_HUD_Y, "HUD/hud_keyBlue_disabled.png", "BlueKeyHUD"), 0, 0);
        addObject(new Display(DIAMOND_HUD_X, DIAMOND_HUD_Y, "HUD/hud_x.png", "DiamondHUD"), 0, 0);
        //   addObject(new Enemy(), 1170, 410);
        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
    }

    @Override
    public void act() {
        ce.update();
    }
}
