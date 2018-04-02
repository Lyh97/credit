package web.mvc.Mapper;

import org.springframework.stereotype.Repository;
import web.mvc.Been.UserBeen;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    List<UserBeen> selectAllUser(Map<String, Object> map);

    void deleteUserBykeyid(Map<String, Object> map);

    void deleteActPersonBykeyid(Map<String, Object> map);

    void deleteActCatalogStatus0Bykeyid(Map<String, Object> map);

    void updateUserBykeyid(UserBeen user);
}
