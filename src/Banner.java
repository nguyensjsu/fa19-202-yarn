import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */

public class Banner extends ScoreBoardComponent {

    private String content;
    private int x;
    private int y;

    public Banner(String content, int x, int y) {
        this.content = content;
        this.x = x;
        this.y = y;
    }

    public void printDescription() {
        getWorld().showText(content, x, y);
    }

    public void addChild(ScoreBoardComponent c) {
 
    }

    public void removeChild(ScoreBoardComponent c){
    }

    public ScoreBoardComponent getChild(int i){
        return null;
    }
}