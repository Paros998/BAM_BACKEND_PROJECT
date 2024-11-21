package psk.bam.delivery;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import psk.bam.api.tests.request.AddBloodPressureTestRequest;
import psk.bam.api.tests.request.AddDiabetesTestRequest;
import psk.bam.api.tests.request.AddPulseTestRequest;
import psk.bam.api.tests.response.PatientTestResponse;
import psk.bam.service.PatientService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/patient-tests")
@RequiredArgsConstructor
@RestController
public class PatientsTestsHttpEndpoint {
    private final PatientService patientService;

    @GetMapping("/{patientId}")
    public List<PatientTestResponse> getPatientTests(final @PathVariable UUID patientId) {
        return patientService.getPatientTests(patientId);
    }

    @PostMapping("/pulse")
    public UUID addPulseTestResults(final @Valid @RequestBody AddPulseTestRequest request) {
        return patientService.addTestResult(request);
    }

    @PostMapping("/diabetes")
    public UUID addDiabetesTestResults(final @Valid @RequestBody AddDiabetesTestRequest request) {
        return patientService.addTestResult(request);
    }

    @PostMapping("/blood-pressure")
    public UUID addBloodPressureTestResults(final @Valid @RequestBody AddBloodPressureTestRequest request) {
        return patientService.addTestResult(request);
    }
}