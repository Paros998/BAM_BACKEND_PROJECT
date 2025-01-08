package psk.bam.api.users;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@EqualsAndHashCode
public class DoctorModel implements Serializable {
    private UUID doctorId;
    private String fullName;
    private String specialization;
    private Integer yearsOfExperience;
    private Integer age;
    private Integer assignedPatients;
    private List<UUID> assignedPatientIds;
}
