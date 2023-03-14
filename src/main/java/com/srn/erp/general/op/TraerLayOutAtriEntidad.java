package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.AtributoEnGrupo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadFijo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoHabilitadoEntidad;
import com.srn.erp.general.bm.Entidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLayOutAtriEntidad extends Operation {
	
	IDataSet dataSetHoja = null;
	IDataSet dataSetAtriHoja = null;

	public TraerLayOutAtriEntidad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String nickNameIdentifier = mapaDatos.getString("nickname");
		Entidad entidad = Entidad.getEntidad(nickNameIdentifier, getSesion());

		dataSetHoja = this.getDataSetHojas();
		dataSetAtriHoja = this.getDataAtriHoja();

		enviarHojasAtri(dataSetHoja, entidad);
		enviarAtributosHoja(dataSetAtriHoja, entidad);

		writeCliente(dataSetHoja);
		writeCliente(dataSetAtriHoja);
	}

	private IDataSet getDataAtriHoja() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAtributosEnHoja");
		dataset.fieldDef(new Field("oid_grupo_atributo_hoja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_hoja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_atributo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("mascara", Field.STRING, 100));
		dataset.fieldDef(new Field("F_V", Field.STRING, 1));
		return dataset;
	}

	private void cargarAtributosDeHoja(IDataSet dataset, 
			                               Integer oidGrupoAtriEntFijo,
			                               AtributoEnGrupo atributoEnGrupo) throws BaseException {
		dataset.append();		
		dataset.fieldValue("oid_grupo_atributo_hoja", atributoEnGrupo.getOIDInteger());
		dataset.fieldValue("oid_hoja", oidGrupoAtriEntFijo);
		dataset.fieldValue("orden", atributoEnGrupo.getSecu());
		dataset.fieldValue("nombre", atributoEnGrupo.getAtributo().getDescripcion());
		dataset.fieldValue("tipo", atributoEnGrupo.getAtributo().getTipo());
		dataset.fieldValue("oid_atributo", atributoEnGrupo.getAtributo().getOIDInteger());
		if (atributoEnGrupo.getAtributo().isValorCompo())
			dataset.fieldValue("oid_compo", atributoEnGrupo.getAtributo().getCompo().getOIDInteger());
		else
			dataset.fieldValue("oid_compo", new Integer(0));
		if (atributoEnGrupo.getFormato()!=null)
			dataset.fieldValue("mascara", atributoEnGrupo.getFormato());
		else
			dataset.fieldValue("mascara", "");
		dataset.fieldValue("F_V", "F");
	}
	
	private IDataSet getDataSetHojas() {
		IDataSet dataset = new TDataSet();
		dataset.create("THojasAtributos");
		dataset.fieldDef(new Field("oid_hoja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 50));
		dataset.fieldDef(new Field("F_V", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_grupo_atri_var",Field.INTEGER, 0));
		return dataset;
	}
	
	private void cargarHojaAtriFijo(IDataSet dataset, GrupoAtributoEntidadFijo grupoAtriEntFijo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_hoja", grupoAtriEntFijo.getOIDInteger());
		dataset.fieldValue("orden", grupoAtriEntFijo.getOrden());
		dataset.fieldValue("nombre", grupoAtriEntFijo.getNombre());
		dataset.fieldValue("F_V", "F");
		dataset.fieldValue("oid_grupo_atri_var",new Integer(0));
	}
	
	private void cargarHojaAtriVar(IDataSet dataset, GrupoAtributoEntidadVar grupoAtriEntVar) throws BaseException {
		Integer oidHoja = new Integer(grupoAtriEntVar.getOID()*-1);
		dataset.append();
		// Se multiplica por -1, para evitar que se duplique con los fijos
		dataset.fieldValue("oid_hoja", oidHoja);
		dataset.fieldValue("orden", new Integer(1));
		dataset.fieldValue("nombre", grupoAtriEntVar.getNombre());
		dataset.fieldValue("F_V", "V");
		dataset.fieldValue("oid_grupo_atri_var",grupoAtriEntVar.getOID());
		
		// Cargar los atributos
		Iterator iterGrupoAtriEntVar = grupoAtriEntVar.getGruposAtributosHabilitados().iterator();
		while (iterGrupoAtriEntVar.hasNext()) {
			GrupoHabilitadoEntidad grupoHabEnt = (GrupoHabilitadoEntidad) iterGrupoAtriEntVar.next();
			Iterator iterAtributosEnGrupo = grupoHabEnt.getGrupo_atributo().getAtributosEnGrupo().iterator();
			while (iterAtributosEnGrupo.hasNext()) {
				AtributoEnGrupo atributoEnGrupo = (AtributoEnGrupo) iterAtributosEnGrupo.next();			
				cargarAtributosDeHoja(this.dataSetAtriHoja,oidHoja,atributoEnGrupo);				
			}			
		}			
	}
	

	private void enviarHojasAtri(IDataSet dataSetHoja,
			                         Entidad entidad) throws BaseException {
		Iterator iterGruposAtriEntFijo = entidad.getGruposAtributosEntidadFijo().iterator();
		
		// Enviar Atributos Fijos de Entidad
		while (iterGruposAtriEntFijo.hasNext()) {
			GrupoAtributoEntidadFijo grupoAtriEntFijo = (GrupoAtributoEntidadFijo) iterGruposAtriEntFijo.next();
			cargarHojaAtriFijo(dataSetHoja, grupoAtriEntFijo);
		}
		
		// Enviar Atributos Variables de Entidad
		Iterator iterAtriEntVar = entidad.getGruposAtributosEntidadVar().iterator();
		while (iterAtriEntVar.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) iterAtriEntVar.next();
			cargarHojaAtriVar(dataSetHoja, grupoAtriEntVar);
		}
	}

	private void enviarAtributosHoja(IDataSet dataSetAtriHoja, Entidad entidad) throws BaseException {
		Iterator iterGruposAtriEntFijo = entidad.getGruposAtributosEntidadFijo().iterator();
		while (iterGruposAtriEntFijo.hasNext()) {
			GrupoAtributoEntidadFijo grupoAtriEntFijo = (GrupoAtributoEntidadFijo) iterGruposAtriEntFijo.next();

			// Devolver la Informacion de los Atributos de la Hoja
			Iterator iterAtriEnGrupo = grupoAtriEntFijo.getGrupo_atributo().getAtributosEnGrupo().iterator();
			while (iterAtriEnGrupo.hasNext()) {
				AtributoEnGrupo atributoEnGrupo = (AtributoEnGrupo) iterAtriEnGrupo.next();
				cargarAtributosDeHoja(dataSetAtriHoja,grupoAtriEntFijo.getOIDInteger(),atributoEnGrupo);
			}
		}
	}
	
	
	
	

}
