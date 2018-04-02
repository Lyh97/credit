package web.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.mvc.Been.MenuBeen;
import web.mvc.Been.UserBeen;
import web.mvc.Service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

    @Resource
    LoginService service;

    @ResponseBody
    @RequestMapping(value = "/login",method = POST)
    public UserBeen login(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserBeen user = new UserBeen();
        user.setUsername(username);
        user.setPassword(password);

        UserBeen users = service.loginCheck(user);

        if(users == null || users.equals("") || !users.getUsername().equals(username)){
            response.setStatus(202);
            return null;
        }
        if(!users.getPassword().equals(password)) {
            response.setStatus(203);
            return null;
        }
        return users;
    }

    @PostMapping(value = "/register")
    public String register(HttpServletRequest request, HttpServletResponse response){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String tele = request.getParameter("tele");

        UserBeen user = new UserBeen();

        user.setKeyid(UUID.randomUUID().toString().replace("-",""));
        user.setUsername(username);
        user.setPassword(password);
        user.setTelephone(tele);
        user.setRole("2");
        user.setName(name);
        user.setGrade(0);

        if(service.loginCheck(user)!=null){
            response.setStatus(303);
            return null;
        }
        service.addUser(user);
        return null;
    }

    @ResponseBody
    @RequestMapping(value="/getmenu")
    public List<MenuBeen> getMenu(HttpServletRequest request) {
        String keyid = request.getParameter("keyid");
        keyid = keyid.replace(" ", "");
        System.out.println(keyid);

        List<MenuBeen> menu = service.selectMenuByUserRole(keyid);
        return menu;
    }
}
