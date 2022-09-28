package Controller_octubre;

import Config.conexion;
import entidad_octubre.octubre;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controlador {

    ModelAndView mav = new ModelAndView();
    conexion con = new conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.conectar());

    @RequestMapping("loctubre.htm")
    public ModelAndView listar() {
        String sql = "select * from c_octubre";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_octubre");
        return mav;
    }

    @RequestMapping(value = "aoctubre.htm", method = RequestMethod.GET)
    public ModelAndView nuevo() {
        mav.addObject(new octubre());
        mav.setViewName("C_octubre");
        return mav;
    }

    @RequestMapping(value = "aoctubre.htm", method = RequestMethod.POST)
    public ModelAndView nuevo(octubre o) {
        String sql = "insert into c_octubre(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql, o.getId(), o.getNombre(), o.getValor(), o.getFecha(), o.getStatus());
        return new ModelAndView("redirect:/loctubre.htm");
    }

    int id;
    List datos;

    @RequestMapping(value = "uoctubre.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from c_octubre where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_octubre");
        return mav;
    }

    @RequestMapping(value = "uoctubre.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(octubre o) {
        String sql = "update c_octubre set nombre=?, valor=?, fecha=?, status=? where id=" + id;
        this.jdbcTemplate.update(sql, o.getNombre(), o.getValor(), o.getFecha(), o.getStatus());
        return new ModelAndView("redirect:/loctubre.htm");
    }

    @RequestMapping("doctubre.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from c_octubre where id=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/loctubre.htm");
    }
    
      @RequestMapping("roctubre.htm")
    public ModelAndView reporte() {
        String sql = "select id, nombre, valor, fecha, status from c_octubre order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_octubre");
        return mav;
    }

}
