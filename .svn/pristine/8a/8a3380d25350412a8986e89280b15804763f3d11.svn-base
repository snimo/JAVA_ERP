package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBCabAsiTarjACobrar extends DBObjetoPersistente {

  public static final String OID_CAB_ASI_ACOB = "oid_cab_asi_acob";
  public static final String FEC_ASIENTO = "fec_asiento";
  public static final String COMENTARIO = "comentario";
  public static final String NRO_LIQUIDACION = "nro_liquidacion";
  public static final String ARCH_INTERFAZ_GEN = "arch_interfaz_gen";
  public static final String FEC_ARCH_INTERFAZ = "fec_arch_interfaz";
  public static final String ACTIVO = "activo";
  public static final String HORA_ARCH_INTERFAZ = "hora_arch_interfaz";
  public static final String CONTA_SIST_EXT = "conta_sist_ext";
  public static final String FEC_CONTA_SIST_EXT = "fec_conta_sist_ext";
  public static final String HOR_CONTA_SIST_EXT = "hor_conta_sist_ext";
  public static final String OID_EMPRESA = "oid_empresa";
  
  public static final int SELECT_BY_FEC_DESDE_HASTA = 100;

  public DBCabAsiTarjACobrar() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAB_ASI_ACOB = 1;
    final int FEC_ASIENTO = 2;
    final int COMENTARIO = 3;
    final int NRO_LIQUIDACION = 4;
    final int ARCH_INTERFAZ_GEN = 5;
    final int FEC_ARCH_INTERFAZ = 6;
    final int ACTIVO = 7;
    final int HORA_ARCH_INTERFAZ = 8;
    final int CONTA_SIST_EXT = 9;
    final int FEC_CONTA_SIST_EXT = 10;
    final int HOR_CONTA_SIST_EXT = 11;
    final int OID_EMPRESA = 12;

    CabAsiTarjACobrar pers = (CabAsiTarjACobrar) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into CTARCABASIACOB "+
                     " ( "+
                      "OID_CAB_ASI_ACOB,"+
                      "FEC_ASIENTO,"+
                      "COMENTARIO,"+
                      "NRO_LIQUIDACION,"+
                      "ARCH_INTERFAZ_GEN,"+
                      "FEC_ARCH_INTERFAZ,"+
                      "ACTIVO,"+
                      "HORA_ARCH_INTERFAZ,"+
                      "CONTA_SIST_EXT,"+
                      "FEC_CONTA_SIST_EXT,"+
                      "HOR_CONTA_SIST_EXT,OID_EMPRESA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CAB_ASI_ACOB,pers.getOID());
    qInsert.setDate(FEC_ASIENTO,new java.sql.Date(pers.getFec_asiento().getTime()));
    if (pers.getComentario()!=null)
    	qInsert.setString(COMENTARIO,pers.getComentario());
    else
    	qInsert.setNull(COMENTARIO,Types.VARCHAR);
    if (pers.getNro_liquidacion()!=null)
    	qInsert.setInt(NRO_LIQUIDACION,pers.getNro_liquidacion().intValue());
    else
    	qInsert.setInt(NRO_LIQUIDACION,Types.INTEGER);
    if (pers.isArch_interfaz_gen()!= null)
    	qInsert.setBoolean(ARCH_INTERFAZ_GEN,pers.isArch_interfaz_gen().booleanValue());
    else
    	qInsert.setBoolean(ARCH_INTERFAZ_GEN,false);
    if (pers.getFec_arch_interfaz()!=null) 
      qInsert.setDate(FEC_ARCH_INTERFAZ,new java.sql.Date(pers.getFec_arch_interfaz().getTime()));
    else
      qInsert.setNull(FEC_ARCH_INTERFAZ,java.sql.Types.DATE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getHora_arch_interfaz()!=null)
    	qInsert.setString(HORA_ARCH_INTERFAZ,pers.getHora_arch_interfaz());
    else
    	qInsert.setNull(HORA_ARCH_INTERFAZ,Types.VARCHAR);
    if (pers.isConta_sist_ext()!=null)
    	qInsert.setBoolean(CONTA_SIST_EXT,pers.isConta_sist_ext().booleanValue());
    else
    	qInsert.setBoolean(CONTA_SIST_EXT,false);
    if (pers.getFec_conta_sist_ext()!=null) 
      qInsert.setDate(FEC_CONTA_SIST_EXT,new java.sql.Date(pers.getFec_conta_sist_ext().getTime()));
    else
      qInsert.setNull(FEC_CONTA_SIST_EXT,java.sql.Types.DATE);
    if (pers.getHor_conta_sist_ext()!=null)
    	qInsert.setString(HOR_CONTA_SIST_EXT,pers.getHor_conta_sist_ext());
    else
    	qInsert.setNull(HOR_CONTA_SIST_EXT,Types.VARCHAR);
    if (pers.getEmpresa()!=null)
    	qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    else
    	qInsert.setNull(OID_EMPRESA,Types.INTEGER);    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FEC_ASIENTO = 1;
    final int COMENTARIO = 2;
    final int NRO_LIQUIDACION = 3;
    final int ARCH_INTERFAZ_GEN = 4;
    final int FEC_ARCH_INTERFAZ = 5;
    final int ACTIVO = 6;
    final int HORA_ARCH_INTERFAZ = 7;
    final int CONTA_SIST_EXT = 8;
    final int FEC_CONTA_SIST_EXT = 9;
    final int HOR_CONTA_SIST_EXT = 10;
    final int OID_EMPRESA = 11;
    final int OID_CAB_ASI_ACOB = 12;

    CabAsiTarjACobrar pers = (CabAsiTarjACobrar) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update CTARCABASIACOB set "+
              "fec_asiento=?"+ 
              ",comentario=?"+ 
              ",nro_liquidacion=?"+ 
              ",arch_interfaz_gen=?"+ 
              ",fec_arch_interfaz=?"+ 
              ",activo=?"+ 
              ",hora_arch_interfaz=?"+ 
              ",conta_sist_ext=?"+ 
              ",fec_conta_sist_ext=?"+ 
              ",hor_conta_sist_ext=?"+ 
              ",oid_empresa=?"+
                 " where " +
                 " oid_cab_asi_acob=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_ACOB,pers.getOID());
    qUpdate.setDate(FEC_ASIENTO, new java.sql.Date(pers.getFec_asiento().getTime()));
    if (pers.getComentario()!=null)
    	qUpdate.setString(COMENTARIO,pers.getComentario());
    else
    	qUpdate.setNull(COMENTARIO,Types.VARCHAR);
    if (pers.getNro_liquidacion()!=null)
    	qUpdate.setInt(NRO_LIQUIDACION,pers.getNro_liquidacion().intValue());
    else
    	qUpdate.setNull(NRO_LIQUIDACION,Types.INTEGER);
    if (pers.isArch_interfaz_gen()!=null)
    	qUpdate.setBoolean(ARCH_INTERFAZ_GEN,pers.isArch_interfaz_gen().booleanValue());
    else
    	qUpdate.setBoolean(ARCH_INTERFAZ_GEN,false);
    if (pers.getFec_arch_interfaz()!=null) 
      qUpdate.setDate(FEC_ARCH_INTERFAZ,new java.sql.Date(pers.getFec_arch_interfaz().getTime()));
    else
      qUpdate.setNull(FEC_ARCH_INTERFAZ,java.sql.Types.DATE);
    if (pers.isActivo()!=null)
    	qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    else
    	qUpdate.setBoolean(ACTIVO,false);
    if (pers.getHora_arch_interfaz()!=null)
    	qUpdate.setString(HORA_ARCH_INTERFAZ,pers.getHora_arch_interfaz());
    else
    	qUpdate.setNull(HORA_ARCH_INTERFAZ,Types.VARCHAR);
    if (pers.isConta_sist_ext()!=null)
    	qUpdate.setBoolean(CONTA_SIST_EXT,pers.isConta_sist_ext().booleanValue());
    else
    	qUpdate.setBoolean(CONTA_SIST_EXT,false);
    if (pers.getFec_conta_sist_ext()!=null) 
      qUpdate.setDate(FEC_CONTA_SIST_EXT,new java.sql.Date(pers.getFec_conta_sist_ext().getTime()));
    else
      qUpdate.setNull(FEC_CONTA_SIST_EXT,java.sql.Types.DATE);
    if (pers.getHor_conta_sist_ext()!=null)
    	qUpdate.setString(HOR_CONTA_SIST_EXT,pers.getHor_conta_sist_ext());
    else
    	qUpdate.setNull(HOR_CONTA_SIST_EXT,Types.VARCHAR);
    if (pers.getEmpresa()!=null)
    	qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    else
    	qUpdate.setNull(OID_EMPRESA,Types.INTEGER);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAB_ASI_ACOB = 1; 
    CabAsiTarjACobrar pers = (CabAsiTarjACobrar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update CTARCABASIACOB "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cab_asi_acob=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_ACOB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAB_ASI_ACOB = 1; 
    CabAsiTarjACobrar pers = (CabAsiTarjACobrar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update CTARCABASIACOB "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cab_asi_acob=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_ACOB, pers.getOID()); 
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
      case SELECT_BY_FEC_DESDE_HASTA: {
          ps = this.selectByFecDesdeHasta(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CAB_ASI_ACOB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  CTARCABASIACOB "); 
    textSQL.append(" WHERE oid_cab_asi_acob = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CAB_ASI_ACOB, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  CTARCABASIACOB "); 
	    textSQL.append(" WHERE fec_asiento >= ? and fec_asiento<=? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date)condiciones.get("FEC_DESDE");
	    java.util.Date fecHasta = (java.util.Date)condiciones.get("FEC_HASTA");
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime())); 
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  CTARCABASIACOB "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cab_asi_acob oid, codigo,  descripcion ,activo ");
    textSQL.append(" from CTARCABASIACOB");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAsientosByFechas(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FEC_DESDE", fecDesde);
	  condiciones.put("FEC_HASTA", fecHasta);
	  return (List) ObjetoLogico.getObjects(CabAsiTarjACobrar.NICKNAME,
             DBCabAsiTarjACobrar.SELECT_BY_FEC_DESDE_HASTA,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  

  
} 
