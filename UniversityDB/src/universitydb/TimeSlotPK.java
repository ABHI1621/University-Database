/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Joydeep
 */
@Embeddable
public class TimeSlotPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "time_slot_id")
    private String timeSlotId;
    @Basic(optional = false)
    @Column(name = "day")
    private String day;
    @Basic(optional = false)
    @Column(name = "start_hr")
    private short startHr;
    @Basic(optional = false)
    @Column(name = "start_min")
    private short startMin;

    public TimeSlotPK() {
    }

    public TimeSlotPK(String timeSlotId, String day, short startHr, short startMin) {
        this.timeSlotId = timeSlotId;
        this.day = day;
        this.startHr = startHr;
        this.startMin = startMin;
    }

    public String getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(String timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public short getStartHr() {
        return startHr;
    }

    public void setStartHr(short startHr) {
        this.startHr = startHr;
    }

    public short getStartMin() {
        return startMin;
    }

    public void setStartMin(short startMin) {
        this.startMin = startMin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeSlotId != null ? timeSlotId.hashCode() : 0);
        hash += (day != null ? day.hashCode() : 0);
        hash += (int) startHr;
        hash += (int) startMin;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeSlotPK)) {
            return false;
        }
        TimeSlotPK other = (TimeSlotPK) object;
        if ((this.timeSlotId == null && other.timeSlotId != null) || (this.timeSlotId != null && !this.timeSlotId.equals(other.timeSlotId))) {
            return false;
        }
        if ((this.day == null && other.day != null) || (this.day != null && !this.day.equals(other.day))) {
            return false;
        }
        if (this.startHr != other.startHr) {
            return false;
        }
        if (this.startMin != other.startMin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.TimeSlotPK[ timeSlotId=" + timeSlotId + ", day=" + day + ", startHr=" + startHr + ", startMin=" + startMin + " ]";
    }
    
}
