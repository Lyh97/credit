package web.mvc.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.mvc.Been.UserBeen;
import web.mvc.Service.UserService;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @Resource
    UserService service;

    @ResponseBody
    @RequestMapping(value = "/stu/selectAllUser", method = POST)
    public JSONObject selectAllUser(@RequestBody String info) {
        JSONObject json = new JSONObject();
        List<UserBeen> list = new ArrayList<UserBeen>();
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("name", JSON.parseObject(info).get("name").toString());
        try{
            list = service.selectAllUser(map);
        } catch(Exception e) {
            json.put("code",201);
            return json;
        }
        json.put("code",200);
        json.put("data",list);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/deleteUserBykeyid", method = POST)
    public JSONObject deleteUserBykeyid(@RequestBody String info) {
        JSONObject json = new JSONObject();
        List<UserBeen> list = new ArrayList<UserBeen>();
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("keyid", JSON.parseObject(info).get("keyid").toString());
        try{
            service.deleteUserBykeyid(map);
            service.deleteActCatalogStatus0Bykeyid(map);
            service.deleteActPersonBykeyid(map);
        } catch(Exception e) {
            json.put("code",201);
            return json;
        }
        json.put("code",200);
        json.put("data",list);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/updateUserBykeyid", method = POST)
    public JSONObject updateUserBykeyid(@RequestBody String info) {
        JSONObject json = new JSONObject();
        List<UserBeen> list = new ArrayList<UserBeen>();
        UserBeen user = JSON.parseObject(info,UserBeen.class);

        try{
            service.updateUserBykeyid(user);
        } catch(Exception e) {
            json.put("code",201);
            return json;
        }
        json.put("code",200);
        json.put("data",list);
        return json;
    }
}
