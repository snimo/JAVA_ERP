package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.SeguEmpresaPredioDet;
import com.srn.erp.excluidos.bm.SeguridadEmpresaPredio;
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

public class DBSeguEmpresaPredioDet extends DBObjetoPersistente {

  public static final String OID_SEG_EMP_PRE_D = "oid_seg_emp_pre_d";
  public static final String OID_SEG_EMP_PREDIO = "oid_seg_emp_predio";
  public static final String OID_PREDIO_VISUALIZ = "oid_predio_visualiz";
  public static final String OID_PERFIL_ACT = "oid_perfil_act";
  public static final String VIS_DIF_IMPORTES = "vis_dif_importes";
  public static final String VIS_VEHICULOS = "vis_vehiculos";
  public static final String VIS_OBS_GENERALES = "vis_obs_generales";
  public static final String VIS_NOVEDADES = "vis_novedades";
  public static final String VIS_ARCH_ADJUNTOS = "vis_arch_adjuntos";
  public static final String VIS_PERS_REL = "vis_pers_rel";
  public static final String PERMITIR_ALTA = "permitir_alta";
  public static final String VER_NROS_DE_ACTAS = "ver_nros_de_actas";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_SEG_EMP_PREDIO = 100;

  public DBSeguEmpresaPredioDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SEG_EMP_PRE_D = 1;
    final int OID_SEG_EMP_PREDIO = 2;
    final int OID_PREDIO_VISUALIZ = 3;
    final int OID_PERFIL_ACT = 4;
    final int VIS_DIF_IMPORTES = 5;
    final int VIS_VEHICULOS = 6;
    final int VIS_OBS_GENERALES = 7;
    final int VIS_NOVEDADES = 8;
    final int VIS_ARCH_ADJUNTOS = 9;
    final int VIS_PERS_REL = 10;
    final int PERMITIR_ALTA = 11;
    final int VER_NROS_DE_ACTAS = 12;
    final int ACTIVO = 13;

    SeguEmpresaPredioDet pers = (SeguEmpresaPredioDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excSeguEmpPredioD "+
                     " ( "+
                      "OID_SEG_EMP_PRE_D,"+
                      "OID_SEG_EMP_PREDIO,"+
                      "OID_PREDIO_VISUALIZ,"+
                      "OID_PERFIL_ACT,"+
                      "VIS_DIF_IMPORTES,"+
                      "VIS_VEHICULOS,"+
                      "VIS_OBS_GENERALES,"+
                      "VIS_NOVEDADES,"+
                      "VIS_ARCH_ADJUNTOS,"+
                      "VIS_PERS_REL,"+
                      "PERMITIR_ALTA,"+
                      "VER_NROS_DE_ACTAS,"+
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SEG_EMP_PRE_D,pers.getOID());
    qInsert.setInt(OID_SEG_EMP_PREDIO,pers.getSegu_empresa_predio().getOID());
    if (pers.getPredio()!=null) 
      qInsert.setInt(OID_PREDIO_VISUALIZ,pers.getPredio().getOID());
    else
      qInsert.setNull(OID_PREDIO_VISUALIZ,java.sql.Types.INTEGER);
    if (pers.getPerfil_act()!=null) 
      qInsert.setInt(OID_PERFIL_ACT,pers.getPerfil_act().getOID());
    else
      qInsert.setNull(OID_PERFIL_ACT,java.sql.Types.INTEGER);
    qInsert.setBoolean(VIS_DIF_IMPORTES,pers.isVis_dif_importes().booleanValue());
    qInsert.setBoolean(VIS_VEHICULOS,pers.isVis_vehiculos().booleanValue());
    qInsert.setBoolean(VIS_OBS_GENERALES,pers.isVis_obs_generales().booleanValue());
    qInsert.setBoolean(VIS_NOVEDADES,pers.isVis_novedades().booleanValue());
    qInsert.setBoolean(VIS_ARCH_ADJUNTOS,pers.isVis_arch_adjuntos().booleanValue());
    qInsert.setBoolean(VIS_PERS_REL,pers.isVis_pers_rel().booleanValue());
    qInsert.setBoolean(PERMITIR_ALTA,pers.isPermitir_alta().booleanValue());
    qInsert.setBoolean(VER_NROS_DE_ACTAS,pers.isVer_nros_de_actas().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SEG_EMP_PREDIO = 1;
    final int OID_PREDIO_VISUALIZ = 2;
    final int OID_PERFIL_ACT = 3;
    final int VIS_DIF_IMPORTES = 4;
    final int VIS_VEHICULOS = 5;
    final int VIS_OBS_GENERALES = 6;
    final int VIS_NOVEDADES = 7;
    final int VIS_ARCH_ADJUNTOS = 8;
    final int VIS_PERS_REL = 9;
    final int PERMITIR_ALTA = 10;
    final int VER_NROS_DE_ACTAS = 11;
    final int ACTIVO = 12;
    final int OID_SEG_EMP_PRE_D = 13;

    SeguEmpresaPredioDet pers = (SeguEmpresaPredioDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excSeguEmpPredioD set "+
              "oid_seg_emp_predio=?"+ 
              ",oid_predio_visualiz=?"+ 
              ",oid_perfil_act=?"+ 
              ",vis_dif_importes=?"+ 
              ",vis_vehiculos=?"+ 
              ",vis_obs_generales=?"+ 
              ",vis_novedades=?"+ 
              ",vis_arch_adjuntos=?"+ 
              ",vis_pers_rel=?"+ 
              ",permitir_alta=?"+ 
              ",ver_nros_de_actas=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_seg_emp_pre_d=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEG_EMP_PRE_D,pers.getOID());
    qUpdate.setInt(OID_SEG_EMP_PREDIO,pers.getSegu_empresa_predio().getOID());
    if (pers.getPredio()!=null) 
      qUpdate.setInt(OID_PREDIO_VISUALIZ,pers.getPredio().getOID());
    else
      qUpdate.setNull(OID_PREDIO_VISUALIZ,java.sql.Types.INTEGER);
    if (pers.getPerfil_act()!=null) 
      qUpdate.setInt(OID_PERFIL_ACT,pers.getPerfil_act().getOID());
    else
      qUpdate.setNull(OID_PERFIL_ACT,java.sql.Types.INTEGER);
    qUpdate.setBoolean(VIS_DIF_IMPORTES,pers.isVis_dif_importes().booleanValue());
    qUpdate.setBoolean(VIS_VEHICULOS,pers.isVis_vehiculos().booleanValue());
    qUpdate.setBoolean(VIS_OBS_GENERALES,pers.isVis_obs_generales().booleanValue());
    qUpdate.setBoolean(VIS_NOVEDADES,pers.isVis_novedades().booleanValue());
    qUpdate.setBoolean(VIS_ARCH_ADJUNTOS,pers.isVis_arch_adjuntos().booleanValue());
    qUpdate.setBoolean(VIS_PERS_REL,pers.isVis_pers_rel().booleanValue());
    qUpdate.setBoolean(PERMITIR_ALTA,pers.isPermitir_alta().booleanValue());
    qUpdate.setBoolean(VER_NROS_DE_ACTAS,pers.isVer_nros_de_actas().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEG_EMP_PRE_D = 1; 
    SeguEmpresaPredioDet pers = (SeguEmpresaPredioDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excSeguEmpPredioD "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_seg_emp_pre_d=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEG_EMP_PRE_D, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEG_EMP_PRE_D = 1; 
    SeguEmpresaPredioDet pers = (SeguEmpresaPredioDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excSeguEmpPredioD "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_seg_emp_pre_d=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEG_EMP_PRE_D, pers.getOID()); 
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
      case SELECT_BY_SEG_EMP_PREDIO: {
          ps = this.selectSegEmpresaPredio(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SEG_EMP_PRE_D = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excSeguEmpPredioD "); 
    textSQL.append(" WHERE oid_seg_emp_pre_d = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SEG_EMP_PRE_D, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectSegEmpresaPredio(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excSeguEmpPredioD "); 
	    textSQL.append(" WHERE oid_seg_emp_predio  = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    SeguridadEmpresaPredio seguEmpresaPredio = (SeguridadEmpresaPredio) aCondiciones; 
	    querySelect.setInt(1, seguEmpresaPredio.getOID()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excSeguEmpPredioD "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_seg_emp_pre_d oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excSeguEmpPredioD");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getSeguEmpreasPredioDet(
		  SeguridadEmpresaPredio seguEmpresaPredio,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SeguEmpresaPredioDet.NICKNAME,
             DBSeguEmpresaPredioDet.SELECT_BY_SEG_EMP_PREDIO,
             seguEmpresaPredio,
             new ListObserver(),
             aSesion);
  }  
  
} 
