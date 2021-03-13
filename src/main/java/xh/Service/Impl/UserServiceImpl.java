package xh.Service.Impl;


import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import xh.Ao.UserAo;
import xh.Entity.UserEntity;
import xh.Mapper.UserDao;
import xh.Service.UserService;
import xh.utils.GetNowData;
import xh.utils.UUID;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;
    @Override
    public void addUser(@NonNull UserAo ao) throws Exception {
        //清理参数
        //执行逻辑

        boolean flag = dao.exists("username", ao.getUsername());//查询用户是否重名
        if(!flag){
            UserEntity entity = new UserEntity();
            entity.setDisabled(false);
            entity.setEmail(ao.getEmail());
            entity.setId(UUID.random32());

            entity.setNickname(ao.getNickname());
            SecureRandomNumberGenerator se = new SecureRandomNumberGenerator();
            String salt = se.nextBytes().toBase64();
            String pwd = new Sha256Hash(ao.getPassword(), salt, 1024).toBase64();
            entity.setPassword(pwd);
            entity.setSalt(salt);
            entity.setUsername(ao.getUsername());
            entity.setTellphone(ao.getTellphone());
            entity.setAddress(null);
            entity.setLoginAt(GetNowData.getData());
            entity.setLoginIp("127.0.0.1");
            entity.setLoginCount(1);
            //组装业务
            dao.insert(entity);
        }

    }

    @Override
    public void removeUser(String id) throws Exception {
        //清理参数
        if(null==id.trim()){
            throw new NullPointerException("id为空");
        }
        //执行逻辑
        dao.delete(id);
        //组装业务


    }

    @Override
    public void modifyUser(String id, @NonNull UserEntity  entity) throws Exception {
        //清理参数
        if(null==id.trim()){
            throw new NullPointerException("id为空");
        }
        //执行逻辑
       dao.update(id,entity);
        //组装业务
    }

    @Override
    public List<UserEntity> queryAllUsers(String cloumn) throws Exception {
        //清理参数
        if(null==cloumn){
            throw new NullPointerException("列名");
        }
        //执行逻辑
        List<UserEntity> userEntities = dao.selectAll(cloumn);
        //组装业务
        return userEntities;
    }
}
