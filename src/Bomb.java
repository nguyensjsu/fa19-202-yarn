import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Item
{
    public MagicState.States state;
    private int speed;
    private int score;
    public Bomb(MagicState.States s, int yarnspeed, int yarnscore) {
        this.state = s;
        speed = yarnspeed;
        score = yarnscore;
    }
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //touched();
    }
    public MagicState.States getState() {
        return state;
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
    public void touched() {
        if (isTouching(Dog.class)) {
            super.setScoreSpeed(score, speed);
        }
    }
    public void eaten()
    {
        super.setScoreSpeed(score, speed);
    }
}
