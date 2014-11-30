package modelos.bo;

public class Alumno {

    private long idAlumno;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String sexo;
    private int edad;

    public Alumno(long idAlumno, String nombre, String apPaterno, String apMaterno, String sexo, int edad) {
        this(nombre,apPaterno,apMaterno,sexo, edad);
        this.idAlumno = idAlumno;
    }
    
    public Alumno(String nombre, String apPaterno, String apMaterno, String sexo, int edad) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.sexo = sexo;
        this.edad = edad;
    }

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
