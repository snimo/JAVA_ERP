package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioDevVtas;
import com.srn.erp.ventas.bm.ConfigTalonarioDevVtas;
import com.srn.erp.ventas.bm.OperHabiTalonarioDevVtas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBOperHabiTalonarioDevVtas extends DBObjetoPersistente {

  public static final String OID_OPER_TAL_DEV = "oid_oper_tal_dev";
  public static final String OID_CONF_TAL_DEV = "oid_conf_tal_dev";
  public static final String TIPO_DEV = "tipo_dev";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";
  
  public static final int SELECT_BY_CONF_TAL_DEV = 100;
  public static final int SELECT_BY_CONF_TAL_DEV_Y_TIPO_DEV = 101;

  public DBOperHabiTalonarioDevVtas() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OPER_TAL_DEV = 1;
    final int OID_CONF_TAL_DEV = 2;
    final int TIPO_DEV = 3;
    final int USAR_POR_DEFECTO = 4;

    OperHabiTalonarioDevVtas pers = (OperHabiTalonarioDevVtas) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veOperHabTalDev "+
                     " ( "+
                      "OID_OPER_TAL_DEV,"+
                      "OID_CONF_TAL_DEV,"+
                      "TIPO_DEV,"+
                      "USAR_POR_DEFECTO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_OPER_TAL_DEV,pers.getOID());
    qInsert.setInt(OID_CONF_TAL_DEV,pers.getConf_tal_dev().getOID());
    qInsert.setString(TIPO_DEV,pers.getTipo_devolucion());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONF_TAL_DEV = 1;
    final int TIPO_DEV = 2;
    final int USAR_POR_DEFECTO = 3;
    final int OID_OPER_TAL_DEV = 4;

    OperHabiTalonarioDevVtas pers = (OperHabiTalonarioDevVtas) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veOperHabTalDev set "+
              "oid_conf_tal_dev=?"+ 
              ",tipo_dev=?"+ 
              ",usar_por_defecto=?"+ 
                 " where " +
                 " oid_oper_tal_dev=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_TAL_DEV,pers.getOID());
    qUpdate.setInt(OID_CONF_TAL_DEV,pers.getConf_tal_dev().getOID());
    qUpdate.setString(TIPO_DEV,pers.getTipo_devolucion());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OPER_TAL_DEV = 1; 
    OperHabiTalonarioDevVtas pers = (OperHabiTalonarioDevVtas) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from veOperHabTalDev "+
                     " where " + 
                     " oid_oper_tal_dev=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_TAL_DEV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OPER_TAL_DEV = 1; 
    OperHabiTalonarioDevVtas pers = (OperHabiTalonarioDevVtas) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veOperHabTalDev "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_oper_tal_dev=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_TAL_DEV, pers.getOID()); 
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
      case SELECT_BY_CONF_TAL_DEV: {
    	  ps = this.selectByConfTalDev(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_CONF_TAL_DEV_Y_TIPO_DEV: {
    	  ps = this.selectByConfTalDevyTipoDev(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_OPER_TAL_DEV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veOperHabTalDev "); 
    textSQL.append(" WHERE oid_oper_tal_dev = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_OPER_TAL_DEV, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veOperHabTalDev "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByConfTalDev(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veOperHabTalDev "); 
	    textSQL.append(" WHERE OID_CONF_TAL_DEV = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ConfigTalonarioDevVtas confTalDevVtas = (ConfigTalonarioDevVtas) aCondiciones; 
	    querySelect.setInt(1, confTalDevVtas.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByConfTalDevyTipoDev(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veOperHabTalDev "); 
	    textSQL.append(" WHERE OID_CONF_TAL_DEV = ? and tipo_dev = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ConfigTalonarioDevVtas confTalDevVtas = (ConfigTalonarioDevVtas) condiciones.get(ConfigTalonarioDevVtas.NICKNAME);
	    String tipoDevolucion = (String) condiciones.get("TIPO_DEV");
	    querySelect.setInt(1, confTalDevVtas.getOID()); 
	    querySelect.setString(2, tipoDevolucion);
	    return querySelect; 
  }
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_oper_tal_dev oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veOperHabTalDev");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getOperHabilitadasPorConfTalonario(ConfigTalonarioDevVtas configTalDevVtas,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(PeriodoIncDet.NICKNAME,
			  DBOperHabiTalonarioDevVtas.SELECT_BY_CONF_TAL_DEV,
             configTalDevVtas,
             new ListObserver(),
             aSesion);
  }
  
  public static OperHabiTalonarioDevVtas getOperHabiTalonarioDevVtas(ConfigTalonarioDevVtas confTalDevVtas,
		  String tipoDevolucion,
          ISesion aSesion)
          throws BaseException {

	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ConfigTalonarioDevVtas.NICKNAME, confTalDevVtas);
	  condiciones.put("TIPO_DEV", tipoDevolucion);
	  
	  return (OperHabiTalonarioDevVtas) ObjetoLogico.getObjects(OperHabiTalonarioDevVtas.NICKNAME,
			  				DBOperHabiTalonarioDevVtas.SELECT_BY_CONF_TAL_DEV_Y_TIPO_DEV,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  

  
  
} 
