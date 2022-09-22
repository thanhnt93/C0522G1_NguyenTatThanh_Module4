package com.codegym.dto.employee;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Getter
@Setter
public class EmployeeDto {
    private int id;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Phải viết hoa chữ cái của mỗi từ")
    private String name;

    private String birthday;

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Vui lòng nhập lại theo định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX (X: 0-9)")
    private String idCard;


    private double salary;

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Vui lòng nhập lại theo định dạng: 090xxxxxxx hoặc 091xxxxxxx " +
                    "hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx (x: 0-9)")
    private String numberPhone;

    @NotBlank(message = "Tên không được để trống")
    @Email(message = "Vui lòng nhập lại theo định dạng: abc@gmail.com or abc@gmail.com.vn")
    private String email;

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Phải viết hoa chữ cái của mỗi từ!")
    private String address;


    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private Integer isDelete=0;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, String birthday, String idCard, double salary, String numberPhone,
                       String email, String address, Position position, EducationDegree educationDegree,
                       Division division) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }
}
