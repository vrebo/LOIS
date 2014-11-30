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

public class ServiciosLOIS {

    private static final ServiciosLOIS servicios = new ServiciosLOIS();

    public static ServiciosLOIS getServicios(){
        return servicios;
    }
    
    private final PeliculaDAO peliculaDAO;
    private final GeneroDAO generoDAO;
    private final EmpleadoDAO empleadoDAO;
    private final ClienteDAO clienteDAO;
    private final CopiaPeliculaDAO copiaDAO;
    private final VentaDAO ventaDAO;

    public ServiciosLOIS() {
        peliculaDAO = new PeliculaDAO();
        generoDAO = new GeneroDAO();
        empleadoDAO = new EmpleadoDAO();
        clienteDAO = new ClienteDAO();
        copiaDAO = new CopiaPeliculaDAO();
        ventaDAO = new VentaDAO();
    }

    public List<Pelicula> catalogoPeliculas() {
        return peliculaDAO.buscarTodosCommit();
    }

    public List<Genero> catalogoGeneros() {
        return generoDAO.buscarTodosCommit();
    }

    public List<Empleado> catalogoEmpleados() {
        return empleadoDAO.buscarTodosCommit();
    }

    public List<Cliente> catalogoClientes() {
        return clienteDAO.buscarTodosCommit();
    }

    public List<CopiaPelicula> catalogoCopias() {
        return copiaDAO.buscarTodosCommit();
    }

    public void altaEmpleado(Empleado e) {
        empleadoDAO.persistirCommit(e);
    }

    public void altaCliente(Cliente e) {
        clienteDAO.persistirCommit(e);
    }

    public void altaGenero(Genero e) {
        generoDAO.persistirCommit(e);
    }

    public void altaPelicula(Pelicula e) {
        peliculaDAO.persistirCommit(e);
    }

    public void altaCopiaPelicula(CopiaPelicula e) {
        copiaDAO.persistirCommit(e);
    }

    public void altaVenta(Venta e) {
        ventaDAO.persistirCommit(e);
    }

    public void actualizaEmpleado(Empleado e) {
        empleadoDAO.actualizarCommit(e);
    }

    public void actualizaCliente(Cliente e) {
        clienteDAO.actualizarCommit(e);
    }

    public void actualizaGenero(Genero e) {
        generoDAO.actualizarCommit(e);
    }

    public void actualizaPelicula(Pelicula e) {
        peliculaDAO.actualizarCommit(e);
    }

    public void actualizaCopiaPelicula(CopiaPelicula e) {
        copiaDAO.actualizarCommit(e);
    }

    public void actualizaVenta(Venta e) {
        ventaDAO.actualizarCommit(e);
    }
}
