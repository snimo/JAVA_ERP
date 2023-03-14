package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.EvalFirma;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEvalFirma extends DBObjetoPersistente {

  public static final String OID_FIRMA_EVAL = "oid_firma_eval";
  public static final String OID_EVAL_CAB = "oid_eval_cab";
  public static final String NRO_FIRMA = "nro_firma";
  public static final String OID_LEGAJO_FIRMA = "oid_legajo_firma";
  public static final String FIRMO = "firmo";
  public static final String FEC_FIRMA = "fec_firma";
  public static final String ACTIVO = "activo";
  public static final String TITULO = "titulo";

  public static final int SELECT_BY_EVALUACION = 100;
  
  public DBEvalFirma() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FIRMA_EVAL = 1;
    final int OID_EVAL_CAB = 2;
    final int NRO_FIRMA = 3;
    final int OID_LEGAJO_FIRMA = 4;
    final int FIRMO = 5;
    final int FEC_FIRMA = 6;
    final int ACTIVO = 7;
    final int TITULO = 8;

    EvalFirma pers = (EvalFirma) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhFirmasEval "+
                     " ( "+
                      "OID_FIRMA_EVAL,"+
                      "OID_EVAL_CAB,"+
                      "NRO_FIRMA,"+
                      "OID_LEGAJO_FIRMA,"+
                      "FIRMO,"+
                      "FEC_FIRMA,"+
                      "ACTIVO,TITULO)"+ 
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
    qInsert.setInt(OID_FIRMA_EVAL,pers.getOID());
    qInsert.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    if (pers.getNro_firma()!=null)
    	qInsert.setInt(NRO_FIRMA,pers.getNro_firma().intValue());
    else
    	qInsert.setInt(NRO_FIRMA,0);
    if (pers.getLegajo_firma()!=null) 
      qInsert.setInt(OID_LEGAJO_FIRMA,pers.getLegajo_firma().getOID());
    else
      qInsert.setNull(OID_LEGAJO_FIRMA,java.sql.Types.INTEGER);
    qInsert.setBoolean(FIRMO,pers.isFirmo().booleanValue());
    if (pers.getFec_firma()!=null) 
      qInsert.setDate(FEC_FIRMA,new java.sql.Date(pers.getFec_firma().getTime()));
    else
      qInsert.setNull(FEC_FIRMA,java.sql.Types.DATE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTitulo()!=null)
    	qInsert.setString(TITULO, pers.getTitulo());
    else
    	qInsert.setString(TITULO, "");
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_CAB = 1;
    final int NRO_FIRMA = 2;
    final int OID_LEGAJO_FIRMA = 3;
    final int FIRMO = 4;
    final int FEC_FIRMA = 5;
    final int ACTIVO = 6;
    final int TITULO = 7;
    final int OID_FIRMA_EVAL = 8;

    EvalFirma pers = (EvalFirma) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhFirmasEval set "+
              "oid_eval_cab=?"+ 
              ",nro_firma=?"+ 
              ",oid_legajo_firma=?"+ 
              ",firmo=?"+ 
              ",fec_firma=?"+ 
              ",activo=?"+ 
              ",titulo=?"+
                 " where " +
                 " oid_firma_eval=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FIRMA_EVAL,pers.getOID());
    qUpdate.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    if (pers.getNro_firma()!=null)
    	qUpdate.setInt(NRO_FIRMA,pers.getNro_firma().intValue());
    else
    	qUpdate.setInt(NRO_FIRMA,0);
    if (pers.getLegajo_firma()!=null) 
      qUpdate.setInt(OID_LEGAJO_FIRMA,pers.getLegajo_firma().getOID());
    else
      qUpdate.setNull(OID_LEGAJO_FIRMA,java.sql.Types.INTEGER);
    qUpdate.setBoolean(FIRMO,pers.isFirmo().booleanValue());
    if (pers.getFec_firma()!=null) 
      qUpdate.setDate(FEC_FIRMA,new java.sql.Date(pers.getFec_firma().getTime()));
    else
      qUpdate.setNull(FEC_FIRMA,java.sql.Types.DATE);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTitulo()!=null)
    	qUpdate.setString(TITULO, pers.getTitulo());
    else
    	qUpdate.setString(TITULO, "");
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FIRMA_EVAL = 1; 
    EvalFirma pers = (EvalFirma) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhFirmasEval "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_firma_eval=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FIRMA_EVAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FIRMA_EVAL = 1; 
    EvalFirma pers = (EvalFirma) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhFirmasEval "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_firma_eval=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FIRMA_EVAL, pers.getOID()); 
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
      case SELECT_BY_EVALUACION: {
        ps = this.selectByEvaluacion(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FIRMA_EVAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhFirmasEval "); 
    textSQL.append(" WHERE oid_firma_eval = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FIRMA_EVAL, oid); 
    return querySelect; 
  }
  

  private PreparedStatement selectByEvaluacion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhFirmasEval "); 
	    textSQL.append(" WHERE oid_eval_cab  = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EvaluacionLegajoCab evaluacionLegajoCab = (EvaluacionLegajoCab) aCondiciones; 
	    querySelect.setInt(1, evaluacionLegajoCab.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhFirmasEval "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_firma_eval oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhFirmasEval");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEvalFirmas(EvaluacionLegajoCab aEvaluacionLegajoCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EvalFirma.NICKNAME,
             DBEvalFirma.SELECT_BY_EVALUACION,
             aEvaluacionLegajoCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
