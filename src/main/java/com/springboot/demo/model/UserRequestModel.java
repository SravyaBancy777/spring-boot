package com.springboot.demo.model;

        import com.fasterxml.jackson.annotation.JsonProperty;
        import jakarta.validation.constraints.Email;
        import jakarta.validation.constraints.NotBlank;
        import jakarta.validation.constraints.Positive;
        import jakarta.validation.constraints.Size;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestModel {
    @JsonProperty("first-name")
    @NotBlank(message = "first name can not be empty")
    @Size(min = 2, message = "First name can not be less than 2 characters")
    private String firstName;

    @JsonProperty("last-name")
    @NotBlank(message = "last name can not be empty")
    @Size(min = 2, message = "lastname can not be less than 2 characters")
    private String lastName;

    @Email
    private String email;

    @Positive
    private int age;

}
