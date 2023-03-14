package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MovCajaDiaTipoCompro;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBMovCajaDiaTipoCompro extends DBObjetoPersistente {

  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String OID_TC = "oid_tc";
  public static final String IMPORTE = "importe";
  public static final String CAJA = "oid_caja";
  
  public static final int SELECT_BY_MOV_DIA = 100;
  public static final int SELECT_BY_MOV_FECHA_DESDE_HASTA = 102;

  public DBMovCajaDiaTipoCompro() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

      }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

      }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    
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
      case SELECT_BY_MOV_DIA: {
        ps = this.selectByMovDia(aCondiciones); 
        break; 
      }
      case SELECT_BY_MOV_FECHA_DESDE_HASTA: {
        ps = this.selectByMovFechaDesdeHasta(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    return null; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

     return null; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

     return null; 
  }
  
  private PreparedStatement selectByMovFechaDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		Caja caja = (Caja)condiciones.get(Caja.NICKNAME);
		TipoValor tipoValor = (TipoValor) condiciones.get(TipoValor.NICKNAME);
		Date fechaDesde = (Date) condiciones.get("FECHA_DESDE");
		Date fechaHasta = (Date) condiciones.get("FECHA_HASTA");
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select "); 
		textSQL.append("  b.oid_tc, ");
		textSQL.append("  a.oid_tipo_valor, ");
		textSQL.append("  a.oid_moneda, ");
		textSQL.append("  a.oid_caja, ");
		textSQL.append("  sum(a.importe * a.signo) importe ");
		textSQL.append(" from "); 
		textSQL.append("  vaArqueo a, ");
		textSQL.append(" geComproCab b, ");
		textSQL.append("  geTipoCompro c ");
		textSQL.append(" where ");
		textSQL.append("  a.oid_cco = b.oid_cco and "); 
		textSQL.append("  b.oid_tc = c.oid_tc and ");
		textSQL.append("  a.oid_caja = "+caja.getOIDInteger().toString()+" and ");
		textSQL.append("  a.oid_tipo_valor = "+tipoValor.getOIDInteger().toString()+" and ");
		textSQL.append("  a.fecha_caja >= ? and ");
		textSQL.append("  a.fecha_caja <= ?  ");
		textSQL.append(" group by ");
		textSQL.append("  b.oid_tc, ");
		textSQL.append("  a.oid_tipo_valor, ");
		textSQL.append("  a.oid_moneda, ");
		textSQL.append("  a.oid_caja  ");
		  	
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fechaHasta.getTime()));
		return querySelect;
	  }
  
  
  private PreparedStatement selectByMovDia(Object aCondiciones) throws BaseException, SQLException {
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	
	Caja caja = (Caja)condiciones.get(Caja.NICKNAME);
	TipoValor tipoValor = (TipoValor) condiciones.get(TipoValor.NICKNAME);
	Date fecha = (Date) condiciones.get("FECHA");
	
	StringBuffer textSQL = new StringBuffer();
	textSQL.append(" select "); 
	textSQL.append("  b.oid_tc, ");
	textSQL.append("  a.oid_tipo_valor, ");
	textSQL.append("  a.oid_moneda, ");
	textSQL.append("  a.oid_caja, ");
	textSQL.append("  sum(a.importe * a.signo) importe ");
	textSQL.append(" from "); 
	textSQL.append("  vaArqueo a, ");
	textSQL.append(" geComproCab b, ");
	textSQL.append("  geTipoCompro c ");
	textSQL.append(" where ");
	textSQL.append("  a.oid_cco = b.oid_cco and "); 
	textSQL.append("  b.oid_tc = c.oid_tc and ");
	textSQL.append("  a.oid_caja = "+caja.getOIDInteger().toString()+" and ");
	textSQL.append("  a.oid_tipo_valor = "+tipoValor.getOIDInteger().toString()+" and ");
	textSQL.append("  a.fecha_caja = ? ");
	textSQL.append(" group by ");
	textSQL.append("  b.oid_tc, ");
	textSQL.append("  a.oid_tipo_valor, ");
	textSQL.append("  a.oid_moneda, ");
	textSQL.append("  a.oid_caja  ");
	  	
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
	return querySelect;
  }
  
  public static List getMovDiaTiposComprobantes(Caja caja,TipoValor tipoValor,Date fecha,ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Caja.NICKNAME,caja);
	  condiciones.put(TipoValor.NICKNAME,tipoValor);
	  condiciones.put("FECHA",fecha);
	  return (List) ObjetoLogico.getObjects(MovCajaDiaTipoCompro.NICKNAME,
             DBMovCajaDiaTipoCompro.SELECT_BY_MOV_DIA,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getMovDiaTiposComprobantesEntreFechas(Caja caja,TipoValor tipoValor,Date fechaDesde,Date fechaHasta,ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Caja.NICKNAME,caja);
	  condiciones.put(TipoValor.NICKNAME,tipoValor);
	  condiciones.put("FECHA_DESDE",fechaDesde);
	  condiciones.put("FECHA_HASTA",fechaHasta);
	  return (List) ObjetoLogico.getObjects(MovCajaDiaTipoCompro.NICKNAME,
             DBMovCajaDiaTipoCompro.SELECT_BY_MOV_FECHA_DESDE_HASTA,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
  
  
} 
