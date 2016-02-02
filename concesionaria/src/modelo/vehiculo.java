
package modelo;


public class vehiculo {
    
    private String modelo=null;
    private String marca=null;
    private int kilometraje=0;
    private int id=0;
    private String color=null;
    private String placa=null;
    private float precio=0;
    
    public vehiculo()
    {
        
        
    }

    public vehiculo(String modelo, String marca, int kilometraje,int id, String color, String placa, float precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.id=id;
        this.color = color;
        this.placa = placa;
        this.precio = precio;
    }

   

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getId() {
        return id;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public float getPrecio() {
        return precio;
    }

    public String getColor() {
        return color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
    
    
}
