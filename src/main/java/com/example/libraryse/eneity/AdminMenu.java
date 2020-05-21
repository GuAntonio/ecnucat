package com.example.libraryse.eneity;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

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
public class AdminMenu  {

    private Integer id;

    private String path;

    private String name;

    private String nameZh;

    private String iconCls;

    private String component;

    private Integer parentId;
    List<AdminMenu> children;

}
