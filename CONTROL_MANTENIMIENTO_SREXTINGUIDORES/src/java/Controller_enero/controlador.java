package Controller_enero;

import Config.conexion;
import entidad_enero.enero;
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
    @RequestMapping("lenero.htm")
    public ModelAndView listar() {
        String sql = "select * from c_enero";
        List datos = this.jbctemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_enero");
        return mav;

    }
    
     @RequestMapping("reporte.htm")
    public ModelAndView reporte() {
        String sql = "select id, nombre, valor, fecha, status from c_enero order by fecha";
        List datos = this.jbctemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_enero");
        return mav;

    }


    //paso 2 metodo para Agregar datos
    @RequestMapping(value = "cenero.htm", method = RequestMethod.GET)
    public ModelAndView agregar() {
        mav.addObject(new enero());
        mav.setViewName("C_enero");
        return mav;
    }

    @RequestMapping(value = "cenero.htm", method = RequestMethod.POST)
    public ModelAndView agregar(enero e) {
        String sql = "insert into c_enero(id, nombre, valor, fecha, status)values(?,?,?,?,?)";
        this.jbctemplate.update(sql, e.getId(), e.getNombre(), e.getValor(), e.getFecha(), e.getStatus());
        return new ModelAndView("redirect:/lenero.htm");
    }
    
    //paso3 metodo para actualizar datos 
    
    int id;
    List datos;
    
    @RequestMapping(value = "uenero.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="select * from c_enero where id="+id;
        datos=this.jbctemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("U_enero");
        return mav;
    }
    
    @RequestMapping(value = "uenero.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(enero e){
        String sql="update c_enero set nombre=?, valor=?, fecha=?, status=? where id="+id;
        this.jbctemplate.update(sql,e.getNombre(), e.getValor(), e.getFecha(), e.getStatus());
        return new ModelAndView("redirect:/lenero.htm");
    }
    
     //paso 4 metodo de eliminar datos de la base de datos 
    
    @RequestMapping("denero.htm")
    public ModelAndView eliminar(HttpServletRequest request){
        id=Integer.parseInt(request.getParameter("id"));
        String sql="delete from c_enero where id="+id;
        this.jbctemplate.update(sql);
        return new ModelAndView("redirect:/lenero.htm");
        
    }
    
    
    
}
