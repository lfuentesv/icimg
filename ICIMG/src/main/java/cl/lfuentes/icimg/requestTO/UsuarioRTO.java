package cl.lfuentes.icimg.requestTO;

import cl.lfuentes.icimg.entityTo.Perfil;

public class UsuarioRTO {

    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private String fono;
    private String cargo;
    private String empresa;
    private Perfil perfil;
    private String password;

    public UsuarioRTO() {
    }

    public UsuarioRTO(String rut, String nombre, String apellido, String email, String fono, String cargo, String empresa, Perfil perfil, String password) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fono = fono;
        this.cargo = cargo;
        this.empresa = empresa;
        this.perfil = perfil;
        this.password = password;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
