package Deposito.DAO;

public class Producto {
    
    String Codigo, Nombre,Descripcion;
    int Cantidad, id;
    public Producto(){
        
    }
    public Producto(String Codigo, String Nombre, String Descripcion, int Cantidad, int id){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.id = id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    public int getId(){
        return id;
    }
    
    public void setid(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{" + "Codigo=" + Codigo + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Cantidad=" + Cantidad + ", id=" + id + '}';
    }
    
}
