package com.srn.erp.excelReport.op;


import java.util.Iterator;

import com.srn.erp.excelReport.bm.ExcelReport;
import com.srn.erp.excelReport.bm.FuncionReporteExcel;
import com.srn.erp.excelReport.bm.UsuarioReporteExcel;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerExcelReport extends Operation { 

  public TraerExcelReport() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ExcelReport excelreport = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       excelreport = ExcelReport.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       excelreport = ExcelReport.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetExcelReport = getDataSetExcelReport();
    IDataSet datasetFunciones = getDataSetFunciones();
    IDataSet datasetUsuarios = getDataSetUsuarioReporteExcel();
    
    if (excelreport != null) { 
        cargarRegistroExcelReport(datasetExcelReport, 
                         			excelreport);
        
        Iterator iterFunciones =
        	excelreport.getFunciones().iterator();
        while (iterFunciones.hasNext()) {
        	FuncionReporteExcel funcionReporte = (FuncionReporteExcel) iterFunciones.next();
        	cargarRegistroFuncion(datasetFunciones, funcionReporte);
        }
        
        int secu = 0;
        Iterator iterUsuarios = 
        	Usuario.getUsuariosActivos(this.getSesion()).iterator();
        while (iterUsuarios.hasNext()) {
        	Usuario usuario = (Usuario) iterUsuarios.next();
        	UsuarioReporteExcel usuRepoExc =
        		excelreport.getUsuarioReporteExcel(usuario);
        	
        	boolean lectura = false;
        	boolean grabacion = false;
        	boolean modificacion = false;
        	boolean activo = true;
        	if (usuRepoExc!=null) {
            	lectura = usuRepoExc.isLectura();
            	grabacion = usuRepoExc.isGrabacion();
            	modificacion = usuRepoExc.isModificacion();
            	activo = true;
        	}
        	cargarRegistroUsuarioReporteExcel(
        			datasetUsuarios, 
        			new Integer(++secu), 
        			excelreport, 
        			new Boolean(lectura), 
        			new Boolean(modificacion), 
        			new Boolean(grabacion), 
        			new Boolean(activo), usuario);
        }
        
        
        
    }
    
    writeCliente(datasetExcelReport);
    writeCliente(datasetFunciones);
    writeCliente(datasetUsuarios);
    
  }

  private IDataSet getDataSetExcelReport() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TExcelReport");
    dataset.fieldDef(new Field("oid_reporte", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 200)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_grupo_reporte", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_grupo_reporte", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupo_reporte", Field.STRING, 100));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDataSetFunciones() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TFuncReporte");
	    dataset.fieldDef(new Field("oid_func_repo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_reporte", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("token_funcion", Field.STRING, 255));
	    dataset.fieldDef(new Field("funcion", Field.STRING, 255));
	    dataset.fieldDef(new Field("comentario", Field.STRING, 255));
	    dataset.fieldDef(new Field("celda_destino", Field.STRING, 255));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
	  }
  

  private void cargarRegistroExcelReport(IDataSet dataset, 
                         ExcelReport report) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_reporte", report.getOIDInteger());
    dataset.fieldValue("codigo", report.getCodigo());
    dataset.fieldValue("descripcion", report.getDescripcion());
    dataset.fieldValue("activo", report.isActivo());
    dataset.fieldValue("oid_grupo_reporte", report.getGrupoReporteExcel().getOIDInteger());
    dataset.fieldValue("cod_grupo_reporte", report.getGrupoReporteExcel().getCodigo());
    dataset.fieldValue("desc_grupo_reporte", report.getGrupoReporteExcel().getDescripcion());
    dataset.fieldValue("orden", report.getGrupoReporteExcel().getOrden());
    
  }
  
  private void cargarRegistroFuncion(IDataSet dataset, 
		  FuncionReporteExcel funcion) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_func_repo", funcion.getOIDInteger());
	  dataset.fieldValue("oid_reporte", funcion.getReporte().getOIDInteger());
	  dataset.fieldValue("orden", funcion.getOrden());
	  dataset.fieldValue("token_funcion", funcion.getToken_funcion());
	  dataset.fieldValue("funcion", funcion.getFuncion());
	  dataset.fieldValue("comentario", funcion.getComentario());
	  dataset.fieldValue("celda_destino", funcion.getCelda_destino());
	  dataset.fieldValue("activo", funcion.isActivo());
  }
  
  private IDataSet getDataSetUsuarioReporteExcel() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TUsuariosReporte");
	    dataset.fieldDef(new Field("oid_rol_reporte", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_reporte", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("lectura", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("modif", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("grabacion", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("oid_usuario", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("nombre_y_apellido", Field.STRING, 200));
	    return dataset;
	  }
  
  private void cargarRegistroUsuarioReporteExcel(IDataSet dataset, 
         Integer oidRolReporte,
         ExcelReport reporte,
         Boolean lectura,
         Boolean modif,
         Boolean grabacion,
         Boolean activo,
         Usuario usuario) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_rol_reporte", oidRolReporte);
	  dataset.fieldValue("oid_reporte", reporte.getOIDInteger());
	  dataset.fieldValue("lectura", lectura);
	  dataset.fieldValue("modif", modif);
	  dataset.fieldValue("grabacion", grabacion);
	  dataset.fieldValue("activo", activo);
	  dataset.fieldValue("oid_usuario", usuario.getOIDInteger());
	  dataset.fieldValue("nombre_y_apellido", usuario.getApellidoyNombre());
  }

  
}
