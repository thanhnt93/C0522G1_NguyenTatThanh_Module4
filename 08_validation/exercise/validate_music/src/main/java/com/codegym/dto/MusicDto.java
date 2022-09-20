package com.codegym.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MusicDto implements Validator {
    private int id;

    @NotBlank(message = "Không được phép để trống!")
    @Size(min = 5, max = 800, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String nameMusic;

    @NotBlank(message = "Không được phép để trống!")
    @Size(min = 5, max = 300, message = "Không quá 300 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String author;

    @NotBlank(message = "Không được phép để trống!")
    @Size(min = 5, max = 1000, message = "Không quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ,\\+]*$", message = "Trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép lưu vào DB.")
    private String typeOfMusic;

    private String link;

    public MusicDto() {
    }

    public MusicDto(int id, String nameMusic, String author, String typeOfMusic, String link) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.author = author;
        this.typeOfMusic = typeOfMusic;
        this.link = link;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
