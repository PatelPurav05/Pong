package Pong;
import utilities.GDV5;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class Paddle extends Rectangle {
	int pY;
	int speed = 6;
	public Paddle(int x, int y, int w, int h) {
		super(x,y,w,h);
		pY = 8;
	}
	public void move() {
		if (GDV5.KeysPressed[KeyEvent.VK_W]&&this.getY()>0) {
		this.translate(0, -10);
		}
	if(GDV5.KeysPressed[KeyEvent.VK_S]&&this.getY()<Pong.getMaxWindowY()-150) {
		this.translate(0, 10);
		}	
	}
	public void multp2move() {
		if (GDV5.KeysPressed[KeyEvent.VK_UP]&&this.getY()>0) {
			this.translate(0, -10);
		}
		if(GDV5.KeysPressed[KeyEvent.VK_DOWN]&&this.getY()<Pong.getMaxWindowY()-150) {
			this.translate(0, 10);
		}
	}
	public void movePaddle2(Ball b1) {
		if (b1.y > y) translate(0, speed);
		else translate(0, -speed);
	}
}
