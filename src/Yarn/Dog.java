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
    int x=4;
    public void act() 
    {
        moveAndTurn();
        eat();
    }
    
    public void moveAndTurn()
    {
        move(x);
        if(Greenfoot.isKeyDown("left"))
        {
            
            setRotation(180);
            //move(x);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            
            setRotation(0);
            //move(x);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            
            setRotation(270);
            //move(x);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            
            setRotation(90);
            //move(x);
        }
    }   
    public void eat()
    {
        Actor ball;
        Actor bomb;
        Actor wall;
        Actor wallvertical;
        ball = getOneObjectAtOffset(0, 0, Ball.class);
        YarnWorld yarnworld = (YarnWorld) getWorld();
        wall = getOneObjectAtOffset(0, 0, Wall.class);
        wallvertical = getOneObjectAtOffset(0, 0, WallVertical.class);
        Counter counter = yarnworld.getCounter();
        
        if (wall != null)
        {
            
            GameOver gameover = new GameOver(counter.getTotalCount());
            Greenfoot.setWorld(gameover);
        }
        if (wallvertical != null)
        {
            
            GameOver gameover = new GameOver(counter.getTotalCount());
            Greenfoot.setWorld(gameover);
        }
        if (ball != null)
        {
            World world;
            world=getWorld();
            world.removeObject(ball);
              // get a reference to the world
              // get a reference to the counter
            counter.bumpCount(5);
            yarnworld.addObject(new Ball(), Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        }
        bomb = getOneObjectAtOffset(0, 0, Bomb.class);
        if (bomb != null)
        {
            World world;
            world=getWorld();
            world.removeObject(bomb);
            x++;            
            yarnworld.addObject(new Bomb(), Greenfoot.getRandomNumber(yarnworld.getWidth()), Greenfoot.getRandomNumber(yarnworld.getHeight()));
        }
    }
   
}
