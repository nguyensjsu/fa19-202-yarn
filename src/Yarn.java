import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yarn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yarn extends Actor
{
    public Yarn() {
        GreenfootImage yarnImage = new GreenfootImage(50, 50);
        yarnImage.setColor(Color.BLUE);
        yarnImage.fill();
        setImage(yarnImage);
    }
    /**
     * Act - do whatever the Yarn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(3);
        if (Greenfoot.isKeyDown("Down")) {
            setRotation(90);
        } 
        if (Greenfoot.isKeyDown("Up")) {
            setRotation(270);
        }
        if (Greenfoot.isKeyDown("Left")) {
            setRotation(180);
        }
        if (Greenfoot.isKeyDown("Right")) {
            setRotation(0);
        }
    }    
}
