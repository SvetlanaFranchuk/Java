package org.example.hotelbookingapplication.dto.comment;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@JsonRootName("comment")
public class CommentDto {
    private Long id;
    private String message;
    private LocalDate dateMessage;
    private String userFirstName;
    private String userLastName;
}
