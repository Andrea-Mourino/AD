import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    public static Connection conexionMetodo(){
         String url = "jdbc:postgresql://aws-1-eu-north-1.pooler.supabase.com:6543/postgres?user=postgres.xlarfbdnbyauabjlunug&password=admin";
         String usuario = "postgres";
         String contraseña = "admin";
         Connection conex = null;

         try {
             conex= DriverManager.getConnection(url,usuario,contraseña);
             System.out.println("Conexion exitosa a la base de datos!!!");
         }
         catch (SQLException e) {
             System.out.println("Error al conectar a la base de datos " + e.getMessage());
         }
         return conex;
    }



}
