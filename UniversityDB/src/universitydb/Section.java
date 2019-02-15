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
@Table(name = "section", catalog = "university", schema = "")
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.findByCourseId", query = "SELECT s FROM Section s WHERE s.sectionPK.courseId = :courseId"),
    @NamedQuery(name = "Section.findBySecId", query = "SELECT s FROM Section s WHERE s.sectionPK.secId = :secId"),
    @NamedQuery(name = "Section.findBySemester", query = "SELECT s FROM Section s WHERE s.sectionPK.semester = :semester"),
    @NamedQuery(name = "Section.findByYear", query = "SELECT s FROM Section s WHERE s.sectionPK.year = :year"),
    @NamedQuery(name = "Section.findByBuilding", query = "SELECT s FROM Section s WHERE s.building = :building"),
    @NamedQuery(name = "Section.findByRoomNumber", query = "SELECT s FROM Section s WHERE s.roomNumber = :roomNumber"),
    @NamedQuery(name = "Section.findByTimeSlotId", query = "SELECT s FROM Section s WHERE s.timeSlotId = :timeSlotId")})
public class Section implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SectionPK sectionPK;
    @Column(name = "building")
    private String building;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "time_slot_id")
    private String timeSlotId;

    public Section() {
    }

    public Section(SectionPK sectionPK) {
        this.sectionPK = sectionPK;
    }

    public Section(String courseId, String secId, String semester, short year) {
        this.sectionPK = new SectionPK(courseId, secId, semester, year);
    }

    public SectionPK getSectionPK() {
        return sectionPK;
    }

    public void setSectionPK(SectionPK sectionPK) {
        this.sectionPK = sectionPK;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        String oldBuilding = this.building;
        this.building = building;
        changeSupport.firePropertyChange("building", oldBuilding, building);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        String oldRoomNumber = this.roomNumber;
        this.roomNumber = roomNumber;
        changeSupport.firePropertyChange("roomNumber", oldRoomNumber, roomNumber);
    }

    public String getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(String timeSlotId) {
        String oldTimeSlotId = this.timeSlotId;
        this.timeSlotId = timeSlotId;
        changeSupport.firePropertyChange("timeSlotId", oldTimeSlotId, timeSlotId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionPK != null ? sectionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.sectionPK == null && other.sectionPK != null) || (this.sectionPK != null && !this.sectionPK.equals(other.sectionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.Section[ sectionPK=" + sectionPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
