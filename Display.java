
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class display here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Display extends UI {

    String dispname;

    /**
     * Act - do whatever the display wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Display(int x, int y, String img, String dispname) {
        this.dispname = dispname;
        setLocation(x, y);
        setImage(img);
    }

    public void act() {
        List<Display> displays = getWorld().getObjects(Display.class);
        switch (dispname) {
            case "RedKeyHUD":
                for (int i = 0; i < displays.size(); i++) {
                    if (displays.get(i).dispname == "RedKeyHUD" && getWorld().getObjects(Hero.class).get(0).hasRedKey) {
                        displays.get(i).setImage("HUD/hud_keyRed.png");
                    }
                }
            case "GreenKeyHUD":
                for (int i = 0; i < displays.size(); i++) {
                    if (displays.get(i).dispname == "GreenKeyHUD" && getWorld().getObjects(Hero.class).get(0).hasGreenKey) {
                        displays.get(i).setImage("HUD/hud_keyGreen.png");
                    }
                }
            case "BlueKeyHUD":
                for (int i = 0; i < displays.size(); i++) {
                    if (displays.get(i).dispname.equals("BlueKeyHUD") && getWorld().getObjects(Hero.class).get(0).hasBlueKey) {
                        displays.get(i).setImage("HUD/hud_keyBlue.png");
                    }
                }
            case "DiamondHUD":
                for (int i = 0; i < displays.size(); i++) {
                    if (displays.get(i).dispname.equals("DiamondHUD") && getWorld().getObjects(Hero.class).get(0).hasDiamond) {
                        displays.get(i).setImage("HUD/hud_gem_blue.png");
                    }
                }
        }

    }
}
