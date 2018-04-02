package web.mvc.Service;

import org.springframework.stereotype.Service;
import web.mvc.Been.ActClassBeen;
import web.mvc.Mapper.ActClassDao;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActClassService {
    @Resource
    ActClassDao dao;

    public List<ActClassBeen> selectAllActClass() {
        return dao.selectAllActClass();
    }

    public double selectGradeByName(String acttype) {
        return dao.selectGradeByName(acttype);
    }

    public void addClass(ActClassBeen act) {
        dao.addClass(act);
    }

    public void updateClass(ActClassBeen actClassBeen) {
        dao.updateClass(actClassBeen);
    }

    public void deleteClass(ActClassBeen actClassBeen) {
        dao.deleteClass(actClassBeen);
    }
}
