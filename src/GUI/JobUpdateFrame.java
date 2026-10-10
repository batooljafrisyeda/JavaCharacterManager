package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main_Classes.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobUpdateFrame extends JFrame {

	private JPanel contentPane;

	private Adventurer current;

	/**
	 * Create the frame.
	 */
	public JobUpdateFrame(Adventurer current) {
		this.current = current;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select new job:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(29, 35, 104, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(143, 31, 246, 22);
		contentPane.add(comboBox);
		
		// populate combobox based on your race
		String[] options = current.getRace().getJobOptions();
	    for (String job : options) {
	        comboBox.addItem(job);
	    }
		
	    JLabel lblResult = new JLabel("");
		lblResult.setBounds(29, 140, 360, 35);
		contentPane.add(lblResult);
	    
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedJob = (String) comboBox.getSelectedItem();
				
				// block evolution-only jobs
			    if (selectedJob.equals("Archmage") || selectedJob.equals("Berserker")) {
			        lblResult.setText("This job is evolution-only!");
			        return;
			    }
			    
			    current.chooseJob(selectedJob);

			    lblResult.setText("Job changed to " + selectedJob);
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(70, 107, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClose.setBounds(271, 108, 85, 21);
		contentPane.add(btnClose);
	}

}