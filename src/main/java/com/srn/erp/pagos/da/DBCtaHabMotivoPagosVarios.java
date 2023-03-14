package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.pagos.bm.CtaHabMotivoPagosVarios;
import com.srn.erp.pagos.bm.MotivoPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCtaHabMotivoPagosVarios extends DBObjetoPersistente {

  public static final String OID_CTA_HAB = "oid_cta_hab";
  public static final String OID_MOTIVO_PAGO = "oid_motivo_pago";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_MOTIVO_PAGO = 100;
  public static final int SELECT_BY_MOTIVO_CTA = 101;

  public DBCtaHabMotivoPagosVarios() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CTA_HAB = 1;
    final int OID_MOTIVO_PAGO = 2;
    final int OID_ANA_CON = 3;
    final int ACTIVO = 4;

    CtaHabMotivoPagosVarios pers = (CtaHabMotivoPagosVarios) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opCtasHabMotPagVar "+
                     " ( "+
                      "OID_CTA_HAB,"+
                      "OID_MOTIVO_PAGO,"+
                      "OID_ANA_CON,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CTA_HAB,pers.getOID());
    qInsert.setInt(OID_MOTIVO_PAGO,pers.getMotivo_pago().getOID());
    qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOTIVO_PAGO = 1;
    final int OID_ANA_CON = 2;
    final int ACTIVO = 3;
    final int OID_CTA_HAB = 4;

    CtaHabMotivoPagosVarios pers = (CtaHabMotivoPagosVarios) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opCtasHabMotPagVar set "+
              "oid_motivo_pago=?"+ 
              ",oid_ana_con=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_cta_hab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_HAB,pers.getOID());
    qUpdate.setInt(OID_MOTIVO_PAGO,pers.getMotivo_pago().getOID());
    qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_HAB = 1; 
    CtaHabMotivoPagosVarios pers = (CtaHabMotivoPagosVarios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from opCtasHabMotPagVar "+
                     " where " + 
                     " oid_cta_hab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_HAB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_HAB = 1; 
    CtaHabMotivoPagosVarios pers = (CtaHabMotivoPagosVarios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opCtasHabMotPagVar "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cta_hab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_HAB, pers.getOID()); 
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
      case SELECT_BY_MOTIVO_PAGO: {
          ps = this.selectByMotivoPago(aCondiciones); 
          break; 
      }
      case SELECT_BY_MOTIVO_CTA: {
          ps = this.selectByMotivoCta(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CTA_HAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opCtasHabMotPagVar "); 
    textSQL.append(" WHERE oid_cta_hab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CTA_HAB, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByMotivoCta(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  opCtasHabMotPagVar "); 
	    textSQL.append(" WHERE oid_motivo_pago = ? and oid_ana_con = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    MotivoPago motivoPago = (MotivoPago) condiciones.get(MotivoPago.NICKNAME);
	    Cuenta cuenta = (Cuenta) condiciones.get(Cuenta.NICKNAME);
	    
	    querySelect.setInt(1, motivoPago.getOID()); 
	    querySelect.setInt(2, cuenta.getOID());
	    
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByMotivoPago(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  opCtasHabMotPagVar "); 
	    textSQL.append(" WHERE oid_motivo_pago = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    MotivoPago motivoPago = (MotivoPago) aCondiciones; 
	    querySelect.setInt(1, motivoPago.getOID()); 
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opCtasHabMotPagVar "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cta_hab oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opCtasHabMotPagVar");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCtasHabilitadasMotivosPagos(
		  MotivoPago motivoPago,
		  ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CtaHabMotivoPagosVarios.NICKNAME,
             DBCtaHabMotivoPagosVarios.SELECT_BY_MOTIVO_PAGO,
             motivoPago,
             new ListObserver(),
             aSesion);
  }
  
  public static CtaHabMotivoPagosVarios getCtaHabMotPago(
		  MotivoPago motivo,
		  Cuenta cuenta,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(MotivoPago.NICKNAME, motivo);
	  condiciones.put(Cuenta.NICKNAME, cuenta);
	  
	  return (CtaHabMotivoPagosVarios) ObjetoLogico.getObjects(CtaHabMotivoPagosVarios.NICKNAME,
			  				DBCtaHabMotivoPagosVarios.SELECT_BY_MOTIVO_CTA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
