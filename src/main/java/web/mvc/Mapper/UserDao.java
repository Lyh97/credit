package web.mvc.Mapper;

import org.springframework.stereotype.Repository;
import web.mvc.Been.UserBeen;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    List<UserBeen> selectAllUser(Map<String, Object> map);
}
