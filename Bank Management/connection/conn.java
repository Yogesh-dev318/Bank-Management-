package connection;
import java.sql.*;

public class conn{
    Connection c;
    public Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","9813236240");
            s =c.createStatement();
            System.out.printf("connected");

        }catch(Exception e){
            System.out.println("exception aa gai"+e.getMessage()
            );
        }

    }

    public static void main(String[] args) {
        conn cc = new conn();
    }
}
