package Controller_julio;

import Config.conexion;
import entidad_julio.julio;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {

    ModelAndView mav = new ModelAndView();
    conexion con = new conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.conectar());

    @RequestMapping("ljulio.htm")
    public ModelAndView listar() {
        String sql = "select * from c_julio";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_julio");
        return mav;
    }

    @RequestMapping(value = "ajulio.htm", method = RequestMethod.GET)
    public ModelAndView agregar() {
        mav.addObject(new julio());
        mav.setViewName("C_julio");
        return mav;
    }

    @RequestMapping(value = "ajulio.htm", method = RequestMethod.POST)
    public ModelAndView agregar(julio j) {
        String sql = "insert into c_julio(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql, j.getId(), j.getNombre(), j.getValor(), j.getFecha(), j.getStatus());
        return new ModelAndView("redirect:/ljulio.htm");
    }

    int id;
    List datos;

    @RequestMapping(value = "ujulio.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from c_julio where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_julio");
        return mav;
    }

    @RequestMapping(value = "ujulio.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(julio j) {
        String sql = "update c_julio set nombre=?, valor=?, fecha=?, status=? where id=" + id;
        this.jdbcTemplate.update(sql, j.getNombre(), j.getValor(), j.getFecha(), j.getStatus());
        return new ModelAndView("redirect:/ljulio.htm");
    }

    @RequestMapping("djulio.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from c_julio where id=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/ljulio.htm");
    }
    
    
    @RequestMapping("rjulio.htm")
    public ModelAndView reporte(){
        String sql ="select id, nombre, valor, fecha, status from c_julio order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_julio");
        return mav;
    }

}
