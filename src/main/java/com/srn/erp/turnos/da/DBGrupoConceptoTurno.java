package com.srn.erp.turnos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.turnos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBGrupoConceptoTurno extends DBObjetoPersistente {

  public static final String OID_GRUPO_CONC = "oid_grupo_conc";
  public static final String OID_DEUDA_CONC = "oid_deuda_conc";
  public static final String CONCEPTO = "concepto";
  
  public static final int SELECT_BY_DEUDA_CONCEPTO = 100;
  public static final int SELECT_BY_DEUDA_Y_CONCEPTO = 101;

  public DBGrupoConceptoTurno() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_CONC = 1;
    final int OID_DEUDA_CONC = 2;
    final int CONCEPTO = 3;

    GrupoConceptoTurno pers = (GrupoConceptoTurno) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuGrupoConcepto "+
                     " ( "+
                      "OID_GRUPO_CONC,"+
                      "OID_DEUDA_CONC,"+
                      "CONCEPTO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_CONC,pers.getOID());
    qInsert.setInt(OID_DEUDA_CONC,pers.getDeuda_por_concepto().getOID());
    qInsert.setString(CONCEPTO,pers.getConcepto());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEUDA_CONC = 1;
    final int CONCEPTO = 2;
    final int OID_GRUPO_CONC = 3;

    GrupoConceptoTurno pers = (GrupoConceptoTurno) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuGrupoConcepto set "+
              "oid_deuda_conc=?"+ 
              ",concepto=?"+ 
                 " where " +
                 " oid_grupo_conc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CONC,pers.getOID());
    qUpdate.setInt(OID_DEUDA_CONC,pers.getDeuda_por_concepto().getOID());
    qUpdate.setString(CONCEPTO,pers.getConcepto());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_CONC = 1; 
    GrupoConceptoTurno pers = (GrupoConceptoTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from tuGrupoConcepto "+
                     " where " + 
                     " oid_grupo_conc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CONC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_CONC = 1; 
    GrupoConceptoTurno pers = (GrupoConceptoTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuGrupoConcepto "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_conc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CONC, pers.getOID()); 
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
      case SELECT_BY_DEUDA_CONCEPTO: {
          ps = this.selectByDeudaConcepto(aCondiciones); 
          break; 
      }
      case SELECT_BY_DEUDA_Y_CONCEPTO: {
          ps = this.selectByDeudaYConcepto(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 
  
  private PreparedStatement selectByDeudaConcepto(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuGrupoConcepto "); 
	    textSQL.append(" WHERE oid_deuda_conc = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    DeudaPorConcTurno deudaPorConc = (DeudaPorConcTurno) aCondiciones;
	    querySelect.setInt(1, deudaPorConc.getOID()); 
	    
	    return querySelect; 
	  }
  
  private PreparedStatement selectByDeudaYConcepto(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuGrupoConcepto "); 
	    textSQL.append(" WHERE oid_deuda_conc = ? and concepto = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    DeudaPorConcTurno deudaPorConc = (DeudaPorConcTurno)condiciones.get(DeudaPorConcTurno.NICKNAME);
	    String concepto = (String)condiciones.get("CONCEPTO");
	    
	    querySelect.setInt(1, deudaPorConc.getOID()); 
	    querySelect.setString(2, concepto);
	    
	    return querySelect; 
	  }
  
  
  
  

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPO_CONC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuGrupoConcepto "); 
    textSQL.append(" WHERE oid_grupo_conc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_CONC, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuGrupoConcepto "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_conc oid, codigo, oid_deuda_conc descripcion ,activo ");
    textSQL.append(" from tuGrupoConcepto");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConceptos(DeudaPorConcTurno deudaPorConcepto,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(GrupoConceptoTurno.NICKNAME,
             DBGrupoConceptoTurno.SELECT_BY_DEUDA_CONCEPTO,
             deudaPorConcepto,
             new ListObserver(),
             aSesion);
  }
  
  public static GrupoConceptoTurno getGrupoConceptoTurno(DeudaPorConcTurno deudaPorConcepto,String concepto,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(DeudaPorConcTurno.NICKNAME, deudaPorConcepto);
	  condiciones.put("CONCEPTO", concepto);
	  
	  return (GrupoConceptoTurno) ObjetoLogico.getObjects(GrupoConceptoTurno.NICKNAME,
			  				DBGrupoConceptoTurno.SELECT_BY_DEUDA_Y_CONCEPTO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
  
} 
