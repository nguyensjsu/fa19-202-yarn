import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dog extends Actor
{
    public int getSpeed() {
        return speed + speedUpdate;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Act - do whatever the Dog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed=4;

    public MagicStateManager getMagicM() {
        return magicM;
    }


    public void setMagicM(MagicStateManager magicM) {
        this.magicM = magicM;
    }

    private MagicStateManager magicM;
    int timer = 0;                //set timer to 2 once touch a PowerUp
    public boolean invincible = false;  // like in Super Mario, if invincible, nothing happens when touch wall and bomb  
   
    //private DisplayComponent display;  //stateManager will notify display

    public int getSpeedUpdate() {
        return speedUpdate;
    }

    public void setSpeedUpdate(int speedUpdate) {
        this.speedUpdate = speedUpdate;
    }

    private int speedUpdate = 0;           //Temporarily speed effect applied on Dog

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
            
            GameOver gameover = new GameOver(scoreDisplay.getScore());
            Greenfoot.setWorld(gameover);
        }
        else if ((isTouching(Wall.class) || isTouching(WallVertical.class)) && invincible==true) {
            //do nothing
        }
        else if (getOneObjectAtOffset(0, 0, PowerUp.class) != null) {
            
        }    
        //if (getOneObjectAtOffset(0, 0, Ball.class) != null)
        //{
        //    
        //    yarnworld.removeObject(getOneObjectAtOffset(0, 0, Ball.class));
            //counter.bumpCount(5);
        //    yarnworld.removeObject(ball);
        //    timer=80;
        //    magicM.setState(ball.getState());
        //    magicM.doEffect(this);
        //    yarnworld.addObject(new Ball(MagicState.getRandomState()), Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        //}
        //if (getOneObjectAtOffset(0, 0, Bomb.class) != null)
        //{
        //    yarnworld.removeObject(getOneObjectAtOffset(0, 0, Bomb.class));
        //    timer=80;
        //    magicM.setState(bomb.getState());
         //   magicM.doEffect(this);
        //    yarnworld.addObject(new Bomb(MagicState.States.UP), Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        //}
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
        YarnWorld yarnworld = (YarnWorld) getWorld();
        
        this.magicM.setState(s);
        this.magicM.doEffect(this);
        
        this.timer=80;
        Actor a = getOneIntersectingObject(PowerUp.class);
        if (a == null) System.out.println("NO Ball Found");
        removeTouching(PowerUp.class);
        
        PowerUp ball = new PowerUp(this, new Ball(), MagicState.getRandomState());
        getWorld().addObject(ball, Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
    }
       
    
    public void updateBombEaten(MagicState.States s) {
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
    
        getWorld().addObject(x, Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
    }
    
}

