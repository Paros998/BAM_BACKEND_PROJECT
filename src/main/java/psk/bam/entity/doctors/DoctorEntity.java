package psk.bam.entity.doctors;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.patients.PatientEntity;
import psk.bam.entity.users.UserEntity;
import psk.bam.entity.users.UserRole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "doctors")
@Table(name = "doctors")
@ToString(callSuper = true)
@SuperBuilder
public class DoctorEntity extends UserEntity {
    public static final Integer MAX_ASSIGNED_PATIENTS = 10;

    public DoctorEntity() {
        this.role = UserRole.DOCTOR;
    }

    private String specialization;

    private LocalDate workingAsDoctorSince;

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "assignedDoctor", fetch = FetchType.LAZY)
    private List<PatientEntity> assignedPatients = new ArrayList<>();

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
        DoctorEntity that = (DoctorEntity) o;
        return Objects.equals(assignedPatients, that.assignedPatients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), assignedPatients);
    }
}
