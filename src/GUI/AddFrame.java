package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main_Classes.*;
import race_InheritClasses.*;
import systemMainClasses.GuildSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;

	private GuildSystem guild;

	/**
	 * Create the frame.
	 */
	public AddFrame(GuildSystem guild) {
		this.guild = guild;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 45, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRace = new JLabel("Race:");
		lblRace.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRace.setBounds(20, 101, 49, 14);
		contentPane.add(lblRace);
		
		textField = new JTextField();
		textField.setBounds(79, 42, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Elf", "Giant", "Human"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(79, 97, 143, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 146, 373, 77);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(304, 41, 89, 23);
		contentPane.add(btnAdd);

		ActionListener addCharacter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField.getText();
			    String raceChoice = comboBox.getSelectedItem().toString();
			    
			    Race race = null;
			    
			    if (raceChoice.equals("Human")) race = new Human();
			    else if (raceChoice.equals("Elf")) race = new Elf();
			    else if (raceChoice.equals("Giant")) race = new Giant();
			    
			    if (name.isEmpty() || race == null) {
			        lblNewLabel_1.setText("Invalid input!");
			        return;
			    }
			    
			    Adventurer a = new Adventurer(name, race);
			    boolean added = guild.addAdventurer(a);

			    if (added) {
			        lblNewLabel_1.setText("Adventurer added successfully!");
			    } else {
			        lblNewLabel_1.setText("Failed: name taken or guild full.");
			    }
			}
		};
		
		btnAdd.addActionListener(addCharacter);

		textField.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
					addCharacter.actionPerformed(null);
				}
			}
		});
		
		JButton btnMain = new JButton("Main");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMain.setBounds(304, 97, 89, 23);
		contentPane.add(btnMain);
	}
}
