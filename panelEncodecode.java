import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class panelEncodecode extends JPanel
{
	JLabel lbl_accountcode, lbl_codetype, lbl_accountname, lbl_typedescription;
	JTextField text_accountcode, text_codetype, text_accountname, text_typedescription;
	JPanel panel_encode, panel_north, panel_south;
	JButton btn_add, btn_view, btn_update, btn_confirm;
	
	public panelEncodecode()
	{
		setLayout(new BorderLayout());
		
		HandleControlButton control = new HandleControlButton();
		HandleKeyListener keycontrol = new HandleKeyListener();
		
		panel_encode = new JPanel();
		panel_north = new JPanel();
		panel_south = new JPanel();
		
		panel_encode.setLayout(new GridBagLayout());
		panel_north.setLayout(new BorderLayout());
		panel_south.setLayout(new FlowLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		btn_add = new JButton("Add");
		btn_add.setMnemonic(KeyEvent.VK_A);
		btn_add.addActionListener(control);
		btn_view = new JButton("View");
		btn_view.setMnemonic(KeyEvent.VK_V);
		btn_view.addActionListener(control);
		btn_update = new JButton("Update and Browse");
		btn_update.setMnemonic(KeyEvent.VK_D);
		btn_update.addActionListener(control);
		btn_confirm = new JButton("Confirm");
		btn_confirm.addActionListener(control);
		btn_confirm.addKeyListener(keycontrol);
		
		lbl_accountcode = new JLabel("Account Code :");
		lbl_codetype = new JLabel("Code Type :");
		lbl_accountname = new JLabel("Account Name :");
		lbl_typedescription = new JLabel("Type Description :");
		
		lbl_accountcode.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_codetype.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_accountname.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_typedescription.setFont(new Font("Arial", Font.PLAIN, 20));
		
		text_accountcode = new JTextField(10);
		text_accountcode.addKeyListener(keycontrol);
		text_codetype = new JTextField(10);
		text_codetype.addKeyListener(keycontrol);
		text_accountname = new JTextField(30);
		text_accountname.addKeyListener(keycontrol);
		text_typedescription = new JTextField(30);
		text_typedescription.addKeyListener(keycontrol);
		
		text_accountcode.setFont(new Font("Arial", Font.PLAIN, 20));
		text_codetype.setFont(new Font("Arial", Font.PLAIN, 20));
		text_accountname.setFont(new Font("Arial", Font.PLAIN, 20));
		text_typedescription.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//first row
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,0,0,10);
		c.anchor = GridBagConstraints.LINE_END;
		panel_encode.add(lbl_accountcode, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_accountcode, c);
		
		//second row
		
		c.gridy++;
		c.gridx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		panel_encode.add(lbl_codetype, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_codetype, c);
		
		//third row
		
		c.gridy++;
		c.gridx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		panel_encode.add(lbl_accountname, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_accountname, c);
		
		//fourth row
		
		c.gridy++;
		c.gridx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		panel_encode.add(lbl_typedescription, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_typedescription, c);
		
		//fifth row
		
		c.gridy++;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		panel_encode.add(btn_confirm, c);
		
		panel_south.add(btn_add);
		panel_south.add(btn_view);
		panel_south.add(btn_update);
		
		panel_north.add(panel_encode, BorderLayout.CENTER);
		
		add(panel_north, BorderLayout.CENTER);
		add(panel_south, BorderLayout.SOUTH);
		
		text_accountcode.requestFocus();
	}
	
	class HandleControlButton implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			Object source = e.getSource();
			
			if (source == btn_confirm)
			{
				JDialog.setDefaultLookAndFeelDecorated(true);
				
				int response = JOptionPane.showConfirmDialog(null, "Do you want to add code record?", "Confirm Add", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (response == JOptionPane.NO_OPTION)
				{
					System.out.println("No option selected");
				}
				else if (response == JOptionPane.YES_OPTION)
				{
					dbconnect connect = new dbconnect();
				
					String accountcode = text_accountcode.getText();
					String codetype = text_codetype.getText();
					String accountname = text_accountname.getText();
					String description = text_typedescription.getText();
						
					try
					{
						connect.addCode(accountcode, codetype, accountname, description);
						connect.close();
					}
					catch (Exception x)
					{
						System.out.println(x);
					}
					
					text_accountcode.setText("");
					text_codetype.setText("");
					text_accountname.setText("");
					text_typedescription.setText("");
					
					text_accountcode.requestFocus();
				}
				else if (response == JOptionPane.CLOSED_OPTION)
				{
					System.out.println("Closed window");
				}
			}
			
			if (source == btn_view)
			{
				panel_north.removeAll();
				repaint();
				revalidate();
				
				try
				{
					panel_north.add(new panelEncodecodeview(), BorderLayout.CENTER);
					repaint();
					revalidate();
				}
				catch (Exception d)
				{
					System.out.println("error panel encode code view");
				}				
			}
			
			if (source == btn_add)
			{
				panel_north.removeAll();
				repaint();
				revalidate();
				
				panel_north.add(panel_encode, BorderLayout.CENTER);
				repaint();
				revalidate();
				text_accountcode.requestFocus();
			}
			
			if (source == btn_update)
			{
				panel_north.removeAll();
				repaint();
				revalidate();
				
				panel_north.add(new panelEncodecodeupdate(), BorderLayout.CENTER);
				repaint();
				revalidate();
				
			}
		}
	}
	
	class HandleKeyListener implements KeyListener
	{
		public void keyTyped(KeyEvent e)
		{
			/*
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				System.out.println("up key pressed");
			}
			*/
		}
		
		public void keyReleased(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				if (btn_confirm.hasFocus())
					text_typedescription.requestFocus();
				if (text_typedescription.hasFocus())
					text_accountname.requestFocus();
				if (text_accountname.hasFocus())
					text_codetype.requestFocus();
				if (text_codetype.hasFocus())
					text_accountcode.requestFocus();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if (text_accountcode.hasFocus())
					text_codetype.requestFocus();
				if (text_codetype.hasFocus())
					text_accountname.requestFocus();
				if (text_accountname.hasFocus())
					text_typedescription.requestFocus();
				if (text_typedescription.hasFocus())
					btn_confirm.requestFocus();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if (text_accountcode.hasFocus())
					text_codetype.requestFocus();
				if (text_codetype.hasFocus())
					text_accountname.requestFocus();
				if (text_accountname.hasFocus())
					text_typedescription.requestFocus();
				if (text_typedescription.hasFocus())
					btn_confirm.requestFocus();
				if (btn_confirm.hasFocus())
				{
					JDialog.setDefaultLookAndFeelDecorated(true);
				
					int response = JOptionPane.showConfirmDialog(null, "Do you want to add code record?", "Confirm Add", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
					if (response == JOptionPane.NO_OPTION)
					{
						System.out.println("No option selected");
					}
					else if (response == JOptionPane.YES_OPTION)
					{
						dbconnect connect = new dbconnect();
					
						String accountcode = text_accountcode.getText();
						String codetype = text_codetype.getText();
						String accountname = text_accountname.getText();
						String description = text_typedescription.getText();
							
						try
						{
							connect.addCode(accountcode, codetype, accountname, description);
							connect.close();
						}
						catch (Exception x)
						{
							System.out.println(x);
						}
						
						text_accountcode.setText("");
						text_codetype.setText("");
						text_accountname.setText("");
						text_typedescription.setText("");
						
						text_accountcode.requestFocus();
					}
					else if (response == JOptionPane.CLOSED_OPTION)
					{
						System.out.println("Closed window");
					}
				}				
			}
		}
		
		public void keyPressed(KeyEvent e) 
		{
			/*
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("Right key pressed");
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("Left key pressed");
			}
			*/
		}
	}
}