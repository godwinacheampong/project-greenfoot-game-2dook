
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterCoin here.
 *
 * @author G. A
 * @version 0.1
 */
public class CharacterCoin extends Mover {

    /**
     * Act - do whatever the CharacterCoin wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    int switchTo;
   // String kleur;
    /*
    ID: 0 -> Groene hero
    ID: 1 -> Blauwe hero
    ID: 2 -> Roze hero
     */
    public CharacterCoin(int switchToHeroNum) {
        switch (switchToHeroNum) {
            case 0:
                this.switchTo = switchToHeroNum;
                break;

            case 1:
                this.switchTo = switchToHeroNum;
                this.setImage(filename);
                break;

            case 2:
                this.switchTo = switchToHeroNum;
                break;

            default:
                break;
        }
    }

    public void act() {
        // Add your action code here.
    }
}
