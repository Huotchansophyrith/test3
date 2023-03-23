package LocalTripManangement.LocalTrip.entiry;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
@Table(name="Places")
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String placeName;
    private String province1;
    private String img;
    private boolean status;

    @Column(columnDefinition="TEXT")
    private String history;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
}
