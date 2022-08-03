package io.bootify.jpa_project.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/*
@Entity
@Table*//*(name ="customers")*//*
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "id",nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private Long custId;

    @Column(nullable = false)
    private Long thresholdAmt;

    @Column(nullable = false)
    private Long utilizedThresholdAmt;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usr_id")
    private User user;

    */



@Entity
@Table
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long custId;

    @Column(nullable = false)
    private Long thresholdAmt;

    @Column(nullable = false)
    private Long utilizedThresholdAmt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdDate;

    @OneToOne(cascade = CascadeType.ALL)
    @NonNull
    private Usr usr;


}

