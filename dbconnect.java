import java.sql.*;

public class dbconnect
{
	private static final String database_driver = "com.mysql.jdbc.Driver";
	private static final String database_url = "jdbc:mysql://localhost:3306/uytit?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String user = "mike";
	private static final String password = "12345";
	
	private Connection conn = null;
	private Statement statement = null;
	private ResultSet rset = null;
	
	public void connect() throws Exception
	{
		try
		{
			Class.forName(database_driver);
			conn = DriverManager.getConnection(database_url, user, password);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public void addTransaction(String page, String line, String refpage, String refline, String transaction_date, String description, String account_code, String code_type, String issue_date, String amount) throws Exception
	{
		try
		{
			connect();
			statement = conn.createStatement();
			statement.executeUpdate("insert into transaction (page, line, refpage, refline, transaction_date, description, account_code, code_type, issue_date, amount) values ('" + page + "', '" + line + "', '" + refpage + "', '" + refline + "', '" + transaction_date + "', '" + description + "', '" + account_code + "', '" + code_type + "','" + issue_date + "', " + amount + ")");
			System.out.println("Inserted transaction of page: " + page + " and line: " + line);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ResultSet getTransactions() throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from transaction");
		}
		catch (Exception m)
		{
			throw m;
		}
		
		return rset;
	}
	
	public ResultSet getSearch(String page, String line, String account_code, String code_type) throws Exception
	{
		rset = null;
			
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from transaction where page = '" + page + "' and line = '" + line + "' and account_code = '" + account_code + "' and code_type = '" + code_type + "'");
		}
		catch (Exception y)
		{
			throw y;
		}
		
		return rset;
	}

	public void updateTransaction(String transid, String page, String line, String refpage, String refline, String transdate, String description, String accountcode, String codetype, String issuedate, String amount) throws Exception
	{
			try
			{
				connect();
				statement = conn.createStatement();
				statement.executeUpdate("update transaction set page = '" + page + "', line = '" + line + "', refpage = '" + refpage + "', refline = '" + refline + "', transaction_date = '" + transdate + "', description = '" + description + "', account_code = '" + accountcode + "', code_type = '" + codetype + "', issue_date = '" + issuedate + "', amount = " + amount + " where transid = " + transid);
			}
			catch (Exception z)
			{
				throw z;
			}
	}
	
	public void deleteTransaction(String transid) throws Exception
	{
		try
		{
			connect();
			statement = conn.createStatement();
			statement.executeUpdate("delete from transaction where transid = " + transid);
		}
		catch (Exception x)
		{
			throw x;
		}
	}
	
	public ResultSet getFirsttransaction() throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from transaction order by transid asc limit 1");
		}
		catch (Exception j)
		{
			throw j;
		}
		
		return rset;			
	}
	
	public ResultSet getLasttransaction() throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from transaction order by transid desc limit 1");
		}
		catch (Exception j)
		{
			throw j;
		}
		
		return rset;			
	}
	
	public ResultSet getPrevioustransaction(String transid) throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from transaction where transid = (select max(transid) from transaction where transid < " + transid + ")");
		}
		catch (Exception i)
		{
			throw i;
		}
		
		return rset;
	}
	
	public ResultSet getNexttransaction(String transid) throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from transaction where transid = (select min(transid) from transaction where transid > " + transid + ")");
		}
		catch (Exception l)
		{
			throw l;
		}
		
		return rset;
	}
	
	public void addCode(String accountcode, String codetype, String accountname, String description) throws Exception
	{
		try
		{
			connect();
			statement = conn.createStatement();
			statement.executeUpdate("insert into code (accountcode, codetype, accountname, description) values ('" + accountcode + "', '" + codetype + "', '" + accountname + "', '" + description + "')");
			System.out.println("Inserted code of account code: " + accountcode + " and code type: " + codetype);
		}
		catch (Exception r)
		{
			throw r;
		}
	}
	
	public ResultSet getCodes() throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from code");
		}
		catch (Exception h)
		{
			throw h;
		}
		
		return rset;
	}
	
	public ResultSet getSearchcode(String accountcode, String codetype) throws Exception
	{
		rset = null;
			
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from code where accountcode = '" + accountcode + "' and codetype = '" + codetype + "'");
		}
		catch (Exception y)
		{
			throw y;
		}
		
		return rset;
	}

	public void updateCode(String codeid, String accountcode, String codetype, String accountname, String typedescription) throws Exception
	{
		try
		{
			connect();
			statement = conn.createStatement();
			statement.executeUpdate("update code set accountcode = '" + accountcode + "', codetype = '" + codetype + "', accountname = '" + accountname + "', description = '" + typedescription + "' where codeid = " + codeid);
		}
		catch (Exception z)
		{
			throw z;
		}
	}
	
	public void deleteCode(String codeid) throws Exception
	{
		try
		{
			connect();
			statement = conn.createStatement();
			statement.executeUpdate("delete from code where codeid = " + codeid);
		}
		catch (Exception x)
		{
			throw x;
		}
	}
	
	public ResultSet getFirstcode() throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from code order by codeid asc limit 1");
		}
		catch (Exception j)
		{
			throw j;
		}
		
		return rset;			
	}
	
	public ResultSet getLastcode() throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from code order by codeid desc limit 1");
		}
		catch (Exception j)
		{
			throw j;
		}
		
		return rset;			
	}
	
	public ResultSet getPreviouscode(String codeid) throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from code where codeid = (select max(codeid) from code where codeid < " + codeid + ")");
		}
		catch (Exception i)
		{
			throw i;
		}
		
		return rset;
	}
	
	public ResultSet getNextcode(String codeid) throws Exception
	{
		rset = null;
		
		try
		{
			connect();
			statement = conn.createStatement();
			rset = statement.executeQuery("select * from code where codeid = (select min(codeid) from code where codeid > " + codeid + ")");
		}
		catch (Exception l)
		{
			throw l;
		}
		
		return rset;
	}
	
	public void close() throws Exception
	{
		try
		{
			conn.close();
			statement.close();
			rset = null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
}

