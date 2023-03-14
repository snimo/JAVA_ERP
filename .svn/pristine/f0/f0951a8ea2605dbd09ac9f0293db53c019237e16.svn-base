package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.SaldoEfectivo;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoEfectivo extends DBObjetoPersistente {

  public static final String OID_SALDO_EFECTIVO = "oid_saldo_efectivo";
  public static final String OID_CAJA = "oid_caja";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String SALDO = "saldo";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String ENTRADAS = "entradas";
  public static final String SALIDAS = "salidas";
  
  public static final int SELECT_BY_ALL_SALDOS = 100;
  public static final int SELECT_BY_CAJA_TIPO_VALOR_EFECTIVO = 101;

  public DBSaldoEfectivo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SALDO_EFECTIVO = 1;
    final int OID_CAJA = 2;
    final int OID_MONEDA = 3;
    final int SALDO = 4;
    final int OID_TIPO_VALOR = 5;

    SaldoEfectivo pers = (SaldoEfectivo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into SaldoEfectivo "+
                     " ( "+
                      "OID_SALDO_EFECTIVO,"+
                      "OID_CAJA,"+
                      "OID_MONEDA,"+
                      "SALDO,"+
                      "OID_TIPO_VALOR)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SALDO_EFECTIVO,pers.getOID());
    qInsert.setInt(OID_CAJA,pers.getCaja().getOID());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAJA = 1;
    final int OID_MONEDA = 2;
    final int SALDO = 3;
    final int OID_TIPO_VALOR = 4;
    final int OID_SALDO_EFECTIVO = 5;

    SaldoEfectivo pers = (SaldoEfectivo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update SaldoEfectivo set "+
              "oid_caja=?"+ 
              ",oid_moneda=?"+ 
              ",saldo=?"+ 
              ",oid_tipo_valor=?"+ 
                 " where " +
                 " oid_saldo_efectivo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SALDO_EFECTIVO,pers.getOID());
    qUpdate.setInt(OID_CAJA,pers.getCaja().getOID());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(SALDO,pers.getSaldo().doubleValue());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SALDO_EFECTIVO = 1; 
    SaldoEfectivo pers = (SaldoEfectivo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update SaldoEfectivo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_saldo_efectivo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SALDO_EFECTIVO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SALDO_EFECTIVO = 1; 
    SaldoEfectivo pers = (SaldoEfectivo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update SaldoEfectivo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_saldo_efectivo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SALDO_EFECTIVO, pers.getOID()); 
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
      case SELECT_BY_ALL_SALDOS: {
        ps = this.selectByAllSaldos(aCondiciones); 
        break; 
      }
      case SELECT_BY_CAJA_TIPO_VALOR_EFECTIVO: {
          ps = this.selectByCajaTipoValorEfectivo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SALDO_EFECTIVO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  SaldoEfectivo "); 
    textSQL.append(" WHERE oid_saldo_efectivo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SALDO_EFECTIVO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  SaldoEfectivo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByAllSaldos(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    	    
	    textSQL.append(" select "); 
	    textSQL.append("  oid_caja, ");
	    textSQL.append("  oid_moneda, ");
	    textSQL.append("  oid_tipo_valor, ");
	    textSQL.append("  sum(entrada) entradas, ");
	    textSQL.append("  sum(salida)  salidas "); 
	    textSQL.append(" from "); 
	    textSQL.append("  vaArqueo "); 
	    textSQL.append(" where "); 
	    textSQL.append(" (compo_tipo_valor = 'EFE_ML' or  compo_tipo_valor = 'EFE_ME') ");
	    
	    if (aCondiciones!=null) {
	    	Caja caja = (Caja) aCondiciones;
	    	textSQL.append(" and oid_caja = "+caja.getOIDInteger().toString());
	    }
	    
	    textSQL.append(" group by ");
	    textSQL.append("  oid_caja, ");
	    textSQL.append("  oid_moneda, ");
	    textSQL.append("  oid_tipo_valor ");
	    	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  
  }
  
  private PreparedStatement selectByCajaTipoValorEfectivo(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    
	    textSQL.append(" select "); 
	    textSQL.append("  oid_caja, ");
	    textSQL.append("  oid_moneda, ");
	    textSQL.append("  oid_tipo_valor, ");
	    textSQL.append("  sum(entrada) entradas, ");
	    textSQL.append("  sum(salida)  salidas "); 
	    textSQL.append(" from "); 
	    textSQL.append("  vaArqueo "); 
	    textSQL.append(" where "); 
	    textSQL.append(" (compo_tipo_valor = 'EFE_ML' or  compo_tipo_valor = 'EFE_ME') ");
	    
	    Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
	    textSQL.append(" and oid_caja = "+caja.getOIDInteger().toString());
	    
	    TipoValor tipoValor = (TipoValor) condiciones.get(TipoValor.NICKNAME);
	    textSQL.append(" and oid_tipo_valor = "+tipoValor.getOIDInteger().toString());
	    
	    textSQL.append(" group by ");
	    textSQL.append("  oid_caja, ");
	    textSQL.append("  oid_moneda, ");
	    textSQL.append("  oid_tipo_valor ");
	    	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  
}
  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_saldo_efectivo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from SaldoEfectivo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getSaldosEfectivo(Caja caja,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SaldoEfectivo.NICKNAME,
             DBSaldoEfectivo.SELECT_BY_ALL_SALDOS,
             caja,
             new ListObserver(),
             aSesion);
  }
  
  public static SaldoEfectivo getSaldoEfectivo(
		  Caja caja,
		  TipoValor tipoValor,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Caja.NICKNAME, caja);
	  condiciones.put(TipoValor.NICKNAME, tipoValor);
	  return (SaldoEfectivo) ObjetoLogico.getObjects(SaldoEfectivo.NICKNAME,
             DBSaldoEfectivo.SELECT_BY_CAJA_TIPO_VALOR_EFECTIVO,
             condiciones,
             new ObjetoObservado(),
             aSesion);
  }
  
  
  
} 
