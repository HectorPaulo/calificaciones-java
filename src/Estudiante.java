import java.io.Serializable;

public class Estudiante implements Serializable {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String matricula;
    private double español;
    private double matematicas;
    private double computacion;
    private double fisica;
    private double quimica;
    private int asistenciasEspañol;
    private int asistenciasMatematicas;
    private int asistenciasComputacion;
    private int asistenciasFisica;
    private int asistenciasQuimica;

    public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String matricula,
                      double español, double matematicas, double computacion, double fisica, double quimica,
                      int asistenciasEspañol, int asistenciasMatematicas, int asistenciasComputacion,
                      int asistenciasFisica, int asistenciasQuimica) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.matricula = matricula;
        this.español = español;
        this.matematicas = matematicas;
        this.computacion = computacion;
        this.fisica = fisica;
        this.quimica = quimica;
        this.asistenciasEspañol = asistenciasEspañol;
        this.asistenciasMatematicas = asistenciasMatematicas;
        this.asistenciasComputacion = asistenciasComputacion;
        this.asistenciasFisica = asistenciasFisica;
        this.asistenciasQuimica = asistenciasQuimica;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getCalificacionEspañol() {
        return español;
    }

    public String getEstatusEspañol() {
        return (asistenciasEspañol >= 3 && español > 5) ? "Aprobado" : "Reprobado";
    }

    public double getCalificacionMatematicas() {
        return matematicas;
    }

    public String getEstatusMatematicas() {
        return (asistenciasMatematicas >= 3 && matematicas > 5) ? "Aprobado" : "Reprobado";
    }

    public double getCalificacionComputacion() {
        return computacion;
    }

    public String getEstatusComputacion() {
        return (asistenciasComputacion >= 3 && computacion > 5) ? "Aprobado" : "Reprobado";
    }

    public double getCalificacionFisica() {
        return fisica;
    }

    public String getEstatusFisica() {
        return (asistenciasFisica >= 3 && fisica > 5) ? "Aprobado" : "Reprobado";
    }

    public double getCalificacionQuimica() {
        return quimica;
    }

    public String getEstatusQuimica() {
        return (asistenciasQuimica >= 3 && quimica > 5) ? "Aprobado" : "Reprobado";
    }

    public double getPromedio() {
        return (español + matematicas + computacion + fisica + quimica) / 5;
    }

    public String getEstatusGeneral() {
        return (getEstatusEspañol().equals("Aprobado") && getEstatusMatematicas().equals("Aprobado") &&
                getEstatusComputacion().equals("Aprobado") && getEstatusFisica().equals("Aprobado") &&
                getEstatusQuimica().equals("Aprobado")) ? "Aprobado" : "Reprobado";
    }
}
