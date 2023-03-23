package LocalTripManangement.LocalTrip.entiry;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin;

    @Column(unique = true)
    private String adminName;
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
}
