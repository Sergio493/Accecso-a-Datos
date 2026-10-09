package repository;

import modelo.Telefono;

import java.sql.SQLException;
import java.util.List;

public interface TelefonoDao {
    void agregarTelefono(Telefono telefono) throws SQLException;
    List<Telefono> obtenerTelefonosPorUsuario(int idUsuario) throws SQLException;
    List<Telefono> obtenerTodosLosTelefonos() throws SQLException;
    void actualizarTelefono(int idUsuario, int telefonoAnterior, int telefonoNuevo) throws SQLException;
    void eliminarTelefono(int idUsuario, int telefono) throws SQLException;
}
