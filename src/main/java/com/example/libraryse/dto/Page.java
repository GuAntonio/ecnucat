package com.example.libraryse.dto;

import com.example.libraryse.eneity.JotterArticle;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Page {
    List<JotterArticle> content;
    Integer totalCount;
}
