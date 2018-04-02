package web.mvc.Service;

import org.springframework.stereotype.Service;
import web.mvc.Been.MenuBeen;
import web.mvc.Been.UserBeen;
import web.mvc.Mapper.LoginDao;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {
    @Resource
    LoginDao dao;

    public UserBeen loginCheck(UserBeen user) {

        UserBeen users = dao.loginCheck(user);
        return users;
    }

    public void addUser(UserBeen user) {
        dao.addUser(user);
    }

    public List<MenuBeen> selectMenuByUserRole(String keyid) {
        return dao.selectMenuByUserRole(keyid);
    }
}
