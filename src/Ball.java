import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Item
{
    public Ball() {
        GreenfootImage bomb = new GreenfootImage("ball.png");
        bomb.scale(30, 30);
        setImage(bomb);
    }
    
    /**
    * @return object type
    */
    public String getType()
    {
        return "Ball";
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    // Power up touch 
    public void touched() {
        super.setScoreSpeed(10, 0);
    }
}
