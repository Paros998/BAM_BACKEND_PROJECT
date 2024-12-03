package psk.bam.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import psk.bam.api.tests.response.AssignedDoctorResponse;
import psk.bam.mapper.DoctorMapper;
import psk.bam.service.PatientService;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/patients")
@RequiredArgsConstructor
@RestController
public class PatientHttpEndpoint {
    private final PatientService patientService;
    private final DoctorMapper doctorMapper;

    @GetMapping("/assigned-doctor/{patientId}")
    public AssignedDoctorResponse getAssignedDoctor(final @PathVariable("patientId") UUID patientId) {
        return AssignedDoctorResponse.of(Optional.ofNullable(patientService.getPatientEntity(patientId).getAssignedDoctor())
                .map(doctorMapper::mapToDoctorModel)
                .orElse(null));
    }

    @PostMapping("/assign-doctor/{doctorId}/{patientId}")
    public void assignDoctor(final @PathVariable("doctorId") UUID doctorId, final @PathVariable("patientId") UUID patientId) {
        patientService.assignDoctorToPatient(doctorId, patientId);
    }
}
