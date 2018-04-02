package web.mvc.Mapper;

import org.springframework.stereotype.Repository;
import web.mvc.Been.ActFinishBeen;
import web.mvc.Been.JoinBeen;
import web.mvc.Been.UserBeen;

import java.util.List;
import java.util.Map;

@Repository
public interface ActPersonDao {

    void addPerson(ActFinishBeen been);

    int selectActNumber(String activekeyid);

    String selectEnrollmentTimeBystukeyid(String stukeyid);

    String selectUserNameBykeyid(String keyid);

    List<ActFinishBeen> selectActByUserKeyid(String keyid);

    List<ActFinishBeen> selectGradeByStuKeyid(Map<String, Object> map);

    List<JoinBeen> selectJoinPersonByActkeyid(Map<Object, String> map);

    void deleteJoinByStuKeyid(Map<Object, String> map);

    List<ActFinishBeen> selectPersonGrade(ActFinishBeen be);

    List<UserBeen> selectUserBykeyid(String keyid);
}
