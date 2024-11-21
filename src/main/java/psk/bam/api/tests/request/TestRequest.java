package psk.bam.api.tests.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
@EqualsAndHashCode
@SuperBuilder
public abstract class TestRequest {
    @NonNull
    private UUID patientId;
    private LocalDateTime dateOfTest;
    private String note;
}
