package Controller_abril;

import Config.conexion;
import Entidad_abril.abril;
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
    @RequestMapping("labril.htm")
    public ModelAndView listar() {
        String sql = "select * from c_abril";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_abril");
        return mav;
    }
    
      @RequestMapping("rabril.htm")
    public ModelAndView reporte() {
        String sql = "select id, nombre, valor, fecha, status from c_abril order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_abril");
        return mav;
    }

    //paso 2 metodo para Agregar datos
    @RequestMapping(value = "cabril.htm", method = RequestMethod.GET)
    public ModelAndView agregar() {
        mav.addObject(new abril());
        mav.setViewName("C_abril");
        return mav;
    }

    @RequestMapping(value = "cabril.htm", method = RequestMethod.POST)
    public ModelAndView agregar(abril a) {
        String sql = "insert into c_abril(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql, a.getId(), a.getNombre(), a.getValor(), a.getFecha(), a.getStatus());
        return new ModelAndView("redirect:/labril.htm");
    }

    //paso3 metodo para actualizar datos
    int id;
    List datos;

    @RequestMapping(value = "uabril.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from c_abril where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_abril");
        return mav;
    }

    @RequestMapping(value = "uabril.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(abril a) {
        String sql = "update c_abril set nombre=?, valor=?, fecha=?, status=? where id=" + id;
        this.jdbcTemplate.update(sql, a.getNombre(), a.getValor(), a.getFecha(), a.getStatus());
        return new ModelAndView("redirect:/labril.htm");
    }

    //paso 4 metodo de eliminar datos de la base de datos
    @RequestMapping("dabril.htm")
    public ModelAndView eliminar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="delete from c_abril where id="+id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/labril.htm");
    }
}
