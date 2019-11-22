import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedDisplay extends DisplayComponent
{
    private int speed;
    public SpeedDisplay(){
        this.speed = 0;
        Color trans = new Color(0,0,0,0);
        setImage(new GreenfootImage("Speed: " + speed, 20, Color.BLACK, trans));
    }
    /**
     * Act - do whatever the SpeedDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void updateScoreSpeed(int update_score, int update_speed){
        speed = update_speed;
        Color trans = new Color(0,0,0,0);
        setImage(new GreenfootImage("Speed: " + speed, 20, Color.BLACK, trans));
    }   
    public void updateSpeed(int update_speed){
        speed = update_speed;
        Color trans = new Color(0,0,0,0);
        setImage(new GreenfootImage("Speed: " + speed, 20, Color.BLACK, trans));
    } 
}
