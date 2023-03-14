package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTarjetaConciTar extends DBObjetoPersistente {

  public static final String OID_TAR_CONCI = "oid_tar_conci";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String IDENTIF_TARJ = "identif_tarj";
  public static final String ACTIVO = "activo";
  public static final String CODIGO_POSNET = "codigo_posnet";
  public static final String OID_AGRUPADOR = "oid_agrup_tar";
  public static final String TOT_DIAS_FEC_CONCI = "tol_dias_fec_conci";
  public static final String TOT_DIAS_CONCI_OK = "tol_dias_conc_ok";
  public static final String ACOB_CTA_TARJ = "acob_cta_tarj";
  public static final String ACOB_CTA_TARJ_C1 = "acob_cta_tarj_c1";
  public static final String ACOB_CTA_TARJ_C2 = "acob_cta_tarj_c2";
  public static final String IGNORAR_MOV_POSNET = "ignorar_mov_posnet";
  public static final String LIQUIDACION = "liquidacion";
  public static final String OID_MODELO_LIQ = "oid_modelo_liq";
  
  
  
  public static final int SELECT_BY_CODIGO_POSNET = 100;
  public static final int SELECT_BY_IDENTIF_TARJ = 101;
  
  
  

  public DBTarjetaConciTar() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TAR_CONCI = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int IDENTIF_TARJ = 4;
    final int ACTIVO = 5;
    final int CODIGO_POSNET = 6;
    final int OID_AGRUPADOR = 7;
    final int TOT_DIAS_FEC_CONCI = 8;
    final int TOL_DIAS_CONCI_OK = 9;
    final int ACOB_CTA_TARJ = 10;
    final int ACOB_CTA_TARJ_C1 = 11;
    final int ACOB_CTA_TARJ_C2 = 12;
    final int IGNORAR_MOV_POSNET = 13;
    final int LIQUIDACION = 14;
    final int OID_MODELO_LIQ = 15;
    

    TarjetaConciTar pers = (TarjetaConciTar) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarTarjConci "+
                     " ( "+
                      "OID_TAR_CONCI,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "IDENTIF_TARJ,"+
                      "ACTIVO,CODIGO_POSNET,OID_AGRUP_TAR,TOL_DIAS_FEC_CONCI,tol_dias_conc_ok,acob_cta_tarj,acob_cta_tarj_c1,acob_cta_tarj_c2,ignorar_mov_posnet,liquidacion,oid_modelo_liq) "+ 
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
    qInsert.setInt(OID_TAR_CONCI,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(IDENTIF_TARJ,pers.getIdentif_tarj());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(CODIGO_POSNET,pers.getCodigoPosnet());
    qInsert.setInt(OID_AGRUPADOR, pers.getAgrupador().getOIDInteger());
    if (pers.getToleranciaDiasFecConci()!=null)
    	qInsert.setInt(TOT_DIAS_FEC_CONCI, pers.getToleranciaDiasFecConci());
    else
    	qInsert.setInt(TOT_DIAS_FEC_CONCI, 0);
    if (pers.getTolDiasConciOK()!=null)
    	qInsert.setInt(TOL_DIAS_CONCI_OK, pers.getTolDiasConciOK());
    else
    	qInsert.setInt(TOL_DIAS_CONCI_OK, 0);
    
    if (pers.getCtaTarjetaACobrar()!=null)
    	qInsert.setString(ACOB_CTA_TARJ, pers.getCtaTarjetaACobrar());
    else
    	qInsert.setNull(ACOB_CTA_TARJ, Types.VARCHAR);
    
    if (pers.getCtaTarjetaACobrarC1()!=null)
    	qInsert.setString(ACOB_CTA_TARJ_C1, pers.getCtaTarjetaACobrarC1());
    else
    	qInsert.setNull(ACOB_CTA_TARJ_C1, Types.VARCHAR);
    
    if (pers.getCtaTarjetaACobrarC2()!=null)
    	qInsert.setString(ACOB_CTA_TARJ_C2, pers.getCtaTarjetaACobrarC2());
    else
    	qInsert.setNull(ACOB_CTA_TARJ_C2, Types.VARCHAR);
    
    if (pers.isIgnorarMovPOSNET()!=null)
    	qInsert.setBoolean(IGNORAR_MOV_POSNET, pers.isIgnorarMovPOSNET().booleanValue());
    else
    	qInsert.setBoolean(IGNORAR_MOV_POSNET, false);
    if (pers.getLiquidacion()!=null)
    	qInsert.setString(LIQUIDACION, pers.getLiquidacion());
    else
    	qInsert.setNull(LIQUIDACION, Types.VARCHAR);    
    
    if (pers.getCabModeloLiq()!=null)
    	qInsert.setInt(OID_MODELO_LIQ, pers.getCabModeloLiq().getOID());
    else
    	qInsert.setNull(OID_MODELO_LIQ, Types.INTEGER);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int IDENTIF_TARJ = 3;
    final int ACTIVO = 4;
    final int CODIGO_POSNET = 5;
    final int OID_AGRUPADOR = 6;
    final int TOT_DIAS_FEC_CONCI = 7;
    final int TOL_DIAS_CONCI_OK = 8;
    final int ACOB_CTA_TARJ = 9;
    final int ACOB_CTA_TARJ_C1 = 10;
    final int ACOB_CTA_TARJ_C2 = 11;  
    final int IGNORAR_MOV_POSNET = 12;
    final int LIQUIDACION = 13;
    final int OID_MODELO_LIQ = 14;
    final int OID_TAR_CONCI = 15;

    TarjetaConciTar pers = (TarjetaConciTar) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarTarjConci set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",identif_tarj=?"+ 
              ",activo=?"+
              ",codigo_posnet=?"+
              ",oid_agrup_tar=?"+
              ",tol_dias_fec_conci=?"+
              ",tol_dias_conc_ok=? "+
              ",acob_cta_tarj=? "+
              ",acob_cta_tarj_c1=? "+
              ",acob_cta_tarj_c2=? "+
              ",ignorar_mov_posnet=? "+
              ",liquidacion=? "+
              ",oid_modelo_liq=? "+
                 " where " +
                 " oid_tar_conci=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_CONCI,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(IDENTIF_TARJ,pers.getIdentif_tarj());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(CODIGO_POSNET,pers.getCodigoPosnet());
    qUpdate.setInt(OID_AGRUPADOR, pers.getAgrupador().getOIDInteger());
    if (pers.getToleranciaDiasFecConci()!=null)
    	qUpdate.setInt(TOT_DIAS_FEC_CONCI, pers.getToleranciaDiasFecConci());
    else
    	qUpdate.setInt(TOT_DIAS_FEC_CONCI, 0);
    if (pers.getTolDiasConciOK()!=null)
    	qUpdate.setInt(TOL_DIAS_CONCI_OK, pers.getTolDiasConciOK());
    else
    	qUpdate.setInt(TOL_DIAS_CONCI_OK, 0);
        
    if (pers.getCtaTarjetaACobrar()!=null)
    	qUpdate.setString(ACOB_CTA_TARJ, pers.getCtaTarjetaACobrar());
    else
    	qUpdate.setNull(ACOB_CTA_TARJ, Types.VARCHAR);
    
    if (pers.getCtaTarjetaACobrarC1()!=null)
    	qUpdate.setString(ACOB_CTA_TARJ_C1, pers.getCtaTarjetaACobrarC1());
    else
    	qUpdate.setNull(ACOB_CTA_TARJ_C1, Types.VARCHAR);
    
    if (pers.getCtaTarjetaACobrarC2()!=null)
    	qUpdate.setString(ACOB_CTA_TARJ_C2, pers.getCtaTarjetaACobrarC2());
    else
    	qUpdate.setNull(ACOB_CTA_TARJ_C2, Types.VARCHAR);
    
    if (pers.isIgnorarMovPOSNET()!=null)
    	qUpdate.setBoolean(IGNORAR_MOV_POSNET, pers.isIgnorarMovPOSNET().booleanValue());
    else
    	qUpdate.setBoolean(IGNORAR_MOV_POSNET, false);
    if (pers.getLiquidacion()!=null)
    	qUpdate.setString(LIQUIDACION, pers.getLiquidacion());
    else
    	qUpdate.setNull(LIQUIDACION, Types.VARCHAR);    
    
    if (pers.getCabModeloLiq()!=null)
    	qUpdate.setInt(OID_MODELO_LIQ, pers.getCabModeloLiq().getOID());
    else
    	qUpdate.setNull(OID_MODELO_LIQ, Types.INTEGER);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TAR_CONCI = 1; 
    TarjetaConciTar pers = (TarjetaConciTar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarTarjConci "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tar_conci=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_CONCI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TAR_CONCI = 1; 
    TarjetaConciTar pers = (TarjetaConciTar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarTarjConci "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tar_conci=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_CONCI, pers.getOID()); 
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
      case SELECT_BY_CODIGO_POSNET: {
          ps = this.selectByCodigoPOSNET(aCondiciones); 
          break;    	  
      }
      case SELECT_ALL_ACTIVOS_HELP: {
          ps = this.selectAllActivosHelp(aCondiciones); 
          break;    	  
      } 
      case SELECT_BY_IDENTIF_TARJ: {
          ps = this.selectByIdentifTarj(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TAR_CONCI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarTarjConci "); 
    textSQL.append(" WHERE oid_tar_conci = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TAR_CONCI, oid); 
    return querySelect; 
  }

  private PreparedStatement selectAllActivosHelp(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_tar_conci oid,codigo codigo, descripcion descripcion ,activo ");
	    textSQL.append(" from cTarTarjConci where activo=1");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByIdentifTarj(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarTarjConci "); 
	    textSQL.append(" WHERE identif_tarj = ? and activo=1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    String codigo = (String) aCondiciones; 
	    querySelect.setString(1, codigo); 
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByCodigoPOSNET(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarTarjConci "); 
	    textSQL.append(" WHERE codigo_posnet = ? and activo=1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    String codigo = (String) aCondiciones; 
	    querySelect.setString(1, codigo); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarTarjConci "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tar_conci oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cTarTarjConci");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static TarjetaConciTar getTarjetaConciliacion(String codigoPOSNET,
          ISesion aSesion)
          throws BaseException {
	  return (TarjetaConciTar) ObjetoLogico.getObjects(TarjetaConciTar.NICKNAME,
			  				DBTarjetaConciTar.SELECT_BY_CODIGO_POSNET,
			  				codigoPOSNET,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
  public static TarjetaConciTar getTarjetaByIdentif(String identif,
          ISesion aSesion)
          throws BaseException {
	  return (TarjetaConciTar) ObjetoLogico.getObjects(TarjetaConciTar.NICKNAME,
			  				DBTarjetaConciTar.SELECT_BY_IDENTIF_TARJ,
			  				identif,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
} 
