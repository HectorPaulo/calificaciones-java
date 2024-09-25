import java.io.*;
import java.util.Scanner;

class Estudiante implements Serializable {
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

public class ControlCalificacionesTexto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del estudiante:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido Paterno: ");
        String apellidoPaterno = scanner.nextLine();
        System.out.print("Apellido Materno: ");
        String apellidoMaterno = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Calificación en Español: ");
        double español = Double.parseDouble(scanner.nextLine());
        System.out.print("Calificación en Matemáticas: ");
        double matematicas = Double.parseDouble(scanner.nextLine());
        System.out.print("Calificación en Computación: ");
        double computacion = Double.parseDouble(scanner.nextLine());
        System.out.print("Calificación en Física: ");
        double fisica = Double.parseDouble(scanner.nextLine());
        System.out.print("Calificación en Química: ");
        double quimica = Double.parseDouble(scanner.nextLine());
        System.out.print("Asistencias en Español: ");
        int asistenciasEspañol = Integer.parseInt(scanner.nextLine());
        System.out.print("Asistencias en Matemáticas: ");
        int asistenciasMatematicas = Integer.parseInt(scanner.nextLine());
        System.out.print("Asistencias en Computación: ");
        int asistenciasComputacion = Integer.parseInt(scanner.nextLine());
        System.out.print("Asistencias en Física: ");
        int asistenciasFisica = Integer.parseInt(scanner.nextLine());
        System.out.print("Asistencias en Química: ");
        int asistenciasQuimica = Integer.parseInt(scanner.nextLine());

        Estudiante estudiante = new Estudiante(nombre, apellidoPaterno, apellidoMaterno, edad, matricula,
                español, matematicas, computacion, fisica, quimica,
                asistenciasEspañol, asistenciasMatematicas, asistenciasComputacion,
                asistenciasFisica, asistenciasQuimica);

        try {
            FileOutputStream fileOut = new FileOutputStream("estudiante.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(estudiante);
            out.close();
            fileOut.close();

            System.out.println("Información guardada exitosamente.");

            generarBoleta();

        } catch (IOException ex) {
            System.err.println("Error al guardar la información: " + ex.getMessage());
        }
    }

    private static void generarBoleta() {
        try {
            FileInputStream fileIn = new FileInputStream("estudiante.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Estudiante estudiante = (Estudiante) in.readObject();
            in.close();
            fileIn.close();

            FileWriter writer = new FileWriter("boleta.txt");

            writer.write("Matrícula: " + estudiante.getMatricula() + "\n");
            writer.write("Nombre: " + estudiante.getNombreCompleto() + "\n");
            writer.write("Edad: " + estudiante.getEdad() + "\n");
            writer.write("Español: " + estudiante.getCalificacionEspañol() + " - Estatus: " + estudiante.getEstatusEspañol() + "\n");
            writer.write("Matemáticas: " + estudiante.getCalificacionMatematicas() + " - Estatus: " + estudiante.getEstatusMatematicas() + "\n");
            writer.write("Computación: " + estudiante.getCalificacionComputacion() + " - Estatus: " + estudiante.getEstatusComputacion() + "\n");
            writer.write("Física: " + estudiante.getCalificacionFisica() + " - Estatus: " + estudiante.getEstatusFisica() + "\n");
            writer.write("Química: " + estudiante.getCalificacionQuimica() + " - Estatus: " + estudiante.getEstatusQuimica() + "\n");
            writer.write("Promedio: " + estudiante.getPromedio() + " - Estatus: " + estudiante.getEstatusGeneral() + "\n");

            writer.close();

            System.out.println("Boleta generada exitosamente.");

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error al generar la boleta: " + ex.getMessage());
        }
    }
}
