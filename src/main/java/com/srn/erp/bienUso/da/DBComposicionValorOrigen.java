package com.srn.erp.bienUso.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bienUso.bm.ComposicionValorOrigen;
import com.srn.erp.bienUso.bm.SubBienVidaUtil;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComposicionValorOrigen extends DBObjetoPersistente {

  public static final String OID_COMP_VO = "oid_comp_vo";
  public static final String OID_DCO = "oid_dco";
  public static final String OID_BIEN_VU = "oid_bien_vu";
  public static final String PORC = "porc";
  public static final String IMPO_VALOR = "impo_valor";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String FEC_IMPUTAC = "fec_imputac";
  
  public static final int SELECT_BY_BIEN_VU = 100; 

  public DBComposicionValorOrigen() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMP_VO = 1;
    final int OID_DCO = 2;
    final int OID_BIEN_VU = 3;
    final int PORC = 4;
    final int IMPO_VALOR_ORI = 5;
    final int OID_MONEDA = 6;
    final int FEC_IMPUTAC = 7;

    ComposicionValorOrigen pers = (ComposicionValorOrigen) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buCompVO "+
                     " ( "+
                      "OID_COMP_VO,"+
                      "OID_DCO,"+
                      "OID_BIEN_VU,"+
                      "PORC,"+
                      "IMPO_VALOR,"+
                      "OID_MONEDA,"+
                      "FEC_IMPUTAC)"+ 
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
    qInsert.setInt(OID_COMP_VO,pers.getOID());
    qInsert.setInt(OID_DCO,pers.getCompro_conta_det().getOID());
    qInsert.setInt(OID_BIEN_VU,pers.getSubbienVidaUtil().getOID());
    qInsert.setDouble(PORC,pers.getPorcentaje().doubleValue());
    qInsert.setDouble(IMPO_VALOR_ORI,pers.getImpo_valor().doubleValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDate(FEC_IMPUTAC,new Date(pers.getFecImputac().getTime()));
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DCO = 1;
    final int OID_BIEN_VU = 2;
    final int PORC = 3;
    final int IMPO_VALOR_ORI = 4;
    final int OID_MONEDA = 5;
    final int FEC_IMPUTAC = 6;
    final int OID_COMP_VO = 7;

    ComposicionValorOrigen pers = (ComposicionValorOrigen) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buCompVO set "+
              "oid_dco=?"+ 
              ",oid_bien_vu=?"+ 
              ",porc=?"+ 
              ",impo_valor=?"+ 
              ",oid_moneda=?"+ 
              ",fec_imputac=?"+
                 " where " +
                 " oid_comp_vo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMP_VO,pers.getOID());
    qUpdate.setInt(OID_DCO,pers.getCompro_conta_det().getOID());
    qUpdate.setInt(OID_BIEN_VU,pers.getSubbienVidaUtil().getOID());
    qUpdate.setDouble(PORC,pers.getPorcentaje().doubleValue());
    qUpdate.setDouble(IMPO_VALOR_ORI,pers.getImpo_valor().doubleValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDate(FEC_IMPUTAC,new java.sql.Date(pers.getFecImputac().getTime()));
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMP_VO = 1; 
    ComposicionValorOrigen pers = (ComposicionValorOrigen) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buCompVO "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_comp_vo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMP_VO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMP_VO = 1; 
    ComposicionValorOrigen pers = (ComposicionValorOrigen) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buCompVO "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_comp_vo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMP_VO, pers.getOID()); 
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
      case SELECT_BY_BIEN_VU: {
        ps = this.selectByBienVU(aCondiciones); 
        break;     	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COMP_VO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buCompVO "); 
    textSQL.append(" WHERE oid_comp_vo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMP_VO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByBienVU(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buCompVO "); 
	textSQL.append(" WHERE oid_bien_vu = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	SubBienVidaUtil subBienVidaUtil = (SubBienVidaUtil) aCondiciones; 
	querySelect.setInt(1, subBienVidaUtil.getOID()); 
	return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buCompVO "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_comp_vo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from buCompVO");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getValoresOrigen(SubBienVidaUtil subBienVidaUtil,
          ISesion aSesion) throws BaseException {
	return (List) ObjetoLogico.getObjects(ComposicionValorOrigen.NICKNAME,
             DBComposicionValorOrigen.SELECT_BY_BIEN_VU,
             subBienVidaUtil,
             new ListObserver(),
             aSesion);
  }
  
  
} 
