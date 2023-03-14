package com.srn.erp.contabilidad.bm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class Atributo
    extends ObjetoLogico {

  public Atributo() {
  }

  public static final String TIPO_COMPONENTE = "COM";
  public static final String TIPO_ENTERO = "INT";
  public static final String TIPO_STRING = "TXT";
  public static final String TIPO_DECIMAL = "DEC";
  public static final String TIPO_FECHA = "FEC";

  public static String NICKNAME = "cg.Atributo";

  private String codigo;
  private String descripcion;
  private String tipo;
  private Componente compo;
  private Boolean activo;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo = aCodigo;
  }

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion = aDescripcion;
  }

  public String getTipo() throws BaseException {
    supportRefresh();
    return tipo;
  }

  public void setTipo(String aTipo) {
    this.tipo = aTipo;
  }

  public Componente getCompo() throws BaseException {
    supportRefresh();
    return compo;
  }

  public void setCompo(Componente aCompo) {
    this.compo = aCompo;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo = aActivo;
  }

  public String getNickName() {
    return NICKNAME;
  }

  public static Atributo findByOid(Integer oid, ISesion aSesion) throws
      BaseException {
    return (Atributo) getObjectByOid(NICKNAME, oid, aSesion);
  }

  public static Atributo findByOidProxy(Integer oid, ISesion aSesion) throws
      BaseException {
    return (Atributo) getObjectByOidProxy(NICKNAME, oid, aSesion);
  }

  public static Atributo findByCodigo(String codigo, ISesion aSesion) throws
      BaseException {
    return (Atributo) getObjectByCodigo(NICKNAME, codigo, aSesion);
  }

  public void beforeSave() throws BaseException {

    if (isNew() && (isActivo().booleanValue() == false)) {
      Validar.mensajeValidacion("El atributo debe estar en modo activo");

    }
  }

  public boolean isEntero() throws BaseException {
    if (getTipo().equals(Atributo.TIPO_ENTERO))
      return true;
    else
      return false;
  }

  public boolean isValorCompo() throws BaseException {
    if (getTipo().equals(Atributo.TIPO_COMPONENTE))
      return true;
    else
      return false;
  }

  public boolean isString() throws BaseException {
    if (getTipo().equals(Atributo.TIPO_STRING))
      return true;
    else
      return false;
  }

  public boolean isDecimal() throws BaseException {
    if (getTipo().equals(Atributo.TIPO_DECIMAL))
      return true;
    else
      return false;
  }

  public boolean isFecha() throws BaseException {
     if (getTipo().equals(Atributo.TIPO_FECHA))
       return true;
     else
       return false;
   }


  public String getCampoFisico() throws BaseException {
    if (getTipo().equals(Atributo.TIPO_COMPONENTE)) {
      return "atri_oid_" + getCodigo();
    }
    else
    if (getTipo().equals(Atributo.TIPO_ENTERO)) {
      return "atri_ent_" + getCodigo();
    }
    else
    if (getTipo().equals(Atributo.TIPO_STRING)) {
      return "atri_str_" + getCodigo();
    }
    else
    if (getTipo().equals(Atributo.TIPO_DECIMAL)) {
      return "atri_dec_" + getCodigo();
    }
    else
    if (getTipo().equals(Atributo.TIPO_DECIMAL)) {
      return "atri_dec_" + getCodigo();
    }
    else
    if (getTipo().equals(Atributo.TIPO_FECHA)) {
      return "atri_fec_" + getCodigo();
    }
    else return "";
  }
  
  public void agregarAtributoA(String tableName) throws BaseException {
  	
  	try {
  	
  	// Ejecutar query de tabla para verificar si ya existe el atributo 
		Statement st = getSesion().getConexionBD().createStatement();
		ResultSet rs = st.executeQuery("select * from "+tableName+" where 1=2 ");
		
		boolean encontro = false;
		for (int i=1;i<=rs.getMetaData().getColumnCount();++i) {
			String columnName = rs.getMetaData().getColumnName(i);
			if (columnName.toUpperCase().equals(this.getCampoFisico().toUpperCase())) {
				encontro = true;
				break;
			}
		}
		
		rs.close();
		st.close();
		
		// Si no lo encontro dar de alta el campo		
		if (!encontro) {
			Statement st1 = getSesion().getConexionBD().createStatement();
			st1.execute("alter table "+tableName+" add "+getScriptAddTypeField());
		  st1.close();
		}
		
  	}
  	catch(Exception e) {
  		throw new ExceptionValidation(null,e.getMessage());
  	}
  	
  }
  
  public String getScriptAddTypeField() throws BaseException {
    StringBuffer sb = new StringBuffer();
    if (getTipo().equals(Atributo.TIPO_COMPONENTE))
        sb.append(" atri_oid_"+this.getCodigo()+" integer");
    else
    if (getTipo().equals(Atributo.TIPO_ENTERO))
        sb.append(" atri_ent_"+this.getCodigo()+" integer");
    else
    if (getTipo().equals(Atributo.TIPO_STRING))
        sb.append(" atri_str_"+this.getCodigo()+" varchar(50)");
    else
    if (getTipo().equals(Atributo.TIPO_DECIMAL))
          sb.append(" atri_dec_"+this.getCodigo()+" DOUBLE PRECISION");
    else
    if (getTipo().equals(Atributo.TIPO_FECHA))
          sb.append("atri_fec_"+this.getCodigo()+" TIMESTAMP");
    return sb.toString();
  }
  
  

}
