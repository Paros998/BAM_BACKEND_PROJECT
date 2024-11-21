package psk.bam.api.tests.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.tests.TestType;

import java.util.List;

@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AddPulseTestRequest extends TestRequest {
    public static final TestType TYPE = TestType.PULSE;

    private List<Integer> beatsPerMinute;
}
