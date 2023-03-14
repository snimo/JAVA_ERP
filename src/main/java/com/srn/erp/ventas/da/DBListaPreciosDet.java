package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBCostoProducto;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.HashTableObserver;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBListaPreciosDet extends DBObjetoPersistente {

  public static final String OID_PRECIO_DET = "oid_precio_det";
  public static final String OID_PRECIO_CAB = "oid_precio_cab";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_UM = "oid_um";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String PRECIO = "precio";
  public static final String ACTIVO = "activo";
  public static final String FEC_ULT_ACT = "fec_ult_act";

  public final static int SELECT_BY_LISTA_Y_PRODUCTO = 100;
  public final static int SELECT_BY_LISTA = 101;
  public final static int SELECT_BY_CONSULTA_MASIVA = 102;

  public DBListaPreciosDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PRECIO_DET = 1;
    final int OID_PRECIO_CAB = 2;
    final int OID_PRODUCTO = 3;
    final int OID_UM = 4;
    final int CANTIDAD = 5;
    final int OID_MONEDA = 6;
    final int PRECIO = 7;
    final int ACTIVO = 8;
    final int FEC_ULT_ACT = 9;

    ListaPreciosDet pers = (ListaPreciosDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vePreciosDet "+
                     " ( "+
                      "OID_PRECIO_DET,"+
                      "OID_PRECIO_CAB,"+
                      "OID_PRODUCTO,"+
                      "OID_UM,"+
                      "CANTIDAD,"+
                      "OID_MONEDA,"+
                      "PRECIO,"+
                      "ACTIVO,FEC_ULT_ACT)"+
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
    qInsert.setInt(OID_PRECIO_DET,pers.getOID());
    qInsert.setInt(OID_PRECIO_CAB,pers.getLista_precio().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(PRECIO,pers.getPrecio().doubleValue(4));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getFecUltAct()!=null)
    	qInsert.setDate(FEC_ULT_ACT,new java.sql.Date(pers.getFecUltAct().getTime()));
    else
    	qInsert.setNull(FEC_ULT_ACT,java.sql.Types.DATE);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PRECIO_CAB = 1;
    final int OID_PRODUCTO = 2;
    final int OID_UM = 3;
    final int CANTIDAD = 4;
    final int OID_MONEDA = 5;
    final int PRECIO = 6;
    final int ACTIVO = 7;
    final int FEC_ULT_ACT = 8;
    final int OID_PRECIO_DET = 9;

    ListaPreciosDet pers = (ListaPreciosDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vePreciosDet set "+
              "oid_precio_cab=?"+
              ",oid_producto=?"+
              ",oid_um=?"+
              ",cantidad=?"+
              ",oid_moneda=?"+
              ",precio=?"+
              ",activo=?"+
              ",fec_ult_act=?"+
                 " where " +
                 " oid_precio_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_DET,pers.getOID());
    qUpdate.setInt(OID_PRECIO_CAB,pers.getLista_precio().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(PRECIO,pers.getPrecio().doubleValue(4));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getFecUltAct()!=null)
    	qUpdate.setDate(FEC_ULT_ACT,new java.sql.Date(pers.getFecUltAct().getTime()));
    else
    	qUpdate.setNull(FEC_ULT_ACT,java.sql.Types.DATE);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PRECIO_DET = 1;
    ListaPreciosDet pers = (ListaPreciosDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vePreciosDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_precio_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_DET, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PRECIO_DET = 1;
    ListaPreciosDet pers = (ListaPreciosDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vePreciosDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_precio_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_DET, pers.getOID());
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
      case SELECT_BY_LISTA_Y_PRODUCTO: {
        ps = this.selectByListaYProducto(aCondiciones);
        break;
      }
      case SELECT_BY_LISTA: {
        ps = this.selectByLista(aCondiciones);
        break;
      }
      case SELECT_BY_CONSULTA_MASIVA: {
        ps = this.selectByConsultaMasiva(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PRECIO_DET = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePreciosDet ");
    textSQL.append(" WHERE oid_precio_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PRECIO_DET, oid);
    return querySelect;
  }
    
  private PreparedStatement selectByLista(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePreciosDet ");
    textSQL.append(" WHERE oid_precio_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ListaPrecios listaPrecios = (ListaPrecios) aCondiciones;
    querySelect.setInt(1, listaPrecios.getOID());
    return querySelect;
  }
  

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePreciosDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
  private PreparedStatement selectByConsultaMasiva(Object aCondiciones) throws BaseException, SQLException { 

	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  StringBuffer textSQL = new StringBuffer();
	  
	  ListaPrecios listaPrecios = (ListaPrecios) condiciones.get(ListaPrecios.NICKNAME);
	  
	  textSQL.append("select * from vePreciosDet a where  ");
	  textSQL.append(" a.oid_precio_cab="+listaPrecios.getOIDInteger());
	  
	  textSQL.append(" and a.oid_producto in (select oid_producto from stProducto c where 1=1 ");

	  
		// Descripcion del producto
		if (condiciones.containsKey("oid_producto") && 
			 (condiciones.getInteger("oid_producto").intValue()>0)) {			
			textSQL.append(" and c.oid_producto =" + condiciones.getInteger("oid_producto").toString());
		}			
	  
	  
		// Descripcion del producto
		if (condiciones.containsKey("codigo_producto") && 
			 (condiciones.getString("codigo_producto").length()>0)) {			
			StringTokenizer st = new StringTokenizer(condiciones.getString("codigo_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and c.codigo like '%" + next + "%' ");
			}
		}			

		// Descripcion del producto
		if (condiciones.containsKey("desc_producto") && 
			 (condiciones.getString("desc_producto").length()>0)) {			
			StringTokenizer st = new StringTokenizer(condiciones.getString("desc_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and c.desc_search like '%" + next + "%' ");
			}
		}			
		
		// Descripcion abreviada del producto
		if (condiciones.containsKey("desc_abreviada") && 
				 (condiciones.getString("desc_abreviada").length()>0)) {			
				StringTokenizer st = new StringTokenizer(condiciones.getString("desc_abreviada"), " ");
				while (st.hasMoreTokens()) {
					String next = st.nextToken().toUpperCase();
					textSQL.append(" and c.desc_abrev like '%" + next + "%' ");
				}
		}
		
		if (condiciones.containsKey(TipoProducto.NICKNAME)) {
			TipoProducto tipoProd = (TipoProducto) condiciones.get(TipoProducto.NICKNAME);
			textSQL.append(" and c.oid_tipo_prod="+tipoProd.getOIDInteger());
		}
		
		if (condiciones.containsKey("COMPRABLE")) 
			textSQL.append(" and c.comprable=1 ");
		
		if (condiciones.containsKey("VENDIBLE")) 
			textSQL.append(" and c.vendible=1 ");
		
		if (condiciones.containsKey("STOCKEBLE")) 
			textSQL.append(" and c.stockeable=1 ");
		
		if (condiciones.containsKey("PROD_PROPIA")) 
			textSQL.append(" and c.prod_propia=1 ");
		
		if (condiciones.containsKey("IMPORTADO")) 
			textSQL.append(" and c.importado=1 ");
		
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
		  

	return querySelect;
	  
  }
  
  
  

  private PreparedStatement selectByListaYProducto(Object aCondiciones) throws BaseException, SQLException {

    Hashtable condiciones = (Hashtable) aCondiciones;
    ListaPrecios listaPrecios = (ListaPrecios) condiciones.get(ListaPrecios.NICKNAME);
    Producto     producto     = (Producto) condiciones.get(Producto.NICKNAME);
    UnidadMedida unidadMedida = null;
    if (condiciones.containsKey(UnidadMedida.NICKNAME))
        unidadMedida = (UnidadMedida) condiciones.get(UnidadMedida.NICKNAME);
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vePreciosDet ");
    textSQL.append(" WHERE  oid_precio_cab = ? and oid_producto = ? ");
    
    if (unidadMedida!=null)
    	textSQL.append(" and oid_um="+unidadMedida.getOIDInteger().toString());
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,listaPrecios.getOID());
    querySelect.setInt(2,producto.getOID());
    return querySelect;
  }

  public static ListaPreciosDet getListaPrecioDetByListaProducto(ListaPrecios listaPrecio,
                                                                 Producto producto,
                                                                 UnidadMedida unidadMedida,
                                                                 ISesion aSesion)
                                                      throws BaseException {
    Hashtable condiciones = new Hashtable();
    condiciones.put(ListaPrecios.NICKNAME,listaPrecio);
    condiciones.put(Producto.NICKNAME,producto);
    if (unidadMedida!=null)
      condiciones.put(UnidadMedida.NICKNAME,unidadMedida);
    return (ListaPreciosDet) ObjetoLogico.getObjects(ListaPreciosDet.NICKNAME,
                                                     DBListaPreciosDet.SELECT_BY_LISTA_Y_PRODUCTO,
                                                     condiciones,
                                                     new ObjetoObservado(),
                                                     aSesion);
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_precio_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vePreciosDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getDetallesListaPrecios(ListaPrecios listaPrecios,
      																			 ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ListaPreciosDet.NICKNAME,
         																  DBListaPreciosDet.SELECT_BY_LISTA,
         																  listaPrecios,
         																  new ListObserver(),
         																  aSesion);
  }
  
  public static List getConsultaMasivaProductos(
		    ListaPrecios lp,
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
	  	
	  	condiciones.put(ListaPrecios.NICKNAME,lp);

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
	  	

	  	return (List) ObjetoLogico.getObjects(ListaPreciosDet.NICKNAME,
	         DBListaPreciosDet.SELECT_BY_CONSULTA_MASIVA,
	         condiciones,
	         new ListObserver(),
	         aSesion);
	  	
	  }
		

  
  
  
  

}
