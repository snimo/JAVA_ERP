package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.EvalCargaResul;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEvalCargaResul extends DBObjetoPersistente {

  public static final String OID_EVAL_CARGA = "oid_eval_carga";
  public static final String OID_EVAL_CAB = "oid_eval_cab";
  public static final String OID_COMPETENCIA = "oid_competencia";
  public static final String NRO_GRADO = "nro_grado";
  public static final String PORC_CUMPLI = "porc_cumpli";
  public static final String ACTIVO = "activo";
  public static final String PUNTAJE = "puntaje";
  
  public static final int SELECT_BY_EVALUACION = 100;
  public static final int SELECT_BY_EVAL_COMPE = 101;

  public DBEvalCargaResul() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_CARGA = 1;
    final int OID_EVAL_CAB = 2;
    final int OID_COMPETENCIA = 3;
    final int NRO_GRADO = 4;
    final int PORC_CUMPLI = 5;
    final int ACTIVO = 6;
    final int PUNTAJE = 7;

    EvalCargaResul pers = (EvalCargaResul) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhEvalCargaResul "+
                     " ( "+
                      "OID_EVAL_CARGA,"+
                      "OID_EVAL_CAB,"+
                      "OID_COMPETENCIA,"+
                      "NRO_GRADO,"+
                      "PORC_CUMPLI,"+
                      "ACTIVO,PUNTAJE)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EVAL_CARGA,pers.getOID());
    qInsert.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    qInsert.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    if (pers.getNro_grado()!=null)
    	qInsert.setInt(NRO_GRADO,pers.getNro_grado().intValue());
    else
    	qInsert.setNull(NRO_GRADO,Types.INTEGER);
    if (pers.getPorc_cumpli()!=null) 
      qInsert.setDouble(PORC_CUMPLI,pers.getPorc_cumpli().doubleValue());
    else
      qInsert.setNull(PORC_CUMPLI,java.sql.Types.DOUBLE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getPuntaje()!=null)
    	qInsert.setDouble(PUNTAJE, pers.getPuntaje().doubleValue());
    else
    	qInsert.setDouble(PUNTAJE, 0);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_CAB = 1;
    final int OID_COMPETENCIA = 2;
    final int NRO_GRADO = 3;
    final int PORC_CUMPLI = 4;
    final int ACTIVO = 5;
    final int PUNTAJE = 6;
    final int OID_EVAL_CARGA = 7;

    EvalCargaResul pers = (EvalCargaResul) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhEvalCargaResul set "+
              "oid_eval_cab=?"+ 
              ",oid_competencia=?"+ 
              ",nro_grado=?"+ 
              ",porc_cumpli=?"+ 
              ",activo=?"+ 
              ",puntaje=?"+
                 " where " +
                 " oid_eval_carga=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_CARGA,pers.getOID());
    qUpdate.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    qUpdate.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    if (pers.getNro_grado()!=null)
    	qUpdate.setInt(NRO_GRADO,pers.getNro_grado().intValue());
    else
    	qUpdate.setNull(NRO_GRADO,Types.INTEGER);
    if (pers.getPorc_cumpli()!=null) 
      qUpdate.setDouble(PORC_CUMPLI,pers.getPorc_cumpli().doubleValue());
    else
      qUpdate.setNull(PORC_CUMPLI,java.sql.Types.DOUBLE);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getPuntaje()!=null)
    	qUpdate.setDouble(PUNTAJE, pers.getPuntaje().doubleValue());
    else
    	qUpdate.setDouble(PUNTAJE, 0);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EVAL_CARGA = 1; 
    EvalCargaResul pers = (EvalCargaResul) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEvalCargaResul "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_eval_carga=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_CARGA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EVAL_CARGA = 1; 
    EvalCargaResul pers = (EvalCargaResul) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEvalCargaResul "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_eval_carga=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_CARGA, pers.getOID()); 
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
      case SELECT_BY_EVAL_COMPE: {
          ps = this.selectByEvalCompe(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EVAL_CARGA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEvalCargaResul "); 
    textSQL.append(" WHERE oid_eval_carga = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EVAL_CARGA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByEvalCompe(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhEvalCargaResul "); 
	    textSQL.append(" WHERE oid_eval_cab = ? and oid_competencia = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EvaluacionLegajoCab evaluacionLegajoCab = (EvaluacionLegajoCab) condiciones.get(EvaluacionLegajoCab.NICKNAME);
	    Competencia competencia = (Competencia) condiciones.get(Competencia.NICKNAME);
	    querySelect.setInt(1, evaluacionLegajoCab.getOID()); 
	    querySelect.setInt(2, competencia.getOID());
	    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByEvaluacion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhEvalCargaResul ");  
	    textSQL.append(" WHERE oid_eval_cab = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EvaluacionLegajoCab evaluacionLegajoCab = (EvaluacionLegajoCab) aCondiciones; 
	    querySelect.setInt(1, evaluacionLegajoCab.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEvalCargaResul "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_eval_carga oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhEvalCargaResul");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 

  
  public static List getEvalCargaResul(EvaluacionLegajoCab aEvaluacionLegajoCab,ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EvalCargaResul.NICKNAME,
             DBEvalCargaResul.SELECT_BY_EVALUACION,
             aEvaluacionLegajoCab,
             new ListObserver(),
             aSesion);
  }
  
  public static EvalCargaResul getEvalCargaResul(
		  EvaluacionLegajoCab evaluacion,
		  Competencia competencia,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(EvaluacionLegajoCab.NICKNAME, evaluacion);
	  condiciones.put(Competencia.NICKNAME, competencia);
	  return (EvalCargaResul) ObjetoLogico.getObjects(EvalCargaResul.NICKNAME,
			  				DBEvalCargaResul.SELECT_BY_EVAL_COMPE,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
