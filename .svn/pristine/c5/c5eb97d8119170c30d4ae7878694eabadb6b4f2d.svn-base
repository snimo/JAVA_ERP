package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;
import com.srn.erp.pagos.bm.RendicionFondoFijoComproImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRendicionFondoFijoComproImpu extends DBObjetoPersistente {

  public static final String OID_CCO_PROV_IMPU = "oid_cco_prov_impu";
  public static final String OID_REND_FF_DET = "oid_rend_ff_det";
  public static final String OID_AI = "oid_ai";
  public static final String IMPORTE = "importe";
  public static final String COMENTARIO = "comentario";
  
  public static final int SELECT_BY_RENF_FF_DET = 100; 

  public DBRendicionFondoFijoComproImpu() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_PROV_IMPU = 1;
    final int OID_REND_FF_DET = 2;
    final int OID_AI = 3;
    final int IMPORTE = 4;
    final int COMENTARIO = 5;

    RendicionFondoFijoComproImpu pers = (RendicionFondoFijoComproImpu) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opRendFFComproImpu "+
                     " ( "+
                      "OID_CCO_PROV_IMPU,"+
                      "OID_REND_FF_DET,"+
                      "OID_AI,"+
                      "IMPORTE,"+
                      "COMENTARIO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CCO_PROV_IMPU,pers.getOID());
    qInsert.setInt(OID_REND_FF_DET,pers.getRendicion_det().getOID());
    qInsert.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REND_FF_DET = 1;
    final int OID_AI = 2;
    final int IMPORTE = 3;
    final int COMENTARIO = 4;
    final int OID_CCO_PROV_IMPU = 5;

    RendicionFondoFijoComproImpu pers = (RendicionFondoFijoComproImpu) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opRendFFComproImpu set "+
              "oid_rend_ff_det=?"+ 
              ",oid_ai=?"+ 
              ",importe=?"+ 
              ",comentario=?"+ 
                 " where " +
                 " oid_cco_prov_impu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_PROV_IMPU,pers.getOID());
    qUpdate.setInt(OID_REND_FF_DET,pers.getRendicion_det().getOID());
    qUpdate.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_PROV_IMPU = 1; 
    RendicionFondoFijoComproImpu pers = (RendicionFondoFijoComproImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opRendFFComproImpu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cco_prov_impu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_PROV_IMPU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_PROV_IMPU = 1; 
    RendicionFondoFijoComproImpu pers = (RendicionFondoFijoComproImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opRendFFComproImpu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco_prov_impu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_PROV_IMPU, pers.getOID()); 
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
      case SELECT_BY_RENF_FF_DET: {
          ps = this.selectByRendFFDet(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CCO_PROV_IMPU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opRendFFComproImpu "); 
    textSQL.append(" WHERE oid_cco_prov_impu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CCO_PROV_IMPU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByRendFFDet(Object aCondiciones) throws BaseException, SQLException { 

	    final int OID_CCO_PROV_IMPU = 1; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  opRendFFComproImpu "); 
	    textSQL.append(" WHERE oid_rend_ff_det = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RendicionFondoFijoCompro rendFFCompro = (RendicionFondoFijoCompro) aCondiciones;
	    querySelect.setInt(1, rendFFCompro.getOID()); 
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opRendFFComproImpu "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_prov_impu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opRendFFComproImpu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getImputacionesComproProv(RendicionFondoFijoCompro rendFondoFijoCompro,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RendicionFondoFijoComproImpu.NICKNAME,
             DBRendicionFondoFijoComproImpu.SELECT_BY_RENF_FF_DET,
             rendFondoFijoCompro,
             new ListObserver(),
             aSesion);
  }
  
  
} 
