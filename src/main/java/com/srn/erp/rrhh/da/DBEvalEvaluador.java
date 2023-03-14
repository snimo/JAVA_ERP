package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.EvalEvaluador;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEvalEvaluador extends DBObjetoPersistente {

  public static final String OID_EVAL_EVALUADOR = "oid_eval_evaluador";
  public static final String OID_EVAL_CAB = "oid_eval_cab";
  public static final String ACTIVO = "activo";
  public static final String FIRMADO = "firmado";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String FEC_FIRMADO = "fec_firmado";
  
  public static final int SELECT_BY_EVALUACION = 100;

  public DBEvalEvaluador() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_EVALUADOR = 1;
    final int OID_EVAL_CAB = 2;
    final int ACTIVO = 3;
    final int FIRMADO = 4;
    final int OID_LEGAJO = 5;
    final int FEC_FIRMADO = 6;

    EvalEvaluador pers = (EvalEvaluador) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhEvalEvaluador "+
                     " ( "+
                      "OID_EVAL_EVALUADOR,"+
                      "OID_EVAL_CAB,"+
                      "ACTIVO,"+
                      "FIRMADO,"+
                      "OID_LEGAJO,"+
                      "FEC_FIRMADO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EVAL_EVALUADOR,pers.getOID());
    qInsert.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(FIRMADO,pers.isFirmado().booleanValue());
    if (pers.getLegajo()!=null) 
      qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    else
      qInsert.setNull(OID_LEGAJO,java.sql.Types.INTEGER);
    if (pers.getFec_firmado()!=null) 
      qInsert.setDate(FEC_FIRMADO,new java.sql.Date(pers.getFec_firmado().getTime()));
    else
      qInsert.setNull(FEC_FIRMADO,java.sql.Types.DATE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_CAB = 1;
    final int ACTIVO = 2;
    final int FIRMADO = 3;
    final int OID_LEGAJO = 4;
    final int FEC_FIRMADO = 5;
    final int OID_EVAL_EVALUADOR = 6;

    EvalEvaluador pers = (EvalEvaluador) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhEvalEvaluador set "+
              "oid_eval_cab=?"+ 
              ",activo=?"+ 
              ",firmado=?"+ 
              ",oid_legajo=?"+ 
              ",fec_firmado=?"+ 
                 " where " +
                 " oid_eval_evaluador=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_EVALUADOR,pers.getOID());
    qUpdate.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(FIRMADO,pers.isFirmado().booleanValue());
    if (pers.getLegajo()!=null) 
      qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    else
      qUpdate.setNull(OID_LEGAJO,java.sql.Types.INTEGER);
    if (pers.getFec_firmado()!=null) 
      qUpdate.setDate(FEC_FIRMADO,new java.sql.Date(pers.getFec_firmado().getTime()));
    else
      qUpdate.setNull(FEC_FIRMADO,java.sql.Types.DATE);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EVAL_EVALUADOR = 1; 
    EvalEvaluador pers = (EvalEvaluador) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEvalEvaluador "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_eval_evaluador=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_EVALUADOR, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EVAL_EVALUADOR = 1; 
    EvalEvaluador pers = (EvalEvaluador) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEvalEvaluador "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_eval_evaluador=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_EVALUADOR, pers.getOID()); 
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

    final int OID_EVAL_EVALUADOR = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEvalEvaluador "); 
    textSQL.append(" WHERE oid_eval_evaluador = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EVAL_EVALUADOR, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByEvaluacion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhEvalEvaluador "); 
	    textSQL.append(" WHERE oid_eval_cab  = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EvaluacionLegajoCab evaluacion = (EvaluacionLegajoCab) aCondiciones; 
	    querySelect.setInt(1, evaluacion.getOID()); 
	    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEvalEvaluador "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_eval_evaluador oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhEvalEvaluador");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEvalEvaluadores(EvaluacionLegajoCab aEvaluacionLegajoCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EvalEvaluador.NICKNAME,
             DBEvalEvaluador.SELECT_BY_EVALUACION,
             aEvaluacionLegajoCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
