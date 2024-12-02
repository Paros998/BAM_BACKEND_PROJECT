package psk.bam.entity.patients;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.doctors.DoctorEntity;
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

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private DoctorEntity assignedDoctor;

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
        return Objects.equals(takenTests, that.takenTests) && Objects.equals(assignedDoctor, that.assignedDoctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), takenTests, assignedDoctor);
    }
}
