package com.codegym.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserDto implements Validator {
    private int id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;

    @NotNull
    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải là 10 số")
    private String numberPhone;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi phải >= 18")
    private String age;

    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[a-z]+([\\_\\.]?[a-z\\d]+)*@[a-z]{3,7}\\.[a-z]{2,3}$", message = "Sai quy tắc đặt tên mail example@xxx.xxx")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String numberPhone, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
    }
}
