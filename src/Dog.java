import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dog extends Actor
{
    
    /**
     * Act - do whatever the Dog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed=4;
    private MagicStateManager magicM;
    int timer = 0;                //set timer to 2 once touch a PowerUp
    public boolean invincible = false;  // like in Super Mario, if invincible, nothing happens when touch wall and bomb 
    private int speedUpdate = 0;           //Temporarily speed effect applied on Dog
    
    /*** 
        Dog speed getter stter
    ***/
    public int getSpeed() {
        return speed + speedUpdate;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /***
        Dog speed update getter setter
    ***/
    public int getSpeedUpdate() {
        return speedUpdate;
    }

    public void setSpeedUpdate(int speedUpdate) {
        this.speedUpdate = speedUpdate;
    }

    /**
        Magic State Manager getter setter
    **/
    public void setMagicM(MagicStateManager magicM) {
        this.magicM = magicM;
    }

    public MagicStateManager getMagicM() {
        return magicM;
    }


    public void addSpeedUpdate(){
        this.speedUpdate++;
    }

    public void act() 
    {
        moveAndTurn();
        eat();
        timerCountdown();
    }
    
    
    public void moveAndTurn()
    {
        move(speed+speedUpdate);
        if(Greenfoot.isKeyDown("left"))
        {
            
            setRotation(180);
            
        }
        if(Greenfoot.isKeyDown("right"))
        {
            
            setRotation(0);
            
        }
        if(Greenfoot.isKeyDown("up"))
        {
            
            setRotation(270);
            
        }
        if(Greenfoot.isKeyDown("down"))
        {
            
            setRotation(90);
            
        }
    }

    public void eat()
    {
        YarnWorld yarnworld = (YarnWorld) getWorld();
        //Counter counter = yarnworld.getCounter();   
        //Ball ball = yarnworld.getBall();
        //Bomb bomb = yarnworld.getBomb();
        ScoreDisplay scoreDisplay = yarnworld.getScoreDisplay();
        if ((isTouching(Wall.class) || isTouching(WallVertical.class) || isAtEdge()) && invincible==false) 
        {
            
            Greenfoot.playSound("bark.mp3");
            GameOver gameover = new GameOver(scoreDisplay.getScore());
            Greenfoot.setWorld(gameover);
        }
        else if ((isTouching(Wall.class) || isTouching(WallVertical.class)) && invincible==true) {
            //do nothing
        }
    }
    
    public void timerCountdown() {
        if (timer > 0) {
            if (invincible == true) {
                // image slightly transparent when it's invincible
                getImage().setTransparency(100);
            }
            else {
                getImage().setTransparency(255);
            }
            timer--;
            if (timer == 0) {
                getImage().setTransparency(255);
                magicM.setState(MagicState.States.OFF);
                magicM.doEffect(this);
            }
        }
    }
    
    public void updateBallEaten(MagicState.States s) {
        Greenfoot.playSound("ball.mp3");
        YarnWorld yarnworld = (YarnWorld) getWorld();
        
        this.magicM.setState(s);
        this.magicM.doEffect(this);
        
        this.timer=80;
        Actor a = getOneIntersectingObject(PowerUp.class);
        if (a == null) System.out.println("NO Ball Found");
        removeTouching(PowerUp.class);
        
        PowerUp ball = new PowerUp(this, new Ball(), MagicState.getRandomState());
        //getWorld().addObject(ball, Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        int[] pos = getPosition();
        getWorld().addObject(ball, pos[0], pos[1]); 
    }
       
    
    public void updateBombEaten(MagicState.States s) {
        //Greenfoot.playSound("bomb.mp3");
        YarnWorld yarnworld = (YarnWorld) getWorld();
        this.magicM.setState(s);
        
        this.timer=80;
        
        Actor a = getOneIntersectingObject(PowerUp.class);
        if (a == null) System.out.println("NO Bomb Found");
        removeTouching(PowerUp.class);
       
        this.magicM.doEffect(this);
        Bomb b = new Bomb();
        PowerUp x = new PowerUp(this, b, MagicState.getRandomState());
        //System.out.println("Here");
        int[] pos = getPosition();
        getWorld().addObject(x, pos[0], pos[1]); 
        //getWorld().addObject(x, Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
    }

    //check collision
    private int[] getPosition() {
        YarnWorld yarnworld = (YarnWorld) getWorld();
        int x = Greenfoot.getRandomNumber(yarnworld.getWidth() - 100);
        int y = Greenfoot.getRandomNumber(yarnworld.getHeight() - 100);

        //int sItem = getObjectsAt(x, y, PowerUp.class).size();
        int sw = yarnworld.getObjectsAt(x, y, Wall.class).size();
        int swv = yarnworld.getObjectsAt(x, y, WallVertical.class).size();
        int sDog = yarnworld.getObjectsAt(x, y, Dog.class).size();

        boolean noCollision = sw == 0 && swv == 0 && sDog == 0;

        while (!noCollision) {
            x = Greenfoot.getRandomNumber(yarnworld.getWidth());
            y = Greenfoot.getRandomNumber(yarnworld.getHeight());
            //sItem = yarnworld.getObjectsAt(x, y, PowerUp.class).size();
            sw = yarnworld.getObjectsAt(x, y, Wall.class).size();
            swv = yarnworld.getObjectsAt(x, y, WallVertical.class).size();
            sDog = yarnworld.getObjectsAt(x, y, Dog.class).size();
            noCollision = sw == 0 && swv == 0 && sDog == 0;
        }

        return new int[]{x, y};

    }
    
}

