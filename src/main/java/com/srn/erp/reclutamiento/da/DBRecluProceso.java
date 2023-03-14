package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluProceso extends DBObjetoPersistente {

  public static final String OID_PROCESO = "oid_proceso";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ORDEN = "orden";
  public static final String COSTO = "costo";
  public static final String ACTIVO = "activo";
  public static final String ALTA_SOLAPA_POSTU = "alta_solapa_postu";
  public static final String VISU_SOLAPA_POSTU = "visu_solapa_postu";
  public static final String VISU_CONS_RECEPCION = "visu_cons_recepcion";
  public static final String ALTA_EN_BUSQUEDA = "alta_en_busqueda";
  


  public DBRecluProceso() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROCESO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ORDEN = 4;
    final int COSTO = 5;
    final int ACTIVO = 6;
    final int ALTA_SOLAPA_POSTU = 7;
    final int VISU_SOLAPA_POSTU = 8;
    final int VISU_CONS_RECEPCION = 9;
    final int ALTA_EN_BUSQUEDA = 10;

    RecluProceso pers = (RecluProceso) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsProceso "+
                     " ( "+
                      "OID_PROCESO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ORDEN,"+
                      "COSTO,"+
                      "ACTIVO,ALTA_SOLAPA_POSTU,VISU_SOLAPA_POSTU,VISU_CONS_RECEPCION, ALTA_EN_BUSQUEDA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PROCESO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    if (pers.getCosto()!=null)
    	qInsert.setDouble(COSTO,pers.getCosto().doubleValue());
    else
    	qInsert.setDouble(COSTO,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isAltaSolapaPostulante()!=null)
    	qInsert.setBoolean(ALTA_SOLAPA_POSTU, pers.isAltaSolapaPostulante().booleanValue());
    else
    	qInsert.setBoolean(ALTA_SOLAPA_POSTU, false);
    if (pers.isVisuSolapaPostulante()!=null)
    	qInsert.setBoolean(VISU_SOLAPA_POSTU, pers.isVisuSolapaPostulante().booleanValue());
    else
    	qInsert.setBoolean(VISU_SOLAPA_POSTU, false);
    if (pers.isVisuConsRecepcion()!=null)
    	qInsert.setBoolean(VISU_CONS_RECEPCION, pers.isVisuConsRecepcion().booleanValue());
    else
    	qInsert.setBoolean(VISU_CONS_RECEPCION, false);    
    if (pers.isAltaEnBusqueda()!=null)
    	qInsert.setBoolean(ALTA_EN_BUSQUEDA, pers.isAltaEnBusqueda().booleanValue());
    else
    	qInsert.setBoolean(ALTA_EN_BUSQUEDA, false);    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ORDEN = 3;
    final int COSTO = 4;
    final int ACTIVO = 5;
    final int ALTA_SOLAPA_POSTU = 6;
    final int VISU_SOLAPA_POSTU = 7;  
    final int VISU_CONS_RECEPCION = 8;
    final int ALTA_EN_BUSQUEDA = 9;
    final int OID_PROCESO = 10;

    RecluProceso pers = (RecluProceso) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsProceso set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",orden=?"+ 
              ",costo=?"+ 
              ",activo=?"+ 
              ",alta_solapa_postu=?"+
              ",visu_solapa_postu=?"+
              ",visu_cons_recepcion=?"+
              ",alta_en_busqueda=?"+
                 " where " +
                 " oid_proceso=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setDouble(COSTO,pers.getCosto().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isAltaSolapaPostulante()!=null)
    	qUpdate.setBoolean(ALTA_SOLAPA_POSTU, pers.isAltaSolapaPostulante().booleanValue());
    else
    	qUpdate.setBoolean(ALTA_SOLAPA_POSTU, false);
    if (pers.isVisuSolapaPostulante()!=null)
    	qUpdate.setBoolean(VISU_SOLAPA_POSTU, pers.isVisuSolapaPostulante().booleanValue());
    else
    	qUpdate.setBoolean(VISU_SOLAPA_POSTU, false);  
    if (pers.isVisuConsRecepcion()!=null)
    	qUpdate.setBoolean(VISU_CONS_RECEPCION, pers.isVisuConsRecepcion().booleanValue());
    else
    	qUpdate.setBoolean(VISU_CONS_RECEPCION, false);   
    if (pers.isAltaEnBusqueda()!=null)
    	qUpdate.setBoolean(ALTA_EN_BUSQUEDA, pers.isAltaEnBusqueda().booleanValue());
    else
    	qUpdate.setBoolean(ALTA_EN_BUSQUEDA, false);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROCESO = 1; 
    RecluProceso pers = (RecluProceso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsProceso "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_proceso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROCESO = 1; 
    RecluProceso pers = (RecluProceso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsProceso "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_proceso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: { 
          ps = this.selectAllActivos(aCondiciones); 
          break; 
        }     
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PROCESO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsProceso "); 
    textSQL.append(" WHERE oid_proceso = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROCESO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsProceso "); 
	    textSQL.append(" WHERE activo=1 order by orden ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect; 
  } 
    
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsProceso "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_proceso oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from rsProceso order by orden ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getProcesosActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluProceso.NICKNAME,
             DBRecluProceso.SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }  
  
} 
