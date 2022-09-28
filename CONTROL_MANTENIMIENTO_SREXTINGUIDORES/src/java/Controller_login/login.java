package Controller_login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class login {

    ModelAndView mav = new ModelAndView();

    @RequestMapping("login.htm")
    public ModelAndView iniciar(HttpServletRequest req, HttpServletResponse res) {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String trol = req.getParameter("trol");
        
        if(name.equals("brian") && pass.equals("123") && trol.equals("admin")){
            return new ModelAndView("menu");
        }else{
            return new ModelAndView("error");
        }

    }
}
