import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Item
{
    IDecorator decorator = null;
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }  
    protected void addedToWorld(World world)
    {
        while (isTouching(Ball.class) || isTouching(Wall.class) || isTouching(WallVertical.class) || isTouching(Counter.class))
        {
            int x = Greenfoot.getRandomNumber(world.getWidth());
            int y = Greenfoot.getRandomNumber(world.getHeight());
            setLocation(x, y);
        }
    }
    public void setDecorator(IDecorator d) {
        this.decorator = d;
    }
    public void touched() {
        if (isTouching(Dog.class) && decorator != null) {
            super.setScoreSpeed(-10, 2);
            YarnWorld yw = (YarnWorld) getWorld();
            Dog yarn = yw.getDog();
            decorator.powerUp(MagicState.States.UP, yarn);
        }
    }
}
