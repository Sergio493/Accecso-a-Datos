package modelo;

public class Telefono {
    private int id;
    private int telefono;

    public Telefono() {
    }

    public Telefono(int id, int telefono) {
        this.id = id;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
