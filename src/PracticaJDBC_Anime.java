import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticaJDBC_Anime {

    private static final String URL = "jdbc:postgresql://10.0.2.15:5432/probas";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        try (Connection conexion = conectar()) {
            crearTabla(conexion);
            insertarDatos(conexion);
            mostrarTodo(conexion);

            insertarExtra(conexion);
            mostrarConPuntuacionMaxima(conexion);

            actualizarPuntuacion(conexion);
            eliminarRegistro(conexion);
            mostrarTodo(conexion);

        } catch (SQLException e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }

    private static Connection conectar() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            throw e;
        }
    }

    public static void crearTabla(Connection prueba1) throws SQLException {
        String sql = "CREATE TABLE anime (" +
                "nome VARCHAR(100), " +
                "descripcion TEXT, " +
                "data DATE, " +
                "puntuacion INTEGER" +
                ")";
        prueba1.createStatement().execute(sql);
    }

    private static void insertarDatos(Connection conn) throws SQLException {
        String sql = """
                INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES
                ('Evangelion', 'Serie de mechas que explora as emocións dos pilotos nunha ameaza global apocalíptica.', '1995-10-04', 95),
                ('Ghost In the Shell', 'Anime de ciencia ficción cibernética sobre intelixencia artificial e a identidade.', '1995-11-18', 92),
                ('Akira', 'Película postapocalíptica con acción e crítica social ambientada nunha Tokio futurista.', '1988-07-16', 90),
                ('Dragon Ball', 'Serie clásica de aventuras e artes marciais con personaxes icónicos e épicos combates.', '1986-02-26', 88)
                """;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Datos iniciales insertados correctamente.");
        }
    }

    public static void mostrarTodo(Connection prueba1) throws SQLException {
        String sql = "select * from anime";
        ResultSet salida = prueba1.createStatement().executeQuery(sql);
        while (salida.next()) {
            System.out.println("");
            System.out.println("Nombre: " + salida.getString("nome"));
            System.out.println("Descripcion: " + salida.getString("descripcion"));
            System.out.println("Fecha: " + salida.getDate("data"));
            System.out.println("Puntuacion: " + salida.getInt("puntuacion"));
            System.out.println("");
        }
    }

    private static void insertarExtra(Connection conn) throws SQLException {
        String sql = """
                INSERT INTO anime (nome, descripcion, data, puntuacion)
                VALUES ('Jojos', 'Serie de un vampiro metrosexual', '2012-10-06', 100)
                """;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Insertado anime adicional: Jojos");
        }
    }

    private static void mostrarConPuntuacionMaxima(Connection conn) throws SQLException {
        String sql = "SELECT nome FROM anime WHERE puntuacion = 100";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nAnimes con puntuación perfecta (100):");
            while (rs.next()) {
                System.out.println(" - " + rs.getString("nome"));
            }
        }
    }

    private static void actualizarPuntuacion(Connection conn) throws SQLException {
        String sql = "UPDATE anime SET puntuacion = 95 WHERE nome = 'Jojos'";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Puntuación actualizada para Jojos.");
        }
    }

    private static void eliminarRegistro(Connection conn) throws SQLException {
        String sql = "DELETE FROM anime WHERE nome = 'Evangelion'";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Eliminado registro: Evangelion");
        }
    }
}
