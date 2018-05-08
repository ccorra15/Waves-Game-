import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	
	Handler handler;
	
	Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
	}


	public void tick() {
		
		x += vX;
		y += vY;
		
		if(y <= 0 || y >= Game.HEIGHT - 63) vY *= 0;
		if(x <= 0 || x >= Game.WIDTH - 39) vX *= 0;
		
		collision();
		
	}
	
	public void collision() {
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject x = handler.object.get(i);
			
			if(x.getID() == ID.BasicEnemy || x.getID() == ID.SmartEnemy || x.getID() == ID.FastEnemy || x.getID() == ID.HorizontalEnemy ||
			   x.getID() == ID.VerticalEnemy) {
				
				if(getBounds().intersects(x.getBounds())) { 
					
					HUD.health -= 5;
					
				}
				
			}
			
		}
		
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int) x, (int) y,32, 32);
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y,32, 32);
		
	}

}
