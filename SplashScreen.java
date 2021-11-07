package Pong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import utilities.GDV5;

import java.awt.Graphics2D;
public class SplashScreen extends Rectangle{
	Images i  = new Images();
	SplashScreen() {
		super(0, 0, GDV5.getMaxWindowX(), GDV5.getMaxWindowY());
	}
	
	public void drawSplashScreen(Graphics2D win) {
		win.setColor(Color.white);
		win.setFont(new Font("Courier",Font.ITALIC,34));
		win.drawString("Press 1 for SinglePlayer ", 100, 400);
		win.drawString(" Press 2 for MultiPlayer", 600, 400);
		win.drawImage(i.wkey,285,425,150,150,null);
		win.drawImage(i.skey,285,600,150,150,null);
		win.drawImage(i.updownkey,765,425,150,325,null);
		win.drawString("up", 175, 500);
		win.drawString("up", 625, 500);
		win.drawString("down", 150, 675);
		win.drawString("down", 600, 675);
		win.setFont(new Font("Courier",Font.ITALIC,22));
		win.drawString("Try to get the ball past the other player's paddle for one point. First to 10 points wins!", 25, 778);
		win.setColor(Color.blue);
		win.setFont(new Font("Courier",Font.ITALIC,80));
		win.drawString("Purav Patel", 345, 300);
			}
}
