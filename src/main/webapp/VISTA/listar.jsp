<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.3.1/css/all.min.css" integrity="sha512-QeR2VH+lsBE5LSAe1Q5EnTBbe7XTBubt8dG93Y7gidSgdMCr8nVqKcfKAMyN96SV8KDbZVTDXChatu5G2KQGzg==" crossorigin="anonymous" referrerpolicy="no-referrer">
        <title>Listado de Aprendices</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card" style="width: 80rem;">
                        <div class="card-header bg-secondary text-center"><h4>Datos Aprendices</h4></div>
                        <div class="card-body">
                            <a href="AprendizControlador?accion=nuevo" class="btn bg-primary btn-sm"><i class="fa-solid fa-plus"></i>Nuevo</a>
                        </div>
                        <div class="col-md-8">
                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>apellido</th>
                                        <th>programa</th>
                                        <th>acciones</th>
                                    </tr>                        
                                </thead>                        
                                <tbody>                        
                                    <tr>
                                        <c:forEach items="${estudiantes}" var="item">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.nombre}</td>
                                            <td>${item.apellido}</td>
                                            <td>${item.programa}</td>
                                            <td>
                                                <a href="AprendizControlador?accion=editar&id=${item.id}" class="btn btn-outline-success btn-sm">Editar</a>
                                                <a href="AprendizControlador?accion=eliminar&id=${item.id}" class="btn btn-outline-danger btn-sm">Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
