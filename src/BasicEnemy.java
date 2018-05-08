import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	private Handler handler;
	
	BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		vX = 7;
		vY = 7;
		
	
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int) x, (int) y,16, 16);
		
	}
	
	public void tick() {
		
		x += vX;
		y += vY;
		
		if(y <= 0 || y >= Game.HEIGHT - 40) vY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 10) vX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.RED,16, 16, 0.1f, handler));
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 16, 16);
		
	}

}
