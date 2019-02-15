/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "department", catalog = "university", schema = "")
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDeptName", query = "SELECT d FROM Department d WHERE d.deptName = :deptName"),
    @NamedQuery(name = "Department.findByBuilding", query = "SELECT d FROM Department d WHERE d.building = :building"),
    @NamedQuery(name = "Department.findByBudget", query = "SELECT d FROM Department d WHERE d.budget = :budget")})
public class Department implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dept_name")
    private String deptName;
    @Column(name = "building")
    private String building;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "budget")
    private BigDecimal budget;

    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        String oldDeptName = this.deptName;
        this.deptName = deptName;
        changeSupport.firePropertyChange("deptName", oldDeptName, deptName);
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        String oldBuilding = this.building;
        this.building = building;
        changeSupport.firePropertyChange("building", oldBuilding, building);
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        BigDecimal oldBudget = this.budget;
        this.budget = budget;
        changeSupport.firePropertyChange("budget", oldBudget, budget);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptName != null ? deptName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.deptName == null && other.deptName != null) || (this.deptName != null && !this.deptName.equals(other.deptName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.Department[ deptName=" + deptName + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
