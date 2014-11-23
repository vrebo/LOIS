package silordordo.dao;

import org.losi.dao.PeliculaDAO;
import org.losi.dao.GeneroDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.losi.bo.Conexion;
import org.losi.bo.Genero;
import org.losi.bo.Pelicula;
import org.losi.dao.DataBaseHelper;

public class PeliculaDAOTest {
    
    private PeliculaDAO instance;
    private Genero g;
    private Pelicula e;
    public PeliculaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DataBaseHelper.setConexion(new Conexion());
        instance = new PeliculaDAO();
        g = new GeneroDAO().buscarPorId(1L);
        e = new Pelicula(g, "imagen", "Morgan Freman", "El caballero de la noche", "now()", "Morgan Freman", "A", "02:30");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of persistir method, of class PeliculaDAO.
     */
    @Test
    public void testPersistir() {
        System.out.println("TEST PeliculaDAO persistir");
        boolean expResult = true;
        boolean result = instance.persistir(e);
        assertEquals(expResult, result);
        instance.eliminar(e);
    }

    /**
     * Test of actualizar method, of class PeliculaDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("TEST PeliculaDAO actualizar");
        instance.persistir(e);
        e.setDirector("Michael Bay");
        boolean expResult = true;
        boolean result = instance.actualizar(e);
        assertEquals(expResult, result);
        instance.eliminar(e);
    }

    /**
     * Test of eliminar method, of class PeliculaDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("TEST PeliculaDAO eliminar");
        boolean expResult = true;
        instance.persistir(e);
        boolean result = instance.eliminar(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarTodos method, of class PeliculaDAO.
     */
    @Test
    public void testBuscarTodos() {
        System.out.println("TEST PeliculaDAO buscarTodos");
        instance.persistir(e);
        List<Pelicula> result = instance.buscarTodos();
        assertNotSame(0, result.size());
    }

    /**
     * Test of buscarPorId method, of class PeliculaDAO.
     */
    @Test
    public void testBuscarPorId() {
        System.out.println("TEST PeliculaDAO buscarPorId");
        long id = 1L;
        Pelicula result = instance.buscarPorId(id);
        assertEquals(id,result.getIdPelicula());
    }
    
}
