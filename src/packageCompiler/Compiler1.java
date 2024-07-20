package packageCompiler;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Compiler1 {

	private JFrame frm_Home;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compiler1 window = new Compiler1();
					window.frm_Home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Compiler1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm_Home = new JFrame();
		frm_Home.getContentPane().setBackground(new Color(230, 230, 250));
		frm_Home.setTitle("Introductory");
		frm_Home.setBounds(0, 0, 800, 500);
		frm_Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_Home.setLocationRelativeTo(null); 
		frm_Home.getContentPane().setLayout(null);
		
		
		//--------------------LABEL--------------------
		JLabel lbl_Title = new JLabel("Title");
		lbl_Title.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\1. Title.gif"));
		lbl_Title.setBounds(60, 55, 658, 265);
		frm_Home.getContentPane().add(lbl_Title);
		//----------------------------------------------
		
		
		//--------------------BUTTON - PROCEED (START)--------------------
		JButton btn_Proceed = new JButton("Proceed");
		btn_Proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//-----Proceed Window-----
				Compiler2 nw = new Compiler2();
				nw.frm_Compiler.setVisible(true);
				frm_Home.dispose();
			}
		});
		btn_Proceed.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\2. Proceed.png"));
		btn_Proceed.setBounds(108, 345, 270, 60);
		frm_Home.getContentPane().add(btn_Proceed);
		//--------------------BUTTON - PROCEED (END)--------------------
		
		
		//--------------------BUTTON - EXIT (START)--------------------
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_Home = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frm_Home, "Confirm if you want to exit", "Compiler",
				   JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btn_Exit.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\3. Exit.png"));
		btn_Exit.setBounds(401, 345, 270, 60);
		frm_Home.getContentPane().add(btn_Exit);
		//--------------------BUTTON - EXIT (END)--------------------
		
	}
}
