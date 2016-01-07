//By Sujata Regoti
//Date: 2 April 2015
package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class TicTacToe extends JPanel implements ActionListener	{

	
	private static final long serialVersionUID = 1L;

	private static int hei;

	private static int wid;

	private static int w;

	private static int h;

	private static JFrame f;

	JButton b[];
	String won=null;
	Icon ic;
	boolean turn=true,flg=false;

	private JPanel p;

	/**
	 * Create the panel.
	 */
	public TicTacToe() {
		p=new JPanel(new GridLayout(3,3));
		setLayout(new BorderLayout());
		add(p);
		ic=new ImageIcon(TicTacToe.class.getResource("/images/1.png"));
		b=new JButton[9];

		for(int i=0;i<b.length;i++)
		{
	
			b[i]=new JButton(ic);
			b[i].addActionListener(this);
			p.add(b[i]);
		}
	}
	public static void main(String args[]){
		create();
		
	}
	public static void create() {
		f=new JFrame("Tic Tac Toe Game");
		f.add(new TicTacToe());
		GraphicsDevice gd=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		wid=gd.getDisplayMode().getWidth();
		hei=gd.getDisplayMode().getHeight();
		w=460;h=330;
		f.setBounds(wid/2-w/2,hei/2-h/2,w,h);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton bb=(JButton) e.getSource();
		flg=false;
		if(bb.getText().equals(""))
		{
		
			if(turn)
			{
	
				bb.setText("x");
				bb.setIcon(new ImageIcon(TicTacToe.class.getResource("/images/bx.png")));
				turn =false;
				won=check("x");
			}
			else
			{
				
				bb.setText("o");
				bb.setIcon(new ImageIcon(TicTacToe.class.getResource("/images/o.png")));
				turn =true;
				won=check("o");
			}
			

		}
		
		for(int i=0;i<b.length;i++)
		{
			if(b[i]!=bb&&b[i].getText().equals(""))
			{
				
				flg=true;
				break;
			}
			
		}

		if(!flg)
		{
			won="both";
			//repaint();
		}
		if(won!=null)
				declare();

	}
	
	public void declare() {
		
		System.out.println("won: "+won);
		if(won!=null)
		{
			JLabel l=new JLabel("",JLabel.CENTER);
			l.setForeground(Color.yellow);
			l.setBackground(Color.BLUE);
			l.setFont(new Font("Tahoma",Font.BOLD,24));
			
		
			if(won.equals("x"))
			{
				
				l.setText("Player1 won!!");
				
			}
			else if(won.equals("o"))
			{
				
				l.setText("Player2 won!!");
			}
			else{
				l.setText("Both Won !!");
			}
			final JFrame frm=new JFrame();
			p=new JPanel(new GridLayout(0,1));
			p.setBackground(Color.blue);
			
			//bottom message
			JLabel l1=new JLabel("Press Enter to continue..",JLabel.CENTER);
			l1.setForeground(Color.white);
			l1.setFont(new Font("Tahoma",Font.BOLD,20));
			
			p.add(l);
			p.add(l1);
			frm.add(p);
			frm.setBounds(wid/2-w/2,hei/2-h/2,w,h);
			frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frm.setVisible(true);
			TicTacToe.f.setVisible(false);
			TicTacToe.f.dispose();
			
			//Mapping action ==> keystroke enter
			//so whenever enter is pressed action related to "action" is get perform
			
			p.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"action");
			p.getActionMap().put("action", new AbstractAction() {
				
			
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					frm.setVisible(false);
					frm.dispose();
					TicTacToe.main(null);
				}
			});
			
		}
		
	}
	//check if any player won
	public String  check(String g)
	{
		if(b[0].getText().equals(g)&&b[1].getText().equals(g)&&b[2].getText().equals(g))
			return g;

		if(b[3].getText().equals(g)&&b[4].getText().equals(g)&&b[5].getText().equals(g))
			return g;

		if(b[6].getText().equals(g)&&b[7].getText().equals(g)&&b[8].getText().equals(g))
			return g;

		if(b[0].getText().equals(g)&&b[3].getText().equals(g)&&b[6].getText().equals(g))
			return g;

		if(b[1].getText().equals(g)&&b[4].getText().equals(g)&&b[7].getText().equals(g))
			return g;

		if(b[2].getText().equals(g)&&b[5].getText().equals(g)&&b[8].getText().equals(g))
			return g;

		if(b[0].getText().equals(g)&&b[4].getText().equals(g)&&b[8].getText().equals(g))
			return g;

		if(b[2].getText().equals(g)&&b[4].getText().equals(g)&&b[6].getText().equals(g))
			return g;
		
		
		
		//return g;
		return null;
	}
		
}

