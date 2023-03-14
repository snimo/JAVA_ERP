package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ventas.bm.FacturaElectronicaCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBFacturaElectronicaCab extends DBObjetoPersistente {

  public static final String OID_CCO_FACT = "oid_cco_fact";
  public static final String HOMOLOGADA_FE = "homologada_fe";
  public static final String FECHORA_HOMOLOGADA_FE = "fechora_homologada_fe";
  public static final String USU_HOMOLOGADA_FE = "usu_homologada_fe";
  public static final String CAE_FE = "cae_fe";
  public static final String FEC_VTO_CAE_FE = "fec_vto_cae_fe";
  
  public static final int 		UPDATE_FACT_ELEC = 100;

  public DBFacturaElectronicaCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_FACT = 1;
    final int HOMOLOGADA_FE = 2;
    final int FECHORA_HOMOLOGADA_FE = 3;
    final int USU_HOMOLOGADA_FE = 4;
    final int CAE_FE = 5;
    final int FEC_VTO_CAE_FE = 6;

    FacturaElectronicaCab pers = (FacturaElectronicaCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veFacturasCab "+
                     " ( "+
                      "OID_CCO_FACT,"+
                      "HOMOLOGADA_FE,"+
                      "FECHORA_HOMOLOGADA_FE,"+
                      "USU_HOMOLOGADA_FE,"+
                      "CAE_FE,"+
                      "FEC_VTO_CAE_FE)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CCO_FACT,pers.getOID());
    qInsert.setBoolean(HOMOLOGADA_FE,pers.isHomologada_fe().booleanValue());
    if (pers.getFechora_homologada_fe()!=null) 
      qInsert.setDate(FECHORA_HOMOLOGADA_FE,new Date(pers.getFechora_homologada_fe().getTime()));
    else
      qInsert.setNull(FECHORA_HOMOLOGADA_FE,java.sql.Types.DATE);
    qInsert.setString(USU_HOMOLOGADA_FE,pers.getUsu_homologada_fe());
    qInsert.setString(CAE_FE,pers.getCae_fe());
    if (pers.getFec_vto_cae_fe()!=null) 
      qInsert.setDate(FEC_VTO_CAE_FE,new Date(pers.getFec_vto_cae_fe().getTime()));
    else
      qInsert.setNull(FEC_VTO_CAE_FE,java.sql.Types.DATE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int HOMOLOGADA_FE = 1;
    final int FECHORA_HOMOLOGADA_FE = 2;
    final int USU_HOMOLOGADA_FE = 3;
    final int CAE_FE = 4;
    final int FEC_VTO_CAE_FE = 5;
    final int OID_CCO_FACT = 6;

    FacturaElectronicaCab pers = (FacturaElectronicaCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veFacturasCab set "+
              "homologada_fe=?"+ 
              ",fechora_homologada_fe=?"+ 
              ",usu_homologada_fe=?"+ 
              ",cae_fe=?"+ 
              ",fec_vto_cae_fe=?"+ 
                 " where " +
                 " oid_cco_fact=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_FACT,pers.getOID());
    if (pers.isHomologada_fe()!=null)
    	qUpdate.setBoolean(HOMOLOGADA_FE,pers.isHomologada_fe().booleanValue());
    else
    	qUpdate.setBoolean(HOMOLOGADA_FE, false);
    if (pers.getFechora_homologada_fe()!=null) 
      qUpdate.setDate(FECHORA_HOMOLOGADA_FE,new Date(pers.getFechora_homologada_fe().getTime()));
    else
      qUpdate.setNull(FECHORA_HOMOLOGADA_FE,java.sql.Types.DATE);
    if (pers.getUsu_homologada_fe()!=null)
    	qUpdate.setString(USU_HOMOLOGADA_FE,pers.getUsu_homologada_fe());
    else
    	qUpdate.setNull(USU_HOMOLOGADA_FE,java.sql.Types.VARCHAR);
    
    if (pers.getCae_fe()!=null)
    	qUpdate.setString(CAE_FE,pers.getCae_fe());
    else
    	qUpdate.setNull(CAE_FE,java.sql.Types.VARCHAR);
    
    if (pers.getFec_vto_cae_fe()!=null) 
      qUpdate.setDate(FEC_VTO_CAE_FE,new Date(pers.getFec_vto_cae_fe().getTime()));
    else
      qUpdate.setNull(FEC_VTO_CAE_FE,java.sql.Types.DATE);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_FACT = 1; 
    FacturaElectronicaCab pers = (FacturaElectronicaCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veFacturasCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cco_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_FACT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_FACT = 1; 
    FacturaElectronicaCab pers = (FacturaElectronicaCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veFacturasCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_FACT, pers.getOID()); 
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
      case UPDATE_FACT_ELEC: {
		ps = this.updateFactElectronica(aCondiciones);
		break;
      }

    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CCO_FACT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFacturasCab "); 
    textSQL.append(" WHERE oid_cco_fact = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CCO_FACT, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFacturasCab "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_fact oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veFacturasCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static void actualizarFactElectronica(
			java.util.Date fecha,
			String usuario,
			String cae,
			java.util.Date vto,
			Integer oidCCO,
			ISesion aSesion) throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA", fecha);
		condiciones.put("USUARIO", usuario);
		condiciones.put("CAE", cae);
		condiciones.put("VTO", vto);
		condiciones.put("OID_CCO", oidCCO);

		ObjetoLogico.getObjects(FacturaElectronicaCab.NICKNAME, DBFacturaElectronicaCab.UPDATE_FACT_ELEC, condiciones,
				new ListObserver(), aSesion);
  }

  
  protected PreparedStatement updateFactElectronica(Object aCondiciones) throws BaseException, SQLException {

	  
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecHorHomologada = (java.util.Date) condiciones.get("FECHA");
		String usuario = (String) condiciones.get("USUARIO");
		String cae = (String) condiciones.get("CAE");
		java.util.Date fecVtoCae = (java.util.Date) condiciones.get("VTO");
		Integer oidCCO = (Integer) condiciones.get("OID_CCO");
		
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veFacturasCab set homologada_fe=1 , fechora_homologada_fe = ? , usu_homologada_fe = ? , cae_fe = ? , fec_vto_cae_fe = ?"
				+ "  where " + " oid_cco_fact=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setDate(1, new Date(fecHorHomologada.getTime()));
		qUpdate.setString(2, usuario);
		qUpdate.setString(3, cae);
		qUpdate.setDate(4, new Date(fecVtoCae.getTime()));
		qUpdate.setInt(5, oidCCO);	
		qUpdate.executeUpdate();
		qUpdate.close();
		
		return null;
	}
  
  
} 
