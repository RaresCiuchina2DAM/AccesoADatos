import java.sql.*;

public class Clase23 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Cargar el driver
        Class.forName("com.mysql.jdbc.Driver");

        //Crear la conexion
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo/?serverTimeZone=UTC","root","afuera");

        //Crear el statement
        Statement st = con.createStatement();
        Statement sentencia = con.createStatement();

        //Crear la consulta
        String sql= "SELECT * FROM dptos";

        //Ejecutar la consulta
        ResultSet rs = st.executeQuery(sql);

        boolean consulta = sentencia.execute(sql);

        if (consulta) {
            //Recorrer el resultset
            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
            }
            //cerramos
            rs.close();
        } else {
            int numfilas = sentencia.getUpdateCount();
            System.out.println("Filas afectadas: " + numfilas);}


        //Cerrar el resultset
        rs.close();


    }
}
