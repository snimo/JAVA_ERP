package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.bm.GrupoCajasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBGrupoCajasDet extends DBObjetoPersistente {

  public static final String OID_GRUPO_CAJA_DET = "oid_grupo_caja_det";
  public static final String OID_GRUPO_CAJA = "oid_grupo_caja";
  public static final String OID_CAJA = "oid_caja";
  public static final String ORDEN = "orden";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CAJA_ACTIVOS = 100;
  public static final int SELECT_BY_GRUPO_CAJA_ACTIVO = 101;

  public DBGrupoCajasDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_CAJA_DET = 1;
    final int OID_GRUPO_CAJA = 2;
    final int OID_CAJA = 3;
    final int ORDEN = 4;
    final int ACTIVO = 5;

    GrupoCajasDet pers = (GrupoCajasDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaGrupoCajaDet "+
                     " ( "+
                      "OID_GRUPO_CAJA_DET,"+
                      "OID_GRUPO_CAJA,"+
                      "OID_CAJA,"+
                      "ORDEN,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_CAJA_DET,pers.getOID());
    qInsert.setInt(OID_GRUPO_CAJA,pers.getGrupo_caja().getOID());
    qInsert.setInt(OID_CAJA,pers.getCaja().getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_CAJA = 1;
    final int OID_CAJA = 2;
    final int ORDEN = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_CAJA_DET = 5;

    GrupoCajasDet pers = (GrupoCajasDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaGrupoCajaDet set "+
              "oid_grupo_caja=?"+ 
              ",oid_caja=?"+ 
              ",orden=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_caja_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CAJA_DET,pers.getOID());
    qUpdate.setInt(OID_GRUPO_CAJA,pers.getGrupo_caja().getOID());
    qUpdate.setInt(OID_CAJA,pers.getCaja().getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_CAJA_DET = 1; 
    GrupoCajasDet pers = (GrupoCajasDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaGrupoCajaDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_caja_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CAJA_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_CAJA_DET = 1; 
    GrupoCajasDet pers = (GrupoCajasDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaGrupoCajaDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_caja_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CAJA_DET, pers.getOID()); 
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
      case SELECT_BY_CAJA_ACTIVOS: {
          ps = this.selectByCajaActivos(aCondiciones); 
          break; 
      }
      case SELECT_BY_GRUPO_CAJA_ACTIVO: {
          ps = this.selectByGrupoCajaActivo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPO_CAJA_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaGrupoCajaDet "); 
    textSQL.append(" WHERE oid_grupo_caja_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_CAJA_DET, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByGrupoCajaActivo(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaGrupoCajaDet "); 
	    textSQL.append(" WHERE oid_grupo_caja = ? and oid_caja =? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    GrupoCajas grupo = (GrupoCajas) condiciones.get(GrupoCajas.NICKNAME);
	    Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
	    querySelect.setInt(1, grupo.getOID()); 
	    querySelect.setInt(2, caja.getOID());
	    return querySelect; 
	    
}

  
  private PreparedStatement selectByCajaActivos(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaGrupoCajaDet "); 
	    textSQL.append(" WHERE oid_grupo_caja = ? and activo=1 order by oid_grupo_caja_det ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    GrupoCajas grupo = (GrupoCajas) aCondiciones; 
	    querySelect.setInt(1, grupo.getOID()); 
	    return querySelect; 
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaGrupoCajaDet "); 
    textSQL.append(" WHERE oid_grupo_caja = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_caja_det oid,oid_grupo_caja codigo,  descripcion ,activo ");
    textSQL.append(" from vaGrupoCajaDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getGruposCajasDetByCaja(GrupoCajas grupoCaja,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(GrupoCajasDet.NICKNAME,
             DBGrupoCajasDet.SELECT_BY_CAJA_ACTIVOS,
             grupoCaja,
             new ListObserver(),
             aSesion);
  }
  
  public static GrupoCajasDet getGrupoCajasDet(GrupoCajas grupoCajas,Caja caja,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Caja.NICKNAME, caja);
	  condiciones.put(GrupoCajas.NICKNAME, grupoCajas);
	  return (GrupoCajasDet) ObjetoLogico.getObjects(GrupoCajasDet.NICKNAME,
			  				DBGrupoCajasDet.SELECT_BY_GRUPO_CAJA_ACTIVO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
