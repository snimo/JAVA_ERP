package com.srn.erp.contabilidad.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.contabilidad.bm.*;
import com.srn.erp.ventas.da.DBPedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBAtributoEnGrupo extends DBObjetoPersistente {

  public static final String OID_ATRI_EN_GRUPO = "oid_atri_en_grupo";
  public static final String OID_GRUPOS_ATRI = "oid_grupos_atri";
  public static final String OID_ATRIBUTO = "oid_atributo";
  public static final String SECU = "secu";
  public static final String FORMATO = "formato";
  public static final String OBLIGATORIO = "obligatorio";
  public static final String MAX_LONGITUD = "max_longitud";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ATRI_EN_GRUPO = 100;

  public DBAtributoEnGrupo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ATRI_EN_GRUPO = 1;
    final int OID_GRUPOS_ATRI = 2;
    final int OID_ATRIBUTO = 3;
    final int SECU = 4;
    final int FORMATO = 5;
    final int OBLIGATORIO = 6;
    final int MAX_LONGITUD = 7;
    final int ACTIVO = 8;

    AtributoEnGrupo pers = (AtributoEnGrupo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geAtriEnGrupo "+
                     " ( "+
                      "OID_ATRI_EN_GRUPO,"+
                      "OID_GRUPOS_ATRI,"+
                      "OID_ATRIBUTO,"+
                      "SECU,"+
                      "FORMATO,"+
                      "OBLIGATORIO,"+
                      "MAX_LONGITUD,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ATRI_EN_GRUPO,pers.getOID());
    qInsert.setInt(OID_GRUPOS_ATRI,pers.getGrupoatri().getOID());
    qInsert.setInt(OID_ATRIBUTO,pers.getAtributo().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    if (pers.getFormato()!=null)
    	qInsert.setString(FORMATO,pers.getFormato());
    else
    	qInsert.setNull(FORMATO,Types.VARCHAR);
    if (pers.isObligatorio()!=null)
    	qInsert.setBoolean(OBLIGATORIO,pers.isObligatorio().booleanValue());
    else
    	qInsert.setNull(OBLIGATORIO,Types.BOOLEAN);
    if (pers.getMax_longitud()!=null)
    	qInsert.setInt(MAX_LONGITUD,pers.getMax_longitud().intValue());
    else
    	qInsert.setNull(MAX_LONGITUD,Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPOS_ATRI = 1;
    final int OID_ATRIBUTO = 2;
    final int SECU = 3;
    final int FORMATO = 4;
    final int OBLIGATORIO = 5;
    final int MAX_LONGITUD = 6;
    final int ACTIVO = 7;
    final int OID_ATRI_EN_GRUPO = 8;

    AtributoEnGrupo pers = (AtributoEnGrupo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geAtriEnGrupo set "+
              "oid_grupos_atri=?"+ 
              ",oid_atributo=?"+ 
              ",secu=?"+ 
              ",formato=?"+ 
              ",obligatorio=?"+ 
              ",max_longitud=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_atri_en_grupo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ATRI_EN_GRUPO,pers.getOID());
    qUpdate.setInt(OID_GRUPOS_ATRI,pers.getGrupoatri().getOID());
    qUpdate.setInt(OID_ATRIBUTO,pers.getAtributo().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    if (pers.getFormato()!=null)
    	qUpdate.setString(FORMATO,pers.getFormato());
    else
    	qUpdate.setNull(FORMATO,Types.VARCHAR);
    if (pers.isObligatorio()!=null)
    	qUpdate.setBoolean(OBLIGATORIO,pers.isObligatorio().booleanValue());
    else
    	qUpdate.setNull(OBLIGATORIO,Types.BOOLEAN);
    if (pers.getMax_longitud()!=null)
    	qUpdate.setInt(MAX_LONGITUD,pers.getMax_longitud().intValue());
    else
    	qUpdate.setNull(MAX_LONGITUD,Types.INTEGER);    
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ATRI_EN_GRUPO = 1; 
    AtributoEnGrupo pers = (AtributoEnGrupo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from geAtriEnGrupo "+
                     " where " + 
                     " oid_atri_en_grupo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ATRI_EN_GRUPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ATRI_EN_GRUPO = 1; 
    AtributoEnGrupo pers = (AtributoEnGrupo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geAtriEnGrupo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_atri_en_grupo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ATRI_EN_GRUPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
    PreparedStatement ps = null; 
    switch (aSelect) { 
      case IDBObjetoPersistente.SELECT_BY_OID: { 
        ps = this.selectByOID(aCondiciones); 
        break; 
      } 
      case IDBObjetoPersistente.SELECT_BY_CODIGO: { 
        ps = this.selectByCodigo(aCondiciones); 
        break; 
      } 
      case IDBObjetoPersistente.SELECT_ALL_HELP: { 
        ps = this.selectAllHelp(aCondiciones); 
        break; 
      } 
      case SELECT_BY_ATRI_EN_GRUPO: {
        ps = this.selectByAtriEnGrupo(aCondiciones); 
        break; 
      }
      
    } 
    return ps;
  }
  
  private PreparedStatement selectByAtriEnGrupo(Object aCondiciones) throws BaseException, SQLException { 

    GrupoDeAtributos grupoDeAtributos = (GrupoDeAtributos) aCondiciones;

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geAtriEnGrupo "); 
    textSQL.append(" WHERE oid_grupos_atri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setInt(1, grupoDeAtributos.getOID()); 
    return querySelect; 
    
  }
  

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ATRI_EN_GRUPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geAtriEnGrupo "); 
    textSQL.append(" WHERE oid_atri_en_grupo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ATRI_EN_GRUPO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geGrupoDeAtri "); 
    textSQL.append(" WHERE oid_grupos_atri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_atri_en_grupo oid,oid_grupos_atri codigo,  descripcion ,activo ");
    textSQL.append(" from geGrupoDeAtri");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getAtributosEnGrupo(GrupoDeAtributos grupoDeAtributos,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AtributoEnGrupo.NICKNAME,
				DBAtributoEnGrupo.SELECT_BY_ATRI_EN_GRUPO, grupoDeAtributos,
				new ListObserver(), aSesion);
	}
    
  
} 
