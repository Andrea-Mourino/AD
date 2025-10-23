import java.sql.*;
import java.util.ArrayList;

public class CRUD {
    public static void insertarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo(modelo,marca,ano,descripcion) values (?,?,?,?)";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexionMetodo()) {
            ps=conn.prepareStatement(sql);
            ps.setString(1,vehiculo.getModelo());
            ps.setString(2,vehiculo.getMarca());
            ps.setInt(3,vehiculo.getAno());
            ps.setString(4,vehiculo.getDescripcion());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar un vehiculo: " + e.getMessage());
        }
    }

    public static ArrayList<Vehiculo> leerVehiculos (){
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        Vehiculo vehiculo;
        String sql = "SELECT * FROM vehiculo";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexionMetodo()) {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int ano = rs.getInt("ano");
                String descripcion = rs.getString("descripcion");
                vehiculo = new Vehiculo(id,modelo,marca,ano,descripcion);
                listaVehiculos.add(vehiculo);

            }
        } catch (SQLException e) {
            System.out.println("Error al leer la base de datos: " + e.getMessage());
        }
        return listaVehiculos;

    }

    public static void actualizarVehiculo(Vehiculo vehiculoactualizado, int id) {
        String sql = "UPDATE vehiculo set modelo = ?, marca = ?, ano = ?, descripcion = ? WHERE id = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexionMetodo()) {
            ps=conn.prepareStatement(sql);
            ps.setString(1,vehiculoactualizado.getModelo());
            ps.setString(2,vehiculoactualizado.getMarca());
            ps.setInt(3,vehiculoactualizado.getAno());
            ps.setString(4,vehiculoactualizado.getDescripcion());
            ps.setInt(5, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar un vehiculo: " + e.getMessage());
        }

    }

    public static void eliminarVehiculo(int id){
        String sql = "DELETE FROM vehiculo WHERE id = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexionMetodo()) {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al borrar el vehiculo: " + e.getMessage());
        }
    }



}
