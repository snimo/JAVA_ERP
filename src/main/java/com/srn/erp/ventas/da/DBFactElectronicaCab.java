package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.ventas.bm.FactElectronicaCab;
import com.srn.erp.ventas.bm.FacturaElectronicaCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBFactElectronicaCab extends DBObjetoPersistente {

  public static final String OID_CCO = "oid_cco";
  public static final String OID_TC = "oid_tc";
  public static final String TC_EXT = "tc_ext";
  public static final String LETRA = "letra";
  public static final String NRO_EXT = "nro_ext";
  public static final String LUG_EMI = "lug_emi";
  public static final String FEC_HOMOLOGADA = "fec_homologada";
  public static final String USU_HOMOLOGO = "usu_homologo";
  public static final String HOMOLOGADO_OK = "homologado_ok";
  public static final String OID_CCO_ASIGNADO_A = "oid_cco_asignado_a";
  public static final String CAE = "cae";
  public static final String VTO_CAE = "vto_cae";
  public static final String RESPUESTA_WS_HOMO = "respuesta_ws_homo";
  public static final String CUIT_EMPRESA = "cuit_empresa";
  public static final String TC_FE = "tc_fe";
  public static final String TIPO_DOCU_FE = "tipo_docu_fe";
  public static final String NRO_DOCU_FE = "nro_docu_fe";
  public static final String FEC_FE = "fec_fe";
  public static final String IMP_TOTAL_FE = "imp_total_fe";
  public static final String IMP_NETO_FE = "imp_neto_fe";
  public static final String IMP_IVA_FE = "imp_iva_fe";
  
  public static final int 		UPDATE_FACT_ASIGNADA_A = 100;

  public DBFactElectronicaCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO = 1;
    final int OID_TC = 2;
    final int TC_EXT = 3;
    final int LETRA = 4;
    final int NRO_EXT = 5;
    final int LUG_EMI = 6;
    final int FEC_HOMOLOGADA = 7;
    final int USU_HOMOLOGO = 8;
    final int HOMOLOGADO_OK = 9;
    final int OID_CCO_ASIGNADO_A = 10;
    final int CAE = 11;
    final int VTO_CAE = 12;
    final int RESPUESTA_WS_HOMO = 13;
    final int CUIT_EMPRESA = 14;
    final int TC_FE = 15;
    final int TIPO_DOCU_FE = 16;
    final int NRO_DOCU_FE = 17;
    final int FEC_FE = 18;
    final int IMP_TOTAL_FE = 19;
    final int IMP_NETO_FE = 20;
    final int IMP_IVA_FE = 21;

    FactElectronicaCab pers = (FactElectronicaCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into VEFACTELECTRONICA "+
                     " ( "+
                      "OID_CCO,"+
                      "OID_TC,"+
                      "TC_EXT,"+
                      "LETRA,"+
                      "NRO_EXT,"+
                      "LUG_EMI,"+
                      "FEC_HOMOLOGADA,"+
                      "USU_HOMOLOGO,"+
                      "HOMOLOGADO_OK,"+
                      "OID_CCO_ASIGNADO_A,"+
                      "CAE,"+
                      "VTO_CAE,"+
                      "RESPUESTA_WS_HOMO,"+
                      "CUIT_EMPRESA,"+
                      "TC_FE,"+
                      "TIPO_DOCU_FE,"+
                      "NRO_DOCU_FE,"+
                      "FEC_FE,"+
                      "IMP_TOTAL_FE,"+
                      "IMP_NETO_FE,"+
                      "IMP_IVA_FE)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CCO,pers.getOID());
    qInsert.setInt(OID_TC,pers.getOid_tc().intValue());
    qInsert.setString(TC_EXT,pers.getTc_ext());
    qInsert.setString(LETRA,pers.getLetra());
    qInsert.setInt(NRO_EXT,pers.getNro_ext().intValue());
    qInsert.setInt(LUG_EMI,pers.getLug_emi().intValue());
    qInsert.setDate(FEC_HOMOLOGADA,new java.sql.Date(pers.getFec_homologada().getTime()));
    qInsert.setString(USU_HOMOLOGO,pers.getUsu_homologo());
    qInsert.setBoolean(HOMOLOGADO_OK,pers.isHomologado_ok().booleanValue());
    if (pers.getOid_cco_asignado_a()!=null)
    	qInsert.setInt(OID_CCO_ASIGNADO_A,pers.getOid_cco_asignado_a().intValue());
    else
    	qInsert.setNull(OID_CCO_ASIGNADO_A,Types.INTEGER);
    if (pers.getCae()!=null)
    	qInsert.setString(CAE,pers.getCae());
    else
    	qInsert.setNull(CAE,Types.VARCHAR);
    if (pers.getVto_cae()!=null)
    	qInsert.setDate(VTO_CAE,new java.sql.Date(pers.getVto_cae().getTime()));
    else
    	qInsert.setNull(VTO_CAE,Types.TIMESTAMP);
    if (pers.getRespuesta_ws_homo()==null)
    	qInsert.setNull(RESPUESTA_WS_HOMO,Types.NULL);
    else if ((pers.getRespuesta_ws_homo()!=null) && (pers.getRespuesta_ws_homo().length()>1000))
    		qInsert.setString(RESPUESTA_WS_HOMO,pers.getRespuesta_ws_homo().substring(0,999));
    	 else
    		 qInsert.setString(RESPUESTA_WS_HOMO,pers.getRespuesta_ws_homo()); 
    qInsert.setString(CUIT_EMPRESA,pers.getCuit_empresa());
    qInsert.setInt(TC_FE,pers.getTc_fe().intValue());
    qInsert.setInt(TIPO_DOCU_FE,pers.getTipo_docu_fe().intValue());
    qInsert.setString(NRO_DOCU_FE,pers.getNro_docu_fe());
    qInsert.setDate(FEC_FE,new java.sql.Date(pers.getFec_fe().getTime()));
    if (pers.getImp_total_fe()!=null)
    	qInsert.setDouble(IMP_TOTAL_FE,pers.getImp_total_fe().doubleValue());
    else
    	qInsert.setDouble(IMP_TOTAL_FE,0);
    if (pers.getImp_neto_fe()!=null)
    	qInsert.setDouble(IMP_NETO_FE,pers.getImp_neto_fe().doubleValue());
    else
    	qInsert.setDouble(IMP_NETO_FE,0);
    if (pers.getImp_iva_fe()!=null)
    	qInsert.setDouble(IMP_IVA_FE,pers.getImp_iva_fe().doubleValue());
    else
    	qInsert.setDouble(IMP_IVA_FE,0);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TC = 1;
    final int TC_EXT = 2;
    final int LETRA = 3;
    final int NRO_EXT = 4;
    final int LUG_EMI = 5;
    final int FEC_HOMOLOGADA = 6;
    final int USU_HOMOLOGO = 7;
    final int HOMOLOGADO_OK = 8;
    final int OID_CCO_ASIGNADO_A = 9;
    final int CAE = 10;
    final int VTO_CAE = 11;
    final int RESPUESTA_WS_HOMO = 12;
    final int CUIT_EMPRESA = 13;
    final int TC_FE = 14;
    final int TIPO_DOCU_FE = 15;
    final int NRO_DOCU_FE = 16;
    final int FEC_FE = 17;
    final int IMP_TOTAL_FE = 18;
    final int IMP_NETO_FE = 19;
    final int IMP_IVA_FE = 20;
    final int OID_CCO = 21;

    FactElectronicaCab pers = (FactElectronicaCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update VEFACTELECTRONICA set "+
              "oid_tc=?"+ 
              ",tc_ext=?"+ 
              ",letra=?"+ 
              ",nro_ext=?"+ 
              ",lug_emi=?"+ 
              ",fec_homologada=?"+ 
              ",usu_homologo=?"+ 
              ",homologado_ok=?"+ 
              ",oid_cco_asignado_a=?"+ 
              ",cae=?"+ 
              ",vto_cae=?"+ 
              ",respuesta_ws_homo=?"+ 
              ",cuit_empresa=?"+ 
              ",tc_fe=?"+ 
              ",tipo_docu_fe=?"+ 
              ",nro_docu_fe=?"+ 
              ",fec_fe=?"+ 
              ",imp_total_fe=?"+ 
              ",imp_neto_fe=?"+ 
              ",imp_iva_fe=?"+ 
                 " where " +
                 " oid_cco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO,pers.getOID());
    qUpdate.setInt(OID_TC,pers.getOid_tc().intValue());
    qUpdate.setString(TC_EXT,pers.getTc_ext());
    qUpdate.setString(LETRA,pers.getLetra());
    qUpdate.setInt(NRO_EXT,pers.getNro_ext().intValue());
    qUpdate.setInt(LUG_EMI,pers.getLug_emi().intValue());
    qUpdate.setDate(FEC_HOMOLOGADA,new java.sql.Date(pers.getFec_homologada().getTime()));
    qUpdate.setString(USU_HOMOLOGO,pers.getUsu_homologo());
    qUpdate.setBoolean(HOMOLOGADO_OK,pers.isHomologado_ok().booleanValue());
    if (pers.getOid_cco_asignado_a()!=null)
    	qUpdate.setInt(OID_CCO_ASIGNADO_A,pers.getOid_cco_asignado_a().intValue());
    else
    	qUpdate.setNull(OID_CCO_ASIGNADO_A,Types.INTEGER);
    if (pers.getCae()!=null)
    	qUpdate.setString(CAE,pers.getCae());
    else
    	qUpdate.setNull(CAE,Types.VARCHAR);
    if (pers.getVto_cae()!=null)
    	qUpdate.setDate(VTO_CAE,new java.sql.Date(pers.getVto_cae().getTime()));
    else
    	qUpdate.setNull(VTO_CAE,Types.VARCHAR);
  
    if (pers.getRespuesta_ws_homo()==null)
    	qUpdate.setNull(RESPUESTA_WS_HOMO,Types.NULL);
    else if ((pers.getRespuesta_ws_homo()!=null) && (pers.getRespuesta_ws_homo().length()>255))
    		qUpdate.setString(RESPUESTA_WS_HOMO,pers.getRespuesta_ws_homo().substring(0,254));
    	 else
    		 qUpdate.setString(RESPUESTA_WS_HOMO,pers.getRespuesta_ws_homo()); 
  
    qUpdate.setString(CUIT_EMPRESA,pers.getCuit_empresa());
    qUpdate.setInt(TC_FE,pers.getTc_fe().intValue());
    qUpdate.setInt(TIPO_DOCU_FE,pers.getTipo_docu_fe().intValue());
    qUpdate.setString(NRO_DOCU_FE,pers.getNro_docu_fe());
    qUpdate.setDate(FEC_FE,new java.sql.Date(pers.getFec_fe().getTime()));
    if (pers.getImp_total_fe()!=null)
    	qUpdate.setDouble(IMP_TOTAL_FE,pers.getImp_total_fe().doubleValue());
    else
    	qUpdate.setDouble(IMP_TOTAL_FE,0);
    if (pers.getImp_neto_fe()!=null)
    	qUpdate.setDouble(IMP_NETO_FE,pers.getImp_neto_fe().doubleValue());
    else
    	qUpdate.setDouble(IMP_NETO_FE,0);
    if (pers.getImp_iva_fe()!=null)
    	qUpdate.setDouble(IMP_IVA_FE,pers.getImp_iva_fe().doubleValue());
    else
    	qUpdate.setDouble(IMP_IVA_FE,0);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO = 1; 
    FactElectronicaCab pers = (FactElectronicaCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update VEFACTELECTRONICA "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO = 1; 
    FactElectronicaCab pers = (FactElectronicaCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update VEFACTELECTRONICA "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO, pers.getOID()); 
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
      case UPDATE_FACT_ASIGNADA_A: {
  		ps = this.updateFactElectronica(aCondiciones);
  		break;
        }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CCO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  VEFACTELECTRONICA "); 
    textSQL.append(" WHERE oid_cco = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CCO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  VEFACTELECTRONICA "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from VEFACTELECTRONICA");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static void actualizarFactElectronica(
			Integer oidCCO,
			Integer oidCCOAsig,
			ISesion aSesion) throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("oid_cco", oidCCO);
		condiciones.put("oid_cco_asignado", oidCCOAsig);
			ObjetoLogico.getObjects(FactElectronicaCab.NICKNAME, DBFactElectronicaCab.UPDATE_FACT_ASIGNADA_A, condiciones,
				new ListObserver(), aSesion);
  }

  
  protected PreparedStatement updateFactElectronica(Object aCondiciones) throws BaseException, SQLException {

	  
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oidCCO = (Integer) condiciones.get("oid_cco");
		Integer oidCCOAsignado = (Integer) condiciones.get("oid_cco_asignado");
		
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veFactElectronica set oid_cco_asignado_a=? where oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(1, oidCCOAsignado);
		qUpdate.setInt(2, oidCCO);
		qUpdate.executeUpdate();
		qUpdate.close();
		
		return null;
	}

  
} 
