package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class LibraryManagementSystem {

	private JFrame frame;
	private JTextField entertitle;
	private JTextField enterauthor;
	private JTextField enterisbn;
	private JTextField entercategory;
	private JTable table;
	private JTextField searchField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryManagementSystem window = new LibraryManagementSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LibraryManagementSystem() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 150, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel table_panel = new JPanel();
		table_panel.setBorder(new LineBorder(new Color(255, 153, 153), 10));
		table_panel.setBackground(new Color(255, 204, 204));
		table_panel.setBounds(455, 132, 801, 540);
		frame.getContentPane().add(table_panel);
		table_panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 781, 462);
		table_panel.add(scrollPane);
		
		DefaultTableModel tableModel = new DefaultTableModel(
		        new Object[][] {},
		        new String[] {"Book Title", "Book Author", "Book ISBN", "Book Category"}
		    );
		    
		    table = new JTable(tableModel);
		    table.setForeground(new Color(255, 51, 153));
		    table.setBackground(new Color(255, 204, 204));
		    table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		    table.setBorder(new LineBorder(new Color(255, 102, 153)));
		    scrollPane.setViewportView(table);
		    
		    searchField = new JTextField();
		    searchField.setBounds(202, 22, 577, 34);
		    table_panel.add(searchField);
		    searchField.setColumns(10);
		    
		    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
		    table.setRowSorter(sorter);
		    
		    JLabel lblNewLabel = new JLabel("Search your books");
		    lblNewLabel.setForeground(new Color(255, 51, 102));
		    lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		    lblNewLabel.setBounds(28, 23, 172, 27);
		    table_panel.add(lblNewLabel);

		    // added DocumentListener to searchField to filter the table based on input
		    searchField.getDocument().addDocumentListener(new DocumentListener() {
		        private void filterTable() {
		            String searchText = searchField.getText();
		            if (searchText.trim().length() == 0) {
		                sorter.setRowFilter(null);
		            } else {
		                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
		            }
		        }
		        
		        @Override
		        public void insertUpdate(DocumentEvent e) {
		            filterTable();
		        }

		        @Override
		        public void removeUpdate(DocumentEvent e) {
		            filterTable();
		        }

		        @Override
		        public void changedUpdate(DocumentEvent e) {
		            filterTable();
		        }
		    });

		
		JLabel librarytext = new JLabel("Library Management System");
		librarytext.setForeground(new Color(255, 255, 255));
		librarytext.setFont(new Font("Harlow Solid Italic", Font.BOLD, 45));
		librarytext.setBounds(437, 0, 600, 139);
		frame.getContentPane().add(librarytext);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\jirah\\Downloads\\pink-pink-book.png"));
		logo.setBounds(284, 11, 161, 128);
		frame.getContentPane().add(logo);
		
		JPanel input_panel = new JPanel();
		input_panel.setBorder(new LineBorder(new Color(255, 153, 153), 10));
		input_panel.setBackground(new Color(255, 204, 204));
		input_panel.setBounds(10, 132, 431, 540);
		frame.getContentPane().add(input_panel);
		input_panel.setLayout(null);
		
		JLabel addyourbook = new JLabel("Add Your Book!");
		addyourbook.setBounds(114, 15, 203, 30);
		addyourbook.setForeground(new Color(255, 51, 102));
		addyourbook.setBackground(new Color(255, 255, 255));
		addyourbook.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		input_panel.add(addyourbook);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 204, 204), 7));
		panel_2.setBounds(10, 45, 411, 95);
		input_panel.add(panel_2);
		panel_2.setLayout(null);
		
		entertitle = new JTextField();
		entertitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		entertitle.setBounds(10, 45, 391, 39);
		panel_2.add(entertitle);
		entertitle.setColumns(10);
		
		JLabel labeltitle = new JLabel("Enter Book Title:");
		labeltitle.setForeground(new Color(255, 102, 153));
		labeltitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labeltitle.setBounds(126, 20, 163, 14);
		panel_2.add(labeltitle);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 204, 204), 7));
		panel_3.setBounds(10, 151, 411, 95);
		input_panel.add(panel_3);
		panel_3.setLayout(null);
		
		enterauthor = new JTextField();
		enterauthor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		enterauthor.setBounds(10, 45, 391, 39);
		panel_3.add(enterauthor);
		enterauthor.setColumns(10);
		
		JLabel labelauthor = new JLabel("Enter Book Author:");
		labelauthor.setForeground(new Color(255, 102, 153));
		labelauthor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labelauthor.setBounds(117, 20, 187, 14);
		panel_3.add(labelauthor);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(255, 204, 204), 7));
		panel_4.setBounds(10, 257, 411, 95);
		input_panel.add(panel_4);
		panel_4.setLayout(null);
		
		enterisbn = new JTextField();
		enterisbn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		enterisbn.setBounds(10, 45, 391, 39);
		panel_4.add(enterisbn);
		enterisbn.setColumns(10);
		
		JLabel labelisbn = new JLabel("Enter Book ISBN:");
		labelisbn.setForeground(new Color(255, 102, 153));
		labelisbn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labelisbn.setBounds(126, 20, 178, 14);
		panel_4.add(labelisbn);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(255, 204, 204), 7));
		panel_5.setBounds(10, 363, 411, 95);
		input_panel.add(panel_5);
		panel_5.setLayout(null);
		
		entercategory = new JTextField();
		entercategory.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		entercategory.setBounds(10, 45, 391, 39);
		panel_5.add(entercategory);
		entercategory.setColumns(10);
		
		JLabel labelcategory = new JLabel("Enter Book Category:");
		labelcategory.setForeground(new Color(255, 102, 153));
		labelcategory.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labelcategory.setBounds(106, 11, 210, 24);
		panel_5.add(labelcategory);
		
		JButton btnNewButton = new JButton("Submit Book Details");
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 102, 153));
		btnNewButton.setBounds(84, 469, 261, 45);
		input_panel.add(btnNewButton);
		
		btnNewButton.addActionListener(e -> {
	        String title = entertitle.getText();
	        String author = enterauthor.getText();
	        String isbn = enterisbn.getText();
	        String category = entercategory.getText();

	        //adding input to the table
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.addRow(new Object[]{title, author, isbn, category});

	        //clear text fields after submit
	        entertitle.setText("");
	        enterauthor.setText("");
	        enterisbn.setText("");
	        entercategory.setText("");
	    });
		
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
			     // get the selected row in the table
		        int row = table.getSelectedRow();
		        if (row != -1) { //row is selected visibly
				//confirm joption pop-up
		            int option = JOptionPane.showConfirmDialog(frame, "Delete this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if (option == JOptionPane.YES_OPTION) {
		                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
		                if (confirm == JOptionPane.YES_OPTION) {
		                    DefaultTableModel model = (DefaultTableModel) table.getModel();
		                    model.removeRow(row);
		                }
		            }
		        }
		    }
		});
		
		JLabel pink = new JLabel("");
		pink.setBounds(0, 0, 1280, 720);
		pink.setBackground(new Color(255, 102, 153));
		pink.setOpaque(true);
		frame.getContentPane().add(pink);
		
		JLabel bgimg = new JLabel("");
		bgimg.setIcon(new ImageIcon("C:\\Users\\jirah\\Downloads\\book.png"));
		bgimg.setBackground(new Color(255, 153, 204));
		bgimg.setBounds(0, 0, 1280, 720);
		frame.getContentPane().add(bgimg);
	}
}
