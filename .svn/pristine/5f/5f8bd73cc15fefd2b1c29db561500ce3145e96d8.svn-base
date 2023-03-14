package com.srn.erp.excelReport.op;

import com.srn.erp.excelReport.bm.ExcelReport;
import com.srn.erp.excelReport.bm.FuncionReporteExcel;
import com.srn.erp.excelReport.bm.GrupoReporteExcel;
import com.srn.erp.excelReport.bm.UsuarioReporteExcel;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveExcelReport extends Operation { 

  public SaveExcelReport() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TExcelReport"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ExcelReport excelreport = ExcelReport.findByOid(dataset.getInteger("oid_reporte"),getSesion());
        excelreport.setCodigo(dataset.getString("codigo"));
        excelreport.setDescripcion(dataset.getString("descripcion"));
        excelreport.setActivo(dataset.getBoolean("activo"));
        excelreport.setGrupoReporteExcel(GrupoReporteExcel.findByOid(dataset.getInteger("oid_grupo_reporte"), this.getSesion()));
        excelreport.setOrden(dataset.getInteger("orden"));
        
        IDataSet dsFunciones = dataset.getDataSet("TFuncReporte");
        dsFunciones.first();
        while (!dsFunciones.EOF()) {
        	FuncionReporteExcel funcion =
        		FuncionReporteExcel.findByOid(dsFunciones.getInteger("oid_func_repo"), this.getSesion());
        	funcion.setReporte(excelreport);
        	funcion.setOrden(dsFunciones.getInteger("orden"));
        	funcion.setToken_funcion(dsFunciones.getString("token_funcion"));
        	funcion.setFuncion(dsFunciones.getString("funcion"));
        	funcion.setCelda_destino(dsFunciones.getString("celda_destino"));
        	funcion.setComentario(dsFunciones.getString("comentario"));
        	funcion.setActivo(dsFunciones.getBoolean("activo"));
        	if (!funcion.isActivo())
        		funcion.delete();
        	
        	excelreport.addFuncion(funcion);
        	
        	dsFunciones.next();
        }
        
        IDataSet dsUsuariosRep = dataset.getDataSet("TUsuariosReporte");
        dsUsuariosRep.first();
        while (!dsUsuariosRep.EOF()) {
        	UsuarioReporteExcel usuRepoExcel = 
        		excelreport.getUsuarioReporteExcel(Usuario.findByOidProxy(dsUsuariosRep.getInteger("oid_usuario"), this.getSesion()));
        	if (usuRepoExcel == null)
        		usuRepoExcel = (UsuarioReporteExcel) UsuarioReporteExcel.getNew(UsuarioReporteExcel.NICKNAME, this.getSesion());
        	usuRepoExcel.setUsuario(Usuario.findByOidProxy(dsUsuariosRep.getInteger("oid_usuario"), this.getSesion()));
        	usuRepoExcel.setReporte(excelreport);
        	usuRepoExcel.setLectura(dsUsuariosRep.getBoolean("lectura"));
        	usuRepoExcel.setModificacion(dsUsuariosRep.getBoolean("modif"));
        	usuRepoExcel.setGrabacion(dsUsuariosRep.getBoolean("grabacion"));
        	usuRepoExcel.setActivo(dsUsuariosRep.getBoolean("activo"));
        	if (!usuRepoExcel.isActivo())
        		usuRepoExcel.delete();
        	
        	excelreport.addUsuarioReporteExcel(usuRepoExcel);
        	
        	dsUsuariosRep.next();
        }
            
              
        
        
        
        addTransaccion(excelreport);
        dataset.next();
    }
      
      
  }
  
}
