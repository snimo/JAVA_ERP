package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;
import com.srn.erp.tesoreria.bm.LiquidacionTarCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBLiquidacionTarCab extends DBObjetoPersistente {

  public static final String OID_LIQUI_TAR = "oid_liqui_tar";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String COMPO_TIPO_VALOR = "compo_tipo_valor";
  public static final String OID_TAR_CREDITO = "oid_tar_credito";
  public static final String OID_BANCO = "oid_banco";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String FEC_VTO = "fec_vto";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COTIZACION = "cotizacion";
  public static final String IMPORTE = "importe";
  public static final String OID_CONC_LIQ_TC = "oid_conc_liq_tc";
  public static final String OID_CAJA = "oid_caja";
  public static final String OID_VALOR = "oid_valor";
  
  public static final int SELECT_BY_HELP_LIQUIDACION = 100;

  public DBLiquidacionTarCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LIQUI_TAR = 1;
    final int OID_TIPO_VALOR = 2;
    final int COMPO_TIPO_VALOR = 3;
    final int OID_TAR_CREDITO = 4;
    final int OID_BANCO = 5;
    final int FEC_DESDE = 6;
    final int FEC_HASTA = 7;
    final int FEC_VTO = 8;
    final int OID_MONEDA = 9;
    final int COTIZACION = 10;
    final int IMPORTE = 11;
    final int OID_CONC_LIQ_TC = 12;
    final int OID_CAJA = 13;
    final int OID_VALOR = 14;

    LiquidacionTarCab pers = (LiquidacionTarCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaLiquiTarjeta "+
                     " ( "+
                      "OID_LIQUI_TAR,"+
                      "OID_TIPO_VALOR,"+
                      "COMPO_TIPO_VALOR,"+
                      "OID_TAR_CREDITO,"+
                      "OID_BANCO,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "FEC_VTO,"+
                      "OID_MONEDA,"+
                      "COTIZACION,"+
                      "IMPORTE,"+
                      "OID_CONC_LIQ_TC,OID_CAJA,OID_VALOR)"+ 
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LIQUI_TAR,pers.getOID());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qInsert.setString(COMPO_TIPO_VALOR,pers.getCompo_tipo_valor());
    if (pers.getTarjeta_credito()!=null) 
      qInsert.setInt(OID_TAR_CREDITO,pers.getTarjeta_credito().getOID());
    else
      qInsert.setNull(OID_TAR_CREDITO,java.sql.Types.INTEGER);
    if (pers.getBanco()!=null) 
      qInsert.setInt(OID_BANCO,pers.getBanco().getOID());
    else
      qInsert.setNull(OID_BANCO,java.sql.Types.INTEGER);
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qInsert.setDate(FEC_VTO,new java.sql.Date(pers.getFec_vto().getTime()));
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setInt(OID_CONC_LIQ_TC,pers.getConcepto_liq_tar().getOID());
    if (pers.getCaja()!=null)
    	qInsert.setInt(OID_CAJA,pers.getCaja().getOID());
    else
    	qInsert.setNull(OID_CAJA,java.sql.Types.INTEGER);
    if (pers.getValor()!=null)
    	qInsert.setInt(OID_VALOR,pers.getValor().getOID());
    else
    	qInsert.setNull(OID_VALOR,java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_VALOR = 1;
    final int COMPO_TIPO_VALOR = 2;
    final int OID_TAR_CREDITO = 3;
    final int OID_BANCO = 4;
    final int FEC_DESDE = 5;
    final int FEC_HASTA = 6;
    final int FEC_VTO = 7;
    final int OID_MONEDA = 8;
    final int COTIZACION = 9;
    final int IMPORTE = 10;
    final int OID_CONC_LIQ_TC = 11;
    final int OID_CAJA = 12;
    final int OID_VALOR = 13;
    final int OID_LIQUI_TAR = 14;

    LiquidacionTarCab pers = (LiquidacionTarCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaLiquiTarjeta set "+
              "oid_tipo_valor=?"+ 
              ",compo_tipo_valor=?"+ 
              ",oid_tar_credito=?"+ 
              ",oid_banco=?"+ 
              ",fec_desde=?"+ 
              ",fec_hasta=?"+ 
              ",fec_vto=?"+ 
              ",oid_moneda=?"+ 
              ",cotizacion=?"+ 
              ",importe=?"+ 
              ",oid_conc_liq_tc=?"+ 
              ",oid_caja=?"+
              ",oid_valor=?"+
                 " where " +
                 " oid_liqui_tar=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LIQUI_TAR,pers.getOID());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qUpdate.setString(COMPO_TIPO_VALOR,pers.getCompo_tipo_valor());
    if (pers.getTarjeta_credito()!=null) 
      qUpdate.setInt(OID_TAR_CREDITO,pers.getTarjeta_credito().getOID());
    else
      qUpdate.setNull(OID_TAR_CREDITO,java.sql.Types.INTEGER);
    if (pers.getBanco()!=null) 
      qUpdate.setInt(OID_BANCO,pers.getBanco().getOID());
    else
      qUpdate.setNull(OID_BANCO,java.sql.Types.INTEGER);
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qUpdate.setDate(FEC_VTO,new java.sql.Date(pers.getFec_vto().getTime()));
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setInt(OID_CONC_LIQ_TC,pers.getConcepto_liq_tar().getOID());
    if (pers.getCaja()!=null)
    	qUpdate.setInt(OID_CAJA,pers.getCaja().getOID());
    else
    	qUpdate.setNull(OID_CAJA,java.sql.Types.INTEGER);
    if (pers.getValor()!=null)
    	qUpdate.setInt(OID_VALOR,pers.getValor().getOID());
    else
    	qUpdate.setNull(OID_VALOR,java.sql.Types.INTEGER);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    LiquidacionTarCab pers = (LiquidacionTarCab) objetoPersistente;
	StringBuffer sqlUpdate = new StringBuffer();
	sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
	PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
	qUpdate.setInt(1, pers.getOID());
	qUpdate.executeUpdate();
	qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LIQUI_TAR = 1; 
    LiquidacionTarCab pers = (LiquidacionTarCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaLiquiTarjeta "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_liqui_tar=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LIQUI_TAR, pers.getOID()); 
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
      case SELECT_BY_HELP_LIQUIDACION: {
          ps = this.selectByHelpLiquidacion(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LIQUI_TAR = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaLiquiTarjeta a, geComproCab b "); 
    textSQL.append(" WHERE a.oid_liqui_tar=b.oid_cco and a.oid_liqui_tar = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LIQUI_TAR, oid); 
    return querySelect; 
  }
  
	private PreparedStatement selectByHelpLiquidacion(Object aCondiciones) throws BaseException, SQLException {

		int nroParam = 0;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  vaLiquiTarjeta a, geComproCab b  ");

		textSQL.append(" WHERE  a.oid_liqui_tar = b.oid_cco ");

		if (condiciones.containsKey(ConceptoLiqTarjeta.NICKNAME)) {
			ConceptoLiqTarjeta conceptoLiquidacion = (ConceptoLiqTarjeta) condiciones.get(ConceptoLiqTarjeta.NICKNAME);
			textSQL.append(" and a.oid_conc_liq_tc = " + conceptoLiquidacion.getOIDInteger().toString());
		}

		if (condiciones.containsKey("NRO_EXT_DESDE"))
			textSQL.append(" and b.nro_ext >= " + condiciones.getInteger("NRO_EXT_DESDE").toString());

		if (condiciones.containsKey("NRO_EXT_HASTA"))
			textSQL.append(" and b.nro_ext <= " + condiciones.getInteger("NRO_EXT_HASTA").toString());

		if (condiciones.containsKey("FEC_DESDE"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and b.emision <= ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		if (condiciones.containsKey("FEC_DESDE")) {
			java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}

		return querySelect;
	}
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaLiquiTarjeta "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_liqui_tar oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaLiquiTarjeta");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
	public static List getHelpLiquidacionTarjetasCab(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			ConceptoLiqTarjeta conceptoLiquidacion, 
			Date fechaDesde,
			Date fechaHasta, 
			ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("NRO_EXT_DESDE", nroExtDesde.toString());
		if (nroExtHasta != null)
			condiciones.put("NRO_EXT_HASTA", nroExtHasta.toString());
		if (fechaDesde != null)
			condiciones.put("FEC_DESDE", fechaDesde);
		if (fechaHasta != null)
			condiciones.put("FEC_HASTA", fechaHasta);
		if (conceptoLiquidacion != null)
			condiciones.put(ConceptoLiqTarjeta.NICKNAME, conceptoLiquidacion);

		return (List) ObjetoLogico.getObjects(LiquidacionTarCab.NICKNAME, 
				                                  DBLiquidacionTarCab.SELECT_BY_HELP_LIQUIDACION, 
				                                  condiciones, new ListObserver(),
			aSesion);
	}
  
  
} 
