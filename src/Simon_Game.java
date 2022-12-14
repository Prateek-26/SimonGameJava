import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.*;
import java.io.*;

class Game extends JFrame implements ActionListener{
	static int level =0;
	static int high = 0;
	String str1 = "Great Going..Keep it Up!";
	String str2 = "Wrong Sequence!!, Start Again!";
//	Image image;
	Color clr1 = new Color(1, 31, 63); // royal kind of blue
	Color clr2 = new Color(141,0,0); // maroon
	Color clr3 = new Color(0,19,114); // light royal blue
	Color white = new Color(255,255,255); 
	static boolean started = false;
	Container c = getContentPane();
	JButton btn0,btn1,btn2,btn3,start_btn;
	JLabel heading,curr_score,curr_score_result, high_score,high_score_result, result, made_by;
	String buttonColors[] = {"red","green","blue","yellow"};
	ArrayList<Integer> gamePattern = new ArrayList<Integer>();
	ArrayList<Integer> userPattern = new ArrayList<Integer>();
	Game(){
		
		// All about the Frame
		JFrame frame = new JFrame();
		setTitle("SIMON");
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		c.setLayout(null);
		c.setBackground(clr1);
		
		Font f1 = new Font("Gill Sans Ultra Bold",Font.BOLD,28);
		Font f2 = new Font("Sans Serif",Font.BOLD,14);
		Font f3 = new Font("Gill Sans Ultra Bold",Font.BOLD,14);
		Font f4 = new Font("Verdana",Font.BOLD,8);
		Font f5 = new Font("Verdana",Font.BOLD,12);
		// All the Labels
		
		heading = new JLabel("THE SIMON GAME");
		curr_score = new JLabel("Current Score: ");
		curr_score_result = new  JLabel("0");
		high_score = new JLabel("High Score :");
		high_score_result = new JLabel("0");
		result = new JLabel("Click on START to begin");
		made_by = new JLabel("Created and Designed by Prateek Sharma");
		
		heading.setBounds(80,10,500,30);
		curr_score.setBounds(330,70,110,20);
		curr_score_result.setBounds(450,70,30,20);
		high_score.setBounds(330,50,200,20);
		high_score_result.setBounds(450,50,30,20);
		result.setBounds(130,450,300,20);
		made_by.setBounds(145,540,300,20);
		
//		result.setVisible(true);
		
		heading.setFont(f1);
		curr_score.setFont(f2);
		high_score.setFont(f2);
		result.setFont(f3);
		made_by.setFont(f4);
		
		heading.setForeground(white);
		curr_score.setForeground(white);
		high_score.setForeground(white);
		result.setForeground(white);
		made_by.setForeground(white);
		curr_score_result.setForeground(white);
		high_score_result.setForeground(white);
		
		add(curr_score);
		add(curr_score_result);
		add(high_score);
		add(high_score_result);
		add(result);
		add(made_by);
		add(heading);
		
		// Buttons
		btn0=new JButton("0");
		btn0.setBounds(115,115,120,120);
		add(btn0);
		
		btn1=new JButton("1");
		btn1.setBounds(245,115,120,120);
		add(btn1);
		
		btn2=new JButton("2");
		btn2.setBounds(115,245,120,120);
		add(btn2);
		
		btn3=new JButton("3");
		btn3.setBounds(245,245,120,120);
		add(btn3);
		
		start_btn=new JButton("START");
		start_btn.setBounds(190,380,100,30);
		add(start_btn);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn0.addActionListener(this);
		start_btn.addActionListener(this);
		
		btn1.setBackground(Color.red);
		btn2.setBackground(Color.green);
		btn3.setBackground(Color.blue);
		btn0.setBackground(Color.yellow);
		
		btn0.setFocusPainted(false);
		btn1.setFocusPainted(false);
		btn2.setFocusPainted(false);
		btn3.setFocusPainted(false);
		
		btn0.setBorderPainted(false);
		btn1.setBorderPainted(false);
		btn2.setBorderPainted(false);
		btn3.setBorderPainted(false);
		
		start_btn.setBorderPainted(false);
		start_btn.setFocusPainted(false);
//		start_btn.setContentAreaFilled(false);
		start_btn.setBackground(Color.black);
		start_btn.setForeground(white);
		start_btn.setFont(f5);
		
		btn0.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn0.setBounds(110,110,130,130);
				btn0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				btn0.setBounds(115,115,120,120);
			}
		});
		
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn1.setBounds(240,110,130,130);
				btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
				btn1.setBounds(245,115,120,120);
			}
		});
		
		btn2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn2.setBounds(110,240,130,130);
				btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				btn2.setBounds(115,245,120,120);
			}
		});
		
		btn3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn3.setBounds(240,240,130,130);
				btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				btn3.setBounds(245,245,120,120);
			}
		});
		
		start_btn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				start_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		setVisible(true);
	}
	
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="START") {
				c.setBackground(clr1);
				result.setBounds(130,450,300,20);
				result.setText("The Game Has Begun!..");
				String s = Integer.toString(level);
				curr_score_result.setText(s);
				delay_boi();
				nextSequence();
			}
			else {
				String colorChoosed = e.getActionCommand();
				int coloId = Integer.parseInt(colorChoosed);
				System.out.print("Color Choosed: "+coloId+" ");
				userPattern.add(coloId);
				System.out.print("\nUP: "+userPattern+"\n");	
				verify(userPattern.size()-1);
			}
		}
		
		public void nextSequence() {
			userPattern.removeAll(userPattern);
			System.out.print("\nUP: "+userPattern+"\n");
			
			int randomNumber = (int)(Math.random()*4);
			gamePattern.add(randomNumber);
			System.out.print("\nGP: "+gamePattern+" ");
			animatein(randomNumber);
			
			System.out.print(randomNumber+"\n");
		}
		
		public void verify(int curr_len) {
			if(gamePattern.get(curr_len)==userPattern.get(curr_len)) {
				System.out.print("True\n"+"Upsz: "+userPattern.size()+"Gpsz: "+gamePattern.size()+"\n");
				result.setText(str1);
				if(gamePattern.size()==userPattern.size()) {
//					System.out.print("|nEk level Paar");
					level++;
					String s = Integer.toString(level);
					curr_score_result.setText(s);
					String h = Integer.toString(0);
					if(high<level) {
						high=level;
						String a = Integer.toString(high);
						high_score_result.setText(a);
						result.setVisible(true);	
					}
					System.out.print("\nlevel: "+level+"\n");
//					Thread.sleep(3);
					delay_boi();
					nextSequence();					
				}
			}
			else {
//				result.setBounds(110,450,300,20);
//				result.setText(str2);
				System.out.print("False");
				level=0;
				String s = Integer.toString(level);
				curr_score_result.setText(s);
				restart();
			}
		}
		public void restart() {
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			result.setForeground(Color.red);
			c.setBackground(clr2);
			result.setBounds(90,450,300,20);
			result.setText(str2);
			userPattern.removeAll(userPattern);
			gamePattern.removeAll(gamePattern);
		}
		
		public void delay_boi() {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void animatein(int no) {
			switch(no) {
			case 0: {
				btn0.setBounds(110,110,130,130);
				CompletableFuture.delayedExecutor(300,TimeUnit.MILLISECONDS).execute(()->{
					btn0.setBounds(115,115,120,120);
				});
				break;
			}
			case 1: {
				btn1.setBounds(240,110,130,130);
				CompletableFuture.delayedExecutor(300,TimeUnit.MILLISECONDS).execute(()->{
					btn1.setBounds(245,115,120,120);
				});
				break;
			}
			case 2: {
				btn2.setBounds(110,240,130,130);
				CompletableFuture.delayedExecutor(300,TimeUnit.MILLISECONDS).execute(()->{
					btn2.setBounds(115,245,120,120);
				});
				break;
			}
			case 3: {
				btn3.setBounds(240,240,130,130);
				CompletableFuture.delayedExecutor(300,TimeUnit.MILLISECONDS).execute(()->{
					btn3.setBounds(245,245,120,120);
				});
				break;
			}
			}
		}
}
public class Simon_Game {
	public static void main(String[] args) {
		Game obj = new Game();
	}
}