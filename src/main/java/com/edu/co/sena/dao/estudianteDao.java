package com.edu.co.sena.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.edu.co.sena.modelo.estudiantes;
import com.edu.co.sena.config.conexion;
import java.sql.SQLException;

public class estudianteDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<estudiantes> ListarTodo() {

        ArrayList<estudiantes> list = new ArrayList<>();

        String query = "SELECT * FROM aprendiz";

        try {

            Connection conn = conexion.getConnection();

            System.out.println("Conexion = " + conn);

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id")
                        + " Nombre: " + rs.getString("nombre")
                );

                estudiantes obj = new estudiantes();

                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("nombre"));
                obj.setApellido(rs.getString("apellido"));
                obj.setPrograma(rs.getString("programa"));

                list.add(obj);
            }

            System.out.println("Total registros DAO: " + list.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int registrar(estudiantes obj) {
        int result = 0;

        try {
            cn = conexion.getConnection();

            String sql = "INSERT INTO aprendiz(nombre,apellido,programa) VALUES (?,?,?)";

            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getPrograma());
            result = ps.executeUpdate();

            System.out.println("Filas insertadas: " + result);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    
    public estudiantes buscarId(int id) {
        estudiantes obj = null;
        try {
            cn = conexion.getConnection();
            String sql = "select * from aprendiz where id=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs= ps.executeQuery();
            
            while (rs.next()){
                obj = new estudiantes();
                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("nombre"));
                obj.setApellido(rs.getString("apellido"));
                obj.setPrograma(rs.getString("programa"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
    
    public int actualizar(estudiantes obj) {

        int result = 0;

        try {
            cn = conexion.getConnection();

            String sql = "UPDATE aprendiz "
                    + "SET nombre=?, apellido=?, programa=? "
                    + "WHERE id=?";

            ps = cn.prepareStatement(sql);

            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getPrograma());
            ps.setInt(4, obj.getId());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
}
    
    public int eliminar(int id) {
        
        int result = 0;
        
        try {
            cn = conexion.getConnection();
            
            String sql = "DELETE FROM aprendiz WHERE id=?";
            
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            
            result = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

}
