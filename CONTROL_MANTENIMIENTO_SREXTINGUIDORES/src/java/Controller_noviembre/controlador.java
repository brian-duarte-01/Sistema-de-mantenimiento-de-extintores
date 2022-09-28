package Controller_noviembre;

import Config.conexion;
import entidad_noviembre.noviembre;
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

    @RequestMapping("lnoviembre.htm")
    public ModelAndView listar() {
        String sql = "select * from c_noviembre";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_noviembre");
        return mav;
    }

    @RequestMapping(value = "anoviembre.htm", method = RequestMethod.GET)
    public ModelAndView nuevo() {
        mav.addObject(new noviembre());
        mav.setViewName("C_noviembre");
        return mav;
    }

    @RequestMapping(value = "anoviembre.htm", method = RequestMethod.POST)
    public ModelAndView nuevo(noviembre n) {
        String sql = "insert into c_noviembre(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql, n.getId(), n.getNombre(), n.getValor(), n.getFecha(), n.getStatus());
        return new ModelAndView("redirect:/lnoviembre.htm");
    }

    int id;
    List datos;

    @RequestMapping(value = "unoviembre.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from c_noviembre where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_noviembre");
        return mav;
    }

    @RequestMapping(value = "unoviembre.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(noviembre n) {
        String sql = "update c_noviembre set nombre=?, valor=?, fecha=?, status=? where id=" + id;
        this.jdbcTemplate.update(sql, n.getNombre(), n.getValor(), n.getFecha(), n.getStatus());
        return new ModelAndView("redirect:/lnoviembre.htm");
    }

    @RequestMapping("dnoviembre.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from c_noviembre where id=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/lnoviembre.htm");
    }

    @RequestMapping("rnoviembre.htm")
    public ModelAndView reporte() {
        String sql = "select id, nombre, valor, fecha, status from c_noviembre order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_noviembre");
        return mav;
    }

}
