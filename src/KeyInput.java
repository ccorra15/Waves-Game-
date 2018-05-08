import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;	
	}

	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject x = handler.object.get(i);
			
			if(x.getID() == ID.Player) {
				
				if(key == KeyEvent.VK_W) { 
					if(x.getY() > 0) {
						x.setVY(-5);
						keyDown[0] = true;
					}
				}
				
				if(key == KeyEvent.VK_S) {
					if(x.getY() < Game.HEIGHT - 63) {
						x.setVY(5); 
						keyDown[1] = true;
					}
				}
				
				if(key == KeyEvent.VK_A) { 
					
					if(x.getX() > 0) {
						x.setVX(-5); 
						keyDown[2] = true;
					}
				
				}
				
				if(key == KeyEvent.VK_D) { 
					if(x.getX() < Game.WIDTH - 39) {
						x.setVX(5);
						keyDown[3] = true;
					}
				}
				
			}
			
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(GameObject x: handler.object) {
			
			if(x.getID() == ID.Player) {
				
				if(key == KeyEvent.VK_W) { keyDown[0] = false; }
				if(key == KeyEvent.VK_S) { keyDown[1] = false; }
				if(key == KeyEvent.VK_A) { keyDown[2] = false; }
				if(key == KeyEvent.VK_D) { keyDown[3] = false; }
				
				if(!keyDown[0] && !keyDown[1]) { x.setVY(0);}
				
				if(!keyDown[2] && !keyDown[3]) { x.setVX(0);}
				
			}
			
		}
		
	}
	
}
