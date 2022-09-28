package Controller_septiembre;

import Config.conexion;
import entidad_septiembre.septiembre;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controlador {

    conexion con = new conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.conectar());
    ModelAndView mav = new ModelAndView();

    @RequestMapping("lseptiembre.htm")
    public ModelAndView listar() {
        String sql = "select * from c_septiembre";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_septiembre");
        return mav;
    }

    @RequestMapping(value = "cseptiembre.htm", method = RequestMethod.GET)
    public ModelAndView nuevo() {
        mav.addObject(new septiembre());
        mav.setViewName("C_septiembre");
        return mav;
    }

    @RequestMapping(value = "cseptiembre.htm", method = RequestMethod.POST)
    public ModelAndView nuevo(septiembre s) {
        String sql = "insert into c_septiembre(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql, s.getId(), s.getNombre(), s.getValor(), s.getFecha(), s.getStatus());
        return new ModelAndView("redirect:/lseptiembre.htm");
    }

    int id;
    List datos;

    @RequestMapping(value = "aseptiembre.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from c_septiembre where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_septiembre");
        return mav;
    }

    @RequestMapping(value = "aseptiembre.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(septiembre s) {
        String sql = "update c_septiembre set nombre=?, valor=?, fecha=?, status=? where id=" + id;
        this.jdbcTemplate.update(sql, s.getNombre(), s.getValor(), s.getFecha(), s.getStatus());
        return new ModelAndView("redirect:/lseptiembre.htm");
    }

    @RequestMapping("dseptiembre.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from c_septiembre where id=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/lseptiembre.htm");
    }

    @RequestMapping("rseptiembre.htm")
    public ModelAndView reporte() {
        String sql = "select id, nombre, valor, fecha, status from c_septiembre order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_septiembre");
        return mav;
    }

}
