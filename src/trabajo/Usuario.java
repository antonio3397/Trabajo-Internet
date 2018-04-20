/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private String contrasenia;
    private String NIF;
    private String email;
    private String nombre;
    private String apellidos;
    private String sexo;
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    private Integer codigo_postal;
    private String direccion;
    private String provincia;
    private String Localidad;
    @Temporal(TemporalType.DATE)
    private Date fecha_ingreso;
    @Temporal(TemporalType.DATE)
    private Date fecha_baja;
    private Integer telefono;
    private Integer movil;
    private String responsable_legal;
    private String metodo_pago;
    private Integer cuota_total;
    @OneToMany (mappedBy = "usuario")
    @JoinColumn(nullable = true)
    List<Documento> documentos;
    @OneToMany (mappedBy = "usuario")
    @JoinColumn (nullable = true)
    List<Comentario> comentarios;
    

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
