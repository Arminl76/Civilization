package ir.civilization.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangePasswordDTO {

    private String oldPassword;
    private String newPassword;

}
