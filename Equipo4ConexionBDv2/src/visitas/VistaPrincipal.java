package visitas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.beans.EventHandler;
import java.util.EventListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelos.bo.Conexion;

public final class VistaPrincipal extends VistaPlantilla {

    public final String EQT_BASE_DATOS = "Nombre de la BD: ";
    private final String EQT_USUARIO = "Usuario: ";
    private final String EQT_PASSWORD = "Password: ";
    private final String EQT_HOST = "Nombre Host:";
    private final String EQT_PUERTO = "Puerto:";
    private final String EQT_CONEXION_REMOTA = "Conexion Remota";
    public static final String EQT_BTN_CREAR = "Crear Conexión";
    public static final String EQT_BTN_PROBAR = "Probar Conexión";
    public static final String EQT_BTN_DEFAULT = "Conexión por Defecto";
    public static final String EQT_TITULO = "Nueva Conexión";
    private JTextField jtfConexion;
    private JTextField jtfHost;
    private JTextField jtfPuerto;
    private JTextField jtfUsuario;
    private JPasswordField jpfPassword;
    private JCheckBox jcbOpcionRemota;
    private JButton jbCrearConexion;
    private JButton jbProbarConexion;
    private JButton jbConexionPorDefecto;

    public VistaPrincipal() {
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new GridBagLayout());
        addComponentes();
    }

    @Override
    protected final void addComponentes() {
        jcbOpcionRemota = new JCheckBox(EQT_CONEXION_REMOTA);
        jcbOpcionRemota.setSelected(false);
        jtfHost = new JTextField(13);
        jtfHost.setEnabled(false);
        jtfPuerto = new JTextField(5);
        jtfPuerto.setEnabled(false);
        jtfConexion = new JTextField(30);
        jtfUsuario = new JTextField(30);
        jpfPassword = new JPasswordField(30);
        jbCrearConexion = new JButton(EQT_BTN_CREAR);
        jbProbarConexion = new JButton(EQT_BTN_PROBAR);
        jbConexionPorDefecto = new JButton(EQT_BTN_DEFAULT);

        setGBC(0, 0, GridBagConstraints.FIRST_LINE_END, new Insets(5, 5, 5, 5));
        add(new JLabel(EQT_BASE_DATOS), gbc);
        setGBC(1, 0);
        add(jtfConexion, gbc);

        JPanel panelInterno = new JPanel(new GridBagLayout());
        panelInterno.setBorder(BorderFactory.createEtchedBorder());
        setGBCSize(2, 1);
        setGBC(0, 1, GridBagConstraints.FIRST_LINE_END);
        add(panelInterno, gbc);
        setGBC(0, 0);
        setGBCSize(1, 1);
        panelInterno.add(jcbOpcionRemota, gbc);
        setGBC(0, 2);
        panelInterno.add(new JLabel(EQT_HOST), gbc);
        setGBC(1, 2);
        panelInterno.add(jtfHost, gbc);
        setGBC(2, 2);
        panelInterno.add(new JLabel(EQT_PUERTO), gbc);
        setGBC(3, 2);
        panelInterno.add(jtfPuerto, gbc);

        setGBCSize(1, 1);
        setGBC(0, 2);
        add(new JLabel(EQT_USUARIO), gbc);
        setGBC(1, 2);
        add(jtfUsuario, gbc);
        setGBC(0, 3);
        add(new JLabel(EQT_PASSWORD), gbc);
        setGBC(1, 3);
        add(jpfPassword, gbc);

        panelInterno = new JPanel(new GridLayout(1, 3, 10, 10));
        panelInterno.add(jbCrearConexion);
        panelInterno.add(jbProbarConexion);
        panelInterno.add(jbConexionPorDefecto);
        setGBC(0, 4, GridBagConstraints.CENTER);
        setGBCSize(2, 1);
        add(panelInterno, gbc);
    }

    @Override
    public void addEventos(EventListener controlador) {
        
        jbCrearConexion.addActionListener((ActionListener) controlador);
        jbProbarConexion.addActionListener((ActionListener) controlador);
        jbConexionPorDefecto.addActionListener((ActionListener) controlador);
        jcbOpcionRemota.addItemListener((ItemListener)controlador);
    }
    
    public final Conexion getConexion() {
        String user = jtfUsuario.getText();
        String dataBase = jtfConexion.getText();
        String password = "";
        for (int i = 0; i < jpfPassword.getPassword().length; i++) {
            password += jpfPassword.getPassword()[i];
        }
        String host = jtfHost.getText();
        String port = jtfPuerto.getText();
        
        return new Conexion(host, port, dataBase, user, password);
    }

    public JTextField getJtfConexion() {
        return jtfConexion;
    }

    public void setJtfConexion(JTextField jtfConexion) {
        this.jtfConexion = jtfConexion;
    }

    public JTextField getJtfHost() {
        return jtfHost;
    }

    public void setJtfHost(JTextField jtfHost) {
        this.jtfHost = jtfHost;
    }

    public JTextField getJtfPuerto() {
        return jtfPuerto;
    }

    public void setJtfPuerto(JTextField jtfPuerto) {
        this.jtfPuerto = jtfPuerto;
    }

    public JTextField getJtfUsuario() {
        return jtfUsuario;
    }

    public void setJtfUsuario(JTextField jtfUsuario) {
        this.jtfUsuario = jtfUsuario;
    }

    public JPasswordField getJpfPassword() {
        return jpfPassword;
    }

    public void setJpfPassword(JPasswordField jpfPassword) {
        this.jpfPassword = jpfPassword;
    }

    public JCheckBox getJcbOpcionRemota() {
        return jcbOpcionRemota;
    }

    public void setJcbOpcionRemota(JCheckBox jcbOpcionRemota) {
        this.jcbOpcionRemota = jcbOpcionRemota;
    }

    public JButton getJbCrearConexion() {
        return jbCrearConexion;
    }

    public void setJbCrearConexion(JButton jbCrearConexion) {
        this.jbCrearConexion = jbCrearConexion;
    }

    public JButton getJbProbarConexion() {
        return jbProbarConexion;
    }

    public void setJbProbarConexion(JButton jbProbarConexion) {
        this.jbProbarConexion = jbProbarConexion;
    }

    public JButton getJbConexionPorDefecto() {
        return jbConexionPorDefecto;
    }

    public void setJbConexionPorDefecto(JButton jbConexionPorDefecto) {
        this.jbConexionPorDefecto = jbConexionPorDefecto;
    }
}