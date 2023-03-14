package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class DBCategAccesoCIP extends DBObjetoPersistente {

  public static final String OID_CATEG_ACCESO = "oid_categ_acceso";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String OID_SUB_GRUPO = "oid_sub_grupo"; 
  
  public static final int SELECT_CATEG_ACC_PUEDE_HAB_USU = 100;
  public static final int SELECT_BY_LEGAJO = 101;
  

  public DBCategAccesoCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CATEG_ACCESO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int OID_SUB_GRUPO = 5;

    CategAccesoCIP pers = (CategAccesoCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipCategAcceso "+
                     " ( "+
                      "OID_CATEG_ACCESO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO , OID_SUB_GRUPO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CATEG_ACCESO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getSubGrupo()!=null)
    	qInsert.setInt(OID_SUB_GRUPO, pers.getSubGrupo().getOID());
    else
    	qInsert.setNull(OID_SUB_GRUPO, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_SUB_GRUPO = 4;
    final int OID_CATEG_ACCESO = 5;

    CategAccesoCIP pers = (CategAccesoCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipCategAcceso set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",oid_sub_grupo=?"+
                 " where " +
                 " oid_categ_acceso=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEG_ACCESO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getSubGrupo()!=null)
    	qUpdate.setInt(OID_SUB_GRUPO, pers.getSubGrupo().getOID());
    else
    	qUpdate.setNull(OID_SUB_GRUPO, Types.INTEGER);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CATEG_ACCESO = 1; 
    CategAccesoCIP pers = (CategAccesoCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategAcceso "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_categ_acceso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEG_ACCESO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CATEG_ACCESO = 1; 
    CategAccesoCIP pers = (CategAccesoCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategAcceso "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_categ_acceso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEG_ACCESO, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS_HELP: { 
          ps = this.selectAllActivosHelp(aCondiciones); 
          break; 
        } 
      
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
          ps = this.selectAllActivos(aCondiciones); 
          break; 
      }
      case SELECT_CATEG_ACC_PUEDE_HAB_USU: {
          ps = this.selectCategAccPuedeHabUsu(aCondiciones); 
          break; 
      }
      case SELECT_BY_LEGAJO: {
          ps = this.selectByLegajo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CATEG_ACCESO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategAcceso "); 
    textSQL.append(" WHERE oid_categ_acceso = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CATEG_ACCESO, oid); 
    return querySelect; 
  }

  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategAcceso "); 
	    textSQL.append(" WHERE activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }

  
  private PreparedStatement selectCategAccPuedeHabUsu(Object aCondiciones) throws BaseException, SQLException { 
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("");
	    textSQL.append(" select "); 
	    textSQL.append("   d.* ");
	    textSQL.append(" from ");
	    textSQL.append("   cipHabAccInternos c, ");
	    textSQL.append("   cipCategAcceso d ");
	    textSQL.append(" where ");
	    textSQL.append("   c.oid_categ_acceso = d.oid_categ_acceso and ");
	    textSQL.append("   d.activo = 1 and ");
	    textSQL.append("   c.activo = 1 and ");
	    textSQL.append("   c.oid_perfil_func in ( ");
	    textSQL.append("   	select "); 
	    textSQL.append("   	   a.oid_perfil_func "); 
	    textSQL.append("   	from "); 
	    textSQL.append("   	   sePerfFuncUsu a, ");
	    textSQL.append("   	   sePerfilFunc b ");
	    textSQL.append("   	where "); 
	    textSQL.append("   	   a.oid_perfil_func = b.oid_perfil_func and ");
	    textSQL.append("   	   a.activo = 1 and "); 
	    textSQL.append("   	   b.activo = 1 and ");
	    textSQL.append("   	   a.oid_usuario = ? ");
	    textSQL.append("   ) ");	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Usuario usuario = (Usuario) aCondiciones; 
	    querySelect.setInt(1, usuario.getOID()); 
	    return querySelect; 
  }

  
  private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException { 
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from cipCategAcceso where activo = 1 and oid_categ_acceso in ( ");
		textSQL.append(" 		select ");
		textSQL.append("		  a2.oid_categ_acceso ");
		textSQL.append("		from ");
		textSQL.append("		  cipCategAccLeg a2 ");
		textSQL.append("		where ");
		textSQL.append("		  a2.activo = 1 and a2.oid_legajo = ? ");
		textSQL.append("		union all ");
		textSQL.append("		select  ");
		textSQL.append("		  a1.oid_categ_acceso "); 
		textSQL.append("		from  ");
		textSQL.append("		  cipCategAccEstado  a1, ");
		textSQL.append("		  suLegajo b1 ");
		textSQL.append("		where  ");
		textSQL.append("		  a1.oid_estado = b1.oid_estado and "); 
		textSQL.append("		  a1.activo = 1 and  ");
		textSQL.append("		  b1.oid_legajo = ? and  ");
		textSQL.append("		  b1.activo = 1 "); 
		textSQL.append("		union all ");
		textSQL.append("		select ");
		textSQL.append("		  oid_categ_acceso ");
		textSQL.append("		from ");
		textSQL.append("		  cipCategAccVClasif a3 , ");
		textSQL.append("		  suLegajo b3 ");
		textSQL.append("		where ");
		textSQL.append("		  a3.activo = 1 and ");
		textSQL.append("		  b3.activo = 1 and ");
		textSQL.append("		  b3.oid_legajo = ? and ");
		textSQL.append("		  (a3.oid_val_clasif_ent = b3.oid_clasif_01 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_02 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_03 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_04 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_05 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_06 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_07 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_08 or "); 
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_09 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_10 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_11 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_12 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_13 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_14 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_15 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_16 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_17 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_18 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_19 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_20) ");
		textSQL.append("		) ");		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		querySelect.setInt(2, legajo.getOID());
		querySelect.setInt(3, legajo.getOID());
		return querySelect;
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategAcceso "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_categ_acceso oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cipCategAcceso");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllActivosHelp(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_categ_acceso oid,codigo codigo, descripcion descripcion ,activo ");
	    textSQL.append(" from cipCategAcceso where activo = 1");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  }
  
  
  public static List getAllActivos(
            ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(CategAccesoCIP.NICKNAME,
               DBCategAccesoCIP.SELECT_ALL_ACTIVOS,
               null,
               new ListObserver(),
               aSesion);
  }
  
  public static List getCategAccPuedeOtorgar(
		  Usuario usuario,
          ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(CategAccesoCIP.NICKNAME,
             DBCategAccesoCIP.SELECT_CATEG_ACC_PUEDE_HAB_USU,
             usuario,
             new ListObserver(),
             aSesion);
  }
  
  public static List getCategAccesosByLegajo(
		  Legajo legajo,
          ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(CategAccesoCIP.NICKNAME,
             DBCategAccesoCIP.SELECT_BY_LEGAJO,
             legajo,
             new ListObserver(),
             aSesion);
  }
  
  
  
  
  
} 
