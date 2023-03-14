package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.SaldoTipoValor;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoTipoValor extends DBObjetoPersistente {

  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String SALDO_INICIAL = "saldo_inicial";
  public static final String ENTRADAS = "entradas";
  public static final String SALIDAS = "salidas";
  public static final String SALDO_FINAL = "saldo_final";
  public static final String OID_CAJA = "oid_caja";
  
  public static final int SELECT_BY_SALDO_A_FECHA = 100;
  public static final int SELECT_SALDO_A_HOY = 101;

  public DBSaldoTipoValor() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_VALOR = 1;
    final int FECHA = 2;
    final int OID_MONEDA = 3;
    final int SALDO_INICIAL = 4;
    final int ENTRADAS = 5;
    final int SALIDAS = 6;
    final int SALDO_FINAL = 7;

    SaldoTipoValor pers = (SaldoTipoValor) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into baSaldoTipoValor "+
                     " ( "+
                      "OID_TIPO_VALOR,"+
                      "FECHA,"+
                      "OID_MONEDA,"+
                      "SALDO_INICIAL,"+
                      "ENTRADAS,"+
                      "SALIDAS,"+
                      "SALDO_FINAL)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TIPO_VALOR,pers.getOID());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(SALDO_INICIAL,pers.getSaldo_inicial().doubleValue());
    qInsert.setDouble(ENTRADAS,pers.getEntradas().doubleValue());;
    qInsert.setDouble(SALIDAS,pers.getSalidas().doubleValue());
    qInsert.setDouble(SALDO_FINAL,pers.getSaldo_final().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FECHA = 1;
    final int OID_MONEDA = 2;
    final int SALDO_INICIAL = 3;
    final int ENTRADAS = 4;
    final int SALIDAS = 5;
    final int SALDO_FINAL = 6;
    final int OID_TIPO_VALOR = 7;

    SaldoTipoValor pers = (SaldoTipoValor) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update baSaldoTipoValor set "+
              "fecha=?"+ 
              ",oid_moneda=?"+ 
              ",saldo_inicial=?"+ 
              ",entradas=?"+ 
              ",salidas=?"+ 
              ",saldo_final=?"+ 
                 " where " +
                 " oid_tipo_valor=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_VALOR,pers.getOID());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(SALDO_INICIAL,pers.getSaldo_inicial().doubleValue());
    qUpdate.setDouble(ENTRADAS,pers.getEntradas().doubleValue());
    qUpdate.setDouble(SALIDAS,pers.getSalidas().doubleValue());
    qUpdate.setDouble(SALDO_FINAL,pers.getSaldo_final().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_VALOR = 1; 
    SaldoTipoValor pers = (SaldoTipoValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update baSaldoTipoValor "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tipo_valor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_VALOR, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_VALOR = 1; 
    SaldoTipoValor pers = (SaldoTipoValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update baSaldoTipoValor "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tipo_valor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_VALOR, pers.getOID()); 
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
      case SELECT_BY_SALDO_A_FECHA: {
        ps = this.selectSaldoAFecha(aCondiciones); 
        break; 
      }
      case SELECT_SALDO_A_HOY: {
          ps = this.selectSaldoAHoy(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 
  
  
  private PreparedStatement selectSaldoAHoy(Object aCondiciones) throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
		TipoValor tipoValor = (TipoValor) condiciones.get(TipoValor.NICKNAME); 
		  
		  
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select "); 
		textSQL.append("  a.oid_tipo_valor, ");
		textSQL.append("  b.oid_moneda, ");
		textSQL.append("  a.oid_caja, ");
		textSQL.append("  0 saldo_inicial, ");
		textSQL.append("  0 entradas, ");
		textSQL.append("  0 salidas, ");
		textSQL.append("  sum(a.importe) saldo_final ");
		textSQL.append(" from "); 
		textSQL.append("  vaValores a , vaTipoValores b ");
		textSQL.append(" where ");
		textSQL.append("   a.oid_tipo_valor = b.oid_tipo_valor ");
		textSQL.append("  and a.oid_caja = "+caja.getOIDInteger().toString()+" and "); 
		textSQL.append("  a.oid_tipo_valor = "+tipoValor.getOIDInteger().toString()+" ");
		textSQL.append("  and a.es_caja=1 and a.anulado=0 and a.endosado = 0 and a.depositado=0 and a.rechazado=0 and a.cobrado=0 and a.recibido=0 and a.devuelto=0 and a.liquidado=0 ");
		textSQL.append(" group by ");
		textSQL.append("  a.oid_tipo_valor, ");
		textSQL.append("  b.oid_moneda, ");
		textSQL.append("  a.oid_caja ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
		return querySelect; 
	  }
  
  
  private PreparedStatement selectSaldoAFecha(Object aCondiciones) throws BaseException, SQLException {
	
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
	TipoValor tipoValor = (TipoValor) condiciones.get(TipoValor.NICKNAME); 
	java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");  
	  
	StringBuffer textSQL = new StringBuffer();
	textSQL.append(" select "); 
	textSQL.append("  oid_tipo_valor, ");
	textSQL.append("  oid_moneda, ");
	textSQL.append("  oid_caja, ");
	textSQL.append("  (select  sum(a.importe*a.signo) from vaArqueo a , geComproCab b where a.oid_cco=b.oid_cco  and a.oid_caja ="+caja.getOIDInteger().toString()+" and a.oid_tipo_valor = "+tipoValor.getOIDInteger().toString()+" and a.fecha_caja<?) saldo_inicial, ");
	textSQL.append("  (select  sum(a.entrada) from vaArqueo a , geComproCab b where a.oid_cco=b.oid_cco and a.oid_caja = "+caja.getOIDInteger().toString()+" and a.oid_tipo_valor = "+tipoValor.getOIDInteger().toString()+" and a.fecha_caja=?) entradas, ");
	textSQL.append("  (select  sum(a.salida) from vaArqueo a , geComproCab b where a.oid_cco=b.oid_cco and a.oid_caja = "+caja.getOIDInteger().toString()+" and a.oid_tipo_valor = "+tipoValor.getOIDInteger().toString()+" and a.fecha_caja=?) salidas, ");
	textSQL.append("  (select  sum(a.importe*a.signo) from vaArqueo a , geComproCab b where a.oid_cco=b.oid_cco and  a.oid_caja ="+caja.getOIDInteger().toString()+" and a.oid_tipo_valor = "+tipoValor.getOIDInteger().toString()+" and a.fecha_caja<=?) saldo_final ");
	textSQL.append(" from "); 
	textSQL.append("  vaArqueo ");
	textSQL.append(" where ");
	textSQL.append("  oid_caja = "+caja.getOIDInteger().toString()+" and "); 
	textSQL.append("  oid_tipo_valor = "+tipoValor.getOIDInteger().toString()+" ");
	textSQL.append(" group by ");
	textSQL.append("  oid_tipo_valor, ");
	textSQL.append("  oid_moneda, ");
	textSQL.append("  oid_caja ");
	
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	querySelect.setDate(1, new java.sql.Date(fecha.getTime())); 
	querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
	querySelect.setDate(4, new java.sql.Date(fecha.getTime()));
	return querySelect; 
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 
    final int OID_TIPO_VALOR = 1; 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  baSaldoTipoValor "); 
    textSQL.append(" WHERE oid_tipo_valor = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TIPO_VALOR, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  baSaldoTipoValor "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_valor oid, codigo,  descripcion ,activo ");
    textSQL.append(" from baSaldoTipoValor");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static SaldoTipoValor getSaldoTipoValor(Caja caja,java.util.Date fecha,TipoValor tipoValor,ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Caja.NICKNAME,caja);
	  condiciones.put("FECHA",fecha);
	  condiciones.put(TipoValor.NICKNAME,tipoValor);
	  return (SaldoTipoValor) ObjetoLogico.getObjects(SaldoTipoValor.NICKNAME,
			  				DBSaldoTipoValor.SELECT_BY_SALDO_A_FECHA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static SaldoTipoValor getSaldoTipoValorAHoy(Caja caja,TipoValor tipoValor,ISesion aSesion)
  	throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Caja.NICKNAME,caja);
	  condiciones.put(TipoValor.NICKNAME,tipoValor);
	  return (SaldoTipoValor) ObjetoLogico.getObjects(SaldoTipoValor.NICKNAME,
	  				DBSaldoTipoValor.SELECT_SALDO_A_HOY,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
  
} 
