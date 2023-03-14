package com.srn.erp.turnos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.turnos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBDeudaPorConcTurno extends DBObjetoPersistente {

  public static final String OID_DEUDA_CONC = "oid_deuda_conc";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String MAX_DIAS_ATRASO = "max_dias_atraso";
  public static final String MAX_DEUDA = "max_deuda";
  public static final String ACTIVO = "activo";
  public static final String CANT_MAX_PERI_DEUDA = "cant_max_peri_deu";
  
  public static final int SELECT_BY_COMPO_ACTIVO = 100;

  public DBDeudaPorConcTurno() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEUDA_CONC = 1;
    final int DESCRIPCION = 2;
    final int COMPORTAMIENTO = 3;
    final int MAX_DIAS_ATRASO = 4;
    final int MAX_DEUDA = 5;
    final int ACTIVO = 6;
    final int CANT_MAX_PERI_DEU = 7;

    DeudaPorConcTurno pers = (DeudaPorConcTurno) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuDeudaPorConc "+
                     " ( "+
                      "OID_DEUDA_CONC,"+
                      "DESCRIPCION,"+
                      "COMPORTAMIENTO,"+
                      "MAX_DIAS_ATRASO,"+
                      "MAX_DEUDA,"+
                      "ACTIVO,CANT_MAX_PERI_DEU)"+ 
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
    qInsert.setInt(OID_DEUDA_CONC,pers.getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    qInsert.setInt(MAX_DIAS_ATRASO,pers.getMax_dias_atraso().intValue());
    qInsert.setDouble(MAX_DEUDA,pers.getMax_deuda().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCantMaxPeriDeuda()!=null)
    	qInsert.setInt(CANT_MAX_PERI_DEU, pers.getCantMaxPeriDeuda().intValue());
    else
    	qInsert.setInt(CANT_MAX_PERI_DEU, 0);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int DESCRIPCION = 1;
    final int COMPORTAMIENTO = 2;
    final int MAX_DIAS_ATRASO = 3;
    final int MAX_DEUDA = 4;
    final int ACTIVO = 5;
    final int CANT_MAX_PERI_DEU = 6;
    final int OID_DEUDA_CONC = 7;

    DeudaPorConcTurno pers = (DeudaPorConcTurno) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuDeudaPorConc set "+
              "descripcion=?"+ 
              ",comportamiento=?"+ 
              ",max_dias_atraso=?"+ 
              ",max_deuda=?"+ 
              ",activo=?, cant_max_peri_deu = ? "+ 
                 " where " +
                 " oid_deuda_conc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEUDA_CONC,pers.getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    qUpdate.setInt(MAX_DIAS_ATRASO,pers.getMax_dias_atraso().intValue());
    qUpdate.setDouble(MAX_DEUDA,pers.getMax_deuda().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCantMaxPeriDeuda()!=null)
    	qUpdate.setInt(CANT_MAX_PERI_DEU, pers.getCantMaxPeriDeuda().intValue());
    else
    	qUpdate.setInt(CANT_MAX_PERI_DEU, 0);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEUDA_CONC = 1; 
    DeudaPorConcTurno pers = (DeudaPorConcTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuDeudaPorConc "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_deuda_conc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEUDA_CONC, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEUDA_CONC = 1; 
    DeudaPorConcTurno pers = (DeudaPorConcTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuDeudaPorConc "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_deuda_conc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEUDA_CONC, pers.getOID()); 
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
      case DBDeudaPorConcTurno.SELECT_BY_COMPO_ACTIVO: {
          ps = this.selectByComportamientoActivo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DEUDA_CONC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuDeudaPorConc "); 
    textSQL.append(" WHERE oid_deuda_conc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DEUDA_CONC, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByComportamientoActivo(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuDeudaPorConc "); 
	    textSQL.append(" WHERE comportamiento = ? and activo = 1 "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    String comportamiento = ( String) aCondiciones; 
	    querySelect.setString(1, comportamiento); 
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuDeudaPorConc "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_deuda_conc oid, descripcion codigo, descripcion descripcion ,activo ");
    textSQL.append(" from tuDeudaPorConc");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDeudasPorConc(String comportamiento,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DeudaPorConcTurno.NICKNAME,
             DBDeudaPorConcTurno.SELECT_BY_COMPO_ACTIVO,
             comportamiento,
             new ListObserver(),
             aSesion);
  }
  
  
} 
