package seminar.tum.fingerprintdb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fingerprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double audio;

    @ElementCollection
    private List<String> fonts;

    private Boolean cookiesEnabled;

    private String platform;


}
