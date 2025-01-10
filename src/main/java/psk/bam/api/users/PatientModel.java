package psk.bam.api.users;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Data
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PatientModel implements Serializable {
    @NonNull
    private UUID patientId;
    @NonNull
    private String fullName;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String nationalId;
    @NonNull
    private Integer age;
}
