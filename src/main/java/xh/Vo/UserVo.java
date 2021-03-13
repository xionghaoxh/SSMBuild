package xh.Vo;

import lombok.Data;
import lombok.NonNull;
import xh.Entity.UserEntity;

@Data
public class UserVo {
    //用户名
    private String username;
    //姓名
    private String nickname;
    //电话
    private String tellphone;
    //邮箱
    private String email;
    //登录ip
    private Integer loginCount;
    //登录次数
    private String  loginIp;
    //登录时间
    private Integer loginAt;

    public static UserVo of(@NonNull UserEntity e) {
        //验证UserEntity 非空
        UserVo vo = new UserVo();
        vo.setUsername(e.getUsername());
        vo.setNickname(e.getNickname());
        vo.setTellphone(e.getTellphone());
        vo.setEmail(e.getEmail());
        vo.setLoginCount(e.getLoginCount());
        vo.setLoginIp(e.getLoginIp());
        vo.setLoginAt(e.getLoginAt());
        return vo;
    }
}
