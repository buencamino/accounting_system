import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class panelEncodemainview extends JPanel
{
	JLabel lbl_title;
	JTable tbl_transactions;
	Vector<Vector<Object>> data;
	Vector<Object> record;
	ResultSet rset = null;
	Vector<String> headers = new Vector<String>();
	DefaultTableModel tablemodel;
	dbconnect connect;
	
	public panelEncodemainview() throws Exception
	{
		connect = new dbconnect();
		tablemodel = new DefaultTableModel();
			
		setLayout(new BorderLayout());
		
		headers.add("Page");
		headers.add("Line");
		headers.add("Ref. Page");
		headers.add("Ref. Line");
		headers.add("Trans. Date");
		headers.add("Description");
		headers.add("Account Code");
		headers.add("Code Type");
		headers.add("Issue Date");
		headers.add("Amount");
		
		try
		{
			rset = connect.getTransactions();
			refreshTable(rset);
			connect.close();
		}
		catch (Exception j)
		{
			throw j;
		}
		
		lbl_title = new JLabel("Transaction List");
		tbl_transactions = new JTable(tablemodel);
		
		add(lbl_title, BorderLayout.NORTH);
		add(new JScrollPane(tbl_transactions), BorderLayout.CENTER);
	}
	
	public void refreshTable(ResultSet rset1) throws Exception
	{
		data = new Vector<Vector<Object>>();
		
		while(rset1.next())
		{
			record = new Vector<Object>();
			
			record.add(rset1.getString("page"));
			record.add(rset1.getString("line"));
			record.add(rset1.getString("refpage"));
			record.add(rset1.getString("refline"));
			record.add(rset1.getString("transaction_date"));
			record.add(rset1.getString("description"));
			record.add(rset1.getString("account_code"));
			record.add(rset1.getString("code_type"));
			record.add(rset1.getString("issue_date"));
			record.add(rset1.getString("amount"));
		
			data.addElement(record);
		}
		
		tablemodel.setDataVector(data, headers);
		tablemodel.fireTableDataChanged();

	}
}