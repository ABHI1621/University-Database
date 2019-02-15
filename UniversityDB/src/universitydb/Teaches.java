/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Joydeep
 */
@Entity
@Table(name = "teaches", catalog = "university", schema = "")
@NamedQueries({
    @NamedQuery(name = "Teaches.findAll", query = "SELECT t FROM Teaches t"),
    @NamedQuery(name = "Teaches.findById", query = "SELECT t FROM Teaches t WHERE t.teachesPK.id = :id"),
    @NamedQuery(name = "Teaches.findByCourseId", query = "SELECT t FROM Teaches t WHERE t.teachesPK.courseId = :courseId"),
    @NamedQuery(name = "Teaches.findBySecId", query = "SELECT t FROM Teaches t WHERE t.teachesPK.secId = :secId"),
    @NamedQuery(name = "Teaches.findBySemester", query = "SELECT t FROM Teaches t WHERE t.teachesPK.semester = :semester"),
    @NamedQuery(name = "Teaches.findByYear", query = "SELECT t FROM Teaches t WHERE t.teachesPK.year = :year")})
public class Teaches implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TeachesPK teachesPK;

    public Teaches() {
    }

    public Teaches(TeachesPK teachesPK) {
        this.teachesPK = teachesPK;
    }

    public Teaches(String id, String courseId, String secId, String semester, short year) {
        this.teachesPK = new TeachesPK(id, courseId, secId, semester, year);
    }

    public TeachesPK getTeachesPK() {
        return teachesPK;
    }

    public void setTeachesPK(TeachesPK teachesPK) {
        this.teachesPK = teachesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teachesPK != null ? teachesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teaches)) {
            return false;
        }
        Teaches other = (Teaches) object;
        if ((this.teachesPK == null && other.teachesPK != null) || (this.teachesPK != null && !this.teachesPK.equals(other.teachesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.Teaches[ teachesPK=" + teachesPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
