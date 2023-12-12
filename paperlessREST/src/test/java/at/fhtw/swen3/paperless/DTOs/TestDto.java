package at.fhtw.swen3.paperless.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
    private Integer id;
    private String title;
    private String content;
}
