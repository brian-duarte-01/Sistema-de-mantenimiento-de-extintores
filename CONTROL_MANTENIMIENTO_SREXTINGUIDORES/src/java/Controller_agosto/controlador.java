package Controller_agosto;

import Config.conexion;
import entidad_agosto.agosto;
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

    @RequestMapping("lagosto.htm")
    public ModelAndView listar() {
        String sql = "select * from c_agosto";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_agosto");
        return mav;

    }

    @RequestMapping(value = "aagosto.htm", method = RequestMethod.GET)
    public ModelAndView agregar() {
        mav.addObject(new agosto());
        mav.setViewName("C_agosto");
        return mav;
    }

    @RequestMapping(value = "aagosto.htm", method = RequestMethod.POST)
    public ModelAndView agregar(agosto a) {
        String sql = "insert into c_agosto(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql, a.getId(), a.getNombre(), a.getValor(), a.getFecha(), a.getStatus());
        return new ModelAndView("redirect:/lagosto.htm");
    }

    int id;
    List datos;

    @RequestMapping(value = "uagosto.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from c_agosto where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_agosto");
        return mav;
    }

    @RequestMapping(value = "uagosto.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(agosto a) {
        String sql = "update c_agosto set nombre=?, valor=?, fecha=?, status=? where id=" + id;
        this.jdbcTemplate.update(sql, a.getNombre(), a.getValor(), a.getFecha(), a.getStatus());
        return new ModelAndView("redirect:/lagosto.htm");
    }

    @RequestMapping("dagosto.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from c_agosto where id=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/lagosto.htm");
    }

    @RequestMapping("ragosto.htm")
    public ModelAndView reporte() {
        String sql = "select id, nombre, valor, fecha, status from c_agosto order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_agosto");
        return mav;
    }
}
