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

@Getter
@Setter
@Entity(name = "diabetes_tests")
@Table(name = "diabetes_tests")
@ToString(callSuper = true)
@SuperBuilder
public class DiabetesTestEntity extends PatientTestEntity {
    public DiabetesTestEntity() {
        this.type = TestType.DIABETES;
    }

    private List<Integer> diabetesLevelCases = new ArrayList<>();
}
