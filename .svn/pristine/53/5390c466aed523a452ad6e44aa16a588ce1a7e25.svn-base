package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.ventas.bm.ConsultaPrecios;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConsultaPrecios extends DBObjetoPersistente {

  public static final String OID_PRECIO_CAB = "oid_precio_cab";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String COD_PRODUCTO = "cod_producto";
  public static final String DESC_PRODUCTO = "desc_producto";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_UM = "oid_um";
  public static final String COD_UM = "cod_um";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COD_MONEDA = "cod_moneda";
  public static final String PRECIO = "precio";
  
  public static final int SELECT_BY_HELP_ART_Y_LISTA_PRECIO = 100;


  public DBConsultaPrecios() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PRECIO_CAB = 1;
    final int OID_PRODUCTO = 2;
    final int COD_PRODUCTO = 3;
    final int DESC_PRODUCTO = 4;
    final int CANTIDAD = 5;
    final int OID_UM = 6;
    final int COD_UM = 7;
    final int OID_MONEDA = 8;
    final int COD_MONEDA = 9;
    final int PRECIO = 10;

    ConsultaPrecios pers = (ConsultaPrecios) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into aaaaaa "+
                     " ( "+
                      "OID_PRECIO_CAB,"+
                      "OID_PRODUCTO,"+
                      "COD_PRODUCTO,"+
                      "DESC_PRODUCTO,"+
                      "CANTIDAD,"+
                      "OID_UM,"+
                      "COD_UM,"+
                      "OID_MONEDA,"+
                      "COD_MONEDA,"+
                      "PRECIO)"+ 
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PRECIO_CAB,pers.getOid_precio_cab().intValue());
    qInsert.setInt(OID_PRODUCTO,pers.getOid_producto().intValue());
    qInsert.setString(COD_PRODUCTO,pers.getCod_producto());
    qInsert.setString(DESC_PRODUCTO,pers.getDesc_producto());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setInt(OID_UM,pers.getOid_um().intValue());
    qInsert.setString(COD_UM,pers.getCod_um());
    qInsert.setInt(OID_MONEDA,pers.getOid_moneda().intValue());
    qInsert.setString(COD_MONEDA,pers.getCod_moneda());
    qInsert.setDouble(PRECIO,pers.getPrecio().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PRECIO_CAB = 1;
    final int OID_PRODUCTO = 2;
    final int COD_PRODUCTO = 3;
    final int DESC_PRODUCTO = 4;
    final int CANTIDAD = 5;
    final int OID_UM = 6;
    final int COD_UM = 7;
    final int OID_MONEDA = 8;
    final int COD_MONEDA = 9;
    final int PRECIO = 10;

    ConsultaPrecios pers = (ConsultaPrecios) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update aaaaaa set "+
              "oid_precio_cab=?"+ 
              ",oid_producto=?"+ 
              ",cod_producto=?"+ 
              ",desc_producto=?"+ 
              ",cantidad=?"+ 
              ",oid_um=?"+ 
              ",cod_um=?"+ 
              ",oid_moneda=?"+ 
              ",cod_moneda=?"+ 
              ",precio=?"+ 
                 " where " +
                 " =? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PRECIO_CAB,pers.getOid_precio_cab().intValue());
    qUpdate.setInt(OID_PRODUCTO,pers.getOid_producto().intValue());
    qUpdate.setString(COD_PRODUCTO,pers.getCod_producto());
    qUpdate.setString(DESC_PRODUCTO,pers.getDesc_producto());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setInt(OID_UM,pers.getOid_um().intValue());
    qUpdate.setString(COD_UM,pers.getCod_um());
    qUpdate.setInt(OID_MONEDA,pers.getOid_moneda().intValue());
    qUpdate.setString(COD_MONEDA,pers.getCod_moneda());
    qUpdate.setDouble(PRECIO,pers.getPrecio().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    ConsultaPrecios pers = (ConsultaPrecios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update aaaaaa "+
                     " set activo=0 " + 
                     " where " + 
                     " =? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    ConsultaPrecios pers = (ConsultaPrecios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update aaaaaa "+
                     " set activo=1 " + 
                     " where " + 
                     " =? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
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
      case SELECT_BY_HELP_ART_Y_LISTA_PRECIO: {
        ps = this.selectByHelpArtListaPrecios(aCondiciones);
        break;
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  aaaaaa "); 
    textSQL.append(" WHERE  = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  aaaaaa "); 
    textSQL.append(" WHERE cod_producto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT  oid,cod_producto codigo, desc_producto descripcion ,activo ");
    textSQL.append(" from aaaaaa");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private String getNroClasificador(Integer nroClasificador) {
  	String nroClasif = nroClasificador.toString();
  	if (nroClasif.length() == 2)
  		return nroClasif;
  	else
  		return "0"+ nroClasif;
  }
  
  private PreparedStatement selectByHelpArtListaPrecios(Object aCondiciones) throws BaseException, SQLException {

  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	ListaPrecios listaPrecios = (ListaPrecios) condiciones.get(ListaPrecios.NICKNAME);
  	
  	//ClasificadorEntidad clasifEnt1 = ListaPrecios.getClasifNro1EstrucLP(this.getSesion());
  	ClasificadorEntidad clasifEnt2 = ListaPrecios.getClasifNro2EstrucLP(this.getSesion());
  	
    StringBuffer textSQL = new StringBuffer();
    textSQL.append(" select "); 
    textSQL.append("     a.oid_precio_cab, ");
    textSQL.append("     a.cantidad, ");
    textSQL.append("     a.oid_um, ");
    textSQL.append("     c.codigo cod_um, ");
    textSQL.append("     a.oid_moneda, ");
    textSQL.append("     d.simbolo cod_moneda, ");
    textSQL.append("     a.precio, ");
    textSQL.append("     b.oid_producto, ");
    textSQL.append("     b.codigo cod_producto, ");
    textSQL.append("     b.descripcion desc_producto ");  
    textSQL.append("   from "); 
    textSQL.append("     vePreciosEstLP a, ");
    textSQL.append("     stProducto b, ");
    textSQL.append("     stUniMed c, ");
    textSQL.append("     geMonedas d "); 
    textSQL.append("   where "); 
    //textSQL.append("      a.oid_clasif_art_1 = b.oid_clasif_"+getNroClasificador(clasifEnt1.getNroClasif())+" and ");
    textSQL.append("      a.oid_clasif_art_2 = b.oid_clasif_"+getNroClasificador(clasifEnt2.getNroClasif())+" and ");
    textSQL.append("      c.oid_um = a.oid_um and ");
    textSQL.append("      d.oid_moneda = a.oid_moneda and "); 
    textSQL.append("      a.oid_precio_cab  = ? ");
    textSQL.append("      and b.oid_producto not in (select oid_producto from vePreciosDet where oid_precio_cab=? ) ");
    
    if (condiciones.containsKey("codigo")) {
  		StringTokenizer st =  new StringTokenizer(condiciones.getString("codigo"), " ");
      while(st.hasMoreTokens()){
      	String next = st.nextToken().toUpperCase();
      	textSQL.append(" and b.codigo like '%"+next+"%' ");
      }
    }
    
    if (condiciones.containsKey("nd_int"))
    	textSQL.append(" and b.hab_nd_int = 1 ");
    
    if (condiciones.containsKey("nc_int"))
    	textSQL.append(" and b.hab_nc_int = 1 ");     
    
    
    if (condiciones.containsKey("descripcion")) {
  		StringTokenizer st =  new StringTokenizer(condiciones.getString("descripcion"), " ");
      while(st.hasMoreTokens()){
      	String next = st.nextToken().toUpperCase();
      	textSQL.append(" and b.desc_search like '%"+next+"%' ");
      }
    }
    
    textSQL.append("      union all ");
    
    textSQL.append("   select  ");
    textSQL.append("       a.oid_precio_cab, ");
    textSQL.append("       a.cantidad, ");
    textSQL.append("       a.oid_um, ");
    textSQL.append("       b.codigo cod_um, ");
    textSQL.append("       a.oid_moneda, ");
    textSQL.append("       c.simbolo cod_moneda, ");
    textSQL.append("       a.precio, ");
    textSQL.append("       d.oid_producto, ");
    textSQL.append("       d.codigo cod_producto, ");
    textSQL.append("       d.descripcion desc_producto ");  
    textSQL.append("   from "); 
    textSQL.append("       vePreciosDet a, ");
    textSQL.append("       stProducto d, ");
    textSQL.append("       stUniMed b, ");
    textSQL.append("       geMonedas c ");
    textSQL.append("   where ");
    textSQL.append("       d.oid_producto = a.oid_producto ");
    textSQL.append("       and a.oid_um = b.oid_um ");
    textSQL.append("       and a.oid_moneda = c.oid_moneda ");
    textSQL.append("       and a.oid_precio_cab = ? ");
    
    if (condiciones.containsKey("nd_int"))
    	textSQL.append(" and d.hab_nd_int = 1 ");
    
    if (condiciones.containsKey("nc_int"))
    	textSQL.append(" and d.hab_nc_int = 1 ");     
    
    
    if (condiciones.containsKey("codigo"))
      textSQL.append(" and d.codigo like '%"+condiciones.getString("codigo")+"%' ");
    
    if (condiciones.containsKey("descripcion")) {
  		StringTokenizer st =  new StringTokenizer(condiciones.getString("descripcion"), " ");
      while(st.hasMoreTokens()){
      	String next = st.nextToken().toUpperCase();
      	textSQL.append(" and d.desc_search like '%"+next+"%' ");
      }
    }
    
  	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
  	querySelect.setInt(1, listaPrecios.getOID());
  	querySelect.setInt(2, listaPrecios.getOID());
  	querySelect.setInt(3, listaPrecios.getOID());
  	return querySelect;
  }
  
  public static List getPrecios(HashTableDatos aCondiciones,
  															ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ConsultaPrecios.NICKNAME,
         DBConsultaPrecios.SELECT_BY_HELP_ART_Y_LISTA_PRECIO,
         aCondiciones,
         new ListObserver(),
         aSesion);
  }
  
  
  
} 
