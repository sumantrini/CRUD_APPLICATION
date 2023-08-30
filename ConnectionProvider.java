package CRUD_APPLICATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider{

    private static Properties p;

    static{
        p= new Properties();
    }

   // String user= "root";
   // String password= "3Umbrellas@";
    public static Connection connect(String user,  String password){
        Connection con= null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/crud";

            p.setProperty("user", user);
            p.setProperty("password", password);

            con= DriverManager.getConnection(url, p);
        }
       
        catch(Exception e){
            System.out.println(e);
        }

        return con;

    }
}