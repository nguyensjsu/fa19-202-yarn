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
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public YarnWorld()
    {    
        super(560, 560, 1); 
        prepare();
        theCounter=new Counter();
        addObject(theCounter, 10, getHeight()-10);
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
        dog = new Dog();
        addObject(dog,108,228);
        bomb = new Bomb(MagicState.States.UP);
        addObject(bomb,376,414);        
        ball = new Ball(MagicState.getRandomState());
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
