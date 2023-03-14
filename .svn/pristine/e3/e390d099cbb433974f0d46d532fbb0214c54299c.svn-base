package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.DispMovilExc;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDispMovilExc extends DBObjetoPersistente {

  public static final String OID_DISP_MOVIL = "oid_disp_movil";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_GRUPO_IMP_EXC = "oid_grupo_imp_exc";
  public static final String FEC_HOR_ULT_SINC_OL = "fec_hor_ult_sinc_ol";
  public static final String FORZAR_SINC_ALL = "forzar_sinc_all";
  public static final String ULT_NRO_LOTE_INF = "ult_nro_lote_inf";
  public static final String ACTIVO = "activo";
  public static final String FORZAR_SIEMPRE_SINC = "forzar_siempre_sinc";
  
  
  public static final int SELECT_BY_GRUPO_IMP_EXC = 100;

  public DBDispMovilExc() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DISP_MOVIL = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_GRUPO_IMP_EXC = 4;
    final int FEC_HOR_ULT_SINC_OL = 5;
    final int FORZAR_SINC_ALL = 6;
    final int ULT_NRO_LOTE_INF = 7;
    final int ACTIVO = 8;
    final int FORZAR_SIEMPRE_SINC = 9;

    DispMovilExc pers = (DispMovilExc) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excDispMovil "+
                     " ( "+
                      "OID_DISP_MOVIL,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_GRUPO_IMP_EXC,"+
                      "FEC_HOR_ULT_SINC_OL,"+
                      "FORZAR_SINC_ALL,"+
                      "ULT_NRO_LOTE_INF,"+
                      "ACTIVO,FORZAR_SIEMPRE_SINC)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DISP_MOVIL,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_importacion().getOID());
    qInsert.setString(FEC_HOR_ULT_SINC_OL,pers.getFec_hor_ult_sinc_ol());
    qInsert.setBoolean(FORZAR_SINC_ALL,pers.isForzar_sinc_all().booleanValue());
    if (pers.getUlt_nro_lote_inf()!=null)
    	qInsert.setInt(ULT_NRO_LOTE_INF,pers.getUlt_nro_lote_inf().intValue());
    else
    	qInsert.setInt(ULT_NRO_LOTE_INF,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isForzarSiempreSinc()!=null)
    	qInsert.setBoolean(FORZAR_SIEMPRE_SINC,pers.isForzarSiempreSinc());
    else
    	qInsert.setBoolean(FORZAR_SIEMPRE_SINC,false);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_GRUPO_IMP_EXC = 3;
    final int FEC_HOR_ULT_SINC_OL = 4;
    final int FORZAR_SINC_ALL = 5;
    final int ULT_NRO_LOTE_INF = 6;
    final int ACTIVO = 7;
    final int FORZAR_SIEMPRE_SINC = 8;
    final int OID_DISP_MOVIL = 9;

    DispMovilExc pers = (DispMovilExc) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excDispMovil set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",oid_grupo_imp_exc=?"+ 
              ",fec_hor_ult_sinc_ol=?"+ 
              ",forzar_sinc_all=?"+ 
              ",ult_nro_lote_inf=?"+ 
              ",activo=?"+ 
              ",forzar_siempre_sinc=?"+
                 " where " +
                 " oid_disp_movil=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DISP_MOVIL,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_importacion().getOID());
    qUpdate.setString(FEC_HOR_ULT_SINC_OL,pers.getFec_hor_ult_sinc_ol());
    qUpdate.setBoolean(FORZAR_SINC_ALL,pers.isForzar_sinc_all().booleanValue());
    if (pers.getUlt_nro_lote_inf()!=null)
    	qUpdate.setInt(ULT_NRO_LOTE_INF,pers.getUlt_nro_lote_inf().intValue());
    else
    	qUpdate.setInt(ULT_NRO_LOTE_INF,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isForzarSiempreSinc()!=null)
    	qUpdate.setBoolean(FORZAR_SIEMPRE_SINC,pers.isForzarSiempreSinc());
    else
    	qUpdate.setBoolean(FORZAR_SIEMPRE_SINC,false);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DISP_MOVIL = 1; 
    DispMovilExc pers = (DispMovilExc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excDispMovil "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_disp_movil=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DISP_MOVIL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DISP_MOVIL = 1; 
    DispMovilExc pers = (DispMovilExc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excDispMovil "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_disp_movil=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DISP_MOVIL, pers.getOID()); 
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
      case SELECT_BY_GRUPO_IMP_EXC: {
          ps = this.selectByGrupoImpExcluido(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DISP_MOVIL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excDispMovil "); 
    textSQL.append(" WHERE oid_disp_movil = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DISP_MOVIL, oid); 
    return querySelect; 
  }
  

  private PreparedStatement selectByGrupoImpExcluido(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excDispMovil "); 
	    textSQL.append(" WHERE oid_grupo_imp_exc = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    GrupoImportacionExcluido grupoImportacion = (GrupoImportacionExcluido) aCondiciones; 
	    querySelect.setInt(1, grupoImportacion.getOID()); 
	    return querySelect; 
	    
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excDispMovil "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_disp_movil oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excDispMovil");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDispMovExc(
		  GrupoImportacionExcluido grupoImportacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DispMovilExc.NICKNAME,
             DBDispMovilExc.SELECT_BY_GRUPO_IMP_EXC,
             grupoImportacion,
             new ListObserver(),
             aSesion);
  }

  
  
} 
