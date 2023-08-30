package CRUD_APPLICATION;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.*;
import java.sql.*;

import com.toedter.calendar.JDateChooser;


// import java.awt.event.ActionEvent;

public class UserInformation extends JFrame{
    
    private static final long serialVersionUID= 1L;
    private JPanel contentPane;
    private JTextField textField, textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8;
	private JButton insert, update, delete, clear, exit;
	private JRadioButton male, female, other;
	JDateChooser dateChooser;
    private JFrame frame1;
    private static UserInformation frame;
    private User user;
    private UserDAO dao;
    private String username= "root";
    private String password= "3Umbrellas@";
    private JLabel lblNewLabel;

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    frame= new UserInformation();
                    frame.setVisible(true);
                    frame.setTitle("User Infomation");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public UserInformation(){
        initialize();
    }
    private void initialize(){
        frame1= new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 545);
        contentPane= new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Label1= new JLabel("Enter your data here:");
        Label1.setFont(new Font("Raleway", Font.BOLD, 20));
        Label1.setForeground(Color.BLACK);
        Label1.setBounds(248, 50, 555, 32);
        contentPane.add(Label1);


        JLabel lblUserInformation= new JLabel("USER INFORMATION: ");
        lblUserInformation.setFont(new Font("Raleway", Font.BOLD, 21));
        lblUserInformation.setForeground(Color.WHITE);
        lblUserInformation.setBackground(Color.BLACK);
        lblUserInformation.setBounds(328, 24, 44, HEIGHT);
        contentPane.add(lblUserInformation);


        JLabel lblAadhar = new JLabel("Aadhar: ");
		lblAadhar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadhar.setFont(new Font("Raleway", Font.BOLD, 15));
		lblAadhar.setBounds(287, 104, 93, 32);
		contentPane.add(lblAadhar);

        textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(362, 104, 165, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox(new UserDAOImpl(username,password).getAadhar());
		
		comboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				 if (comboBox.getSelectedIndex() != -1) {
			           
						String value = String.valueOf(comboBox.getSelectedItem());
			            user = new UserDAOImpl(username, password).fillFields(value);
			           	textField.setText(user.getAadhar());
						textField1.setText(user.getName());
						textField2.setText(user.getDob());
						textField3.setText(user.getGender());
						textField4.setText(user.getAddress());
						textField5.setText(user.getContact());
						textField6.setText(user.getEmail());
						textField7.setText(String.valueOf(user.getIncome()));
					}
			}
			
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(539, 104, 128, 34);
		contentPane.add(comboBox);

        JLabel lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Raleway", Font.BOLD, 15));
		lblName.setBounds(287, 144, 93, 32);
		contentPane.add(lblName);

        textField1 = new JTextField(20);
		textField1.setFont(new Font("Raleway", Font.BOLD, 15));
		textField1.setBounds(362, 144, 165, 34);
		contentPane.add(textField1);
		textField1.setColumns(10);


        JLabel lblDob = new JLabel("Date of Birth: ");
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		lblDob.setFont(new Font("Raleway", Font.BOLD, 15));
		lblDob.setBounds(270, 184, 100, 32);
		contentPane.add(lblDob);

        // textField2 = new JTextField();
		// textField2.setFont(new Font("Raleway", Font.BOLD, 15));
		// textField2.setBounds(370, 184, 155, 34);
		// contentPane.add(textField2);
		// textField2.setColumns(10);

		dateChooser= new JDateChooser();
        dateChooser.setBounds(370, 184, 155, 34);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel lblGender = new JLabel("Gender: ");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Raleway", Font.BOLD, 15));
		lblGender.setBounds(284, 224, 100, 32);
		contentPane.add(lblGender);

        // textField3 = new JTextField();
		// textField3.setFont(new Font("Raleway", Font.BOLD, 15));
		// textField3.setBounds(370, 224, 155, 34);
		// contentPane.add(textField3);
		// textField3.setColumns(10);     

		male= new JRadioButton("Male");
        male.setBounds(370, 224, 60, 30);
        male.setForeground(Color.BLACK);
        add(male);

        female= new JRadioButton("Female");
        female.setBounds(450, 224, 83, 30);
        female.setForeground(Color.BLACK);
        add(female);

		other= new JRadioButton("Other");
        other.setBounds(530, 224, 60, 30);
        other.setForeground(Color.BLACK);
        add(other);

        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
		gendergroup.add(other);
        
        JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Raleway", Font.BOLD, 15));
		lblAddress.setBounds(284, 264, 100, 32);
		contentPane.add(lblAddress);

        textField4 = new JTextField(20);
		textField4.setFont(new Font("Raleway", Font.BOLD, 15));
		textField4.setBounds(370, 264, 155, 34);
		contentPane.add(textField4);
		textField4.setColumns(10);    
        
        JLabel lblContact = new JLabel("Contact: ");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Raleway", Font.BOLD, 15));
		lblContact.setBounds(284, 304, 100, 32);
		contentPane.add(lblContact);

        textField5 = new JTextField(20);
		textField5.setFont(new Font("Raleway", Font.BOLD, 15));
		textField5.setBounds(370, 304, 155, 34);
		contentPane.add(textField5);
		textField5.setColumns(10);   
        
        
        JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Raleway", Font.BOLD, 15));
		lblEmail.setBounds(284, 344, 100, 32);
		contentPane.add(lblEmail);

        textField6 = new JTextField(20);
		textField6.setFont(new Font("Raleway", Font.BOLD, 15));
		textField6.setBounds(370, 344, 155, 34);
		contentPane.add(textField6);
		textField6.setColumns(10);   
        
        
        JLabel lblIncome = new JLabel("Income: ");
		lblIncome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncome.setFont(new Font("Raleway", Font.BOLD, 15));
		lblIncome.setBounds(284, 384, 100, 32);
		contentPane.add(lblIncome);

        textField7 = new JTextField(20);
		textField7.setFont(new Font("Raleway", Font.BOLD, 15));
		textField7.setBounds(370, 384, 155, 34);
		contentPane.add(textField7);
		textField7.setColumns(10);  
		
		insert= new JButton("Insert");
		insert.setFont(new Font("Raleway", Font.BOLD, 15));
		insert.setBounds(200, 430, 100, 23);
		contentPane.add(insert);

		insert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// String id=textField.getText();
				// String description=textField1.getText();
				// double price=Double.parseDouble(textField2.getText());
				// int quantity=Integer.parseInt(textField3.getText());
				String aadhar= textField.getText();
				String name= textField1.getText();
				//String dob= textField2.getText();
				String dob= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				//String gender= textField3.getText();
				String gender= null;
				if(male.isSelected()){
					gender= "Male";
				}
				else if(female.isSelected()){
					gender= "Female";
				}
				String address= textField4.getText();
				String contact= textField5.getText();
				String email= textField6.getText();
				int income= Integer.parseInt(textField7.getText());

				user=new User(aadhar, name, dob, gender, address, contact, email, income);
				dao= new UserDAOImpl(username,password);
				
				if(UserDAOImpl.getConnection()!=null)
				{
					int result=dao.insertUser(user);
					
					if(result>0)
					{
						lblNewLabel.setText("Row inserted successfully !"); 
						//showMessage();
						comboBox.addItem(aadhar);
						lblNewLabel.setForeground(Color.BLUE);
						
					}
					else
					{
						lblNewLabel.setText("ERROR! NO row inserted"); 
						//showMessage();
						lblNewLabel.setForeground(Color.RED);
					}
				}
				else
				{
					lblNewLabel.setText("Connection Error!"); 
					//showMessage();
					lblNewLabel.setForeground(Color.RED);
				}
				
			}
		});
		

		update= new JButton("Update");
		update.setFont(new Font("Raleway", Font.BOLD, 15));
		update.setBounds(310, 430, 100, 23);
		contentPane.add(update);

		update.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
							String aadhar= textField.getText();
							String name= textField1.getText();
							String dob1= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
							//String dob= textField2.getText();
							String dob= dob1;
							String gender= textField3.getText();
							String address= textField4.getText();
							String contact= textField5.getText();
							String email= textField6.getText();
							int income= Integer.parseInt(textField7.getText());

							user=new User(aadhar, name, dob, gender, address, contact, email, income);
							dao= new UserDAOImpl(username,password);
				
						
						if(ProductDAOImpl.getConnection()!=null)
						{
							int result=dao.updateUser(user);
							
							if(result>0)
							{
								lblNewLabel.setText("Row updated successfully !"); 
								lblNewLabel.setForeground(Color.BLUE);
								
							}
							else
							{
								lblNewLabel.setText("No update has been performed"); 
								lblNewLabel.setForeground(Color.RED);
							}
						}
						else
						{
							lblNewLabel.setText("Connection Error!"); 
							lblNewLabel.setForeground(Color.RED);
						}
						
						
					}
					
				});

		delete= new JButton("Delete");
		delete.setFont(new Font("Raleway", Font.BOLD, 15));
		delete.setBounds(420, 430, 100, 23);
		contentPane.add(delete);

		delete.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						String aadhar= textField.getText();
							String name= textField1.getText();
							String dob= textField2.getText();
							String gender= textField3.getText();
							String address= textField4.getText();
							String contact= textField5.getText();
							String email= textField6.getText();
							int income= Integer.parseInt(textField7.getText());

							user=new User(aadhar, name, dob, gender, address, contact, email, income);
							dao= new UserDAOImpl(username,password);
				
						if(ProductDAOImpl.getConnection()!=null)
						{
							int result=dao.deleteUser(aadhar);
							
							if(result>0)
							{
								lblNewLabel.setText("Row deleted successfully !"); 
								comboBox.removeItem(aadhar);
								lblNewLabel.setForeground(Color.BLUE);
								
							}
							else
							{
								lblNewLabel.setText("No deletion has been performed"); 
								lblNewLabel.setForeground(Color.RED);
							}
						}
						else
						{
							lblNewLabel.setText("Connection Error!"); 
							lblNewLabel.setForeground(Color.RED);
						}
						
					}
					
				});

		clear= new JButton("Clear");
		clear.setFont(new Font("Raleway", Font.BOLD, 15));
		clear.setBounds(530, 430, 100, 23);
		contentPane.add(clear);

		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				textField6.setText("");
				textField7.setText("");
				lblNewLabel.setText("");
				comboBox.setSelectedIndex(-1);
				
			}
		});
		
		exit= new JButton("Exit");
		exit.setFont(new Font("Raleway", Font.BOLD, 15));
		exit.setBounds(640, 430, 100, 23);
		contentPane.add(exit);

		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//frame.setVisible(false);
				frame.dispose();
			}
		});
		

    }
}
