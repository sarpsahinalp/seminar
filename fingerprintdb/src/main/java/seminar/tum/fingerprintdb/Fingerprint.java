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

    @ElementCollection
    private List<String> fonts;

    @ElementCollection
    private List<String> plugins;

    private Boolean cookiesEnabled;

    private String platform;

    private String userAgent;

    private String continent;

    private Integer screenResolution;

    private String bot;

}
