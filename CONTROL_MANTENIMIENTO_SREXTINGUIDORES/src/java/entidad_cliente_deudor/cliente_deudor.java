
package entidad_cliente_deudor;

public class cliente_deudor {
   int id;
   String no_factura;
   String nombre;
   String fecha;
   double total;
   String status;

    public cliente_deudor() {
    }

    

    public cliente_deudor(int id, String no_factura, String nombre, String fecha, double total, String status) {
        this.id = id;
        this.no_factura = no_factura;
        this.nombre = nombre;
        this.fecha = fecha;
        this.total = total;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(String no_factura) {
        this.no_factura = no_factura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
   
   
}
