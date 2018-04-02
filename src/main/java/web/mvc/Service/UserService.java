package web.mvc.Service;

import org.springframework.stereotype.Service;
import web.mvc.Been.UserBeen;
import web.mvc.Mapper.UserDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource
    UserDao dao;

    public List<UserBeen> selectAllUser(Map<String, Object> map) {
        return dao.selectAllUser(map);
    }
}
