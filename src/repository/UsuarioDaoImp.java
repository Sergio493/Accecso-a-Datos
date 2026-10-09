package repository;

import modelo.Telefono;
import modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsuarioDaoImp implements UsuarioDao {


    @Override
    public void agregarUsuario(Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, apellidos, direccion, localidad) VALUES (?, ?, ?, ?)";

        try (Connection conexion = databaseConection.getConnection();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellidos());
            sentencia.setString(3, usuario.getDireccion());
            sentencia.setString(4, usuario.getLocalidad());
            sentencia.executeUpdate();
        }
    }

    @Override
    public Usuarios obtenerUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT cod, nombre, apellidos, direccion, localidad FROM usuarios WHERE cod = ?";
        return null;
    }

    @Override
    public List<Usuarios> obtenerUsuariosPorNombre(String nombre) throws SQLException {
        String sql = "SELECT cod, nombre, apellidos, direccion, localidad FROM usuarios WHERE nombre = ?";
        List<Usuarios> usuarios = new ArrayList<>();
        return usuarios;
    }

    @Override
    public List<Usuarios> obtenerTodosLosUsuarios() throws SQLException {
        String sql = "SELECT cod, nombre, apellidos, direccion, localidad FROM usuarios";
        List<Usuarios> usuarios = new ArrayList<>();

        return usuarios;
    }

    public List<Telefono> obtenerTelefonos(int idUsuario) throws SQLException{
        String sql = "SELECT cod, telefono FROM Telefonos WHERE cod = ?";
        List<Telefono> telefonos = new ArrayList<>();
        return telefonos;
    }

    @Override
    public List<Usuarios> obtenerUsuariosPorLocalidad(String localidad) throws SQLException {
        String sql = "SELECT cod, nombre, apellidos, direccion, localidad FROM usuarios WHERE localidad = ?";
        List<Usuarios> usuarios = new ArrayList<>();

        return usuarios;
    }

    @Override
    public void actualizarUsuario(Usuarios usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, direccion = ?, localidad = ? WHERE cod = ?";

        try (Connection conexion = databaseConection.getConnection();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellidos());
            sentencia.setString(3, usuario.getDireccion());
            sentencia.setString(4, usuario.getLocalidad());
            sentencia.setInt(5, usuario.getId());
            sentencia.executeUpdate();
        }
    }

    @Override
    public void eliminarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE cod = ?";

        }
    }

    private Usuarios mapearUsuario(ResultSet resultados) throws SQLException {
        return new Usuarios(
                resultados.getInt("cod"),
                resultados.getString("nombre"),
                resultados.getString("apellidos"),
                resultados.getString("direccion"),
                resultados.getString("localidad")
        );
    }

}
