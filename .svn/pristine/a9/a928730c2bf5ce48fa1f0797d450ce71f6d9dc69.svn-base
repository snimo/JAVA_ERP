package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.CostoProducto;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.HashTableObserver;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCostoProductoGral extends DBObjetoPersistente {

  public static final String OID_COSTO_PRODGRAL = "oid_costo_prodgral";
  public static final String OID_VAL_CLASIF_ENT = "oid_val_clasif_ent";
  public static final String OID_CLASIF_ENT = "oid_clasif_ent";
  public static final String FEC_ULT_COSTO = "fec_ult_costo";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_UM = "oid_um";
  public static final String COSTO = "costo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CLASIF_Y_VALOR_CLASIF = 100;
  public static final int SELECT_BY_COSTOS_VIG_A_FECHA = 101;
  public static final int SELECT_BY_FECHA_PRODUCTO = 102;
  public static final int SELECT_BY_COSTO_PRODUCTO_VIG = 103;

  public DBCostoProductoGral() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COSTO_PRODGRAL = 1;
    final int OID_VAL_CLASIF_ENT = 2;
    final int OID_CLASIF_ENT = 3;
    final int FEC_ULT_COSTO = 4;
    final int OID_MONEDA = 5;
    final int CANTIDAD = 6;
    final int OID_UM = 7;
    final int COSTO = 8;
    final int ACTIVO = 9;

    CostoProductoGral pers = (CostoProductoGral) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into stCostosProdGral "+
                     " ( "+
                      "OID_COSTO_PRODGRAL,"+
                      "OID_VAL_CLASIF_ENT,"+
                      "OID_CLASIF_ENT,"+
                      "FEC_ULT_COSTO,"+
                      "OID_MONEDA,"+
                      "CANTIDAD,"+
                      "OID_UM,"+
                      "COSTO,"+
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COSTO_PRODGRAL,pers.getOID());
    qInsert.setInt(OID_VAL_CLASIF_ENT,pers.getVal_clasif_ent().getOID());
    qInsert.setInt(OID_CLASIF_ENT,pers.getClasificador().getOID());
    qInsert.setDate(FEC_ULT_COSTO,new java.sql.Date(pers.getFec_ult_costo().getTime()));
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setInt(OID_UM,pers.getUm().getOID());
    qInsert.setDouble(COSTO,pers.getCosto().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_CLASIF_ENT = 1;
    final int OID_CLASIF_ENT = 2;
    final int FEC_ULT_COSTO = 3;
    final int OID_MONEDA = 4;
    final int CANTIDAD = 5;
    final int OID_UM = 6;
    final int COSTO = 7;
    final int ACTIVO = 8;
    final int OID_COSTO_PRODGRAL = 9;

    CostoProductoGral pers = (CostoProductoGral) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update stCostosProdGral set "+
              "oid_val_clasif_ent=?"+ 
              ",oid_clasif_ent=?"+ 
              ",fec_ult_costo=?"+ 
              ",oid_moneda=?"+ 
              ",cantidad=?"+ 
              ",oid_um=?"+ 
              ",costo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_costo_prodgral=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COSTO_PRODGRAL,pers.getOID());
    qUpdate.setInt(OID_VAL_CLASIF_ENT,pers.getVal_clasif_ent().getOID());
    qUpdate.setInt(OID_CLASIF_ENT,pers.getClasificador().getOID());
    qUpdate.setDate(FEC_ULT_COSTO,new java.sql.Date(pers.getFec_ult_costo().getTime()));
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setInt(OID_UM,pers.getUm().getOID());
    qUpdate.setDouble(COSTO,pers.getCosto().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COSTO_PRODGRAL = 1; 
    CostoProductoGral pers = (CostoProductoGral) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from stCostosProdGral "+
                     " where " + 
                     " oid_costo_prodgral=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COSTO_PRODGRAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COSTO_PRODGRAL = 1; 
    CostoProductoGral pers = (CostoProductoGral) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update stCostosProdGral "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_costo_prodgral=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COSTO_PRODGRAL, pers.getOID()); 
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
      case SELECT_BY_CLASIF_Y_VALOR_CLASIF: {
          ps = this.selectByClasifValorClasif(aCondiciones); 
          break; 
      }
      case SELECT_BY_COSTOS_VIG_A_FECHA: {
          ps = this.selectByCostosVigAFecha(aCondiciones); 
          break; 
      }      
      case SELECT_BY_FECHA_PRODUCTO: {
          ps = this.selectByFechaProducto(aCondiciones); 
          break; 
      }   
      case SELECT_BY_COSTO_PRODUCTO_VIG: {
          ps = this.selectByCostoProductoVigente(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COSTO_PRODGRAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  stCostosProdGral "); 
    textSQL.append(" WHERE oid_costo_prodgral = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COSTO_PRODGRAL, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByClasifValorClasif(Object aCondiciones) throws BaseException, SQLException { 

	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	ClasificadorEntidad clasificador = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
	ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	  
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  stCostosProdGral "); 
	textSQL.append(" WHERE  oid_val_clasif_ent = ? and oid_clasif_ent = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	querySelect.setInt(1, valClasifEnt.getOID());
	querySelect.setInt(2, clasificador.getOID());
	
	
	return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  stCostosProdGral "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_costo_prodgral oid, codigo,  descripcion ,activo ");
    textSQL.append(" from stCostosProdGral");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getCostosProductosGral(
		  ClasificadorEntidad clasificador,
		  ValorClasificadorEntidad valClasifEnt,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ClasificadorEntidad.NICKNAME, clasificador);
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
	  return (List) ObjetoLogico.getObjects(CostoProductoGral.NICKNAME,
             DBCostoProductoGral.SELECT_BY_CLASIF_Y_VALOR_CLASIF,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static HashTableDatos getConsultaMasivaProductos(
		    java.util.Date fecha,
		    Integer oidProducto,
	  		String descProducto,
	  		String descAbreviada,
	  		String codigoProducto,
	  		TipoProducto tipoProducto,  		
	  		boolean isComprable,
	  		boolean isVendible,
	  		boolean isStockeable,
	  		boolean isProdPropia,
	  		boolean isImportado,
	  		HashTableDatos listaValoresClasif,
	      ISesion aSesion) throws BaseException {
	  	
	  	HashTableDatos condiciones = new HashTableDatos();
	  	
	  	condiciones.put("FECHA",fecha);

	  	if ((oidProducto!=null) && (oidProducto.intValue()>0))
	  		condiciones.put("oid_producto",oidProducto);
	  	
	  	if ((descProducto!=null) && (descProducto.length()>0))
	  		condiciones.put("desc_producto",descProducto);

	  	if ((descAbreviada!=null) && (descAbreviada.length()>0))
	  		condiciones.put("desc_abreviada",descAbreviada);
	  	
	  	if ((codigoProducto!=null) && (codigoProducto.length()>0))
	  		condiciones.put("codigo_producto",codigoProducto);
	  	
	  	
	  	if (tipoProducto!=null)
	    		condiciones.put(TipoProducto.NICKNAME,tipoProducto);
	  	
	  	if (isComprable)
	  		condiciones.put("COMPRABLE","");
	  	if (isVendible)
	  		condiciones.put("VENDIBLE","");
	  	if (isStockeable)
	  		condiciones.put("STOCKEBLE","");
	  	if (isProdPropia)
	  		condiciones.put("PROD_PROPIA","");
	  	if (isImportado)
	  		condiciones.put("IMPORTADO","");
	  	
	  	if ((listaValoresClasif!=null) && (listaValoresClasif.keySet().size()>0)) 
	  		condiciones.put("LISTA_VAL_CLASIF",listaValoresClasif);
	  	

	  	return (HashTableDatos) ObjetoLogico.getObjects(CostoProductoGral.NICKNAME,
	         DBCostoProductoGral.SELECT_BY_COSTOS_VIG_A_FECHA,
	         condiciones,
	         new HashTableObserver(),
	         aSesion);
	  	
	  }
  
  private PreparedStatement selectByCostoProductoVigente(Object aCondiciones) throws BaseException, SQLException { 

	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	  ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	  StringBuffer textSQL = new StringBuffer();
	  
	  textSQL.append(" select * from stCostosProdGral a ");
	  textSQL.append(" where a.oid_clasif_ent = ? and a.oid_val_clasif_ent = ? and a.activo = 1 and fec_ult_costo = (select max(fec_ult_costo) from stCostosProdGral b where b.oid_val_clasif_ent=a.oid_val_clasif_ent and b.fec_ult_costo<=? ) ");

	  
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	querySelect.setInt(1, valClasifEnt.getClasificador_entidad().getOID());
	querySelect.setInt(2, valClasifEnt.getOID());
	querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
	
	return querySelect;
	  
  }
  
  
    
  
  private PreparedStatement selectByCostosVigAFecha(Object aCondiciones) throws BaseException, SQLException { 

	  
	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	  StringBuffer textSQL = new StringBuffer();
	  
	  textSQL.append("select * from stCostosProdGral a where a.activo = 1 and fec_ult_costo = (select max(fec_ult_costo) from stCostosProdGral b where b.oid_val_clasif_ent=a.oid_val_clasif_ent and b.fec_ult_costo<=? ) ");
	  textSQL.append(" and a.oid_val_clasif_ent in (select d.oid_val_clasif_ent from stExtensionPG c , geValClasifEnt d where c.oid_val_clasif_ent=d.oid_val_clasif_ent ");

	  
		// Descripcion del producto
		if (condiciones.containsKey("oid_producto") && 
			 (condiciones.getInteger("oid_producto").intValue()>0)) {			
			textSQL.append(" and c.oid_val_clasif_ent = "+condiciones.getInteger("oid_producto").toString());
		}			
	  
	  
		// Descripcion del producto
		if (condiciones.containsKey("codigo_producto") && 
			 (condiciones.getString("codigo_producto").length()>0)) {			
			StringTokenizer st = new StringTokenizer(condiciones.getString("codigo_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and d.codigo like '%" + next + "%' ");
			}
		}			

		// Descripcion del producto
		if (condiciones.containsKey("desc_producto") && 
			 (condiciones.getString("desc_producto").length()>0)) {			
			StringTokenizer st = new StringTokenizer(condiciones.getString("desc_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and d.descripcion like '%" + next + "%' ");
			}
		}			
		
		// Descripcion abreviada del producto
		if (condiciones.containsKey("desc_abreviada") && 
				 (condiciones.getString("desc_abreviada").length()>0)) {			
				StringTokenizer st = new StringTokenizer(condiciones.getString("desc_abreviada"), " ");
				while (st.hasMoreTokens()) {
					String next = st.nextToken().toUpperCase();
					textSQL.append(" and d.descripcion like '%" + next + "%' ");
				}
		}
		
		if (condiciones.containsKey(TipoProducto.NICKNAME)) {
			TipoProducto tipoProd = (TipoProducto) condiciones.get(TipoProducto.NICKNAME);
			textSQL.append(" and c.oid_tipo_prod="+tipoProd.getOIDInteger());
		}
		
		/*if (condiciones.containsKey("COMPRABLE")) 
			textSQL.append(" and c.comprable=1 ");
		
		if (condiciones.containsKey("VENDIBLE")) 
			textSQL.append(" and c.vendible=1 ");
		
		if (condiciones.containsKey("STOCKEBLE")) 
			textSQL.append(" and c.stockeable=1 ");
		
		if (condiciones.containsKey("PROD_PROPIA")) 
			textSQL.append(" and c.prod_propia=1 ");
		
		if (condiciones.containsKey("IMPORTADO")) 
			textSQL.append(" and c.importado=1 ");*/
		
		if (condiciones.containsKey("LISTA_VAL_CLASIF")) {
			HashTableDatos listaValClasif = 
				(HashTableDatos) condiciones.get("LISTA_VAL_CLASIF");
			Iterator iterValoresClasif = listaValClasif.keySet().iterator();
			while (iterValoresClasif.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterValoresClasif.next();
				IValorClasificadorEntidad valor = (IValorClasificadorEntidad)
				    listaValClasif.get(clasifEnt);
				textSQL.append(" and c."+clasifEnt.getCampoFisico()+"="+valor.getOID());
			}
		}
		
		textSQL.append(" )");
		
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
		  

	return querySelect;
	  
  }
  
  public static CostoProductoGral getCostoProductoByFecha(
		  java.util.Date fecha,
		  ValorClasifEntProdGen producto,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ValorClasifEntProdGen.NICKNAME, producto );
	  condiciones.put("FECHA", fecha);
	  
	  return (CostoProductoGral) ObjetoLogico.getObjects(CostoProductoGral.NICKNAME,
			  				DBCostoProductoGral.SELECT_BY_FECHA_PRODUCTO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static CostoProductoGral getCostoProductoVigenteAFecha(
		  java.util.Date fecha,
		  ValorClasificadorEntidad producto,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, producto );
	  condiciones.put("FECHA", fecha);
	  
	  return (CostoProductoGral) ObjetoLogico.getObjects(CostoProductoGral.NICKNAME,
			  				DBCostoProductoGral.SELECT_BY_COSTO_PRODUCTO_VIG,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
private PreparedStatement selectByFechaProducto(Object aCondiciones) throws BaseException, SQLException { 

	  
	  
	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  ValorClasifEntProdGen producto = (ValorClasifEntProdGen) condiciones.get(ValorClasifEntProdGen.NICKNAME);
	  java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	  StringBuffer textSQL = new StringBuffer(); 
	  textSQL.append("SELECT * FROM  stCostosProdGral "); 
	  textSQL.append(" WHERE oid_val_clasif_ent = ? and fec_ult_costo=? "); 
	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	  querySelect.setInt(1, producto.getOID());
	  querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	  
	  return querySelect;
	  
  }
  
  
  
  
  
  
  
  
} 
