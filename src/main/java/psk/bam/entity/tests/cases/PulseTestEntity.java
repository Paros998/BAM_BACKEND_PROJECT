package psk.bam.entity.tests.cases;


import jakarta.persistence.Entity;
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
@Entity(name = "pulse_tests")
@Table(name = "pulse_tests")
@ToString(callSuper = true)
@SuperBuilder
public class PulseTestEntity extends PatientTestEntity {
    public PulseTestEntity() {
        this.type = TestType.PULSE;
    }

    private List<Integer> beatsPerMinute = new ArrayList<>();

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
        PulseTestEntity that = (PulseTestEntity) o;
        return Objects.equals(beatsPerMinute, that.beatsPerMinute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), beatsPerMinute);
    }
}
