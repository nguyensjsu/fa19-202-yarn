import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */

public class UserName extends ScoreBoardComponent {

    private String name;
    private int x;
    private int y;

    public UserName(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

	public void printDescription() {
    	getWorld().showText(name, x, y);
    }

    public void addChild(ScoreBoardComponent c) {
 
    }

    public void removeChild(ScoreBoardComponent c){
    }

    public ScoreBoardComponent getChild(int i){
    	return null;
    }
}