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
@Table(name = "time_slot", catalog = "university", schema = "")
@NamedQueries({
    @NamedQuery(name = "TimeSlot.findAll", query = "SELECT t FROM TimeSlot t"),
    @NamedQuery(name = "TimeSlot.findByTimeSlotId", query = "SELECT t FROM TimeSlot t WHERE t.timeSlotPK.timeSlotId = :timeSlotId"),
    @NamedQuery(name = "TimeSlot.findByDay", query = "SELECT t FROM TimeSlot t WHERE t.timeSlotPK.day = :day"),
    @NamedQuery(name = "TimeSlot.findByStartHr", query = "SELECT t FROM TimeSlot t WHERE t.timeSlotPK.startHr = :startHr"),
    @NamedQuery(name = "TimeSlot.findByStartMin", query = "SELECT t FROM TimeSlot t WHERE t.timeSlotPK.startMin = :startMin"),
    @NamedQuery(name = "TimeSlot.findByEndHr", query = "SELECT t FROM TimeSlot t WHERE t.endHr = :endHr"),
    @NamedQuery(name = "TimeSlot.findByEndMin", query = "SELECT t FROM TimeSlot t WHERE t.endMin = :endMin")})
public class TimeSlot implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimeSlotPK timeSlotPK;
    @Column(name = "end_hr")
    private Short endHr;
    @Column(name = "end_min")
    private Short endMin;

    public TimeSlot() {
    }

    public TimeSlot(TimeSlotPK timeSlotPK) {
        this.timeSlotPK = timeSlotPK;
    }

    public TimeSlot(String timeSlotId, String day, short startHr, short startMin) {
        this.timeSlotPK = new TimeSlotPK(timeSlotId, day, startHr, startMin);
    }

    public TimeSlotPK getTimeSlotPK() {
        return timeSlotPK;
    }

    public void setTimeSlotPK(TimeSlotPK timeSlotPK) {
        this.timeSlotPK = timeSlotPK;
    }

    public Short getEndHr() {
        return endHr;
    }

    public void setEndHr(Short endHr) {
        Short oldEndHr = this.endHr;
        this.endHr = endHr;
        changeSupport.firePropertyChange("endHr", oldEndHr, endHr);
    }

    public Short getEndMin() {
        return endMin;
    }

    public void setEndMin(Short endMin) {
        Short oldEndMin = this.endMin;
        this.endMin = endMin;
        changeSupport.firePropertyChange("endMin", oldEndMin, endMin);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeSlotPK != null ? timeSlotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeSlot)) {
            return false;
        }
        TimeSlot other = (TimeSlot) object;
        if ((this.timeSlotPK == null && other.timeSlotPK != null) || (this.timeSlotPK != null && !this.timeSlotPK.equals(other.timeSlotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.TimeSlot[ timeSlotPK=" + timeSlotPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
