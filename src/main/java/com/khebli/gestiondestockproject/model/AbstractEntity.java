package com.khebli.gestiondestockproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity  implements Serializable {

    @Id
    @SequenceGenerator( name = "owner_sequence", sequenceName ="owner_sequence", allocationSize = 1,schema = "public")
    @GeneratedValue(strategy = SEQUENCE, generator = "owner_sequence")
    private Integer Id;

    @CreatedDate
    @Column(name="creationDate", nullable = false)
    @JsonIgnore
    private Instant creationDate;

    @LastModifiedDate
    @Column(name="lastModifiedDate")
    @JsonIgnore
    private Instant lastUpdateDate;

}
