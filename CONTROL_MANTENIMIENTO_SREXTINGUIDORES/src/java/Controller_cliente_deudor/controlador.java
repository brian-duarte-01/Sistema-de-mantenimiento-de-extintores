package Controller_cliente_deudor;

import Config.conexion;
import entidad_cliente_deudor.cliente_deudor;
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
    ModelAndView mav = new ModelAndView();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.conectar());

    @RequestMapping(value = "ldeudor.htm", method = RequestMethod.GET)
    public ModelAndView listar() {
        String sql = "select * from cli_deudor";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("R_C_cliente_deudor");
        return mav;
    }

    public ModelAndView agregar() {
        mav.addObject(new cliente_deudor());
        mav.setViewName("R_C_cliente_deudor");
        return mav;
    }

    @RequestMapping(value = "ldeudor.htm", method = RequestMethod.POST)

    public ModelAndView agregar(cliente_deudor c) {
        String sql = "insert into cli_deudor(id,no_factura,nombre,fecha,total,status)values(?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql, c.getId(), c.getNo_factura(), c.getNombre(), c.getFecha(), c.getTotal(), c.getStatus());
        return new ModelAndView("redirect:/ldeudor.htm");
    }

    int id;
    List datos;

    @RequestMapping(value = "adeudor.htm", method = RequestMethod.GET)
    public ModelAndView actualizar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from cli_deudor where id=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("U_deudor");
        return mav;
    }

    @RequestMapping(value = "adeudor.htm", method = RequestMethod.POST)
    public ModelAndView actualizar(cliente_deudor c) {
        String sql = "update cli_deudor set no_factura=?,nombre=?, fecha=?, total=?, status=? where id=" + id;
        this.jdbcTemplate.update(sql, c.getNo_factura(), c.getNombre(), c.getFecha(), c.getTotal(), c.getStatus());
        return new ModelAndView("redirect:/ldeudor.htm");
    }

    @RequestMapping("ddeudor.htm")
    public ModelAndView eliminar(HttpServletRequest req) {
        id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from cli_deudor where id=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/ldeudor.htm");
    }
    
    @RequestMapping("rdeudor.htm")
    public ModelAndView reporte() {
        String sql = "select id, no_factura, nombre,fecha,total,status from cli_deudor where status like('%PENDIENTE%')";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_deudor");
        return mav;
    }
    
     @RequestMapping("redeudor.htm")
    public ModelAndView reporter() {
        String sql = "select id, no_factura, nombre,fecha,total,status from cli_deudor where status like('%PAGADO%')";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("RE_deudor_pagado");
        return mav;
    }

}
