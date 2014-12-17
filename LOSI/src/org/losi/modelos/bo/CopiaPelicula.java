package org.losi.modelos.bo;

public class CopiaPelicula {

    private long idCopiaPelicula;
    private Pelicula pelicula;
    private String codigo;
    private String formato;
    private String fechaAdquisicion;
    private double precio;
    private String estado;

    public CopiaPelicula(long idCopiaPelicula, Pelicula pelicula, String codigo, String formato, String fechaAdquisicion, double precio, String estado) {
        this(pelicula, codigo, formato, fechaAdquisicion, precio, estado);
        this.idCopiaPelicula = idCopiaPelicula;
    }

    public CopiaPelicula(Pelicula pelicula, String codigo, String formato, String fechaAdquisicion, double precio, String estado) {
        this.pelicula = pelicula;
        this.codigo = codigo;
        this.formato = formato;
        this.fechaAdquisicion = fechaAdquisicion;
        this.precio = precio;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public long getIdCopiaPelicula() {
        return idCopiaPelicula;
    }

    public void setIdCopiaPelicula(long idCopiaPelicula) {
        this.idCopiaPelicula = idCopiaPelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public boolean isAvailable(){
        return estado.equals("EN-STOCK");
    }
}
