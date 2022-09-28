package Controller_mayo;

import Config.conexion;
import entidad_mayo.mayo;

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

    //paso 1 metodo para listar datos
    @RequestMapping("lmayo.htm")
    public ModelAndView listar() {
        String sql = "select * from c_mayo";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_mayo");
        return mav;
    }
    
    @RequestMapping("rmayo.htm")
    public ModelAndView reporte(){
        String sql ="select id, nombre, valor, fecha, status from c_mayo order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("RE_mayo");
        return mav;
    }

    //paso 2 metodo para Agregar datos
    @RequestMapping(value = "amayo.htm", method = RequestMethod.GET)
    public ModelAndView agregar() {
        mav.addObject(new mayo());
        mav.setViewName("C_mayo");
        return mav;
    }

    @RequestMapping(value = "amayo.htm", method = RequestMethod.POST)
    public ModelAndView agregar(mayo m) {
        String sql = "insert into c_mayo(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql, m.getId(), m.getNombre(), m.getValor(), m.getFecha(), m.getStatus());
        return new ModelAndView("redirect:/lmayo.htm");
    }

    //paso3 metodo para actualizar datos
    int id;
    List datos;

    @RequestMapping(value = "umayo.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from c_mayo where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_mayo");
        return mav;
    }

    @RequestMapping(value = "umayo.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(mayo m) {
        String sql = "update c_mayo set nombre=?,valor=?,fecha=?,status=? where id=" + id;
        this.jdbcTemplate.update(sql, m.getNombre(), m.getValor(), m.getFecha(), m.getStatus());
        return new ModelAndView("redirect:/lmayo.htm");
    }

    //paso 4 metodo de eliminar datos de la base de datos 
    @RequestMapping("dmayo.htm")
    public ModelAndView eliminar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="delete from c_mayo where id="+id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/lmayo.htm");
        
    }
}
