package generator.mapper;

import generator.domain.User;

/**
* @author 麻小神
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-05-26 00:49:59
* @Entity generator.domain.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
