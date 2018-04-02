package web.mvc.Mapper;
import org.springframework.stereotype.Repository;
import web.mvc.Been.ActCatalogBeen;
import web.mvc.Been.ActClassBeen;

import java.util.List;
import java.util.Map;

@Repository
public interface ApplyActionDao {

    void applyAction(ActCatalogBeen act);

    List<ActCatalogBeen> selectRecordByCondition(Map<String, Object> map);

    List<ActCatalogBeen> selectRecordNumber(Map<String, Object> map);

    void deleteApply(String keyid);

    List<ActClassBeen> selectAllActClass();
}
