package org.losi.modelos.servicios;

import java.util.List;
import org.losi.modelos.bo.Cliente;
import org.losi.modelos.bo.CopiaPelicula;
import org.losi.modelos.bo.Empleado;
import org.losi.modelos.bo.Genero;
import org.losi.modelos.bo.Pelicula;
import org.losi.modelos.bo.Venta;
import org.losi.modelos.dao.ClienteDAO;
import org.losi.modelos.dao.CopiaPeliculaDAO;
import org.losi.modelos.dao.EmpleadoDAO;
import org.losi.modelos.dao.GeneroDAO;
import org.losi.modelos.dao.PeliculaDAO;
import org.losi.modelos.dao.VentaDAO;

public class ServiciosLOSI {
private final PeliculaDAO peliculaDAO;
    private final GeneroDAO generoDAO;
    private final EmpleadoDAO empleadoDAO;
    private final ClienteDAO clienteDAO;
    private final CopiaPeliculaDAO copiaDAO;
    private final VentaDAO ventaDAO;

    public ServiciosLOSI(){
        peliculaDAO = new PeliculaDAO();
        generoDAO = new GeneroDAO();
        empleadoDAO = new EmpleadoDAO();
        clienteDAO = new ClienteDAO();
        copiaDAO = new CopiaPeliculaDAO();
        ventaDAO = new VentaDAO();
    }
    
    public List<Pelicula> catalogoPeliculas(){
        return peliculaDAO.buscarTodos();
    }
    
    public List<Genero> catalogoGeneros(){
        return generoDAO.buscarTodos();
    }
    
    public List<Empleado> catalogoEmpleados(){
        return empleadoDAO.buscarTodos();
    }
    
    public List<Cliente> catalogoClientes(){
        return clienteDAO.buscarTodos();
    }
    
    public List<CopiaPelicula> catalogoCopias(){
        return copiaDAO.buscarTodos();
    }
    
        public void altaEmpleado(Empleado e){
        empleadoDAO.persistir(e);
    }
    
    public void altaCliente(Cliente e){
        clienteDAO.persistir(e);
    }
    
    public void altaGenero(Genero e){
        generoDAO.persistir(e);
    }
    
    public void altaPelicula(Pelicula e){
        peliculaDAO.persistir(e);
    }
    
    public void altaCopiaPelicula(CopiaPelicula e){
        copiaDAO.persistir(e);
    }
    
    public void altaVenta(Venta e){
        ventaDAO.persistir(e);
    }
    
    public void actualizaEmpleado(Empleado e){
        empleadoDAO.actualizar(e);
    }
    
    public void actualizaCliente(Cliente e){
        clienteDAO.actualizar(e);
    }
    
    public void actualizaGenero(Genero e){
        generoDAO.actualizar(e);
    }
    
    public void actualizaPelicula(Pelicula e){
        peliculaDAO.actualizar(e);
    }
    
    public void actualizaCopiaPelicula(CopiaPelicula e){
        copiaDAO.actualizar(e);
    }
    
    public void actualizaVenta(Venta e){
        ventaDAO.actualizar(e);
    }
    
}