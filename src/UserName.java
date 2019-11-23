import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */
// User Name of SCore Board Component
public class UserName extends ScoreBoardComponent {

    private String name;

    public UserName(String name) {
        this.name = name;
    }

    // Display user name 
	public void printDescription() {
        
        String content = "Hi " + name;
        Color trans = new Color(0,0,0,0);
        setImage (new GreenfootImage (content, 30, Color.ORANGE, trans));

    	//getWorld().showText(content, x, y);
    }

    public void addChild(ScoreBoardComponent c) {
 
    }

    public void removeChild(ScoreBoardComponent c){
    }

    public ScoreBoardComponent getChild(int i){
    	return null;
    }
}