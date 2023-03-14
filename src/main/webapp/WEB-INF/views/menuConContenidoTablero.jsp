<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:ice="http://ns.adobe.com/incontextediting">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Menu del Modulo Empresa</title>
<link href="resources/css/tem01.css" rel="stylesheet" type="text/css">
<link href="resources/css/SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css">
<script src="resources/css/SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script src="resources/css/includes/ice/ice.js" type="text/javascript"></script>
</head>

<body>
<div class="container">


  <table width="100%" border="0">
    <tr>
      <td width="7%" height="123" rowspan="2">&nbsp;</td>
      <td width="34%" rowspan="2"><div align="center"><img src="resources/Imagenes/${path_logo_empresa}" width="300" height="96" /></div></td>
      <td width="25%" rowspan="2">&nbsp;</td>
      <td width="34%" height="111"><div align="center"><img src="${imagen_modulo}" width="176" height="96" /></div></td>
    </tr>
    <tr>
      <td><div style="text-align:center">${nombre_modulo}</div></td>
    </tr>
  </table>
<table width="100%" border="0" class="container">
  <tr>
    <td width="65" height="55">&nbsp;</td>
    <td width="831">
    ${armado_menu}
    </td>
    <td width="42">&nbsp;</td>
  </tr>
  <tr >
    <td height="360">&nbsp;</td>
    <td width="831" height="360">
    
    <iframe id="frameGrillaDocu" name="frameGrillaDocu"  style="width: 100%; display: table-cell; height: 100%;"></iframe>
    </td>
  </tr>
  <tr>
    <td height="129">&nbsp;</td>
    <td>
    <div class="footer">
    <table width="100%" border="0">
    <tr>
      <td width="2%" height="40">&nbsp;</td>
      <td width="18%"><div align="center"><a href="#" onClick="window.history.go(-1)">Anterior</a></div></td>
      <td width="15%"><div align="center"><a href="#" onClick="window.history.go(1)">Siguiente</a></div></td>
      <td width="17%"><div align="center"><a href="seleccionarEmpresas">Empresas</a></div></td>
      <td width="16%"><div align="center"><a href="frameSetTablero?empresa=${empresa}" >M&oacute;dulos</a></div></td>
      <td width="17%"><div align="center"><a href="logout" >Cerrar Sesi&oacute;n</a></div></td>
      <td width="15%">&nbsp;</td>
      </tr>
  </table>
    </div>    
    </td>
    <td>&nbsp;</td>
  </tr>
</table>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"resources/css/SpryAssets/SpryMenuBarDownHover.gif", imgRight:"resources/css/SpryAssets/SpryMenuBarRightHover.gif"});
</script>
</body>
</div>

</html>
