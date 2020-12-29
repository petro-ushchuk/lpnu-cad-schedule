package ua.com.lpnu.demo.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class GroupDto {

    @Null
    private Long id;

    @NotNull
    private String title;

}
