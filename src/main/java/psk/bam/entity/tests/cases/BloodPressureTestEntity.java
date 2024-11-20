package psk.bam.entity.tests.cases;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.tests.PatientTestEntity;
import psk.bam.entity.tests.TestType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    private List<BloodPressure> bloodPressuresCases = new ArrayList<>();

    @Data
    @ToString
    @NoArgsConstructor
    @Embeddable
    public static class BloodPressure implements Serializable {
        private Integer bloodPressureOn;
        private Integer bloodPressureTo;
    }
}
