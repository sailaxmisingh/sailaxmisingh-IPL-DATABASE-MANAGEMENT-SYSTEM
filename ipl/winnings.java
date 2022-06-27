package ipl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.*;
public class winnings extends JFrame {

	private JPanel contentPane;
	private JTextField tid;
	private JTextField tname;
	private JTextField nw;
	private JTextField hs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winnings frame = new winnings();
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
	Connection con=null;
	public winnings() {
		con=demo.db();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TEAM WINNINGS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(322, 38, 228, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TEAM ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(35, 146, 173, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TEAM NAME");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(35, 230, 173, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NUMBER OF WINNINGS");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 428, 228, 45);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("HIGH SCORE");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(40, 341, 151, 40);
		contentPane.add(lblNewLabel_4);
		
		tid = new JTextField();
		tid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tid.setBounds(218, 146, 195, 37);
		contentPane.add(tid);
		tid.setColumns(10);
		
		tname = new JTextField();
		tname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tname.setBounds(218, 238, 195, 33);
		contentPane.add(tname);
		tname.setColumns(10);
		
		nw = new JTextField();
		nw.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nw.setBounds(254, 436, 195, 34);
		contentPane.add(nw);
		nw.setColumns(10);
		
		hs = new JTextField();
		hs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hs.setBounds(225, 344, 198, 40);
		contentPane.add(hs);
		hs.setColumns(10);
		
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{   
			  		 String query="select t.tname,w.highscore,w.nwinnings from team t,winnings w where w.teamid=? and t.teamid=w.teamid";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		//JOptionPane.showMessageDialog(null, "enter your admin id details will be displayed");
			  		 pst.setString(1, tid.getText() );
			  		 ResultSet rs=pst.executeQuery();
			  		 rs.next();
			  			 tname.setText(rs.getString(1));
			  			hs.setText(rs.getString(2));
			  			nw.setText(rs.getString(3));
			  		 rs.close();
			  		 pst.close();
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(194, 513, 121, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(730, 506, 98, 68);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\MURALI\\Pictures\\Saved Pictures\\ipl12.jpg"));
		lblNewLabel_5.setBounds(498, 127, 446, 308);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{  
			  		 String query="update team set tname=? where teamid=?";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		 pst.setString(1,tname.getText() );
			  		 pst.setString(2,tid.getText() );
			  		pst.executeUpdate();
				  		 pst.close();
				  		// JOptionPane.showMessageDialog(null, "succesfully updated");
			  		
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
				try{  
			  		 String query="update winnings set highscore=?,nwinnings=? where teamid=?";
			  		 PreparedStatement pst=con.prepareStatement(query);
			  		 pst.setString(1,hs.getText() );
			  		 pst.setString(2,nw.getText() );
			  		 pst.setString(3,tid.getText() );
			  		JOptionPane.showMessageDialog(null, "succesfully updated");
			  		
			  		}catch(Exception e1){
			  			 JOptionPane.showMessageDialog(null, e1);
			  		}
		
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(461, 520, 151, 45);
		contentPane.add(btnNewButton_2);
	}
}
