package psk.bam.api.tests.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode
public class BloodPressure {
    private Integer bloodPressureOn;
    private Integer bloodPressureTo;
    private Integer testOrder;
}
