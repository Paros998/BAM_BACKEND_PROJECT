package psk.bam.initializers;

import lombok.Data;
import lombok.NoArgsConstructor;
import psk.bam.entity.admins.AdminEntity;
import psk.bam.entity.doctors.DoctorEntity;
import psk.bam.entity.patients.PatientEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UsersToAddConfig {
    private List<PatientEntity> patients = new ArrayList<>();
    private List<DoctorEntity> doctors = new ArrayList<>();
    private List<AdminEntity> admins = new ArrayList<>();
}
