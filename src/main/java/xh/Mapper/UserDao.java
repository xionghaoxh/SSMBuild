package xh.Mapper;


import org.springframework.stereotype.Repository;
import xh.Entity.UserEntity;

@Repository
public interface UserDao extends TempleteDao<String, UserEntity> {

}
