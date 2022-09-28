
package entidad_cliente;


public class cliente {
    int correlativo;
    String nombre;
    String nit;
    int calle;
    String avenida;
    int zona;
    int telefono;
    String correo;

    public cliente() {
    }

    public cliente(int correlativo, String nombre, String nit, int calle, String avenida, int zona, int telefono, String correo) {
        this.correlativo = correlativo;
        this.nombre = nombre;
        this.nit = nit;
        this.calle = calle;
        this.avenida = avenida;
        this.zona = zona;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getCalle() {
        return calle;
    }

    public void setCalle(int calle) {
        this.calle = calle;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
