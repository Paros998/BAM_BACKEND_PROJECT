package psk.bam.api.tests.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import psk.bam.api.users.DoctorModel;

import java.io.Serializable;

@Data
@AllArgsConstructor(staticName = "of")
public class AssignedDoctorResponse implements Serializable {
    private DoctorModel doctor;
}
