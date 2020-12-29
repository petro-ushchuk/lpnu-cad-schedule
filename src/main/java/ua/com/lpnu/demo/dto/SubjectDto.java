package ua.com.lpnu.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ua.com.lpnu.demo.dto.validation.group.OnRegister;
import ua.com.lpnu.demo.model.Group;
import ua.com.lpnu.demo.model.enums.Day;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
@Data
public class SubjectDto {

    @JsonProperty(access = READ_ONLY)
    private Long id;

    @NotBlank(groups = OnRegister.class, message = "{name.blank}")
    private String title;

    @NotBlank(groups = OnRegister.class, message = "{surname.blank}")
    private Day day;

    @NotBlank(groups = OnRegister.class, message = "{name.blank}")
    private Long number;

    @NotBlank(groups = OnRegister.class, message = "{name.blank}")
    private String audience;

    @NotBlank(groups = OnRegister.class, message = "{name.blank}")
    private String url;

    @NotBlank(groups = OnRegister.class, message = "{name.blank}")
    private Group group;

}
