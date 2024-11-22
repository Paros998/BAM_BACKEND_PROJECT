package psk.bam.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import psk.bam.api.tests.request.AddBloodPressureTestRequest;
import psk.bam.api.tests.request.AddDiabetesTestRequest;
import psk.bam.api.tests.request.AddPulseTestRequest;
import psk.bam.api.tests.response.PatientTestResponse;
import psk.bam.entity.patients.PatientEntity;
import psk.bam.entity.patients.PatientRepository;
import psk.bam.entity.tests.PatientTestRepository;
import psk.bam.entity.tests.cases.*;
import psk.bam.mapper.HealthTestMapper;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientTestRepository patientTestRepository;
    private final BloodPressureRepository bloodPressureRepository;
    private final HealthTestMapper healthTestMapper;

    @Transactional
    public UUID addTestResult(final @NonNull AddBloodPressureTestRequest request) {
        final PatientEntity patient = getPatientEntity(request.getPatientId());
        final var i = new AtomicInteger(1);

        final BloodPressureTestEntity testEntity = BloodPressureTestEntity.builder()
                .testDate(request.getDateOfTest())
                .note(request.getNote())
                .patient(patient)
                .type(AddBloodPressureTestRequest.TYPE)
                .build();

        patientTestRepository.save(testEntity);

        final List<BloodPressureEntity> bloodPressureEntities = request.getBloodPressuresCases().stream()
                .map(bloodPressure -> BloodPressureEntity.builder()
                        .testOrder(i.getAndIncrement())
                        .bloodPressureOn(bloodPressure.getBloodPressureOn())
                        .bloodPressureTo(bloodPressure.getBloodPressureTo())
                        .bloodPressureTestEntity(testEntity)
                        .build())
                .toList();
        bloodPressureRepository.saveAll(bloodPressureEntities);

        return testEntity.getTestId();
    }

    @Transactional
    public UUID addTestResult(final @NonNull AddPulseTestRequest request) {
        final PatientEntity patient = getPatientEntity(request.getPatientId());

        final PulseTestEntity testEntity = PulseTestEntity.builder()
                .testDate(request.getDateOfTest())
                .note(request.getNote())
                .patient(patient)
                .type(AddPulseTestRequest.TYPE)
                .beatsPerMinute(request.getBeatsPerMinute())
                .build();

        patientTestRepository.save(testEntity);
        return testEntity.getTestId();
    }

    @Transactional
    public UUID addTestResult(final @NonNull AddDiabetesTestRequest request) {
        final PatientEntity patient = getPatientEntity(request.getPatientId());

        final DiabetesTestEntity testEntity = DiabetesTestEntity.builder()
                .testDate(request.getDateOfTest())
                .note(request.getNote())
                .patient(patient)
                .type(AddDiabetesTestRequest.TYPE)
                .diabetesLevelCases(request.getDiabetesLevelCases())
                .build();

        patientTestRepository.save(testEntity);
        return testEntity.getTestId();
    }

    public List<PatientTestResponse> getPatientTests(final @NonNull UUID patientId) {
        final PatientEntity patient = getPatientEntity(patientId);
        return patient.getTakenTests().stream()
                .map(healthTestMapper::toTestDto)
                .toList();
    }

    private PatientEntity getPatientEntity(final UUID patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
    }

}
