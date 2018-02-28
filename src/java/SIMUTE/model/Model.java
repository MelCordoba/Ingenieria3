package SIMUTE.model;

import SIMUTE.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jefferson
 * @author Mariana
 * @author Melany
 * @author Lisseth
 *
 */
public class Model {

    static Database lo_database;
    public static String nombreDeArchivoCargado = "";

    static {
        initDatabase();
    }

    private static void initDatabase() {
        lo_database = new Database(null, null, null);
    }

    public static List<NumeroTelefonico> getPoblacion() {
        List<NumeroTelefonico> ls_numeros;
        ls_numeros = new ArrayList();
        try {
            String sql = "select * from poblacion";
            ResultSet rs = lo_database.executeQuery(sql);
            while (rs.next()) {
                ls_numeros.add(toNumber(rs));
            }
        } catch (SQLException ex) {
        }
        return ls_numeros;
    }

    public static void limpiaPoblacion() {
        String sql = "truncate poblacion";
        ResultSet rs = lo_database.executeQuery(sql);
    }

    private static NumeroTelefonico toNumber(ResultSet rs) {
        try {
            NumeroTelefonico obj = new NumeroTelefonico();
            obj.setNumero(rs.getInt("NumeroTelefono"));
            obj.setProvincia(rs.getInt("Provincia"));
            obj.setCanton(rs.getInt("Canton"));
            obj.setDistrito(rs.getInt("Distrito"));
            obj.setZona(rs.getInt("Zona"));
            obj.setRegion(rs.getInt("Region"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static int agregaNumeros(String ps_numeroTelefono, int pi_provincia, int pi_canton, int pi_distrito, int pi_zona, int pi_region) throws SQLException {
        String sql = "insert into poblacion values ('%s','%d','%d','%d','%d', '%d')";
        sql = String.format(sql, ps_numeroTelefono, pi_provincia, pi_canton, pi_distrito, pi_zona, pi_region);
        ResultSet rs = lo_database.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static Usuario getUsuario(String ps_id) throws SQLException {
        String sql = "select from Usuario u where u.Cedula = %s";
        sql = String.format(sql, ps_id);
        ResultSet rs = lo_database.executeUpdateWithKeys(sql);
        if (rs.next()) 
            return toUser(rs);
        else    
            return new Usuario();
    }

    private static Usuario toUser(ResultSet rs) {
        try {
            Usuario obj = new Usuario();
            obj.setNombre(rs.getString("Nombre"));
            obj.setApellido1(rs.getString("Apellido1"));
            obj.setApellido2(rs.getString("Apellido2"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Contra"));
            obj.setCedula(rs.getString("Cedula"));
            obj.setNumeroCelular(rs.getString("Celular"));
            obj.setRol(rs.getInt("TipoUsuario"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static Usuario userLogin(Usuario usuario) throws Exception {
        try {
            String sql = "select * from Usuario u where u.Cedula = '%s' and u.Contra='%s'";
            sql = String.format(sql, usuario.as_cedula, usuario.as_clave);
            ResultSet rs = lo_database.executeQuery(sql);
            if (rs.next()) {
                return toUser(rs);
            } else {
                return new Usuario(usuario.as_cedula, usuario.as_clave, 0);
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static int creaMuestra(Muestra muestra)
    {
        return 0;
    }
}
