package CRUD_APPLICATION;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    
    private static Connection con;
    private static User user;

    public UserDAOImpl(String username, String password){
        con= ConnectionProvider.connect(username, password);
    }

    public static Connection getConnection(){
        return con;
    }

    //override
    public int insertUser(User u){
        // public User(String Aadhar, String Name, String dob, String gender, String address, String contact, int income)
        String insertQuery= "INSERT INTO users(Aadhar, Name, Dob, Gender, Address, Contact, Income) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int result= -1;
        try{

            PreparedStatement pstmt= con.prepareStatement(insertQuery);
            pstmt.setString(1, u.getAadhar());
            pstmt.setString(2, u.getName());
            pstmt.setString(3, u.getDob());
            pstmt.setString(4, u.getGender());
            pstmt.setString(5, u.getAddress());
            pstmt.setString(6, u.getContact());
            pstmt.setInt(7, u.getIncome());

            result= pstmt.executeUpdate();
            pstmt.close();
        }

        catch(Exception e){
            System.out.println(e);
        }

        return result;
    }

    //override
    public int updateUser(User u){
        String updateQuery= "UPDATE users SET Name=?, Dob=?, Gender=?, Address=?, Contact=?, Email=?, Income=? WHERE Aadhar=?";
        int result= -1;

        try{
            PreparedStatement pstmt= con.prepareStatement(updateQuery);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getDob());
            pstmt.setString(3,u.getGender());
            pstmt.setString(4, u.getAddress());
            pstmt.setString(5, u.getContact());
            pstmt.setString(6, u.getEmail());
            pstmt.setInt(7, u.getIncome());

            result= pstmt.executeUpdate();
        }

        catch(Exception e){
            System.out.println(e);
        }

        return result;
    }

    //override
    public int deleteUser(String aadhar){
        String deleteQuery= "DELETE FROM users WHERE Aadhar=?";
        int result= -1;

        try{
            PreparedStatement pstmt= con.prepareStatement(deleteQuery);
            pstmt.setString(1, aadhar);

            result= pstmt.executeUpdate();
            pstmt.close();
        }
        
        catch(Exception e){
            System.out.println(e);
        }

        return result;
    }

    //override
    public String[] getAadhar(){
        String readQuery= "SELECT Aadhar from users";
        String[] users= null;

        try{
            PreparedStatement pstmt= con.prepareStatement(readQuery);
            ResultSet result= pstmt.executeQuery();
            users= new String[result.getFetchSize()];

            List<String> ulist= new ArrayList<>();
            while(result.next()){
                ulist.add(result.getString(1));
            }
            users= ulist.toArray(new String[0]);
            Arrays.sort(users);
            pstmt.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public User fillFields(String users){
        String getQuery= "SELECT * FROM users where Aadhar=?";

        try{
            PreparedStatement pstmt= con.prepareStatement(getQuery);
            pstmt.setString(1, users);
            ResultSet result= pstmt.executeQuery();

            while(result.next()){

                //INSERT INTO users(Aadhar, Name, Dob, Gender, Address, Contact, Email, Income) VALUES (?, ?, ?, ?, ?, ?);

                String aadhar= result.getString(1);
                String name= result.getString(2);
                String dob= result.getString(3);
                String gender= result.getString(4);
                String address= result.getString(5);
                String contact= result.getString(6);
                String email= result.getString(7);
                int income= result.getInt(8);

                user= new User(aadhar, name, dob, gender, address, contact, email, income );
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }
}
