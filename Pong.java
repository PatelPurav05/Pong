package Pong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import utilities.GDV5;
public class Pong extends GDV5{

	boolean single = false;
	boolean mult = false;
	boolean splash = true;
	boolean winner1 = false;
	boolean winnerc = false;
	boolean winnerm1 = false;
	boolean winnerm2 = false;
	public int maxX = Pong.getMaxWindowX();
	public int maxY = Pong.getMaxWindowY();
	Rectangle black = new Rectangle(0,0,GDV5.getMaxWindowX(),GDV5.getMaxWindowY());
	Ball b1 = new Ball(Pong.getMaxWindowX()/2,Pong.getMaxWindowY()/2,20,20);
	Paddle p1 = new Paddle(20,Pong.getMaxWindowY()/4+20,20,125);
	Paddle p2 = new Paddle(Pong.getMaxWindowX()-40,Pong.getMaxWindowY()/4,20,125);
	Paddle p3 = new Paddle(Pong.getMaxWindowX()-40,Pong.getMaxWindowY()/4,20,125);
	Images i = new Images();
	SplashScreen sp = new SplashScreen();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pong p = new Pong();
		p.start();
	}
	public void update() {
		KeyPressed();
		if (single) {
		p2.movePaddle2(b1);
		p1.move();
		b1.move();
		b1.bounce();}
		if (mult) {
		p3.multp2move();
		p1.move();
		b1.move();
		b1.bounce();}
		contactp1p2();
		smashball();
	}
	public void KeyPressed() {
		if (winner1) {
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			b1.score1=0;
			b1.score2=0;
			b1.scorep=0;
			b1.scorec=0;
			winner1 = false;
			single = true;
			}
		}
		if (winnerc) {
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				b1.score1=0;
				b1.score2=0;
				b1.scorep=0;
				b1.scorec=0;
				winnerc = false;
				single = true;
				}
		}
		if (winnerm1) {
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				b1.score1=0;
				b1.score2=0;
				b1.scorep=0;
				b1.scorec=0;
				winnerm1 = false;
				mult = true;
				}
		}
		if (winnerm2) {
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				b1.score1=0;
				b1.score2=0;
				b1.scorep=0;
				b1.scorec=0;
				winnerm2 = false;
				mult = true;
				}
		}
		if (GDV5.KeysTyped[KeyEvent.VK_1]) {
			splash = false;
			this.single = true;
		}
		if (GDV5.KeysTyped[KeyEvent.VK_2]) {
			splash = false;
			this.mult = true;
		}
	}
	public void draw(Graphics2D win) {
		if (single) {
			win.setColor(Color.BLACK);
			win.setFont(new Font("Courier",Font.BOLD,40));
			win.drawString("Press 1 for Single Player", 100, 400);
			win.drawString("Press 2 for MultiPlayer", 600, 400);
			win.drawImage(i.background,0,0,GDV5.getMaxWindowX(),GDV5.getMaxWindowY(),null);
			win.drawImage(i.paddlep1,null, p1.x-110,p1.y);
			win.drawImage(i.ball,b1.x,b1.y,25,25,null);
			win.drawImage(i.paddlep2, null, p2.x,p2.y);
			win.setFont(new Font("Courier",Font.ITALIC,50));
			win.setColor(Color.white);
			win.drawString("" + b1.scorep, maxX/4, 60);
			win.drawString("" + b1.scorec, (int)(maxX*0.75), 60);
		} else if (mult) {
			win.setColor(Color.BLACK);
			win.setFont(new Font("Courier",Font.BOLD,40));
			win.drawString("Press 1 for Single Player", 100, 400);
			win.drawString("Press 2 for MultiPlayer", 600, 400);
			win.drawImage(i.background,0,0,GDV5.getMaxWindowX(),GDV5.getMaxWindowY(),null);
			win.drawImage(i.ball,b1.x,b1.y,25,25,null);
			win.drawImage(i.paddlep1,null, p1.x-110,p1.y);
			win.drawImage(i.paddlep2, null, p3.x,p3.y);
			win.setFont(new Font("Courier",Font.ITALIC,50));
			win.setColor(Color.white);
			win.drawString("" + b1.scorep, maxX/4, 60);
			win.drawString("" + b1.scorec, (int)(maxX*0.75), 60);
		}
		if (single){
			if (b1.scorec==1) {
			winnerc = true;
			single=false;
			}
			else if (b1.scorep==10) {
			winner1 = true;
			single = false;
			}
		}
		if (mult) {
			if (b1.scorec==10) {
			winnerm2 = true;
			mult=false;
			}
			else if (b1.scorep==10) {
			winnerm1 = true;
			mult = false;
			}
		}
		if (splash) {
			win.setColor(Color.BLACK);
			win.fill(sp);
			sp.drawSplashScreen(win);
			
		}
		if (winner1) {
			win.setColor(Color.BLACK);
			win.fill(black);
			win.setColor(Color.pink);
			win.setFont(new Font("Courier",Font.BOLD,50));
			win.drawString("Player 1 Wins!", maxX/2, maxY/2);
			win.drawString("Press Enter to Restart", 400,600);
		}
		if (winnerc) {
			win.setColor(Color.BLACK);
			win.fill(black);
			win.setColor(Color.pink);
			win.setFont(new Font("Courier",Font.BOLD,50));
			win.drawString("You Lose", maxX/2, maxY/2);
			win.drawString("Press Enter to Restart", 400,600);
		}
		if (winnerm1) {
			win.setColor(Color.BLACK);
			win.fill(black);
			win.setColor(Color.pink);
			win.setFont(new Font("Courier",Font.BOLD,50));
			win.drawString("Player 1 Wins!", maxX/2, maxY/2);
			win.drawString("Press Enter to Restart", 400,600);
		}
		if (winnerm2) {
			win.setColor(Color.BLACK);
			win.fill(black);
			win.setColor(Color.pink);
			win.setFont(new Font("Courier",Font.BOLD,50));
			win.drawString("Player 2 Wins!", maxX/2, maxY/2);
			win.drawString("Press Enter to Restart", 400,600);
		}
	}
	public void contactp1p2() {
		if (b1.intersects(p1)) {
			b1.dX*=-1;
			b1.dY*=-1;
			b1.x = p1.x + 20;
			b1.dirx *= -1;
			if (b1.minispeedx < 2) b1.minispeedx++;
			else {
				b1.speedx+=2;
				b1.minispeedx = 0;
			}
		}
		if(b1.intersects(p2)) {
			b1.dX*=-1;
			b1.dY*=-1;
			b1.x = p2.x - 20;
			b1.dirx *= -1;
		}
		if(b1.intersects(p3)) {
			b1.dX*=-1;
			b1.dY*=-1;
			b1.x = p2.x - 20;
			b1.dirx *= -1;
			if (b1.minispeedx < 2) b1.minispeedx++;
			else {
				b1.speedx+=2;
				b1.minispeedx = 0;
			}
		}
	}
	public void smashball() {
		if (single) {
			if ((b1.dY>0&&GDV5.KeysPressed[KeyEvent.VK_S])&&b1.intersects(p1)) {
			b1.speedx+=2;
			}
			if ((b1.dY<0&&GDV5.KeysPressed[KeyEvent.VK_W])&&b1.intersects(p1)) {
				b1.speedx+=2;
			}
			if ((b1.dY>0&&p2.speed<0)&&b1.intersects(p2)) {
				b1.speedx+=2;
			}
			if ((b1.dY<0&&p2.speed>0)&&b1.intersects(p2)) {
				b1.speedx+=2;
			}
		}
		if (mult) {
			if ((b1.dY>0&&GDV5.KeysPressed[KeyEvent.VK_S])&&b1.intersects(p1)) {
				b1.speedx-=2;
				}
			if ((b1.dY<0&&GDV5.KeysPressed[KeyEvent.VK_W])&&b1.intersects(p1)) {
					b1.speedx-=2;
				}
			if ((b1.dY>0&&GDV5.KeysPressed[KeyEvent.VK_DOWN])&&b1.intersects(p3)) {
				b1.speedx+=2;
			}
			if ((b1.dY<0&&GDV5.KeysPressed[KeyEvent.VK_UP])&&b1.intersects(p3)) {
				b1.speedx+=2;
			}
		}
	}
}