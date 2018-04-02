package web.mvc.Mapper;

import org.springframework.stereotype.Repository;
import web.mvc.Been.MenuBeen;
import web.mvc.Been.UserBeen;

import java.util.List;

@Repository
public interface LoginDao {

    UserBeen loginCheck(UserBeen user);

    void addUser(UserBeen user);

    List<MenuBeen> selectMenuByUserRole(String keyid);
}
