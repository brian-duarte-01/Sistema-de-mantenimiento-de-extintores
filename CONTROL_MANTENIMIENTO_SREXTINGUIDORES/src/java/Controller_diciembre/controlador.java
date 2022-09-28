package Controller_diciembre;

import Config.conexion;
import entidad_diciembre.diciembre;
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

    @RequestMapping("ldiciembre.htm")
    public ModelAndView listar() {
        String sql = "select * from c_diciembre";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_diciembre");
        return mav;
    }

    @RequestMapping(value = "adiciembre.htm", method = RequestMethod.GET)
    public ModelAndView nuevo() {
        mav.addObject(new diciembre());
        mav.setViewName("C_diciembre");
        return mav;
    }

    @RequestMapping(value = "adiciembre.htm", method = RequestMethod.POST)
    public ModelAndView nuevo(diciembre d) {
        String sql = "insert into c_diciembre(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql, d.getId(), d.getNombre(), d.getValor(), d.getFecha(), d.getStatus());
        return new ModelAndView("redirect:/ldiciembre.htm");
    }

    int id;
    List datos;

    @RequestMapping(value = "udiciembre.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from c_diciembre where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_diciembre");
        return mav;
    }

    @RequestMapping(value = "udiciembre.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(diciembre d) {
        String sql = "update c_diciembre set nombre=?, valor=?, fecha=?, status=? where id=" + id;
        this.jdbcTemplate.update(sql, d.getNombre(), d.getValor(), d.getFecha(), d.getStatus());
        return new ModelAndView("redirect:/ldiciembre.htm");
    }

    @RequestMapping("ddiciembre.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from c_diciembre where id=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/ldiciembre.htm");
    }

    @RequestMapping("rdiciembre.htm")
    public ModelAndView reporte() {
        String sql = "select id, nombre, valor, fecha, status from c_diciembre order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_diciembre");
        return mav;
    }
}
