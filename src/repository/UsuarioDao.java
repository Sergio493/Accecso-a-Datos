package repository;

import modelo.Usuarios;

import java.util.List;

public interface UsuarioDao {
    void agregarUsuario(Usuarios usuario);
    Usuarios obtenerUsuarioPorId(int id);
    List<Usuarios> obtenerTodosLosUsuarios();
    void actualizarUsuario(Usuarios usuario);
    void eliminarUsuario(int id);
}