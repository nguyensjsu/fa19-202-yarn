import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Yueqiao	
 * @version Nov 16
 */
public class GameEntryWorld extends World
{	
	private GreenfootImage background;
	private YarnWorld yw;
	private StartButton sb;

	public GameEntryWorld() {
		super(750, 600, 1);
		sb = new StartButton();

		background = new GreenfootImage("entry.png");
		background.scale(getWidth(), getHeight());
		setBackground(background);
		addObject(sb, 400, 500);
		yw = new YarnWorld();
	}

	// Added stargame button
	public void act() {
		if (Greenfoot.mouseClicked(sb)) {
			Greenfoot.setWorld(yw);
		}
	}

	// added button for entering game world
	private class StartButton extends Actor {
		private GreenfootImage buttonImage;

		public StartButton() {
			buttonImage = new GreenfootImage("start.png");
			buttonImage.scale(200, 80);
			setImage(buttonImage);
		}
	}

}