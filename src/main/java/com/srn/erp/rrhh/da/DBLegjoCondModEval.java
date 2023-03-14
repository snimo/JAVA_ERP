package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.LegjoCondModEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBLegjoCondModEval extends DBObjetoPersistente {

  public static final String OID_LEG_COND_MOD = "oid_leg_cond_mod";
  public static final String OID_COND_MOD = "oid_cond_mod";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_COND_MODELO =  100;
  public static final int SELECT_BY_MODELO_LEGAJO  = 101;

  public DBLegjoCondModEval() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LEG_COND_MOD = 1;
    final int OID_COND_MOD = 2;
    final int OID_LEGAJO = 3;
    final int ACTIVO = 4;

    LegjoCondModEval pers = (LegjoCondModEval) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhLegCondMod "+
                     " ( "+
                      "OID_LEG_COND_MOD,"+
                      "OID_COND_MOD,"+
                      "OID_LEGAJO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LEG_COND_MOD,pers.getOID());
    qInsert.setInt(OID_COND_MOD,pers.getCondicion_modelo().getOID());
    qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COND_MOD = 1;
    final int OID_LEGAJO = 2;
    final int ACTIVO = 3;
    final int OID_LEG_COND_MOD = 4;

    LegjoCondModEval pers = (LegjoCondModEval) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhLegCondMod set "+
              "oid_cond_mod=?"+ 
              ",oid_legajo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_leg_cond_mod=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LEG_COND_MOD,pers.getOID());
    qUpdate.setInt(OID_COND_MOD,pers.getCondicion_modelo().getOID());
    qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LEG_COND_MOD = 1; 
    LegjoCondModEval pers = (LegjoCondModEval) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhLegCondMod "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_leg_cond_mod=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LEG_COND_MOD, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LEG_COND_MOD = 1; 
    LegjoCondModEval pers = (LegjoCondModEval) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhLegCondMod "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_leg_cond_mod=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LEG_COND_MOD, pers.getOID()); 
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
      case SELECT_BY_COND_MODELO: {
          ps = this.selectByCondicion(aCondiciones); 
          break; 
      }
      case SELECT_BY_MODELO_LEGAJO: {
          ps = this.selectByModeloLegajo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LEG_COND_MOD = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhLegCondMod "); 
    textSQL.append(" WHERE oid_leg_cond_mod = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LEG_COND_MOD, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCondicion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhLegCondMod "); 
	    textSQL.append(" WHERE oid_cond_mod = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CondModEvalCab condicion = (CondModEvalCab) aCondiciones; 
	    querySelect.setInt(1, condicion.getOID()); 
	    return querySelect; 
  }

  private PreparedStatement selectByModeloLegajo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhLegCondMod "); 
	    textSQL.append(" WHERE oid_cond_mod = ? and oid_legajo = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    CondModEvalCab condModelo = (CondModEvalCab) condiciones.get(CondModEvalCab.NICKNAME);
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
	    querySelect.setInt(1, condModelo.getOID()); 
	    querySelect.setInt(2, legajo.getOID());
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhLegCondMod "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_leg_cond_mod oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhLegCondMod");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getLegCondModEval(CondModEvalCab condModEvalCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(LegjoCondModEval.NICKNAME,
             DBLegjoCondModEval.SELECT_BY_COND_MODELO,
             condModEvalCab,
             new ListObserver(),
             aSesion);
  }

  public static LegjoCondModEval getLegajoCondModEval(
		  CondModEvalCab condModEvalCab,
		  Legajo aLegajo,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(CondModEvalCab.NICKNAME, condModEvalCab);
	  condiciones.put(Legajo.NICKNAME, aLegajo);
	  
	  return (LegjoCondModEval) ObjetoLogico.getObjects(LegjoCondModEval.NICKNAME,
			  				DBLegjoCondModEval.SELECT_BY_MODELO_LEGAJO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
