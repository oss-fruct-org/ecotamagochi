package ikm;

import ikm.util.Maths;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

public class ProgressBar {
	public static final int BAR_X = 16, BAR_Y = 3;
	public static final int WIDTH_X = 48, WIDTH_Y = 14;
	
	private Sprite sprite;

	private int color;
	private int maxValue = 1;
	
	private int x, y;
	private int currentValue = 0;
	
	public ProgressBar(int x, int y, int color, int maxValue) {
		this.color = color;
		this.maxValue = maxValue;
		
		this.x = x;
		this.y = y;
		
		sprite = new Sprite(Res.progressbar);
		sprite.setPosition(x, y);
	}
	
	public void setCurrentValue(int v) {
		currentValue = Maths.clamp(v, 0, maxValue);
	}

	public void paint(Graphics g) {
		g.setColor(color);
		sprite.paint(g);
		
		int width = WIDTH_X * currentValue / maxValue;
		g.fillRect(x + BAR_X, y + BAR_Y, width, WIDTH_Y);
	}

}