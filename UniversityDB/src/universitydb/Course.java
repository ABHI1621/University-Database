/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Joydeep
 */
@Entity
@Table(name = "course", catalog = "university", schema = "")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByTitle", query = "SELECT c FROM Course c WHERE c.title = :title"),
    @NamedQuery(name = "Course.findByDeptName", query = "SELECT c FROM Course c WHERE c.deptName = :deptName"),
    @NamedQuery(name = "Course.findByCredits", query = "SELECT c FROM Course c WHERE c.credits = :credits")})
public class Course implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_id")
    private String courseId;
    @Column(name = "title")
    private String title;
    @Column(name = "dept_name")
    private String deptName;
    @Column(name = "credits")
    private Short credits;

    public Course() {
    }

    public Course(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        String oldCourseId = this.courseId;
        this.courseId = courseId;
        changeSupport.firePropertyChange("courseId", oldCourseId, courseId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        String oldDeptName = this.deptName;
        this.deptName = deptName;
        changeSupport.firePropertyChange("deptName", oldDeptName, deptName);
    }

    public Short getCredits() {
        return credits;
    }

    public void setCredits(Short credits) {
        Short oldCredits = this.credits;
        this.credits = credits;
        changeSupport.firePropertyChange("credits", oldCredits, credits);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.Course[ courseId=" + courseId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
