import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YarnWorld extends World
{
    private Counter theCounter;
    private Dog dog;
    private Ball ball;
    private Bomb bomb;
    private ScoreDisplay scoreDisplay;
    private MagicStatusDisplay magicStatusDisplay;
    private SpeedDisplay speedDisplay;
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public YarnWorld()
    {    
        super(560, 560, 1);
        theCounter=new Counter();
        prepare();
        ball.attachObserver(scoreDisplay);
        
        //addObject(theCounter, 10, getHeight()-10);
    }
    
    public Counter getCounter()
    {
        return theCounter;
    }
    public Dog getDog() {
        return dog;
    }
    public Ball getBall() {
        return ball;
    }
    public Bomb getBomb() {
        return bomb;
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        this.magicStatusDisplay = new MagicStatusDisplay();
        scoreDisplay = new ScoreDisplay();
        speedDisplay = new SpeedDisplay();
        addObject(scoreDisplay, 30, getHeight()-10);
        addObject(speedDisplay, 210, getHeight()-10);
        addObject(this.magicStatusDisplay, 120, getHeight() - 10);
        dog = new Dog(scoreDisplay, speedDisplay, magicStatusDisplay);
        addObject(dog,108,228);
        bomb = new Bomb(MagicState.States.OFF, dog.speed+dog.speedUpdate, theCounter.getTotalCount());
        addObject(bomb,376,414);        
        ball = new Ball(MagicState.States.OFF, dog.speed+dog.speedUpdate, theCounter.getTotalCount());
        
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
