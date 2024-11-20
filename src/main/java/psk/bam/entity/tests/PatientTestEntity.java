package psk.bam.entity.tests;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.patients.PatientEntity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "health_tests")
@Table(name = "health_tests")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public abstract class PatientTestEntity {
    private static final long MAX_NOTE_CHARACTERS = 5000;
    private static final int MAX_NOTE_CHARACTERS_INT = (int) MAX_NOTE_CHARACTERS;

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            nullable = false,
            updatable = false
    )
    protected UUID testId;

    protected LocalDateTime testDate;

    @Enumerated(EnumType.STRING)
    protected TestType type;

    @Max(MAX_NOTE_CHARACTERS)
    @Column(length = MAX_NOTE_CHARACTERS_INT)
    protected String note;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    protected PatientEntity patient;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PatientTestEntity that = (PatientTestEntity) o;
        return Objects.equals(testId, that.testId) && Objects.equals(testDate, that.testDate)
                && type == that.type && Objects.equals(note, that.note) && Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, testDate, type, note, patient);
    }

}
