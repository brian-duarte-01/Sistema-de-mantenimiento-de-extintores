package entidad_noviembre;

public class noviembre {

    int id;
    String nombre;
    double valor;
    String fecha;
    String status;

    public noviembre() {
    }

    public noviembre(int id, String nombre, double valor, String fecha, String status) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.fecha = fecha;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

}
