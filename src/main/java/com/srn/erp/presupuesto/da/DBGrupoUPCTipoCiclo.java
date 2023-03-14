package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.GrupoTipoUPC;
import com.srn.erp.presupuesto.bm.GrupoUPCTipoCiclo;
import com.srn.erp.presupuesto.bm.TipoCiclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBGrupoUPCTipoCiclo extends DBObjetoPersistente {

  public static final String OID_GRUPO_UPC_TIPO = "oid_grupo_upc_tipo";
  public static final String OID_TIPO_CICLO = "oid_tipo_ciclo";
  public static final String OID_GRUPO_TIPO_UPC = "oid_grupo_tipo_upc";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TIPO_CICLO = 100;
  public static final int SELECT_BY_TIPO_CICLO_GRUPO = 101;

  public DBGrupoUPCTipoCiclo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_UPC_TIPO = 1;
    final int OID_TIPO_CICLO = 2;
    final int OID_GRUPO_TIPO_UPC = 3;
    final int ACTIVO = 4;

    GrupoUPCTipoCiclo pers = (GrupoUPCTipoCiclo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plGUPCTipoCiclo "+
                     " ( "+
                      "OID_GRUPO_UPC_TIPO,"+
                      "OID_TIPO_CICLO,"+
                      "OID_GRUPO_TIPO_UPC,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_UPC_TIPO,pers.getOID());
    qInsert.setInt(OID_TIPO_CICLO,pers.getTipo_ciclo().getOID());
    qInsert.setInt(OID_GRUPO_TIPO_UPC,pers.getGrupo_tipo_upc().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_CICLO = 1;
    final int OID_GRUPO_TIPO_UPC = 2;
    final int ACTIVO = 3;
    final int OID_GRUPO_UPC_TIPO = 4;

    GrupoUPCTipoCiclo pers = (GrupoUPCTipoCiclo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plGUPCTipoCiclo set "+
              "oid_tipo_ciclo=?"+ 
              ",oid_grupo_tipo_upc=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_upc_tipo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_UPC_TIPO,pers.getOID());
    qUpdate.setInt(OID_TIPO_CICLO,pers.getTipo_ciclo().getOID());
    qUpdate.setInt(OID_GRUPO_TIPO_UPC,pers.getGrupo_tipo_upc().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_UPC_TIPO = 1; 
    GrupoUPCTipoCiclo pers = (GrupoUPCTipoCiclo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plGUPCTipoCiclo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_upc_tipo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_UPC_TIPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_UPC_TIPO = 1; 
    GrupoUPCTipoCiclo pers = (GrupoUPCTipoCiclo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plGUPCTipoCiclo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_upc_tipo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_UPC_TIPO, pers.getOID()); 
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
      case SELECT_BY_TIPO_CICLO: {
        ps = this.selectByTipoCiclo(aCondiciones); 
        break; 
      }
      case SELECT_BY_TIPO_CICLO_GRUPO: {
        ps = this.selectByTipoCicloGrupo(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPO_UPC_TIPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plGUPCTipoCiclo "); 
    textSQL.append(" WHERE oid_grupo_upc_tipo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_UPC_TIPO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plGUPCTipoCiclo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByTipoCicloGrupo(Object aCondiciones) throws BaseException, SQLException { 
  	 StringBuffer textSQL = new StringBuffer(); 
  	 textSQL.append("SELECT * FROM  plGUPCTipoCiclo "); 
  	 textSQL.append(" WHERE oid_tipo_ciclo = ? and oid_grupo_tipo_upc = ? ");
  	 HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	 TipoCiclo tipoCiclo = (TipoCiclo) condiciones.get(TipoCiclo.NICKNAME);
  	 GrupoTipoUPC grupoTipoUPC = (GrupoTipoUPC) condiciones.get(GrupoTipoUPC.NICKNAME);
  	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
  	 querySelect.setInt(1, tipoCiclo.getOID()); 
  	 querySelect.setInt(2, grupoTipoUPC.getOID());
  	 return querySelect; 
  }
  
  private PreparedStatement selectByTipoCiclo(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plGUPCTipoCiclo "); 
    textSQL.append(" WHERE oid_tipo_ciclo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    TipoCiclo tipoCiclo = (TipoCiclo) aCondiciones; 
    querySelect.setInt(1, tipoCiclo.getOID()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_upc_tipo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plGUPCTipoCiclo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getGruposUPCByTipoCiclo(TipoCiclo aTipoCiclo,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(GrupoUPCTipoCiclo.NICKNAME,
         DBGrupoUPCTipoCiclo.SELECT_BY_TIPO_CICLO,
         aTipoCiclo,
         new ListObserver(),
         aSesion);
  }
  
  public static GrupoUPCTipoCiclo getGrupoUPCTipoCiclo(TipoCiclo tipoCiclo,
  																										 GrupoTipoUPC grupoTipoUPC,
  																										 ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(TipoCiclo.NICKNAME,tipoCiclo);
  	condiciones.put(GrupoTipoUPC.NICKNAME,grupoTipoUPC);
  	return (GrupoUPCTipoCiclo) ObjetoLogico.getObjects(GrupoUPCTipoCiclo.NICKNAME,
	  				DBGrupoUPCTipoCiclo.SELECT_BY_TIPO_CICLO_GRUPO,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
 }
  
  
  
} 
