package group.project.api.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthRequest {

    @NotBlank()
    @Size(min=8, max= 20)
    private String phone;

    @NotBlank()
    @Size(min = 6, max = 50)
    private String password;

    public AuthRequest() {

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
