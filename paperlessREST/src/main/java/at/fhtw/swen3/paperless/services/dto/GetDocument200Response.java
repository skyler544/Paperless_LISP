package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("GetDocument_200_response")
public class GetDocument200Response extends Document {
    public GetDocument200Response() {
        super();
    }
}
