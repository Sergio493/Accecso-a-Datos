
import modelo.Telefono;
import modelo.Usuarios;
import repository.TelefonoDao;
import repository.TelefonoDaoImp;
import repository.UsuarioDao;
import repository.UsuarioDaoImp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DatabaseConection databaseConection = new DatabaseConection();
        UsuarioDao usuarioDao = new UsuarioDaoImp(databaseConection);
        TelefonoDao telefonoDao = new TelefonoDaoImp(databaseConection);

        try (Scanner teclado = new Scanner(System.in)) {
            System.out.print("Introduce el nombre del usuario: ");
            String nombre = teclado.nextLine();

            try {
                List<Usuarios> usuarios = usuarioDao.obtenerUsuariosPorNombre(nombre);

                for (Usuarios usuario : usuarios) {
                    List<Telefono> telefonos = telefonoDao.obtenerTelefonosPorUsuario(usuario.getId());

                    if (telefonos.isEmpty()) {
                        System.out.println("Este no tiene iphone");
                    } else {
                        for (Telefono telefono : telefonos) {
                            System.out.println("Teléfono: " + telefono.getTelefono());
                        }
                    }
                }

                if (usuarios.isEmpty()) {
                    System.out.println("Nothing there");
                }
            } catch (SQLException e) {
                System.err.println("Error al consultar usuarios o teléfonos: " + e.getMessage());
            }
        }
    }
}
