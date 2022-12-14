package com.spharosacademy.project.SSGBack.user.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spharosacademy.project.SSGBack.user.entity.UserRole;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInputDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "비밀번호는 8~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String userPwd;

    @NotBlank(message = "주소를 입력해주세요.")
    private String userAddress;

    @NotBlank(message = "이름을 입력해주세요.")
    @Pattern(regexp = "^[가-힣]+", message = "이름을 정확히 입력하여주십시오.")
    private String name;

    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String userEmail;

    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    @NotBlank(message = "핸드폰 번호를 입력해주세요.")
    private String userPhoneNumber;


    @NotBlank(message = "탈퇴 여부를 입력해주세요")
    private Boolean userDropCheck;

    private String memberType;

    List<UserEditInputDto> userEditInputDtoList;


}
