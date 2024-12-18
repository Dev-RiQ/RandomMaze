package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

	GamePanel gp;
	Font arial_40, arial_80B;
	BufferedImage keyImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00"); // 표기 방식 지정 
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial",Font.PLAIN,40);
		arial_80B = new Font("Arial",Font.BOLD,80);
	}
	// 이벤트 메세지
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		if(gameFinished == true) {// 게임 클리어 메세지
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			String text;
			int textLength;
			int x;
			int y;
			
			text = "You found exit !";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // 글자 픽셀 추출
			x = gp.screenWidth/2 - textLength/2; // 가운데 출력
			y = gp.screenHeight/2 - (gp.tileSize * 3);
			g2.drawString(text, x, y);
			
			text = "Your Time is : "+dFormat.format(playTime) + " !";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // 글자 픽셀 추출
			x = gp.screenWidth/2 - textLength/2; // 가운데 출력
			y = gp.screenHeight/2 + (gp.tileSize * 4);
			g2.drawString(text, x, y);
			
			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			
			text = "Congratulations !";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // 글자 픽셀 추출
			x = gp.screenWidth/2 - textLength/2; // 가운데 출력
			y = gp.screenHeight/2 + (gp.tileSize * 2);
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
		}else { // 게임 진행 중 메세지
			// 시간 측정
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			playTime += (double)1/60;
			g2.drawString("Time : "+dFormat.format(playTime),gp.tileSize*11,65);
		}
	}
}
