package psk.bam.api.tests.response;

import jakarta.annotation.Nullable;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@EqualsAndHashCode
public class PatientTestResponse {
    @NonNull
    private String id;
    @NonNull
    private String patientId;
    @NonNull
    private String testDate;
    @NonNull
    private String type;
    @Nullable
    private String note;

    @Nullable
    private List<Integer> beatsPerMinute;
    @Nullable
    private List<Integer> diabetesLevelCases;
    @Nullable
    private List<BloodPressure> bloodPressures;
}
