package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.EstadisticaFacturas;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBEstadisticaFacturas extends DBObjetoPersistente {

  public static final String EMISION = "emision";
  public static final String NRO_EXT = "nro_ext";
  public static final String OID_TC = "oid_tc";
  public static final String TC_EXT = "tc_ext";
  public static final String LETRA = "letra";
  public static final String LUG_EMI = "lug_emi";
  public static final String OID_SUJETO = "oid_sujeto";
  public static final String OID_COND_PAGO = "oid_cond_pago";
  public static final String OID_VENDEDOR = "oid_vendedor";
  public static final String OID_CCO_DET = "oid_cco_det";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_UM = "oid_um";
  public static final String CANT = "cant";
  public static final String PRECIO = "precio";
  public static final String COTIZACION = "cotizacion";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COD_PRODUCTO = "cod_producto";
  public static final String DESC_PRODUCTO = "desc_producto";
  public static final String COD_CLIENTE = "cod_cliente";
  public static final String NOMBRE_CLIENTE = "nombre_cliente";
  public static final String SIGNO = "signo";
  
  public static final int SELECT_BY_FECHA_DESDE_HASTA = 100;

  public DBEstadisticaFacturas() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
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
      case SELECT_BY_FECHA_DESDE_HASTA: {
        ps = this.selectByFechaDesdeHasta(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 
    return null; 
  }
  
  private PreparedStatement selectByFechaDesdeHasta(Object aCondiciones) throws BaseException, SQLException {

  	
  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
  	java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
  	List listaClasif = (List) condiciones.get("LISTA_CLASIFICADORES"); 
  	
    StringBuffer textSQL = new StringBuffer(); 
    
    textSQL.append(" select ");
    textSQL.append("   c.emision, ");
    textSQL.append("   c.nro_ext, ");
    textSQL.append("   c.oid_tc, ");
    textSQL.append("   c.tc_ext, ");
    textSQL.append("   c.letra, ");
    textSQL.append("   c.lug_emi, ");
    textSQL.append("   b.oid_sujeto, ");
    textSQL.append("   b.oid_cond_pago, ");
    textSQL.append("   b.oid_vendedor, ");
    textSQL.append("   a.oid_fact_det oid_cco_det, ");
    textSQL.append("   a.oid_cco_fact oid_cco, ");
    textSQL.append("   a.oid_producto, ");
    textSQL.append("   a.oid_um oid_um, ");
    textSQL.append("   a.cantidad cant, ");
    textSQL.append("   a.neto_gravado + a.neto_no_gravado precio, ");
    textSQL.append("   b.cotizacion, ");
    textSQL.append("   b.oid_moneda, ");
    textSQL.append("   d.codigo cod_producto, ");
    textSQL.append("   d.descripcion desc_producto, ");
    textSQL.append("   e.codigo cod_cliente, ");
    textSQL.append("   e.razon_social nombre_cliente, ");
    textSQL.append("   b.signo ");
    
    boolean hayClasifExtensionProd = false;
    
    Iterator iterClasif = listaClasif.iterator();
    while (iterClasif.hasNext()) {
    	
    	
    	ClasificadorEntidad clasif = (ClasificadorEntidad) iterClasif.next();
    	
    	if (clasif.getNickname().equals(Producto.NICKNAME)) {
    		textSQL.append(" ,d.oid_clasif_"+ clasif.getNroClasifFomateado()+ " oid_clasif_"+ clasif.getOIDInteger());
    	} else if (clasif.getNickname().equals(Sujeto.NICKNAME)) {
    		textSQL.append(" ,e.oid_clasif_"+ clasif.getNroClasifFomateado()+ " oid_clasif_"+ clasif.getOIDInteger());
    	} else if (clasif.getNickname().equals(ExtensionProdGen.NICKNAME)) {
    		textSQL.append(" ,f.oid_clasif_"+ clasif.getNroClasifFomateado()+ " oid_clasif_"+ clasif.getOIDInteger());
    		hayClasifExtensionProd = true;
    	}
    }
    
    textSQL.append(" from ");
    textSQL.append("   veFacturasDet a , ");
    textSQL.append("   veFacturasCab b , ");
    textSQL.append("   geComproCab c, ");
    textSQL.append("   stProducto d, ");
    textSQL.append("   veSujeto e ");
    
    if (hayClasifExtensionProd)
    	textSQL.append("   , stExtensionPG f ");
    
    textSQL.append(" where ");
    textSQL.append("   a.oid_cco_fact = b.oid_cco_fact and "); 
    textSQL.append("   c.oid_cco = b.oid_cco_fact and "); 
    textSQL.append("   a.anulado = 0 and "); 
    textSQL.append("   c.activo = 1 and ");
    textSQL.append("   e.oid_sujeto = b.oid_sujeto and ");
    textSQL.append("   a.oid_producto = d.oid_producto ");
    
    if (hayClasifExtensionProd) {
    	String campoFisProdGral = 
    		Producto.getClasifProductoGeneral(this.getSesion()).getCampoFisico();
    	textSQL.append("   and d."+campoFisProdGral+"=f.oid_val_clasif_ent "); 
    }
    
    textSQL.append("   and c.emision>=? and ");
    textSQL.append("   c.emision<=?  ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setDate(1, new Date(fechaDesde.getTime()));
    querySelect.setDate(2, new Date(fechaHasta.getTime()));
    
    setParamFactory(listaClasif);
    
    return querySelect; 
  	
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    return null; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    return null; 
  }
  
  public static List getEstadisticaFacturas(java.util.Date fechaDesde,
  																				 java.util.Date fechaHasta,
  																				 List listaClasificadores,
  																				 ISesion aSesion) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put("FECHA_DESDE",fechaDesde);
  	condiciones.put("FECHA_HASTA",fechaHasta);
  	condiciones.put("LISTA_CLASIFICADORES",listaClasificadores);
  	return (List) ObjetoLogico.getObjects(EstadisticaFacturas.NICKNAME,
         DBEstadisticaFacturas.SELECT_BY_FECHA_DESDE_HASTA,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  
} 
