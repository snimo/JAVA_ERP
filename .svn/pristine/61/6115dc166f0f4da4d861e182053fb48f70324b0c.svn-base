package com.srn.erp.cip.da;

import java.sql.*;

import com.srn.erp.cip.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.*;

public class DBRotaPayroll extends DBObjetoPersistente {

  public static final String OID_ROTA = "oid_rota";
  public static final String TRACODIGO = "tracodigo";
  public static final String TRADESCRIP = "tradescrip";
  public static final String TRAHORAINI = "trahoraini";
  public static final String TRAHORAFIN = "trahorafin";
  public static final String ACTIVO = "activo";
  
  public static final int TRUNCATE_TABLE_ROTA = 100;

  public DBRotaPayroll() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ROTA = 1;
    final int TRACODIGO = 2;
    final int TRADESCRIP = 3;
    final int TRAHORAINI = 4;
    final int TRAHORAFIN = 5;
    final int ACTIVO = 6;

    RotaPayroll pers = (RotaPayroll) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into payRotas "+
                     " ( "+
                      "OID_ROTA,"+
                      "TRACODIGO,"+
                      "TRADESCRIP,"+
                      "TRAHORAINI,"+
                      "TRAHORAFIN,"+
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
    qInsert.setInt(OID_ROTA,pers.getOID());
    qInsert.setString(TRACODIGO,pers.getTracodigo());
    qInsert.setString(TRADESCRIP,pers.getTradescrip());
    qInsert.setString(TRAHORAINI,pers.getTrahoraini());
    qInsert.setString(TRAHORAFIN,pers.getTrahorafin());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int TRACODIGO = 1;
    final int TRADESCRIP = 2;
    final int TRAHORAINI = 3;
    final int TRAHORAFIN = 4;
    final int ACTIVO = 5;
    final int OID_ROTA = 6;

    RotaPayroll pers = (RotaPayroll) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update payRotas set "+
              "tracodigo=?"+ 
              ",tradescrip=?"+ 
              ",trahoraini=?"+ 
              ",trahorafin=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_rota=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA,pers.getOID());
    qUpdate.setString(TRACODIGO,pers.getTracodigo());
    qUpdate.setString(TRADESCRIP,pers.getTradescrip());
    qUpdate.setString(TRAHORAINI,pers.getTrahoraini());
    qUpdate.setString(TRAHORAFIN,pers.getTrahorafin());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROTA = 1; 
    RotaPayroll pers = (RotaPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payRotas "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_rota=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROTA = 1; 
    RotaPayroll pers = (RotaPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payRotas "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rota=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA, pers.getOID()); 
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
      case TRUNCATE_TABLE_ROTA: {
          ps = this.truncarTablaPayRota(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ROTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payRotas "); 
    textSQL.append(" WHERE oid_rota = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ROTA, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payRotas "); 
    textSQL.append(" WHERE tracodigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rota oid,tracodigo codigo, tradescrip descripcion ,activo ");
    textSQL.append(" from payRotas");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement truncarTablaPayRota(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("truncate table payRotas ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
}

public static void truncarTablaRotaPayroll(ISesion aSesion)
	  throws BaseException {
	  	ObjetoLogico.getObjects(RotaPayroll.NICKNAME,
		  				DBRotaPayroll.TRUNCATE_TABLE_ROTA,
		  				null,
		  				null,
		  				aSesion);
}
  
  
} 
