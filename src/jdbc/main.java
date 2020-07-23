package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import jdbc.model.TestObject;


public class main {

    public static void main(String[] args) {

        // [1] Registrar el Controlador
        try {
            Class.forName ("org.h2.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }

        String URL = "jdbc:h2:~/test";
        String USER = "sa";
        String PASS = "";

        // [2] - Establecer la conexión utilizando la URL y los datos de autenticación (opciones)
        // [3] - Obtener una instancia de Statement para poder ejecutar sentencias nativas de la base de datos
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement st = conn.createStatement();){
/*
            System.out.println("Creating table in given database...");
            String sql =  "CREATE TABLE IF NOT EXISTS TEST6(ID INT PRIMARY KEY,"
                        + "NAME VARCHAR(255));";
            st.executeUpdate(sql);
            st.executeUpdate("INSERT INTO TEST6 VALUES(1, 'Bla');");
            st.executeUpdate("INSERT INTO TEST6 VALUES(2, 'Bla');");

            System.out.println("Created table in given database...");
*/

            //[4] - Utilizar ResultSet para obtener los datos provenientes de una consulta SQL
            ResultSet rs = st.executeQuery("SELECT * FROM TEST;");
            Collection<TestObject> collection = new ArrayList<>();

            while (rs.next()) {
                TestObject current = new TestObject();
                current.id = rs.getString(1);
                current.name = rs.getString("NAME");
                collection.add(current);
                System.out.print(rs.getString(1));
                System.out.print("-");
               System.out.println(rs.getString("NAME"));
            }

            System.out.print("-");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } 
        
    }
    
}
