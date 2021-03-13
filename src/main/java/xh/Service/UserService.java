package xh.Service;

import xh.Ao.UserAo;
import xh.Entity.UserEntity;

import java.util.List;

public interface UserService {
    /**
     * 给我一个UserEntity，帮你添加进数据库
     * @param ao
     * @throws Exception
     */
    void addUser(UserAo ao) throws Exception;

    /**
     * 给我一个id 然后去删除
     * @param id
     * @throws Exception
     */
    void removeUser(String id) throws Exception;

    /**
     * 给我一个userAo，修改用户信息
     * @param id
     * @param entity
     * @throws Exception
     */
    void modifyUser(String id, UserEntity entity)throws Exception;

    /**
     * 查询全部用户
     * @param column
     * @return
     * @throws Exception
     */
    List<UserEntity> queryAllUsers(String column) throws Exception;


}
