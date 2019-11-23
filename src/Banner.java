import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */

public class Banner extends ScoreBoardComponent {

    private String content;

    public Banner(String content) {
        this.content = content;
    }

    public void printDescription() {
        Color trans = new Color(0,0,0,0);
        setImage (new GreenfootImage (content, 50, Color.ORANGE, trans));
    }

    public void addChild(ScoreBoardComponent c) {
 
    }

    public void removeChild(ScoreBoardComponent c){
    }

    public ScoreBoardComponent getChild(int i){
        return null;
    }
}