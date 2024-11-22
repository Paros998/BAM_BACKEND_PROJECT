package psk.bam.initializers;

import lombok.Data;
import lombok.NoArgsConstructor;
import psk.bam.entity.patients.PatientEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UsersToAddConfig {
    private List<PatientEntity> patients = new ArrayList<>();
}
