import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {

	ArrayList<GameObject> object = new ArrayList<>();
	
	public void tick() {
		
		
		for(int i = 0; i < object.size(); i++) {
			
			GameObject tempObj = object.get(i);
			
			tempObj.tick();
			
		}
		
	}
	
	public void render(Graphics g) {
		
		for(int i = 0; i < object.size(); i++) {
			
			GameObject x = object.get(i);
			x.render(g);
		}
		
	}
	
	public void addObject(GameObject object) {
		
		this.object.add(object);
		
	}
	
	public void removeObject(GameObject object) {
		
		this.object.remove(object);
		
	}
}
