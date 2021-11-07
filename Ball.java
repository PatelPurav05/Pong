package Pong;
import java.awt.Rectangle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.Font;
import java.awt.Graphics2D;
import utilities.GDV5;
public class Ball extends Rectangle {
	
	int dX,dY,score1,score2,maxX,maxY,scorep,scorec,countDownStarter;
	Paddle p1;
	Ball b1;
	int dirx = 1;
	int diry = 1;
	int speedx = 7;
	int speedy = 7;
	int minispeedx = 0;
public Ball(int x, int y, int w, int h) {
	super(x,y,w,h);
	
}
//autonomous ball movement
public void move() {
	dX = dirx * speedx;
	dY = diry * speedy;
	this.translate(dX,dY);

}
//the bounce method allows for the ball to change directions when it "hits" the borders of the game
public void bounce() {

	if (this.getX() >= GDV5.getMaxWindowX()-20) {
		scorep++;
	resetBall();
	
	}
	if ((this.getX()<=0)) {
		scorec++;
		resetBall();
		
	}
	if (this.getY() >= GDV5.getMaxWindowY()-20||(this.getY()<=0)) {
	diry*=-1;
	}
	
}
//the resetBall method resets the ball to the center of the field and waits three seconds before setting the speed of the ball back to the original state
public void resetBall() {
	this.x=(GDV5.getMaxWindowX()/2);
	this.y=(GDV5.getMaxWindowY() / 2);
	speedx=0;
	speedy=0;
	countDownStarter = 3;
	final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	final Runnable runnable = new Runnable() {
		public void run() {
			countDownStarter--;
			if(countDownStarter==0) {
				speedx=7;
				speedy=7;
				minispeedx=0;
				scheduler.shutdown();
			}
		}
	};
	scheduler.scheduleAtFixedRate(runnable, 0,1,java.util.concurrent.TimeUnit.SECONDS);
}
}


