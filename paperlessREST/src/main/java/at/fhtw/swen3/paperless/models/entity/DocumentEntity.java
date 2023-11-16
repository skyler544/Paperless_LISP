package at.fhtw.swen3.paperless.models.entity;

import jakarta.validation.Valid;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer correspondent;

    private Integer documentType;

    private Integer storagePath;

    private String title;

    private String content;

    /* oh boy this is going to hurt
    @Valid
    @ManyToMany(fetch = FetchType.LAZY)
    private List<> tags;
    */
    private String created;

    private String createdDate;

    private String modified;

    private String added;

    private Integer archiveSerialNumber;

    private String originalFileName;

    private String archivedFileName;

    private Integer owner;
}
