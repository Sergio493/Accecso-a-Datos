package repository;

import modelo.Usuarios;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {
    void agregarUsuario(Usuarios usuario) throws SQLException;
    Usuarios obtenerUsuarioPorId(int id) throws SQLException;
    List<Usuarios> obtenerUsuariosPorNombre(String nombre) throws SQLException;
    List<Usuarios> obtenerTodosLosUsuarios() throws SQLException;
    List<Usuarios> obtenerUsuariosPorLocalidad(String localidad) throws SQLException;
    void actualizarUsuario(Usuarios usuario) throws SQLException;
    void eliminarUsuario(int id) throws SQLException;
}