package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Main_Classes.*;
import systemMainClasses.GuildSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ManageFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextArea textArea;
	private JLabel lblMsg;
	
	private GuildSystem guild;
	private Adventurer current;

	/**
	 * Create the frame.
	 */
	public ManageFrame(GuildSystem guild) {
		this.guild = guild;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(24, 29, 49, 14);
		contentPane.add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(83, 26, 201, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(24, 69, 378, 98);
		contentPane.add(scrollPane);
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
			    current = guild.searchAdventurer(name);
			    
			    if (current != null) {
			    	//refresh display
			    	textArea.setText(current.toString());
			    	lblMsg.setText("Adventurer found.");
			    } else {
			    	textArea.setText("");
			    	lblMsg.setText("Not found.");
			    }
			}
		});
		btnSearch.setBounds(313, 25, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (current != null) {
			        String msg = guild.deleteAdventurer(current.getName());
			        lblMsg.setText(msg);
			        current = null;
			        textArea.setText("");
			    } else {
			    	lblMsg.setText("Search first!");
			    }
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(24, 178, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnLvLUp = new JButton("Level Up");
		btnLvLUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (current != null && current.getJob() != null) {
					
					// Store the result of the level up attempt
		            boolean success = current.levelUp();
					
					if (success) {
		                lblMsg.setText("Leveled up " + current.getJob().getJobName() + 
		                               " to level " + current.getJob().getLevel());
		            } else {
		                // Specific message when growth is restricted by MAX_STAT[cite: 1]
		                lblMsg.setText("Max potential reached!");
		            }
					
					// refresh display
			    	textArea.setText(current.toString());
				} else {
					lblMsg.setText("No job selected!");
				}
			}
		});
		btnLvLUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLvLUp.setBounds(123, 178, 89, 23);
		contentPane.add(btnLvLUp);
		
		JButton btnEvolve = new JButton("Evolve");
		btnEvolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (current != null && current.getJob() != null) {
					
					Job job = current.getJob();	
					
					// Check if they are already maxed out
					if (job.isFinalEvolution()) {
		                lblMsg.setText(job.getJobName() + " has reached its final evolution!");
		            } else if (job.canEvolve()) { // check if they meet the level requirements to evolve
						current.chooseJob(job.evolve().getJobName());
						lblMsg.setText("Evolved to " + current.getJob().getJobName());
						 
						 // refresh display
					    textArea.setText(current.toString());
					} else { // not high enough level yet
						 lblMsg.setText("Cannot evolve yet!");
					}
					
				} else {
					lblMsg.setText("No job selected!");
				}
			}
		});
		btnEvolve.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEvolve.setBounds(222, 178, 89, 23);
		contentPane.add(btnEvolve);
		
		JButton btnMain = new JButton("Main");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMain.setBounds(324, 178, 89, 23);
		contentPane.add(btnMain);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(24, 212, 278, 40);
		contentPane.add(lblMsg);
		
		JButton btnChJob = new JButton("Change Job");
		btnChJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (current != null) {
			        new JobUpdateFrame(current).setVisible(true);
			    } else {
			    	lblMsg.setText("Search an adventurer first!");
			    }
			}
		});
		btnChJob.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnChJob.setBounds(313, 210, 100, 43);
		contentPane.add(btnChJob);
	}
}
