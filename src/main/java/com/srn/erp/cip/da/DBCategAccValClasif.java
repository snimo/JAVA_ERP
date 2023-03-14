package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CategAccValClasif;
import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCategAccValClasif extends DBObjetoPersistente {

  public static final String OID_CATEG_ACC_VCLA = "oid_categ_acc_vcla";
  public static final String OID_CATEG_ACCESO = "oid_categ_acceso";
  public static final String ACTIVO = "activo";
  public static final String OID_VAL_CLASIF_ENT = "oid_val_clasif_ent";
  
  public static final int SELECT_BY_VAL_CLASIF = 100;
  public static final int SELECT_BY_CATEG_VALCLASIF = 101;
  public static final int SELECT_BY_ACTIVO = 102;

  public DBCategAccValClasif() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CATEG_ACC_VCLA = 1;
    final int OID_CATEG_ACCESO = 2;
    final int ACTIVO = 3;
    final int OID_VAL_CLASIF_ENT = 4;

    CategAccValClasif pers = (CategAccValClasif) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipCategAccVClasif "+
                     " ( "+
                      "OID_CATEG_ACC_VCLA,"+
                      "OID_CATEG_ACCESO,"+
                      "ACTIVO,"+
                      "OID_VAL_CLASIF_ENT)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CATEG_ACC_VCLA,pers.getOID());
    qInsert.setInt(OID_CATEG_ACCESO,pers.getCategoria().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_VAL_CLASIF_ENT,pers.getVal_clasif_ent().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CATEG_ACCESO = 1;
    final int ACTIVO = 2;
    final int OID_VAL_CLASIF_ENT = 3;
    final int OID_CATEG_ACC_VCLA = 4;

    CategAccValClasif pers = (CategAccValClasif) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipCategAccVClasif set "+
              "oid_categ_acceso=?"+ 
              ",activo=?"+ 
              ",oid_val_clasif_ent=?"+ 
                 " where " +
                 " oid_categ_acc_vcla=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEG_ACC_VCLA,pers.getOID());
    qUpdate.setInt(OID_CATEG_ACCESO,pers.getCategoria().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_VAL_CLASIF_ENT,pers.getVal_clasif_ent().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CATEG_ACC_VCLA = 1; 
    CategAccValClasif pers = (CategAccValClasif) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategAccVClasif "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_categ_acc_vcla=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEG_ACC_VCLA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CATEG_ACC_VCLA = 1; 
    CategAccValClasif pers = (CategAccValClasif) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategAccVClasif "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_categ_acc_vcla=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEG_ACC_VCLA, pers.getOID()); 
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
      case SELECT_BY_VAL_CLASIF: {
          ps = this.selecByValClasif(aCondiciones); 
          break; 
      }
      case SELECT_BY_CATEG_VALCLASIF: {
          ps = this.selecByValClasifCategoria(aCondiciones); 
          break; 
      }
      case SELECT_BY_ACTIVO: {
          ps = this.selecByActivos(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CATEG_ACC_VCLA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategAccVClasif "); 
    textSQL.append(" WHERE oid_categ_acc_vcla = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CATEG_ACC_VCLA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selecByValClasif(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategAccVClasif "); 
	    textSQL.append(" WHERE oid_val_clasif_ent = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ValorClasificadorEntidad valor = (ValorClasificadorEntidad) aCondiciones; 
	    querySelect.setInt(1, valor.getOID()); 
	    return querySelect; 
  }

  
  private PreparedStatement selecByValClasifCategoria(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategAccVClasif "); 
	    textSQL.append(" WHERE oid_categ_acceso = ? and oid_val_clasif_ent = ? and activo = 1 "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    CategAccesoCIP categoria = (CategAccesoCIP) condiciones.get(CategAccesoCIP.NICKNAME);
	    ValorClasificadorEntidad valor = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	    querySelect.setInt(1, categoria.getOID());
	    querySelect.setInt(2, valor.getOID());
	    return querySelect;
	    
  }
  
  private PreparedStatement selecByActivos(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategAccVClasif "); 
	    textSQL.append(" WHERE activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategAccVClasif "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_categ_acc_vcla oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipCategAccVClasif");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static CategAccValClasif getCategAccValClasif(
		  CategAccesoCIP categoria,
		  ValorClasificadorEntidad valor,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(CategAccesoCIP.NICKNAME, categoria);
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, valor);
	  return (CategAccValClasif) ObjetoLogico.getObjects(CategAccValClasif.NICKNAME,
			  				DBCategAccValClasif.SELECT_BY_CATEG_VALCLASIF,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getCategoriasAcceso(
		  ValorClasificadorEntidad valor,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CategAccValClasif.NICKNAME,
             DBCategAccValClasif.SELECT_BY_VAL_CLASIF,
             valor,
             new ListObserver(),
             aSesion);
  }
  
  public static List getCategoriasAccesoActivas(
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CategAccValClasif.NICKNAME,
             DBCategAccValClasif.SELECT_BY_ACTIVO,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
