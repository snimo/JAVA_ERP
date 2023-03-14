package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.conciTarjeta.bm.CabConciAutomatica;
import com.srn.erp.conciTarjeta.bm.CabTarConciEnt;
import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBDetTarConciEnt extends DBObjetoPersistente {

  public static final String OID_TAR_INFO_DET = "oid_tar_info_det";
  public static final String OID_TAR_INFO_CAB = "oid_tar_info_cab";
  public static final String TIPO_OPERACION = "tipo_operacion";
  public static final String FEC_PRESENT = "fec_present";
  public static final String LOTE = "lote";
  public static final String FEC_PAGO = "fec_pago";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_EMPRESA = "oid_empresa";
  public static final String NRO_COMPROBANTE = "nro_comprobante";
  public static final String FEC_ORIGEN = "fec_origen";
  public static final String PLAN = "plan";
  public static final String NRO_TARJETA = "nro_tarjeta";
  public static final String CUOTA = "cuota";
  public static final String MONEDA = "moneda";
  public static final String COMERCIO = "comercio";
  public static final String IMPORTE = "importe";
  public static final String NRO_CUPON = "nro_cupon";
  public static final String ACTIVO = "activo";
  public static final String TIPO_TARJETA = "tipo_tarjeta";
  public static final String CONCILIADO = "conciliado";
  public static final String FEC_CONCILIADO = "fec_conciliado";
  public static final String TARJETA = "tarjeta";
  public static final String PRECONCI = "preconci";
  public static final String FEC_PRECONCI = "fec_preconci";
  public static final String USU_PRECONCI = "oid_usu_preconci";
  public static final String NRO_CONCILIACION = "nro_conciliacion";
  public static final String MARCAR_PRECONCI = "marcar_preconci";
  public static final String OID_USU_MAR_PRE = "oid_usu_mar_pre";
  public static final String OID_CAB_CONCI_AUT = "oid_cab_conci_aut";
  public static final String PRECONCI_DUDOSO = "preconci_dudoso";
  public static final String NOM_ARCHIVO = "nom_archivo";
  public static final String ALTA_MANUAL = "alta_manual";
  
  public static final int SELECT_BY_CABECERA = 100;
  public static final int SELECT_BY_EMP_PEND_CONCI = 101;
  public static final int MARCAR_COMO_PRECONCI = 102;
  public static final int MARCAR_COMO_NO_PRECONCI = 103;
  public static final int SELECT_BY_MARCADO_PRECONCI_EMP_USU = 104;
  public static final int GENERAR_PRECONCILIACION = 105;
  public static final int MARCAR_COMO_CONCILIADO = 106;
  public static final int SELECT_BY_PRECONCI_BY_NRO = 107;
  public static final int SELECT_BY_PEND_PRECONCI_TARJ = 108;
  public static final int SELECT_BY_EMPRESA_NRO_CONCI = 109;
  public static final int SELECT_BY_EMPRESA_CONCI_AUT = 110;

  public DBDetTarConciEnt() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TAR_INFO_DET = 1;
    final int OID_TAR_INFO_CAB = 2;
    final int TIPO_OPERACION = 3;
    final int FEC_PRESENT = 4;
    final int LOTE = 5;
    final int FEC_PAGO = 6;
    final int DESCRIPCION = 7;
    final int OID_EMPRESA = 8;
    final int NRO_COMPROBANTE = 9;
    final int FEC_ORIGEN = 10;
    final int PLAN = 11;
    final int NRO_TARJETA = 12;
    final int CUOTA = 13;
    final int MONEDA = 14;
    final int COMERCIO = 15;
    final int IMPORTE = 16;
    final int NRO_CUPON = 17;
    final int ACTIVO = 18;
    final int TIPO_TARJETA = 19;
    final int CONCILIADO = 20;
    final int FEC_CONCILIADO = 21;
    final int TARJETA = 22;
    final int PRECONCI = 23;
    final int FEC_PRECONCI = 24;
    final int OID_USU_PRECONCI = 25;
    final int NRO_CONCILIACION = 26;
    final int MARCAR_PRECONCI = 27;
    final int OID_CAB_CONCI_AUT = 28;
    final int PRECONCI_DUDOSO = 29;
    final int NOM_ARCHIVO = 30;
    final int ALTA_MANUAL = 31;

    DetTarConciEnt pers = (DetTarConciEnt) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarInfPorEntDet "+
                     " ( "+
                      "OID_TAR_INFO_DET,"+
                      "OID_TAR_INFO_CAB,"+
                      "TIPO_OPERACION,"+
                      "FEC_PRESENT,"+
                      "LOTE,"+
                      "FEC_PAGO,"+
                      "DESCRIPCION,"+
                      "OID_EMPRESA,"+
                      "NRO_COMPROBANTE,"+
                      "FEC_ORIGEN,"+
                      "PLAN,"+
                      "NRO_TARJETA,"+
                      "CUOTA,"+
                      "MONEDA,"+
                      "COMERCIO,"+
                      "IMPORTE,"+
                      "NRO_CUPON,"+
                      "ACTIVO,"+
                      "TIPO_TARJETA,"+
                      "CONCILIADO,"+
                      "FEC_CONCILIADO,TARJETA"+
                      ",PRECONCI,FEC_PRECONCI,OID_USU_PRECONCI,NRO_CONCILIACION,MARCAR_PRECONCI,OID_CAB_CONCI_AUT,PRECONCI_DUDOSO,NOM_ARCHIVO,ALTA_MANUAL)"+
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TAR_INFO_DET,pers.getOID());
    if (pers.getTar_info_cab()!=null)
    	qInsert.setInt(OID_TAR_INFO_CAB,pers.getTar_info_cab().getOID());
    else
    	qInsert.setNull(OID_TAR_INFO_CAB,Types.INTEGER);
    qInsert.setString(TIPO_OPERACION,pers.getTipo_operacion());
    if (pers.getFec_present()!=null)
    	qInsert.setDate(FEC_PRESENT,new java.sql.Date(pers.getFec_present().getTime()));
    else
    	qInsert.setNull(FEC_PRESENT,Types.DATE);
    if (pers.getLote()!=null)
    	qInsert.setInt(LOTE,pers.getLote().intValue());
    else
    	qInsert.setNull(LOTE,Types.INTEGER);
    if (pers.getFec_pago()!=null)
    	qInsert.setDate(FEC_PAGO,new java.sql.Date(pers.getFec_pago().getTime()));
    else
    	qInsert.setNull(FEC_PAGO,Types.DATE);
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    if (pers.getNro_comprobante()!=null)
    	qInsert.setInt(NRO_COMPROBANTE,pers.getNro_comprobante().intValue());
    else
    	qInsert.setNull(NRO_COMPROBANTE,Types.INTEGER);
    if (pers.getFec_origen()!=null)
    	qInsert.setDate(FEC_ORIGEN,new java.sql.Date(pers.getFec_origen().getTime()));
    else
    	qInsert.setNull(FEC_ORIGEN,Types.DATE);
    qInsert.setString(PLAN,pers.getPlan());
    if (pers.getNro_tarjeta()!=null)
    	qInsert.setInt(NRO_TARJETA,pers.getNro_tarjeta().intValue());
    else
    	qInsert.setNull(NRO_TARJETA,Types.INTEGER);
    qInsert.setString(CUOTA,pers.getCuota());
    qInsert.setString(MONEDA,pers.getMoneda());
    qInsert.setString(COMERCIO,pers.getComercio());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    if (pers.getNro_cupon()!=null)
    	qInsert.setInt(NRO_CUPON,pers.getNro_cupon().intValue());
    else
    	qInsert.setNull(NRO_CUPON,Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(TIPO_TARJETA, pers.getTipoTarjeta());
    qInsert.setBoolean(CONCILIADO, pers.isConciliado());
    qInsert.setString(TARJETA, pers.getTarjeta());
    if (pers.getFecConciliado()!=null)
    	qInsert.setDate(FEC_CONCILIADO, new java.sql.Date(pers.getFecConciliado().getTime()));
    else
    	qInsert.setNull(FEC_CONCILIADO, Types.DATE);    
    if (pers.isPreConciliado()!=null)
    	qInsert.setBoolean(PRECONCI, pers.isPreConciliado());
    else
    	qInsert.setBoolean(PRECONCI, false);
    if (pers.getFecPreconci()!=null)
    	qInsert.setDate(FEC_PRECONCI, new java.sql.Date(pers.getFecPreconci().getTime()));
    else
    	qInsert.setNull(FEC_PRECONCI, Types.DATE);
    qInsert.setInt(OID_USU_PRECONCI, this.getSesion().getLogin().getUsuario().getOID());
    if (pers.getNroConciliacion()!=null)
    	qInsert.setInt(NRO_CONCILIACION, pers.getNroConciliacion().intValue());
    else
    	qInsert.setInt(NRO_CONCILIACION, 0);
    if (pers.isMarcarPreconci()!=null)
    	qInsert.setBoolean(MARCAR_PRECONCI, pers.isMarcarPreconci().booleanValue());
    else
    	qInsert.setBoolean(MARCAR_PRECONCI, false);
	if (pers.getCabConciAut() != null)
		qInsert.setInt(OID_CAB_CONCI_AUT, pers.getCabConciAut().getOID());
	else
		qInsert.setNull(OID_CAB_CONCI_AUT, Types.INTEGER);    	
	if (pers.isPreconciDudoso() != null)
		qInsert.setBoolean(PRECONCI_DUDOSO, pers.isPreconciDudoso().booleanValue());
	else
		qInsert.setBoolean(PRECONCI_DUDOSO, false);
	qInsert.setString(NOM_ARCHIVO, pers.getNomArchivo());
	qInsert.setBoolean(ALTA_MANUAL, pers.isAltaManual().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TAR_INFO_CAB = 1;
    final int TIPO_OPERACION = 2;
    final int FEC_PRESENT = 3;
    final int LOTE = 4;
    final int FEC_PAGO = 5;
    final int DESCRIPCION = 6;
    final int OID_EMPRESA = 7;
    final int NRO_COMPROBANTE = 8;
    final int FEC_ORIGEN = 9;
    final int PLAN = 10;
    final int NRO_TARJETA = 11;
    final int CUOTA = 12;
    final int MONEDA = 13;
    final int COMERCIO = 14;
    final int IMPORTE = 15;
    final int NRO_CUPON = 16;
    final int ACTIVO = 17;
    final int TIPO_TARJETA = 18;
    final int CONCILIADO = 19;
    final int FEC_CONCILIADO = 20;
    final int TARJETA = 21;
    final int PRECONCI = 22;
    final int FEC_PRECONCI = 23;
    final int OID_USU_PRECONCI = 24;    
    final int NRO_CONCILIACION = 25;
    final int MARCAR_PRECONCI = 26;
    final int OID_CAB_CONCI_AUT = 27;
    final int PRECONCI_DUDOSO = 28;
    final int NOM_ARCHIVO = 29;
    final int OID_USU_MAR_PRE = 30;
    final int ALTA_MANUAL = 31;
    final int OID_TAR_INFO_DET = 32;

    DetTarConciEnt pers = (DetTarConciEnt) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarInfPorEntDet set "+
              "oid_tar_info_cab=?"+ 
              ",tipo_operacion=?"+ 
              ",fec_present=?"+ 
              ",lote=?"+ 
              ",fec_pago=?"+ 
              ",descripcion=?"+ 
              ",oid_empresa=?"+ 
              ",nro_comprobante=?"+ 
              ",fec_origen=?"+ 
              ",plan=?"+ 
              ",nro_tarjeta=?"+ 
              ",cuota=?"+ 
              ",moneda=?"+ 
              ",comercio=?"+ 
              ",importe=?"+ 
              ",nro_cupon=?"+ 
              ",activo=?"+ 
              ",tipo_tarjeta=?"+
              ",conciliado=?"+
              ",fec_conciliado=?"+
              ",tarjeta=?"+
              ",preconci=?"+
              ",fec_preconci=?"+
              ",oid_usu_preconci=?"+
              ",nro_conciliacion=?"+
              ",marcar_preconci=?"+
              ",oid_cab_conci_aut=? "+
              ",preconci_dudoso=? "+
              ",nom_archivo=? "+
              ",oid_usu_mar_pre=?"+
              ",alta_manual=?"+
                 " where " +
                 " oid_tar_info_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_INFO_DET,pers.getOID());
    if (pers.getTar_info_cab()!=null)
    	qUpdate.setInt(OID_TAR_INFO_CAB,pers.getTar_info_cab().getOID());
    else
    	qUpdate.setNull(OID_TAR_INFO_CAB,Types.INTEGER);
    qUpdate.setString(TIPO_OPERACION,pers.getTipo_operacion());
    if (pers.getFec_present()!=null)
    	qUpdate.setDate(FEC_PRESENT,new java.sql.Date(pers.getFec_present().getTime()));
    else
    	qUpdate.setNull(FEC_PRESENT,Types.DATE);
    if (pers.getLote()!=null)
    	qUpdate.setInt(LOTE,pers.getLote().intValue());
    else
    	qUpdate.setNull(LOTE,Types.INTEGER);
    if (pers.getFec_pago()!=null)
    	qUpdate.setDate(FEC_PAGO,new java.sql.Date(pers.getFec_pago().getTime()));
    else
    	qUpdate.setNull(FEC_PAGO,Types.DATE);
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    if (pers.getNro_comprobante()!=null)
    	qUpdate.setInt(NRO_COMPROBANTE,pers.getNro_comprobante().intValue());
    else
    	qUpdate.setNull(NRO_COMPROBANTE,Types.INTEGER);
    if (pers.getFec_origen()!=null)
    	qUpdate.setDate(FEC_ORIGEN,new java.sql.Date(pers.getFec_origen().getTime()));
    else
    	qUpdate.setNull(FEC_ORIGEN,Types.DATE);
    qUpdate.setString(PLAN,pers.getPlan());
    if (pers.getNro_tarjeta()!=null)
    	qUpdate.setInt(NRO_TARJETA,pers.getNro_tarjeta().intValue());
    else
    	qUpdate.setNull(NRO_TARJETA,Types.INTEGER);
    qUpdate.setString(CUOTA,pers.getCuota());
    qUpdate.setString(MONEDA,pers.getMoneda());
    qUpdate.setString(COMERCIO,pers.getComercio());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    if (pers.getNro_cupon()!=null)
    	qUpdate.setInt(NRO_CUPON,pers.getNro_cupon().intValue());
    else
    	qUpdate.setNull(NRO_CUPON,Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(TIPO_TARJETA, pers.getTipoTarjeta());
    qUpdate.setBoolean(CONCILIADO, pers.isConciliado());
    if (pers.getFecConciliado()!=null)
    	qUpdate.setDate(FEC_CONCILIADO, new java.sql.Date(pers.getFecConciliado().getTime()));
    else
    	qUpdate.setNull(FEC_CONCILIADO, Types.DATE);
    qUpdate.setString(TARJETA, pers.getTarjeta());
    if (pers.isPreConciliado()!=null)
    	qUpdate.setBoolean(PRECONCI, pers.isPreConciliado());
    else
    	qUpdate.setBoolean(PRECONCI, false);
    if (pers.getFecPreconci()!=null)
    	qUpdate.setDate(FEC_PRECONCI, new java.sql.Date(pers.getFecPreconci().getTime()));
    else
    	qUpdate.setNull(FEC_PRECONCI, Types.DATE);
    qUpdate.setInt(OID_USU_PRECONCI, this.getSesion().getLogin().getUsuario().getOID());
    if (pers.getNroConciliacion()!=null)
    	qUpdate.setInt(NRO_CONCILIACION, pers.getNroConciliacion().intValue());
    else
    	qUpdate.setInt(NRO_CONCILIACION, 0);    
    if (pers.isMarcarPreconci()!=null)
    	qUpdate.setBoolean(MARCAR_PRECONCI, pers.isMarcarPreconci().booleanValue());
    else
    	qUpdate.setBoolean(MARCAR_PRECONCI, false);    
    if (pers.getUsuarioMarcaPreconci()!=null)
    	qUpdate.setInt(OID_USU_MAR_PRE, pers.getUsuarioMarcaPreconci().getOID());
    else
    	qUpdate.setNull(OID_USU_MAR_PRE, Types.INTEGER);       
	if (pers.getCabConciAut() != null)
		qUpdate.setInt(OID_CAB_CONCI_AUT, pers.getCabConciAut().getOID());
	else
		qUpdate.setNull(OID_CAB_CONCI_AUT, Types.INTEGER);
	if (pers.isPreconciDudoso() != null)
		qUpdate.setBoolean(PRECONCI_DUDOSO, pers.isPreconciDudoso().booleanValue());
	else
		qUpdate.setBoolean(PRECONCI_DUDOSO, false);	
	qUpdate.setString(NOM_ARCHIVO, pers.getNomArchivo());
	qUpdate.setBoolean(ALTA_MANUAL, pers.isAltaManual().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TAR_INFO_DET = 1; 
    DetTarConciEnt pers = (DetTarConciEnt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarInfPorEntDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tar_info_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_INFO_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TAR_INFO_DET = 1; 
    DetTarConciEnt pers = (DetTarConciEnt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarInfPorEntDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tar_info_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_INFO_DET, pers.getOID()); 
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
      case SELECT_BY_CABECERA: {
          ps = this.selectByCabecera(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_EMP_PEND_CONCI: {
          ps = this.selectByEmpPendConci(aCondiciones); 
          break;    	  
      }
      case MARCAR_COMO_PRECONCI: {
          ps = this.marcarComoPreconci(aCondiciones); 
          break;    	  
      }
      case MARCAR_COMO_NO_PRECONCI: {
          ps = this.marcarComoNoPreconci(aCondiciones); 
          break;    	  
      }   
      case SELECT_BY_MARCADO_PRECONCI_EMP_USU: {
          ps = this.selectByMarcadoPreConciEmpUsu(aCondiciones); 
          break;    	      	  
      }
      case GENERAR_PRECONCILIACION: {
          ps = this.generarPreconciliacion(aCondiciones); 
          break;    	  
      }
      case MARCAR_COMO_CONCILIADO: {
          ps = this.marcarComoConciliado(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_PRECONCI_BY_NRO: {
          ps = this.selectByPreconciByNro(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_PEND_PRECONCI_TARJ: {
          ps = this.selectByPendPreconciTarj(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_EMPRESA_NRO_CONCI: {
          ps = this.selectByEmpyNroConci(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_EMPRESA_CONCI_AUT: {
          ps = this.selectByEmpyConciAut(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  }
  
  private PreparedStatement selectByEmpyConciAut(Object aCondiciones) throws BaseException, SQLException {
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EmpresaConciTar empresa 				= (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    CabConciAutomatica cabConciAutomatica 	= (CabConciAutomatica) condiciones.get(CabConciAutomatica.NICKNAME);
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append(" SELECT * FROM  cTarInfPorEntDet "); 
	    textSQL.append(" WHERE activo = 1 and oid_empresa="+empresa.getOIDInteger()+" and oid_cab_conci_aut=? and preconci=1 "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1, cabConciAutomatica.getOID());
	    return querySelect; 
  }  
  
  private PreparedStatement selectByEmpyNroConci(Object aCondiciones) throws BaseException, SQLException {
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    Integer nroConciliacion = (Integer) condiciones.get("NRO_CONCILIACION");
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append(" SELECT * FROM  cTarInfPorEntDet "); 
	    textSQL.append(" WHERE activo = 1 and oid_empresa="+empresa.getOIDInteger()+" and nro_conciliacion=? and preconci=1 "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1, nroConciliacion.intValue());
	    return querySelect; 
  }  
  
  
  
  private PreparedStatement selectByPendPreconciTarj(Object aCondiciones) throws BaseException, SQLException {
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    String tarjeta = (String) condiciones.get("TARJETA");
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append(" SELECT * FROM  cTarInfPorEntDet "); 
	    textSQL.append(" WHERE activo = 1 and preconci = 0 and oid_empresa="+empresa.getOIDInteger()+" and tarjeta=? order by fec_origen "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setString(1, tarjeta);
	    return querySelect; 
  }  
  
  

  private PreparedStatement selectByPreconciByNro(Object aCondiciones) throws BaseException, SQLException {
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    Integer nroConciliacion = (Integer) condiciones.get("NRO_CONCILIACION");
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarInfPorEntDet "); 
	    textSQL.append(" WHERE activo = 1 and preconci = 1 and oid_empresa="+empresa.getOIDInteger()+" and conciliado = 0 and nro_conciliacion ="+nroConciliacion.toString()); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByMarcadoPreConciEmpUsu(Object aCondiciones) throws BaseException, SQLException {
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarInfPorEntDet "); 
	    textSQL.append(" WHERE activo = 1 and marcar_preconci = 1 and preconci=0 "); 
	    textSQL.append(" and oid_empresa="+empresa.getOIDInteger()+" ");
	    if (usuario!=null)
	    	textSQL.append(" and oid_usu_mar_pre="+usuario.getOIDInteger());
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TAR_INFO_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarInfPorEntDet "); 
    textSQL.append(" WHERE oid_tar_info_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TAR_INFO_DET, oid); 
    return querySelect; 
  }

  private PreparedStatement marcarComoPreconci(Object aCondiciones) throws BaseException, SQLException {
	  	
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("update cTarInfPorEntDet set marcar_preconci=1 , oid_usu_mar_pre="+this.getSesion().getLogin().getUsuario().getOID()+" "); 
	    textSQL.append(" WHERE oid_tar_info_det=? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    DetTarConciEnt detTarConciEnt = (DetTarConciEnt) aCondiciones; 
	    querySelect.setInt(1, detTarConciEnt.getOID()); 
	    querySelect.executeUpdate();
	    querySelect.close();
		return null;	    
  }  
  
  private PreparedStatement marcarComoNoPreconci(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("update cTarInfPorEntDet set marcar_preconci=0 , oid_usu_mar_pre="+this.getSesion().getLogin().getUsuario().getOID()+" ");
	    textSQL.append(" WHERE oid_tar_info_det=? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    DetTarConciEnt detTarConciEnt = (DetTarConciEnt) aCondiciones; 
	    querySelect.setInt(1, detTarConciEnt.getOID());
	    querySelect.executeUpdate();
	    querySelect.close();
	    return null; 
}   
  
  
  private PreparedStatement selectByEmpPendConci(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarInfPorEntDet "); 
	    textSQL.append(" WHERE oid_empresa = ? and preconci=0 and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EmpresaConciTar empresa = (EmpresaConciTar) aCondiciones; 
	    querySelect.setInt(1, empresa.getOID()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectByCabecera(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarInfPorEntDet "); 
	    textSQL.append(" WHERE oid_tar_info_cab = ? and activo=1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CabTarConciEnt cabecera = (CabTarConciEnt) aCondiciones; 
	    querySelect.setInt(1, cabecera.getOID()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarInfPorEntDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tar_info_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cTarInfPorEntDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetalles(CabTarConciEnt cabecera,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME,
             DBDetTarConciEnt.SELECT_BY_CABECERA,
             cabecera,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getDetEmpPendConci(EmpresaConciTar empresa,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME,
             DBDetTarConciEnt.SELECT_BY_EMP_PEND_CONCI,
             empresa,
             new ListObserver(),
             aSesion);
  }
  
	public static void marcarComoPreconci(
			   DetTarConciEnt detTarConciEnt,	
			   ISesion aSesion)
		throws BaseException {
	  	ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME,
				DBDetTarConciEnt.MARCAR_COMO_PRECONCI,
				detTarConciEnt,
				null,
				aSesion);		
	}	
	
	public static void marcarComoNoPreconci(
			   DetTarConciEnt detTarConciEnt,	
			   ISesion aSesion)
		throws BaseException {
	  	ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME,
				DBDetTarConciEnt.MARCAR_COMO_NO_PRECONCI,
				detTarConciEnt,
				null,
				aSesion);		
	}
	
	public static List getMarcadosPorEmpresaUsu(EmpresaConciTar empresa, Usuario usuario, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put(Usuario.NICKNAME, usuario);
		return (List) ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME, 
				DBDetTarConciEnt.SELECT_BY_MARCADO_PRECONCI_EMP_USU, 
				condiciones,
				new ListObserver(), aSesion);
	}
	
	private PreparedStatement generarPreconciliacion(Object aCondiciones) throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		DetTarConciEnt detTarConciEnt = (DetTarConciEnt) condiciones.get(DetTarConciEnt.NICKNAME);
		Integer nroConciliacion = (Integer) condiciones.get("NRO_CONCILIACION");
		Boolean dudoso = (Boolean) condiciones.get("DUDOSO");
		
		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" update cTarInfPorEntDet ");
		textSQL.append(" 	set preconci = 1 , ");
		textSQL.append(" 	oid_usu_preconci="+this.getSesion().getLogin().getUsuario().getOID()+",");
		textSQL.append(" 	fec_preconci=?,");
		if (dudoso)
			textSQL.append(" 	preconci_dudoso=1,");
		else
			textSQL.append(" 	preconci_dudoso=0,");
		textSQL.append("    nro_conciliacion="+nroConciliacion);
		
		if (condiciones.containsKey(CabConciAutomatica.NICKNAME)) {
			CabConciAutomatica cabConciAut = (CabConciAutomatica) condiciones.get(CabConciAutomatica.NICKNAME);
			textSQL.append("  , oid_cab_conci_aut="+cabConciAut.getOIDInteger()+" ");
		}
		
		textSQL.append(" where ");
		textSQL.append("  oid_tar_info_det="+detTarConciEnt.getOIDInteger());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1, new java.sql.Date(UtilCIP.getFechaHoraActual(this.getSesion()).getTime()));
		querySelect.executeUpdate();
		querySelect.close();		
		return null;
	}	
	
	public static void generarPreconciliacion(DetTarConciEnt detTarConciEnt, Integer nroConciliacion, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(DetTarConciEnt.NICKNAME, detTarConciEnt);
		condiciones.put("NRO_CONCILIACION", nroConciliacion);
		ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME, 
								DBDetTarConciEnt.GENERAR_PRECONCILIACION, 
								condiciones, 
								null, 
								aSesion);
	}
	
	private PreparedStatement marcarComoConciliado(Object aCondiciones) throws BaseException, SQLException {

		DetTarConciEnt detTarConciEnt = (DetTarConciEnt) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarInfPorEntDet " + " set conciliado=1 , fec_conciliado = ? " + " where " + " oid_tar_info_det="+detTarConciEnt.getOIDInteger());
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setDate(1, new java.sql.Date(UtilCIP.getFechaHoraActual(this.getSesion()).getTime()));
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}	
	
	public static void marcarComoConciliado(DetTarConciEnt detTarConciEnt, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME, DBDetTarConciEnt.MARCAR_COMO_CONCILIADO, detTarConciEnt, null, aSesion);
	}
	
	public static List getPreconciliadosByNro(
			EmpresaConciTar empresa, Integer nroConciliacion, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("NRO_CONCILIACION", nroConciliacion);
		return (List) ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME, 
				DBDetTarConciEnt.SELECT_BY_PRECONCI_BY_NRO, 
				condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getTarjPendPreconci(
			EmpresaConciTar empresa, 
			String tarjeta, 
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("TARJETA", tarjeta);
		return (List) ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME, 
				DBDetTarConciEnt.SELECT_BY_PEND_PRECONCI_TARJ, 
				condiciones,
				new ListObserver(), aSesion);
	}	
	
	public static List getTarjConciliadas(
			EmpresaConciTar empresa, 
			Integer nroConciliacion, 
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("NRO_CONCILIACION", nroConciliacion);
		return (List) ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME, 
				DBDetTarConciEnt.SELECT_BY_EMPRESA_NRO_CONCI, 
				condiciones,
				new ListObserver(), aSesion);
	}	
	
	public static List getTarjConciliadasAutomaticamente(
			EmpresaConciTar empresa, 
			CabConciAutomatica cabConciAutomatica, 
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put(CabConciAutomatica.NICKNAME, cabConciAutomatica);
		return (List) ObjetoLogico.getObjects(
				DetTarConciEnt.NICKNAME, 
				DBDetTarConciEnt.SELECT_BY_EMPRESA_CONCI_AUT, 
				condiciones,
				new ListObserver(), aSesion);
	}	
	
  
} 
