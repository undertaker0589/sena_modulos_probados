<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.3.1/css/all.min.css" integrity="sha512-QeR2VH+lsBE5LSAe1Q5EnTBbe7XTBubt8dG93Y7gidSgdMCr8nVqKcfKAMyN96SV8KDbZVTDXChatu5G2KQGzg==" crossorigin="anonymous" referrerpolicy="no-referrer">
        <title>Formulario</title>
    </head>
    <body>
        <div class="container mt-3">
            <div class="card">
                <div class="card-body">
                    <h3>EDITAR APRENDIZ</h3>
                    <hr />
                    <form action="AprendizControlador" method="post">
                        <div class="mb-3">
                            <input value="${estudiantes.id}" type="hidden" class="form-control" name="id">
                        </div>
                        <div class="mb-3">
                            <label for="nombre" class="form-label"><strong>Nombre</strong></label>
                            <input value="${estudiantes.nombre}" type="text" class="form-control" name="nombre">
                        </div>
                        <div class="mb-3">
                            <label for="apellido" class="form-label"><strong>Apellido</strong></label>
                            <input value="${estudiantes.apellido}" type="text" class="form-control" name="apellido">
                        </div>
                        <div class="mb-3">
                            <label for="programa" class="form-label"><strong>Programa</strong></label>
                            <input value="${estudiantes.programa}" type="text" class="form-control" name="programa">
                        </div>
                        <div class="mb-3">
                            <input type="hidden" name="accion" value="actualizar">
                            <button class="btn btn-sm">Actualizar</button>
                            <a href="AprendizControlador?accion=listar" class="btn bg-primary btn-sm">Volver</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
