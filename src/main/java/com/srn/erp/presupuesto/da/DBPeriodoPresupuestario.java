package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.TipoPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPeriodoPresupuestario extends DBObjetoPersistente {

  public static final String OID_PERI = "oid_peri";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String OID_TIPO_PERI = "oid_tipo_peri";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  
  public static final int SELECT_BY_TIPO_PERI_FEC_DESDE_HASTA = 100;
  public static final int SELECT_BY_TIPO_PERI_CODIGO = 101;
  public static final int SELECT_BY_TIPO_PERI_FECHA = 102;

  public DBPeriodoPresupuestario() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERI = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int OID_TIPO_PERI = 5;
    final int FEC_DESDE = 6;
    final int FEC_HASTA = 7;

    PeriodoPresupuestario pers = (PeriodoPresupuestario) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plPeriodo "+
                     " ( "+
                      "OID_PERI,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,"+
                      "OID_TIPO_PERI,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA)"+ 
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
    qInsert.setInt(OID_PERI,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_TIPO_PERI,pers.getTipo_periodo().getOID());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_TIPO_PERI = 4;
    final int FEC_DESDE = 5;
    final int FEC_HASTA = 6;
    final int OID_PERI = 7;

    PeriodoPresupuestario pers = (PeriodoPresupuestario) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plPeriodo set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",oid_tipo_peri=?"+ 
              ",fec_desde=?"+ 
              ",fec_hasta=?"+ 
                 " where " +
                 " oid_peri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERI,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_TIPO_PERI,pers.getTipo_periodo().getOID());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERI = 1; 
    PeriodoPresupuestario pers = (PeriodoPresupuestario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plPeriodo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERI = 1; 
    PeriodoPresupuestario pers = (PeriodoPresupuestario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plPeriodo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERI, pers.getOID()); 
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
      case SELECT_BY_TIPO_PERI_FEC_DESDE_HASTA: {
        ps = this.selectByTipoPeriFechaDesdeHasta(aCondiciones); 
        break; 
      }
      case SELECT_BY_TIPO_PERI_CODIGO: {
        ps = this.selectByTipoPeriCodigo(aCondiciones); 
        break; 
      }
      case SELECT_BY_TIPO_PERI_FECHA: {
        ps = this.selectByTipoPeriFecha(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PERI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plPeriodo "); 
    textSQL.append(" WHERE oid_peri = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PERI, oid); 
    return querySelect; 
  }
  
  		
  private PreparedStatement selectByTipoPeriCodigo(Object aCondiciones) throws BaseException, SQLException { 

  	    MapDatos mapaDatos = (MapDatos) aCondiciones;
  	    
  	    TipoPeriodo tipoPeriodo = TipoPeriodo.findByOidProxy(mapaDatos.getInteger("oid_tipo_peri"),this.getSesion());
  	    String codigo = mapaDatos.getString("codigo");
  	    StringBuffer textSQL = new StringBuffer();
  	    
  	    textSQL.append("SELECT * FROM  plPeriodo "); 
  	    textSQL.append(" WHERE oid_tipo_peri = ? and codigo=? ");
  	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
  	    querySelect.setInt(1, tipoPeriodo.getOID());
  	    querySelect.setString(2, codigo);
  	    return querySelect; 
  }
  
  private PreparedStatement selectByTipoPeriFecha(Object aCondiciones) throws BaseException, SQLException { 

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    TipoPeriodo tipoPeriodo = (TipoPeriodo) condiciones.get(TipoPeriodo.NICKNAME);
    java.util.Date fecha = (java.util.Date)condiciones.get("fecha");
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  plPeriodo "); 
    textSQL.append(" WHERE oid_tipo_peri = ? and ?>=fec_desde and ?<=fec_hasta ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setInt(1, tipoPeriodo.getOID());
    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
    querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
    return querySelect; 
  }
  
  
  private PreparedStatement selectByTipoPeriFechaDesdeHasta(Object aCondiciones) throws BaseException, SQLException { 

  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	TipoPeriodo tipoPeriodo = (TipoPeriodo) condiciones.get(TipoPeriodo.NICKNAME);
  	Date fechaDesde = (Date) condiciones.get("FECHA_DESDE");
  	Date fechaHasta = (Date) condiciones.get("FECHA_HASTA");
  	
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plPeriodo "); 
    textSQL.append(" WHERE oid_tipo_peri = ? and fec_desde>=? and fec_hasta<=? order by fec_desde ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setInt(1, tipoPeriodo.getOID());
    querySelect.setDate(2, new java.sql.Date(fechaDesde.getTime()));
    querySelect.setDate(3, new java.sql.Date(fechaHasta.getTime()));
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plPeriodo "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_peri oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plPeriodo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getPeriodosPresupuestados(TipoPeriodo tipoPeriodo,
  		java.util.Date fechaDesde,java.util.Date fechaHasta,
  		ISesion aSesion) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(TipoPeriodo.NICKNAME,tipoPeriodo);
  	condiciones.put("FECHA_DESDE",fechaDesde);
  	condiciones.put("FECHA_HASTA",fechaHasta);
  	return (List) ObjetoLogico.getObjects(PeriodoPresupuestario.NICKNAME,
         DBPeriodoPresupuestario.SELECT_BY_TIPO_PERI_FEC_DESDE_HASTA,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  public static PeriodoPresupuestario getPeriodoPresupuestario(TipoPeriodo tipoPeriodo,
  		String codigo,
      ISesion aSesion)
      throws BaseException {
  	MapDatos mapaDatos = new HashTableDatos();
  	mapaDatos.put("oid_tipo_peri",tipoPeriodo.getOIDInteger());
  	mapaDatos.put("codigo",codigo);
  	return (PeriodoPresupuestario) ObjetoLogico.getObjects(PeriodoPresupuestario.NICKNAME,
	  				DBPeriodoPresupuestario.SELECT_BY_TIPO_PERI_CODIGO,
	  				mapaDatos,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  public static PeriodoPresupuestario getPeriodoPresupuestario(TipoPeriodo tipoPeriodo,
  		java.util.Date fecha,
      ISesion aSesion)
      throws BaseException {
  	MapDatos mapaDatos = new HashTableDatos();
  	mapaDatos.put(TipoPeriodo.NICKNAME,tipoPeriodo);
  	mapaDatos.put("fecha",fecha);
  	return (PeriodoPresupuestario) ObjetoLogico.getObjects(PeriodoPresupuestario.NICKNAME,
	  				DBPeriodoPresupuestario.SELECT_BY_TIPO_PERI_FECHA,
	  				mapaDatos,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
  
  
  
  
} 
