package ikm.states;

import javax.microedition.lcdui.Graphics;

import ikm.Button;
import ikm.GameState;
import ikm.MainCanvas;
import ikm.Res;
import ikm.Translation;
import ikm.Button.ButtonListener;

public class MenuState extends GameState implements ButtonListener {
	private Button backButton;
	private Button restartButton;
	private Button aboutButton;
	private Button quitButton;
	
	private int x;
	private int y = 16;
	private int buttonHeight;
	
	private AboutState aboutState;
	
	public MenuState(String name, MainCanvas canvas) {
		super(name, canvas);
		x = canvas.getWidth() / 2 - Res.button.getWidth() / 2;
		buttonHeight = Res.button.getHeight();
		
		backButton = new Button(x, y += buttonHeight, Translation.tr("continue"));
		restartButton = new Button(x, y += buttonHeight, Translation.tr("restart"));
		aboutButton = new Button(x, y += buttonHeight, Translation.tr("about"));
		quitButton = new Button(x, y += buttonHeight, Translation.tr("quit"));
		
		addClickable(backButton);
		addClickable(restartButton);
		addClickable(aboutButton);
		addClickable(quitButton);
		
		backButton.setListener(this);
		restartButton.setListener(this);
		aboutButton.setListener(this);
		quitButton.setListener(this);
		
		aboutState = new AboutState("About", canvas);
	}

	public void update() {
		
	}

	public void paint(Graphics g) {
		renderParent(g);
		
		backButton.paint(g);
		restartButton.paint(g);
		aboutButton.paint(g);
		quitButton.paint(g);
	}

	public int getUpdateRate() {
		return 1000;
	}

	public void buttonClicked(Button button) {
		if (button == backButton) {
			canvas.back();
		} else if (button == restartButton) {
			canvas.restart();
		} else if (button == aboutButton) {
			canvas.popState();
			canvas.pushState(aboutState);
		} else if (button == quitButton) {
			canvas.quit();
		}
	}
	
	public boolean clicked(int x, int y) {
		if (!super.clicked(x, y))
			canvas.back();
		return true;
	}
}
