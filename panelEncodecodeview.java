import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class panelEncodecodeview extends JPanel
{
	JLabel lbl_title;
	JTable tbl_codes;
	Vector<Vector<Object>> data;
	Vector<Object> record;
	ResultSet rset = null;
	Vector<String> headers = new Vector<String>();
	DefaultTableModel tablemodel;
	dbconnect connect;
	
	public panelEncodecodeview() throws Exception
	{
		setLayout(new BorderLayout());
		
		lbl_title = new JLabel("Code List");
		
		add(lbl_title, BorderLayout.NORTH);
		connect = new dbconnect();
		tablemodel = new DefaultTableModel();
		
		headers.add("Account Code");
		headers.add("Code Type");
		headers.add("Account Name");
		headers.add("Type Description");
		
		try
		{
			rset = connect.getCodes();
			refreshTable(rset);
			connect.close();
		}
		catch (Exception j)
		{
			throw j;
		}
		
		tbl_codes = new JTable(tablemodel);
		
		add(lbl_title, BorderLayout.NORTH);
		add(new JScrollPane(tbl_codes), BorderLayout.CENTER);
	}
	
	public void refreshTable(ResultSet rset1) throws Exception
	{
		data = new Vector<Vector<Object>>();
		
		while(rset1.next())
		{
			record = new Vector<Object>();
			
			record.add(rset1.getString("accountcode"));
			record.add(rset1.getString("codetype"));
			record.add(rset1.getString("accountname"));
			record.add(rset1.getString("description"));
			
			data.addElement(record);
		}
		
		tablemodel.setDataVector(data, headers);
		tablemodel.fireTableDataChanged();
	}
}