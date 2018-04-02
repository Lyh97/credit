package web.mvc.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.mvc.Been.ActCatalogBeen;
import web.mvc.Service.ActCatalogService;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ActCatalogController {

    @Resource
    ActCatalogService service;

    @ResponseBody
    @RequestMapping(value = "/stu/selectActive", method = POST)
    public JSONObject selectActive(@RequestBody String info){
        JSONObject list = new JSONObject();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("keyid",JSON.parseObject(info).get("keyid").toString().replace(" ",""));
        map.put("page",8*(Integer.valueOf(JSON.parseObject(info).get("page").toString())-1));

        List<ActCatalogBeen> actList = service.selectActive(map);
        list.put("data",actList);
        list.put("pages",service.selectAll(map));
        list.put("code",200);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/selectAllStatus0", method = GET)
    public JSONObject selectAllStatus0() {

        JSONObject json = new JSONObject();
        List<ActCatalogBeen> list = new ArrayList<ActCatalogBeen>();
        try {
            list = service.selectAllStatus0();
        } catch (Exception e) {
            json.put("code",201);
        }
        json.put("code",200);
        json.put("data",list);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/updateStatus" , method = POST)
    public JSONObject updateStatus(@RequestBody String info) {
        JSONObject json = new JSONObject();

        ActCatalogBeen been = JSON.parseObject(info,ActCatalogBeen.class);
        try {
            service.updateStatus(been);
        } catch(Exception e) {
            json.put("code",201);
        }
        json.put("code",200);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/finishApplyByKeyid" , method = POST)
    public JSONObject finishApplyByKeyid(@RequestBody String info){
        JSONObject json = new JSONObject();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("keyid",JSON.parseObject(info).get("keyid").toString());

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        map.put("date",sf.format(date));

        try {
            service.updateStatus2(map);
            service.insertFinishtimeInPerson(map);
        } catch(Exception e) {
            json.put("code",201);
        }
        json.put("code",200);
        return json;
    }

}
