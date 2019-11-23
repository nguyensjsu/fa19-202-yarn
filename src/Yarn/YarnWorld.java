import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YarnWorld extends World
{
    private ScoreDisplay scoreDisplay;
    
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public YarnWorld()
    {    
        super(560, 560, 1); 
        prepare();
        scoreDisplay=new ScoreDisplay();
        addObject(scoreDisplay, 10, getHeight()-10);
        
    }
    public Counter getCounter()
    {
        return theCounter;
    }
    
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Bomb bomb = new Bomb();
        addObject(bomb,376,414);        
        Dog dog = new Dog();
        addObject(dog,108,228);
        Ball ball = new Ball();
        addObject(ball,367,138);
        Wall wall = new Wall();
        addObject(wall,367,444);
        dog.setLocation(130,202);
        WallVertical wallVertical = new WallVertical();
        addObject(wallVertical,130,202);
        dog.setLocation(131,188);
        wall.setLocation(345,444);
        bomb.setLocation(237,306);
        dog.setLocation(76,444);

        dog.setLocation(81,389);
    }
}
