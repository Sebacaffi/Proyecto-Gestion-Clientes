
package modelo;

/**
 * @author G. Gaggero - F. Beltrami - S. Caffi - A. Maltrain
 * @version 10/12/2020
 */
public class Cliente {
    
    private String rut;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String genero;
    private int telefono;
    private String email;
    private String direccion;
    
    private String comuna;
    private String estadoCivil;
    
    public Cliente() {
    }

    public Cliente(String rut, String nombre, String apaterno, String amaterno, String genero, int telefono, String email, String direccion, String estadoCivil, String comuna) {
        this.rut = rut;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.genero = genero;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.comuna = comuna;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public String getGenero() {
        return genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getComuna() {
        return comuna;
    }
}
