import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    int score;
    /**
     * Constructor for objects of class GameOver.
     *
     */
    private ScoreBoardComponent scoreboardComponent;

    public GameOver(int counter)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 560, 1); 
        String input = Greenfoot.ask("What is your name ?");
        scoreboardComponent = new ScoreBoardComposite();
        //System.out.println(input);
        score = counter;
        prepare();
        //showText("Sorry " + input +" GAME OVER\n\n Score = "+score+"\n\nPress n for new game", getWidth()/2, getHeight()/2);
        
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("n"))
        {
           YarnWorld yarnworld = new YarnWorld();
           Greenfoot.setWorld(yarnworld);
        }
    }

    private void prepare() {
        ScoreBoardComponent composite = new ScoreBoardComposite();
        ScoreBoardComponent name = new UserName();
        ScoreBoardComponent userScore = new Score(score, 100, 100);
        addObject(composite, 200, 200);
        addObject(name, 0, 0);
        addObject(userScore, 0, 0);
        composite.addChild(name);
        composite.addChild(userScore);
        scoreboardComponent.addChild(composite);
        scoreboardComponent.printDescription();
    }
}
