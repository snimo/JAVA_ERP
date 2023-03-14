package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.cip.bm.NovedadGLMPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class DBNovedadGLMPayroll extends DBObjetoPersistente {

  public static final String OID_TBGL_NOV = "oid_tbgl_nov";
  public static final String CODIGO = "codigo";
  public static final String FECHAINI = "fechaini";
  public static final String FECHAFIN = "fechafin";
  public static final String PROCONPE = "PROCONPE";
  public static final String ACTIVO = "activo";
  
  public static final int TRUNCATE_TABLE_NOVEDAD = 100;

  public DBNovedadGLMPayroll() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TBGL_NOV = 1;
    final int CODIGO = 2;
    final int FECHAINI = 3;
    final int FECHAFIN = 4;
    final int PROCONPE = 5;
    final int ACTIVO = 6;

    NovedadGLMPayroll pers = (NovedadGLMPayroll) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into PayTBGLMNOV "+
                     " ( "+
                      "OID_TBGL_NOV,"+
                      "CODIGO,"+
                      "FECHAINI,"+
                      "FECHAFIN,"+
                      "PROCONPE,"+
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
    qInsert.setInt(OID_TBGL_NOV,pers.getOID());
    if (pers.getCodigo()!=null)
    	qInsert.setString(CODIGO,pers.getCodigo());
    else
    	qInsert.setNull(CODIGO,Types.CHAR);
    if (pers.getFechaini()!=null)
    	qInsert.setDate(FECHAINI,new java.sql.Date(pers.getFechaini().getTime()));
    else
    	qInsert.setNull(FECHAINI,Types.DATE);
    if (pers.getFechafin()!=null)
    	qInsert.setDate(FECHAFIN,new java.sql.Date(pers.getFechafin().getTime()));
    else
    	qInsert.setNull(FECHAFIN,Types.DATE);
    if (pers.getProconpe()!=null)
    	qInsert.setDate(PROCONPE,new java.sql.Date(pers.getProconpe().getTime()));
    else
    	qInsert.setNull(PROCONPE,Types.DATE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int FECHAINI = 2;
    final int FECHAFIN = 3;
    final int PROCONPE = 4;
    final int ACTIVO = 5;
    final int OID_TBGL_NOV = 6;

    NovedadGLMPayroll pers = (NovedadGLMPayroll) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update PayTBGLMNOV set "+
              "codigo=?"+ 
              ",fechaini=?"+ 
              ",fechafin=?"+ 
              ",PROCONPE=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_tbgl_nov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TBGL_NOV,pers.getOID());
    if (pers.getCodigo()!=null)
    	qUpdate.setString(CODIGO,pers.getCodigo());
    else
    	qUpdate.setNull(CODIGO,Types.CHAR);
    if (pers.getFechaini()!=null)
    	qUpdate.setDate(FECHAINI,new java.sql.Date(pers.getFechaini().getTime()));
    else
    	qUpdate.setNull(FECHAINI,Types.DATE);
    if (pers.getFechafin()!=null)
    	qUpdate.setDate(FECHAFIN,new java.sql.Date(pers.getFechafin().getTime()));
    else
    	qUpdate.setNull(FECHAFIN,Types.DATE);
    if (pers.getProconpe()!=null)
    	qUpdate.setDate(PROCONPE,new java.sql.Date(pers.getProconpe().getTime()));
    else
    	qUpdate.setNull(PROCONPE,Types.DATE);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TBGL_NOV = 1; 
    NovedadGLMPayroll pers = (NovedadGLMPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update PayTBGLMNOV "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tbgl_nov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TBGL_NOV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TBGL_NOV = 1; 
    NovedadGLMPayroll pers = (NovedadGLMPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update PayTBGLMNOV "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tbgl_nov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TBGL_NOV, pers.getOID()); 
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
      case TRUNCATE_TABLE_NOVEDAD: {
          ps = this.truncarTablaNovedad(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TBGL_NOV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  PayTBGLMNOV "); 
    textSQL.append(" WHERE oid_tbgl_nov = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TBGL_NOV, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  PayTBGLMNOV "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tbgl_nov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from PayTBGLMNOV");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement truncarTablaNovedad(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("truncate table PayTBGLMNOV ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
}

public static void truncarTablaNovedades(ISesion aSesion)
	  throws BaseException {
	  	ObjetoLogico.getObjects(NovedadGLMPayroll.NICKNAME,
	  					DBNovedadGLMPayroll.TRUNCATE_TABLE_NOVEDAD,
		  				null,
		  				null,
		  				aSesion);
}
  
  
} 
