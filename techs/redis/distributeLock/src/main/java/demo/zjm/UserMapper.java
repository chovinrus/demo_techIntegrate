package demo.zjm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Update("update db_user set age = age - 1 where name = ‘小明’")
    public String minusXiaoming();
}
