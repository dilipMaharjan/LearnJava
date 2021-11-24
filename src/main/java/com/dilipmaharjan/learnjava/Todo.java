package com.dilipmaharjan.learnjava;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dilip
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Todo {
    private long id;
    private String title;
    private String description;

}
