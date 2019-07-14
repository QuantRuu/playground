package me.ruu.playground.dao;

import me.ruu.playground.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
//    @Select 是查询类的注解，所有的查询均使用这个
//    @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
//    @Insert 插入数据库使用，直接传入实体类会自动解析属性到对应的值
//    @Update 负责修改，也可以直接传入对象
//    @delete 负责删除

    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    @Select("SELECT * FROM user WHERE user_id = #{id}")
    User getUser(Long id);

    @Insert("INSERT INTO user(username,password,age) VALUES(#{username}, #{password}, #{age})")
    int insertUser(User user);

    @Update("UPDATE user SET username=#{username},age=#{age} WHERE user_id =#{userId}")
    int updateUser(User user);

    @Delete("DELETE FROM user WHERE user_id =#{id}")
    int deleteUser(Long id);

}