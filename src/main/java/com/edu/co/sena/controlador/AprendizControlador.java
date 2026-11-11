package com.edu.co.sena.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.edu.co.sena.dao.estudianteDao;
import com.edu.co.sena.modelo.estudiantes;

public class AprendizControlador extends HttpServlet {

    private estudianteDao estDao = new estudianteDao();
    private final String pagListar = "/VISTA/listar.jsp";
    private final String pagNuevo = "/VISTA/nuevo.jsp";
    private final String pagEditar = "/VISTA/editar.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "listar":
                listar(request, response);
                break;
            case "nuevo":
                nuevo(request, response);
                break;
            case "guardar":
                guardar(request, response);
                break;
            case "editar":
                editar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("estudiantes", estDao.ListarTodo());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }

    protected void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("estudiantes", new estudiantes());
        request.getRequestDispatcher(pagNuevo).forward(request, response);

    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        estudiantes obj = new estudiantes();
        obj.setNombre(request.getParameter("nombre"));
        obj.setApellido(request.getParameter("apellido"));
        obj.setPrograma(request.getParameter("programa"));
        int result = estDao.registrar(obj);
        if (result > 0) {
            response.sendRedirect("AprendizControlador?accion=listar");
        } else {
            request.setAttribute("estudiantes", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }

    }
    
     private void editar(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        estudiantes obj = estDao.buscarId(id);
        if(obj != null){
            request.setAttribute("estudiantes", obj);
            request.getRequestDispatcher(pagEditar).forward(request, response);
        }else{
            response.sendRedirect("AprendizControlador?accion=listar");
        }
    }
     
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        estudiantes obj = new estudiantes();
        
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setNombre(request.getParameter("nombre"));
        obj.setApellido(request.getParameter("apellido"));
        obj.setPrograma(request.getParameter("programa"));
        int result = estDao.actualizar(obj);
        if (result > 0) {
            response.sendRedirect("AprendizControlador?accion=listar");
        } else {
            request.setAttribute("estudiantes", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }

    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int result = estDao.eliminar(id);
        response.sendRedirect("AprendizControlador?accion=listar");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
