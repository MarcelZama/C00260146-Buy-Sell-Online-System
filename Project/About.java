package Project;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class About extends JPanel {
	private JTable table;
	private JTable table_1;

	public About() {
		setBounds(253, 42, 721, 474);
		setVisible(true);
		
		table_1 = new JTable();
		table_1.setShowHorizontalLines(false);
		table_1.setShowVerticalLines(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "                                     About"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, "Our first shop was opened in London in 1992. We "},
				{null, "have stores in UK,Spain,Ireland,India."},
				{null, "Australia, Portugal, Netherlands, Mexico, Poland"},
				{null, "and Canarias.We buy, sell and exchange a range"},
				{null, "of technology and entertainment products"},
				{null, "including mobile phones, video games, DVDs and"},
				{null, "Blu-ray movies, computers, digital electronics, TVs"},
				{null, "and monitors, and music CDs"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(240);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(480);
		add(table_1);
		
		table = new JTable();
		add(table);
	}

}
