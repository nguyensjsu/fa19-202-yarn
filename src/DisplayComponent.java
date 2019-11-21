import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;

/**
 * Write a description of class DisplayComponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayComponent extends Actor implements ITouchObserver
{
    /**
     * Act - do whatever the DisplayComponent wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    /**
     * Constructor for objects of class DisplayComponet
     */
    public DisplayComponent()
    {
    }

    /**
     * update speed and score
     * to be overrideed
     */ 
    public void updateScoreSpeed(int update_score, int update_speed)
    {
    }
    

}
