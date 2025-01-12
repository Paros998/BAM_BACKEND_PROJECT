package psk.bam.api.tests.request;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UpdateTestNoteRequest implements Serializable {
    @NonNull
    private String newNote;
}
