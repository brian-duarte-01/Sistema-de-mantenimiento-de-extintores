package Controller_proveedores;

import Config.conexion;
import entidad_proveedores.proveedores;
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

    @RequestMapping(value = "lproveedores.htm", method = RequestMethod.GET)
    public ModelAndView listar() {
        String sql = "select * from proveedores";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_proveedores");
        return mav;
    }

    public ModelAndView agregar() {
        mav.addObject(new proveedores());
        mav.setViewName("R_proveedores");
        return mav;
    }

    @RequestMapping(value = "lproveedores.htm", method = RequestMethod.POST)
    public ModelAndView agregar(proveedores p) {
        String sql = "insert into proveedores(correlativo,nombre,calle,avenida,zona,telefono,correo)values(?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql, p.getCorrelativo(), p.getNombre(), p.getCalle(), p.getAvenida(), p.getZona(), p.getTelefono(), p.getCorreo());
        return new ModelAndView("redirect:/lproveedores.htm");
    }

    int id;
    List datos;

    @RequestMapping(value = "aproveedores.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from proveedores where correlativo=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_proveedores");
        return mav;
    }

    @RequestMapping(value = "aproveedores.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(proveedores p) {
        String sql = "update proveedores set nombre=?, calle=?,avenida=?,zona=?,telefono=?,correo=? where correlativo=" + id;
        this.jdbcTemplate.update(sql, p.getNombre(), p.getCalle(), p.getAvenida(), p.getZona(), p.getTelefono(), p.getCorreo());
        return new ModelAndView("redirect:/lproveedores.htm");
    }

    @RequestMapping("dproveedores.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from proveedores where correlativo=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/lproveedores.htm");
    }

    @RequestMapping("rproveedores.htm")
    public ModelAndView reporte() {
        String sql = "select correlativo,nombre,calle,avenida,zona,telefono,correo from proveedores order by nombre";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_proveedores");
        return mav;
    }
}
