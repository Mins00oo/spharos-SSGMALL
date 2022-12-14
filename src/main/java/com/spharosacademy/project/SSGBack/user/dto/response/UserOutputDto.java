package com.spharosacademy.project.SSGBack.user.dto.response;

import com.spharosacademy.project.SSGBack.user.dto.request.UserEditInputDto;
import com.spharosacademy.project.SSGBack.user.entity.UserRole;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserOutputDto {

    private Long id;
    private String userId;
    private String userPwd;
    private String name;
    private String userAddress;
    private String userEmail;
    private String userPhone;
    private String memberType;
    private UserRole role;
    private LocalDateTime userBirthDate, createdAt, updatedAt;
    private Boolean userDropCheck;

}
