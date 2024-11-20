package psk.bam.entity.patients;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.tests.PatientTestEntity;
import psk.bam.entity.users.UserEntity;
import psk.bam.entity.users.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "patients")
@Table(name = "patients")
@ToString(callSuper = true)
@SuperBuilder
public class PatientEntity extends UserEntity {
    public PatientEntity() {
        this.role = UserRole.PATIENT;
    }

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<PatientTestEntity> takenTests = new ArrayList<>();

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(takenTests, that.takenTests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), takenTests);
    }
}
