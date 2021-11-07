package Pong;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;


public class Images {
		BufferedImage ball; {
		try {
			File file = new File("D:/Users/E-Radiance/eclipse-workspace/Pong/src/Pong/ball.png");
			FileInputStream fis = new FileInputStream(file);
			ball = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
		}
		BufferedImage paddlep2; {
		try {
			File file = new File("D:/Users/E-Radiance/eclipse-workspace/Pong/src/Pong/paddleBlue.png");
			FileInputStream fis = new FileInputStream(file);
			paddlep2 = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
		}
		BufferedImage paddlep1; {
			try {
				File file = new File("D:/Users/E-Radiance/eclipse-workspace/Pong/src/Pong/paddleOrange.png");
				FileInputStream fis = new FileInputStream(file);
				paddlep1 = ImageIO.read(fis);
			} catch (IOException e) {
				System.err.println(e);
			}
			}
		BufferedImage background; {
			try {
				File file = new File("D:/Users/E-Radiance/eclipse-workspace/Pong/src/Pong/background.png");
				FileInputStream fis = new FileInputStream(file);
				background = ImageIO.read(fis);
			} catch (IOException e) {
				System.err.println(e);
			}
			}
		BufferedImage wkey; {
			try {
				File file = new File("D:/Users/E-Radiance/eclipse-workspace/Pong/src/Pong/letter_w.png");
				FileInputStream fis = new FileInputStream(file);
				wkey = ImageIO.read(fis);
			} catch (IOException e) {
				System.err.println(e);
			}
			}
		BufferedImage skey; {
			try {
				File file = new File("D:/Users/E-Radiance/eclipse-workspace/Pong/src/Pong/letter_s.png");
				FileInputStream fis = new FileInputStream(file);
				skey = ImageIO.read(fis);
			} catch (IOException e) {
				System.err.println(e);
			}
			}
		BufferedImage updownkey; {
			try {
				File file = new File("D:/Users/E-Radiance/eclipse-workspace/Pong/src/Pong/image-keys-up-png-keyboard-up-and-down.png");
				FileInputStream fis = new FileInputStream(file);
				updownkey = ImageIO.read(fis);
			} catch (IOException e) {
				System.err.println(e);
			}
			}
}
