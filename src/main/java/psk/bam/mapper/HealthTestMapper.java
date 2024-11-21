package psk.bam.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import psk.bam.api.tests.response.BloodPressure;
import psk.bam.api.tests.response.PatientTestResponse;
import psk.bam.entity.tests.PatientTestEntity;
import psk.bam.entity.tests.cases.BloodPressureEntity;
import psk.bam.entity.tests.cases.BloodPressureTestEntity;
import psk.bam.entity.tests.cases.DiabetesTestEntity;
import psk.bam.entity.tests.cases.PulseTestEntity;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class HealthTestMapper {

    @SuppressWarnings("checkstyle:MissingSwitchDefault")
    public PatientTestResponse toTestDto(final @NonNull PatientTestEntity testEntity) {
        final var testResponse = PatientTestResponse.builder()
                .id(testEntity.getTestId().toString())
                .note(testEntity.getNote())
                .patientId(testEntity.getPatient().getUserId().toString())
                .type(testEntity.getType().name())
                .testDate(testEntity.getTestDate().format(DateTimeFormatter.ISO_DATE_TIME));

        switch (testEntity.getType()) {
            case PULSE -> testResponse.beatsPerMinute(((PulseTestEntity) testEntity).getBeatsPerMinute());
            case DIABETES -> testResponse.diabetesLevelCases(((DiabetesTestEntity) testEntity).getDiabetesLevelCases());
            case BLOOD_PRESSURE -> testResponse.bloodPressures(((BloodPressureTestEntity) testEntity).getBloodPressures().stream()
                    .map(this::toBloodPressure)
                    .toList());
        }

        return testResponse.build();
    }

    private BloodPressure toBloodPressure(final @NonNull BloodPressureEntity bloodPressure) {
        return BloodPressure.builder()
                .bloodPressureOn(bloodPressure.getBloodPressureOn())
                .bloodPressureTo(bloodPressure.getBloodPressureTo())
                .testOrder(bloodPressure.getTestOrder())
                .build();
    }

}
