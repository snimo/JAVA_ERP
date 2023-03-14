package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBRecluEstadoPostulante extends DBObjetoPersistente {

  public static final String OID_ESTADO_POSTU = "oid_estado_postu";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String COLOR = "color";
  public static final String SELECCIONADO = "seleccionado";
  

  public DBRecluEstadoPostulante() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTADO_POSTU = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int COLOR = 5;
    final int SELECCIONADO = 6;

    RecluEstadoPostulante pers = (RecluEstadoPostulante) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into RSESTADOPOSTU "+
                     " ( "+
                      "OID_ESTADO_POSTU,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,COLOR,SELECCIONADO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESTADO_POSTU,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getColor()!=null)
    	qInsert.setInt(COLOR, pers.getColor());
    else
    	qInsert.setNull(COLOR, Types.INTEGER);
    if (pers.isSeleccionado()!=null)
    	qInsert.setBoolean(SELECCIONADO, pers.isSeleccionado());
    else
    	qInsert.setBoolean(SELECCIONADO, false);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int COLOR = 4;
    final int SELECCIONADO = 5;
    final int OID_ESTADO_POSTU = 6;

    RecluEstadoPostulante pers = (RecluEstadoPostulante) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update RSESTADOPOSTU set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",color=?"+
              ",seleccionado=?"+
                 " where " +
                 " oid_estado_postu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_POSTU,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getColor()!=null)
    	qUpdate.setInt(COLOR, pers.getColor());
    else
    	qUpdate.setNull(COLOR, Types.INTEGER);  
    if (pers.isSeleccionado()!=null)
    	qUpdate.setBoolean(SELECCIONADO, pers.isSeleccionado());
    else
    	qUpdate.setBoolean(SELECCIONADO, false);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTADO_POSTU = 1; 
    RecluEstadoPostulante pers = (RecluEstadoPostulante) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSESTADOPOSTU "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_estado_postu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_POSTU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTADO_POSTU = 1; 
    RecluEstadoPostulante pers = (RecluEstadoPostulante) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSESTADOPOSTU "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_estado_postu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_POSTU, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESTADO_POSTU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSESTADOPOSTU "); 
    textSQL.append(" WHERE oid_estado_postu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESTADO_POSTU, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSESTADOPOSTU "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_estado_postu oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from RSESTADOPOSTU");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
