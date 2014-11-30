package modelos.bo;

public class Conexion {
    
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://";
    private String host = "localhost";
    private String port = "5432";
    private String dataBase = "conexion";
    private String user = "postgres";
    private String password = "1";

    public Conexion(String host, String port, String dataBase, String user, String password) {
        this.host = host;
        this.port = port;
        this.dataBase = dataBase;
        this.user = user;
        this.password = password;
    }
    
    public Conexion(){}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBaseDatos() {
        return dataBase;
    }

    public void setBaseDatos(String baseDatos) {
        this.dataBase = baseDatos;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return port;
    }

    public void setPuerto(String puerto) {
        this.port = puerto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}