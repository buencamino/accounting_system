import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;


public class lautentat 
{
	JMenuBar mb;
	JMenu menu1, menu2, menu3;
	JMenuItem menu2_summation, menu2_view, menu2_list, menu2_reports, menu3_backuprestore, menu1_main, menu1_code, menu1_exit;
	JPanel panelEncode, panelBackup, panelRestore, panelMain;
	JLabel lbl_testpanel1, lbl_testpanel2, lbl_testpanel3;
	//Border borderEncode, borderBackup, borderRestore;
	
	public lautentat()
	{
		HandleControlButton control = new HandleControlButton();
		
		JFrame mainWindow = new JFrame("Francisco's System");
		mainWindow.setBounds(0,0,1024,700);
		
		/*
		borderEncode = BorderFactory.createTitledBorder("Encode Module");
		borderBackup = BorderFactory.createTitledBorder("Backup Module");
		borderRestore = BorderFactory.createTitledBorder("Restore Module");
		*/
		
		lbl_testpanel1 = new JLabel("This is the Encode Panel");
		lbl_testpanel2 = new JLabel("This is the Backup Panel");
		lbl_testpanel3 = new JLabel("This is the Restore Panel");
		mb = new JMenuBar();
		menu1 = new JMenu("Maintenance");
		menu2 = new JMenu("Functions");
		menu3 = new JMenu("Utility");
		menu2_summation = new JMenuItem("Summation");
		menu2_view = new JMenuItem("View");
		menu2_list = new JMenuItem("List");
		menu2_reports = new JMenuItem("Reports");
		menu1_exit = new JMenuItem("Exit");
		menu3_backuprestore = new JMenuItem("Backup/Restore");
		panelEncode = new JPanel();
		panelBackup = new JPanel();
		panelRestore = new JPanel();
		panelMain = new JPanel();
		menu1_main = new JMenuItem("Main");
		menu1_code = new JMenuItem("Code");
		
		menu1_main.addActionListener(control);
		menu1_code.addActionListener(control);
		menu1_exit.addActionListener(control);
		
		menu1.add(menu1_main);
		menu1.add(menu1_code);
		menu1.addSeparator();
		menu1.add(menu1_exit);
		
		
		menu2.add(menu2_summation);
		menu2.add(menu2_view);
		menu2.add(menu2_list);
		menu2.add(menu2_reports);
		
		menu3.add(menu3_backuprestore);
		
		mb.add(menu1);
		mb.add(menu2);
		mb.add(menu3);
		
		mainWindow.setLayout(new BorderLayout());
		
		panelEncode.setLayout(new FlowLayout());
		panelEncode.add(lbl_testpanel1);
		panelEncode.setBackground(Color.WHITE);
		//panelEncode.setBorder(borderEncode);
		
		panelBackup.setLayout(new FlowLayout());
		panelBackup.add(lbl_testpanel2);
		panelBackup.setBackground(Color.GRAY);
		//panelBackup.setBorder(borderBackup);
		
		panelRestore.setLayout(new FlowLayout());
		panelRestore.add(lbl_testpanel3);
		//panelRestore.setBorder(borderRestore);
		
		panelMain.setLayout(new BorderLayout());
		
		mainWindow.add(panelMain, BorderLayout.CENTER);
		mainWindow.setJMenuBar(mb);
		
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}
	
	
	class HandleControlButton implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			Object source = e.getSource();
			
			if(source == menu1_main)
			{
					panelMain.removeAll();
					panelMain.repaint();
					panelMain.revalidate();
					
					panelMain.add(new panelEncodemain(), BorderLayout.CENTER);
					panelMain.repaint();
					panelMain.revalidate();
			}
			
			if(source == menu1_code)
			{
					panelMain.removeAll();
					panelMain.repaint();
					panelMain.revalidate();
					
					panelMain.add(new panelEncodecode(), BorderLayout.CENTER);
					panelMain.repaint();
					panelMain.revalidate();
			}
			
			if(source == menu1_exit)
			{
					System.exit(0);		
			}
		}
	}
}
