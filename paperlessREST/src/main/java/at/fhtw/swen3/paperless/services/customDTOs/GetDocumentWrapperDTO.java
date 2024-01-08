package at.fhtw.swen3.paperless.services.customDTOs;

import at.fhtw.swen3.paperless.services.dto.GetDocument200Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDocumentWrapperDTO {

    private Integer count;

    private List<GetDocument200Response> results;

}
