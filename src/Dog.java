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

    MagicStateManager magicM;
    int timer = 0;                //set timer to 2 once touch a PowerUp
    public boolean invincible = false;  // like in Super Mario, if invincible, nothing happens when touch wall and bomb  

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
        Actor ball;
        Actor bomb;
        YarnWorld yarnworld = (YarnWorld) getWorld();        
        ScoreDisplay scoreDisplay = yarnworld.getScoreDisplay();
        if ((isTouching(Wall.class) || isTouching(WallVertical.class) || isAtEdge()) && invincible==false) 
        {
            
            GameOver gameover = new GameOver(scoreDisplay.getScore());
            Greenfoot.setWorld(gameover);
        }
        else if ((isTouching(Wall.class) || isTouching(WallVertical.class)) && invincible==true) {
            //do nothing
        }
        ball = getOneObjectAtOffset(0, 0, Ball.class);
        if (ball != null)
        {
            yarnworld.removeObject(ball);
            //scoreDisplay.bumpScore(5);
            timer=80;
            Ball b = new Ball();
            b.setDecorator(new PowerUpDecorator());
            yarnworld.addObject(b, Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        }
        bomb = getOneObjectAtOffset(0, 0, Bomb.class);
        if (bomb != null)
        {
            yarnworld.removeObject(bomb);
            timer=80;
            Bomb b = new Bomb();
            b.setDecorator(new PowerUpDecorator());
            yarnworld.addObject(b, Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
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
}
