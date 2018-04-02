package web.mvc.Mapper;

import org.springframework.stereotype.Repository;
import web.mvc.Been.ActCatalogBeen;

import java.util.List;
import java.util.Map;

@Repository
public interface ActCatalogDao {
    List<ActCatalogBeen> selectActive(Map<String, Object> map);

    int selectAll(Map<String, Object> map);

    List<ActCatalogBeen> selectAllStatus0();

    void updateStatus(ActCatalogBeen been);

    void updateStatus2(Map<String, Object> map);

    void insertFinishtimeInPerson(Map<String, Object> map);
}
