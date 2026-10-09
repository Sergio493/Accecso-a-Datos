package repository;

import modelo.Telefono;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TelefonoDaoImp implements TelefonoDao {


    @Override
    public void agregarTelefono(Telefono telefono) throws SQLException {
        String sql = "INSERT INTO Telefonos (cod, telefono) VALUES (?, ?)";

    }

    @Override
    public List<Telefono> obtenerTelefonosPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT cod, telefono FROM Telefonos WHERE cod = ?";
        List<Telefono> telefonos = new ArrayList<>();

        return telefonos;
    }

    @Override
    public List<Telefono> obtenerTodosLosTelefonos() throws SQLException {
        String sql = "SELECT cod, telefono FROM Telefonos";
        List<Telefono> telefonos = new ArrayList<>();

        return telefonos;
    }

    @Override
    public void actualizarTelefono(int idUsuario, int telefonoAnterior, int telefonoNuevo) throws SQLException {
        String sql = "UPDATE Telefonos SET telefono = ? WHERE cod = ? AND telefono = ?";

    }

    @Override
    public void eliminarTelefono(int idUsuario, int telefono) throws SQLException {
        String sql = "DELETE FROM Telefonos WHERE cod = ? AND telefono = ?";

    }
}
