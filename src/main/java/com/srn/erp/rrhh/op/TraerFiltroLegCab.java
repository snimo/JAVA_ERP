package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.ClaseSindicato;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.FiltroValLegCab;
import com.srn.erp.rrhh.bm.PerfilFiltroLegajo;
import com.srn.erp.rrhh.bm.TareaDesempeneada;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFiltroLegCab extends Operation {

	public TraerFiltroLegCab() {
	}
	
	private int secu = 0;

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		
		if (mapaDatos.containsKey("TRAER_VAL_DATOS_FILTRO")) {
			Integer oidFiltroCab = mapaDatos.getInteger("oid_filtro");
			enviarValoresFiltros(oidFiltroCab); 
			return;
		}
		
		FiltroLegCab filtrolegcab = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			filtrolegcab = FiltroLegCab.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			filtrolegcab = FiltroLegCab.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetFiltroLegCab = getDataSetFiltroLegCab();
		IDataSet dsPerfiles = this.getDataSetPerfiles();
		
		if (filtrolegcab != null) {
			cargarRegistroFiltroLegCab(datasetFiltroLegCab, filtrolegcab.getOIDInteger(), filtrolegcab.getDescripcion(), filtrolegcab.isAplic_cons_rotas(), filtrolegcab.isAplic_busq_leg(), filtrolegcab.isActivo());
		}
		
		enviarValoresFiltros(filtrolegcab.getOIDInteger());
		
		Iterator iterPerfilesFiltro = 
			filtrolegcab.getPerfilesFiltro().iterator();
		while (iterPerfilesFiltro.hasNext()) {
			PerfilFiltroLegajo perfilFiltroLegajo = (PerfilFiltroLegajo) iterPerfilesFiltro.next();
			cargarPerfil(dsPerfiles, perfilFiltroLegajo);
		}
		
		writeCliente(datasetFiltroLegCab);
		writeCliente(dsPerfiles);
	}
	
	private void enviarValoresFiltros(Integer oidFiltroCab) throws BaseException {
		
		IDataSet dsEmpresa = getDataSetValoresEmpresa();
		IDataSet dsEstado = getDataSetValoresEstados();
		IDataSet dsSector = getDataSetValoresSectores();
		IDataSet dsPuesto = getDataSetValoresPuestos();
		IDataSet dsTareasDesemp = getDataSetValoresTareasDesemp();
		IDataSet dsClaseSindicatos = getDataSetValoresClasesSind();
		
		
		
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		
		Iterator iterValoresClasifEmp = 
			clasifEmpresa.getValoresClasificador().iterator();
		
		while (iterValoresClasifEmp.hasNext()) {
			ValorClasificadorEntidad valorClasificadorEntidad = (ValorClasificadorEntidad) iterValoresClasifEmp.next();
			cargarEmpresa(dsEmpresa, oidFiltroCab, valorClasificadorEntidad);
		}
		
		Iterator iterValoresClasifEst = 
			clasifEstado.getValoresClasificador().iterator();
		
		while (iterValoresClasifEst.hasNext()) {
			ValorClasificadorEntidad valorClasificadorEstado = (ValorClasificadorEntidad) iterValoresClasifEst.next();
			cargarEstado(dsEstado, oidFiltroCab, valorClasificadorEstado);
		}		
		
		Iterator iterValoresClasifSec = 
			clasifSector.getValoresClasificador().iterator();
		
		while (iterValoresClasifSec.hasNext()) {
			ValorClasificadorEntidad valorClasificadorSector = (ValorClasificadorEntidad) iterValoresClasifSec.next();
			cargarSectores(dsSector, oidFiltroCab, valorClasificadorSector);
		}		
		
		Iterator iterValoresClasifPue = 
			clasifPuesto.getValoresClasificador().iterator();
		
		while (iterValoresClasifPue.hasNext()) {
			ValorClasificadorEntidad valorClasificadorPuesto = (ValorClasificadorEntidad) iterValoresClasifPue.next();
			cargarPuesto(dsPuesto, oidFiltroCab, valorClasificadorPuesto);
		}		
		
		Iterator iterValoresTarea = 
			TareaDesempeneada.getAllTareas(this.getSesion()).iterator();
		
		while (iterValoresTarea.hasNext()) {
			TareaDesempeneada valorTarea = (TareaDesempeneada) iterValoresTarea.next();
			cargarTareaDesemp(dsTareasDesemp, oidFiltroCab, valorTarea);
		}		
		
		Iterator iterValoresSindicatos = 
			ClaseSindicato.getAllSindicatos(this.getSesion()).iterator();
		
		while (iterValoresSindicatos.hasNext()) {
			ClaseSindicato sindicato = (ClaseSindicato) iterValoresSindicatos.next();
			cargarClaseSindicato(dsClaseSindicatos, oidFiltroCab, sindicato);
		}		
		
		
		writeCliente(dsEmpresa);
		writeCliente(dsEstado);
		writeCliente(dsSector);
		writeCliente(dsPuesto);
		writeCliente(dsTareasDesemp);
		writeCliente(dsClaseSindicatos);		
		
		
		
	}
	
	private IDataSet getDataSetValoresEmpresa() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresEmpresa");
		dataset.fieldDef(new Field("oid_val_filtro_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_filtro_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetValoresEstados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresEstados");
		dataset.fieldDef(new Field("oid_val_filtro_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_filtro_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		return dataset;
	}	
	
	private IDataSet getDataSetPerfiles() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPerfilFilLegCab");
		dataset.fieldDef(new Field("oid_perfil_leg_filtro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_filtro_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_perfil", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	
	
	
	private IDataSet getDataSetValoresSectores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresSectores");
		dataset.fieldDef(new Field("oid_val_filtro_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_filtro_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetValoresTareasDesemp() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresTareasDesemp");
		dataset.fieldDef(new Field("oid_val_filtro_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_filtro_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		return dataset;
	}		
	
	private IDataSet getDataSetValoresClasesSind() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresClasesSind");
		dataset.fieldDef(new Field("oid_val_filtro_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_filtro_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		return dataset;
	}	
	
	
	private IDataSet getDataSetValoresPuestos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresPuestos");
		dataset.fieldDef(new Field("oid_val_filtro_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_filtro_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		return dataset;
	}	
	
	
	private void cargarEmpresa(IDataSet ds,Integer oidFiltro, ValorClasificadorEntidad valor) throws BaseException {
		ds.append();
		ds.fieldValue("oid_val_filtro_det", --secu);
		ds.fieldValue("oid_filtro_cab", oidFiltro);
		ds.fieldValue("oid_valor", valor.getOID());
		ds.fieldValue("tipo", "EMPRESA");
		ds.fieldValue("descripcion", valor.getDescripcion());
		
		FiltroValLegCab filtroValor = FiltroValLegCab.getFiltroValLegCab(FiltroLegCab.findByOidProxy(oidFiltro, this.getSesion()), "EMPRESA", valor.getOID(), this.getSesion());
		
		if ((filtroValor!=null) && (filtroValor.isActivo())) 
			ds.fieldValue("activo", true);
		else
			ds.fieldValue("activo", false);
		ds.fieldValue("codigo", valor.getCodigo());
		
	}
	

	private void cargarPerfil(IDataSet ds,PerfilFiltroLegajo perfilFiltro) throws BaseException {
		ds.append();
		ds.fieldValue("oid_perfil_leg_filtro", perfilFiltro.getOIDInteger());
		ds.fieldValue("oid_filtro_cab", perfilFiltro.getFiltro_legajo_cab().getOIDInteger());
		ds.fieldValue("oid_perfil", perfilFiltro.getPerfil().getOIDInteger());
		ds.fieldValue("activo", perfilFiltro.isActivo());
	}
	
	private void cargarPuesto(IDataSet ds,Integer oidFiltro, ValorClasificadorEntidad valor) throws BaseException {
		ds.append();
		ds.fieldValue("oid_val_filtro_det", --secu);
		ds.fieldValue("oid_filtro_cab", oidFiltro);
		ds.fieldValue("oid_valor", valor.getOID());
		ds.fieldValue("tipo", "PUESTO");
		ds.fieldValue("descripcion", valor.getDescripcion());
		
		FiltroValLegCab filtroValor = FiltroValLegCab.getFiltroValLegCab(FiltroLegCab.findByOidProxy(oidFiltro, this.getSesion()), "PUESTO", valor.getOID(), this.getSesion());
		
		if ((filtroValor!=null) && (filtroValor.isActivo())) 
			ds.fieldValue("activo", true);
		else
			ds.fieldValue("activo", false);		
		ds.fieldValue("codigo", valor.getCodigo());
		
	}	
	
	private void cargarTareaDesemp(IDataSet ds,Integer oidFiltro, TareaDesempeneada tarea) throws BaseException {
		ds.append();
		ds.fieldValue("oid_val_filtro_det", --secu);
		ds.fieldValue("oid_filtro_cab", oidFiltro);
		ds.fieldValue("oid_valor", tarea.getOID());
		ds.fieldValue("tipo", "TAREA");
		ds.fieldValue("descripcion", tarea.getDescripcion());
		
		FiltroValLegCab filtroValor = FiltroValLegCab.getFiltroValLegCab(FiltroLegCab.findByOidProxy(oidFiltro, this.getSesion()), "TAREA", tarea.getOID(), this.getSesion());
		
		if ((filtroValor!=null) && (filtroValor.isActivo())) 
			ds.fieldValue("activo", true);
		else
			ds.fieldValue("activo", false);		
		ds.fieldValue("codigo", tarea.getCodigo());
		
	}	
	
	private void cargarClaseSindicato(IDataSet ds,Integer oidFiltro, ClaseSindicato claseSindicato) throws BaseException {
		ds.append();
		ds.fieldValue("oid_val_filtro_det", --secu);
		ds.fieldValue("oid_filtro_cab", oidFiltro);
		ds.fieldValue("oid_valor", claseSindicato.getOID());
		ds.fieldValue("tipo", "SINDICATO");
		ds.fieldValue("descripcion", claseSindicato.getDescripcion());
		
		FiltroValLegCab filtroValor = FiltroValLegCab.getFiltroValLegCab(FiltroLegCab.findByOidProxy(oidFiltro, this.getSesion()), "SINDICATO", claseSindicato.getOID(), this.getSesion());
		
		if ((filtroValor!=null) && (filtroValor.isActivo())) 
			ds.fieldValue("activo", true);
		else
			ds.fieldValue("activo", false);		
		ds.fieldValue("codigo", claseSindicato.getCodigo());
		
	}	
	
	private void cargarSectores(IDataSet ds,Integer oidFiltro, ValorClasificadorEntidad valor) throws BaseException {
		ds.append();
		ds.fieldValue("oid_val_filtro_det", --secu);
		ds.fieldValue("oid_filtro_cab", oidFiltro);
		ds.fieldValue("oid_valor", valor.getOID());
		ds.fieldValue("tipo", "SECTOR");
		ds.fieldValue("descripcion", valor.getDescripcion());
		
		FiltroValLegCab filtroValor = FiltroValLegCab.getFiltroValLegCab(FiltroLegCab.findByOidProxy(oidFiltro, this.getSesion()), "SECTOR", valor.getOID(), this.getSesion());
		
		if ((filtroValor!=null) && (filtroValor.isActivo())) 
			ds.fieldValue("activo", true);
		else
			ds.fieldValue("activo", false);
		ds.fieldValue("codigo", valor.getCodigo());
		
	}	
	
	private void cargarEstado(IDataSet ds,Integer oidFiltro, ValorClasificadorEntidad valor) throws BaseException {
		ds.append();
		ds.fieldValue("oid_val_filtro_det", --secu);
		ds.fieldValue("oid_filtro_cab", oidFiltro);
		ds.fieldValue("oid_valor", valor.getOID());
		ds.fieldValue("tipo", "ESTADO");
		ds.fieldValue("descripcion", valor.getDescripcion());
		
		FiltroValLegCab filtroValor = FiltroValLegCab.getFiltroValLegCab(FiltroLegCab.findByOidProxy(oidFiltro, this.getSesion()), "ESTADO", valor.getOID(), this.getSesion());
		
		if ((filtroValor!=null) && (filtroValor.isActivo())) 
			ds.fieldValue("activo", true);
		else
			ds.fieldValue("activo", false);
		ds.fieldValue("codigo", valor.getCodigo());
		
	}	
	
 

	private IDataSet getDataSetFiltroLegCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFiltroLegCab");
		dataset.fieldDef(new Field("oid_filtro_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 250));
		dataset.fieldDef(new Field("aplic_cons_rotas", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("aplic_busq_leg", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroFiltroLegCab(IDataSet dataset, Integer oid_filtro_cab, String descripcion, Boolean aplic_cons_rotas, Boolean aplic_busq_leg, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_filtro_cab", oid_filtro_cab);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("aplic_cons_rotas", aplic_cons_rotas);
		dataset.fieldValue("aplic_busq_leg", aplic_busq_leg);
		dataset.fieldValue("activo", activo);
	}
}
