package com.demoprogram.database.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class LoginModel {

    @NotNull(message = "Username must be provided!!")
    @Size(min=5,max=15,message="Username must be entered between 5-15 characters!!")
    private String username;

    @NotNull(message = "Password must be provided!!")
    @Size(min=8, max=15, message="Password must be between 8 to 15 characters!!")
    private String password;

    @Override
    public String toString(){
        return "LoginModel [username="+username+"password="+password+"]";
    }

}
