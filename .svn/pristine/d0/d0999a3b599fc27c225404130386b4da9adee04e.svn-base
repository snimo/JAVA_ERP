package com.srn.erp.proveedoresMaterials.da;

import java.sql.*;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.proveedoresMaterials.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBGrupoProveedor extends DBObjetoPersistente {

  public static final String OID_GRUPO_PROVEEDOR = "oid_grupo_proveedor";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_GRUPO_UTE = "oid_grupo_ute";
  public static final String OID_GRUPO_BINBAIRES = "oid_grupo_binbaires";
  public static final String OID_GRUPO_ALAVERA = "oid_grupo_alavera";
  public static final String OID_GRUPO_MAGIC = "oid_grupo_magic";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_ALL = 100;
  public static final int SELECT_BY_OID_UTE = 101;
  public static final int SELECT_BY_OID_BINBAIRES = 102;
  public static final int SELECT_BY_OID_ALAVERA = 103;
  public static final int SELECT_BY_OID_MAGIC = 104;
  public static final int SELECT_BY_OID_BASE = 105;

  public DBGrupoProveedor() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_PROVEEDOR = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_GRUPO_UTE = 4;
    final int OID_GRUPO_BINBAIRES = 5;
    final int OID_GRUPO_ALAVERA = 6;
    final int OID_GRUPO_MAGIC = 7;
    final int ACTIVO = 8;

    GrupoProveedor pers = (GrupoProveedor) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into MCGrupoProveedor "+
                     " ( "+
                      "OID_GRUPO_PROVEEDOR,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_GRUPO_UTE,"+
                      "OID_GRUPO_BINBAIRES,"+
                      "OID_GRUPO_ALAVERA,"+
                      "OID_GRUPO_MAGIC,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_PROVEEDOR,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_GRUPO_UTE,pers.getGrupoute().intValue());
    qInsert.setInt(OID_GRUPO_BINBAIRES,pers.getGrupobinbaires().intValue());
    qInsert.setInt(OID_GRUPO_ALAVERA,pers.getGrupoalavera().intValue());
    qInsert.setInt(OID_GRUPO_MAGIC,pers.getGrupomagic().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_GRUPO_UTE = 3;
    final int OID_GRUPO_BINBAIRES = 4;
    final int OID_GRUPO_ALAVERA = 5;
    final int OID_GRUPO_MAGIC = 6;
    final int ACTIVO = 7;
    final int OID_GRUPO_PROVEEDOR = 8;

    GrupoProveedor pers = (GrupoProveedor) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update MCGrupoProveedor set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",oid_grupo_ute=?"+ 
              ",oid_grupo_binbaires=?"+ 
              ",oid_grupo_alavera=?"+ 
              ",oid_grupo_magic=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_proveedor=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_PROVEEDOR,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_GRUPO_UTE,pers.getGrupoute().intValue());
    qUpdate.setInt(OID_GRUPO_BINBAIRES,pers.getGrupobinbaires().intValue());
    qUpdate.setInt(OID_GRUPO_ALAVERA,pers.getGrupoalavera().intValue());
    qUpdate.setInt(OID_GRUPO_MAGIC,pers.getGrupomagic().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_PROVEEDOR = 1; 
    GrupoProveedor pers = (GrupoProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update MCGrupoProveedor "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_proveedor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_PROVEEDOR, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_PROVEEDOR = 1; 
    GrupoProveedor pers = (GrupoProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update MCGrupoProveedor "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_proveedor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_PROVEEDOR, pers.getOID()); 
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
		case SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_BY_OID_UTE: {
			ps = this.selectByOidUte(aCondiciones);
			break;
		}
		case SELECT_BY_OID_BINBAIRES: {
			ps = this.selectByOidBinbaires(aCondiciones);
			break;
		}
		case SELECT_BY_OID_ALAVERA: {
			ps = this.selectByOidAlavera(aCondiciones);
			break;
		}
		case SELECT_BY_OID_MAGIC: {
			ps = this.selectByOidMagic(aCondiciones);
			break;
		}
		case SELECT_BY_OID_BASE: {
			ps = this.selectByOidBase(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_PROVEEDOR = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  MCGrupoProveedor ");
		textSQL.append(" WHERE oid_grupo_proveedor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_PROVEEDOR, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  MCGrupoProveedor ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByOidUte(Object aCondiciones) throws BaseException, SQLException {
		Integer oid = (Integer) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  MCGrupoProveedor ");
		textSQL.append(" WHERE oid_grupo_ute = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oid);
		return querySelect;
	}

	private PreparedStatement selectByOidBinbaires(Object aCondiciones) throws BaseException, SQLException {
		Integer oid = (Integer) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  MCGrupoProveedor ");
		textSQL.append(" WHERE oid_grupo_binbaires = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByOidAlavera(Object aCondiciones) throws BaseException, SQLException {
		Integer oid = (Integer) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  MCGrupoProveedor ");
		textSQL.append(" WHERE oid_grupo_alavera = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByOidMagic(Object aCondiciones) throws BaseException, SQLException {
		Integer oid = (Integer) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  MCGrupoProveedor ");
		textSQL.append(" WHERE oid_grupo_magic = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByOidBase(Object aCondiciones) throws BaseException, SQLException {
		Hashtable hash = (Hashtable) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  MCGrupoProveedor ");
		textSQL.append(" WHERE oid_grupo_ute = ? and oid_grupo_binbaires = ?");
		textSQL.append(" and oid_grupo_alavera = ? and oid_grupo_magic = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, (Integer) hash.get("UTE"));
		querySelect.setInt(2, (Integer)hash.get("BINBAIRES"));
		querySelect.setInt(3, (Integer)hash.get("ALAVERA"));
		querySelect.setInt(4, (Integer)hash.get("MAGIC"));
		return querySelect;
	}
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_proveedor oid, codigo,  descripcion ,activo ");
		textSQL.append(" from MCGrupoProveedor");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  MCGrupoProveedor ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
  
  public static List getAllObject(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoProveedor.NICKNAME, 
				DBGrupoProveedor.SELECT_ALL, null, new ListObserver(), aSesion);
  }
  
  public static GrupoProveedor getByUteOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoProveedor) ObjetoLogico.getObjects(GrupoProveedor.NICKNAME, 
				DBGrupoProveedor.SELECT_BY_OID_UTE, oid, new ObjetoObservado(), aSesion);
  }
  
  public static GrupoProveedor getByBinbairesOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoProveedor) ObjetoLogico.getObjects(GrupoProveedor.NICKNAME, 
				DBGrupoProveedor.SELECT_BY_OID_BINBAIRES, oid, new ObjetoObservado(), aSesion);
  }
  
  public static GrupoProveedor getByAlaveraOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoProveedor) ObjetoLogico.getObjects(GrupoProveedor.NICKNAME, 
				DBGrupoProveedor.SELECT_BY_OID_ALAVERA, oid, new ObjetoObservado(), aSesion);
  }
  
  public static GrupoProveedor getByMagicOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoProveedor) ObjetoLogico.getObjects(GrupoProveedor.NICKNAME, 
				DBGrupoProveedor.SELECT_BY_OID_MAGIC, oid, new ObjetoObservado(), aSesion);
  }
  
  public static GrupoProveedor getByOidBase(Integer oidUte, Integer oidBinbaires, Integer oidAlavera, Integer oidMagic, ISesion aSesion) throws BaseException {
	  	Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
	  	hashtable.put("UTE", oidUte);
	  	hashtable.put("BINBAIRES", oidBinbaires);
	  	hashtable.put("ALAVERA", oidAlavera);
	  	hashtable.put("MAGIC", oidMagic);
		return (GrupoProveedor) ObjetoLogico.getObjects(GrupoProveedor.NICKNAME, 
				DBGrupoProveedor.SELECT_BY_OID_BASE, hashtable, new ObjetoObservado(), aSesion);
  }
  
} 
