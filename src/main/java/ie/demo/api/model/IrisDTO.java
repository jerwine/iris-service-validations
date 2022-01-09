package ie.demo.api.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IrisDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty
    private String species;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    @Positive
    private BigDecimal sepalLength;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    @Positive
    private BigDecimal sepalWidth;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    @Positive
    private BigDecimal petalLength;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    @Positive
    private BigDecimal petalWidth;
}