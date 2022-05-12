package product.util.checker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ResponseChecker {
    public boolean responseCheck(ResponseEntity entity) {
        return Objects.nonNull(entity) && Objects.nonNull(entity.getBody()) && entity.getStatusCode() == HttpStatus.OK;
    }
}
