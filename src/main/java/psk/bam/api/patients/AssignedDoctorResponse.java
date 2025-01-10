package psk.bam.api.patients;

import lombok.*;
import psk.bam.api.users.DoctorModel;

import java.io.Serializable;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class AssignedDoctorResponse implements Serializable {
    private DoctorModel doctor;
}
