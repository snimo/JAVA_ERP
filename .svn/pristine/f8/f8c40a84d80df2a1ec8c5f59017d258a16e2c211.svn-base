package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.AccesoValClasif;
import com.srn.erp.cip.bm.CategAccValClasif;
import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.MotAccInterClasifLeg;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDefAccesosClasifLeg extends Operation {

	public TraerDefAccesosClasifLeg() {
	}

	private HashTableDatos valoresPorMotivos = new HashTableDatos();
	private HashTableDatos motivos = new HashTableDatos();
	
	private HashTableDatos valoresPorCateroria = new HashTableDatos();
	private HashTableDatos categorias = new HashTableDatos();

	
	private void agregarValoresPorCategoria(CategAccValClasif categAccValClasif) throws BaseException {

		HashTableDatos listaValClasifByOid = (HashTableDatos) valoresPorCateroria.get(categAccValClasif.getCategoria().getOIDInteger());
		if (listaValClasifByOid == null) {
			listaValClasifByOid = new HashTableDatos();
			valoresPorCateroria.put(categAccValClasif.getCategoria().getOIDInteger(), listaValClasifByOid);
		}
		listaValClasifByOid.put(categAccValClasif.getVal_clasif_ent().getOIDInteger(), "");
		
	}
	
	private void agregarValoresPorMotivo(MotAccInterClasifLeg motAccInterClasifLeg) throws BaseException {

		HashTableDatos listaValClasifByOid = (HashTableDatos) valoresPorMotivos.get(motAccInterClasifLeg.getMotivo().getOIDInteger());
		if (listaValClasifByOid == null) {
			listaValClasifByOid = new HashTableDatos();
			valoresPorMotivos.put(motAccInterClasifLeg.getMotivo().getOIDInteger(), listaValClasifByOid);
		}
		listaValClasifByOid.put(motAccInterClasifLeg.getValorclasificador().getOIDInteger(), "");

	}

	private boolean encontroMotParaValorClasif(Integer oidMotivo,
			ValorClasificadorEntidad valor) throws BaseException {
		HashTableDatos listaValClasifByOid = (HashTableDatos) valoresPorMotivos.get(oidMotivo);
		if (listaValClasifByOid != null) {
			if (listaValClasifByOid.containsKey(valor.getOIDInteger()))
				return true;
		}
		return false;
	}
	
	private boolean encontroCategParaValorClasif(Integer oidCategoria,
					ValorClasificadorEntidad valor) throws BaseException {
		HashTableDatos listaValClasifByOid = (HashTableDatos) this.valoresPorCateroria.get(oidCategoria);
		if (listaValClasifByOid != null) {
			if (listaValClasifByOid.containsKey(valor.getOIDInteger()))
				return true;
		}
		return false;
	}
	

	private void cargarMotAccInterClasifLeg() throws BaseException {
		Iterator iterMotAccInterClasifLeg = MotAccInterClasifLeg.getAllActivos(
				this.getSesion()).iterator();
		while (iterMotAccInterClasifLeg.hasNext()) {
			MotAccInterClasifLeg motAccInterClasifLeg = (MotAccInterClasifLeg) iterMotAccInterClasifLeg
					.next();
			agregarValoresPorMotivo(motAccInterClasifLeg);
		}
	}
	
	private void cargarCategAccesooClasifLeg() throws BaseException {
		Iterator iterCategAccesoValClasif = CategAccValClasif.getCategoriasAccesoActivas(this.getSesion()).iterator();
		while (iterCategAccesoValClasif.hasNext()) {
			CategAccValClasif categAccValClasif = (CategAccValClasif) iterCategAccesoValClasif.next();
			agregarValoresPorCategoria(categAccValClasif);
		}
	}
	

	private void agregarMotivos() throws BaseException {
		Iterator iterMotEntInter = MotivoEntIntermedias
				.getMotivoEntIntermedias(this.getSesion()).iterator();
		while (iterMotEntInter.hasNext()) {
			MotivoEntIntermedias motivoEntIntermedias = (MotivoEntIntermedias) iterMotEntInter
					.next();
			motivos.put(motivoEntIntermedias.getOIDInteger(),
					motivoEntIntermedias.getDescripcion());
		}
	}
	
	private void agregarCategorias() throws BaseException {
		Iterator iterCategAcceso = CategAccesoCIP.getAllActivos(this.getSesion()).iterator();
		while (iterCategAcceso.hasNext()) {
			CategAccesoCIP categAccesoCIP = (CategAccesoCIP) iterCategAcceso.next();
			categorias.put(categAccesoCIP.getOIDInteger(),
					categAccesoCIP.getDescripcion());
		}
	}
	

	public void execute(MapDatos mapaDatos) throws BaseException {

		agregarMotivos();
		agregarCategorias();
		
		cargarMotAccInterClasifLeg();
		cargarCategAccesooClasifLeg();

		IDataSet dsClasifLeg = this.getDataSetClasifLegajo();
		IDataSet dsValClasifLeg = this.getDataSetValClasifLegajo();
		IDataSet dsControlAcceso = this.getDataSetControlAcceso();
		IDataSet dsMotAccClasifLeg = this.getDataSetMotAccInterVClasif();
		IDataSet dsCategAccesos = this.getDataSetCategAccesos();
		

		int secu = 1;
		Iterator iterClasif = ClasificadorEntidad.getClasificadoresEntidad(Legajo.NICKNAME, true, this.getSesion()).iterator();
		while (iterClasif.hasNext()) {

			ClasificadorEntidad clasif = (ClasificadorEntidad) iterClasif.next();
			cargarRegistroClasificador(dsClasifLeg, clasif);

			Iterator iterValClasif = clasif.getValoresClasificador().iterator();
			while (iterValClasif.hasNext()) {

				ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif.next();
				cargarRegistroValorClasificador(dsValClasifLeg, valClasifEnt);
				
				// Control de Acceso
				AccesoValClasif accesoValClasif = AccesoValClasif.getAccesoValClasif(valClasifEnt, this.getSesion()); 
				
				++secu;
				if (accesoValClasif!=null)
					cargarControlAcceso(
						dsControlAcceso, 
						secu, accesoValClasif.getTipo_ingreso(), accesoValClasif.getLey_no_ingreso(), accesoValClasif.getMin_ent_antes(), accesoValClasif.getMin_ent_despues(), accesoValClasif.getTipo_egreso(), accesoValClasif.getLey_no_egreso(), accesoValClasif.isAntipassback(), accesoValClasif.isCacheo(), accesoValClasif.getValor(), accesoValClasif.isActivo());
				else 
					cargarControlAcceso(
							dsControlAcceso, 
							secu, "", "", 0, 0, "", "", false, false, valClasifEnt, true);
				
				
				

				Iterator iterMotivos = motivos.keySet().iterator();
				while (iterMotivos.hasNext()) {
					Integer oidMotivo = (Integer) iterMotivos.next();
					String descMotivo = (String) motivos.get(oidMotivo);
					boolean habilitado = encontroMotParaValorClasif(oidMotivo,valClasifEnt);
					cargarMotAccInterVClasif(dsMotAccClasifLeg, ++secu,valClasifEnt, oidMotivo, descMotivo, habilitado);
				}
				
				Iterator iterCategorias = categorias.keySet().iterator();
				while (iterCategorias.hasNext()) {
					Integer oidCategoria = (Integer) iterCategorias.next();
					String descCategoria = (String) categorias.get(oidCategoria);
					boolean habilitado = encontroCategParaValorClasif(oidCategoria,valClasifEnt);
					cargarCategAccesso(dsCategAccesos, ++secu,++secu, oidCategoria.intValue(), 
							           descCategoria, valClasifEnt.getOIDInteger(), habilitado);
					
				}
				
				
			}
		}
		
		
		writeCliente(dsClasifLeg);
		writeCliente(dsValClasifLeg);
		writeCliente(dsControlAcceso);
		writeCliente(dsMotAccClasifLeg);
		writeCliente(dsCategAccesos);
		

	}

	private IDataSet getDataSetClasifLegajo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TClasifLegajo");
		dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	private IDataSet getDataSetCategAccesos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCategAccesos");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_categ_acc_vcla", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_categ_acceso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_categ_acceso", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarCategAccesso(IDataSet ds,
			int secu,
			int oidCategAccValClasif,
			int oidCategAccesso,
			String descCategAcceso,
			int oidValClasif,
			boolean activo) throws BaseException {
		
		ds.append();
		ds.fieldValue("secu", secu);
		ds.fieldValue("oid_categ_acc_vcla", oidCategAccValClasif);
		ds.fieldValue("oid_categ_acceso" , oidCategAccesso);
		ds.fieldValue("desc_categ_acceso", descCategAcceso);
		ds.fieldValue("oid_val_clasif_ent", oidValClasif);
		ds.fieldValue("activo", activo);
		
	}
	

	private IDataSet getDataSetValClasifLegajo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValClasifLegajo");
		dataset.fieldDef(new Field("oid_val_clasif_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetMotAccInterVClasif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotAccInterValClasif");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetControlAcceso() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAcceso");
		dataset.fieldDef(new Field("oid_val_acceso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_ingreso", Field.STRING, 20));
		dataset.fieldDef(new Field("ley_no_ingreso", Field.STRING, 100));
		dataset.fieldDef(new Field("min_ent_antes", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_despues", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_egreso", Field.STRING, 20));
		dataset.fieldDef(new Field("ley_no_egreso", Field.STRING, 100));
		dataset.fieldDef(new Field("antipassback", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cacheo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarControlAcceso(IDataSet ds,
			Integer oidValAcceso,
			String tipoIngreso,
			String leyNoIngreso,
			Integer minEntAntes,
			Integer minEntDespues,
			String tipoEgreso,
			String leyNoEgresa,
			boolean antipassback,
			boolean cacheo,
			ValorClasificadorEntidad valor,
			boolean activo) throws BaseException {
		
		ds.append();
		ds.fieldValue("oid_val_acceso", oidValAcceso);
		ds.fieldValue("tipo_ingreso", tipoIngreso);
		ds.fieldValue("ley_no_ingreso", leyNoIngreso);
		ds.fieldValue("min_ent_antes", minEntAntes);
		ds.fieldValue("min_ent_despues", minEntDespues);
		ds.fieldValue("tipo_egreso", tipoEgreso);
		ds.fieldValue("ley_no_egreso",leyNoEgresa);
		ds.fieldValue("antipassback", antipassback);
		ds.fieldValue("cacheo", cacheo);
		ds.fieldValue("oid_val_clasif", valor.getOIDInteger());
		ds.fieldValue("activo", activo);
		
		
	}
	

	private void cargarMotAccInterVClasif(IDataSet ds, int secu,
			ValorClasificadorEntidad valorClasif, Integer oidMotivo,
			String descMotivo, boolean habilitado) throws BaseException {

		ds.append();
		ds.fieldValue("secu", secu);
		ds.fieldValue("oid_val_clasif", valorClasif.getOIDInteger());
		ds.fieldValue("oid_motivo", oidMotivo);
		ds.fieldValue("descripcion", descMotivo);
		ds.fieldValue("habilitado", habilitado);
	}

	private void cargarRegistroClasificador(IDataSet dataset,
			ClasificadorEntidad clasificador) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_clasificador", clasificador.getOIDInteger());
		dataset.fieldValue("codigo", clasificador.getCodigo());
		dataset.fieldValue("descripcion", clasificador.getDescripcion());
	}

	private void cargarRegistroValorClasificador(IDataSet dataset,
			ValorClasificadorEntidad valorClasificadorEntidad)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_val_clasif_leg", valorClasificadorEntidad
				.getOIDInteger());
		dataset.fieldValue("oid_clasificador", valorClasificadorEntidad
				.getClasificador_entidad().getOIDInteger());
		dataset.fieldValue("codigo", valorClasificadorEntidad.getCodigo());
		dataset.fieldValue("descripcion", valorClasificadorEntidad
				.getDescripcion());
	}

}
