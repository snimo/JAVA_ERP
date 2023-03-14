package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioDevVtas;
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

public class DBCompoStkTalonarioDevVtas extends DBObjetoPersistente {

  public static final String OID_COMPO_STK_DEV = "oid_compo_stk_dev";
  public static final String OID_OPER_TAL_DEV = "oid_oper_tal_dev";
  public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";
  
  public static final int SELECT_BY_OPER_TAL_DEV = 100;
  public static final int SELECT_BY_OPER_TIPO_CONF = 101;

  public DBCompoStkTalonarioDevVtas() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPO_STK_DEV = 1;
    final int OID_OPER_TAL_DEV = 2;
    final int OID_TIPO_CONF_MOV = 3;
    final int USAR_POR_DEFECTO = 4;

    CompoStkTalonarioDevVtas pers = (CompoStkTalonarioDevVtas) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCompoStkTalDev "+
                     " ( "+
                      "OID_COMPO_STK_DEV,"+
                      "OID_OPER_TAL_DEV,"+
                      "OID_TIPO_CONF_MOV,"+
                      "USAR_POR_DEFECTO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMPO_STK_DEV,pers.getOID());
    qInsert.setInt(OID_OPER_TAL_DEV,pers.getOper_hab_tal_dev().getOID());
    qInsert.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OPER_TAL_DEV = 1;
    final int OID_TIPO_CONF_MOV = 2;
    final int USAR_POR_DEFECTO = 3;
    final int OID_COMPO_STK_DEV = 4;

    CompoStkTalonarioDevVtas pers = (CompoStkTalonarioDevVtas) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCompoStkTalDev set "+
              "oid_oper_tal_dev=?"+ 
              ",oid_tipo_conf_mov=?"+ 
              ",usar_por_defecto=?"+ 
                 " where " +
                 " oid_compo_stk_dev=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_STK_DEV,pers.getOID());
    qUpdate.setInt(OID_OPER_TAL_DEV,pers.getOper_hab_tal_dev().getOID());
    qUpdate.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPO_STK_DEV = 1; 
    CompoStkTalonarioDevVtas pers = (CompoStkTalonarioDevVtas) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from veCompoStkTalDev "+
                     " where " + 
                     " oid_compo_stk_dev=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_STK_DEV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPO_STK_DEV = 1; 
    CompoStkTalonarioDevVtas pers = (CompoStkTalonarioDevVtas) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veCompoStkTalDev "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_compo_stk_dev=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_STK_DEV, pers.getOID()); 
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
      case SELECT_BY_OPER_TAL_DEV: {
          ps = this.selectByOperTalDev(aCondiciones); 
          break; 
      }
      case SELECT_BY_OPER_TIPO_CONF: {
          ps = this.selectByOperTipoConf(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COMPO_STK_DEV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veCompoStkTalDev "); 
    textSQL.append(" WHERE oid_compo_stk_dev = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMPO_STK_DEV, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByOperTipoConf(Object aCondiciones) throws BaseException, SQLException { 
	    
	  StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veCompoStkTalDev "); 
	    textSQL.append(" WHERE oid_oper_tal_dev = ? and oid_tipo_conf_mov = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    OperHabiTalonarioDevVtas operHabTalDev = (OperHabiTalonarioDevVtas) condiciones.get(OperHabiTalonarioDevVtas.NICKNAME);
	    TipoConfMovStkTalonario tipoConfMovStok = (TipoConfMovStkTalonario) condiciones.get(TipoConfMovStkTalonario.NICKNAME);
	    querySelect.setInt(1, operHabTalDev.getOID()); 
	    querySelect.setInt(2, tipoConfMovStok.getOID());
	    return querySelect; 
	    
  }
  
  
  private PreparedStatement selectByOperTalDev(Object aCondiciones) throws BaseException, SQLException { 
	    
	  StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veCompoStkTalDev "); 
	    textSQL.append(" WHERE oid_oper_tal_dev = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    OperHabiTalonarioDevVtas operHabTalDev = (OperHabiTalonarioDevVtas) aCondiciones; 
	    querySelect.setInt(1, operHabTalDev.getOID()); 
	    return querySelect; 
	    
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veCompoStkTalDev "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compo_stk_dev oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veCompoStkTalDev");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCompoStockTalonario(OperHabiTalonarioDevVtas operHabDevVtas,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CompoStkTalonarioDevVtas.NICKNAME,
             DBCompoStkTalonarioDevVtas.SELECT_BY_OPER_TAL_DEV,
             operHabDevVtas,
             new ListObserver(),
             aSesion);
  }
  
  public static CompoStkTalonarioDevVtas getCompoStkTalDevVtas(OperHabiTalonarioDevVtas operHabTalDev,
		  TipoConfMovStkTalonario tipoConfMovStok,
          ISesion aSesion)
          throws BaseException {

	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(OperHabiTalonarioDevVtas.NICKNAME, operHabTalDev);
	  condiciones.put(TipoConfMovStkTalonario.NICKNAME, tipoConfMovStok);
	  
	  return (CompoStkTalonarioDevVtas) ObjetoLogico.getObjects(CompoStkTalonarioDevVtas.NICKNAME,
			  				DBCompoStkTalonarioDevVtas.SELECT_BY_OPER_TIPO_CONF,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
