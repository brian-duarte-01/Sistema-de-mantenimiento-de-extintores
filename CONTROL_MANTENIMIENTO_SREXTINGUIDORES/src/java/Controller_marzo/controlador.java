
package Controller_marzo;

import Config.conexion;
import entidad_marzo.marzo;
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
    @RequestMapping("lmarzo.htm")
    public ModelAndView listar(){
        String sql ="select * from c_marzo";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("R_marzo");
        return mav;  
    }
    @RequestMapping("rmarzo.htm")
    public ModelAndView reporte(){
        String sql ="select id, nombre, valor, fecha, status from c_marzo order by fecha";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("RE_marzo");
        return mav;  
    }
    //paso 2 metodo para Agregar datos
    @RequestMapping(value = "cmarzo.htm", method= RequestMethod.GET)
    public ModelAndView agregar(){
        mav.addObject(new marzo());
        mav.setViewName("C_marzo");
        return mav; 
    }
    @RequestMapping(value = "cmarzo.htm", method = RequestMethod.POST)
    public ModelAndView agregar(marzo m){
        String sql="insert into c_marzo(id,nombre,valor,fecha,status)values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql,m.getId(),m.getNombre(),m.getValor(),m.getFecha(),m.getStatus());
        return new ModelAndView("redirect:/lmarzo.htm");
    }
    //paso3 metodo para actualizar datos
    int id;
    List datos;
    @RequestMapping(value = "umarzo.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="select * from c_marzo where id="+id;
        datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("U_marzo");
        return mav;
    }
    @RequestMapping(value = "umarzo.htm", method = RequestMethod.POST)
     public ModelAndView actualizar(marzo m){
         String sql="update c_marzo set nombre=?, valor=?, fecha=?, status=? where id="+id;
         this.jdbcTemplate.update(sql, m.getNombre(),m.getValor(),m.getFecha(),m.getStatus());
         return new ModelAndView("redirect:/lmarzo.htm");
     }
     
      //paso 4 metodo de eliminar datos de la base de datos 
        @RequestMapping("dmarzo.htm")
        public ModelAndView eliminar(HttpServletRequest request){
            id=Integer.parseInt(request.getParameter("id"));
            String sql="delete from c_marzo where id="+id;
            this.jdbcTemplate.update(sql);
            return new ModelAndView("redirect:/lmarzo.htm");
            
        }
    
}
