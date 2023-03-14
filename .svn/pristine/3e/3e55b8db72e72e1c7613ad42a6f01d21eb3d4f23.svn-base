package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.ObsGeneralesExcluido;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBObsGeneralesExcluido extends DBObjetoPersistente {

  public static final String OID_OBS_GRALES = "oid_obs_grales";
  public static final String OID_INDIVIDUO = "oid_individuo";
  public static final String FECHA = "fecha";
  public static final String OBSERVACION = "observacion";
  public static final String ACTIVO = "activo";
  public static final String OID_PREDIO = "oid_predio";
  
  public static final int SELECT_BY_INDIVIDUO = 100;

  public DBObsGeneralesExcluido() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OBS_GRALES = 1;
    final int OID_INDIVIDUO = 2;
    final int FECHA = 3;
    final int OBSERVACION = 4;
    final int ACTIVO = 5;
    final int OID_PREDIO = 6;

    ObsGeneralesExcluido pers = (ObsGeneralesExcluido) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excObsGenerales "+
                     " ( "+
                      "OID_OBS_GRALES,"+
                      "OID_INDIVIDUO,"+
                      "FECHA,"+
                      "OBSERVACION,"+
                      "ACTIVO , OID_PREDIO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_OBS_GRALES,pers.getOID());
    if (pers.getIndividuo()!=null) 
      qInsert.setInt(OID_INDIVIDUO,pers.getIndividuo().getOID());
    else
      qInsert.setNull(OID_INDIVIDUO,java.sql.Types.INTEGER);
    if (pers.getFecha()!=null) 
      qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    else
      qInsert.setNull(FECHA,java.sql.Types.DATE);
    if (pers.getObservacion()!=null)
    	qInsert.setString(OBSERVACION,pers.getObservacion().replaceAll("Â", ""));
    else
    	qInsert.setNull(OBSERVACION,java.sql.Types.VARCHAR);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getPredioExcluido()!=null)
    	qInsert.setInt(OID_PREDIO,pers.getPredioExcluido().getOID());
    else
    	qInsert.setNull(OID_PREDIO,java.sql.Types.INTEGER);    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_INDIVIDUO = 1;
    final int FECHA = 2;
    final int OBSERVACION = 3;
    final int ACTIVO = 4;
    final int OID_PREDIO = 5;
    final int OID_OBS_GRALES = 6;

    ObsGeneralesExcluido pers = (ObsGeneralesExcluido) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excObsGenerales set "+
              "oid_individuo=?"+ 
              ",fecha=?"+ 
              ",observacion=?"+ 
              ",activo=?"+ 
              ",oid_predio=?"+
                 " where " +
                 " oid_obs_grales=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_GRALES,pers.getOID());
    if (pers.getIndividuo()!=null) 
      qUpdate.setInt(OID_INDIVIDUO,pers.getIndividuo().getOID());
    else
      qUpdate.setNull(OID_INDIVIDUO,java.sql.Types.INTEGER);
    if (pers.getFecha()!=null) 
      qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    else
      qUpdate.setNull(FECHA,java.sql.Types.DATE);
    if (pers.getObservacion()!=null)
    	qUpdate.setString(OBSERVACION,pers.getObservacion().replaceAll("Â", ""));
    else
    	qUpdate.setNull(OBSERVACION,java.sql.Types.VARCHAR);    
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getPredioExcluido()!=null)
    	qUpdate.setInt(OID_PREDIO,pers.getPredioExcluido().getOID());
    else
    	qUpdate.setNull(OID_PREDIO,java.sql.Types.INTEGER);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OBS_GRALES = 1; 
    ObsGeneralesExcluido pers = (ObsGeneralesExcluido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excObsGenerales "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_obs_grales=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_GRALES, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OBS_GRALES = 1; 
    ObsGeneralesExcluido pers = (ObsGeneralesExcluido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excObsGenerales "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_obs_grales=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_GRALES, pers.getOID()); 
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
      case SELECT_BY_INDIVIDUO: {
          ps = this.selectByIndividuo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_OBS_GRALES = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excObsGenerales "); 
    textSQL.append(" WHERE oid_obs_grales = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_OBS_GRALES, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excObsGenerales "); 
	    textSQL.append(" WHERE oid_individuo = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones; 
	    querySelect.setInt(1, individuo.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excObsGenerales "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_obs_grales oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excObsGenerales");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getObsGenerales(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ObsGeneralesExcluido.NICKNAME, DBObsGeneralesExcluido.SELECT_BY_INDIVIDUO, individuo,
				new ListObserver(), aSesion);
	}
  
  
} 
