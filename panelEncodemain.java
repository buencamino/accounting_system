import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.text.*;
import java.util.Date;


public class panelEncodemain extends JPanel
{
	JLabel lbl_page, lbl_line, lbl_refpage, lbl_refline, lbl_transdate, lbl_desc, lbl_accountcode, lbl_codetype, lbl_issuedate, lbl_amount;
	JTextField text_page, text_line, text_refpage, text_refline, text_desc, text_accountcode, text_codetype, text_amount;
	JButton btn_confirm, btn_add, btn_view, btn_update;
	JPanel panel_north, panel_south, panel_encode;
	dbconnect connect;
	JFormattedTextField text_transdate, text_issuedate;
	
	public panelEncodemain()
	{
		setLayout(new BorderLayout());
		panel_north = new JPanel();
		panel_south = new JPanel();
		panel_encode = new JPanel();
		
		panel_north.setLayout(new BorderLayout());
		panel_south.setLayout(new FlowLayout());
		panel_encode.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
	
		HandleControlButton control = new HandleControlButton();
		HandleKeyListener keycontrol = new HandleKeyListener();
		
		btn_confirm = new JButton("Confirm");
		btn_confirm.addActionListener(control);
		btn_confirm.addKeyListener(keycontrol);
		btn_add = new JButton("Add");
		btn_view = new JButton("View");
		btn_update = new JButton("Update and Browse");
	
		lbl_page = new JLabel("Page :");
		lbl_line = new JLabel("Line :");
		lbl_refpage = new JLabel("Ref. Page :");
		lbl_refline = new JLabel("Ref. Line :");
		lbl_transdate = new JLabel("Transaction Date :");
		lbl_desc = new JLabel("Description :");
		lbl_accountcode = new JLabel("Account Code :");
		lbl_codetype = new JLabel("Code Type :");
		lbl_issuedate = new JLabel("Issue Date :");
		lbl_amount = new JLabel("Amount :");
		
		lbl_page.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_line.setFont(new Font("Arial", Font.PLAIN, 20)); 
		lbl_refpage.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_refline.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_transdate.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_desc.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_accountcode.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_codetype.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_issuedate.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_amount.setFont(new Font("Arial", Font.PLAIN, 20));
		
		text_page = new JTextField(7);
		text_page.addKeyListener(keycontrol);
		text_line = new JTextField(5);
		text_line.addKeyListener(keycontrol);
		text_refpage = new JTextField(40);
		text_refpage.addKeyListener(keycontrol);
		text_refline = new JTextField(40);
		text_refline.addKeyListener(keycontrol);
		
		MaskFormatter mask = null;
		try
		{
			mask = new MaskFormatter("##/##/####");
			mask.setPlaceholderCharacter('_');
			
		}
		catch (ParseException k)
		{
			k.printStackTrace();
		}
		
		text_transdate = new JFormattedTextField(mask);
		text_transdate.setPreferredSize(new Dimension(110, 25));
		text_transdate.addKeyListener(keycontrol);
		
		text_desc = new JTextField(40);
		text_desc.addKeyListener(keycontrol);
		text_accountcode = new JTextField(5);
		text_accountcode.addKeyListener(keycontrol);
		text_codetype = new JTextField(5);
		text_codetype.addKeyListener(keycontrol);
		
		text_issuedate = new JFormattedTextField(mask);
		text_issuedate.setPreferredSize(new Dimension(110, 25));
		text_issuedate.addKeyListener(keycontrol);
		
		text_amount = new JTextField(10);
		text_amount.addKeyListener(keycontrol);
		
		
		text_page.setFont(new Font("Arial", Font.PLAIN, 20));
		text_line.setFont(new Font("Arial", Font.PLAIN, 20));
		text_refpage.setFont(new Font("Arial", Font.PLAIN, 20));
		text_refline.setFont(new Font("Arial", Font.PLAIN, 20));
		text_transdate.setFont(new Font("Arial", Font.PLAIN, 20));
		text_desc.setFont(new Font("Arial", Font.PLAIN, 20));
		text_accountcode.setFont(new Font("Arial", Font.PLAIN, 20));
		text_codetype.setFont(new Font("Arial", Font.PLAIN, 20));
		text_issuedate.setFont(new Font("Arial", Font.PLAIN, 20));
		text_amount.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//first row
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,0,0,10);
		c.anchor = GridBagConstraints.LINE_END;
		panel_encode.add(lbl_page, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_page, c);
		
		//second row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_line, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_line, c);
		
		//third row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_refpage, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_refpage, c);
		
		//fourth row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_refline, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_refline, c);
		
		//fifth row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_transdate, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_transdate, c);
		
		//sixth row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_desc, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_desc, c);
		
		//seventh row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_accountcode, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_accountcode, c);
		
		//eighth row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_codetype, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_codetype, c);
		
		//ninth row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_issuedate, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_issuedate, c);
		
		//tenth row
		
		c.gridy++;
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx=0;
		panel_encode.add(lbl_amount, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel_encode.add(text_amount, c);
		
		//tenth row
		
		c.gridy++;
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		panel_encode.add(btn_confirm, c);
		
		
		btn_add.addActionListener(control);
		btn_add.setMnemonic(KeyEvent.VK_A);
		btn_view.addActionListener(control);
		btn_view.setMnemonic(KeyEvent.VK_V);
		btn_update.addActionListener(control);
		btn_update.setMnemonic(KeyEvent.VK_D);
		
		panel_south.add(btn_add);
		panel_south.add(btn_view);
		panel_south.add(btn_update);
		
		panel_north.add(panel_encode, BorderLayout.CENTER);
		add(panel_north, BorderLayout.CENTER);
		add(panel_south, BorderLayout.SOUTH);
	}
	
	class HandleControlButton implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			Object source = e.getSource();
			
			if(source == btn_confirm)
			{
				dbconnect connect = new dbconnect();
				
				String page = text_page.getText();
				String line = text_line.getText();
				String refpage = text_refpage.getText();
				String refline = text_refline.getText();
				String transaction_date = text_transdate.getText();
				String description = text_desc.getText();
				String account_code = text_accountcode.getText();
				String code_type = text_codetype.getText();
				String issue_date = text_issuedate.getText();
				String amount = text_amount.getText();
					
				try
				{
					connect.addTransaction(page, line, refpage, refline, transaction_date, description, account_code, code_type, issue_date, amount);
					connect.close();
				}
				catch (Exception x)
				{
					System.out.println(x);
				}
				
				text_page.setText("");
				text_line.setText("");
				text_refpage.setText("");
				text_refline.setText("");
				text_transdate.setValue("");
				text_desc.setText("");
				text_accountcode.setText("");
				text_codetype.setText("");
				text_issuedate.setValue("");
				text_amount.setText("");
			
				text_page.requestFocus();
			}
			
			if(source == btn_view)
			{
				panel_north.removeAll();
				repaint();
				revalidate();
				
				try
				{
					panel_north.add(new panelEncodemainview(), BorderLayout.CENTER);
					repaint();
					revalidate();
				}
				catch (Exception d)
				{
					System.out.println("error panel encode view");
				}
				
			}
			
			if(source == btn_add)
			{
				panel_north.removeAll();
				repaint();
				revalidate();
				
				panel_north.add(panel_encode, BorderLayout.CENTER);
				repaint();
				revalidate();
				text_page.requestFocus();
			}
			
			if(source == btn_update)
			{
				panel_north.removeAll();
				repaint();
				revalidate();
				
				panel_north.add(new panelEncodemainupdate(), BorderLayout.CENTER);
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
				if (text_line.hasFocus())
					text_page.requestFocus();
				if (text_refpage.hasFocus())
					text_line.requestFocus();
				if (text_refline.hasFocus())
					text_refpage.requestFocus();
				if (text_transdate.hasFocus())
					text_refline.requestFocus();
				if (text_desc.hasFocus())
					text_transdate.requestFocus();
				if (text_accountcode.hasFocus())
					text_desc.requestFocus();
				if (text_codetype.hasFocus())
					text_accountcode.requestFocus();
				if (text_issuedate.hasFocus())
					text_codetype.requestFocus();
				if (text_amount.hasFocus())
					text_issuedate.requestFocus();
				if (btn_confirm.hasFocus())
					text_amount.requestFocus();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if (text_page.hasFocus())
					text_line.requestFocus();
				if (text_line.hasFocus())
					text_refpage.requestFocus();
				if (text_refpage.hasFocus())
					text_refline.requestFocus();
				if (text_refline.hasFocus())
					text_transdate.requestFocus();
				if (text_transdate.hasFocus())
					text_desc.requestFocus();
				if (text_desc.hasFocus())
					text_accountcode.requestFocus();
				if (text_accountcode.hasFocus())
					text_codetype.requestFocus();
				if (text_codetype.hasFocus())
					text_issuedate.requestFocus();
				if (text_issuedate.hasFocus())
					text_amount.requestFocus();
				if (text_amount.hasFocus())
					btn_confirm.requestFocus();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if (text_page.hasFocus())
					text_line.requestFocus();
				if (text_line.hasFocus())
					text_refpage.requestFocus();
				if (text_refpage.hasFocus())
					text_refline.requestFocus();
				if (text_refline.hasFocus())
					text_transdate.requestFocus();
				if (text_transdate.hasFocus())
					text_desc.requestFocus();
				if (text_desc.hasFocus())
					text_accountcode.requestFocus();
				if (text_accountcode.hasFocus())
					text_codetype.requestFocus();
				if (text_codetype.hasFocus())
					text_issuedate.requestFocus();
				if (text_issuedate.hasFocus())
					text_amount.requestFocus();
				if (text_amount.hasFocus())
					btn_confirm.requestFocus();
				if (btn_confirm.hasFocus())
				{
					dbconnect connect = new dbconnect();
					
					String page = text_page.getText();
					String line = text_line.getText();
					String refpage = text_refpage.getText();
					String refline = text_refline.getText();
					String transaction_date = text_transdate.getText();
					String description = text_desc.getText();
					String account_code = text_accountcode.getText();
					String code_type = text_codetype.getText();
					String issue_date = text_issuedate.getText();
					String amount = text_amount.getText();
					
					try
					{
						connect.addTransaction(page, line, refpage, refline, transaction_date, description, account_code, code_type, issue_date, amount);
						connect.close();
					}
					catch (Exception x)
					{
						System.out.println(x);
					}
					
					text_page.setText("");
					text_line.setText("");
					text_refpage.setText("");
					text_refline.setText("");
					text_transdate.setValue("");
					text_desc.setText("");
					text_accountcode.setText("");
					text_codetype.setText("");
					text_issuedate.setValue("");
					text_amount.setText("");
					
					text_page.requestFocus();					
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
