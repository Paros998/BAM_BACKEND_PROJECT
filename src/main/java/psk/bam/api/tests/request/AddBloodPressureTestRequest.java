package psk.bam.api.tests.request;

import jakarta.validation.constraints.Max;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.tests.TestType;

import java.util.List;

@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AddBloodPressureTestRequest extends TestRequest {
    public static final TestType TYPE = TestType.BLOOD_PRESSURE;
    private static final int MAX_TESTS = 3;

    @Max(MAX_TESTS)
    private List<BloodPressure> bloodPressuresCases;
}
