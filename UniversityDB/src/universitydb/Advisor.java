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
@Table(name = "advisor", catalog = "university", schema = "")
@NamedQueries({
    @NamedQuery(name = "Advisor.findAll", query = "SELECT a FROM Advisor a"),
    @NamedQuery(name = "Advisor.findBySID", query = "SELECT a FROM Advisor a WHERE a.sID = :sID"),
    @NamedQuery(name = "Advisor.findByIID", query = "SELECT a FROM Advisor a WHERE a.iID = :iID")})
public class Advisor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "s_ID")
    private String sID;
    @Column(name = "i_ID")
    private String iID;

    public Advisor() {
    }

    public Advisor(String sID) {
        this.sID = sID;
    }

    public String getSID() {
        return sID;
    }

    public void setSID(String sID) {
        String oldSID = this.sID;
        this.sID = sID;
        changeSupport.firePropertyChange("SID", oldSID, sID);
    }

    public String getIID() {
        return iID;
    }

    public void setIID(String iID) {
        String oldIID = this.iID;
        this.iID = iID;
        changeSupport.firePropertyChange("IID", oldIID, iID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sID != null ? sID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advisor)) {
            return false;
        }
        Advisor other = (Advisor) object;
        if ((this.sID == null && other.sID != null) || (this.sID != null && !this.sID.equals(other.sID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "universitydb.Advisor[ sID=" + sID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
