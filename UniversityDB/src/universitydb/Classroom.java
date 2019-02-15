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
@Table(name = "classroom", catalog = "university", schema = "")
@NamedQueries({
    @NamedQuery(name = "Classroom.findAll", query = "SELECT c FROM Classroom c"),
    @NamedQuery(name = "Classroom.findByBuilding", query = "SELECT c FROM Classroom c WHERE c.classroomPK.building = :building"),
    @NamedQuery(name = "Classroom.findByRoomNumber", query = "SELECT c FROM Classroom c WHERE c.classroomPK.roomNumber = :roomNumber"),
    @NamedQuery(name = "Classroom.findByCapacity", query = "SELECT c FROM Classroom c WHERE c.capacity = :capacity")})
public class Classroom implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClassroomPK classroomPK;
    @Column(name = "capacity")
    private Short capacity;

    public Classroom() {
    }

    public Classroom(ClassroomPK classroomPK) {
        this.classroomPK = classroomPK;
    }

    public Classroom(String building, String roomNumber) {
        this.classroomPK = new ClassroomPK(building, roomNumber);
    }

    public ClassroomPK getClassroomPK() {
        return classroomPK;
    }

    public void setClassroomPK(ClassroomPK classroomPK) {
        this.classroomPK = classroomPK;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        Short oldCapacity = this.capacity;
        this.capacity = capacity;
        changeSupport.firePropertyChange("capacity", oldCapacity, capacity);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classroomPK != null ? classroomPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classroom)) {
            return false;
        }
        Classroom other = (Classroom) object;
        if ((this.classroomPK == null && other.classroomPK != null) || (this.classroomPK != null && !this.classroomPK.equals(other.classroomPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.Classroom[ classroomPK=" + classroomPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
