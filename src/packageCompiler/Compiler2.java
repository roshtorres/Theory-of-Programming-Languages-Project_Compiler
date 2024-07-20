package packageCompiler;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class Compiler2 {

	JFrame frm_Compiler;
	JTextArea textArea_Input;
	JTextArea textArea_Result;
	JTextArea textArea_Code;
	JButton btn_LexicalAnalysis;
	
	
	JFileChooser chooser; //= new JFileChooser();
	File f; //= chooser.getSelectedFile();
	BufferedReader br;
	String fileName; //= f.getAbsolutePath();
	FileReader fr; //= new FileReader(fileName);
	Scanner inFile;
	String line;
	
	/**
	 * Launch the application.
	 */
	public static void Compiler() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compiler2 window = new Compiler2();
					window.frm_Compiler.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Compiler2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String input;
		
		frm_Compiler = new JFrame();
		frm_Compiler.getContentPane().setBackground(new Color(230, 230, 250));
		frm_Compiler.setTitle("Compiler");
		frm_Compiler.setBounds(0, 0, 800, 500);
		frm_Compiler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_Compiler.setLocationRelativeTo(null); 
		frm_Compiler.getContentPane().setLayout(null);
		
		
		//--------------------BUTTON - OPEN FILE (START)--------------------
		JButton btn_OpenFile = new JButton("Open File");
		//btn_OpenFile.setFocusable(false);
		btn_OpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				f = chooser.getSelectedFile();
				fileName = f.getAbsolutePath();
				
				try
				{
					fr = new FileReader(fileName);
					br = new BufferedReader(fr);
					
					textArea_Input.read(br, null);
					br.close();
					textArea_Input.requestFocus();
					btn_LexicalAnalysis.setEnabled(true);
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, exc);
				}
			}
		});
		btn_OpenFile.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\4. Open File.png"));
		btn_OpenFile.setBounds(35, 35, 170, 70);
		frm_Compiler.getContentPane().add(btn_OpenFile);
		//--------------------BUTTON - OPEN FILE (END)--------------------
		
		
		//--------------------LABEL--------------------
		JLabel lbl_Compiler = new JLabel("Compiler");
		lbl_Compiler.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\9. Compiler.gif"));
		lbl_Compiler.setBounds(227, 35, 520, 50);
		frm_Compiler.getContentPane().add(lbl_Compiler);
		
		JLabel lbl_Input = new JLabel("Input:");
		lbl_Input.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 18));
		lbl_Input.setBounds(227, 103, 520, 25);
		frm_Compiler.getContentPane().add(lbl_Input);
		
		JLabel lbl_Result = new JLabel("Result:");
		lbl_Result.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 18));
		lbl_Result.setBounds(227, 183, 520, 25);
		frm_Compiler.getContentPane().add(lbl_Result);
		//------------------------------------------------
		
		
		//--------------------BUTTON - CLEAR (START)--------------------
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.setText(null);
				textArea_Result.setText(null);
				textArea_Code.setText(null);
			}
		});
		btn_Clear.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\8. Clear.png"));
		btn_Clear.setBounds(35, 358, 170, 70);
		frm_Compiler.getContentPane().add(btn_Clear);
		//--------------------BUTTON - CLEAR (END)--------------------
		
		
		//--------------------BUTTON - LEXICAL ANALYSIS (START)--------------------
		btn_LexicalAnalysis = new JButton("Lexical Analysis");
		btn_LexicalAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(frm_Compiler, "Please open a file first.");
				 btn_LexicalAnalysis.setEnabled(false);
				
				 inFile = new Scanner(System.in);
				 inFile = new Scanner(br);
				 File file = new File(inFile.nextLine());
				 line = inFile.nextLine();
				 
				 String srcLang = line;
				 String word[] = srcLang.split(" ");
				
				 char token = 'a';
				 for(int i = 0; i < word.length; i++) 
				 {
					 switch(token)
					 {
					 	//Data Type
					 	case 'a': if(word[i].contains("String"))
					 			  {
					 				  textArea_Code.setText("<data_type>");	 
					 				  token = 'b';
					 			  }
					 			  else if(word[i].contains("char"))
					 			  {
					 				  textArea_Code.setText("<data_type>");	
					 				  token = 'b';
					 			  }
					 			  else if(word[i].contains("int"))
					 			  {
					 				  textArea_Code.setText("<data_type>");	
					 				  token = 'b';
					 			  }
					 			  else if(word[i].contains("double"))
					 			  {
					 				  textArea_Code.setText("<data_type>");	
					 				  token = 'b';
			 			          }
					 			  break;
					 			  
					 	//Identifier
					 	case 'b': if(word[i].contains(""))
			 			  		  {
					 		          textArea_Code.setText("<identifier>");
			 			  			  if(word.length != 2)
			 			  			  {
			 				  		      token = 'c';
			 			  			  }
			 			  			  else
			 			  			  {
			 				  		      token = 'e';
			 				  		      i--;
			 			  			  }
			 			  		  }
					 			  else if(word[i].matches(".*[0-9]."))
					 			  {
					 				  textArea_Code.setText("<identifier>");
			 			  			  if(word.length != 2)
			 			  			  {
			 				  		      token = 'c';
			 			  			  }
			 			  			  else
			 			  			  {
			 				  		      token = 'e';
			 				  		      i--;
			 			  			  }
					 			  }
					 			  break;
					 			  
					 	//Assignment Operator
					 	case 'c': if(word[i].contains("="))
			 			  		  {
					 		          textArea_Code.setText("<assignment_operator>"); 
			 				  		  token = 'd';
			 			  		  }
					 			  break;
					 			  
					 	//Value
					 	case 'd': if(word[i].contains("\""))
			 			  		  {
					 		          textArea_Code.setText("<value>");
			 				          token = 'e';
			 			  		  }
					 			  else if(word[i].contains("'"))
				  		          {
					 				  textArea_Code.setText("<value>");
					  		          token = 'e';
				  		          }
					 			  else if(word[i].matches(".*[0-9]."))
			 			  		  {
					 				  textArea_Code.setText("<value>");
			 				  		  token = 'e';
			 			  		  }
					 			  i--;
					 			  break;
					 	
					 	//Delimiter
					 	case 'e': if(word[i].contains(";"))
			 			  		  {
					 				   textArea_Code.setText("<delimiter>");
			 			  		  }
					 			  break;
					 } 
				 }
			}
		});
		btn_LexicalAnalysis.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\5. Lexical Analysis.png"));
		btn_LexicalAnalysis.setBounds(35, 117, 170, 70);
		frm_Compiler.getContentPane().add(btn_LexicalAnalysis);
		//--------------------BUTTON - LEXICAL ANALYSIS (END)--------------------
		
		
		//--------------------BUTTON - SYNTAX ANALYSIS (START)--------------------
		JButton btn_SyntaxAnalysis = new JButton("Syntax Analysis");
		btn_SyntaxAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frm_Compiler, "Syntax Analysis will only enable after completing Lexical Analysis.");
				btn_SyntaxAnalysis.setEnabled(false);
				
				/*inFile = new Scanner(System.in);
				inFile = new Scanner(br);
				File file = new File(inFile.nextLine());
				line = inFile.nextLine();

		        if(checkSyntax(entTokens))
		        {
		        	textArea_Result.setText("Syntax is Correct!");
		        }
		        else
		        {
		        	textArea_Result.setText("Syntax is Error!");
		        }

			    public static boolean checkSyntax(String entTokens)
			    {
			        String word[] = entTokens.split(" ");
			        char j = 'a';

			        for(int i = 0; i < word.length; i++)
			        {
			            switch(j)
			            {
			                //Data Type
			                case 'a': if(word[i].contains("<data_type>"))
			                {
			                    j = 'b';
			                }
			                else
			                {
			                    return false;
			                }
			                    break;

			                //Identifier
			                case 'b': if(word[i].contains("<identifier>"))
			                {
			                    if(word.length == 5)
			                    {
			                        j = 'c';
			                    }
			                    else if(word.length == 3)
			                    {
			                        j = 'e';
			                    }
			                }
			                else
			                {
			                    return false;
			                }
			                    break;

			                //Assignment Operator
			                case 'c': if(word[i].contains("<assignment_operator>"))
			                {
			                    j = 'd';
			                }
			                else
			                {
			                    return false;
			                }
			                    break;

			                //Value
			                case 'd': if(word[i].contains("<value>"))
			                {
			                    j = 'e';
			                }
			                else
			                {
			                    return false;
			                }
			                    break;

			                //Delimiter
			                case 'e': if(word[i].contains("<delimiter>"))
			                {
			                    j = 'a';
			                }
			                else
			                {
			                    return false;
			                }
			                    break;
			            }
			        }
			        return true;
			    }*/
			}
		});
		btn_SyntaxAnalysis.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\6. Syntax Analysis.png"));
		btn_SyntaxAnalysis.setBounds(35, 197, 170, 70);
		frm_Compiler.getContentPane().add(btn_SyntaxAnalysis);
		//--------------------BUTTON - SYNTAX ANALYSIS (END)--------------------
		
		
		//--------------------BUTTON - SEMANTIC ANALYSIS (START)--------------------
		JButton btn_SemanticAnalysis = new JButton("Semantic Analysis");
		btn_SemanticAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frm_Compiler, "Semantic Analysis will only enable after completing Syntax Analysis.");
				btn_SemanticAnalysis.setEnabled(false);
				
				/*inFile = new Scanner(System.in);
				inFile = new Scanner(br);
				File file = new File(inFile.nextLine());
				line = inFile.nextLine();
				
				Scanner input = new Scanner(System.in);
		        String entStatement = input.nextLine();

		        String word[] = entStatement.split(" ");
		        String lastWord = word[word.length - 1];

		        //Length = 2
		        if(word.length == 2)
		        {
		            word[1] = word[1].replaceAll("[^a-zA-Z0-9]","");

		            if(word[0].contains("String") || word[0].contains("char"))
		            {
		                if(word[1].matches("^[A-Za-z0-9]*$"))
		                {
		                    textArea_Result.setText("Semantically Correct!");
		                }
		                else
		                {
		                    textArea_Result.setText("Semantically Incorrect!");
		                }
		            }
		            else if(word[0].contains("int") || word[0].contains("double"))
		            {
		                if(word[1].matches("^[A-Za-z0-9]*$"))
		                {
		                    textArea_Result.setText("Semantically Correct!");
		                }
		                else
		                {
		                    textArea_Result.setText("Semantically Incorrect!");
		                }
		            }
		            else
		            {
		                textArea_Result.setText("Error");
		            }
		        }

		        //Length = more than 2
		        else if(word.length > 2)
		        {
		            //String
		            if(word[0].contains("String"))
		            {
		                char first = word[3].charAt(0);
		                char last = lastWord.charAt(lastWord.length() - 2);

		                if(first == '"' && last == '"')
		                {
		                    textArea_Result.setText("Semantically Correct!");
		                }
		                else
		                {
		                    textArea_Result.setText("Semantically Incorrect!");
		                }

		            }
		            //char
		            else if(word[0].contains("char"))
		            {
		                char first = word[3].charAt(0);
		                char last = word[3].charAt(word[3].length() - 2);

		                if(word[3].length() == 4)
		                {
		                    if(first == '\'' && last == '\'')
		                    {
		                        textArea_Result.setText("Semantically Correct!");
		                    }
		                    else
		                    {
		                        textArea_Result.setText("Semantically Incorrect!");
		                    }
		                }
		                else
		                {
		                    textArea_Result.setText("Semantically Incorrect!");
		                }

		            }
		            //int
		            else if(word[0].contains("int"))
		            {

		                if(word[3].contains("-"))
		                {
		                    word[3] = word[3].replaceAll("-", "");
		                }

		                String intgr = word[3].replaceAll(";", "");
		                if(intgr.matches("\\d*"))
		                {
		                    textArea_Result.setText("Semantically Correct!");
		                }
		                else
		                {
		                    textArea_Result.setText("Semantically Incorrect!");
		                }

		            }
		            //double
		            else if(word[0].contains("double"))
		            {
		                if(word[3].contains("-"))
		                {
		                    word[3] = word[3].replaceAll("-", "");
		                }
		                if(word[3].contains("\"") || word[3].contains("'"))
		                {
		                    textArea_Result.setText("Semantically Incorrect!");
		                }
		                else if(word[3].contains("."))
		                {
		                    String dbl = word[3].replaceAll("[^a-zA-Z0-9]", "");

		                    if(dbl.matches("\\d*"))
		                    {
		                        textArea_Result.setText("Semantically Correct!");
		                    }
		                    else
		                    {
		                        textArea_Result.setText("Semantically Incorrect!");
		                    }
		                }
		                else
		                {
		                    textArea_Result.setText("Semantically Incorrect!");
		                }
		            }
		            else
		            {
		                textArea_Result.setText("Error");
		            }
		        }*/

			}
		});
		btn_SemanticAnalysis.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\7. Semantic Analysis.png"));
		btn_SemanticAnalysis.setBounds(35, 277, 170, 70);
		frm_Compiler.getContentPane().add(btn_SemanticAnalysis);
		//--------------------BUTTON - SEMANTIC ANALYSIS (END)--------------------
		
		
		//--------------------BUTTON - BACK (START)--------------------
		JButton btn_Back = new JButton("Back");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_Compiler.setVisible(false);
				Compiler1 window = new Compiler1();
				window.main(null);
			}
		});
		btn_Back.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\TPL Project - Compiler\\10. Back.png"));
		btn_Back.setBounds(567, 378, 180, 50);
		frm_Compiler.getContentPane().add(btn_Back);
		//--------------------BUTTON - END (START)--------------------
		
		
		//--------------------TEXT AREA--------------------
		textArea_Input = new JTextArea();
		textArea_Input.setEditable(false);
		textArea_Input.setFont(new Font("Poppins", Font.PLAIN, 25));
		textArea_Input.setBounds(227, 133, 520, 35);
		frm_Compiler.getContentPane().add(textArea_Input);
		
		textArea_Result = new JTextArea();
		textArea_Result.setEditable(false);
		textArea_Result.setBounds(227, 213, 520, 35);
		frm_Compiler.getContentPane().add(textArea_Result);
		
		textArea_Code = new JTextArea();
		textArea_Code.setEditable(false);
		textArea_Code.setBounds(227, 260, 520, 100);
		frm_Compiler.getContentPane().add(textArea_Code);
		//---------------------------------------------------
	}
}
