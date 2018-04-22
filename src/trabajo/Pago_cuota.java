/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author anton
 */
@Entity
public class Pago_cuota implements Serializable {

    /**
     * @return the usuarios
     */
    public Usuario getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer cantidad_pagada;
    
    @ManyToOne
    private Usuario usuarios;

    public void setCantidad_pagada(Integer cantidad_pagada) {
        this.cantidad_pagada = cantidad_pagada;
    }

    public Integer getCantidad_pagada() {
        return cantidad_pagada;
    }

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
        if (!(object instanceof Pago_cuota)) {
            return false;
        }
        Pago_cuota other = (Pago_cuota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajo.Pago_cuota[ id=" + id + " ]";
    }
    
}
