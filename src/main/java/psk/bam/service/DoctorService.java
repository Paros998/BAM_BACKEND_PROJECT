package psk.bam.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import psk.bam.entity.doctors.DoctorEntity;
import psk.bam.entity.doctors.DoctorRepository;

import java.util.List;
import java.util.UUID;

import static psk.bam.entity.doctors.DoctorEntity.MAX_ASSIGNED_PATIENTS;

@Service
@RequiredArgsConstructor
public class DoctorService {
    public final DoctorRepository doctorRepository;

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
}
