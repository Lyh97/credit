package web.mvc.Mapper;

import org.springframework.stereotype.Repository;
import web.mvc.Been.ActClassBeen;

import java.util.List;

@Repository
public interface ActClassDao {

    List<ActClassBeen> selectAllActClass();

    double selectGradeByName(String acttype);

    void addClass(ActClassBeen act);

    void updateClass(ActClassBeen actClassBeen);

    void deleteClass(ActClassBeen actClassBeen);
}
