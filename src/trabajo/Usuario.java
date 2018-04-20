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

    private static final long serialVersionUID = 1L;
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
    
    @OneToMany(mappedBy = "Usuario")
    private List<Inscripcion> inscripciones;
    
    @ManyToOne
    private Perfil perfiles;
    
    @OneToMany (mappedBy="perfiles")
    private List<Pago_cuota> pago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajo.Usuario[ id=" + id + " ]";
    }
    
}
