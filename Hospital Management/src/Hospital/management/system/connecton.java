package Hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connecton {

    Connection connection;
    Statement statement;
    public  connecton(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_mangement_system","root","Prem@9876");
            statement =connection.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
