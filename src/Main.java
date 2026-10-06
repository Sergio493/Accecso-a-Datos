
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:sqlite:prueba.db";

        String sqlUsuario = """
                SELECT cod
                FROM usuarios
                WHERE nombre = ?
                """;

        String sqlTelefonos = """
                SELECT usuarios.nombre, telefonos.telefono
                FROM usuarios
                INNER JOIN telefonos
                ON usuarios.cod = telefonos.cod
                WHERE usuarios.nombre = ?
                """;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el nombre del usuario: ");
        String nombre = teclado.nextLine();

        try (Connection conexion = DriverManager.getConnection(url);
             PreparedStatement stmtUsuario = conexion.prepareStatement(sqlUsuario)) {

            stmtUsuario.setString(1, nombre);

            try (ResultSet rsUsuario = stmtUsuario.executeQuery()) {

                if (!rsUsuario.next()) {
                    System.out.println("Nothing there");
                } else {
                    try (PreparedStatement stmtTelefonos = conexion.prepareStatement(sqlTelefonos)) {
                        stmtTelefonos.setString(1, nombre);
                        try (ResultSet rsTelefonos = stmtTelefonos.executeQuery()) {
                            boolean tieneTelefono = false;
                            while (rsTelefonos.next()) {
                                tieneTelefono = true;

                                System.out.println("Teléfono:"
                                        + rsTelefonos.getString("telefono"));
                            }
                            if (!tieneTelefono) {
                                System.out.println("Este no tiene iphone");
                            }
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en la base de datos:");
            e.printStackTrace();
        }

        teclado.close();
    }
}
