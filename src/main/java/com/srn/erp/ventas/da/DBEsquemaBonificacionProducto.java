package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.bm.EsquemaBonificacionProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEsquemaBonificacionProducto extends DBObjetoPersistente {

  public static final String OID_ESQ_BONIF_PROD = "oid_esq_bonif_prod";
  public static final String OID_ESQ_BONIF = "oid_esq_bonif";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESQ_BONIF_PRODUCTO = 100;
  
  public static final int SELECT_BY_ESQUEMA_BONIFICACION = 101;

  public DBEsquemaBonificacionProducto() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESQ_BONIF_PROD = 1;
    final int OID_ESQ_BONIF = 2;
    final int OID_PRODUCTO = 3;
    final int ACTIVO = 4;

    EsquemaBonificacionProducto pers = (EsquemaBonificacionProducto) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veEsqBonifProd "+
                     " ( "+
                      "OID_ESQ_BONIF_PROD,"+
                      "OID_ESQ_BONIF,"+
                      "OID_PRODUCTO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESQ_BONIF_PROD,pers.getOID());
    qInsert.setInt(OID_ESQ_BONIF,pers.getEsquema_bonificacion().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESQ_BONIF = 1;
    final int OID_PRODUCTO = 2;
    final int ACTIVO = 3;
    final int OID_ESQ_BONIF_PROD = 4;

    EsquemaBonificacionProducto pers = (EsquemaBonificacionProducto) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veEsqBonifProd set "+
              "oid_esq_bonif=?"+ 
              ",oid_producto=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_esq_bonif_prod=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BONIF_PROD,pers.getOID());
    qUpdate.setInt(OID_ESQ_BONIF,pers.getEsquema_bonificacion().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESQ_BONIF_PROD = 1; 
    EsquemaBonificacionProducto pers = (EsquemaBonificacionProducto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veEsqBonifProd "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_esq_bonif_prod=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BONIF_PROD, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESQ_BONIF_PROD = 1; 
    EsquemaBonificacionProducto pers = (EsquemaBonificacionProducto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veEsqBonifProd "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_esq_bonif_prod=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BONIF_PROD, pers.getOID()); 
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
      case SELECT_BY_ESQUEMA_BONIFICACION: {
        ps = this.selectByEsquemaBonificacion(aCondiciones); 
        break; 
      }
      case SELECT_BY_ESQ_BONIF_PRODUCTO: {
        ps = this.selectByEsquemaBonifProducto(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESQ_BONIF_PROD = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veEsqBonifProd "); 
    textSQL.append(" WHERE oid_esq_bonif_prod = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESQ_BONIF_PROD, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veEsqBonifProd "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEsquemaBonifProducto(Object aCondiciones) throws BaseException, SQLException {
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	EsquemaBonificacion esquemaBonificacion = (EsquemaBonificacion) condiciones.get(EsquemaBonificacion.NICKNAME);
	Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  veEsqBonifProd "); 
	textSQL.append(" WHERE oid_esq_bonif = ? and oid_producto = ? and activo = 1 ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	querySelect.setInt(1, esquemaBonificacion.getOID());
	querySelect.setInt(2, producto.getOID());
	return querySelect; 
  }
  
  
  
  
  private PreparedStatement selectByEsquemaBonificacion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veEsqBonifProd "); 
	    textSQL.append(" WHERE  oid_esq_bonif = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EsquemaBonificacion esquemaBonificacion = (EsquemaBonificacion) aCondiciones; 
	    querySelect.setInt(1, esquemaBonificacion.getOID()); 
	    return querySelect;
	    
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_esq_bonif_prod oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veEsqBonifProd");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEsquemasBonifProducto(EsquemaBonificacion esquemaBonificacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EsquemaBonificacionProducto.NICKNAME,
             DBEsquemaBonificacionProducto.SELECT_BY_ESQUEMA_BONIFICACION,
             esquemaBonificacion,
             new ListObserver(),
             aSesion);
  }
  
  public static EsquemaBonificacionProducto getEsquemaBonifPro(EsquemaBonificacion esquemaBonificacion,
		  													   Producto producto,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(EsquemaBonificacion.NICKNAME,esquemaBonificacion);
	  condiciones.put(Producto.NICKNAME,producto);
	  return (EsquemaBonificacionProducto) ObjetoLogico.getObjects(EsquemaBonificacionProducto.NICKNAME,
			  				DBEsquemaBonificacionProducto.SELECT_BY_ESQ_BONIF_PRODUCTO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
  
  
} 
