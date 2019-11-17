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
    private ScoreBoardComponent button;

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
        if(Greenfoot.mouseClicked(button))
        {
           YarnWorld yarnworld = new YarnWorld();
           Greenfoot.setWorld(yarnworld);
        }
    }

    // get banner content if user wins or not
    private String getBanner(int score) {
        return score > 15 ? "Congrats! You Win!" : "Sorry. You lose!";
    }

    private void prepare() {
        ScoreBoardComponent composite = new ScoreBoardComposite();
        ScoreBoardComponent background = new ScoreBoardBackground();
        ScoreBoardComponent title = new ScoreBoardTitle();
        ScoreBoardComponent banner = new Banner(getBanner(score));
        ScoreBoardComponent userName = new UserName(name);
        ScoreBoardComponent userScore = new Score(score);
        button = new ScoreBoardButton();
        
        addObject(composite, 0, 0);
        addObject(background, 0, 0);
        addObject(title, 250, 50);
        addObject(banner, 280, 200);
        addObject(userScore, 250, 350);
        addObject(userName, 250, 300);
        addObject(button, 250, 450);

        composite.addChild(background);
        composite.addChild(title);
        composite.addChild(userName);
        composite.addChild(userScore);
        composite.addChild(banner);
        composite.addChild(button);
        scoreboardComponent.addChild(composite);
        scoreboardComponent.printDescription();
    }
}
