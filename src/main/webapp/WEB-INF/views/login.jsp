<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login Tablero de Empresas</title>
<link href="resources/css/tem01.css" rel="stylesheet" type="text/css">
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body onload='document.f.j_username.focus();'>

<div class="container">
  <div class="header"><!-- end .header --> </div>
  <div class="content">
    <div class="header" align="center"><br/>
    <h2>Tablero de Informaci&oacute;n Multiempresas</h2>
    <br/></div>

    <div align="center">
      <h2>TIM</h2></div>
      <div align="center"><p>Favor ingrese el usuario y la clave para acceder al sistema</p></div>
    
    <table width="100%" border="0">
      <tr>
        <td width="25%" height="50"><div></div>&nbsp;</td>
        <td width="50%"><div align="center"><img src="resources/Imagenes/logoSistTIM.jpg"  ></div></td>
        <td width="25%">&nbsp;</td>
      </tr>
      <tr>
        <td height="147"><div></div>&nbsp;</td>
        <td><form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
          <div  align="center">
            <table >
              <tr>
                <td width="104">Usuario:</td>
                <td width="149"><input type='text' name='j_username' value=''></td>
                </tr>
              <tr>
                <td>Clave:</td>
                <td><input type='password' name='j_password' /></td>
                </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                </tr>
              <tr>
                <td><input name="Ingresar" type="submit" id="Ingresar"
					value="Ingresar" /></td>
                <td><input name="reset" type="reset" value="Borrar" /></td>
                </tr>
            </table>
            </div>
        </form>
          &nbsp;</td>
        
        <td>&nbsp;</td>
      </tr>
    </table>
    
     <table width="100%" border="0">
      <tr>
        <td width="25%" height="91"><div></div>&nbsp;</td>
        <td width="50%"><div align="center">
        
            <c:if test="${verError}">
    	<div align="center" class="errorblock"><p>${errorLogin}&nbsp;</p></div>
    </c:if>

        
        </div></td>
        <td width="25%">&nbsp;</td>
      </tr>
      </table>
    
    

    <!-- end .content --></div>
  <div class="footer">
    <h5>Desarrollado por CPM@2013</h5>
    
  
    
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>