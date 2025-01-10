package psk.bam.api.doctors;

import lombok.*;
import lombok.experimental.SuperBuilder;
import psk.bam.api.tests.response.PatientTestResponse;
import psk.bam.api.users.PatientModel;

import java.io.Serializable;
import java.util.List;

@Data
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssignedPatient extends PatientModel implements Serializable {
    @NonNull
    private List<PatientTestResponse> patientTests;
}
