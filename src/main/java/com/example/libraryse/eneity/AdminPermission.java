package com.example.libraryse.eneity;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminPermission {
    private Integer id;
    private  String name;
    private  String desc_;
    private  String url;
}
