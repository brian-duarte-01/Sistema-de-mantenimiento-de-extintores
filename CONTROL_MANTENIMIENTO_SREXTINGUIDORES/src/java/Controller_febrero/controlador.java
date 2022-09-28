package Controller_febrero;

import Config.conexion;
import entidad_febrero.febrero;
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
    JdbcTemplate jbctemplate = new JdbcTemplate(con.conectar());
    ModelAndView mav = new ModelAndView();

    //paso 1 metodo para listar datos
    @RequestMapping("lfebrero.htm")
    public ModelAndView listar() {
        String sql = "select * from c_febrero";
        List datos = this.jbctemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_febrero");
        return mav;

    }
    
    @RequestMapping("rfebrero.htm")
     public ModelAndView reporte() {
        String sql = "select id, nombre, valor, fecha, status from c_febrero order by fecha";
        List datos = this.jbctemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_febrero");
        return mav;

    }
    
    //paso 2 metodo para Agregar datos
    
    @RequestMapping(value = "cfebrero.htm", method = RequestMethod.GET)
    public ModelAndView agregar(){
        mav.addObject(new febrero());
        mav.setViewName("C_febrero");
        return mav;
    }
    
    @RequestMapping(value = "cfebrero.htm", method = RequestMethod.POST)
    public ModelAndView agregar(febrero f){
        String sql="insert into c_febrero(id, nombre, valor, fecha, status)values(?,?,?,?,?)";
        this.jbctemplate.update(sql,f.getId(),f.getNombre(),f.getValor(),f.getFecha(),f.getStatus());
        return new ModelAndView("redirect:/lfebrero.htm");
    }
    
    //paso3 metodo para actualizar datos
    
    int id;
    List datos;
    
    @RequestMapping(value = "ufebrero.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="select * from c_febrero where id="+id;
        datos=this.jbctemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("U_febrero");
        return mav;
    }
    @RequestMapping(value = "ufebrero.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(febrero f){
        String sql="update c_febrero set nombre=?, valor=?, fecha=?, status=? where id="+id;
        this.jbctemplate.update(sql,f.getNombre(),f.getValor(),f.getFecha(),f.getStatus());
        return new ModelAndView("redirect:/lfebrero.htm");
    }
    
    
    //paso 4 metodo de eliminar datos de la base de datos 
    
    @RequestMapping("dfebrero.htm")
    public ModelAndView eliminar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="delete from c_febrero where id="+id;
        this.jbctemplate.update(sql);
        return new ModelAndView("redirect:/lfebrero.htm");
    }
    
}
