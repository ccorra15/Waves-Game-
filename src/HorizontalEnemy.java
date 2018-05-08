import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HorizontalEnemy extends GameObject{

	private Handler handler;
	
	HorizontalEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		vX = 10;
		vY = 0;
		
	
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int) x, (int) y,16, 16);
		
	}
	
	public void tick() {
		
		x += vX;
		
		if(x <= 0 || x >= Game.WIDTH - 10) vX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.RED,16, 16, 0.1f, handler));
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 16, 16);
		
	}

}
