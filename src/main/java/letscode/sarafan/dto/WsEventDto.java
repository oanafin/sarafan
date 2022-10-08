package letscode.sarafan.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import letscode.sarafan.dto.ObjectType;
import letscode.sarafan.dto.EventType;

@Data
@AllArgsConstructor
@JsonView(Views.Id.class)
public class WsEventDto {
    private ObjectType objectType;
    private EventType eventType;
    @JsonRawValue
    private String body;

}
