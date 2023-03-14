package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.rrhh.bm.EvalAspectos;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEvalAspectos extends DBObjetoPersistente {

  public static final String OID_EVAL_ASP = "oid_eval_asp";
  public static final String OID_EVAL_CAB = "oid_eval_cab";
  public static final String TIPO_ASPECTO = "tipo_aspecto";
  public static final String ACTIVO = "activo";
  public static final String FEC_ALTA = "fec_alta";
  public static final String ASPECTO = "aspecto";
  public static final String OID_USU_ALTA = "oid_usu_alta";
  public static final String FEC_MODIF = "fec_modif";
  public static final String OID_USU_MODIF = "oid_usu_modif";
  
  public static final int SELECT_BY_EVALUACION = 100;

  public DBEvalAspectos() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_ASP = 1;
    final int OID_EVAL_CAB = 2;
    final int TIPO_ASPECTO = 3;
    final int ACTIVO = 4;
    final int FEC_ALTA = 5;
    final int ASPECTO = 6;
    final int OID_USU_ALTA = 7;
    final int FEC_MODIF = 8;
    final int OID_USU_MODIF = 9;

    EvalAspectos pers = (EvalAspectos) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhEvalAspectos "+
                     " ( "+
                      "OID_EVAL_ASP,"+
                      "OID_EVAL_CAB,"+
                      "TIPO_ASPECTO,"+
                      "ACTIVO,"+
                      "FEC_ALTA,"+
                      "ASPECTO,"+
                      "OID_USU_ALTA,"+
                      "FEC_MODIF,"+
                      "OID_USU_MODIF)"+ 
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
    qInsert.setInt(OID_EVAL_ASP,pers.getOID());
    qInsert.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    qInsert.setString(TIPO_ASPECTO,pers.getTipo_aspecto());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setDate(FEC_ALTA,new java.sql.Date(pers.getFec_alta().getTime()));
    qInsert.setString(ASPECTO,pers.getAspecto());
    qInsert.setInt(OID_USU_ALTA,pers.getUsuario_alta().getOID());
    if (pers.getFec_modif()!=null)
    	qInsert.setDate(FEC_MODIF,new java.sql.Date(pers.getFec_modif().getTime()));
    else
    	qInsert.setNull(FEC_MODIF,Types.DATE);
    if (pers.getUsuario_modif()!=null)
    	qInsert.setInt(OID_USU_MODIF,pers.getUsuario_modif().getOID());
    else
    	qInsert.setNull(OID_USU_MODIF,Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_CAB = 1;
    final int TIPO_ASPECTO = 2;
    final int ACTIVO = 3;
    final int FEC_ALTA = 4;
    final int ASPECTO = 5;
    final int OID_USU_ALTA = 6;
    final int FEC_MODIF = 7;
    final int OID_USU_MODIF = 8;
    final int OID_EVAL_ASP = 9;

    EvalAspectos pers = (EvalAspectos) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhEvalAspectos set "+
              "oid_eval_cab=?"+ 
              ",tipo_aspecto=?"+ 
              ",activo=?"+ 
              ",fec_alta=?"+ 
              ",aspecto=?"+ 
              ",oid_usu_alta=?"+ 
              ",fec_modif=?"+ 
              ",oid_usu_modif=?"+ 
                 " where " +
                 " oid_eval_asp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_ASP,pers.getOID());
    qUpdate.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    qUpdate.setString(TIPO_ASPECTO,pers.getTipo_aspecto());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setDate(FEC_ALTA,new java.sql.Date(pers.getFec_alta().getTime()));
    qUpdate.setString(ASPECTO,pers.getAspecto());
    qUpdate.setInt(OID_USU_ALTA,pers.getUsuario_alta().getOID());
    if (pers.getFec_modif()!=null)
    	qUpdate.setDate(FEC_MODIF,new java.sql.Date(pers.getFec_modif().getTime()));
    else
    	qUpdate.setNull(FEC_MODIF,Types.DATE);
    if (pers.getUsuario_modif()!=null)	
    	qUpdate.setInt(OID_USU_MODIF,pers.getUsuario_modif().getOID());
    else
    	qUpdate.setNull(OID_USU_MODIF,Types.INTEGER);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EVAL_ASP = 1; 
    EvalAspectos pers = (EvalAspectos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEvalAspectos "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_eval_asp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_ASP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EVAL_ASP = 1; 
    EvalAspectos pers = (EvalAspectos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEvalAspectos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_eval_asp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_ASP, pers.getOID()); 
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

    final int OID_EVAL_ASP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEvalAspectos "); 
    textSQL.append(" WHERE oid_eval_asp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EVAL_ASP, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByEvaluacion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhEvalAspectos "); 
	    textSQL.append(" WHERE oid_eval_cab = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EvaluacionLegajoCab evaluacion = (EvaluacionLegajoCab) aCondiciones; 
	    querySelect.setInt(1, evaluacion.getOID()); 
	    return querySelect; 
  }
  


  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEvalAspectos "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_eval_asp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhEvalAspectos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEvalAspectos(EvaluacionLegajoCab aEvaluacionLegajoCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EvalAspectos.NICKNAME,
             DBEvalAspectos.SELECT_BY_EVALUACION,
             aEvaluacionLegajoCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
