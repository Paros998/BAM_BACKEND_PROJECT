package psk.bam.api.tests.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class BloodPressure {
    private Integer bloodPressureOn;
    private Integer bloodPressureTo;
}
