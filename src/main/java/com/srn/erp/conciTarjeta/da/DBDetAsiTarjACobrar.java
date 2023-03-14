package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.DetAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.DetAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBDetAsiTarjACobrar extends DBObjetoPersistente {

  public static final String OID_DET_ASI_ACOB = "oid_det_asi_acob";
  public static final String ORDEN = "orden";
  public static final String OID_CAB_ASI_ACOB = "oid_cab_asi_acob";
  public static final String CUENTA = "cuenta";
  public static final String COMPO1 = "compo1";
  public static final String COMPO2 = "compo2";
  public static final String DEBE = "debe";
  public static final String HABER = "haber";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ASIENTO = 100;
  public static final int SELECT_BY_CTA_FEC_DES_HAS = 101;
  

  public DBDetAsiTarjACobrar() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DET_ASI_ACOB = 1;
    final int ORDEN = 2;
    final int OID_CAB_ASI_ACOB = 3;
    final int CUENTA = 4;
    final int COMPO1 = 5;
    final int COMPO2 = 6;
    final int DEBE = 7;
    final int HABER = 8;
    final int ACTIVO = 9;

    DetAsiTarjACobrar pers = (DetAsiTarjACobrar) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into CTARDETASIACOB "+
                     " ( "+
                      "OID_DET_ASI_ACOB,"+
                      "ORDEN,"+
                      "OID_CAB_ASI_ACOB,"+
                      "CUENTA,"+
                      "COMPO1,"+
                      "COMPO2,"+
                      "DEBE,"+
                      "HABER,"+
                      "ACTIVO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DET_ASI_ACOB,pers.getOID());
    if (pers.getOrden()!=null)
    	qInsert.setInt(ORDEN,pers.getOrden().intValue());
    else
    	qInsert.setNull(ORDEN,Types.INTEGER);
    qInsert.setInt(OID_CAB_ASI_ACOB,pers.getCab_asi_acob().getOID());
    qInsert.setString(CUENTA,pers.getCuenta());
    if (pers.getCompo1()!=null)
    	qInsert.setString(COMPO1,pers.getCompo1());
    else
    	qInsert.setNull(COMPO1,Types.VARCHAR);
    if (pers.getCompo2()!=null)
    	qInsert.setString(COMPO2,pers.getCompo2());
    else
    	qInsert.setNull(COMPO2,Types.VARCHAR);
    if (pers.getDebe()!=null)
    	qInsert.setDouble(DEBE,pers.getDebe().doubleValue());
    else
    	qInsert.setNull(DEBE,Types.DOUBLE);
    if (pers.getHaber()!=null)
    	qInsert.setDouble(HABER,pers.getHaber().doubleValue());
    else
    	qInsert.setNull(HABER,Types.DOUBLE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int ORDEN = 1;
    final int OID_CAB_ASI_ACOB = 2;
    final int CUENTA = 3;
    final int COMPO1 = 4;
    final int COMPO2 = 5;
    final int DEBE = 6;
    final int HABER = 7;
    final int ACTIVO = 8;
    final int OID_DET_ASI_ACOB = 9;

    DetAsiTarjACobrar pers = (DetAsiTarjACobrar) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update CTARDETASIACOB set "+
              "orden=?"+ 
              ",oid_cab_asi_acob=?"+ 
              ",cuenta=?"+ 
              ",compo1=?"+ 
              ",compo2=?"+ 
              ",debe=?"+ 
              ",haber=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_det_asi_acob=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DET_ASI_ACOB,pers.getOID());
    if (pers.getOrden()!=null)
    	qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    else
    	qUpdate.setNull(ORDEN,Types.INTEGER);
    qUpdate.setInt(OID_CAB_ASI_ACOB,pers.getCab_asi_acob().getOID());
    qUpdate.setString(CUENTA,pers.getCuenta());
    if (pers.getCompo1()!=null)
    	qUpdate.setString(COMPO1,pers.getCompo1());
    else
    	qUpdate.setNull(COMPO1,Types.VARCHAR);
    if (pers.getCompo2()!=null)
    	qUpdate.setString(COMPO2,pers.getCompo2());
    else
    	qUpdate.setNull(COMPO2,Types.VARCHAR);
    if (pers.getDebe()!=null)
    	qUpdate.setDouble(DEBE,pers.getDebe().doubleValue());
    else
    	qUpdate.setNull(DEBE,Types.DOUBLE);
    if (pers.getHaber()!=null)
    	qUpdate.setDouble(HABER,pers.getHaber().doubleValue());
    else
    	qUpdate.setNull(HABER,Types.DOUBLE);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DET_ASI_ACOB = 1; 
    DetAsiTarjACobrar pers = (DetAsiTarjACobrar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update CTARDETASIACOB "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_det_asi_acob=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DET_ASI_ACOB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DET_ASI_ACOB = 1; 
    DetAsiTarjACobrar pers = (DetAsiTarjACobrar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update CTARDETASIACOB "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_det_asi_acob=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DET_ASI_ACOB, pers.getOID()); 
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
      case SELECT_BY_ASIENTO: {
          ps = this.selectByAsiento(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_CTA_FEC_DES_HAS: {
          ps = this.selectByCtaFecDesdeHasta(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DET_ASI_ACOB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  CTARDETASIACOB "); 
    textSQL.append(" WHERE oid_det_asi_acob = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DET_ASI_ACOB, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByAsiento(Object aCondiciones) throws BaseException, SQLException { 
	    CabAsiTarjACobrar cabAsiento = (CabAsiTarjACobrar) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  CTARDETASIACOB "); 
	    textSQL.append(" WHERE oid_cab_asi_acob = ? and activo=1 order by debe ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, cabAsiento.getOID()); 
	    return querySelect; 
	  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  CTARDETASIACOB "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_det_asi_acob oid, codigo,  descripcion ,activo ");
    textSQL.append(" from CTARDETASIACOB");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetallesAsiento(CabAsiTarjACobrar cabAsiento,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DetAsiTarjACobrar.NICKNAME,
             DBDetAsiTarjACobrar.SELECT_BY_ASIENTO,
             cabAsiento,
             new ListObserver(),
             aSesion);
  }
  
	public static double getSaldoAUnaFecha(Object aCondiciones, ISesion aSesion) throws BaseException {

		try {
			HashTableDatos condiciones = (HashTableDatos) aCondiciones;
			String cuenta = (String) condiciones.get("CUENTA");
			java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
			EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
			StringBuffer textSQL = new StringBuffer();
			
			textSQL.append(" select "); 
			textSQL.append("   sum(nvl(debe,0))-sum(nvl(haber,0)) saldo "); 
			textSQL.append(" from "); 
			textSQL.append("   cTarCabAsiAcob a , "); 
			textSQL.append("   cTarDetAsiAcob b "); 
			textSQL.append(" where "); 
			textSQL.append("   a.oid_cab_asi_acob = b.oid_cab_asi_acob and ");
			textSQL.append("   a.activo = 1 and ");
			textSQL.append("   b.activo = 1 and ");
			textSQL.append("   b.cuenta = ? and ");
			textSQL.append("   a.fec_asiento < ? and ");
			textSQL.append("   a.oid_empresa = ? ");
			

			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setString(1, cuenta);
			querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
			querySelect.setInt(3, empresa.getOID());

			ResultSet rs = querySelect.executeQuery();
			double saldo = 0;
			if (rs.next())
				saldo = rs.getDouble(1);
			rs.close();
			querySelect.close();

			return saldo;
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
	
	private PreparedStatement selectByCtaFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarDetAsiAcob a , cTarCabAsiAcob b  ");
		textSQL.append(" WHERE a.oid_cab_asi_acob = b.oid_cab_asi_acob and ");
		textSQL.append(" a.activo = 1 and b.activo = 1 and a.cuenta = ? and b.fec_asiento>=? and b.fec_asiento<=? and b.oid_empresa = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String cuenta = (String) condiciones.get("CUENTA");
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		
		querySelect.setString(1, cuenta);
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
		querySelect.setInt(4, empresa.getOID());
		return querySelect;
	}
	
	public static List getDetAsiACob(
			EmpresaConciTar empresa,
			String cuenta,
			java.util.Date fecDesde,
			java.util.Date fecHasta,
			ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("CUENTA", cuenta);
	  condiciones.put("FEC_DESDE", fecDesde);
	  condiciones.put("FEC_HASTA", fecHasta);
	  condiciones.put(EmpresaConciTar.NICKNAME, empresa);
	  return (List) ObjetoLogico.getObjects(DetAsiTarjACobrar.NICKNAME,
             DBDetAsiTarjACobrar.SELECT_BY_CTA_FEC_DES_HAS,
             condiciones,
             new ListObserver(),
             aSesion);
	}	
	
	
	
  
  
} 
