package ie.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "iris", catalog = "irises")
public class Iris {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "species")
	private String species;

	@NotNull
	@Column(name = "sepal_length")
	private BigDecimal sepalLength;

	@NotNull
	@Column(name = "sepal_width")
	private BigDecimal sepalWidth;

	@NotNull
	@Column(name = "petal_length")
	private BigDecimal petalLength;

	@NotNull
	@Column(name = "petal_width")
	private BigDecimal petalWidth;
}