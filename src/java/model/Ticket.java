/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Rogelio Oseguera
 */
@Entity
@Table(name = "ticket")
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByNoTicket", query = "SELECT t FROM Ticket t WHERE t.noTicket = :noTicket")
    , @NamedQuery(name = "Ticket.findByFecha", query = "SELECT t FROM Ticket t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Ticket.findByArea", query = "SELECT t FROM Ticket t WHERE t.area = :area")
    , @NamedQuery(name = "Ticket.findByAsunto", query = "SELECT t FROM Ticket t WHERE t.asunto = :asunto")
    , @NamedQuery(name = "Ticket.findByProblematica", query = "SELECT t FROM Ticket t WHERE t.problematica = :problematica")
    , @NamedQuery(name = "Ticket.findByEstado", query = "SELECT t FROM Ticket t WHERE t.estado = :estado")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "No_Ticket", nullable = false)
    private Integer noTicket;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 20)
    @Column(name = "Area", length = 20)
    private String area;
    @Size(max = 70)
    @Column(name = "Asunto", length = 70)
    private String asunto;
    @Size(max = 400)
    @Column(name = "Problematica", length = 400)
    private String problematica;
    @Size(max = 25)
    @Column(name = "Estado", length = 25)
    private String estado;
    @JoinColumn(name = "Especialista", referencedColumnName = "No_Trabajador")
    @ManyToOne
    private Especialista especialista;
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "Id_Usuario")
    @ManyToOne
    private Usuario idUsuario;

    public Ticket() {
    }

    public Ticket(Integer noTicket) {
        this.noTicket = noTicket;
    }

    public Integer getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(Integer noTicket) {
        this.noTicket = noTicket;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getProblematica() {
        return problematica;
    }

    public void setProblematica(String problematica) {
        this.problematica = problematica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noTicket != null ? noTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.noTicket == null && other.noTicket != null) || (this.noTicket != null && !this.noTicket.equals(other.noTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ticket[ noTicket=" + noTicket + " ]";
    }
    
}
