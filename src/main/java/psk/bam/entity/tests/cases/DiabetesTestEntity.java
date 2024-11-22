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
@Entity(name = "diabetes_tests")
@Table(name = "diabetes_tests")
@ToString(callSuper = true)
@SuperBuilder
public class DiabetesTestEntity extends PatientTestEntity {
    public DiabetesTestEntity() {
        this.type = TestType.DIABETES;
    }

    private List<Integer> diabetesLevelCases = new ArrayList<>();

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
        DiabetesTestEntity that = (DiabetesTestEntity) o;
        return Objects.equals(diabetesLevelCases, that.diabetesLevelCases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diabetesLevelCases);
    }
}
