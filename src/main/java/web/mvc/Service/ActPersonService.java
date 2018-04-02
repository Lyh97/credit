package web.mvc.Service;

import org.springframework.stereotype.Service;
import web.mvc.Been.ActFinishBeen;
import web.mvc.Been.JoinBeen;
import web.mvc.Been.UserBeen;
import web.mvc.Mapper.ActPersonDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ActPersonService {
    @Resource
    ActPersonDao dao;

    public void addPerson(ActFinishBeen been) {
        dao.addPerson(been);
    }

    public int selectActNumber(String activekeyid) {
        return dao.selectActNumber(activekeyid);
    }

    public String selectEnrollmentTimeBystukeyid(String stukeyid) {
        return dao.selectEnrollmentTimeBystukeyid(stukeyid);
    }

    public String selectUserNameBykeyid(String keyid) {
        return dao.selectUserNameBykeyid(keyid);
    }

    public List<ActFinishBeen> selectActByUserKeyid(String keyid) {
        return dao.selectActByUserKeyid(keyid);
    }

    public List<ActFinishBeen> selectGradeByStuKeyid(Map<String, Object> map) {
        return dao.selectGradeByStuKeyid(map);
    }

    public List<JoinBeen> selectJoinPersonByActkeyid(Map<Object, String> map) {
        return dao.selectJoinPersonByActkeyid(map);
    }

    public void deleteJoinByStuKeyid(Map<Object, String> map) {
        dao.deleteJoinByStuKeyid(map);
    }

    public List<ActFinishBeen> selectPersonGrade(ActFinishBeen be) {
        return dao.selectPersonGrade(be);
    }

    public List<UserBeen> selectUserBykeyid(String keyid) {
        return dao.selectUserBykeyid(keyid);
    }
}
