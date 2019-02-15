/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "takes", catalog = "university", schema = "")
@NamedQueries({
    @NamedQuery(name = "Takes.findAll", query = "SELECT t FROM Takes t"),
    @NamedQuery(name = "Takes.findById", query = "SELECT t FROM Takes t WHERE t.takesPK.id = :id"),
    @NamedQuery(name = "Takes.findByCourseId", query = "SELECT t FROM Takes t WHERE t.takesPK.courseId = :courseId"),
    @NamedQuery(name = "Takes.findBySecId", query = "SELECT t FROM Takes t WHERE t.takesPK.secId = :secId"),
    @NamedQuery(name = "Takes.findBySemester", query = "SELECT t FROM Takes t WHERE t.takesPK.semester = :semester"),
    @NamedQuery(name = "Takes.findByYear", query = "SELECT t FROM Takes t WHERE t.takesPK.year = :year"),
    @NamedQuery(name = "Takes.findByGrade", query = "SELECT t FROM Takes t WHERE t.grade = :grade")})
public class Takes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TakesPK takesPK;
    @Column(name = "grade")
    private String grade;

    public Takes() {
    }

    public Takes(TakesPK takesPK) {
        this.takesPK = takesPK;
    }

    public Takes(String id, String courseId, String secId, String semester, short year) {
        this.takesPK = new TakesPK(id, courseId, secId, semester, year);
    }

    public TakesPK getTakesPK() {
        return takesPK;
    }

    public void setTakesPK(TakesPK takesPK) {
        this.takesPK = takesPK;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        String oldGrade = this.grade;
        this.grade = grade;
        changeSupport.firePropertyChange("grade", oldGrade, grade);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (takesPK != null ? takesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Takes)) {
            return false;
        }
        Takes other = (Takes) object;
        if ((this.takesPK == null && other.takesPK != null) || (this.takesPK != null && !this.takesPK.equals(other.takesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.Takes[ takesPK=" + takesPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
