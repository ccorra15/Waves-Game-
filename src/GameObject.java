import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x, y, vX, vY;
	
	protected ID id;
	
	GameObject(float x, float y, ID id) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	
	public abstract Rectangle getBounds();
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public void setX(float x) {
		
		this.x = x;
		
	}
	
	public void setY(float y) {
		
		this.y = y;
		
	}
	
	public void setID(ID id) {
		
		this.id = id;
		
	}
	
	public void setVX(float vX) {
		
		this.vX = vX;
		
	}
	
	public void setVY(float vY) {
		
		this.vY = vY;
		
	}
	
	public float getX() {
		
		return this.x;
		
	}
	
	public float getY() {
		
		return this.y;
		
	}
	
	public ID getID() {
		
		return this.id;
		
	}
	
	public float getVX() {
		
		return this.vX;
		
	}
	
	public float getVY() {
		
		return this.vY;
		
	}
	
}
