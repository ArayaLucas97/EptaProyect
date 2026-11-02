package Deposito.DAO;

public class Paquete {
    private int id_paquete;
    private String nombre, codigo;
    
    public Paquete(){
        
    }
    
    public Paquete(int id_paquete, String nombre,String codigo){
        this.id_paquete = id_paquete;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
