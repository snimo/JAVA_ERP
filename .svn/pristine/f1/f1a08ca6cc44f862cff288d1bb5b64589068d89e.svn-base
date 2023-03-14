package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.*;

import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class AltaAccionCronograma extends Operation { 

  public AltaAccionCronograma() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  Integer oidAccion  = mapaDatos.getInteger("oid_accion");
	  
	  IDataSet dsSegmentacionAlta = getDataSetSegmentacion();
	  IDataSet dsEstadosAlta = getDataSetEstados();
	  IDataSet dsMesesAEval = getDataSetMesesAEvaluar();
	  
	  // Traer los estados
	  int secuEstado = 0;
	  ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
	  Iterator iterValClasifEst = ValorClasificadorEntidad.getValoresClasifEntidad(clasifEstado, this.getSesion()).iterator();
	  while (iterValClasifEst.hasNext()) {
			++secuEstado;
			ValorClasificadorEntidad valorClasificadorEntidad = (ValorClasificadorEntidad) iterValClasifEst.next();		
			cargarEstado(dsEstadosAlta,++secuEstado,oidAccion,valorClasificadorEntidad.getOIDInteger(),valorClasificadorEntidad.getDescripcion(),false);
	  }
	  
	  // Traer los meses a Evalaur
	  cargarMesesAEvaluar(dsMesesAEval, 1, oidAccion, MesCronoDesa.ENERO, "Enero", false);
	  cargarMesesAEvaluar(dsMesesAEval, 2, oidAccion, MesCronoDesa.FEBRERO, "Febrero", false);
	  cargarMesesAEvaluar(dsMesesAEval, 3, oidAccion, MesCronoDesa.MARZO, "Marzo", false);
	  cargarMesesAEvaluar(dsMesesAEval, 4, oidAccion, MesCronoDesa.ABRIL, "Abril", false);
	  cargarMesesAEvaluar(dsMesesAEval, 5, oidAccion, MesCronoDesa.MAYO, "Mayo", false);
	  cargarMesesAEvaluar(dsMesesAEval, 6, oidAccion, MesCronoDesa.JUNIO, "Junio", false);
	  cargarMesesAEvaluar(dsMesesAEval, 7, oidAccion, MesCronoDesa.JULIO, "Julio", false);
	  cargarMesesAEvaluar(dsMesesAEval, 8, oidAccion, MesCronoDesa.AGOSTO, "Agosto", false);
	  cargarMesesAEvaluar(dsMesesAEval, 9, oidAccion, MesCronoDesa.SEPTIEMBRE, "Septiembre", false);
	  cargarMesesAEvaluar(dsMesesAEval, 10, oidAccion, MesCronoDesa.OCTUBRE, "Octubre", false);
	  cargarMesesAEvaluar(dsMesesAEval, 11, oidAccion, MesCronoDesa.NOVIEMBRE, "Noviembre", false);
	  cargarMesesAEvaluar(dsMesesAEval, 12, oidAccion, MesCronoDesa.DICIEMBRE, "Diciembre", false);
	  
	  cargarSegmentacion(dsSegmentacionAlta, oidAccion);
	  
	  writeCliente(dsSegmentacionAlta);
	  writeCliente(dsEstadosAlta);
	  writeCliente(dsMesesAEval);
	  
  } 

  private IDataSet getDataSetSegmentacion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAltaSegmentacion");
		dataset.fieldDef(new Field("oid_segmentacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_accion_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("habilitado" , Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("secu" , Field.STRING, 100));
		dataset.fieldDef(new Field("secu_padre" , Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}
	

	private IDataSet getDataSetEstados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAltaEstados");
		dataset.fieldDef(new Field("oid_estado_acc_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_accion_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_est", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_val_clasif_est", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarEstado(IDataSet dsEstado,
							  Integer oidEstadoAccCro,
							  Integer oidAccionCro,
							  Integer oidValClasifEst,
							  String descValClasifEst,
							  boolean activo) throws BaseException {
		
		dsEstado.append();
		dsEstado.fieldValue("oid_estado_acc_cro", oidEstadoAccCro);
		dsEstado.fieldValue("oid_accion_cro", oidAccionCro);
		dsEstado.fieldValue("oid_val_clasif_est", oidValClasifEst);
		dsEstado.fieldValue("desc_val_clasif_est", descValClasifEst);
		dsEstado.fieldValue("activo", activo);
		
	}
	
	private IDataSet getDataSetMesesAEvaluar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAltaMesesAEvaluar");
		dataset.fieldDef(new Field("oid_mes_a_eval", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_accion_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("mes", Field.STRING, 5));
		dataset.fieldDef(new Field("desc_mes", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}  
	
	private void cargarMesesAEvaluar(IDataSet dsMesesAEvaluar,
									 Integer oidMesAEval,
									 Integer oidAccion,
									 String mes,
									 String descMes,
									 boolean activo) throws BaseException {
		dsMesesAEvaluar.append();
		dsMesesAEvaluar.fieldValue("oid_mes_a_eval", oidMesAEval);
		dsMesesAEvaluar.fieldValue("oid_accion_cro", oidAccion);
		dsMesesAEvaluar.fieldValue("mes", mes);
		dsMesesAEvaluar.fieldValue("desc_mes", descMes);
		dsMesesAEvaluar.fieldValue("activo", activo);
		
	}
	
	private void cargarSegmentacion(IDataSet datasetSegmentacion,Integer oidAccion) throws BaseException {
		// Cargar las Empresas
		
		int oidSegmentacion = 0;
		
		Iterator iterEmpresas  = EstrucNivEmpresa.getEmpresasActivas(this.getSesion()).iterator();
		while (iterEmpresas.hasNext()) {
			EstrucNivEmpresa estrucNivEmpresa = (EstrucNivEmpresa) iterEmpresas.next();
			
			datasetSegmentacion.append();
			datasetSegmentacion.fieldValue("oid_segmentacion", ++oidSegmentacion);
			datasetSegmentacion.fieldValue("oid_accion_cro", oidAccion);
			if (estrucNivEmpresa.getValor_clasif_empresa()!=null)
				datasetSegmentacion.fieldValue("descripcion", estrucNivEmpresa.getValor_clasif_empresa().getDescripcion());
			else
				datasetSegmentacion.fieldValue("descripcion", "");
			datasetSegmentacion.fieldValue("habilitado" , false);
			datasetSegmentacion.fieldValue("secu" , "EMP_"+estrucNivEmpresa.getOIDInteger().toString());
			datasetSegmentacion.fieldValue("secu_padre" , "BASE");
			if (estrucNivEmpresa.getValor_clasif_empresa()!=null)
				datasetSegmentacion.fieldValue("oid_val_clasif_emp", estrucNivEmpresa.getValor_clasif_empresa().getOIDInteger());
			else
				datasetSegmentacion.fieldValue("oid_val_clasif_emp", "");
			datasetSegmentacion.fieldValue("oid_val_clasif_sec", "");
			datasetSegmentacion.fieldValue("oid_val_clasif_pue", "");
			datasetSegmentacion.fieldValue("orden", "");
			
			// Traer los sectores
			Iterator iterSectores = estrucNivEmpresa.getSectores().iterator();
			while (iterSectores.hasNext()) {
				EstrucNivSector estrucNivSector = (EstrucNivSector) iterSectores.next();
				datasetSegmentacion.append();
				datasetSegmentacion.fieldValue("oid_segmentacion", ++oidSegmentacion);
				datasetSegmentacion.fieldValue("oid_accion_cro", oidAccion);
				if (estrucNivSector.getValor_clasif_sector()!=null)
					datasetSegmentacion.fieldValue("descripcion", "     "+estrucNivSector.getValor_clasif_sector().getDescripcion());
				else
					datasetSegmentacion.fieldValue("descripcion", "");
				datasetSegmentacion.fieldValue("habilitado" , false);
				datasetSegmentacion.fieldValue("secu" , "SEC_"+estrucNivSector.getOIDInteger().toString());
				datasetSegmentacion.fieldValue("secu_padre" , "EMP_"+estrucNivEmpresa.getOIDInteger().toString());
				if (estrucNivEmpresa.getValor_clasif_empresa()!=null)
					datasetSegmentacion.fieldValue("oid_val_clasif_emp", estrucNivEmpresa.getValor_clasif_empresa().getOIDInteger());
				else
					datasetSegmentacion.fieldValue("oid_val_clasif_emp", "");
				if (estrucNivSector.getValor_clasif_sector()!=null)
					datasetSegmentacion.fieldValue("oid_val_clasif_sec", estrucNivSector.getValor_clasif_sector().getOIDInteger());
				else
					datasetSegmentacion.fieldValue("oid_val_clasif_sec", "");
				datasetSegmentacion.fieldValue("oid_val_clasif_pue", "");	
				datasetSegmentacion.fieldValue("orden", "");
				
				// Traer los puestos
				Iterator iterPuestos = estrucNivSector.getPuestos().iterator();
				while (iterPuestos.hasNext()) {
					EstrucNivPuesto estrucNivPuesto = (EstrucNivPuesto) iterPuestos.next();
					
					datasetSegmentacion.append();
					datasetSegmentacion.fieldValue("oid_segmentacion", ++oidSegmentacion);
					datasetSegmentacion.fieldValue("oid_accion_cro", oidAccion);
					if (estrucNivPuesto.getValor_clasif_puesto()!=null)
						datasetSegmentacion.fieldValue("descripcion", "          "+estrucNivPuesto.getValor_clasif_puesto().getDescripcion());
					else
						datasetSegmentacion.fieldValue("descripcion", "");
					
					
					boolean habilitado = false;
					datasetSegmentacion.fieldValue("habilitado" , habilitado);
					datasetSegmentacion.fieldValue("secu" , "PUE_"+estrucNivPuesto.getOIDInteger().toString());
					datasetSegmentacion.fieldValue("secu_padre" , "SEC_"+estrucNivSector.getOIDInteger().toString());
					if (estrucNivEmpresa.getValor_clasif_empresa()!=null)
						datasetSegmentacion.fieldValue("oid_val_clasif_emp", estrucNivEmpresa.getValor_clasif_empresa().getOIDInteger());
					else
						datasetSegmentacion.fieldValue("oid_val_clasif_emp", "");
					if (estrucNivSector.getValor_clasif_sector()!=null)
						datasetSegmentacion.fieldValue("oid_val_clasif_sec", estrucNivSector.getValor_clasif_sector().getOIDInteger());
					else
						datasetSegmentacion.fieldValue("oid_val_clasif_sec", "");
					if (estrucNivPuesto.getValor_clasif_puesto()!=null)
						datasetSegmentacion.fieldValue("oid_val_clasif_pue", estrucNivPuesto.getValor_clasif_puesto().getOIDInteger());
					else
						datasetSegmentacion.fieldValue("oid_val_clasif_pue", "");
					datasetSegmentacion.fieldValue("orden", "");
				}
				
			}
			
			
		}
	}
	
  
}
