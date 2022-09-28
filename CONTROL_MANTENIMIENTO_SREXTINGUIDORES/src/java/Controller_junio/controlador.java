package Controller_junio;

import Config.conexion;
import entidad_junio.junio;
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

    @RequestMapping("ljunio.htm")
    public ModelAndView listar() {
        String sql = "select * from c_junio";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_junio");
        return mav;
    }
    
    @RequestMapping("rjunio.htm")
    public ModelAndView reporte(){
        String sql ="select id, nombre, valor, fecha, status from c_junio order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_junio");
        return mav;
    }

    @RequestMapping(value = "ajunio.htm", method = RequestMethod.GET)
    public ModelAndView agregar() {
        mav.addObject(new junio());
        mav.setViewName("C_junio");
        return mav;
    }
    @RequestMapping(value = "ajunio.htm", method = RequestMethod.POST)
    public ModelAndView agregar(junio j){
        String sql= "insert into c_junio(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql,j.getId(),j.getNombre(),j.getValor(),j.getFecha(),j.getStatus());
        return new ModelAndView("redirect:/ljunio.htm");
        
    }
    
     int id;
    List datos;
    @RequestMapping(value = "ujunio.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="select * from c_junio where id="+id;
        datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("U_junio");
        return mav;
    }
    @RequestMapping(value = "ujunio.htm", method = RequestMethod.POST)
     public ModelAndView actualizar(junio j){
     String sql="update c_junio set nombre=?, valor=?, fecha=?, status=? where id="+id;
     this.jdbcTemplate.update(sql,j.getNombre(),j.getValor(),j.getFecha(),j.getStatus());
     return new ModelAndView("redirect:/ljunio.htm");
     }
     
     
     @RequestMapping("djunio.htm")
     public ModelAndView eliminar(HttpServletRequest request){
         id=Integer.parseInt(request.getParameter("id"));
         String sql="delete from c_junio where id="+id;
         this.jdbcTemplate.update(sql);
         return new ModelAndView("redirect:/ljunio.htm");
     }
    
    


}
