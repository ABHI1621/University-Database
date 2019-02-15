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
public class SectionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "course_id")
    private String courseId;
    @Basic(optional = false)
    @Column(name = "sec_id")
    private String secId;
    @Basic(optional = false)
    @Column(name = "semester")
    private String semester;
    @Basic(optional = false)
    @Column(name = "year")
    private short year;

    public SectionPK() {
    }

    public SectionPK(String courseId, String secId, String semester, short year) {
        this.courseId = courseId;
        this.secId = secId;
        this.semester = semester;
        this.year = year;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        hash += (secId != null ? secId.hashCode() : 0);
        hash += (semester != null ? semester.hashCode() : 0);
        hash += (int) year;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectionPK)) {
            return false;
        }
        SectionPK other = (SectionPK) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        if ((this.secId == null && other.secId != null) || (this.secId != null && !this.secId.equals(other.secId))) {
            return false;
        }
        if ((this.semester == null && other.semester != null) || (this.semester != null && !this.semester.equals(other.semester))) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.SectionPK[ courseId=" + courseId + ", secId=" + secId + ", semester=" + semester + ", year=" + year + " ]";
    }
    
}
