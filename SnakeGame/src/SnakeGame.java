import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGame {
	
	JFrame frame = new JFrame("Snake Game");
	Image star  = new ImageIcon("danger.png").getImage();
	int WIDTH = 128;
	int HEIGHT = 92;
	int SCALE = 10;
	int SPEED = 50;
	int time = 30;
	boolean end = false;
	boolean vic = false;
	
	int highscore = 4;
	int score = 4;
	int x = 20;
	int y = 10;
	int xStep = 1;
	int yStep = 0;
	
	Madi food = new Madi(0, 0);
	Madi danger = new Madi(0,0);
	Madi danger1 = new Madi(0,0);
	Madi danger2 = new Madi(0,0);
	Madi danger3 = new Madi(0,0);
	Madi danger4 = new Madi(0,0);
	
	Madi dan1 = new Madi(0,0);
	Madi dan2 = new Madi(0,0);
	ArrayList<Madi> snake = new ArrayList<>();
	
	public SnakeGame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		
		frame.setResizable(false); //크기조절 못하게?
		frame.setLocationRelativeTo(null); //  처음창이 중앙에
		
		
		frame.getContentPane().add(new GamePanel());
		
		snake.add(new Madi(x, y));
		snake.add(new Madi(x - 1, y));
		snake.add(new Madi(x - 2, y));
		snake.add(new Madi(x - 3, y));
		
		
		food = new Madi( (int)( Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
		
		dan1 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
		
		dan2 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
		
		danger = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
		
		danger1 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
		
		danger2 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
		
		danger3 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
		
		danger4 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
		
		frame.addKeyListener(new GameListener());
		
		frame.setVisible(true);
	}
	
	public void go() {
		while (true) {
			x += xStep;
			y += yStep;
			
			if ((x == food.getX()) && (y == food.getY())) {
				snake.add(new Madi(0, 0));
				food = new Madi( (int)(Math.random() *(WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
				score += 1;
			}
			
			if ((x == dan1.getX()) && (y == dan1.getY())) {
				snake.remove(snake.size() -1);
				dan1 = new Madi( (int)(Math.random() *(WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
				score -= 1;
			}
			
			if ((x == dan2.getX()) && (y == dan2.getY())) {
				snake.remove(snake.size() -1);
				dan2 = new Madi( (int)(Math.random() *(WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
				score -= 1;
			}
			
			if ((x == danger.getX()+4) && (y == danger.getY()) || (x == (danger.getX())+4) && (y == (danger.getY())+2) ||
					(x == (danger.getX())+4) && (y == (danger.getY())+3) || (x == (danger.getX())+4) && (y == (danger.getY())+4)
					|| 
					(x == danger.getX()) && (y == danger.getY()+1) || (x == (danger.getX())) && (y == (danger.getY())+2) ||
					(x == (danger.getX())) && (y == (danger.getY())+3) || (x == (danger.getX())) && (y == (danger.getY())+4)
					||
					(x == danger.getX()+1) && (y == danger.getY()) || (x == (danger.getX())+2) && (y == (danger.getY())) ||
					(x == (danger.getX())+3) && (y == (danger.getY())) || (x == (danger.getX())+4) && (y == (danger.getY()))
					||
					(x == danger.getX()) && (y == danger.getY()) || (x == (danger.getX())+2) && (y == (danger.getY())) ||
					(x == (danger.getX())+3) && (y == (danger.getY())) || (x == (danger.getX())+4) && (y == (danger.getY()))) {
				snake.remove(snake.size() -1);
				
				score -= 1;
				danger = new Madi( (int)(Math.random() *(WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));
				
			}
			if ((x == danger1.getX()+4) && (y == danger1.getY()) || (x == (danger1.getX())+4) && (y == (danger1.getY())+2) ||
					(x == (danger1.getX())+4) && (y == (danger1.getY())+3) || (x == (danger1.getX())+4) && (y == (danger1.getY())+4)
					|| 
					(x == danger1.getX()) && (y == danger1.getY()+1) || (x == (danger1.getX())) && (y == (danger1.getY())+2) ||
					(x == (danger1.getX())) && (y == (danger1.getY())+3) || (x == (danger1.getX())) && (y == (danger1.getY())+4)
					||
					(x == danger1.getX()+1) && (y == danger1.getY()) || (x == (danger1.getX())+2) && (y == (danger1.getY())) ||
					(x == (danger1.getX())+3) && (y == (danger1.getY())) || (x == (danger1.getX())+4) && (y == (danger1.getY()))
					||
					(x == danger1.getX()) && (y == danger1.getY()) || (x == (danger1.getX())+2) && (y == (danger1.getY())) ||
					(x == (danger1.getX())+3) && (y == (danger1.getY())) || (x == (danger1.getX())+4) && (y == (danger1.getY())))
			{
				snake.remove(snake.size() -1);
				
				score -=1;
				danger1 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));	
			}
	
			if ((x == danger2.getX()+4) && (y == danger2.getY()) || (x == (danger2.getX())+4) && (y == (danger2.getY())+2) ||
					(x == (danger2.getX())+4) && (y == (danger2.getY())+3) || (x == (danger2.getX())+4) && (y == (danger2.getY())+4)
					|| 
					(x == danger2.getX()) && (y == danger2.getY()+1) || (x == (danger2.getX())) && (y == (danger2.getY())+2) ||
					(x == (danger2.getX())) && (y == (danger2.getY())+3) || (x == (danger2.getX())) && (y == (danger2.getY())+4)
					||
					(x == danger2.getX()+1) && (y == danger2.getY()) || (x == (danger2.getX())+2) && (y == (danger2.getY())) ||
					(x == (danger2.getX())+3) && (y == (danger2.getY())) || (x == (danger2.getX())+4) && (y == (danger2.getY()))
					||
					(x == danger2.getX()) && (y == danger2.getY()) || (x == (danger2.getX())+2) && (y == (danger2.getY())) ||
					(x == (danger2.getX())+3) && (y == (danger2.getY())) || (x == (danger2.getX())+4) && (y == (danger2.getY())))
			{
				snake.remove(snake.size() -1);
				
				score -=1;
				danger2 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));	
			}
			if ((x == danger3.getX()+4) && (y == danger3.getY()) || (x == (danger3.getX())+4) && (y == (danger3.getY())+2) ||
					(x == (danger3.getX())+4) && (y == (danger3.getY())+3) || (x == (danger3.getX())+4) && (y == (danger3.getY())+4)
					|| 
					(x == danger3.getX()) && (y == danger3.getY()+1) || (x == (danger3.getX())) && (y == (danger3.getY())+2) ||
					(x == (danger3.getX())) && (y == (danger3.getY())+3) || (x == (danger3.getX())) && (y == (danger3.getY())+4)
					||
					(x == danger3.getX()+1) && (y == danger3.getY()) || (x == (danger3.getX())+2) && (y == (danger3.getY())) ||
					(x == (danger3.getX())+3) && (y == (danger3.getY())) || (x == (danger3.getX())+4) && (y == (danger3.getY()))
					||
					(x == danger3.getX()) && (y == danger3.getY()) || (x == (danger3.getX())+2) && (y == (danger3.getY())) ||
					(x == (danger3.getX())+3) && (y == (danger3.getY())) || (x == (danger3.getX())+4) && (y == (danger3.getY()))) {
				snake.remove(snake.size() -1);
				
				score -=1;
				danger3 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));	
			}
			if  ((x == danger4.getX()+4) && (y == danger4.getY()) || (x == (danger4.getX())+4) && (y == (danger4.getY())+2) ||
					(x == (danger4.getX())+4) && (y == (danger4.getY())+3) || (x == (danger4.getX())+4) && (y == (danger4.getY())+4)
					|| 
					(x == danger4.getX()) && (y == danger4.getY()+1) || (x == (danger4.getX())) && (y == (danger4.getY())+2) ||
					(x == (danger4.getX())) && (y == (danger4.getY())+3) || (x == (danger4.getX())) && (y == (danger4.getY())+4)
					||
					(x == danger4.getX()+1) && (y == danger4.getY()) || (x == (danger4.getX())+2) && (y == (danger4.getY())) ||
					(x == (danger4.getX())+3) && (y == (danger4.getY())) || (x == (danger4.getX())+4) && (y == (danger4.getY()))
					||
					(x == danger4.getX()) && (y == danger4.getY()) || (x == (danger4.getX())+2) && (y == (danger4.getY())) ||
					(x == (danger4.getX())+3) && (y == (danger4.getY())) || (x == (danger4.getX())+4) && (y == (danger4.getY()))) {
				snake.remove(snake.size() -1);
				
				score -=1;
				danger4 = new Madi( (int)(Math.random() * (WIDTH-SCALE*2)), (int) (Math.random() * (HEIGHT-SCALE*2)));	
				
				
			}
			for (int i = snake.size() -1; i > 0; i--) {
				snake.get(i).setX(snake.get(i -1).getX());
				snake.get(i).setY(snake.get(i -1).getY());
			}
			snake.get(0).setX(x);
			snake.get(0).setY(y);
			
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (highscore < score) {
				highscore = score;
			}
			frame.repaint();
			if (score == 1) {
				end = true;
				break;
				
			}
			if (score == 10) {
				vic = true;
				break;
			}
		}
		
	}
	class GamePanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.gray);
			
			g.drawImage(star, dan1.getX(), dan1.getY(), SCALE, SCALE, this);
			
			
			g.setColor(Color.black);
			for (Madi madi : snake) {
				g.fillRect(madi.getX() * SCALE, madi.getY() * SCALE, SCALE, SCALE);
			}
			
			g.setColor(Color.white);
			for (Madi madi : snake) {
				g.drawRect(madi.getX() * SCALE, madi.getY() * SCALE, SCALE, SCALE);
			}
			
			g.setColor(Color.blue);
			g.fillRect(food.getX() * SCALE, food.getY() * SCALE, SCALE, SCALE);
			
			g.setColor(Color.red);
			g.fillRect(dan1.getX() * SCALE, dan1.getY() * SCALE, SCALE, SCALE);
			
			g.setColor(Color.red);
			g.fillRect(dan2.getX() * SCALE, dan2.getY() * SCALE, SCALE, SCALE);
			
			g.setColor(Color.red);
			g.fillRect(danger.getX() * SCALE, danger.getY() * SCALE, SCALE*5, SCALE*5);
			
			g.setColor(Color.green);
			g.fillRect(danger1.getX() * SCALE, danger1.getY() * SCALE, SCALE*5, SCALE*5);
			
			g.setColor(Color.yellow);
			g.fillRect(danger2.getX() * SCALE, danger2.getY() * SCALE, SCALE*5, SCALE*5);
			
			g.setColor(Color.pink);
			g.fillRect(danger3.getX() * SCALE, danger3.getY() * SCALE, SCALE*5, SCALE*5);
			
			g.setColor(Color.black);
			g.fillRect(danger4.getX() * SCALE, danger4.getY() * SCALE, SCALE*5, SCALE*5);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("length = " + score, 30, 50);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("HIGH SCORE = " + highscore, 1000, 50);
			
			
			if (end == true) {
				g.setColor(Color.white);
				g.setFont(new Font("Arial", Font.BOLD, 100));
				g.drawString("retry? " , 500, 600);
			}
			if (vic == true) {
				g.setColor(Color.blue);
				g.setFont(new Font("Arial", Font.BOLD, 100));
				g.drawString("clear " , 500, 600);
			}
		}
		
	}
	class GameListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					xStep = 0;
					yStep = -1;
					break;
				case KeyEvent.VK_DOWN:
					xStep = 0;
					yStep = 1;
					break;
				case KeyEvent.VK_LEFT:
					xStep = -1;
					yStep = 0;
					break;
				case KeyEvent.VK_RIGHT:
					xStep = 1;
					yStep = 0;
					break;
			
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class Madi {
		int x = 0;
		int y = 0;
		
		public Madi(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		
	}
	
	
	
	
	
}
