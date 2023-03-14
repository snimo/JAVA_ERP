package com.srn.erp.produccion.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.produccion.bm.AlternativaFabricacion;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAlternativaFabricacion extends DBObjetoPersistente {

  public static final String OID_ALTER_FABRI = "oid_alter_fabri";
  public static final String OID_REC_CAB = "oid_rec_cab";
  public static final String ALTERNATIVA = "alternativa";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PRODUCTO = 100;

  public DBAlternativaFabricacion() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ALTER_FABRI = 1;
    final int OID_REC_CAB = 2;
    final int ALTERNATIVA = 3;
    final int ACTIVO = 4;

    AlternativaFabricacion pers = (AlternativaFabricacion) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into prAlterFabri "+
                     " ( "+
                      "OID_ALTER_FABRI,"+
                      "OID_REC_CAB,"+
                      "ALTERNATIVA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ALTER_FABRI,pers.getOID());
    qInsert.setInt(OID_REC_CAB,pers.getReceta().getOID());
    qInsert.setString(ALTERNATIVA,pers.getAlternativa());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REC_CAB = 1;
    final int ALTERNATIVA = 2;
    final int ACTIVO = 3;
    final int OID_ALTER_FABRI = 4;

    AlternativaFabricacion pers = (AlternativaFabricacion) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update prAlterFabri set "+
              "oid_rec_cab=?"+ 
              ",alternativa=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_alter_fabri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ALTER_FABRI,pers.getOID());
    qUpdate.setInt(OID_REC_CAB,pers.getReceta().getOID());
    qUpdate.setString(ALTERNATIVA,pers.getAlternativa());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ALTER_FABRI = 1; 
    AlternativaFabricacion pers = (AlternativaFabricacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prAlterFabri "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_alter_fabri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ALTER_FABRI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ALTER_FABRI = 1; 
    AlternativaFabricacion pers = (AlternativaFabricacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prAlterFabri "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_alter_fabri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ALTER_FABRI, pers.getOID()); 
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
      case SELECT_BY_PRODUCTO: {
          ps = this.selectByProducto(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ALTER_FABRI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prAlterFabri "); 
    textSQL.append(" WHERE oid_alter_fabri = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ALTER_FABRI, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByProducto(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  prAlterFabri a, prRecCab b "); 
	    textSQL.append(" WHERE a.oid_rec_cab = b.oid_rec_cab and b.oid_producto = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Producto producto = (Producto) aCondiciones; 
	    querySelect.setInt(1, producto.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prAlterFabri "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_alter_fabri oid, codigo,  descripcion ,activo ");
    textSQL.append(" from prAlterFabri");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAlternativasFabricacion(Producto producto,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AlternativaFabricacion.NICKNAME,
             DBAlternativaFabricacion.SELECT_BY_PRODUCTO,
             producto,
             new ListObserver(),
             aSesion);
  }
  
  
} 
