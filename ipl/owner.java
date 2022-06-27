 package ipl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class owner extends JFrame {

	private JPanel contentPane;
	private JTextField pid;
	private JTextField tname;
	private JTextField pname;
	private JTextField role;
	private JTextField wic;
	private JTextField runs;
	private JTextField natio;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					owner frame = new owner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public owner() {
		con=demo.db();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLAYER DETAILS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(322, 38, 276, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PLAYER ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(107, 167, 131, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TEAM");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(107, 227, 115, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PLAYER NAME");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(107, 299, 150, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ROLE");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(107, 378, 115, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("WICKETS");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(112, 452, 94, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("RUNS");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(107, 509, 94, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\MURALI\\Pictures\\Saved Pictures\\ipl7.jpg"));
		lblNewLabel_7.setBounds(695, 79, 250, 340);
		contentPane.add(lblNewLabel_7);
		
		pid = new JTextField();
		pid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pid.setBounds(305, 167, 164, 30);
		contentPane.add(pid);
		pid.setColumns(10);
		
		tname = new JTextField();
		tname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tname.setBounds(302, 227, 167, 35);
		contentPane.add(tname);
		tname.setColumns(10);
		
		pname = new JTextField();
		pname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pname.setBounds(305, 309, 178, 30);
		contentPane.add(pname);
		pname.setColumns(10);
		
		role = new JTextField();
		role.setFont(new Font("Times New Roman", Font.BOLD, 20));
		role.setBounds(302, 383, 181, 30);
		contentPane.add(role);
		role.setColumns(10);
		
		wic = new JTextField();
		wic.setFont(new Font("Times New Roman", Font.BOLD, 20));
		wic.setBounds(302, 452, 181, 38);
		contentPane.add(wic);
		wic.setColumns(10);
		
		runs = new JTextField();
		runs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		runs.setBounds(307, 517, 175, 35);
		contentPane.add(runs);
		runs.setColumns(10);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(837, 495, 105, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DISPLAY");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{   
			  		 String query="select * from player where playerid=?";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		//JOptionPane.showMessageDialog(null, "enter your admin id details will be displayed");
			  		 pst.setString(1, pid.getText() );
			  		 ResultSet rs=pst.executeQuery();
			  		 rs.next();
			  			 pname.setText(rs.getString(2));
			  			natio.setText(rs.getString(3));
			  		 rs.close();
			  		 pst.close();
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
				try{   
			  		 String query="select * from performance where pid=?";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		//JOptionPane.showMessageDialog(null, "enter your admin id details will be displayed");
			  		 pst.setString(1, pid.getText() );
			  		 ResultSet rs=pst.executeQuery();
			  		 rs.next();
			  			 runs.setText(rs.getString(3));
			  			wic.setText(rs.getString(4));
			  		 rs.close();
			  		 pst.close();
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
				try{   
			  		 String query="select * from rolls where playerid=?";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		//JOptionPane.showMessageDialog(null, "enter your admin id details will be displayed");
			  		 pst.setString(1, pid.getText() );
			  		 ResultSet rs=pst.executeQuery();
			  		 rs.next();
			  			 role.setText(rs.getString(2));
			  		 rs.close();
			  		 pst.close();
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
				try{   
			  		 String query="select t.tname from team t, player p where p.playerid=? and p.teamid=t.teamid";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		//JOptionPane.showMessageDialog(null, "enter your admin id details will be displayed");
			  		 pst.setString(1, pid.getText() );
			  		 ResultSet rs=pst.executeQuery();
			  		 rs.next();
			  			 tname.setText(rs.getString(1));
			  		 rs.close();
			  		 pst.close();
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(657, 495, 131, 59);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("NATIONALITY");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_8.setBounds(107, 582, 150, 30);
		contentPane.add(lblNewLabel_8);
		
		natio = new JTextField();
		natio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		natio.setBounds(305, 582, 188, 30);
		contentPane.add(natio);
		natio.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{  
			  		 String query="update player set pname=?,pnationality=? where playerid=?";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		 pst.setString(1,pname.getText() );
			  		pst.setString(2,natio.getText() );
			  		pst.setString(3,pid.getText() );
			  		 
			  		pst.executeUpdate();
				  		 pst.close();
				  		// JOptionPane.showMessageDialog(null, "succesfully updated");
			  		
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
				try{  
			  		 String query="update rolls set rollplayed=? where playerid=?";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		 pst.setString(1,role.getText() );
			  		pst.setString(2,pid.getText() );
			  		 
			  		pst.executeUpdate();
				  		 pst.close();
				  		// JOptionPane.showMessageDialog(null, "succesfully updated");
			  		
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
				try{  
			  		 String query="update performance set runsavg=?,wktavg=? where pid=?";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		 pst.setString(1,runs.getText() );
			  		pst.setString(2,wic.getText() );
			  		pst.setString(3,pid.getText() );
			  		 
			  		pst.executeUpdate();
				  		 pst.close();
				  		JOptionPane.showMessageDialog(null, "succesfully updated");
			  		
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
			}});
	
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(744, 563, 121, 53);
		contentPane.add(btnNewButton_2);
	}
}