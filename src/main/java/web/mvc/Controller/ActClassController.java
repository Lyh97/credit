package web.mvc.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.mvc.Been.ActClassBeen;
import web.mvc.Service.ActClassService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ActClassController {

    @Resource
    ActClassService service;

    @ResponseBody
    @RequestMapping(value = "/stu/selectClass", method = GET)
    public JSONObject selectAllActClass(){
        JSONObject json = new JSONObject();
        List<ActClassBeen> list = new ArrayList<ActClassBeen>();
        try {
            list = service.selectAllActClass();
        } catch (Exception e) {
            json.put("code", 202);
            return json;
        }
        if (list.size() == 0)
        {
            json.put("code",201);
            return json;
        }
        json.put("code",200);
        json.put("aactclass",list);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/addClass", method = POST)
    public JSONObject addClass(@RequestBody String info) {
        JSONObject json = new JSONObject();

        ActClassBeen act = JSON.parseObject(info,ActClassBeen.class);

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        act.setCreattime(sf.format(date));
        act.setKeyid(UUID.randomUUID().toString().replace("_",""));
        act.setStatus(0);
        try {
            service.addClass(act);
        } catch(Exception e) {
            json.put("code",201);
            return json;
        }
        json.put("code",200);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/updateClass", method = POST)
    public JSONObject updateClass(@RequestBody String info) {
        JSONObject json = new JSONObject();
        try{
            service.updateClass(JSON.parseObject(info,ActClassBeen.class));
        } catch(Exception e){
            json.put("code",201);
            return json;
        }
        json.put("code",200);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/deleteClass", method = POST)
    public JSONObject deleteClass(@RequestBody String info) {
        JSONObject json = new JSONObject();
        try{
            service.deleteClass(JSON.parseObject(info,ActClassBeen.class));
        } catch(Exception e){
            json.put("code",201);
            return json;
        }
        json.put("code",200);
        return json;
    }
}
