/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author anton
 */
@Entity
public class Usuario implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String contrasenia;
    @Column(nullable=false)
    private String NIF;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellidos;
    @Column(nullable=false)
    private String sexo;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date fecha_nacimiento;
    @Column(nullable=false)
    private Integer codigo_postal;
    @Column(nullable=false)
    private String direccion;
    @Column(nullable=false)
    private String provincia;
    @Column(nullable=false)
    private String Localidad;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date fecha_ingreso;
    @Temporal(TemporalType.DATE)
    private Date fecha_baja;
    @Column(nullable=false)
    private Integer cuota_total;
    private Integer telefono;
    private Integer movil;
    private String responsable_legal;
    private String metodo_pago;
  
    @OneToMany (mappedBy = "usuario")
    @JoinColumn(nullable = true)
    private List<Documento> documentos;
    
    @OneToMany (mappedBy = "usuario")
    @JoinColumn (nullable = true)
    private List<Comentario> comentarios;
    
    @OneToMany(mappedBy = "usuario")
    @JoinColumn(nullable=true)
    private List<Inscripcion> inscripciones;
    
    @ManyToOne
    private Perfil perfiles;
    
    @OneToMany (mappedBy="usuarios")
    private List<Pago_cuota> pago;
    
    @ManyToOne
    private Seccion seccion;
    
    @OneToMany(mappedBy="usuario")
    private List<Evento> eventos;
    
    @OneToMany(mappedBy="usuario")
    @JoinColumn(nullable=true)
    private List<Notificacion> notificaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajo.Usuario[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * @param NIF the NIF to set
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the fecha_nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the codigo_postal
     */
    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * @param codigo_postal the codigo_postal to set
     */
    public void setCodigo_postal(Integer codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the Localidad
     */
    public String getLocalidad() {
        return Localidad;
    }

    /**
     * @param Localidad the Localidad to set
     */
    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    /**
     * @return the fecha_ingreso
     */
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * @return the fecha_baja
     */
    public Date getFecha_baja() {
        return fecha_baja;
    }

    /**
     * @param fecha_baja the fecha_baja to set
     */
    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    /**
     * @return the cuota_total
     */
    public Integer getCuota_total() {
        return cuota_total;
    }

    /**
     * @param cuota_total the cuota_total to set
     */
    public void setCuota_total(Integer cuota_total) {
        this.cuota_total = cuota_total;
    }

    /**
     * @return the telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the movil
     */
    public Integer getMovil() {
        return movil;
    }

    /**
     * @param movil the movil to set
     */
    public void setMovil(Integer movil) {
        this.movil = movil;
    }

    /**
     * @return the responsable_legal
     */
    public String getResponsable_legal() {
        return responsable_legal;
    }

    /**
     * @param responsable_legal the responsable_legal to set
     */
    public void setResponsable_legal(String responsable_legal) {
        this.responsable_legal = responsable_legal;
    }

    /**
     * @return the metodo_pago
     */
    public String getMetodo_pago() {
        return metodo_pago;
    }

    /**
     * @param metodo_pago the metodo_pago to set
     */
    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    /**
     * @return the documentos
     */
    public List<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    /**
     * @return the comentarios
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the inscripciones
     */
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    /**
     * @param inscripciones the inscripciones to set
     */
    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    /**
     * @return the perfiles
     */
    public Perfil getPerfiles() {
        return perfiles;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setPerfiles(Perfil perfiles) {
        this.perfiles = perfiles;
    }

    /**
     * @return the pago
     */
    public List<Pago_cuota> getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(List<Pago_cuota> pago) {
        this.pago = pago;
    }

    /**
     * @return the seccion
     */
    public Seccion getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the eventos
     */
    public List<Evento> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    /**
     * @return the notificaciones
     */
    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    /**
     * @param notificaciones the notificaciones to set
     */
    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
    
}
