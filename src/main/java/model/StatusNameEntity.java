package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "status_name", schema = "public", catalog = "postgres")
public class StatusNameEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "status_name_id", nullable = false)
    private int statusNameId;
    @Basic
    @Column(name = "status_name", nullable = false, length = 450)
    private String statusName;

    public int getStatusNameId() {
        return statusNameId;
    }

    public void setStatusNameId(int statusNameId) {
        this.statusNameId = statusNameId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusNameEntity that = (StatusNameEntity) o;
        return statusNameId == that.statusNameId && Objects.equals(statusName, that.statusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusNameId, statusName);
    }
}
