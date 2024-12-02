package psk.bam.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import psk.bam.api.users.DoctorModel;
import psk.bam.entity.doctors.DoctorEntity;
import psk.bam.mapper.DoctorMapper;
import psk.bam.service.PatientService;

import java.util.UUID;

@RequestMapping("api/v1/patients")
@RequiredArgsConstructor
@RestController
public class PatientHttpEndpoint {
    private final PatientService patientService;
    private final DoctorMapper doctorMapper;

    @GetMapping("/assigned-doctor/{patientId}")
    public DoctorModel getAssignedDoctor(final @PathVariable("patientId") UUID patientId) {
        final DoctorEntity assignedDoctor = patientService.getPatientEntity(patientId).getAssignedDoctor();
        return doctorMapper.mapToDoctorModel(assignedDoctor);
    }

    @PostMapping("/assign-doctor/{doctorId}/{patientId}")
    public void assignDoctor(final @PathVariable("doctorId") UUID doctorId, final @PathVariable("patientId") UUID patientId) {
        patientService.assignDoctorToPatient(doctorId, patientId);
    }
}
