import greenfoot.*;
import java.util.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */
// ScoreBoard Composite class
public class ScoreBoardComposite extends ScoreBoardComponent {

	private ArrayList<ScoreBoardComponent> components = new ArrayList<>();

	public ScoreBoardComposite() {

	}

    public void printDescription() {
    	for (ScoreBoardComponent obj : components) {
    		obj.printDescription();
    	}
    }

    public void addChild(ScoreBoardComponent c) {
    	components.add(c);
    }

    public void removeChild(ScoreBoardComponent c){
    	components.remove(c);
    }

    public ScoreBoardComponent getChild(int i){
    	return components.get(i);
    }
}
