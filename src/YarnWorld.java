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
        super(819, 576, 1);
        // set up background image
        GreenfootImage background = new GreenfootImage("sand.jpg");
        background.scale(getWidth(), getHeight());
        setBackground(background);
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
        addObject(wall,600,444);
        dog.setLocation(130,202);
        WallVertical wallVertical = new WallVertical();
        int[] wallVPosition = getWallVerticalPosition();
        //addObject(wallVertical, wallVPosition[0], wallVPosition[1]);

        addObject(wallVertical,130,202);
        dog.setLocation(131,188);

        // randomly add wall
        int[] wallPosition = getWallPosition();

        wall.setLocation(600,444);
        //wall.setLocation(wallPosition[0], wallPosition[1]);
        bomb.setLocation(237,306);
        dog.setLocation(76,444);
        dog.setLocation(81,389);

        addObject(speedDisplay, 210, getHeight()-10);
        addObject(scoreDisplay, 30, getHeight()-10);

    }

    //check collision for wall
    private int[] getWallPosition() {
        int x = Greenfoot.getRandomNumber(getWidth() - 50);
        int y = Greenfoot.getRandomNumber(getHeight() - 50);

        int sItem = getObjectsAt(x, y, PowerUp.class).size();
        //int sw = getObjectsAt(x, y, Wall.class).size();
        int swv = getObjectsAt(x, y, WallVertical.class).size();
        int sDog = getObjectsAt(x, y, Dog.class).size();

        boolean noCollision = sItem == 0 && swv == 0 && sDog == 0;

        while (!noCollision) {
            x = Greenfoot.getRandomNumber(getWidth());
            y = Greenfoot.getRandomNumber(getHeight());
            sItem = getObjectsAt(x, y, PowerUp.class).size();
            //sw = yarnworld.getObjectsAt(x, y, Wall.class).size();
            swv = getObjectsAt(x, y, WallVertical.class).size();
            sDog = getObjectsAt(x, y, Dog.class).size();
            noCollision = sItem == 0 && swv == 0 && sDog == 0;
        }

        return new int[]{x, y};

    }

    //check collision for wall Vertical
    private int[] getWallVerticalPosition() {
        int x = Greenfoot.getRandomNumber(getWidth() - 50);
        int y = Greenfoot.getRandomNumber(getHeight() - 50);

        int sItem = getObjectsAt(x, y, PowerUp.class).size();
        //int sw = getObjectsAt(x, y, Wall.class).size();
        int swv = getObjectsAt(x, y, Wall.class).size();
        int sDog = getObjectsAt(x, y, Dog.class).size();

        boolean noCollision = sItem == 0 && swv == 0 && sDog == 0;

        while (!noCollision) {
            x = Greenfoot.getRandomNumber(getWidth());
            y = Greenfoot.getRandomNumber(getHeight());
            sItem = getObjectsAt(x, y, PowerUp.class).size();
            //sw = yarnworld.getObjectsAt(x, y, Wall.class).size();
            swv = getObjectsAt(x, y, Wall.class).size();
            sDog = getObjectsAt(x, y, Dog.class).size();
            noCollision = sItem == 0 && swv == 0 && sDog == 0;
        }

        return new int[]{x, y};

    }
}
