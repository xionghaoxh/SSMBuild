package xh.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xh.Ao.UserAo;
import xh.Entity.UserEntity;
import xh.Service.UserService;
import xh.Vo.UserVo;
import xh.utils.JSONResponse;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService service;
    @PostMapping("/addUser")
    public JSONResponse addUser(UserAo ao) throws Exception {
        service.addUser(ao);
        return JSONResponse.ok();
    }
    @DeleteMapping("/deleteUser/{id}")
    public JSONResponse deleteUser(@PathVariable String id)throws Exception{
        service.removeUser(id);
        return JSONResponse.ok();
    }
    @PutMapping("/modifyUserInfo/{id}")
    public JSONResponse modifyUserInfo(@PathVariable String id, UserEntity entity)throws Exception{
        service.modifyUser(id,entity);
        return  JSONResponse.ok();
    }
    @GetMapping("/queryUserInfo")
    public JSONResponse queryUserInfo()throws Exception{
        String column= "username";
        List<UserEntity> userEntities = service.queryAllUsers(column);
        List<UserVo> list = new ArrayList<>(userEntities.size());
        System.out.println(list);
        for(UserEntity entity : userEntities){
           list.add( UserVo.of(entity));
        }
        return JSONResponse.ok(list);
    }
}
