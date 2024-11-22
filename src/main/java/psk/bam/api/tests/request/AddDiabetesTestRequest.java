package psk.bam.api.tests.request;

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
public class AddDiabetesTestRequest extends TestRequest {
    public static final TestType TYPE = TestType.DIABETES;

    private List<Integer> diabetesLevelCases;
}
