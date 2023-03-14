package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.turnos.bm.RelaConcSujTur;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRelaConcSujTur extends DBObjetoPersistente {

  public static final String OID_CONC_SUJ = "oid_conc_suj";
  public static final String CONCEPTO = "concepto";
  public static final String NRO_SOCIO = "nro_socio";
  public static final String CANTIDAD = "cantidad";
  public static final String NUMERO = "numero";
  public static final String DESDE = "desde";
  public static final String HASTA = "hasta";
  
  public static final int DELETE_ALL  = 100;
  public static final int CONC_HAB  = 101;
  

  public DBRelaConcSujTur() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONC_SUJ = 1;
    final int CONCEPTO = 2;
    final int NRO_SOCIO = 3;
    final int CANTIDAD = 4;
    final int NUMERO = 5;
    final int DESDE = 6;
    final int HASTA = 7;

    RelaConcSujTur pers = (RelaConcSujTur) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuConceptoSuj "+
                     " ( "+
                      "OID_CONC_SUJ,"+
                      "CONCEPTO,"+
                      "NRO_SOCIO,"+
                      "CANTIDAD,"+
                      "NUMERO,"+
                      "DESDE,"+
                      "HASTA)"+ 
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
    qInsert.setInt(OID_CONC_SUJ,pers.getOID());
    qInsert.setString(CONCEPTO,pers.getConcepto());
    qInsert.setInt(NRO_SOCIO,pers.getNro_socio().intValue());
    qInsert.setInt(CANTIDAD,pers.getCantidad().intValue());
    qInsert.setInt(NUMERO,pers.getNumero().intValue());
    if (pers.getDesde()!=null)
    	qInsert.setDate(DESDE,new java.sql.Date(pers.getDesde().getTime()));
    else
    	qInsert.setDate(DESDE,new java.sql.Date(Fecha.getFecha(1, 1, 1900).getTime()));
    qInsert.setDate(HASTA,new java.sql.Date(pers.getHasta().getTime()));
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CONCEPTO = 1;
    final int NRO_SOCIO = 2;
    final int CANTIDAD = 3;
    final int NUMERO = 4;
    final int DESDE = 5;
    final int HASTA = 6;
    final int OID_CONC_SUJ = 7;

    RelaConcSujTur pers = (RelaConcSujTur) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuConceptoSuj set "+
              "concepto=?"+ 
              ",nro_socio=?"+ 
              ",cantidad=?"+ 
              ",numero=?"+ 
              ",desde=?"+ 
              ",hasta=?"+ 
                 " where " +
                 " oid_conc_suj=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_SUJ,pers.getOID());
    qUpdate.setString(CONCEPTO,pers.getConcepto());
    qUpdate.setInt(NRO_SOCIO,pers.getNro_socio().intValue());
    qUpdate.setInt(CANTIDAD,pers.getCantidad().intValue());
    qUpdate.setInt(NUMERO,pers.getNumero().intValue());
    qUpdate.setDate(DESDE,new java.sql.Date(pers.getDesde().getTime()));
    qUpdate.setDate(HASTA,new java.sql.Date(pers.getHasta().getTime()));
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }
  
  protected void deleteAll(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
	    StringBuffer sqlUpdate = new StringBuffer(); 
	    sqlUpdate.append("delete from tuConceptoSuj ");
	    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
	    qUpdate.executeUpdate();
	    qUpdate.close();
  } 
  

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_SUJ = 1; 
    RelaConcSujTur pers = (RelaConcSujTur) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuConceptoSuj "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conc_suj=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_SUJ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_SUJ = 1; 
    RelaConcSujTur pers = (RelaConcSujTur) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuConceptoSuj "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conc_suj=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_SUJ, pers.getOID()); 
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
      case CONC_HAB: {
          ps = this.selectByConcHab(aCondiciones); 
          break; 
      }
      case DELETE_ALL: {
          this.deleteAll(null); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONC_SUJ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuConceptoSuj "); 
    textSQL.append(" WHERE oid_conc_suj = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONC_SUJ, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByConcHab(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Sujeto sujeto = (Sujeto)condiciones.get(Sujeto.NICKNAME);
	    String comportamiento = (String)condiciones.get("COMPORTAMIENTO");
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuConceptoSuj "); 
	    textSQL.append(" WHERE nro_socio = ? and concepto in (select concepto from tuConcHabCateg where comportamiento = ? and oid_categoria = ? ) ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, new Integer(sujeto.getCodigo()));
	    querySelect.setString(2, comportamiento);
	    querySelect.setInt(3, sujeto.getCategoriaSujetoTurno().getOID());
	    
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuConceptoSuj "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conc_suj oid, codigo,  descripcion ,activo ");
    textSQL.append(" from tuConceptoSuj");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static void deleteAllRegistros(ISesion aSesion)
          throws BaseException {
	   ObjetoLogico.getObjects(RelaConcSujTur.NICKNAME,
			  				DBRelaConcSujTur.DELETE_ALL,
			  				null,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getConcHab(Sujeto sujeto,String comportamiento,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Sujeto.NICKNAME, sujeto);
	  condiciones.put("COMPORTAMIENTO", comportamiento);
	  return (List) ObjetoLogico.getObjects(RelaConcSujTur.NICKNAME,
             DBRelaConcSujTur.CONC_HAB,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
  
} 
