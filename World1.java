
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 *
 * @author R. Springer
 */
public class World1 extends World {

    private CollisionEngine ce;
    public String worldName = "World1";
    int heroSpawnX = 84;
    int heroSpawnY = 687;
    /* int[] star1 = {445, 733};
    int[] star2 = {789, 493};
    int[] star3 = {1683, 733}; */ // Sterren kunnen ook in de wereld worden geplaatst als Tiles.
    int resetX = 40;
    int resetY = 45;
    int star2SpawnXPos;
    int star2SpawnYPos;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public World1() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");

        int[][] map = {
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 10, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 75, 82, 82, -1, -1, -1, -1, -1, -1, -1, 82, 77, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 75, 76, 65, 65, 95, 95, 95, 95, 95, 95, 95, 65, 78, 77, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, 60},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, 75, 76, 65, 65, 65, 93, 93, 93, 93, 93, 93, 93, 65, 65, 78, 77, -1, -1, -1, -1, 98, -1, -1, -1, 132, 147, 147, 147, 147, 147, 147},
            {-1, -1, -1, -1, -1, -1, 63, -1, 75, 76, 65, 65, 65, 65, 93, 93, 93, 93, 93, 93, 93, 65, 65, 65, 78, 77, -1, 128, -1, 98, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {82, 82, 82, 82, 82, 82, 82, 82, 76, 65, 65, 65, 65, 65, 93, 93, 93, 93, 93, 93, 93, 65, 65, 65, 65, 78, 82, 82, 82, 82, 82, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 95, 95, 95, 95, 95, 95, 95, 95, 95},
        };

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
        /*addObject(new Ster(), star1[0], star1[1]);
        addObject(new Ster(), star2[0], star2[1]);
        addObject(new Ster(), star3[0], star3[1]);*/
        addObject(new SterCount(), 907, 30);
        addObject(new ResetButton(), resetX, resetY);

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
