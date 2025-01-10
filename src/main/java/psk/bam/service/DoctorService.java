package psk.bam.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import psk.bam.api.doctors.AssignedPatient;
import psk.bam.entity.doctors.DoctorEntity;
import psk.bam.entity.doctors.DoctorRepository;
import psk.bam.entity.patients.PatientEntity;
import psk.bam.mapper.HealthTestMapper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import static psk.bam.entity.doctors.DoctorEntity.MAX_ASSIGNED_PATIENTS;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final HealthTestMapper healthTestMapper;

    public List<DoctorEntity> findAvailableDoctors() {
        return doctorRepository.findAll().stream()
                .filter(doctorEntity -> doctorEntity.getAssignedPatients().size() < MAX_ASSIGNED_PATIENTS)
                .toList();
    }

    public DoctorEntity getAvailableDoctorOrThrow(final @NonNull UUID doctorId) {
        return doctorRepository.findById(doctorId)
                .filter(doctor -> doctor.getAssignedPatients().size() < MAX_ASSIGNED_PATIENTS)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Doctor with given id or available patients slot not found"));
    }

    public List<AssignedPatient> getDoctorAssignedPatients(final @NonNull UUID doctorId) {
        DoctorEntity doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return doctor.getAssignedPatients().stream()
                .map(this::toAssignedPatient)
                .toList();
    }

    private AssignedPatient toAssignedPatient(final @NonNull PatientEntity patient) {
        return AssignedPatient.builder()
                .patientId(patient.getUserId())
                .fullName(String.format("%s %s", patient.getFirstName(), patient.getLastName()))
                .nationalId(patient.getNationalId())
                .phoneNumber(patient.getPhoneNumber())
                .age((int) ChronoUnit.YEARS.between(patient.getDateOfBirth(), LocalDate.now()))
                .patientTests(patient.getTakenTests().stream().map(healthTestMapper::toTestDto).toList())
                .build();
    }
}
