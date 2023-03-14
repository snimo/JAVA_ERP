package com.srn.erp.produccion.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRecetaCab extends DBObjetoPersistente {

  public static final String OID_REC_CAB = "oid_rec_cab";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String BASE_CALCULO = "base_calculo";
  public static final String OID_UM = "oid_um";
  public static final String ALTERNATIVA = "alternativa";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PRODUCTO_ALTER = 100;
  public static final int SELECT_BY_PRODUCTO = 101;

  public DBRecetaCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REC_CAB = 1;
    final int OID_PRODUCTO = 2;
    final int BASE_CALCULO = 3;
    final int OID_UM = 4;
    final int ALTERNATIVA = 5;
    final int ACTIVO = 6;

    RecetaCab pers = (RecetaCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into prRecCab "+
                     " ( "+
                      "OID_REC_CAB,"+
                      "OID_PRODUCTO,"+
                      "BASE_CALCULO,"+
                      "OID_UM,"+
                      "ALTERNATIVA,"+
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
    qInsert.setInt(OID_REC_CAB,pers.getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProduco().getOID());
    qInsert.setDouble(BASE_CALCULO,pers.getBase_calculo().doubleValue());
    qInsert.setInt(OID_UM,pers.getOid_um().getOID());
    qInsert.setString(ALTERNATIVA,pers.getAlternativa());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PRODUCTO = 1;
    final int BASE_CALCULO = 2;
    final int OID_UM = 3;
    final int ALTERNATIVA = 4;
    final int ACTIVO = 5;
    final int OID_REC_CAB = 6;

    RecetaCab pers = (RecetaCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update prRecCab set "+
              " oid_producto=?"+ 
              ",base_calculo=?"+ 
              ",oid_um=?"+ 
              ",alternativa=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_rec_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REC_CAB,pers.getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProduco().getOID());
    qUpdate.setDouble(BASE_CALCULO,pers.getBase_calculo().doubleValue());
    qUpdate.setInt(OID_UM,pers.getOid_um().getOID());
    qUpdate.setString(ALTERNATIVA,pers.getAlternativa());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REC_CAB = 1; 
    RecetaCab pers = (RecetaCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prRecCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_rec_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REC_CAB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REC_CAB = 1; 
    RecetaCab pers = (RecetaCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prRecCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rec_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REC_CAB, pers.getOID()); 
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
      case SELECT_BY_PRODUCTO_ALTER: {
          ps = this.selectByProductoAlternativa(aCondiciones); 
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

    final int OID_REC_CAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prRecCab "); 
    textSQL.append(" WHERE oid_rec_cab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REC_CAB, oid); 
    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByProductoAlternativa(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	  	String alternativa = (String) condiciones.get("ALTERNATIVA");

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  prRecCab "); 
	    textSQL.append(" WHERE oid_producto = ? and alternativa = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, producto.getOID());
	    querySelect.setString(2, alternativa);
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByProducto(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	Producto producto = (Producto) condiciones.get(Producto.NICKNAME);

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  prRecCab "); 
	    textSQL.append(" WHERE oid_producto = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, producto.getOID());
	    return querySelect;
	    
  }
    
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prRecCab "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rec_cab oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from prRecCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static RecetaCab getRecetaByProductoAlternativa(Producto producto,
		  String alternativa,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Producto.NICKNAME, producto);
	  condiciones.put("ALTERNATIVA", alternativa);
	  
	  return (RecetaCab) ObjetoLogico.getObjects(RecetaCab.NICKNAME,
			  				DBRecetaCab.SELECT_BY_PRODUCTO_ALTER,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getRecetasByProducto(Producto producto,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Producto.NICKNAME, producto);
	  
	  return (List) ObjetoLogico.getObjects(RecetaCab.NICKNAME,
			  				DBRecetaCab.SELECT_BY_PRODUCTO,
			  				condiciones,
			  				new ListObserver(),
			  				aSesion);
  }
  
  
  
} 
