/*
* 1.) import sql package
* 2.) Load and register the driver ("com.mysql.jdbc.driver")
* 3.) Create a connection using connection interface
* 4.) Write a statement
* 5.) Execute the query
* 6.) Process the result
* 7.) close the connection as statement
* */
import java.sql.*;
import java.util.Scanner;

public class NewProject{
    public static void main(String[] args) throws Exception{
        Scanner scn=new Scanner(System.in);
        String a=scn.next();
        String url="jdbc:mysql://localhost:3306/abc";
        String usrName="root";
        String password="K@#ish21";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,usrName,password);
        String query="insert into Student value (?,?)";;
        PreparedStatement st=con.prepareStatement(query);
        switch(a){
            case "yes":
                int uid=scn.nextInt();
                String uname=scn.next();
    //        Statement st=con.createStatement();

                st.setInt(1,uid);
                st.setString(2,uname);
                int count=st.executeUpdate();
                System.out.println(count+" rows affected");
                break;
            case "no":
                ResultSet s=st.executeQuery("Select * from Student");
                while(s.next()){
                    String userdata=s.getInt("rollno")+" : "+s.getString("sname");
                    System.out.println(userdata);
                }
        }
        
//        int count=st.executeUpdate();
//        System.out.println(count+" rows affected");
        st.close();
        con.close();

    }
}