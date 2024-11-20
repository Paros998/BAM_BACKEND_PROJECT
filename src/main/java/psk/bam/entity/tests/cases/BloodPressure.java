package psk.bam.entity.tests.cases;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "blood_pressures")
@Table(name = "blood_pressures")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class BloodPressure {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            nullable = false,
            updatable = false
    )
    private UUID pressureId;

    private Integer bloodPressureOn;
    private Integer bloodPressureTo;

    private Integer testOrder;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private BloodPressureTestEntity bloodPressureTestEntity;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BloodPressure that = (BloodPressure) o;
        return Objects.equals(pressureId, that.pressureId) && Objects.equals(bloodPressureOn, that.bloodPressureOn)
                && Objects.equals(bloodPressureTo, that.bloodPressureTo) && Objects.equals(testOrder, that.testOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pressureId, bloodPressureOn, bloodPressureTo, testOrder);
    }
}
