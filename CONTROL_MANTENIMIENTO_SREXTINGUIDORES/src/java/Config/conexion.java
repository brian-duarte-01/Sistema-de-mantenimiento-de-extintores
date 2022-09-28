
package Config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class conexion {
    public DriverManagerDataSource conectar(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
      dataSource.setUsername("SREXTINGUIDORES");
      dataSource.setPassword("123");
      return dataSource;
      
    }
}
