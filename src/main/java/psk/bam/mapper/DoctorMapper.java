package psk.bam.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import psk.bam.api.users.DoctorModel;
import psk.bam.entity.doctors.DoctorEntity;
import psk.bam.entity.patients.PatientEntity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class DoctorMapper {
    public DoctorModel mapToDoctorModel(final @NonNull DoctorEntity doctor) {
        return DoctorModel.builder()
                .doctorId(doctor.getUserId())
                .specialization(doctor.getSpecialization())
                .fullName(String.format("%s %s", doctor.getFirstName(), doctor.getLastName()))
                .assignedPatients(doctor.getAssignedPatients().size())
                .assignedPatientIds(doctor.getAssignedPatients().stream().map(PatientEntity::getUserId).toList())
                .yearsOfExperience((int) ChronoUnit.YEARS.between(doctor.getWorkingAsDoctorSince(), LocalDate.now()))
                .age((int) ChronoUnit.YEARS.between(doctor.getDateOfBirth(), LocalDate.now()))
                .build();
    }
}
