package web.mvc.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.mvc.Been.ActCatalogBeen;
import web.mvc.Been.ActClassBeen;
import web.mvc.Service.ActClassService;
import web.mvc.Service.ApplyActionService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ApplyActionController {

    @Resource
    ApplyActionService service;
    @Resource
    ActClassService classservice;

    @ResponseBody
    @RequestMapping(value="/stu/apply",method = POST)
    public JSONObject applyActionController(@RequestBody String applyFrom){

        JSONObject json = new JSONObject();
        ActCatalogBeen act = JSON.parseObject(applyFrom, ActCatalogBeen.class);

        String keyid = UUID.randomUUID().toString().replace("_","");
        act.setKeyid(keyid);
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd  hh:MM:ss");
        act.setCreattime(dateformat.format(date));
        act.setActgrade(classservice.selectGradeByName(act.getActtype()));
        act.setUserKeyid(act.getUserKeyid().replace(" ",""));
        act.setStatus("0");


        try {
            service.applyAction(act);
        } catch(Exception e){
            json.put("code","400");
            json.put("message","ok");
            return json;
        }
        json.put("code","200");
        json.put("message","ok");
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/stu/record",method = POST)
    public JSONObject applyRecordController(@RequestBody String search){

        JSONObject json = new JSONObject();

        String startime , endtime;
        int page;

        List<ActCatalogBeen> been = new ArrayList<ActCatalogBeen>();

        if(JSON.parseObject(search).get("mindate") == null || JSON.parseObject(search).get("mindate").equals(""))
        {
            startime = "2018-01-01 00:00:00";
        } else startime = JSON.parseObject(search).get("mindate").toString()+" 00:00:00";
        if(JSON.parseObject(search).get("maxdate") == null || JSON.parseObject(search).get("maxdate").equals(""))
        {
            endtime = "2099-12-31 23:59:59";
        } else endtime = JSON.parseObject(search).get("maxdate").toString()+" 12:59:59";
        if(JSON.parseObject(search).get("page") == null || JSON.parseObject(search).get("page").equals(""))
        {
            page = 1;
        } else page = Integer.valueOf(JSON.parseObject(search).get("page").toString());

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("mintime", startime);
        map.put("maxtime", endtime);
        map.put("actName", JSON.parseObject(search).get("actname").toString());
        map.put("page",(page-1)*8);
        map.put("userKeyid",JSON.parseObject(search).get("userKeyid").toString());
        try {
           been = service.selectRecordByCondition(map);
        } catch(Exception e){
            json.put("code","400");
            json.put("message",e.toString());
            return json;
        }
        json.put("code","200");
        json.put("message","ok");
        json.put("date",been);
        json.put("title",service.selectRecordNumber(map).size());
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/deleteApplyByKeyid", method = POST)
    public JSONObject deleteApply(@RequestBody String deleteKeyid){
        String keyid = JSON.parseObject(deleteKeyid).get("keyid").toString();
        JSONObject json = new JSONObject();
        try {
            service.deleteApply(keyid);
        } catch (Exception e) {
            json.put("code", 201);
            return json;
        }
        json.put("code",200);
        return json;
    }
}
