import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    /**
     * Constructor for objects of class GameOver.
     *
     */
    private ScoreBoardComponent scoreboardComponent;
    private int score;
    private String name;

    public GameOver(int counter)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 560, 1); 
        name = Greenfoot.ask("What is your name ?");
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
        ScoreBoardComponent background = new ScoreBoardBackground();
        ScoreBoardComponent banner = new Banner("ScoreBoard", 300, 50);
        ScoreBoardComponent userName = new UserName(name, 100, 100);
        ScoreBoardComponent userScore = new Score(score, 200, 100);

        
        addObject(composite, 0, 0);
        addObject(banner, 0, 0);
        addObject(userName, 0, 0);
        addObject(userScore, 0, 0);
        addObject(background, 0, 0);
        composite.addChild(background);
        composite.addChild(userName);
        composite.addChild(userScore);
        composite.addChild(banner);
        scoreboardComponent.addChild(composite);
        scoreboardComponent.printDescription();
    }
}
