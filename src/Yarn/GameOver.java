import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    int score;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int counter)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 560, 1); 
        score=counter;
        showText("GAME OVER\n\n Score = "+score+"\n\nPress n for new game", getWidth()/2, getHeight()/2);
        
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("n"))
        {
           YarnWorld yarnworld = new YarnWorld();
           Greenfoot.setWorld(yarnworld);
        }
    }
}
