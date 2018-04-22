/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo;

import java.io.Serializable;
import javax.persistence.Embeddable;
/**
 *
 * @author anton
 */
@Embeddable
public class InscripcionID implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long usuario_id;
    private Long evento_id;

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
        if (!(object instanceof InscripcionID)) {
            return false;
        }
        InscripcionID other = (InscripcionID) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajo.InscripcionID[ id=" + id + " ]";
    }

    /**
     * @return the usuario_id
     */
    public Long getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * @return the evento_id
     */
    public Long getEvento_id() {
        return evento_id;
    }

    /**
     * @param evento_id the evento_id to set
     */
    public void setEvento_id(Long evento_id) {
        this.evento_id = evento_id;
    }
    
}
