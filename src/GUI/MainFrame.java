package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import systemMainClasses.GuildSystem;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	
	private GuildSystem guild;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		guild = new GuildSystem();
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adventurer Information:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 21, 197, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(20, 41, 265, 195);
		contentPane.add(scrollPane);
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JButton btnDisplay = new JButton("Display ");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = guild.displayAll();
				
				output += "\n--- GUILD STATS ---";
		        output += "\nAverage Level: " + guild.calculateAverageLevel();
		        output += "\nTotal Created Ever: " + Main_Classes.Adventurer.getTotalAdventurers();
		        
		        textArea.setText(output);
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisplay.setBounds(321, 58, 89, 23);
		contentPane.add(btnDisplay);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFrame addFrame = new AddFrame(guild);
				addFrame.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(321, 92, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSearch = new JButton("Manage");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guild.isEmpty()) {
					textArea.setText("No adventurers to manage!");
			    } else {
					ManageFrame mf = new ManageFrame(guild);
				    mf.setVisible(true);
			    }
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBounds(321, 131, 89, 23);
		contentPane.add(btnSearch);
	}
}
