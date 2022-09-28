package Controller_cliente;

import Config.conexion;
import entidad_cliente.cliente;
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

    @RequestMapping(value = "lcliente.htm", method = RequestMethod.GET)
    public ModelAndView listar() {
        String sql = "select * from clientes";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_cliente");
        return mav;
    }

    public ModelAndView agregar() {
        mav.addObject(new cliente());
        mav.setViewName("R_cliente");
        return mav;
    }
    @RequestMapping(value = "lcliente.htm", method = RequestMethod.POST)
    
    public ModelAndView agregar(cliente c) {
        String sql = "insert into clientes(correlativo,nombre,nit,calle,avenida,zona,telefono,correo)values(?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql,c.getCorrelativo(),c.getNombre(),c.getNit(),c.getCalle(),c.getAvenida(),c.getZona(),c.getTelefono(),c.getCorreo());
        return new ModelAndView("redirect:/lcliente.htm");
    }
       
    
    
    
    int id;
    List datos;

    @RequestMapping(value = "acliente.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from clientes where correlativo=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_cliente");
        return mav;
    }
    
    @RequestMapping(value = "acliente.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(cliente c) {
        String sql = "update clientes set nombre=?, nit=?, calle=?, avenida=?, zona=?, telefono=?, correo=? where correlativo=" + id;
        this.jdbcTemplate.update(sql, c.getNombre(),c.getNit(),c.getCalle(),c.getAvenida(),c.getZona(),c.getTelefono(),c.getCorreo());
        return new ModelAndView("redirect:/lcliente.htm");
    }
    
    
    @RequestMapping("dcliente.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from clientes where correlativo=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/lcliente.htm");
    }
    
       @RequestMapping("rcliente.htm")
    public ModelAndView reporte() {
        String sql = "select correlativo,nombre,nit,calle,avenida,zona,telefono,correo from clientes order by nombre";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_cliente");
        return mav;
    }
    

}
