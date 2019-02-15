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
public class ClassroomPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "building")
    private String building;
    @Basic(optional = false)
    @Column(name = "room_number")
    private String roomNumber;

    public ClassroomPK() {
    }

    public ClassroomPK(String building, String roomNumber) {
        this.building = building;
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (building != null ? building.hashCode() : 0);
        hash += (roomNumber != null ? roomNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassroomPK)) {
            return false;
        }
        ClassroomPK other = (ClassroomPK) object;
        if ((this.building == null && other.building != null) || (this.building != null && !this.building.equals(other.building))) {
            return false;
        }
        if ((this.roomNumber == null && other.roomNumber != null) || (this.roomNumber != null && !this.roomNumber.equals(other.roomNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.ClassroomPK[ building=" + building + ", roomNumber=" + roomNumber + " ]";
    }
    
}
