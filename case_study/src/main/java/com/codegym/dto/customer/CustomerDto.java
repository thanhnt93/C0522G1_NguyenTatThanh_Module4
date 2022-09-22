package com.codegym.dto.customer;


import com.codegym.model.customer.CustomerType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CustomerDto {

    private int id;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Phải viết hoa chữ cái của mỗi từ!")
    private String name;

    @NotBlank(message = "Tên không được để trống")
    private String birthday;


    private int gender;

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Vui lòng nhập lại theo định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX (X: 0-9)")
    private String idCard;

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Vui lòng nhập lại theo định dạng: 090xxxxxxx or 091xxxxxxx " +
                    "or (84)+90xxxxxxx or (84)+91xxxxxxx (x: 0-9)")
    private String numberPhone;

    @NotBlank(message = "Tên không được để trống")
    @Email(message = "Vui lòng nhập lại theo định dạng: abc@gmail.com or abc@gmail.com.vn")
    private String email;

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Phải viết hoa chữ cái của mỗi từ!")
    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String birthday, int gender, String idCard, String numberPhone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }
}
