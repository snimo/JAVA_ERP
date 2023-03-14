package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRendicionFondoFijoImpu extends DBObjetoPersistente {

  public static final String OID_REND_FF_IMPU = "oid_rend_ff_impu";
  public static final String OID_REND_FONDO = "oid_rend_fondo";
  public static final String OID_AI = "oid_ai";
  public static final String IMPORTE_DEBE = "importe_debe";
  public static final String IMPORTE_HABER = "importe_haber";
  public static final String COMENTARIO = "comentario";
  
  public static final int SELECT_BY_REND_FF = 100;

  public DBRendicionFondoFijoImpu() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REND_FF_IMPU = 1;
    final int OID_REND_FONDO = 2;
    final int OID_AI = 3;
    final int IMPORTE_DEBE = 4;
    final int IMPORTE_HABER = 5;
    final int COMENTARIO = 6;

    RendicionFondoFijoImpu pers = (RendicionFondoFijoImpu) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opRendFFImpu "+
                     " ( "+
                      "OID_REND_FF_IMPU,"+
                      "OID_REND_FONDO,"+
                      "OID_AI,"+
                      "IMPORTE_DEBE,"+
                      "IMPORTE_HABER,"+
                      "COMENTARIO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_REND_FF_IMPU,pers.getOID());
    qInsert.setInt(OID_REND_FONDO,pers.getRendicion_fondo().getOID());
    qInsert.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    if (pers.getImporte_debe()!=null)
      qInsert.setDouble(IMPORTE_DEBE,pers.getImporte_debe().doubleValue());
    else
      qInsert.setDouble(IMPORTE_DEBE,0);	
    if (pers.getImporte_haber()!=null)	
    	qInsert.setDouble(IMPORTE_HABER,pers.getImporte_haber().doubleValue());
    else
    	qInsert.setDouble(IMPORTE_HABER,0);
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REND_FONDO = 1;
    final int OID_AI = 2;
    final int IMPORTE_DEBE = 3;
    final int IMPORTE_HABER = 4;
    final int COMENTARIO = 5;
    final int OID_REND_FF_IMPU = 6;

    RendicionFondoFijoImpu pers = (RendicionFondoFijoImpu) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opRendFFImpu set "+
              "oid_rend_fondo=?"+ 
              ",oid_ai=?"+ 
              ",importe_debe=?"+ 
              ",importe_haber=?"+ 
              ",comentario=?"+ 
                 " where " +
                 " oid_rend_ff_impu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REND_FF_IMPU,pers.getOID());
    qUpdate.setInt(OID_REND_FONDO,pers.getRendicion_fondo().getOID());
    qUpdate.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    if (pers.getImporte_debe()!=null)
    	qUpdate.setDouble(IMPORTE_DEBE,pers.getImporte_debe().doubleValue());
      else
    	qUpdate.setDouble(IMPORTE_DEBE,0);	
    if (pers.getImporte_haber()!=null)	
    	qUpdate.setDouble(IMPORTE_HABER,pers.getImporte_haber().doubleValue());
      else
    	qUpdate.setDouble(IMPORTE_HABER,0);    
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REND_FF_IMPU = 1; 
    RendicionFondoFijoImpu pers = (RendicionFondoFijoImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opRendFFImpu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_rend_ff_impu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REND_FF_IMPU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REND_FF_IMPU = 1; 
    RendicionFondoFijoImpu pers = (RendicionFondoFijoImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opRendFFImpu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rend_ff_impu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REND_FF_IMPU, pers.getOID()); 
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
      case SELECT_BY_REND_FF: {
        ps = this.selectByRendFF(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 
  
  private PreparedStatement selectByRendFF(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  opRendFFImpu "); 
	    textSQL.append(" WHERE oid_rend_fondo = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RendicionFondoFijo rendFondoFijo = ( (RendicionFondoFijo) aCondiciones); 
	    querySelect.setInt(1, rendFondoFijo.getOID()); 
	    return querySelect; 
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_REND_FF_IMPU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opRendFFImpu "); 
    textSQL.append(" WHERE oid_rend_ff_impu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REND_FF_IMPU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opRendFFImpu "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rend_ff_impu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opRendFFImpu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getImputacionesRendFF(RendicionFondoFijo rendFondoFijo,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RendicionFondoFijoImpu.NICKNAME,
             DBRendicionFondoFijoImpu.SELECT_BY_REND_FF,
             rendFondoFijo,
             new ListObserver(),
             aSesion);
  }
    
  
} 
