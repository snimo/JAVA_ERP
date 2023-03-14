package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.TipoHabilitadoUPC;
import com.srn.erp.presupuesto.bm.TipoUPC;
import com.srn.erp.presupuesto.bm.UPC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTipoHabilitadoUPC extends DBObjetoPersistente {

  public static final String OID_TIPO_HAB_UPC = "oid_tipo_hab_upc";
  public static final String OID_UPC = "oid_upc";
  public static final String OID_TIPO_UPC = "oid_tipo_upc";
  public static final String HABILITADO = "habilitado";
  
  public static final int SELECT_BY_UPC = 100;
  public static final int SELECT_BY_UPC_TIPO_UPC = 101; 

  public DBTipoHabilitadoUPC() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_HAB_UPC = 1;
    final int OID_UPC = 2;
    final int OID_TIPO_UPC = 3;
    final int HABILITADO = 4;

    TipoHabilitadoUPC pers = (TipoHabilitadoUPC) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plTiposHabUPC "+
                     " ( "+
                      "OID_TIPO_HAB_UPC,"+
                      "OID_UPC,"+
                      "OID_TIPO_UPC,"+
                      "HABILITADO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TIPO_HAB_UPC,pers.getOID());
    qInsert.setInt(OID_UPC,pers.getUpc().getOID());
    qInsert.setInt(OID_TIPO_UPC,pers.getTipoupc().getOID());
    qInsert.setBoolean(HABILITADO,pers.isHabilitado().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_UPC = 1;
    final int OID_TIPO_UPC = 2;
    final int HABILITADO = 3;
    final int OID_TIPO_HAB_UPC = 4;

    TipoHabilitadoUPC pers = (TipoHabilitadoUPC) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plTiposHabUPC set "+
              "oid_upc=?"+ 
              ",oid_tipo_upc=?"+ 
              ",habilitado=?"+ 
                 " where " +
                 " oid_tipo_hab_upc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_HAB_UPC,pers.getOID());
    qUpdate.setInt(OID_UPC,pers.getUpc().getOID());
    qUpdate.setInt(OID_TIPO_UPC,pers.getTipoupc().getOID());
    qUpdate.setBoolean(HABILITADO,pers.isHabilitado().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_HAB_UPC = 1; 
    TipoHabilitadoUPC pers = (TipoHabilitadoUPC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plTiposHabUPC "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tipo_hab_upc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_HAB_UPC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_HAB_UPC = 1; 
    TipoHabilitadoUPC pers = (TipoHabilitadoUPC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plTiposHabUPC "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tipo_hab_upc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_HAB_UPC, pers.getOID()); 
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
      case SELECT_BY_UPC: {
        ps = this.selectByUPC(aCondiciones); 
        break; 
      }
      case SELECT_BY_UPC_TIPO_UPC: {
        ps = this.selectByUPCTipoUPC(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TIPO_HAB_UPC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plTiposHabUPC "); 
    textSQL.append(" WHERE oid_tipo_hab_upc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TIPO_HAB_UPC, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByUPC(Object aCondiciones) throws BaseException, SQLException { 
  	 StringBuffer textSQL = new StringBuffer(); 
  	 textSQL.append("SELECT * FROM  plTiposHabUPC "); 
  	 textSQL.append(" WHERE oid_upc = ? ");
  	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
  	 UPC upc = (UPC) aCondiciones; 
  	 querySelect.setInt(1, upc.getOID()); 
  	 return querySelect; 
  }
  		
  private PreparedStatement selectByUPCTipoUPC(Object aCondiciones) throws BaseException, SQLException {
   HashTableDatos condiciones = (HashTableDatos) aCondiciones;
   UPC upc = (UPC) condiciones.get(UPC.NICKNAME);
   TipoUPC tipoUPC = (TipoUPC) condiciones.get(TipoUPC.NICKNAME);
 	 StringBuffer textSQL = new StringBuffer(); 
 	 textSQL.append("SELECT * FROM  plTiposHabUPC "); 
 	 textSQL.append(" WHERE oid_upc = ? and oid_tipo_upc = ? ");
 	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
 	 querySelect.setInt(1, upc.getOID()); 
 	 querySelect.setInt(2, tipoUPC.getOID());
 	 return querySelect; 
 }
 		
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plTiposHabUPC "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_hab_upc oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plTiposHabUPC");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getTiposHabilitadosUPC(UPC upc,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(TipoHabilitadoUPC.NICKNAME,
         DBTipoHabilitadoUPC.SELECT_BY_UPC,
         upc,
         new ListObserver(),
         aSesion);
  }
  
  public static TipoHabilitadoUPC getTipoHabilitadoUPC(UPC upc,TipoUPC tipoUPC,
      ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(UPC.NICKNAME,upc);
  	condiciones.put(TipoUPC.NICKNAME,tipoUPC);
  	return (TipoHabilitadoUPC) ObjetoLogico.getObjects(TipoHabilitadoUPC.NICKNAME,
	  				DBTipoHabilitadoUPC.SELECT_BY_UPC_TIPO_UPC,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
  
} 
