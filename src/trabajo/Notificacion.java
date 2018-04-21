/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import static trabajo.Documento_.id;

/**
 *
 * @author franc
 */
@Embeddable
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Usuario usuario;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Evento evento;
    @Column(nullable=false)
    private String titulo;
    private String Texto;
    
    
    
    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Notificacion other = (Notificacion) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "trabajo.Notificacion[ id=" + id + " ]";
    }
    
}
