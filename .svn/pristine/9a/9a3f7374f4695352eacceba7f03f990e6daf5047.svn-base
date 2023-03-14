package com.srn.erp.bienUso.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.bienUso.bm.MovimientoBienUso;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBMovimientoBienUso extends DBObjetoPersistente {

  public static final String OID_MOVIN_BIEN = "oid_movin_bien";
  public static final String OID_BIEN_ALTA = "oid_bien_alta";
  public static final String FEC_IMPUTAC = "fec_imputac";
  public static final String TIPO_MOV = "tipo_mov";
  public static final String OID_PERI = "oid_peri";
  public static final String OID_DCO = "oid_dco";
  public static final String OID_SIST_VAL = "oid_sist_val";
  public static final String MESES_AMORT = "meses_amort";
  public static final String TASA_AMORT = "tasa_amort";
  public static final String IMPORTE = "importe";
  public static final String OID_CCO_DET_BU = "oid_cco_det_bu";
  public static final String SIGNO = "signo";
  
  public static final int SELECT_BY_MENOR_A_PERIODO_DESDE = 100;
  public static final int SELECT_BY_ENTRE_PERIODOS = 101;
  

  public DBMovimientoBienUso() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOVIN_BIEN = 1;
    final int OID_BIEN_ALTA = 2;
    final int FEC_IMPUTAC = 3;
    final int TIPO_MOV = 4;
    final int OID_PERI = 5;
    final int OID_DCO = 6;
    final int OID_SIST_VAL = 7;
    final int MESES_AMORT = 8;
    final int TASA_AMORT = 9;
    final int IMPORTE = 10;
    final int OID_CCO_DET_BU = 11;
    final int SIGNO = 12;

    MovimientoBienUso pers = (MovimientoBienUso) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buMovinBien "+
                     " ( "+
                      "OID_MOVIN_BIEN,"+
                      "OID_BIEN_ALTA,"+
                      "FEC_IMPUTAC,"+
                      "TIPO_MOV,"+
                      "OID_PERI,"+
                      "OID_DCO,"+
                      "oid_sist_val,"+
                      "meses_amort,"+
                      "tasa_amort,"+
                      "importe,"+
                      "oid_cco_det_bu,"+
                      "signo)"+
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
    qInsert.setInt(OID_MOVIN_BIEN,pers.getOID());
    qInsert.setInt(OID_BIEN_ALTA,pers.getSub_bien().getOID());
    qInsert.setDate(FEC_IMPUTAC,new Date(pers.getFec_imputac().getTime()));
    qInsert.setString(TIPO_MOV,pers.getTipo_mov());
    qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    if (pers.getCompro_conta_det()!=null)
      qInsert.setInt(OID_DCO,pers.getCompro_conta_det().getOID());
    else
      qInsert.setNull(OID_DCO,Types.INTEGER);    	
    qInsert.setInt(OID_SIST_VAL,pers.getSistemaValuacion().getOID());
    qInsert.setInt(MESES_AMORT,pers.getMesesAmortizados().intValue());
    qInsert.setDouble(TASA_AMORT,pers.getTasaAmortizacion().doubleValue());;
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setInt(OID_CCO_DET_BU,pers.getComproBienUsoDet().getOID());
    qInsert.setInt(SIGNO,pers.getSigno().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_ALTA = 1;
    final int FEC_IMPUTAC = 2;
    final int TIPO_MOV = 3;
    final int OID_PERI = 4;
    final int OID_DCO = 5;
    final int OID_SIST_VAL = 6;
    final int MESES_AMORT = 7;
    final int TASA_AMORT = 8;
    final int IMPORTE = 9;
    final int OID_CCO_DET_BU = 10;
    final int SIGNO = 11;
    final int OID_MOVIN_BIEN = 12;

    MovimientoBienUso pers = (MovimientoBienUso) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buMovinBien set "+
              "oid_bien_alta=?"+ 
              ",fec_imputac=?"+ 
              ",tipo_mov=?"+ 
              ",oid_peri=?"+ 
              ",oid_dco=?"+ 
              ",oid_sist_val=?"+
              ",meses_amort=?"+
              ",tasa_amort=?"+
              ",importe=?"+
              ",signo=?"+
              ",oid_cco_det_bu=?"+
                 " where " +
                 " oid_movin_bien=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOVIN_BIEN,pers.getOID());
    qUpdate.setInt(OID_BIEN_ALTA,pers.getSub_bien().getOID());
    qUpdate.setDate(FEC_IMPUTAC,new java.sql.Date(pers.getFec_imputac().getTime()));
    qUpdate.setString(TIPO_MOV,pers.getTipo_mov());
    qUpdate.setInt(OID_PERI,pers.getPeriodo().getOID());
    qUpdate.setInt(OID_DCO,pers.getCompro_conta_det().getOID());
    qUpdate.setInt(OID_SIST_VAL,pers.getSistemaValuacion().getOID());
    qUpdate.setInt(MESES_AMORT,pers.getMesesAmortizados().intValue());
    qUpdate.setDouble(TASA_AMORT,pers.getTasaAmortizacion().doubleValue());;
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());    
    qUpdate.setInt(OID_CCO_DET_BU,pers.getComproBienUsoDet().getOID());
    qUpdate.setInt(SIGNO,pers.getSigno().intValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOVIN_BIEN = 1; 
    MovimientoBienUso pers = (MovimientoBienUso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buMovinBien "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_movin_bien=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOVIN_BIEN, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOVIN_BIEN = 1; 
    MovimientoBienUso pers = (MovimientoBienUso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buMovinBien "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_movin_bien=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOVIN_BIEN, pers.getOID()); 
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
      case SELECT_BY_MENOR_A_PERIODO_DESDE : {
          ps = this.selectByMenorAPeriodoDesde(aCondiciones); 
          break; 
      }
      case SELECT_BY_ENTRE_PERIODOS : {
          ps = this.selectByEntrePeriodos(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOVIN_BIEN = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buMovinBien "); 
    textSQL.append(" WHERE oid_movin_bien = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOVIN_BIEN, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEntrePeriodos(Object aCondiciones) throws BaseException, SQLException {
	 HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	 SistemaValuacion sistemaValuacion = (SistemaValuacion) condiciones.get(SistemaValuacion.NICKNAME);
	 Periodo periodoDesde = (Periodo) condiciones.get("periodo_desde");
	 Periodo periodoHasta = (Periodo) condiciones.get("periodo_hasta");
	 StringBuffer textSQL = new StringBuffer(); 
	 textSQL.append("SELECT a.* FROM  buMovinBien a, gePeriodos b where a.oid_peri = b.oid_peri "); 
	 textSQL.append(" and a.oid_sist_val = ? and b.fecha_desde>=? and b.fecha_hasta<=?");
	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	 querySelect.setInt(1, sistemaValuacion.getOID());
	 querySelect.setDate(2, new java.sql.Date(periodoDesde.getFechadesde().getTime()));
	 querySelect.setDate(3, new Date(periodoHasta.getFechahasta().getTime()));
	 return querySelect; 
  }

  
  private PreparedStatement selectByMenorAPeriodoDesde(Object aCondiciones) throws BaseException, SQLException {
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT a.* FROM  buMovinBien a, gePeriodos b where a.oid_peri = b.oid_peri "); 
	textSQL.append(" and a.oid_sist_val = ? and b.fecha_desde<?");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	SistemaValuacion sistemaValuacion = (SistemaValuacion) condiciones.get(SistemaValuacion.NICKNAME);
	Periodo periodo = (Periodo) condiciones.get(Periodo.NICKNAME);
	querySelect.setInt(1,sistemaValuacion.getOID());
	querySelect.setDate(2,new Date(periodo.getFechadesde().getTime()));
	return querySelect; 
	  
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buMovinBien "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_movin_bien oid, codigo,  descripcion ,activo ");
    textSQL.append(" from buMovinBien");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getMovimientosSistValAntAlPeriodo(SistemaValuacion sistemaValuacion,
		  Periodo periodo,
		  ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(SistemaValuacion.NICKNAME,sistemaValuacion);
	  condiciones.put(Periodo.NICKNAME,periodo);
	  return (List) ObjetoLogico.getObjects(MovimientoBienUso.NICKNAME,
             DBMovimientoBienUso.SELECT_BY_MENOR_A_PERIODO_DESDE,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getMovimientosSistValEntrePeriodos(SistemaValuacion sistemaValuacion,
		  Periodo periodoDesde,
		  Periodo periodoHasta,
		  ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(SistemaValuacion.NICKNAME,sistemaValuacion);
	  condiciones.put("periodo_desde",periodoDesde);
	  condiciones.put("periodo_hasta",periodoHasta);
	  return (List) ObjetoLogico.getObjects(MovimientoBienUso.NICKNAME,
             DBMovimientoBienUso.SELECT_BY_ENTRE_PERIODOS,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  
} 
