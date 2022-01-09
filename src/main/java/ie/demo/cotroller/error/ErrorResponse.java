package ie.demo.cotroller.error;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;
    private List<String>messages;
}
