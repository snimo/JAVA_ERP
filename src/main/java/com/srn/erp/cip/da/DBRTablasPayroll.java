package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.RTablasPayroll;
import com.srn.erp.cip.bm.RotaPayroll;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRTablasPayroll extends DBObjetoPersistente {

  public static final String OID_TABLA = "oid_tabla";
  public static final String COTAB = "cotab";
  public static final String CODIGO = "codigo";
  public static final String DESCRIP = "descrip";
  public static final String ACTIVO = "activo";
  
  public static final int TRUNCATE_TABLE_RTABLA = 100;
  public static final int SELECT_BY_COTAB = 101;

  public DBRTablasPayroll() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TABLA = 1;
    final int COTAB = 2;
    final int CODIGO = 3;
    final int DESCRIP = 4;
    final int ACTIVO = 5;

    RTablasPayroll pers = (RTablasPayroll) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into payRTablas "+
                     " ( "+
                      "OID_TABLA,"+
                      "COTAB,"+
                      "CODIGO,"+
                      "DESCRIP,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TABLA,pers.getOID());
    qInsert.setInt(COTAB,pers.getCotab().intValue());
    qInsert.setInt(CODIGO,pers.getCodigortabla().intValue());
    qInsert.setString(DESCRIP,pers.getDescrip());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int COTAB = 1;
    final int CODIGO = 2;
    final int DESCRIP = 3;
    final int ACTIVO = 4;
    final int OID_TABLA = 5;

    RTablasPayroll pers = (RTablasPayroll) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update payRTablas set "+
              "cotab=?"+ 
              ",codigo=?"+ 
              ",descrip=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_tabla=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TABLA,pers.getOID());
    qUpdate.setInt(COTAB,pers.getCotab().intValue());
    qUpdate.setInt(CODIGO,pers.getCodigortabla().intValue());
    qUpdate.setString(DESCRIP,pers.getDescrip());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TABLA = 1; 
    RTablasPayroll pers = (RTablasPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payRTablas "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tabla=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TABLA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TABLA = 1; 
    RTablasPayroll pers = (RTablasPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payRTablas "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tabla=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TABLA, pers.getOID()); 
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
      case TRUNCATE_TABLE_RTABLA: {
          ps = this.truncarTablaPayRTabla(aCondiciones); 
          break; 
      }
      case SELECT_BY_COTAB: {
          ps = this.selectByCotab(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TABLA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payRTablas "); 
    textSQL.append(" WHERE oid_tabla = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TABLA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCotab(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  payRTablas "); 
	    textSQL.append(" WHERE  cotab = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Integer cotab = (Integer) aCondiciones; 
	    querySelect.setInt(1, cotab.intValue()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payRTablas "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tabla oid, codigo,  descripcion ,activo ");
    textSQL.append(" from payRTablas");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement truncarTablaPayRTabla(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("truncate table payRTablas ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
 }

 public static void truncarTablaRTablaPayroll(ISesion aSesion)
	  throws BaseException {
	  	ObjetoLogico.getObjects(RTablasPayroll.NICKNAME,
		  				DBRTablasPayroll.TRUNCATE_TABLE_RTABLA,
		  				null,
		  				null,
		  				aSesion);
 }
 
 public static List getRTablasByCotab(Integer contab,
         ISesion aSesion) throws BaseException {
	 return (List) ObjetoLogico.getObjects(RTablasPayroll.NICKNAME,
            DBRTablasPayroll.SELECT_BY_COTAB,
            contab,
            new ListObserver(),
            aSesion);
 }
 
  
  
} 
