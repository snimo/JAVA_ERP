package com.srn.erp.rrhh.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBFirmaModeloEvaluacion extends DBObjetoPersistente {

  public static final String OID_MOV_EVAL_FIRM = "oid_mov_eval_firm";
  public static final String OID_COND_MOD = "oid_cond_mod";
  public static final String NRO_FIRMA = "nro_firma";
  public static final String TITULO = "titulo";
  public static final String OID_LEGAJO_FIRMA = "oid_legajo_firma";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CONDICION_MODELO = 100;

  public DBFirmaModeloEvaluacion() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOV_EVAL_FIRM = 1;
    final int OID_COND_MOD = 2;
    final int NRO_FIRMA = 3;
    final int TITULO = 4;
    final int OID_LEGAJO_FIRMA = 5;
    final int ACTIVO = 6;

    FirmaModeloEvaluacion pers = (FirmaModeloEvaluacion) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhModEvalFirm "+
                     " ( "+
                      "OID_MOV_EVAL_FIRM,"+
                      "OID_COND_MOD,"+
                      "NRO_FIRMA,"+
                      "TITULO,"+
                      "OID_LEGAJO_FIRMA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOV_EVAL_FIRM,pers.getOID());
    qInsert.setInt(OID_COND_MOD,pers.getCondicion_modelo().getOID());
    qInsert.setInt(NRO_FIRMA,pers.getNro_firma().intValue());
    qInsert.setString(TITULO,pers.getTitulo());
    if (pers.getLegajo_firma()!=null)
    	qInsert.setInt(OID_LEGAJO_FIRMA,pers.getLegajo_firma().getOID());
    else
    	qInsert.setNull(OID_LEGAJO_FIRMA,Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COND_MOD = 1;
    final int NRO_FIRMA = 2;
    final int TITULO = 3;
    final int OID_LEGAJO_FIRMA = 4;
    final int ACTIVO = 5;
    final int OID_MOV_EVAL_FIRM = 6;

    FirmaModeloEvaluacion pers = (FirmaModeloEvaluacion) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhModEvalFirm set "+
              "oid_cond_mod=?"+ 
              ",nro_firma=?"+ 
              ",titulo=?"+ 
              ",oid_legajo_firma=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_mov_eval_firm=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOV_EVAL_FIRM,pers.getOID());
    qUpdate.setInt(OID_COND_MOD,pers.getCondicion_modelo().getOID());
    qUpdate.setInt(NRO_FIRMA,pers.getNro_firma().intValue());
    qUpdate.setString(TITULO,pers.getTitulo());
    if (pers.getLegajo_firma()!=null)
    	qUpdate.setInt(OID_LEGAJO_FIRMA,pers.getLegajo_firma().getOID());
    else
    	qUpdate.setNull(OID_LEGAJO_FIRMA,Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOV_EVAL_FIRM = 1; 
    FirmaModeloEvaluacion pers = (FirmaModeloEvaluacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModEvalFirm "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mov_eval_firm=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOV_EVAL_FIRM, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOV_EVAL_FIRM = 1; 
    FirmaModeloEvaluacion pers = (FirmaModeloEvaluacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModEvalFirm "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mov_eval_firm=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOV_EVAL_FIRM, pers.getOID()); 
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
      case SELECT_BY_CONDICION_MODELO: {
        ps = this.selectByCondicionModelo(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOV_EVAL_FIRM = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModEvalFirm "); 
    textSQL.append(" WHERE oid_mov_eval_firm = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOV_EVAL_FIRM, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCondicionModelo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhModEvalFirm "); 
	    textSQL.append(" WHERE oid_cond_mod = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CondModEvalCab condModEvalCab = (CondModEvalCab) aCondiciones; 
	    querySelect.setInt(1, condModEvalCab.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModEvalFirm "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(1, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mov_eval_firm oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhModEvalFirm");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getFirmasModeloEval(CondModEvalCab condModEvalCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(FirmaModeloEvaluacion.NICKNAME,
             DBFirmaModeloEvaluacion.SELECT_BY_CONDICION_MODELO,
             condModEvalCab,
             new ListObserver(),
             aSesion);
  }

} 
