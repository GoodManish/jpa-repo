package io.bootify.jpa_project.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerDTO {

    private Long id;

    @NotNull
    private Long custId;

    @NotNull
    private Long thresholdAmt;

    @NotNull
    private Long utilizedThresholdAmt;

    @NotNull
    private LocalDateTime createdDate;

    @NotNull
    private LocalDateTime lastUpdated;

    @NotNull
    private Long usr;

}
