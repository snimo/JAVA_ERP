package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioCalcInt;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBJuicioCalcInt extends DBObjetoPersistente {

  public static final String OID_CALC_INT = "oid_calc_int";
  public static final String OID_JUICIO = "oid_juicio";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String TIPO_TASA = "tipo_tasa";
  public static final String PORC = "porc";
  public static final String INTERES = "interes";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_JUICIO = 100;

  public DBJuicioCalcInt() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CALC_INT = 1;
    final int OID_JUICIO = 2;
    final int FEC_DESDE = 3;
    final int FEC_HASTA = 4;
    final int TIPO_TASA = 5;
    final int PORC = 6;
    final int INTERES = 7;
    final int ACTIVO = 8;

    JuicioCalcInt pers = (JuicioCalcInt) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into legJuiCalcInt "+
                     " ( "+
                      "OID_CALC_INT,"+
                      "OID_JUICIO,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "TIPO_TASA,"+
                      "PORC,"+
                      "INTERES,"+
                      "ACTIVO)"+ 
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
    qInsert.setInt(OID_CALC_INT,pers.getOID());
    qInsert.setInt(OID_JUICIO,pers.getJuicio().getOID());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qInsert.setString(TIPO_TASA,pers.getTipo_tasa());
    qInsert.setDouble(PORC,pers.getPorc().doubleValue());
    if (pers.getInteres()!=null)
    	qInsert.setDouble(INTERES,pers.getInteres().doubleValue());
    else
    	qInsert.setDouble(INTERES,0.0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_JUICIO = 1;
    final int FEC_DESDE = 2;
    final int FEC_HASTA = 3;
    final int TIPO_TASA = 4;
    final int PORC = 5;
    final int INTERES = 6;
    final int ACTIVO = 7;
    final int OID_CALC_INT = 8;

    JuicioCalcInt pers = (JuicioCalcInt) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update legJuiCalcInt set "+
              "oid_juicio=?"+ 
              ",fec_desde=?"+ 
              ",fec_hasta=?"+ 
              ",tipo_tasa=?"+ 
              ",porc=?"+ 
              ",interes=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_calc_int=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CALC_INT,pers.getOID());
    qUpdate.setInt(OID_JUICIO,pers.getJuicio().getOID());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qUpdate.setString(TIPO_TASA,pers.getTipo_tasa());
    qUpdate.setDouble(PORC,pers.getPorc().doubleValue());
    if (pers.getInteres()!=null)
    	qUpdate.setDouble(INTERES,pers.getInteres().doubleValue());
    else
    	qUpdate.setDouble(INTERES,0.0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CALC_INT = 1; 
    JuicioCalcInt pers = (JuicioCalcInt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update legJuiCalcInt "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_calc_int=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CALC_INT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CALC_INT = 1; 
    JuicioCalcInt pers = (JuicioCalcInt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update legJuiCalcInt "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_calc_int=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CALC_INT, pers.getOID()); 
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
      case SELECT_BY_JUICIO: {
          ps = this.selectByJuicio(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CALC_INT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  legJuiCalcInt "); 
    textSQL.append(" WHERE oid_calc_int = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CALC_INT, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByJuicio(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  legJuiCalcInt "); 
	    textSQL.append(" WHERE oid_juicio  = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Juicio juicio = (Juicio) aCondiciones; 
	    querySelect.setInt(1, juicio.getOID());
	    return querySelect;
	    
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  legJuiCalcInt "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_calc_int oid, codigo,  descripcion ,activo ");
    textSQL.append(" from legJuiCalcInt");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCalcInteres(
		  Juicio aJuicio,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(JuicioCalcInt.NICKNAME,
             DBJuicioCalcInt.SELECT_BY_JUICIO,
             aJuicio,
             new ListObserver(),
             aSesion);
  }  
  
} 
