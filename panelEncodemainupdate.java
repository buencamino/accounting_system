import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class panelEncodemainupdate extends JPanel
{
	JLabel lbl_pagesearch, lbl_linesearch, lbl_accountcodesearch, lbl_codetypesearch, lbl_page, lbl_line, lbl_refpage, lbl_refline, lbl_transdate, lbl_description, lbl_accountcode, lbl_codetype, lbl_issuedate, lbl_amount, lbl_nofound;
	JButton btn_search, btn_modify, btn_delete, btn_first, btn_last, btn_previous, btn_next;
	JTextField text_pagesearch, text_linesearch, text_accountcodesearch, text_codetypesearch, text_page, text_line, text_refpage, text_refline, text_transdate, text_description, text_accountcode, text_codetype, text_issuedate, text_amount;
	String buff_ID;
	
	public panelEncodemainupdate() throws Exception
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		buff_ID = "0";
		
		HandleControlButton control = new HandleControlButton();
		HandleKeyListener keycontrol = new HandleKeyListener();

		lbl_pagesearch = new JLabel("Page :");
		lbl_linesearch = new JLabel("Line :");
		lbl_accountcodesearch = new JLabel("Account Code :");
		lbl_codetypesearch = new JLabel("Code Type :");
		
		lbl_page = new JLabel("Page :");
		lbl_line = new JLabel("Line :");
		lbl_refpage = new JLabel("Ref. Page :");
		lbl_refline = new JLabel("Ref. Line :");
		lbl_transdate = new JLabel("Transaction Date :");
		lbl_description = new JLabel("Description :");
		lbl_accountcode = new JLabel("Account Code :");
		lbl_codetype = new JLabel("Code Type :");
		lbl_issuedate = new JLabel("Issue Date :");
		lbl_amount = new JLabel("Amount :");
		lbl_nofound = new JLabel();
		lbl_nofound.setForeground(Color.RED);
		
		btn_search = new JButton("Search");
		btn_modify = new JButton("Modify");
		btn_modify.setPreferredSize(new Dimension(100,120));
		btn_delete = new JButton("Delete");
		btn_delete.setPreferredSize(new Dimension(100,120));
		btn_first = new JButton("First");
		btn_first.setPreferredSize(new Dimension(90,40));
		btn_last = new JButton("Last");
		btn_last.setPreferredSize(new Dimension(90,40));
		btn_previous = new JButton("Previous");
		btn_previous.setPreferredSize(new Dimension(90,40));
		btn_next = new JButton("Next");
		btn_next.setPreferredSize(new Dimension(90,40));
		
		text_pagesearch = new JTextField(10);
		text_pagesearch.addKeyListener(keycontrol);
		text_linesearch = new JTextField(10);
		text_linesearch.addKeyListener(keycontrol);
		text_accountcodesearch = new JTextField(10);
		text_accountcodesearch.addKeyListener(keycontrol);
		text_codetypesearch = new JTextField(10);
		text_codetypesearch.addKeyListener(keycontrol);
		
		text_page = new JTextField(10);
		text_page.addKeyListener(keycontrol);
		text_line = new JTextField(10);
		text_line.addKeyListener(keycontrol);
		text_refpage = new JTextField(30);
		text_refpage.addKeyListener(keycontrol);
		text_refline = new JTextField(30);
		text_refline.addKeyListener(keycontrol);
		text_transdate = new JTextField(10);
		text_transdate.addKeyListener(keycontrol);
		text_description = new JTextField(30);
		text_description.addKeyListener(keycontrol);
		text_accountcode = new JTextField(10);
		text_accountcode.addKeyListener(keycontrol);
		text_codetype = new JTextField(10);
		text_codetype.addKeyListener(keycontrol);
		text_issuedate = new JTextField(10);
		text_issuedate.addKeyListener(keycontrol);
		text_amount = new JTextField(20);
		text_amount.addKeyListener(keycontrol);
		
		text_pagesearch.setNextFocusableComponent(text_linesearch);
		text_linesearch.setNextFocusableComponent(text_accountcodesearch);
		text_accountcodesearch.setNextFocusableComponent(text_codetypesearch);
		text_codetypesearch.setNextFocusableComponent(btn_search);
		btn_search.setNextFocusableComponent(text_page);
		text_page.setNextFocusableComponent(text_line);
		text_line.setNextFocusableComponent(text_refpage);
		text_refpage.setNextFocusableComponent(text_refline);
		text_refline.setNextFocusableComponent(text_transdate);
		text_transdate.setNextFocusableComponent(text_description);
		text_description.setNextFocusableComponent(text_accountcode);
		text_accountcode.setNextFocusableComponent(text_codetype);
		text_codetype.setNextFocusableComponent(text_issuedate);
		text_issuedate.setNextFocusableComponent(text_amount);
		text_amount.setNextFocusableComponent(btn_modify);
		btn_modify.setNextFocusableComponent(btn_delete);
		btn_delete.setNextFocusableComponent(btn_first);
		btn_first.setNextFocusableComponent(btn_last);
		btn_last.setNextFocusableComponent(btn_previous);
		btn_previous.setNextFocusableComponent(btn_next);
		btn_next.setNextFocusableComponent(text_pagesearch);
			
		btn_search.addActionListener(control);
		btn_search.addKeyListener(keycontrol);
		btn_modify.addActionListener(control);
		btn_modify.addKeyListener(keycontrol);
		btn_delete.addActionListener(control);
		btn_delete.addKeyListener(keycontrol);
		btn_first.addActionListener(control);
		btn_first.addKeyListener(keycontrol);
		btn_last.addActionListener(control);
		btn_last.addKeyListener(keycontrol);
		btn_previous.addActionListener(control);
		btn_previous.addKeyListener(keycontrol);
		btn_next.addActionListener(control);
		btn_next.addKeyListener(keycontrol);
		
		//first row
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,0,0,10);
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_pagesearch, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_pagesearch, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_page, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_page, c);
		
		c.gridx = 6;
		c.gridheight = 5;
		add(btn_modify, c);
		
		c.gridx = 7;
		c.gridheight = 2;
		add(btn_first, c);
		
		//second row
		
		c.gridy++;
		c.gridheight = 1;
		
		c.gridx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_linesearch, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_linesearch, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_line, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_line, c);
		
		//third row
		
		c.gridy++;
		c.gridx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_accountcodesearch, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_accountcodesearch, c);

		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_refpage, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_refpage, c);
		
		
		c.gridx = 7;
		c.gridheight = 2;
		add(btn_last, c);
		
		//fourth row
		
		c.gridy++;
		c.gridheight = 1;
		
		c.gridx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_codetypesearch, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_codetypesearch, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_refline, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_refline, c);
		
		//fifth row
		
		c.gridy++;
		c.gridx = 1;
		add(btn_search, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_transdate, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_transdate, c);
		
		c.gridx = 7;
		c.gridheight = 2;
		add(btn_previous, c);
		
		//sixth row
		
		c.gridy++;
		c.gridheight = 1;
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_description, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_description, c);
		
		c.gridx = 6;
		c.gridheight = 5;
		add(btn_delete, c);
		
		//seventh row
		
		c.gridy++;
		c.gridheight = 1;
		
		c.gridx = 1;
		add(lbl_nofound, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_accountcode, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_accountcode, c);
		
		c.gridx = 7;
		c.gridheight = 2;
		add(btn_next, c);
		
		//eighth row
		
		c.gridy++;
		c.gridheight = 1;
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_codetype, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_codetype, c);
		
		//ninth row
		
		c.gridy++;
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_issuedate, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_issuedate, c);
		
		//tenth row
		
		c.gridy++;
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_amount, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_amount, c);
	}
	
	class HandleControlButton implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			Object source = e.getSource();
			String str_page, str_line, str_accountcode, str_codetype;
			
			if(source == btn_search)
			{
				ResultSet rsetSearch = null;
				dbconnect condb = new dbconnect();
				int rowcount = 0;
				
				try
				{
					str_page = text_pagesearch.getText();
					str_line = text_linesearch.getText();
					str_accountcode = text_accountcodesearch.getText();
					str_codetype = text_codetypesearch.getText();
					
					rsetSearch = condb.getSearch(str_page, str_line, str_accountcode, str_codetype);
			
					if (rsetSearch != null)
					{
						rsetSearch.last();
						rowcount = rsetSearch.getRow();
					}
					
					rsetSearch.first();
					
					if (rowcount > 0)
					{
						try
						{
							buff_ID = rsetSearch.getString("transid");
							text_page.setText(rsetSearch.getString("page"));
							text_line.setText(rsetSearch.getString("line"));
							text_refpage.setText(rsetSearch.getString("refpage"));
							text_refline.setText(rsetSearch.getString("refline"));
							text_transdate.setText(rsetSearch.getString("transaction_date"));
							text_description.setText(rsetSearch.getString("description"));
							text_accountcode.setText(rsetSearch.getString("account_code"));
							text_codetype.setText(rsetSearch.getString("code_type"));
							text_issuedate.setText(rsetSearch.getString("issue_date"));
							text_amount.setText(rsetSearch.getString("amount"));
							
							lbl_nofound.setText("");
						}
						catch (Exception z)
						{
							System.out.println(z.getMessage());
						}
					}
					else if (rowcount == 0)
					{
						buff_ID = "0";
						text_page.setText("");
						text_line.setText("");
						text_refpage.setText("");
						text_refline.setText("");
						text_transdate.setText("");
						text_description.setText("");
						text_accountcode.setText("");
						text_codetype.setText("");
						text_issuedate.setText("");
						text_amount.setText("");
						
						lbl_nofound.setText("No record found!");
					}
						
					condb.close();
				}
				catch (Exception k)
				{
					System.out.println(k.getMessage());
				}
				
			}	
			
			if (source == btn_modify)
			{
				if (Integer.parseInt(buff_ID) > 0)
				{
					
					JDialog.setDefaultLookAndFeelDecorated(true);
					
					int response = JOptionPane.showConfirmDialog(null, "Modify record?", "Confirm Modify", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
					if (response == JOptionPane.NO_OPTION)
					{
						System.out.println("No option selected");
					}
					else if (response == JOptionPane.YES_OPTION)
					{
						dbconnect conn = new dbconnect();
						String page, line, refpage, refline, transdate, description, accountcode, codetype, issuedate, amount;
						
						page = text_page.getText();
						line = text_line.getText();
						refpage = text_refpage.getText();
						refline = text_refline.getText();
						transdate = text_transdate.getText();
						description = text_description.getText();
						accountcode = text_accountcode.getText();
						codetype = text_codetype.getText();
						issuedate = text_issuedate.getText();
						amount = text_amount.getText();
							
						try
						{
							conn.updateTransaction(buff_ID, page, line, refpage, refline, transdate, description, accountcode, codetype, issuedate, amount);
							conn.close();
						}
						catch (Exception z)
						{
							System.out.println(z.getMessage());
						}						
						
						buff_ID = "0";
						text_page.setText("");
						text_line.setText("");
						text_refpage.setText("");
						text_refline.setText("");
						text_transdate.setText("");
						text_description.setText("");
						text_accountcode.setText("");
						text_codetype.setText("");
						text_issuedate.setText("");
						text_amount.setText("");
						text_pagesearch.setText("");
						text_linesearch.setText("");
						text_codetypesearch.setText("");
						text_accountcodesearch.setText("");
					}
					else if (response == JOptionPane.CLOSED_OPTION)
					{
						System.out.println("Closed window");
					}
				}
			}
			
			if (source == btn_delete)
			{
				if (Integer.parseInt(buff_ID) > 0)
				{
					
					JDialog.setDefaultLookAndFeelDecorated(true);
					
					int response = JOptionPane.showConfirmDialog(null, "Delete record?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
					if (response == JOptionPane.NO_OPTION)
					{
						System.out.println("No option selected");
					}
					else if (response == JOptionPane.YES_OPTION)
					{
					
						dbconnect conn = new dbconnect();
					
						try
						{
							conn.deleteTransaction(buff_ID);
							conn.close();
						}
						catch (Exception x)
						{
							System.out.println(x.getMessage());
						}
						
						buff_ID = "0";
						text_page.setText("");
						text_line.setText("");
						text_refpage.setText("");
						text_refline.setText("");
						text_transdate.setText("");
						text_description.setText("");
						text_accountcode.setText("");
						text_codetype.setText("");
						text_issuedate.setText("");
						text_amount.setText("");
						text_pagesearch.setText("");
						text_linesearch.setText("");
						text_codetypesearch.setText("");
						text_accountcodesearch.setText("");
					}
					else if (response == JOptionPane.CLOSED_OPTION)
					{
						System.out.println("Closed window");
					}
				}
			}
			
			if (source == btn_first)
			{
				dbconnect conn = new dbconnect();
				ResultSet rsetFirst = null;
				
				try
				{
					rsetFirst = conn.getFirsttransaction();
				
					rsetFirst.first();
				
					System.out.println("record: " + rsetFirst.getString("page") + ", " + rsetFirst.getString("description"));
					buff_ID = rsetFirst.getString("transid");
					text_page.setText(rsetFirst.getString("page"));
					text_line.setText(rsetFirst.getString("line"));
					text_refpage.setText(rsetFirst.getString("refpage"));
					text_refline.setText(rsetFirst.getString("refline"));
					text_transdate.setText(rsetFirst.getString("transaction_date"));
					text_description.setText(rsetFirst.getString("description"));
					text_accountcode.setText(rsetFirst.getString("account_code"));
					text_codetype.setText(rsetFirst.getString("code_type"));
					text_issuedate.setText(rsetFirst.getString("issue_date"));
					text_amount.setText(rsetFirst.getString("amount"));
					
					lbl_nofound.setText("");
					
					conn.close();
				}
				catch (Exception j)
				{
					System.out.println(j.getMessage());
				}
			}
			
			if (source == btn_last)
			{
				dbconnect conn = new dbconnect();
				ResultSet rsetLast = null;
				
				try
				{
					rsetLast = conn.getLasttransaction();
				
					rsetLast.first();
				
					buff_ID = rsetLast.getString("transid");
					text_page.setText(rsetLast.getString("page"));
					text_line.setText(rsetLast.getString("line"));
					text_refpage.setText(rsetLast.getString("refpage"));
					text_refline.setText(rsetLast.getString("refline"));
					text_transdate.setText(rsetLast.getString("transaction_date"));
					text_description.setText(rsetLast.getString("description"));
					text_accountcode.setText(rsetLast.getString("account_code"));
					text_codetype.setText(rsetLast.getString("code_type"));
					text_issuedate.setText(rsetLast.getString("issue_date"));
					text_amount.setText(rsetLast.getString("amount"));
					
					lbl_nofound.setText("");
					
					conn.close();
				}
				catch (Exception u)
				{
					System.out.println(u.getMessage());
				}
			}
			
			if (source == btn_previous)
			{
				dbconnect conn = new dbconnect();
				ResultSet rsetPrevious = null;
				int rowcount = 0;
				
				try
				{					
					rsetPrevious = conn.getPrevioustransaction(buff_ID);
				
					if (rsetPrevious != null)
					{
						rsetPrevious.last();
						rowcount = rsetPrevious.getRow();
					}
						
					rsetPrevious.first();
					
					if (rowcount > 0)
					{
						buff_ID = rsetPrevious.getString("transid");
						text_page.setText(rsetPrevious.getString("page"));
						text_line.setText(rsetPrevious.getString("line"));
						text_refpage.setText(rsetPrevious.getString("refpage"));
						text_refline.setText(rsetPrevious.getString("refline"));
						text_transdate.setText(rsetPrevious.getString("transaction_date"));
						text_description.setText(rsetPrevious.getString("description"));
						text_accountcode.setText(rsetPrevious.getString("account_code"));
						text_codetype.setText(rsetPrevious.getString("code_type"));
						text_issuedate.setText(rsetPrevious.getString("issue_date"));
						text_amount.setText(rsetPrevious.getString("amount"));
						
						lbl_nofound.setText("");
					}
					
					conn.close();
				}
				catch (Exception i)
				{
					System.out.println(i.getMessage());
				}
			}
			
			if (source == btn_next)
			{
				dbconnect conn = new dbconnect();
				ResultSet rsetNext = null;
				int rowcount = 0;
				
				try
				{
					rsetNext = conn.getNexttransaction(buff_ID);

					if (rsetNext != null)
					{
						rsetNext.last();
						rowcount = rsetNext.getRow();
					}
						
					rsetNext.first();
						
					if (rowcount > 0)
					{
						buff_ID = rsetNext.getString("transid");
						text_page.setText(rsetNext.getString("page"));
						text_line.setText(rsetNext.getString("line"));
						text_refpage.setText(rsetNext.getString("refpage"));
						text_refline.setText(rsetNext.getString("refline"));
						text_transdate.setText(rsetNext.getString("transaction_date"));
						text_description.setText(rsetNext.getString("description"));
						text_accountcode.setText(rsetNext.getString("account_code"));
						text_codetype.setText(rsetNext.getString("code_type"));
						text_issuedate.setText(rsetNext.getString("issue_date"));
						text_amount.setText(rsetNext.getString("amount"));
						
						lbl_nofound.setText("");
					}
					
					conn.close();
				}
				catch (Exception l)
				{
					System.out.println(l.getMessage());
				}
				
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
				if (btn_next.hasFocus())
					btn_previous.requestFocus();
				if (btn_previous.hasFocus())
					btn_last.requestFocus();
				if (btn_last.hasFocus())
					btn_first.requestFocus();
				if (btn_first.hasFocus())
					btn_delete.requestFocus();
				if (btn_delete.hasFocus())
					btn_modify.requestFocus();
				if (btn_modify.hasFocus())
					text_amount.requestFocus();
				if (text_amount.hasFocus())
					text_issuedate.requestFocus();
				if (text_issuedate.hasFocus())
					text_codetype.requestFocus();
				if (text_codetype.hasFocus())
					text_accountcode.requestFocus();
				if (text_accountcode.hasFocus())
					text_description.requestFocus();
				if (text_description.hasFocus())
					text_transdate.requestFocus();
				if (text_transdate.hasFocus())
					text_refline.requestFocus();
				if (text_refline.hasFocus())
					text_refpage.requestFocus();
				if (text_refpage.hasFocus())
					text_line.requestFocus();
				if (text_line.hasFocus())
					text_page.requestFocus();
				if (text_page.hasFocus())
					btn_search.requestFocus();
				if (btn_search.hasFocus())
					text_codetypesearch.requestFocus();
				if (text_codetypesearch.hasFocus())
					text_accountcodesearch.requestFocus();
				if (text_accountcodesearch.hasFocus())
					text_linesearch.requestFocus();
				if (text_linesearch.hasFocus())
					text_pagesearch.requestFocus();
				if (text_pagesearch.hasFocus())
					btn_next.requestFocus();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if (text_pagesearch.hasFocus())
					text_linesearch.requestFocus();
				if (text_linesearch.hasFocus())
					text_accountcodesearch.requestFocus();
				if (text_accountcodesearch.hasFocus())
					text_codetypesearch.requestFocus();
				if (text_codetypesearch.hasFocus())
					btn_search.requestFocus();
				if (btn_search.hasFocus())
					text_page.requestFocus();
				if (text_page.hasFocus())
					text_line.requestFocus();
				if (text_line.hasFocus())
					text_refpage.requestFocus();
				if (text_refpage.hasFocus())
					text_refline.requestFocus();
				if (text_refline.hasFocus())
					text_transdate.requestFocus();
				if (text_transdate.hasFocus())
					text_description.requestFocus();
				if (text_description.hasFocus())
					text_accountcode.requestFocus();
				if (text_accountcode.hasFocus())
					text_codetype.requestFocus();
				if (text_codetype.hasFocus())
					text_issuedate.requestFocus();
				if (text_issuedate.hasFocus())
					text_amount.requestFocus();
				if (text_amount.hasFocus())
					btn_modify.requestFocus();
				if (btn_modify.hasFocus())
					btn_delete.requestFocus();
				if (btn_delete.hasFocus())
					btn_first.requestFocus();
				if (btn_first.hasFocus())
					btn_last.requestFocus();
				if (btn_last.hasFocus())
					btn_previous.requestFocus();
				if (btn_previous.hasFocus())
					btn_next.requestFocus();
				if (btn_next.hasFocus())
					text_pagesearch.requestFocus();
				
			}
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				
				
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