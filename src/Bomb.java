import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Item
{
    public Bomb() {
        GreenfootImage bomb = new GreenfootImage("bomb.png");
        bomb.scale(56, 56);
        setImage(bomb);
    }
    
    /**
    * @return object type
    */
    public String getType()
    {
        return "Bomb";
    }  
    
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }

    // Object touch function
    public void touched() {
       super.setScoreSpeed(-10, 2);
    
    }
}
