package com.example.libraryse.eneity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-05-09
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminRoleMenu  {

    private Integer id;

    private Integer rid;

    private Integer mid;


}
