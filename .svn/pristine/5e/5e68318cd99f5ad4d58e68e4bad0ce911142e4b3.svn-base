package com.srn.erp.bancos.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConciliacionCab extends DBObjetoPersistente {

  public static final String OID_CONCI_BCO = "oid_conci_bco";
  public static final String CODIGO = "codigo";
  public static final String CONCILIADO_AL = "conciliado_al";
  public static final String FEC_DESDE = "fec_desde";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_CTA_BANCARIA = "oid_cta_bancaria";
  public static final String OBS_GENERALES = "obs_generales";
  public static final String SALDO_INI_EXTRAC = "saldo_ini_extrac";
  
  public static final int SELECT_BY_HELP_CONC_BANCO = 100;

  public DBConciliacionCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONCI_BCO = 1;
    final int CODIGO = 2;
    final int CONCILIADO_AL = 3;
    final int FEC_DESDE = 4;
    final int DESCRIPCION = 5;
    final int OID_CTA_BANCARIA = 6;
    final int OBS_GENERALES = 7;
    final int SALDO_INI_EXTRAC = 8;

    ConciliacionCab pers = (ConciliacionCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaConciBco "+
                     " ( "+
                      "OID_CONCI_BCO,"+
                      "CODIGO,"+
                      "CONCILIADO_AL,"+
                      "FEC_DESDE,"+
                      "DESCRIPCION,"+
                      "OID_CTA_BANCARIA,"+
                      "OBS_GENERALES,"+
                      "SALDO_INI_EXTRAC)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONCI_BCO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setDate(CONCILIADO_AL,new java.sql.Date(pers.getConciliado_al().getTime()));
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    qInsert.setString(OBS_GENERALES,pers.getObs_generales());
    qInsert.setDouble(SALDO_INI_EXTRAC,pers.getSaldo_ini_extrac().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int CONCILIADO_AL = 2;
    final int FEC_DESDE = 3;
    final int DESCRIPCION = 4;
    final int OID_CTA_BANCARIA = 5;
    final int OBS_GENERALES = 6;
    final int SALDO_INI_EXTRAC = 7;
    final int OID_CONCI_BCO = 8;

    ConciliacionCab pers = (ConciliacionCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaConciBco set "+
              "codigo=?"+ 
              ",conciliado_al=?"+ 
              ",fec_desde=?"+ 
              ",descripcion=?"+ 
              ",oid_cta_bancaria=?"+ 
              ",obs_generales=?"+ 
              ",saldo_ini_extrac=?"+ 
                 " where " +
                 " oid_conci_bco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONCI_BCO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setDate(CONCILIADO_AL,new java.sql.Date(pers.getConciliado_al().getTime()));
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    qUpdate.setString(OBS_GENERALES,pers.getObs_generales());
    qUpdate.setDouble(SALDO_INI_EXTRAC,pers.getSaldo_ini_extrac().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONCI_BCO = 1; 
    ConciliacionCab pers = (ConciliacionCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");    
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONCI_BCO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONCI_BCO = 1; 
    ConciliacionCab pers = (ConciliacionCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaConciBco "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conci_bco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONCI_BCO, pers.getOID()); 
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
      case SELECT_BY_HELP_CONC_BANCO: {
          ps = this.selectByHelpConcBanco(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONCI_BCO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaConciBco a,geComproCab b "); 
    textSQL.append(" WHERE a.oid_conci_bco = b.oid_cco and a.oid_conci_bco = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONCI_BCO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByHelpConcBanco(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaConciBco a,geComproCab b "); 
	    textSQL.append(" WHERE a.oid_conci_bco = b.oid_cco  ");
	    
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		if (condiciones.containsKey(CuentaBancaria.NICKNAME)) {
			CuentaBancaria ctaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
			textSQL.append(" and a.oid_cta_bancaria = " + ctaBancaria.getOIDInteger().toString());
		}

		if (condiciones.containsKey("NRO_DESDE")) {
			Integer nroExt = (Integer) condiciones.get("NRO_DESDE");
			textSQL.append(" and b.nro_ext >= " + nroExt.toString());
		}

		if (condiciones.containsKey("NRO_HASTA")) {
			Integer nroExt = (Integer) condiciones.get("NRO_HASTA");
			textSQL.append(" and b.nro_ext <= " + nroExt.toString());
		}

		if (condiciones.containsKey("FEC_DESDE"))
			textSQL.append(" and a.fec_desde >= ? ");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and a.conciliado_al <= ? ");
		
	    
		int nroParam = 0;

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		if (condiciones.containsKey("FEC_DESDE")) {
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_DESDE");
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecha.getTime()));
		}

		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_HASTA");
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecha.getTime()));
		}
		
	    
	     
	    return querySelect; 
	  }
  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaConciBco a , geComproCab b "); 
    textSQL.append(" WHERE a.oid_conci_bco = b.oid_cco and codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conci_bco oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from vaConciBco");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConciliacionesBancarias(
		  CuentaBancaria cuentaBancaria,
		  java.util.Date fechaDesde,
		  java.util.Date fechaHasta,
		  Integer nroDesde,
		  Integer nroHasta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (cuentaBancaria!=null)
		  condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
	  if (fechaDesde!=null)
		  condiciones.put("FEC_DESDE", fechaDesde);	  
	  if (fechaHasta!=null)
		  condiciones.put("FEC_HASTA", fechaHasta);
	  if (nroDesde!=null)
		  condiciones.put("NRO_DESDE", nroDesde);
	  if (nroHasta!=null)
		  condiciones.put("NRO_HASTA", nroHasta);
	  
	  return (List) ObjetoLogico.getObjects(ConciliacionCab.NICKNAME,
             DBConciliacionCab.SELECT_BY_HELP_CONC_BANCO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
} 
