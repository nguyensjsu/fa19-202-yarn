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
        Color trans = new Color(0,0,0,0);
        setImage(new GreenfootImage("Status: " + currentStatus, 20, Color.BLACK, trans));
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
        Color trans = new Color(0,0,0,0);
        setImage(new GreenfootImage("Status: " + s.toString() , 20, Color.BLACK, trans));
    }  
}
