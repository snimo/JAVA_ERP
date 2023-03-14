package com.srn.erp.conciTarjeta.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBCabAsiLiquiTarj extends DBObjetoPersistente {

  public static final String OID_CAB_ASI_LIQ = "oid_cab_asi_liq";
  public static final String FEC_ASIENTO = "fec_asiento";
  public static final String COMENTARIO = "comentario";
  public static final String NRO_LIQUIDACION = "nro_liquidacion";
  public static final String ARCH_INTERFAZ_GEN = "arch_interfaz_gen";
  public static final String FEC_ARCH_INTERFAZ = "fec_arch_interfaz";
  public static final String HORA_ARCH_INTERFAZ = "hora_arch_interfaz";
  public static final String CONTA_SIST_EXT = "conta_sist_ext";
  public static final String FEC_CONTA_SIST_EXT = "fec_conta_sist_ext";
  public static final String HOR_CONTA_SIST_EXT = "hor_conta_sist_ext";
  public static final String OID_TIPO_ARCHIVO = "oid_tipo_archivo";
  public static final String ACTIVO = "activo";
  public static final String OID_CTA_BANCO = "oid_cta_banco";
  public static final String OID_MODELO_LIQ = "oid_modelo_liq";
  public static final String OID_EMPRESA = "oid_empresa";
  
  public static final int SELECT_BY_MODELO_FECHA_NRO  = 100;
  public static final int SELECT_BY_FECHA_DESDE_HASTA = 101;

  public DBCabAsiLiquiTarj() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAB_ASI_LIQ = 1;
    final int FEC_ASIENTO = 2;
    final int COMENTARIO = 3;
    final int NRO_LIQUIDACION = 4;
    final int ARCH_INTERFAZ_GEN = 5;
    final int FEC_ARCH_INTERFAZ = 6;
    final int HORA_ARCH_INTERFAZ = 7;
    final int CONTA_SIST_EXT = 8;
    final int FEC_CONTA_SIST_EXT = 9;
    final int HOR_CONTA_SIST_EXT = 10;
    final int OID_TIPO_ARCHIVO = 11;
    final int ACTIVO = 12;
    final int OID_CTA_BANCO = 13;
    final int OID_MODELO_LIQ = 14;
    final int OID_EMPRESA = 15;

    CabAsiLiquiTarj pers = (CabAsiLiquiTarj) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarCabAsiLiq "+
                     " ( "+
                      "OID_CAB_ASI_LIQ,"+
                      "FEC_ASIENTO,"+
                      "COMENTARIO,"+
                      "NRO_LIQUIDACION,"+
                      "ARCH_INTERFAZ_GEN,"+
                      "FEC_ARCH_INTERFAZ,"+
                      "HORA_ARCH_INTERFAZ,"+
                      "CONTA_SIST_EXT,"+
                      "FEC_CONTA_SIST_EXT,"+
                      "HOR_CONTA_SIST_EXT,"+
                      "OID_TIPO_ARCHIVO,"+
                      "ACTIVO , OID_CTA_BANCO , OID_MODELO_LIQ , OID_EMPRESA)"+ 
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CAB_ASI_LIQ,pers.getOID());
    qInsert.setDate(FEC_ASIENTO,new java.sql.Date(pers.getFec_asiento().getTime()));
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.setInt(NRO_LIQUIDACION,pers.getNro_liquidacion().intValue());
    qInsert.setBoolean(ARCH_INTERFAZ_GEN,pers.isArch_interfaz_gen().booleanValue());
    if (pers.getFec_arch_interfaz()!=null) 
      qInsert.setDate(FEC_ARCH_INTERFAZ,new java.sql.Date(pers.getFec_arch_interfaz().getTime()));
    else
      qInsert.setNull(FEC_ARCH_INTERFAZ,java.sql.Types.DATE);
    qInsert.setString(HORA_ARCH_INTERFAZ,pers.getHora_arch_interfaz());
    qInsert.setBoolean(CONTA_SIST_EXT,pers.isConta_sist_ext().booleanValue());
    if (pers.getFec_conta_sist_ext()!=null) 
      qInsert.setDate(FEC_CONTA_SIST_EXT,new java.sql.Date(pers.getFec_conta_sist_ext().getTime()));
    else
      qInsert.setNull(FEC_CONTA_SIST_EXT,java.sql.Types.DATE);
    qInsert.setString(HOR_CONTA_SIST_EXT,pers.getHor_conta_sist_ext());
    if (pers.getTipo_archivo()!=null) 
      qInsert.setInt(OID_TIPO_ARCHIVO,pers.getTipo_archivo().getOID());
    else
      qInsert.setNull(OID_TIPO_ARCHIVO,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCtaBancoLiqTarj()!=null)
    	qInsert.setInt(OID_CTA_BANCO, pers.getCtaBancoLiqTarj().getOID());
    else
    	qInsert.setNull(OID_CTA_BANCO, Types.INTEGER);
    if (pers.getCabModeloLiq()!=null)
    	qInsert.setInt(OID_MODELO_LIQ, pers.getCabModeloLiq().getOID());
    else
    	qInsert.setNull(OID_MODELO_LIQ, Types.INTEGER);
    if (pers.getEmpresa()!=null)
    	qInsert.setInt(OID_EMPRESA, pers.getEmpresa().getOID());
    else
    	qInsert.setNull(OID_EMPRESA, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FEC_ASIENTO = 1;
    final int COMENTARIO = 2;
    final int NRO_LIQUIDACION = 3;
    final int ARCH_INTERFAZ_GEN = 4;
    final int FEC_ARCH_INTERFAZ = 5;
    final int HORA_ARCH_INTERFAZ = 6;
    final int CONTA_SIST_EXT = 7;
    final int FEC_CONTA_SIST_EXT = 8;
    final int HOR_CONTA_SIST_EXT = 9;
    final int OID_TIPO_ARCHIVO = 10;
    final int ACTIVO = 11;
    final int OID_CTA_BANCO  =12;
    final int OID_MODELO_LIQ = 13;
    final int OID_EMPRESA = 14;
    final int OID_CAB_ASI_LIQ = 15;

    CabAsiLiquiTarj pers = (CabAsiLiquiTarj) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarCabAsiLiq set "+
              "fec_asiento=?"+ 
              ",comentario=?"+ 
              ",nro_liquidacion=?"+ 
              ",arch_interfaz_gen=?"+ 
              ",fec_arch_interfaz=?"+ 
              ",hora_arch_interfaz=?"+ 
              ",conta_sist_ext=?"+ 
              ",fec_conta_sist_ext=?"+ 
              ",hor_conta_sist_ext=?"+ 
              ",oid_tipo_archivo=?"+
              ",activo=?"+
              ",oid_cta_banco=? "+
              ",oid_modelo_liq=? "+
              ",oid_empresa=? "+
                 " where " +
                 " oid_cab_asi_liq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_LIQ,pers.getOID());
    qUpdate.setDate(FEC_ASIENTO,new java.sql.Date(pers.getFec_asiento().getTime()));
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.setInt(NRO_LIQUIDACION,pers.getNro_liquidacion().intValue());
    qUpdate.setBoolean(ARCH_INTERFAZ_GEN,pers.isArch_interfaz_gen().booleanValue());
    if (pers.getFec_arch_interfaz()!=null) 
      qUpdate.setDate(FEC_ARCH_INTERFAZ,new java.sql.Date(pers.getFec_arch_interfaz().getTime()));
    else
      qUpdate.setNull(FEC_ARCH_INTERFAZ,java.sql.Types.DATE);
    qUpdate.setString(HORA_ARCH_INTERFAZ,pers.getHora_arch_interfaz());
    qUpdate.setBoolean(CONTA_SIST_EXT,pers.isConta_sist_ext().booleanValue());
    if (pers.getFec_conta_sist_ext()!=null) 
      qUpdate.setDate(FEC_CONTA_SIST_EXT,new java.sql.Date(pers.getFec_conta_sist_ext().getTime()));
    else
      qUpdate.setNull(FEC_CONTA_SIST_EXT,java.sql.Types.DATE);
    qUpdate.setString(HOR_CONTA_SIST_EXT,pers.getHor_conta_sist_ext());
    if (pers.getTipo_archivo()!=null) 
      qUpdate.setInt(OID_TIPO_ARCHIVO,pers.getTipo_archivo().getOID());
    else
      qUpdate.setNull(OID_TIPO_ARCHIVO,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCtaBancoLiqTarj()!=null)
    	qUpdate.setInt(OID_CTA_BANCO, pers.getCtaBancoLiqTarj().getOID());
    else
    	qUpdate.setNull(OID_CTA_BANCO, Types.INTEGER); 
    if (pers.getCabModeloLiq()!=null)
    	qUpdate.setInt(OID_MODELO_LIQ, pers.getCabModeloLiq().getOID());
    else
    	qUpdate.setNull(OID_MODELO_LIQ, Types.INTEGER);
    if (pers.getEmpresa()!=null)
    	qUpdate.setInt(OID_EMPRESA, pers.getEmpresa().getOID());
    else
    	qUpdate.setNull(OID_EMPRESA, Types.INTEGER);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAB_ASI_LIQ = 1; 
    CabAsiLiquiTarj pers = (CabAsiLiquiTarj) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarCabAsiLiq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cab_asi_liq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_LIQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAB_ASI_LIQ = 1; 
    CabAsiLiquiTarj pers = (CabAsiLiquiTarj) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarCabAsiLiq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cab_asi_liq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_LIQ, pers.getOID()); 
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
      case SELECT_BY_MODELO_FECHA_NRO: {
          ps = this.selectByModeloFechaNroLiq(aCondiciones); 
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

    final int OID_CAB_ASI_LIQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarCabAsiLiq "); 
    textSQL.append(" WHERE oid_cab_asi_liq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CAB_ASI_LIQ, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFechaDesdeHasta(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarCabAsiLiq "); 
	    textSQL.append(" WHERE fec_asiento >= ? and fec_asiento <= ? and activo = 1"); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    java.util.Date fechaDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    java.util.Date fechaHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    querySelect.setDate(1, new java.sql.Date(fechaDesde.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fechaHasta.getTime()));
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByModeloFechaNroLiq(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarCabAsiLiq "); 
	    textSQL.append(" WHERE oid_modelo_liq = ? and fec_asiento = ? and nro_liquidacion = ? and activo = 1"); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    CabModeloLiq cabModeloLiq = (CabModeloLiq) condiciones.get(CabModeloLiq.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    Integer nroLiquidacion = (Integer) condiciones.get("NRO_LIQUIDACION"); 
	    querySelect.setInt(1, cabModeloLiq.getOID()); 
	    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    querySelect.setInt(3, nroLiquidacion.intValue());
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarCabAsiLiq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cab_asi_liq oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cTarCabAsiLiq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAsientos(CabModeloLiq cabModeloLiq,
		  						 java.util.Date fecha,
		  						 Integer nroLiquidacion,
		  						 ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(CabModeloLiq.NICKNAME, cabModeloLiq);
	  condiciones.put("FECHA", fecha);
	  condiciones.put("NRO_LIQUIDACION", nroLiquidacion);

	  return (List) ObjetoLogico.getObjects(CabAsiLiquiTarj.NICKNAME,
             DBCabAsiLiquiTarj.SELECT_BY_MODELO_FECHA_NRO,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getAsientosByFechas(
			 java.util.Date fechaDesde,
			 java.util.Date fechaHasta,
			 ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FEC_DESDE", fechaDesde);
	  condiciones.put("FEC_HASTA", fechaHasta);
	  return (List) ObjetoLogico.getObjects(CabAsiLiquiTarj.NICKNAME,
			  DBCabAsiLiquiTarj.SELECT_BY_FECHA_DESDE_HASTA,
			  condiciones,
			  new ListObserver(),
			  aSesion);
  }  
  
} 
