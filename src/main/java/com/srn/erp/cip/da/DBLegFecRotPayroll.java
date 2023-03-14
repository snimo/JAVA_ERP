package com.srn.erp.cip.da;

import java.sql.*;

import com.srn.erp.cip.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.*;

public class DBLegFecRotPayroll extends DBObjetoPersistente {

  public static final String OID_LEG_ROT_FEC = "oid_leg_rot_fec";
  public static final String ETRLEGAJO = "etrlegajo";
  public static final String ETRFECHA = "etrfecha";
  public static final String ETRTRAMO = "etrtramo";
  public static final String ACTIVO = "activo";
  
  public static final int TRUNCATE_TABLE_LEGROTFEC = 100;

  public DBLegFecRotPayroll() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LEG_ROT_FEC = 1;
    final int ETRLEGAJO = 2;
    final int ETRFECHA = 3;
    final int ETRTRAMO = 4;
    final int ACTIVO = 5;

    LegFecRotPayroll pers = (LegFecRotPayroll) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into payLegRotFec "+
                     " ( "+
                      "OID_LEG_ROT_FEC,"+
                      "ETRLEGAJO,"+
                      "ETRFECHA,"+
                      "ETRTRAMO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LEG_ROT_FEC,pers.getOID());
    if (pers.getEtrlegajo()!=null)
    	qInsert.setString(ETRLEGAJO,pers.getEtrlegajo());
    else
    	qInsert.setNull(ETRLEGAJO,Types.CHAR);
    if (pers.getEtrfecha()!=null) 
      qInsert.setDate(ETRFECHA,new java.sql.Date(pers.getEtrfecha().getTime()));
    else
      qInsert.setNull(ETRFECHA,java.sql.Types.DATE);
    if (pers.getEtrtramo()!=null)
    	qInsert.setString(ETRTRAMO,pers.getEtrtramo());
    else
    	qInsert.setNull(ETRTRAMO,Types.CHAR);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int ETRLEGAJO = 1;
    final int ETRFECHA = 2;
    final int ETRTRAMO = 3;
    final int ACTIVO = 4;
    final int OID_LEG_ROT_FEC = 5;

    LegFecRotPayroll pers = (LegFecRotPayroll) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update payLegRotFec set "+
              "etrlegajo=?"+ 
              ",etrfecha=?"+ 
              ",etrtramo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_leg_rot_fec=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LEG_ROT_FEC,pers.getOID());
    if (pers.getEtrlegajo()!=null)
    	qUpdate.setString(ETRLEGAJO,pers.getEtrlegajo());
    else
    	qUpdate.setNull(ETRLEGAJO,Types.CHAR);
    if (pers.getEtrfecha()!=null) 
      qUpdate.setDate(ETRFECHA,new java.sql.Date(pers.getEtrfecha().getTime()));
    else
      qUpdate.setNull(ETRFECHA,java.sql.Types.DATE);
    if (pers.getEtrtramo()!=null)
    	qUpdate.setString(ETRTRAMO,pers.getEtrtramo());
    else
    	qUpdate.setNull(ETRTRAMO,Types.CHAR);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LEG_ROT_FEC = 1; 
    LegFecRotPayroll pers = (LegFecRotPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payLegRotFec "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_leg_rot_fec=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LEG_ROT_FEC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LEG_ROT_FEC = 1; 
    LegFecRotPayroll pers = (LegFecRotPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payLegRotFec "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_leg_rot_fec=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LEG_ROT_FEC, pers.getOID()); 
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
      case TRUNCATE_TABLE_LEGROTFEC: {
    	ps = truncarTablaPayLegRotFec(aCondiciones);
    	break;
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LEG_ROT_FEC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payLegRotFec "); 
    textSQL.append(" WHERE oid_leg_rot_fec = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LEG_ROT_FEC, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payLegRotFec "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_leg_rot_fec oid, codigo,  descripcion ,activo ");
    textSQL.append(" from payLegRotFec");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  private PreparedStatement truncarTablaPayLegRotFec(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("truncate table payLegRotFec ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
  }

  public static void truncarTablaLegRotFecPayroll(ISesion aSesion)
	  throws BaseException {
	  	ObjetoLogico.getObjects(LegFecRotPayroll.NICKNAME,
		  				DBLegFecRotPayroll.TRUNCATE_TABLE_LEGROTFEC,
		  				null,
		  				null,
		  				aSesion);
  }

} 
