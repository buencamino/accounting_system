import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class panelEncodecodeupdate extends JPanel
{
	JLabel lbl_accountcodesearch, lbl_codetypesearch, lbl_accountcode, lbl_codetype, lbl_accountname, lbl_typedescription, lbl_nofound;
	JTextField text_accountcodesearch, text_codetypesearch, text_accountcode, text_codetype, text_accountname, text_typedescription;
	JButton btn_search, btn_modify, btn_delete, btn_first, btn_last, btn_previous, btn_next;
	String buff_ID;
	
	public panelEncodecodeupdate()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		HandleControlButton control = new HandleControlButton();
		
		lbl_accountcodesearch = new JLabel("Account Code :");
		lbl_codetypesearch = new JLabel("Code Type :");
		lbl_accountcode = new JLabel("Account Code :");
		lbl_codetype = new JLabel("Code Type :");
		lbl_accountname = new JLabel("Account Name :");
		lbl_typedescription = new JLabel("Type Description :");
		lbl_nofound = new JLabel();
		lbl_nofound.setForeground(Color.RED);
		
		text_accountcodesearch = new JTextField(10);
		text_codetypesearch = new JTextField(10);
		text_accountcode = new JTextField(10);
		text_codetype = new JTextField(10);
		text_accountname = new JTextField(30);
		text_typedescription = new JTextField(30);
		
		btn_search = new JButton("Search");
		btn_search.addActionListener(control);
		btn_modify = new JButton("Modify");
		btn_modify.addActionListener(control);
		btn_delete = new JButton("Delete");
		btn_delete.addActionListener(control);
		btn_first = new JButton("First");
		btn_first.addActionListener(control);
		btn_last = new JButton("Last");
		btn_last.addActionListener(control);
		btn_previous = new JButton("Previous");
		btn_previous.addActionListener(control);
		btn_next = new JButton("Next");
		btn_next.addActionListener(control);
		
		text_accountcodesearch.setNextFocusableComponent(text_codetypesearch);
		text_codetypesearch.setNextFocusableComponent(btn_search);
		btn_search.setNextFocusableComponent(text_accountcode);
		text_accountcode.setNextFocusableComponent(text_codetype);
		text_codetype.setNextFocusableComponent(text_accountname);
		text_accountname.setNextFocusableComponent(text_typedescription);
		text_typedescription.setNextFocusableComponent(btn_modify);
		btn_modify.setNextFocusableComponent(btn_delete);
		btn_delete.setNextFocusableComponent(btn_first);
		btn_first.setNextFocusableComponent(btn_last);
		btn_last.setNextFocusableComponent(btn_previous);
		btn_previous.setNextFocusableComponent(btn_next);
		btn_next.setNextFocusableComponent(text_accountcodesearch);
		
		btn_modify.setPreferredSize(new Dimension(80,50));
		btn_delete.setPreferredSize(new Dimension(80,50));
		
		//first row
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,0,0,10);
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_accountcodesearch, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_accountcodesearch, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_accountcode, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_accountcode, c);
		
		c.gridx = 6;
		c.gridheight = 2;
		add(btn_modify, c);
		
		c.gridx = 7;
		c.gridheight = 1;
		add(btn_first, c);
		
		//second row
		c.gridy++;
		
		c.gridx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_codetypesearch, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_codetypesearch, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_codetype, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_codetype, c);
		
		c.gridx = 7;
		add(btn_last, c);
		
		//third row
		c.gridy++;
		
		c.gridx = 1;
		add(btn_search, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_accountname, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_accountname, c);
		
		c.gridx = 6;
		c.gridheight = 2;
		add(btn_delete, c);
		
		c.gridx = 7;
		c.gridheight = 1;
		add(btn_previous, c);
		
		//fourth row
		c.gridy++;
		
		c.gridx = 1;
		add(lbl_nofound, c);
		
		c.gridx = 3;
		c.anchor = GridBagConstraints.LINE_END;
		add(lbl_typedescription, c);
		
		c.gridx = 4;
		c.anchor = GridBagConstraints.LINE_START;
		add(text_typedescription, c);
		
		c.gridx = 7;
		add(btn_next, c);
	}
	
	
	class HandleControlButton implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			Object source = e.getSource();
			
			if (source == btn_search)
			{
				String str_accountcode, str_codetype;
				
				ResultSet rsetSearch = null;
				dbconnect condb = new dbconnect();
				int rowcount = 0;
				
				try
				{
					str_accountcode = text_accountcodesearch.getText();
					str_codetype = text_codetypesearch.getText();
					
					rsetSearch = condb.getSearchcode(str_accountcode, str_codetype);
			
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
							buff_ID = rsetSearch.getString("codeid");
							text_accountcode.setText(rsetSearch.getString("accountcode"));
							text_codetype.setText(rsetSearch.getString("codetype"));
							text_accountname.setText(rsetSearch.getString("accountname"));
							text_typedescription.setText(rsetSearch.getString("description"));
							
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
						text_accountcode.setText("");
						text_codetype.setText("");
						text_accountname.setText("");
						text_typedescription.setText("");
						
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
					
					int response = JOptionPane.showConfirmDialog(null, "Modify code record?", "Confirm Modify", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
					if (response == JOptionPane.NO_OPTION)
					{
						System.out.println("No option selected");
					}
					else if (response == JOptionPane.YES_OPTION)
					{
						dbconnect conn = new dbconnect();
						String accountcode, codetype, accountname, typedescription;
						
						accountcode = text_accountcode.getText();
						codetype = text_codetype.getText();
						accountname = text_accountname.getText();
						typedescription = text_typedescription.getText();
							
						try
						{
							conn.updateCode(buff_ID, accountcode, codetype, accountname, typedescription);
							conn.close();
						}
						catch (Exception z)
						{
							System.out.println(z.getMessage());
						}						
						
						buff_ID = "0";
						text_accountcode.setText("");
						text_codetype.setText("");
						text_accountname.setText("");
						text_typedescription.setText("");
						
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
					
					int response = JOptionPane.showConfirmDialog(null, "Delete code record?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
					if (response == JOptionPane.NO_OPTION)
					{
						System.out.println("No option selected");
					}
					else if (response == JOptionPane.YES_OPTION)
					{
						dbconnect conn = new dbconnect();
					
						try
						{
							conn.deleteCode(buff_ID);
							conn.close();
						}
						catch (Exception x)
						{
							System.out.println(x.getMessage());
						}
						
						buff_ID = "0";
						text_accountcode.setText("");
						text_codetype.setText("");
						text_accountname.setText("");
						text_typedescription.setText("");
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
					rsetFirst = conn.getFirstcode();
				
					rsetFirst.first();
				
					buff_ID = rsetFirst.getString("codeid");
					text_accountcode.setText(rsetFirst.getString("accountcode"));
					text_codetype.setText(rsetFirst.getString("codetype"));
					text_accountname.setText(rsetFirst.getString("accountname"));
					text_typedescription.setText(rsetFirst.getString("description"));
					
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
					rsetLast = conn.getLastcode();
				
					rsetLast.first();
				
					buff_ID = rsetLast.getString("codeid");
					text_accountcode.setText(rsetLast.getString("accountcode"));
					text_codetype.setText(rsetLast.getString("codetype"));
					text_accountname.setText(rsetLast.getString("accountname"));
					text_typedescription.setText(rsetLast.getString("description"));
					
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
					rsetPrevious = conn.getPreviouscode(buff_ID);
				
					if (rsetPrevious != null)
					{
						rsetPrevious.last();
						rowcount = rsetPrevious.getRow();
					}
						
					rsetPrevious.first();
					
					if (rowcount > 0)
					{
						buff_ID = rsetPrevious.getString("codeid");
						text_accountcode.setText(rsetPrevious.getString("accountcode"));
						text_codetype.setText(rsetPrevious.getString("codetype"));
						text_accountname.setText(rsetPrevious.getString("accountname"));
						text_typedescription.setText(rsetPrevious.getString("description"));
						
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
					rsetNext = conn.getNextcode(buff_ID);

					if (rsetNext != null)
					{
						rsetNext.last();
						rowcount = rsetNext.getRow();
					}
						
					rsetNext.first();
						
					if (rowcount > 0)
					{
						buff_ID = rsetNext.getString("codeid");
						text_accountcode.setText(rsetNext.getString("accountcode"));
						text_codetype.setText(rsetNext.getString("codetype"));
						text_accountname.setText(rsetNext.getString("accountname"));
						text_typedescription.setText(rsetNext.getString("description"));
						
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
}