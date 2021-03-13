package xh.Entity;

import lombok.Data;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class UserEntity {
    private String id;
    private String address;
    private boolean disabled;
    private String email;
    private Integer loginAt;
    private Integer loginCount;
    private String  loginIp;
    private String nickname;
    private String password;
    private String salt;
    private String tellphone;
    private String username;
}
