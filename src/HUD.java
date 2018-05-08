import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static float health = 180;
	private float green = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		if(green >= 0 && green <= 255)
			green = health;
		
		score++;
		
	}
	
	public void render(Graphics g) {
		
		if(green > 255 || green < 0)
			green = 255;
		g.setColor(Color.gray);
		g.fillRect(15, 15, 180, 32);
		g.setColor(new Color(130, (int) green, 0));
		g.fillRect(15, 15, (int) health, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 180, 32);
	
		g.drawString("Score:" + score, 15, 64);
		g.drawString("Level:" + level, 15, 80);
		
	}
	
	public int getScore() {
		
		return this.score;
		
	}
	
	public int getLevel() {
		
		return this.level;
		
	}
	
	public void setScore(int score) {
		
		this.score = score;
		
	}
	
	public void setLevel(int level) {
		
		this.level = level;
		
	}
	
	
}
