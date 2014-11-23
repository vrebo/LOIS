package silordordo.dao;

import org.losi.dao.VentaDAO;
import org.losi.dao.EmpleadoDAO;
import org.losi.dao.ClienteDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.losi.bo.Cliente;
import org.losi.bo.Conexion;
import org.losi.bo.Empleado;
import org.losi.bo.Venta;
import org.losi.dao.DataBaseHelper;

public class VentaDAOTest {  
    
    private VentaDAO instance;
    private Venta e;
    
    public VentaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Conexion conexion = new Conexion();
        DataBaseHelper.setConexion(conexion);
        instance = new VentaDAO();
        List<Cliente> clientes = new ClienteDAO().buscarTodos();
        Cliente cliente = clientes.get(clientes.size()-1);
        List<Empleado> empleados = new EmpleadoDAO().buscarTodos();
        Empleado empleado = empleados.get(empleados.size()-1);
        e = new Venta(cliente, empleado, "now()");
        instance.persistir(e);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of persistir method, of class VentaDAO.
     */
    @Test
    public void testPersistir() {
        System.out.println("TEST VentaDAO persistir");
        boolean expResult = true;
        boolean result = instance.persistir(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizar method, of class VentaDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("TEST VentaDAO actualizar");
        boolean expResult = true;
        e.setFechaVenta("now()");
        boolean result = instance.actualizar(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminar method, of class VentaDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("TEST VentaDAO eliminar");
        boolean expResult = true;
        instance.persistir(e);
        VentaDAO ventaDAO = new VentaDAO();
        List<Venta> lista = ventaDAO.buscarTodos();
        Venta x = lista.get(lista.size()-1);
        boolean result = instance.eliminar(x);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarTodos method, of class VentaDAO.
     */
    @Test
    public void testBuscarTodos() {
        System.out.println("TEST VentaDAO buscarTodos");
        List<Venta> result = instance.buscarTodos();
        assertNotSame(0, result.size());
    }

    /**
     * Test of buscarPorId method, of class VentaDAO.
     */
    @Test
    public void testBuscarPorId() {
        System.out.println("TEST VentaDAO buscarPorId");
        VentaDAO ventaDAO = new VentaDAO();
        List<Venta> lista = ventaDAO.buscarTodos();
        Venta x = lista.get(lista.size()-1);
        Venta result = instance.buscarPorId(x.getIdVenta());
        assertNotNull(result);
    }
    
}
