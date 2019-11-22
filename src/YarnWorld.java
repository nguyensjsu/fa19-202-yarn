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
    private ScoreDisplay scoreDisplay;
    private Dog dog;
    private Ball ball;
    private Bomb bomb;
    private MagicStateManager ms_manager;
    private MagicStatusDisplay magicStatusDisplay;
    private SpeedDisplay speedDisplay;

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public YarnWorld()
    {    
        super(560, 560, 1); 
        prepare();

    }
    
    public ScoreDisplay getScoreDisplay()
    {
        return scoreDisplay;
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
        this.ms_manager = new MagicStateManager();
        this.magicStatusDisplay = this.ms_manager.getMagicStatusDisplay();
        this.dog.setMagicM(this.ms_manager);
        addObject(this.magicStatusDisplay, 120, getHeight() - 10);
        this.scoreDisplay = new ScoreDisplay();
        this.speedDisplay = new SpeedDisplay();

        addObject(dog,108,228);
        Bomb bomb = new Bomb();
        PowerUp pbomb = new PowerUp(this.dog, new Bomb(), MagicState.getRandomState());
        pbomb.attachObserver(this.scoreDisplay);
        pbomb.attachObserver(this.speedDisplay);
        
        //bomb.setDecorator(new PowerUpDecorator());
        addObject(pbomb,376,414);        
        
        
        Ball ball = new Ball();
        //ball.setDecorator(new PowerUpDecorator());

        PowerUp pball = new PowerUp(this.dog, new Ball(), MagicState.getRandomState());
        pball.attachObserver(this.scoreDisplay);
        pball.attachObserver(this.speedDisplay);
        
        addObject(pball,367,138);
        
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

        addObject(speedDisplay, 210, getHeight()-10);
        addObject(scoreDisplay, 30, getHeight()-10);

    }
}
