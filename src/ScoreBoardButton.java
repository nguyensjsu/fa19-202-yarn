import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */
// SCoreBoard button class -- component of ScoreBoard
public class ScoreBoardButton extends ScoreBoardComponent {

    private int x;
    private int y;
    private GreenfootImage buttonImage;

    public ScoreBoardButton() {
        // this.x = x;
        // this.y = y;
        buttonImage = new GreenfootImage("replay.png");
        buttonImage.scale(200, 50);
        setImage(buttonImage);
    }

	public void printDescription() {
    	//getWorld().showText(name, x, y);
    }

    public void addChild(ScoreBoardComponent c) {
 
    }

    public void removeChild(ScoreBoardComponent c){
    }

    public ScoreBoardComponent getChild(int i){
    	return null;
    }
}