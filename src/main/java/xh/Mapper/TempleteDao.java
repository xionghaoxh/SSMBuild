package xh.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface TempleteDao<ID extends Serializable,E> {
    /**
     * 新增
     *
     * @param e 用户对象
     * @throws Exception exception
     */
    void insert(@Param("param1") E e) throws Exception;

    /**
     * 通过id删除用户
     *
     * @param id id
     * @throws Exception exception
     */
    void delete(@Param("param1") ID id) throws Exception;

    /**
     * @param id 要修改的数据id
     * @param e 要修改的列和对应的值
     * @throws Exception exception
     */
    void update(@Param("param1") ID id,@Param("param2") E e) throws Exception;

    /**
     * 通过id查找用户对象
     *
     * @param id 用户id（保证不为null）
     * @return 如果不存在，则返回null
     * @throws Exception exception
     */
    E selectById(@Param("param1") ID id) throws Exception;

    /**
     * 查询全部用户
     * @return
     * @throws Exception
     */
    List<E> selectAll(@Param("param1") String column)throws Exception;

    /**
     * 查询某个元素是否存在
     * @param columnName
     * @param columnValue
     * @return
     * @throws Exception
     */
    boolean exists(@Param("param1") String columnName,@Param("param2")  Object columnValue)throws Exception;
}
