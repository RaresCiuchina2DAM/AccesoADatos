import java.sql.*;

public class Clase24 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Crear la conexion
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo?serverTimeZone=UTC", "root", "afuera");

        //Crear el statement
        Statement st = con.createStatement();

        //Permiten posicionamiento
        //no es sensible a determinadas a modificaciones es decir, si añado una fila se queda como está
        Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        Statement sentencia2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


        //Crear la consulta
        String sql = "SELECT * FROM dptos";

        //Ejecutar la consulta
        ResultSet rs = sentencia.executeQuery(sql);

        //te coloca anetior a la primera fila
        rs.beforeFirst();

        //RECORREMOS EL RESULTSET
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
            }

        System.out.println("AHORA ALREVES\n");

        //Nos posicionamos despues del ultimo
        rs.afterLast();
        //recorremos hacia atras
        while (rs.previous()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
        }


        System.out.println( "AHORA AÑADIMOS UNA NUEVA FILA\n");
        //PREPARAMOS EL RESULT SET PARA DAR DE ALTA UNA NUEVA FILA
        rs.moveToInsertRow();
        //damos de alta la fila y los valores
        rs.updateInt(1, 56);
        rs.updateString(2, "INFORMATICA");
        rs.updateString(3, "M");
        rs.updateFloat(4, 185.65f);
        //insertamos la fila
        rs.insertRow();

        rs.first();
        //RECORREMOS EL RESULTSET
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
        }


        System.out.println( "AHORA BORRAMOS UNA FILA\n");


        //borramos el ultimo elemento de la fila
        rs.last();
        rs.deleteRow();


        rs.first();
        //RECORREMOS EL RESULTSET
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
        }

        //Cerrar el resultset
        rs.close();

    }
}
