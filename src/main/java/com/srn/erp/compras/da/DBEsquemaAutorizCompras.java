package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.compras.bm.EsquemaAutorizCompras;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBEsquemaAutorizCompras extends DBObjetoPersistente {

  public static final String OID_ESQ_AUTORIZ = "oid_esq_autoriz";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String AMBITO_ESQUEMA = "ambito_esquema";
  public static final String ACTIVO = "activo";
  public static final String OID_CLASIF_ENT = "oid_clasif_ent";
  public static final String USAR_CLASIFICADOR = "usar_clasificador";
  public static final String NICKNAME = "nickname";
  
  public static final int SELECT_AMBITO_REQUISICION = 100;
  public static final int SELECT_AMBITO_COMPRA      = 101;

  public DBEsquemaAutorizCompras() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESQ_AUTORIZ = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int AMBITO_ESQUEMA = 4;
    final int ACTIVO = 5;
    final int OID_CLASIF_ENT = 6;
    final int USAR_CLASIFICADOR = 7;
    final int NICKNAME = 8;

    EsquemaAutorizCompras pers = (EsquemaAutorizCompras) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpEsqAutoriz "+
                     " ( "+
                      "OID_ESQ_AUTORIZ,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "AMBITO_ESQUEMA,"+
                      "ACTIVO,"+
                      "OID_CLASIF_ENT,USAR_CLASIFICADOR,NICKNAME)"+ 
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
    qInsert.setInt(OID_ESQ_AUTORIZ,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(AMBITO_ESQUEMA,pers.getAmbito_esquema());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getClasificadorEntidad()!=null)
    	qInsert.setInt(OID_CLASIF_ENT,pers.getClasificadorEntidad().getOID());
    else
    	qInsert.setNull(OID_CLASIF_ENT,java.sql.Types.INTEGER);
    qInsert.setBoolean(USAR_CLASIFICADOR, pers.isUsarClasificador());
    qInsert.setString(NICKNAME, pers.getNombreNickName());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int AMBITO_ESQUEMA = 3;
    final int ACTIVO = 4;
    final int OID_CLASIF_ENT = 5;
    final int USAR_CLASIFICADOR = 6;
    final int NICKNAME = 7;
    final int OID_ESQ_AUTORIZ = 8;

    EsquemaAutorizCompras pers = (EsquemaAutorizCompras) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpEsqAutoriz set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",ambito_esquema=?"+ 
              ",activo=?"+
              ",oid_clasif_ent=?"+
              ",usar_clasificador=?"+
              ",nickname=?"+
                 " where " +
                 " oid_esq_autoriz=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_AUTORIZ,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(AMBITO_ESQUEMA,pers.getAmbito_esquema());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(USAR_CLASIFICADOR, pers.isUsarClasificador());
    if (pers.getClasificadorEntidad()!=null)
    	qUpdate.setInt(OID_CLASIF_ENT,pers.getClasificadorEntidad().getOID());
    else
    	qUpdate.setNull(OID_CLASIF_ENT,java.sql.Types.INTEGER);
    qUpdate.setString(NICKNAME, pers.getNombreNickName());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESQ_AUTORIZ = 1; 
    EsquemaAutorizCompras pers = (EsquemaAutorizCompras) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpEsqAutoriz "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_esq_autoriz=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_AUTORIZ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESQ_AUTORIZ = 1; 
    EsquemaAutorizCompras pers = (EsquemaAutorizCompras) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpEsqAutoriz "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_esq_autoriz=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_AUTORIZ, pers.getOID()); 
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
      case SELECT_AMBITO_REQUISICION : {
        ps = this.selectHelpAmbitoRequisicion(aCondiciones); 
        break; 
      }
      case SELECT_AMBITO_COMPRA : {
          ps = this.selectHelpAmbitoCompra(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESQ_AUTORIZ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpEsqAutoriz "); 
    textSQL.append(" WHERE oid_esq_autoriz = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESQ_AUTORIZ, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpEsqAutoriz "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_esq_autoriz oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cpEsqAutoriz");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  
  private PreparedStatement selectHelpAmbitoRequisicion(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_esq_autoriz oid,codigo codigo, descripcion descripcion ,activo ");
	    textSQL.append(" from cpEsqAutoriz where ambito_esquema='"+EsquemaAutorizCompras.getAmbitoRequisiciones(getSesion())+"'");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectHelpAmbitoCompra(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_esq_autoriz oid,codigo codigo, descripcion descripcion ,activo ");
	    textSQL.append(" from cpEsqAutoriz where ambito_esquema='"+EsquemaAutorizCompras.getAmbitoCompras(getSesion())+"'");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  
  
} 
