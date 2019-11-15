import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */

public class Score extends ScoreBoardComponent {

    private int score;
    private int x;
    private int y;

    public Score(int score, int x, int y) {
        this.score = score;
        this.x = x;
        this.y = y;
    }

    public void printDescription() {
        getWorld().showText(String.valueOf(score), x, y);
        //getWorld().showText("test", 100, 100);
        //System.out.println(getWorld());
    }

    public void addChild(ScoreBoardComponent c) {
 
    }

    public void removeChild(ScoreBoardComponent c){
    }

    public ScoreBoardComponent getChild(int i){
        return null;
    }
}
