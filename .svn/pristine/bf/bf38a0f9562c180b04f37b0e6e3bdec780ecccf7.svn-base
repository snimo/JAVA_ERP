package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluPuestoAplica;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluPuestoAplica extends DBObjetoPersistente {

  public static final String OID_PUESTO_APLICA = "oid_puesto_aplica";
  public static final String OID_POSTULANTE = "oid_postulante";
  public static final String OID_PUESTO_BUSQUEDA = "oid_puesto_busqueda";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_POSTULANTE = 100;

  public DBRecluPuestoAplica() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PUESTO_APLICA = 1;
    final int OID_POSTULANTE = 2;
    final int OID_PUESTO_BUSQUEDA = 3;
    final int ACTIVO = 4;

    RecluPuestoAplica pers = (RecluPuestoAplica) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into RSPUESTOAPLICA "+
                     " ( "+
                      "OID_PUESTO_APLICA,"+
                      "OID_POSTULANTE,"+
                      "OID_PUESTO_BUSQUEDA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PUESTO_APLICA,pers.getOID());
    qInsert.setInt(OID_POSTULANTE,pers.getPostulante().getOID());
    qInsert.setInt(OID_PUESTO_BUSQUEDA,pers.getPuesto().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_POSTULANTE = 1;
    final int OID_PUESTO_BUSQUEDA = 2;
    final int ACTIVO = 3;
    final int OID_PUESTO_APLICA = 4;

    RecluPuestoAplica pers = (RecluPuestoAplica) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update RSPUESTOAPLICA set "+
              "oid_postulante=?"+ 
              ",oid_puesto_busqueda=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_puesto_aplica=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PUESTO_APLICA,pers.getOID());
    qUpdate.setInt(OID_POSTULANTE,pers.getPostulante().getOID());
    qUpdate.setInt(OID_PUESTO_BUSQUEDA,pers.getPuesto().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PUESTO_APLICA = 1; 
    RecluPuestoAplica pers = (RecluPuestoAplica) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSPUESTOAPLICA "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_puesto_aplica=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PUESTO_APLICA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PUESTO_APLICA = 1; 
    RecluPuestoAplica pers = (RecluPuestoAplica) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSPUESTOAPLICA "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_puesto_aplica=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PUESTO_APLICA, pers.getOID()); 
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
      case SELECT_BY_POSTULANTE: {
          ps = this.selectByPostulante(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PUESTO_APLICA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSPUESTOAPLICA "); 
    textSQL.append(" WHERE oid_puesto_aplica = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PUESTO_APLICA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPostulante(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  RSPUESTOAPLICA "); 
	    textSQL.append(" WHERE oid_postulante  = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluPostulante postulante = (RecluPostulante) aCondiciones; 
	    querySelect.setInt(1, postulante.getOID()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSPUESTOAPLICA "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_puesto_aplica oid, codigo,  descripcion ,activo ");
    textSQL.append(" from RSPUESTOAPLICA");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPuestosAplica(RecluPostulante postulante,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluPuestoAplica.NICKNAME,
             DBRecluPuestoAplica.SELECT_BY_POSTULANTE,
             postulante,
             new ListObserver(),
             aSesion);
  }  
  
} 
