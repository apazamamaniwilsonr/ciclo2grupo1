package pe.edu.upeu.encapsulamiento;

public class Estudiante {
    private String codigo;
    private String carrera;

    public Estudiante(){}

    public Estudiante(String carrera, String codigo) {
        this.carrera = carrera;
        this.codigo = codigo;
    }

    public void trabajo(){
        System.out.println("estudiar, investigar"+"en la carrera de: "+carrera);
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
