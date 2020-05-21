package com.example.libraryse.eneity;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminRolePermission {
    private Integer id;

    private Integer rid;

    private Integer pid;


}
