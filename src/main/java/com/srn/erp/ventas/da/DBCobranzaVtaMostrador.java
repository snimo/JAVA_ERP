package com.srn.erp.ventas.da;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.CobranzaVtaMostrador;
import com.srn.erp.ventas.bm.FacturaCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCobranzaVtaMostrador extends DBObjetoPersistente {

  public static final String OID_COB_VTA_MOS = "oid_cob_vta_mos";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String OID_VALOR = "oid_valor";
  public static final String COTIZACION = "cotizacion";
  public static final String IMPO_MON_TV = "impo_mon_tv";
  public static final String IMPO_MON_FACT = "impo_mon_fact";
  public static final String OID_CCO_FACT = "oid_cco_fact";
  
  public static final int SELECT_BY_FACTURA = 100;

  public DBCobranzaVtaMostrador() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COB_VTA_MOS = 1;
    final int OID_TIPO_VALOR = 2;
    final int OID_VALOR = 3;
    final int COTIZACION = 4;
    final int IMPO_MON_TV = 5;
    final int IMPO_MON_FACT = 6;
    final int OID_CCO_FACT = 7;

    CobranzaVtaMostrador pers = (CobranzaVtaMostrador) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCobrabzaVtaMos "+
                     " ( "+
                      "OID_COB_VTA_MOS,"+
                      "OID_TIPO_VALOR,"+
                      "OID_VALOR,"+
                      "COTIZACION,"+
                      "IMPO_MON_TV,"+
                      "IMPO_MON_FACT,OID_CCO_FACT)"+ 
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
    qInsert.setInt(OID_COB_VTA_MOS,pers.getOID());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    if (pers.getValor()!=null) 
      qInsert.setInt(OID_VALOR,pers.getValor().getOID());
    else
      qInsert.setNull(OID_VALOR,java.sql.Types.INTEGER);
    if (pers.getCotizacion()!=null) 
      qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    else
      qInsert.setNull(COTIZACION,java.sql.Types.DOUBLE);
    qInsert.setDouble(IMPO_MON_TV,pers.getImpo_mon_tv().doubleValue());
    qInsert.setDouble(IMPO_MON_FACT,pers.getImpo_mon_fact().doubleValue());
    qInsert.setInt(OID_CCO_FACT,pers.getFacturaCab().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_VALOR = 1;
    final int OID_VALOR = 2;
    final int COTIZACION = 3;
    final int IMPO_MON_TV = 4;
    final int IMPO_MON_FACT = 5;
    final int OID_CCO_FACT = 6;
    final int OID_COB_VTA_MOS = 7;

    CobranzaVtaMostrador pers = (CobranzaVtaMostrador) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCobrabzaVtaMos set "+
              "oid_tipo_valor=?"+ 
              ",oid_valor=?"+ 
              ",cotizacion=?"+ 
              ",impo_mon_tv=?"+ 
              ",impo_mon_fact=?"+
              ",oid_cco_fact=?"+
                 " where " +
                 " oid_cob_vta_mos=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COB_VTA_MOS,pers.getOID());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    if (pers.getValor()!=null) 
      qUpdate.setInt(OID_VALOR,pers.getValor().getOID());
    else
      qUpdate.setNull(OID_VALOR,java.sql.Types.INTEGER);
    if (pers.getCotizacion()!=null) 
      qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    else
      qUpdate.setNull(COTIZACION,java.sql.Types.DOUBLE);
    qUpdate.setDouble(IMPO_MON_TV,pers.getImpo_mon_tv().doubleValue());
    qUpdate.setInt(OID_CCO_FACT,pers.getFacturaCab().getOID());
    qUpdate.setDouble(IMPO_MON_FACT,pers.getImpo_mon_fact().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COB_VTA_MOS = 1; 
    CobranzaVtaMostrador pers = (CobranzaVtaMostrador) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veCobrabzaVtaMos "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cob_vta_mos=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COB_VTA_MOS, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COB_VTA_MOS = 1; 
    CobranzaVtaMostrador pers = (CobranzaVtaMostrador) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veCobrabzaVtaMos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cob_vta_mos=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COB_VTA_MOS, pers.getOID()); 
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
      case SELECT_BY_FACTURA: {
        ps = this.selectByFactura(aCondiciones); 
        break;     	  
      }
    } 
    return ps;
  } 
  
  private PreparedStatement selectByFactura(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  veCobrabzaVtaMos "); 
	textSQL.append(" WHERE oid_cco_fact = ? "); 
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	FacturaCab facturaCab = (FacturaCab) aCondiciones;
	querySelect.setInt(1, facturaCab.getOID()); 
	return querySelect; 
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COB_VTA_MOS = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veCobrabzaVtaMos "); 
    textSQL.append(" WHERE oid_cob_vta_mos = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COB_VTA_MOS, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veCobrabzaVtaMos "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cob_vta_mos oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veCobrabzaVtaMos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getCobranzasVtaMos(FacturaCab facturaCab,
          								ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CobranzaVtaMostrador.NICKNAME,
             DBCobranzaVtaMostrador.SELECT_BY_FACTURA,
             facturaCab,
             new ListObserver(),
             aSesion);
  }  
  
} 
