package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.AtributoEnGrupo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoHabilitadoEntidad;
import com.srn.erp.general.bm.TablasDeEntidades;
import com.srn.erp.stock.bm.AtributosProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGrupoHabilitadoEntidad extends DBObjetoPersistente {

  public static final String OID_GRUPOS_HAB_ENT = "oid_grupos_hab_ent";
  public static final String OID_GRUPO_ATRI_VAR = "oid_grupo_atri_var";
  public static final String OID_GRUPOS_ATRI = "oid_grupos_atri";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_GRUPO_ATRI_VAR = 100;

  public DBGrupoHabilitadoEntidad() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPOS_HAB_ENT = 1;
    final int OID_GRUPO_ATRI_VAR = 2;
    final int OID_GRUPOS_ATRI = 3;
    final int ACTIVO = 4;

    GrupoHabilitadoEntidad pers = (GrupoHabilitadoEntidad) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geGruposHabEnt "+
                     " ( "+
                      "OID_GRUPOS_HAB_ENT,"+
                      "OID_GRUPO_ATRI_VAR,"+
                      "OID_GRUPOS_ATRI,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPOS_HAB_ENT,pers.getOID());
    qInsert.setInt(OID_GRUPO_ATRI_VAR,pers.getGrupo_atributo_entidad_var().getOID());
    qInsert.setInt(OID_GRUPOS_ATRI,pers.getGrupo_atributo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
    
		// Dar de alta los atriutos en la tabla AtributosProducto
		Iterator iterAtributosEnGrupo = pers.getGrupo_atributo().getAtributosEnGrupo().iterator();
		while (iterAtributosEnGrupo.hasNext()) {
			AtributoEnGrupo atriEnGrupo = (AtributoEnGrupo) iterAtributosEnGrupo.next();
			TablasDeEntidades tablasDeEntidades = new TablasDeEntidades();
			String tablaFisica = tablasDeEntidades.getTablaDeEntidad(AtributosProducto.NICKNAME).getNombreTablaFisica();
			atriEnGrupo.getAtributo().agregarAtributoA(tablaFisica);
		}
    
    
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_ATRI_VAR = 1;
    final int OID_GRUPOS_ATRI = 2;
    final int ACTIVO = 3;
    final int OID_GRUPOS_HAB_ENT = 4;

    GrupoHabilitadoEntidad pers = (GrupoHabilitadoEntidad) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geGruposHabEnt set "+
              "oid_grupo_atri_var=?"+ 
              ",oid_grupos_atri=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupos_hab_ent=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPOS_HAB_ENT,pers.getOID());
    qUpdate.setInt(OID_GRUPO_ATRI_VAR,pers.getGrupo_atributo_entidad_var().getOID());
    qUpdate.setInt(OID_GRUPOS_ATRI,pers.getGrupo_atributo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPOS_HAB_ENT = 1; 
    GrupoHabilitadoEntidad pers = (GrupoHabilitadoEntidad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from geGruposHabEnt "+
                     " where " + 
                     " oid_grupos_hab_ent=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPOS_HAB_ENT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPOS_HAB_ENT = 1; 
    GrupoHabilitadoEntidad pers = (GrupoHabilitadoEntidad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geGruposHabEnt "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupos_hab_ent=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPOS_HAB_ENT, pers.getOID()); 
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
      case SELECT_BY_GRUPO_ATRI_VAR: {
        ps = this.selectByGrupoAtriVar(aCondiciones);
        break;
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPOS_HAB_ENT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geGruposHabEnt "); 
    textSQL.append(" WHERE oid_grupos_hab_ent = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPOS_HAB_ENT, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geGruposHabEnt "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupos_hab_ent oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geGruposHabEnt");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  private PreparedStatement selectByGrupoAtriVar(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) aCondiciones;
    textSQL.append("select * ");
    textSQL.append(" from geGruposHabEnt where oid_grupo_atri_var = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,grupoAtriEntVar.getOID());
    return querySelect;

  }

  public static List getGruposHabilitadosEnt(GrupoAtributoEntidadVar grupoAtriEntVar,
      ISesion aSesion) throws BaseException {
      return (List) ObjetoLogico.getObjects(GrupoHabilitadoEntidad.NICKNAME,
         DBGrupoHabilitadoEntidad.SELECT_BY_GRUPO_ATRI_VAR,
         grupoAtriEntVar,
         new ListObserver(),
         aSesion);
  }

  
} 
