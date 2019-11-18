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
    int speed=4;
    MagicStateManager magicM = new MagicStateManager();
    int timer = 0;                //set timer to 2 once touch a PowerUp
    boolean invincible = false;  // like in Super Mario, if invincible, nothing happens when touch wall and bomb  
    int speedUpdate = 0;           //Temporarily speed effect applied on Dog
    
    public void act() 
    {
       
        magicM.doEffect(this);
        moveAndTurn();
        eat();
        
        if (timer> 0)
        {
            timer--;
        }
        
        if (timer == 0){  
            magicM.setState(MagicState.States.OFF);
        }
        
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
        Counter counter = yarnworld.getCounter();        
        if ((isTouching(Wall.class) || isTouching(WallVertical.class) || isAtEdge()) && invincible==false) 
        {
            
            GameOver gameover = new GameOver(counter.getTotalCount());
            Greenfoot.setWorld(gameover);
        }
        ball = getOneObjectAtOffset(0, 0, Ball.class);
        if (ball != null)
        {
            yarnworld.removeObject(ball);
            counter.bumpCount(5);
            timer=2;
            magicM.setState(MagicState.getRandomState());
            yarnworld.addObject(new Ball(), Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        }
        bomb = getOneObjectAtOffset(0, 0, Bomb.class);
        if (bomb != null)
        {
            yarnworld.removeObject(bomb);
            speed++;
            timer=2;
            magicM.setState(MagicState.getRandomState());
            yarnworld.addObject(new Bomb(), Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        }
    }
   
}
