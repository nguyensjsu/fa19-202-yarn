import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagicStatusDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicStatusDisplay extends DisplayComponent
{
    private MagicState.States currentStatus;
    public MagicStatusDisplay(){
        currentStatus = MagicState.States.OFF;
        setImage(new GreenfootImage("Status: " + currentStatus, 20, Color.WHITE, Color.BLACK));
    }
    /**
     * Act - do whatever the MagicStatusDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    public void updateMagicStatus(MagicState.States s){
        this.currentStatus = s;
        setImage(new GreenfootImage("Status: " + s.toString() , 20, Color.WHITE, Color.BLACK));
    }
}
