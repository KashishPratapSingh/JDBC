import java.sql.*;
public class peopleOfLpu {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Peoples";
        String usrName="root";
        String PassWord="K@#ish21";
        String uName="";
        String query="Select * from name";
        Connection co=DriverManager.getConnection(url,usrName,PassWord);
        PreparedStatement st=co.prepareStatement(query);
//        st.setString(1,"Kashish");
//        int count=st.executeUpdate();
//        System.out.print(count+" row affected");
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            String username=rs.getString("sname");
            System.out.println(username);
        }
        st.close();
        co.close();
    }
}
