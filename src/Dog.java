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
    public int speed=4;
    MagicStateManager magicM = new MagicStateManager();
    int timer = 0;                //set timer to 2 once touch a PowerUp
    public boolean invincible = false;  // like in Super Mario, if invincible, nothing happens when touch wall and bomb  
    public int speedUpdate = 0;           //Temporarily speed effect applied on Dog
    
    private DisplayComponent display;  //observer  
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
        Counter counter = yarnworld.getCounter();   
        Ball ball = yarnworld.getBall();
        Bomb bomb = yarnworld.getBomb();
        if ((isTouching(Wall.class) || isTouching(WallVertical.class) || isAtEdge()) && invincible==false) 
        {
            
            GameOver gameover = new GameOver(counter.getTotalCount());
            Greenfoot.setWorld(gameover);
        }
        else if ((isTouching(Wall.class) || isTouching(WallVertical.class)) && invincible==true) {
            //do nothing
        }
        if (getOneObjectAtOffset(0, 0, Ball.class) != null)
        {
            yarnworld.removeObject(getOneObjectAtOffset(0, 0, Ball.class));
            counter.bumpCount(5);
            timer=80;
            magicM.setState(ball.getState());
            magicM.doEffect(this);
            yarnworld.addObject(new Ball(MagicState.getRandomState()), Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        }
        if (getOneObjectAtOffset(0, 0, Bomb.class) != null)
        {
            yarnworld.removeObject(getOneObjectAtOffset(0, 0, Bomb.class));
            timer=80;
            magicM.setState(bomb.getState());
            magicM.doEffect(this);
            yarnworld.addObject(new Bomb(MagicState.States.UP), Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
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
    
    //Work as subject
    /**
     * attach display observer 
     */
    public void attach(DisplayComponent d_status)
    {
        this.display = d_status;
    }
    
    /**
     * Notify Magic Status Display
     */
    public void notifyDisplay()
    {
        this.display.updateMagicStatus(magicM.getCurrentState());
    }  
}
