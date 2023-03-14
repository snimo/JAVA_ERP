package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.reclutamiento.bm.RecluCompePostu;
import com.srn.erp.reclutamiento.bm.RecluPostulante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluCompePostu extends DBObjetoPersistente {

  public static final String OID_COMPE_POSTU = "oid_compe_postu";
  public static final String OID_POSTULANTE = "oid_postulante";
  public static final String OID_COMPETENCIA = "oid_competencia";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_POSTULANTE = 100;

  public DBRecluCompePostu() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPE_POSTU = 1;
    final int OID_POSTULANTE = 2;
    final int OID_COMPETENCIA = 3;
    final int ACTIVO = 4;

    RecluCompePostu pers = (RecluCompePostu) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsCompePostu "+
                     " ( "+
                      "OID_COMPE_POSTU,"+
                      "OID_POSTULANTE,"+
                      "OID_COMPETENCIA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMPE_POSTU,pers.getOID());
    qInsert.setInt(OID_POSTULANTE,pers.getPostulante().getOID());
    qInsert.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_POSTULANTE = 1;
    final int OID_COMPETENCIA = 2;
    final int ACTIVO = 3;
    final int OID_COMPE_POSTU = 4;

    RecluCompePostu pers = (RecluCompePostu) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsCompePostu set "+
              "oid_postulante=?"+ 
              ",oid_competencia=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_compe_postu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPE_POSTU,pers.getOID());
    qUpdate.setInt(OID_POSTULANTE,pers.getPostulante().getOID());
    qUpdate.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPE_POSTU = 1; 
    RecluCompePostu pers = (RecluCompePostu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsCompePostu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_compe_postu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPE_POSTU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPE_POSTU = 1; 
    RecluCompePostu pers = (RecluCompePostu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsCompePostu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_compe_postu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPE_POSTU, pers.getOID()); 
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

    final int OID_COMPE_POSTU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsCompePostu "); 
    textSQL.append(" WHERE oid_compe_postu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMPE_POSTU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPostulante(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsCompePostu "); 
	    textSQL.append(" WHERE oid_postulante = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluPostulante postulante = (RecluPostulante) aCondiciones; 
	    querySelect.setInt(1, postulante.getOID()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsCompePostu "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compe_postu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rsCompePostu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getRecluCompetencias(
		  RecluPostulante postulante,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluCompePostu.NICKNAME,
             DBRecluCompePostu.SELECT_BY_POSTULANTE,
             postulante,
             new ListObserver(),
             aSesion);
  }  
  
} 
