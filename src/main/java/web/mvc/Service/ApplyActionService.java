package web.mvc.Service;

import org.springframework.stereotype.Service;
import web.mvc.Been.ActCatalogBeen;
import web.mvc.Been.ActClassBeen;
import web.mvc.Mapper.ApplyActionDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ApplyActionService {

    @Resource
    ApplyActionDao dao;

    public void applyAction(ActCatalogBeen act) {
        dao.applyAction(act);
    }

    public List<ActCatalogBeen> selectRecordByCondition(Map<String, Object> map) {
        return dao.selectRecordByCondition(map);
    }

    public List<ActCatalogBeen> selectRecordNumber(Map<String, Object> map) {
        return dao.selectRecordNumber(map);
    }

    public void deleteApply(String keyid) {
        dao.deleteApply(keyid);
    }
}
