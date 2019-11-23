import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */
// ScoreBoard Title class
public class ScoreBoardTitle extends ScoreBoardComponent {

    private GreenfootImage image;

    public ScoreBoardTitle() {
        this.image = new GreenfootImage("title.png");
        this.image.scale(200,80);
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
