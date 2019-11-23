import greenfoot.*;
/**
 * @author Yueqiao
 * @version 1.0 Nov 14
 */

// Score Board  component interface class
public abstract class ScoreBoardComponent extends Actor {
    public abstract void printDescription();
    public abstract void addChild(ScoreBoardComponent c);
    public abstract void removeChild(ScoreBoardComponent c);
    public abstract ScoreBoardComponent getChild(int i);
}
