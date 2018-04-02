package web.mvc.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.mvc.Been.ActFinishBeen;
import web.mvc.Been.UserBeen;
import web.mvc.Service.ActPersonService;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ActPersonController {

    @Resource
    ActPersonService service;

    @ResponseBody
    @RequestMapping(value="/stu/addPerson",method = POST)
    public JSONObject addPerson(@RequestBody String info) throws ParseException {

        JSONObject json = new JSONObject();
        ActFinishBeen been = JSON.parseObject(info,ActFinishBeen.class);

        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        String now = dateformat.format(date);
        String enrollmentTime = service.selectEnrollmentTimeBystukeyid(been.getStukeyid().replace(" ",""));

        if(been.getInfo01() >= service.selectActNumber(been.getActivekeyid())) {
            been.setKeyid(UUID.randomUUID().toString().replace("_",""));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            long m = sdf.parse(now).getTime() - sdf.parse(enrollmentTime).getTime();
            been.setInfo02("第"+String.valueOf((int)((m / (1000 * 60 * 60 * 24))/182))+"学期");
            been.setStukeyid(been.getStukeyid().replace(" ",""));
            List<UserBeen> user = service.selectUserBykeyid(been.getStukeyid().replace(" ",""));
            been.setName(user.get(0).getName());
            been.setSex(user.get(0).getSex());
            been.setJointime(now);
            try {
                service.addPerson(been);
            } catch (Exception e){
                json.put("code",201);
                return json;
            }
            json.put("code",200);
            return json;
        }
        json.put("code",202);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/stu/selectPersonByUserid",method = POST)
    public JSONObject selectByUserid(@RequestBody String info) {
        JSONObject list = new JSONObject();
        String keyid = JSON.parseObject(info).get("keyid").toString().replace(" ","");
        int ok = 0,no = 0;
        String name;
        List<ActFinishBeen> actperson = new ArrayList<ActFinishBeen>();
        try {
            name = service.selectUserNameBykeyid(keyid);
            actperson = service.selectActByUserKeyid(keyid);
            if (actperson.size() > 0) {
                for (int i = 0; i < actperson.size(); i++) {
                    if (actperson.get(i).getFinishtime() == null || actperson.get(i).getFinishtime().equals("")) no++;
                    else ok++;
                }
            }
        } catch (Exception e) {
            list.put("code", 202);
            return list;
        }

        list.put("code",200);
        list.put("actperson",actperson);
        list.put("username",name);
        list.put("ok",ok);
        list.put("no",no);
        return list;
    }

    @ResponseBody
    @RequestMapping(value="/stu/selectStuGrade",method = POST)
    public JSONObject selectStuGrade(@RequestBody String info) {
        JSONObject list = new JSONObject();
        Double[] data =new Double [8];
        String keyid = JSON.parseObject(info).get("keyid").toString().replace(" ","");
        double sum = 0;
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("keyid",keyid);
        List<ActFinishBeen> finish = service.selectGradeByStuKeyid(map);

        for(int i=0; i<8;i++) {
            String a = "第"+(i+1)+"学期";
            for(int j=0;j<finish.size();j++) {
                if (finish.get(j).getInfo02().equals(a)) {
                    data[i] = finish.get(j).getActivegrade();
                    break;
                }
                data[i] = 0.0;
            }
            if(finish.size()==0) data[i] = 0.0;
            sum += data[i];
        }
        list.put("name",service.selectUserNameBykeyid(keyid));
        list.put("code",200);
        list.put("sum",sum);
        list.put("data",data);
        return list;
    }

    @ResponseBody
    @RequestMapping(value="/stu/selectJoinPerson",method = POST)
    public JSONObject selectJoinPersonByActkeyid(@RequestBody String info){
        JSONObject list = new JSONObject();

        String actkeyid = JSON.parseObject(info).get("keyid").toString();

        Map<Object,String> map = new HashMap<Object, String>();
        map.put("actkeyid",actkeyid);

        List<ActFinishBeen> datas = service.selectJoinPersonByActkeyid(map);

        list.put("code",200);
        list.put("data",datas);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/deleteJoinByStuKeyid" , method = POST)
    public JSONObject deleteJoinByStuKeyid(@RequestBody String info){
        String stukeyid = JSON.parseObject(info).get("stukeyid").toString();
        String activekeyid = JSON.parseObject(info).get("activekeyid").toString();

        Map<Object ,String> map = new HashMap<Object ,String>();
        map.put("stukeyid",stukeyid);
        map.put("activekeyid",activekeyid);

        JSONObject json = new JSONObject();
        try {
            service.deleteJoinByStuKeyid(map);
        } catch (Exception e) {
            json.put("code", 201);
            return json;
        }
        json.put("code",200);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/stu/selectPersonGrade", method = POST)
    public JSONObject selectPersonGrade(@RequestBody String info) {
        JSONObject json = new JSONObject();
        String name = JSON.parseObject(info).get("stuname").toString();
        ActFinishBeen be = new ActFinishBeen();
        be.setName(name);
        List<ActFinishBeen> list = new ArrayList<ActFinishBeen>();
        try{
            list = service.selectPersonGrade(be);
        } catch(Exception e) {
            json.put("code",201);
            System.out.println(e.getMessage());
            return json;
        }
        if(list.size()!=0) Collections.sort(list, list.get(0));
        json.put("code",200);
        json.put("data",list);
        return json;
    }
}
