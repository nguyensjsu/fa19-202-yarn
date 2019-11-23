import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */

// Score class of Score Board
public class Score extends ScoreBoardComponent {

    private int score;

    public Score(int score) {
        this.score = score;
    }

    // print component content
    public void printDescription() {
        //getWorld().showText("test", 100, 100);
        //System.out.println(getWorld());
        Color trans = new Color(0,0,0,0);
        String content = "Your score is " + String.valueOf(score);
        
        setImage (new GreenfootImage (content, 30, Color.ORANGE, trans));
    }

    public void addChild(ScoreBoardComponent c) {
 
    }

    public void removeChild(ScoreBoardComponent c){
    }

    public ScoreBoardComponent getChild(int i){
        return null;
    }
}
