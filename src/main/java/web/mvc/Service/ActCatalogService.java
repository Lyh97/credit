package web.mvc.Service;

import org.springframework.stereotype.Service;
import web.mvc.Been.ActCatalogBeen;
import web.mvc.Mapper.ActCatalogDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ActCatalogService {

    @Resource
    ActCatalogDao dao;

    public List<ActCatalogBeen> selectActive(Map<String, Object> map) {
        return dao.selectActive(map);
    }

    public int selectAll(Map<String, Object> map) {
        return dao.selectAll(map);
    }

    public List<ActCatalogBeen> selectAllStatus0() {
        return dao.selectAllStatus0();
    }

    public void updateStatus(ActCatalogBeen been) {
        dao.updateStatus(been);
    }

    public void updateStatus2(Map<String, Object> map) {
        dao.updateStatus2(map);
    }

    public void insertFinishtimeInPerson(Map<String, Object> map) {
        dao.insertFinishtimeInPerson(map);
    }
}
