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
    private MagicStateManager ms_manager;
    private MagicStatusDisplay magicStatusDisplay;

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
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        dog = new Dog();
        this.ms_manager = new MagicStateManager();
        this.magicStatusDisplay = new MagicStatusDisplay();
        this.ms_manager.attach(this.magicStatusDisplay);
        this.dog.setMagicM(ms_manager);
        addObject(this.magicStatusDisplay, 80, getHeight() - 10);
        addObject(dog,108,228);
        Bomb bomb = new Bomb();
        bomb.setDecorator(new PowerUpDecorator());
        addObject(bomb,376,414);        
        Ball ball = new Ball();
        ball.setDecorator(new PowerUpDecorator());
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
