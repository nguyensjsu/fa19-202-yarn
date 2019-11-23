import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */

// ScoreBoard Background of ScoreBoard
public class ScoreBoardBackground extends ScoreBoardComponent {

    private GreenfootImage image;

    public ScoreBoardBackground() {
        this.image = new GreenfootImage("scoreboardbackground.png");
        this.image.scale(1200,1200);
        setImage(this.image);
    }

    public void printDescription() {
    }

    public void addChild(ScoreBoardComponent c) {
 
    }

    public void removeChild(ScoreBoardComponent c){
    }

    public ScoreBoardComponent getChild(int i){
        return null;
    }
}