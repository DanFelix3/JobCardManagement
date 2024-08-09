package com.demoprogram.database.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class SearchModel {
    @NotNull
    private String searchItem;
}
