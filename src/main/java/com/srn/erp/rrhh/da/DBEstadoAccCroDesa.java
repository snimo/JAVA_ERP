package com.srn.erp.rrhh.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBEstadoAccCroDesa extends DBObjetoPersistente {

  public static final String OID_ESTADO_ACC_CRO = "oid_estado_acc_cro";
  public static final String OID_ACCION_CRO = "oid_accion_cro";
  public static final String OID_VAL_CLASIF_EST = "oid_val_clasif_est";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ACCION_ESTADO = 100;
  public static final int SELECT_BY_ACCION = 101;

  public DBEstadoAccCroDesa() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTADO_ACC_CRO = 1;
    final int OID_ACCION_CRO = 2;
    final int OID_VAL_CLASIF_EST = 3;
    final int ACTIVO = 4;

    EstadoAccCroDesa pers = (EstadoAccCroDesa) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhEstAccCro "+
                     " ( "+
                      "OID_ESTADO_ACC_CRO,"+
                      "OID_ACCION_CRO,"+
                      "OID_VAL_CLASIF_EST,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESTADO_ACC_CRO,pers.getOID());
    qInsert.setInt(OID_ACCION_CRO,pers.getAccion().getOID());
    qInsert.setInt(OID_VAL_CLASIF_EST,pers.getValor_clasif_estado().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ACCION_CRO = 1;
    final int OID_VAL_CLASIF_EST = 2;
    final int ACTIVO = 3;
    final int OID_ESTADO_ACC_CRO = 4;

    EstadoAccCroDesa pers = (EstadoAccCroDesa) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhEstAccCro set "+
              "oid_accion_cro=?"+ 
              ",oid_val_clasif_est=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_estado_acc_cro=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_ACC_CRO,pers.getOID());
    qUpdate.setInt(OID_ACCION_CRO,pers.getAccion().getOID());
    qUpdate.setInt(OID_VAL_CLASIF_EST,pers.getValor_clasif_estado().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTADO_ACC_CRO = 1; 
    EstadoAccCroDesa pers = (EstadoAccCroDesa) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEstAccCro "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_estado_acc_cro=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_ACC_CRO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTADO_ACC_CRO = 1; 
    EstadoAccCroDesa pers = (EstadoAccCroDesa) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEstAccCro "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_estado_acc_cro=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_ACC_CRO, pers.getOID()); 
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
      case SELECT_BY_ACCION_ESTADO: {
        ps = this.selectByAccionEstado(aCondiciones); 
        break; 
      }
      case SELECT_BY_ACCION: {
          ps = this.selectByAccion(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESTADO_ACC_CRO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEstAccCro "); 
    textSQL.append(" WHERE oid_estado_acc_cro = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESTADO_ACC_CRO, oid); 
    return querySelect; 
  }

  
  private PreparedStatement selectByAccion(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhEstAccCro "); 
	    textSQL.append(" WHERE oid_accion_cro = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    AccCronoDesa accCronoDesa = (AccCronoDesa) aCondiciones;
	    querySelect.setInt(1, accCronoDesa.getOID());
	    return querySelect;
	    
  }

  private PreparedStatement selectByAccionEstado(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhEstAccCro "); 
	    textSQL.append(" WHERE oid_accion_cro = ? and oid_val_clasif_est = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    AccCronoDesa accCronoDesa = (AccCronoDesa) condiciones.get(AccCronoDesa.NICKNAME);
	    ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) condiciones.get("ESTADO");
	    querySelect.setInt(1, accCronoDesa.getOID());
	    querySelect.setInt(2, valorClasifEnt.getOID());
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEstAccCro "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_estado_acc_cro oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhEstAccCro");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static EstadoAccCroDesa getEstadoAccCroDesa(AccCronoDesa accCronoDesa,
		  ValorClasificadorEntidad valorClasifEntEst,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(AccCronoDesa.NICKNAME, accCronoDesa);
	  condiciones.put("ESTADO", valorClasifEntEst);
	  return (EstadoAccCroDesa) ObjetoLogico.getObjects(EstadoAccCroDesa.NICKNAME,
			  				DBEstadoAccCroDesa.SELECT_BY_ACCION_ESTADO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getEstados(AccCronoDesa aAccCronoDesa,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EstadoAccCroDesa.NICKNAME,
             DBEstadoAccCroDesa.SELECT_BY_ACCION,
             aAccCronoDesa,
             new ListObserver(),
             aSesion);
  }
  
  
  
  
} 
