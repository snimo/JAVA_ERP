package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBRecluEstCandidatoBusq extends DBObjetoPersistente {

  public static final String OID_EST_CAND_BUSQ = "oid_est_cand_busq";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String COLOR = "color";
  public static final String PUEDE_CERRAR_BUSQ = "puede_cerrar_busq";
  public static final String OID_ESTADO_POSTU = "oid_estado_postu";
  public static final String SUGERIR_CIERRE = "sugerir_cierre";
  public static final String AL_CIERRE_EST_BUSQ = "al_cierre_est_busq";
  
  

  public DBRecluEstCandidatoBusq() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EST_CAND_BUSQ = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int COLOR = 5;
    final int PUEDE_CERRAR_BUSQ = 6;
    final int OID_ESTADO_POSTU = 7;
    final int SUGERIR_CIERRE = 8;
    final int AL_CIERRE_EST_BUSQ = 9;

    RecluEstCandidatoBusq pers = (RecluEstCandidatoBusq) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsEstadoCandBusq "+
                     " ( "+
                      "OID_EST_CAND_BUSQ,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO , COLOR , PUEDE_CERRAR_BUSQ , OID_ESTADO_POSTU , SUGERIR_CIERRE , AL_CIERRE_EST_BUSQ) "+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EST_CAND_BUSQ,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getColor()!=null)
    	qInsert.setInt(COLOR,pers.getColor().intValue());
    else
    	qInsert.setNull(COLOR,Types.INTEGER);
    if (pers.isPuedeCerrarBusqueda()!=null)
    	qInsert.setBoolean(PUEDE_CERRAR_BUSQ, pers.isPuedeCerrarBusqueda().booleanValue());
    else
    	qInsert.setBoolean(PUEDE_CERRAR_BUSQ, false);
    if (pers.getEstadoPostulante()!=null)
    	qInsert.setInt(OID_ESTADO_POSTU, pers.getEstadoPostulante().getOID());
    else
    	qInsert.setNull(OID_ESTADO_POSTU, Types.INTEGER);
    if (pers.isSugerirCierre()!=null)
    	qInsert.setBoolean(SUGERIR_CIERRE, pers.isSugerirCierre().booleanValue());
    else
    	qInsert.setBoolean(SUGERIR_CIERRE, false);
    if (pers.getAlCierreEstado()!=null)
    	qInsert.setInt(AL_CIERRE_EST_BUSQ, pers.getAlCierreEstado().getOID());
    else
    	qInsert.setNull(AL_CIERRE_EST_BUSQ, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int COLOR = 4;
    final int PUEDE_CERRAR_BUSQ = 5;
    final int OID_ESTADO_POSTU = 6;
    final int SUGERIR_CIERRE = 7;
    final int AL_CIERRE_EST_BUSQ = 8;
    final int OID_EST_CAND_BUSQ = 9;

    RecluEstCandidatoBusq pers = (RecluEstCandidatoBusq) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsEstadoCandBusq set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",color=?"+
              ",PUEDE_CERRAR_BUSQ=?"+
              ",oid_estado_postu=?"+
              ",sugerir_cierre=?"+
              ",al_cierre_est_busq=? "+
                 " where " +
                 " oid_est_cand_busq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_CAND_BUSQ,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getColor()!=null)
    	qUpdate.setInt(COLOR,pers.getColor().intValue());
    else
    	qUpdate.setNull(COLOR,Types.INTEGER);
    if (pers.isPuedeCerrarBusqueda()!=null)
    	qUpdate.setBoolean(PUEDE_CERRAR_BUSQ, pers.isPuedeCerrarBusqueda().booleanValue());
    else
    	qUpdate.setBoolean(PUEDE_CERRAR_BUSQ, false);    
    if (pers.getEstadoPostulante()!=null)
    	qUpdate.setInt(OID_ESTADO_POSTU, pers.getEstadoPostulante().getOID());
    else
    	qUpdate.setNull(OID_ESTADO_POSTU, Types.INTEGER);  
    if (pers.isSugerirCierre()!=null)
    	qUpdate.setBoolean(SUGERIR_CIERRE, pers.isSugerirCierre().booleanValue());
    else
    	qUpdate.setBoolean(SUGERIR_CIERRE, false);    
    if (pers.getAlCierreEstado()!=null)
    	qUpdate.setInt(AL_CIERRE_EST_BUSQ, pers.getAlCierreEstado().getOID());
    else
    	qUpdate.setNull(AL_CIERRE_EST_BUSQ, Types.INTEGER);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EST_CAND_BUSQ = 1; 
    RecluEstCandidatoBusq pers = (RecluEstCandidatoBusq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsEstadoCandBusq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_est_cand_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_CAND_BUSQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EST_CAND_BUSQ = 1; 
    RecluEstCandidatoBusq pers = (RecluEstCandidatoBusq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsEstadoCandBusq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_est_cand_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_CAND_BUSQ, pers.getOID()); 
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

    final int OID_EST_CAND_BUSQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsEstadoCandBusq "); 
    textSQL.append(" WHERE oid_est_cand_busq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EST_CAND_BUSQ, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsEstadoCandBusq "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_est_cand_busq oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from rsEstadoCandBusq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
