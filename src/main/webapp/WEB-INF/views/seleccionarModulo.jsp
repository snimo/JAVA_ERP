<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tablero de Informaci&oacute;n de empresas</title>
<link href="resources/css/tem01.css" rel="stylesheet" type="text/css">

<style type="text/css">
</style>
</head>

<body>

<div class="container">
<div class="container">
    <div class="header" align="center">
    </br>
<h3>M&oacute;dulos de Empresa</h3>
</br>
</div>      
    
    <div align="center">
   
    <table width="100%" border="0">
      <tr>
        <td>&nbsp;</td>
        <td height="21" colspan="3"><div id="CentrarImagen">
          <div align="center"></div>
        </div></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td rowspan="3">&nbsp;</td>
        <td height="50"><div align="center"><a href="${elementoModuloTablero1.href}" target="_parent"><img src="${elementoModuloTablero1.imagen}" width="70" height="70"></a></div></td>
        <td height="50"><div align="center"><a href="${elementoModuloTablero2.href}" target="_parent"><img src="${elementoModuloTablero2.imagen}" alt="" width="70" height="70"></a></div></td>
        <td><div align="center"><a href="${elementoModuloTablero3.href}" target="_parent"><img src="${elementoModuloTablero3.imagen}" alt="" width="70" height="70"></a></div></td>
        <td rowspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td height="22">
        <div  style="text-align:center"><a href="${elementoModuloTablero1.href}" target="_parent">${elementoModuloTablero1.titulo}</a></div></td>
        <td height="22"><div  style="text-align:center"><a href="${elementoModuloTablero1.href}" target="_parent">${elementoModuloTablero2.titulo}</a></div></td>
        <td><div  style="text-align:center"><a href="${elementoModuloTablero1.href}" target="_parent">${elementoModuloTablero3.titulo}</a></div></td>
      </tr>
      <tr>
        <td height="23">&nbsp;</td>
        <td height="23">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td width="5%" rowspan="3">&nbsp;</td>
        <td width="28%"><div align="center"><a href="${elementoModuloTablero4.href}" target="_parent"><img src="${elementoModuloTablero4.imagen}" alt="" width="70" height="70"></a></div></td>
        <td width="27%" height="50"><div align="center"><a href="${elementoModuloTablero5.href}" target="_parent"><img src="${elementoModuloTablero5.imagen}" alt="" width="70" height="70"></a></div></td>
        <td width="23%"><div align="center"><a href="${elementoModuloTablero6.href}" target="_parent"><img src="${elementoModuloTablero6.imagen}" alt="" width="70" height="70"></a></div></td>
        <td width="17%" rowspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td><div  style="text-align:center"><a href="${elementoModuloTablero4.href}" target="_parent">${elementoModuloTablero4.titulo}</a></div></td>
        <td width="27%" height="20"><div  style="text-align:center"><a href="${elementoModuloTablero5.href}" target="_parent">${elementoModuloTablero5.titulo}</a></div></td>
        <td width="23%"><div  style="text-align:center"><a href="${elementoModuloTablero6.href}" target="_parent">${elementoModuloTablero6.titulo}</a></div></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="27%" height="22">&nbsp;</td>
        <td width="23%">&nbsp;</td>
      </tr>
      <tr>
        <td rowspan="3">&nbsp;</td>
        <td><div align="center"><a href="${elementoModuloTablero7.href}" target="_parent"><img src="${elementoModuloTablero7.imagen}" alt="" width="70" height="70"></a></div></td>
        <td height="50"><div align="center"><a href="${elementoModuloTablero8.href}" target="_parent"><img src="${elementoModuloTablero8.imagen}" alt="" width="70" height="70"></a></div></td>
        <td><div align="center"><a href="${elementoModuloTablero9.href}" target="_parent"><img src="${elementoModuloTablero9.imagen}" alt="" width="70" height="70"></a></div></td>
        <td rowspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td><div  style="text-align:center"><a href="${elementoModuloTablero7.href}" target="_parent">${elementoModuloTablero7.titulo}</a></div></td>
        <td height="19"><div  style="text-align:center"><a href="${elementoModuloTablero8.href}" target="_parent">${elementoModuloTablero8.titulo}</a></div></td>
        <td><div  style="text-align:center"><a href="${elementoModuloTablero9.href}" target="_parent">${elementoModuloTablero9.titulo}</a></div></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="21">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>


  <div class="footer">
    <table width="100%" border="0">
    <tr>
      <td width="6%" height="40">&nbsp;</td>
      <td width="17%"><div align="center">
        <h5>Desarrollado por CPM@2013</h5>
      </div>
        
      </td>
      <td width="17%"><div align="center"><a href="seleccionarEmpresas"  target="_parent">Empresas</a></div></td>
      <td width="12%"><div align="center"><a href="logout" target="_parent">Cerrar Sesi&oacute;n</a></div></td>
      
      <td width="23%">&nbsp;</td>
      <td width="20%">&nbsp;</td>
      </tr>
  </table>
    </div>    

        
  
   
  <!-- end .container -->
</body>
</html>
