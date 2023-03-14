package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.ListaBlanca;
import com.srn.erp.cip.bm.Puerta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBListaBlanca extends DBObjetoPersistente {

  public static final String OID_LB = "oid_lb";
  public static final String OID_PUERTA = "oid_puerta";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String NRO_A_VALIDAR = "nro_a_validar";
  public static final String NRO_ORDEN = "nro_orden";
  public static final String TIPO = "tipo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PUERTA_NRO_DESDE_HASTA = 100;
  public static final int SELECT_ALL = 101;

  public DBListaBlanca() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LB = 1;
    final int OID_PUERTA = 2;
    final int OID_LEGAJO = 3;
    final int NRO_A_VALIDAR = 4;
    final int NRO_ORDEN = 5;
    final int TIPO = 6;
    final int ACTIVO = 7;

    ListaBlanca pers = (ListaBlanca) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipListaBlanca "+
                     " ( "+
                      "OID_LB,"+
                      "OID_PUERTA,"+
                      "OID_LEGAJO,"+
                      "NRO_A_VALIDAR,"+
                      "NRO_ORDEN,"+
                      "TIPO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LB,pers.getOID());
    qInsert.setInt(OID_PUERTA,pers.getPuerta().getOID());
    qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qInsert.setInt(NRO_A_VALIDAR,pers.getNro_a_validar().intValue());
    qInsert.setInt(NRO_ORDEN,pers.getNro_orden().intValue());
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PUERTA = 1;
    final int OID_LEGAJO = 2;
    final int NRO_A_VALIDAR = 3;
    final int NRO_ORDEN = 4;
    final int TIPO = 5;
    final int ACTIVO = 6;
    final int OID_LB = 7;

    ListaBlanca pers = (ListaBlanca) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipListaBlanca set "+
              "oid_puerta=?"+ 
              ",oid_legajo=?"+ 
              ",nro_a_validar=?"+ 
              ",nro_orden=?"+ 
              ",tipo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_lb=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LB,pers.getOID());
    qUpdate.setInt(OID_PUERTA,pers.getPuerta().getOID());
    qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qUpdate.setInt(NRO_A_VALIDAR,pers.getNro_a_validar().intValue());
    qUpdate.setInt(NRO_ORDEN,pers.getNro_orden().intValue());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LB = 1; 
    ListaBlanca pers = (ListaBlanca) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipListaBlanca "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_lb=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LB = 1; 
    ListaBlanca pers = (ListaBlanca) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipListaBlanca "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_lb=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LB, pers.getOID()); 
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
      case SELECT_BY_PUERTA_NRO_DESDE_HASTA: {
          ps = this.selectByPuertaNroDesdeyHasta(aCondiciones); 
          break; 
      }
      case SELECT_ALL: {
          ps = this.selectAll(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipListaBlanca "); 
    textSQL.append(" WHERE oid_lb = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LB, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPuertaNroDesdeyHasta(Object aCondiciones) throws BaseException, SQLException {
	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
	  	Integer nroOrdenDesde = (Integer) condiciones.get("NRO_ORDEN_DESDE");
	  	Integer nroOrdenHasta = (Integer) condiciones.get("NRO_ORDEN_HASTA");
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipListaBlanca "); 
	    textSQL.append(" WHERE oid_puerta  = ? and nro_orden>=? and nro_orden<=? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, puerta.getOID());
	    querySelect.setInt(2, nroOrdenDesde.intValue());
	    querySelect.setInt(3, nroOrdenHasta.intValue());
	    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipListaBlanca "); 
	    textSQL.append(" WHERE activo=1 ");
	    //textSQL.append(" ORDER BY oid_puerta ASC, nro_orden ASC");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
}
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipListaBlanca "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_lb oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipListaBlanca");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getListaBlanca(Puerta puerta,int nroDesde,int nroHasta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Puerta.NICKNAME, puerta);
	  condiciones.put("NRO_ORDEN_DESDE", nroDesde);
	  condiciones.put("NRO_ORDEN_HASTA", nroHasta);
	  return (List) ObjetoLogico.getObjects(ListaBlanca.NICKNAME,
             DBListaBlanca.SELECT_BY_PUERTA_NRO_DESDE_HASTA,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getAllListaBlanca(ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  return (List) ObjetoLogico.getObjects(ListaBlanca.NICKNAME,
             DBListaBlanca.SELECT_ALL,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
} 
