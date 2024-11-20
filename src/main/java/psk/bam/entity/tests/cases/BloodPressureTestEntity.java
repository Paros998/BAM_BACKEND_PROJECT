package psk.bam.entity.tests.cases;

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
import psk.bam.entity.tests.TestType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "blood_tests")
@Table(name = "blood_tests")
@ToString(callSuper = true)
@SuperBuilder
public class BloodPressureTestEntity extends PatientTestEntity {
    public BloodPressureTestEntity() {
        this.type = TestType.BLOOD_PRESSURE;
    }

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "bloodPressureTestEntity", fetch = FetchType.LAZY)
    private List<BloodPressure> bloodPressures = new ArrayList<>();


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
        BloodPressureTestEntity that = (BloodPressureTestEntity) o;
        return Objects.equals(bloodPressures, that.bloodPressures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bloodPressures);
    }
}
