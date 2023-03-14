package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.AccesoInternoPuerta;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.PermisoInternoEmpresa;
import com.srn.erp.cip.bm.PermisoInternoEstado;
import com.srn.erp.cip.bm.PermisoInternoLegajo;
import com.srn.erp.cip.bm.PermisoInternoPuesto;
import com.srn.erp.cip.bm.PermisoInternoSector;
import com.srn.erp.cip.bm.PermisosInternos;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPermisosInternos extends Operation {

	public TraerPermisosInternos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("ALTA_REGLA")) {
			Integer oidRegla = mapaDatos.getInteger("oid_regla");
			inicioAltaRegla(oidRegla);
			return;
		}

		PermisosInternos permisosinternos = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			permisosinternos = PermisosInternos.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			permisosinternos = PermisosInternos.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetPermisosInternos = getDataSetPermisosInternos();
		IDataSet datasetReglas = getDataSetReglasPermisosInt();
		IDataSet datasetAccIntPue = getDataSetAccesoIntPuerta();
		IDataSet datasetPermIntLeg = getDataSetPermisisosIntLeg();
		IDataSet datasetPermIntEmp = getDataSetPermisosIntEmp("TPermisoIntEmp");
		IDataSet datasetPermIntSec = getDataSetPermisosIntSec("TPermisoIntSec");
		IDataSet datasetPermIntPue = getDataSetPermisosIntPue("TPermisoIntPue");
		IDataSet datasetPermIntEst = getDataSetPermisosIntEst("TPermisoIntEst");

		if (permisosinternos != null) {

			cargarRegistroPermisosInternos(datasetPermisosInternos, permisosinternos);

			Iterator iterReglas = permisosinternos.getReglas().iterator();
			while (iterReglas.hasNext()) {
				ReglasPermisosInt reglasPermisosInt = (ReglasPermisosInt) iterReglas.next();
				cargarRegistroReglasPermisosInt(datasetReglas, reglasPermisosInt);

				Iterator iterAccIntPue = reglasPermisosInt.getAccesosInternosPuertas().iterator();
				while (iterAccIntPue.hasNext()) {
					AccesoInternoPuerta accIntPue = (AccesoInternoPuerta) iterAccIntPue.next();
					cargarRegistroAccesoIntPuerta(datasetAccIntPue, accIntPue);
				}

				Iterator iterAccIntLeg = reglasPermisosInt.getAccesosInternosLegajos().iterator();
				while (iterAccIntLeg.hasNext()) {
					PermisoInternoLegajo permisoIntLegajo = (PermisoInternoLegajo) iterAccIntLeg.next();
					cargarRegistroReglasPermisosIntLeg(datasetPermIntLeg, permisoIntLegajo);
				}

				HashTableDatos indiceEmpresas = new HashTableDatos();
				Iterator iterAcceIntEmp = reglasPermisosInt.getAccesosInternosEmpresas().iterator();
				while (iterAcceIntEmp.hasNext()) {
					PermisoInternoEmpresa permisoIntEmp = (PermisoInternoEmpresa) iterAcceIntEmp.next();
					indiceEmpresas.put(permisoIntEmp.getVal_clasif_empresa().getOIDInteger(), permisoIntEmp);
				}

				int id = 0;
				ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
				Iterator iterValorClasif = clasifEmpresa.getValoresClasificador().iterator();
				while (iterValorClasif.hasNext()) {
					ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) iterValorClasif.next();
					--id;

					boolean activo = false;

					if (indiceEmpresas.get(valorClasifEnt.getOIDInteger()) != null)
						activo = true;

					if (valorClasifEnt.isActivo()) {
						cargarRegistroPermisosIntEmp(datasetPermIntEmp, id, reglasPermisosInt.getOIDInteger(), valorClasifEnt, activo);
					}
				}
				
				
				HashTableDatos indiceSectores = new HashTableDatos();
				Iterator iterAcceIntSec = reglasPermisosInt.getAccesosInternosSectores().iterator();
				while (iterAcceIntSec.hasNext()) {
					PermisoInternoSector permisoIntSec = (PermisoInternoSector) iterAcceIntSec.next();
					indiceSectores.put(permisoIntSec.getVal_clasif_sector().getOIDInteger(), permisoIntSec);
				}

				int idSector = 0;
				ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
				Iterator iterValorClasifSec = clasifSector.getValoresClasificador().iterator();
				while (iterValorClasifSec.hasNext()) {
					ValorClasificadorEntidad valorClasifSec = (ValorClasificadorEntidad) iterValorClasifSec.next();
					--id;

					boolean activo = false;

					if (indiceSectores.get(valorClasifSec.getOIDInteger()) != null)
						activo = true;

					if (valorClasifSec.isActivo()) {
						cargarRegistroPermisosIntSec(datasetPermIntSec, id, reglasPermisosInt.getOIDInteger(), valorClasifSec, activo);
					}
				}
				
				HashTableDatos indicePuestos = new HashTableDatos();
				Iterator iterAcceIntPue = reglasPermisosInt.getAccesosInternosPuestos().iterator();
				while (iterAcceIntPue.hasNext()) {
					PermisoInternoPuesto permisoIntPue = (PermisoInternoPuesto) iterAcceIntPue.next();
					indicePuestos.put(permisoIntPue.getVal_clasif_puesto().getOIDInteger(), permisoIntPue);
				}

				int idPuesto = 0;
				ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
				Iterator iterValorClasifPue = clasifPuesto.getValoresClasificador().iterator();
				while (iterValorClasifPue.hasNext()) {
					ValorClasificadorEntidad valorClasifPue = (ValorClasificadorEntidad) iterValorClasifPue.next();
					--id;

					boolean activo = false;

					if (indicePuestos.get(valorClasifPue.getOIDInteger()) != null)
						activo = true;

					if (valorClasifPue.isActivo()) {
						cargarRegistroPermisosIntPue(datasetPermIntPue, id, reglasPermisosInt.getOIDInteger(), valorClasifPue, activo);
					}
				}				
				
				
				HashTableDatos indiceEstados = new HashTableDatos();
				Iterator iterAcceIntEst = reglasPermisosInt.getAccesosInternosEstados().iterator();
				while (iterAcceIntEst.hasNext()) {
					PermisoInternoEstado permisoIntEst = (PermisoInternoEstado) iterAcceIntEst.next();
					indiceEstados.put(permisoIntEst.getEstado_cip().getOIDInteger(), permisoIntEst);
				}

				int idEstado = 0;
				Iterator iterEstadoCIP = EstadoCIP.getAllEstadosCIP(this.getSesion()).iterator();
				while (iterEstadoCIP.hasNext()) {
					EstadoCIP estadoCIP = (EstadoCIP) iterEstadoCIP.next();
					--idEstado;

					boolean activo = false;

					if (indiceEstados.get(estadoCIP.getOIDInteger()) != null)
						activo = true;

					if (estadoCIP.isActivo()) {
						cargarRegistroEstadosCIP(
								datasetPermIntEst,
								idEstado,
								reglasPermisosInt.getOIDInteger(),
								estadoCIP.getOIDInteger(),
								estadoCIP.getDescripcion(), 
								activo);
					}
				}				
				
				
				
				
				

			}

		}

		writeCliente(datasetPermisosInternos);
		writeCliente(datasetReglas);
		writeCliente(datasetAccIntPue);
		writeCliente(datasetPermIntLeg);
		writeCliente(datasetPermIntEmp);
		writeCliente(datasetPermIntSec);
		writeCliente(datasetPermIntPue);
		writeCliente(datasetPermIntEst);

	}

	private IDataSet getDataSetPermisosInternos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPermisosInternos");
		dataset.fieldDef(new Field("oid_permiso_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prioridad", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetPermisosIntEmp(String tabla) {
		IDataSet dataset = new TDataSet();
		dataset.create(tabla);
		dataset.fieldDef(new Field("oid_perm_int_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_regla_permiso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif_emp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif_emp", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetPermisosIntSec(String tabla) {
		IDataSet dataset = new TDataSet();
		dataset.create(tabla);
		dataset.fieldDef(new Field("oid_perm_int_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_regla_permiso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif_sec", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif_sec", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	
	private IDataSet getDataSetPermisosIntPue(String tabla) {
		IDataSet dataset = new TDataSet();
		dataset.create(tabla);
		dataset.fieldDef(new Field("oid_perm_int_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_regla_permiso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif_pue", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif_pue", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	
	
	
	private IDataSet getDataSetPermisosIntEst(String tabla) {
		IDataSet dataset = new TDataSet();
		dataset.create(tabla);
		dataset.fieldDef(new Field("oid_perm_int_est", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_regla_permiso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_estado", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	

	private void cargarRegistroPermisosIntEmp(IDataSet dataset, Integer oidPermIntEmp, Integer oidReglaPermiso, ValorClasificadorEntidad valor, boolean activo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_perm_int_emp", oidPermIntEmp);
		dataset.fieldValue("oid_regla_permiso", oidReglaPermiso);
		dataset.fieldValue("oid_val_clasif_emp", valor.getOIDInteger());
		dataset.fieldValue("cod_val_clasif_emp", valor.getCodigo());
		dataset.fieldValue("desc_val_clasif_emp", valor.getDescripcion());
		dataset.fieldValue("activo", activo);
	}

	private void cargarRegistroPermisosIntSec(IDataSet dataset, Integer oidPermIntSec, Integer oidReglaPermiso, ValorClasificadorEntidad valor, boolean activo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_perm_int_sec", oidPermIntSec);
		dataset.fieldValue("oid_regla_permiso", oidReglaPermiso);
		dataset.fieldValue("oid_val_clasif_sec", valor.getOIDInteger());
		dataset.fieldValue("cod_val_clasif_sec", valor.getCodigo());
		dataset.fieldValue("desc_val_clasif_sec", valor.getDescripcion());
		dataset.fieldValue("activo", activo);
	}
	
	private void cargarRegistroPermisosIntPue(IDataSet dataset, Integer oidPermIntPue, Integer oidReglaPermiso, ValorClasificadorEntidad valor, boolean activo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_perm_int_pue", oidPermIntPue);
		dataset.fieldValue("oid_regla_permiso", oidReglaPermiso);
		dataset.fieldValue("oid_val_clasif_pue", valor.getOIDInteger());
		dataset.fieldValue("cod_val_clasif_pue", valor.getCodigo());
		dataset.fieldValue("desc_val_clasif_pue", valor.getDescripcion());
		dataset.fieldValue("activo", activo);
	}	

	private void cargarRegistroPermisosInternos(IDataSet dataset, PermisosInternos permisos) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_permiso_int", permisos.getOIDInteger());
		dataset.fieldValue("codigo", permisos.getCodigo());
		dataset.fieldValue("descripcion", permisos.getDescripcion());
		dataset.fieldValue("activo", permisos.isActivo());
		dataset.fieldValue("prioridad", permisos.getPrioridad());
		
	}

	private IDataSet getDataSetReglasPermisosInt() {
		IDataSet dataset = new TDataSet();
		dataset.create("TReglasPermisosInt");
		dataset.fieldDef(new Field("oid_regla_permiso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_permiso_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("prioridad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("es_una_vista", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroReglasPermisosInt(IDataSet dataset, ReglasPermisosInt reglas) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_regla_permiso", reglas.getOIDInteger());
		dataset.fieldValue("oid_permiso_int", reglas.getPermisosinternos().getOIDInteger());
		dataset.fieldValue("prioridad", reglas.getPrioridad());
		dataset.fieldValue("descripcion", reglas.getDescripcion());
		dataset.fieldValue("es_una_vista", reglas.isEs_una_vista());
		dataset.fieldValue("activo", reglas.isActivo());
	}

	private IDataSet getDataSetAccesoIntPuerta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAccesoInternoPuerta");
		dataset.fieldDef(new Field("oid_acc_int_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_regla_permiso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precond_entrada", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_compo_entra", Field.STRING, 20));
		dataset.fieldDef(new Field("precond_salida", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_compo_sali", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cod_puerta", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_puerta", Field.STRING, 100));
		dataset.fieldDef(new Field("mensaje_entrada", Field.STRING, 100));
		dataset.fieldDef(new Field("mensaje_salida", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo_ctrl_fh_ent", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo_ctrl_fh_sal", Field.STRING, 100));
		dataset.fieldDef(new Field("min_ent_ant_fh_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_fh_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_ant_fh_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_fh_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("SAL_SEXO", Field.STRING, 50));
		dataset.fieldDef(new Field("ENT_SEXO", Field.STRING, 50));
		
		return dataset;
	}

	private IDataSet getDataSetPermisisosIntLeg() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPermisoIntLeg");
		dataset.fieldDef(new Field("oid_perm_int_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_regla_permiso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroReglasPermisosIntLeg(IDataSet dataset, PermisoInternoLegajo permisoIntLeg) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_perm_int_leg", permisoIntLeg.getOIDInteger());
		dataset.fieldValue("oid_regla_permiso", permisoIntLeg.getRegla_permiso().getOIDInteger());
		dataset.fieldValue("oid_legajo", permisoIntLeg.getLegajo().getOID());
		dataset.fieldValue("legajo", permisoIntLeg.getLegajo().getNro_legajo());
		dataset.fieldValue("ape_y_nom", permisoIntLeg.getLegajo().getApellidoyNombre());
		dataset.fieldValue("activo", permisoIntLeg.isActivo());

	}
	
	private void cargarRegistroEstadosCIP(IDataSet dataset, 
										Integer oid_perm_int_est,
										Integer oid_regla_permiso,
										Integer oidEstado,
										String descEstado,
										Boolean activo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_perm_int_est", oid_perm_int_est);
		dataset.fieldValue("oid_regla_permiso", oid_regla_permiso);
		dataset.fieldValue("oid_estado", oidEstado);
		dataset.fieldValue("desc_estado", descEstado);
		dataset.fieldValue("activo", activo);
	}	

	private void cargarRegistroAccesoIntPuerta(IDataSet dataset, AccesoInternoPuerta accesoIntPuerta) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_acc_int_pue", accesoIntPuerta.getOIDInteger());

		dataset.fieldValue("secu", accesoIntPuerta.getSecu());
		dataset.fieldValue("oid_regla_permiso", accesoIntPuerta.getRegla().getOIDInteger());
		dataset.fieldValue("oid_puerta", accesoIntPuerta.getPuerta().getOIDInteger());
		dataset.fieldValue("precond_entrada", accesoIntPuerta.getPrecond_entrada());
		dataset.fieldValue("tipo_compo_entra", accesoIntPuerta.getTipo_compo_entra());
		dataset.fieldValue("precond_salida", accesoIntPuerta.getPrecond_salida());
		dataset.fieldValue("tipo_compo_sali", accesoIntPuerta.getTipo_compo_sali());
		dataset.fieldValue("activo", accesoIntPuerta.isActivo());
		dataset.fieldValue("cod_puerta", accesoIntPuerta.getPuerta().getCodigo());
		dataset.fieldValue("desc_puerta", accesoIntPuerta.getPuerta().getDescripcion());
		dataset.fieldValue("mensaje_entrada", accesoIntPuerta.getMensajeEntrada());
		dataset.fieldValue("mensaje_salida", accesoIntPuerta.getMensajeSalida());
		dataset.fieldValue("tipo_ctrl_fh_ent", accesoIntPuerta.getTipoCtrlFhEnt());
		dataset.fieldValue("tipo_ctrl_fh_sal", accesoIntPuerta.getTipoCtrlFhSal());
		dataset.fieldValue("min_ent_ant_fh_ent", accesoIntPuerta.getMinEntAntFhEnt());
		dataset.fieldValue("min_ent_des_fh_ent", accesoIntPuerta.getMinEntDesFhEnt());
		dataset.fieldValue("min_ent_ant_fh_sal", accesoIntPuerta.getMinEntAntFhSal());
		dataset.fieldValue("min_ent_des_fh_sal", accesoIntPuerta.getMinEntDesFhSal());
		dataset.fieldValue("SAL_SEXO", accesoIntPuerta.getSalSexo());
		dataset.fieldValue("ENT_SEXO", accesoIntPuerta.getEntSexo());
		

	}

	private void inicioAltaRegla(Integer oidRegla) throws BaseException {

		IDataSet dsEmpresa = getDataSetPermisosIntEmp("TTempPermisoIntEmp");
		IDataSet dsSector = getDataSetPermisosIntSec("TTempPermisoIntSec");
		IDataSet dsPuesto = getDataSetPermisosIntPue("TTempPermisoIntPue");
		IDataSet dsEstado = getDataSetPermisosIntEst("TTempPermisoIntEst");

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		Iterator iterValorClasif = clasifEmpresa.getValoresClasificador().iterator();
		int id = 0;
		while (iterValorClasif.hasNext()) {
			ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) iterValorClasif.next();
			--id;
			if (valorClasifEnt.isActivo()) {
				cargarRegistroPermisosIntEmp(dsEmpresa, id, oidRegla, valorClasifEnt, false);
			}
		}

		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		Iterator iterValorClasifSec = clasifSector.getValoresClasificador().iterator();
		int idSector = 0;
		while (iterValorClasifSec.hasNext()) {
			ValorClasificadorEntidad valorClasifEntSec = (ValorClasificadorEntidad) iterValorClasifSec.next();
			--idSector;
			if (valorClasifEntSec.isActivo()) {
				cargarRegistroPermisosIntSec(dsSector, idSector, oidRegla, valorClasifEntSec, false);
			}
		}
		
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		Iterator iterValorClasifPue = clasifPuesto.getValoresClasificador().iterator();
		int idPuesto = 0;
		while (iterValorClasifPue.hasNext()) {
			ValorClasificadorEntidad valorClasifEntPue = (ValorClasificadorEntidad) iterValorClasifPue.next();
			--idPuesto;
			if (valorClasifEntPue.isActivo()) {
				cargarRegistroPermisosIntPue(dsPuesto, idPuesto, oidRegla, valorClasifEntPue, false);
			}
		}		
		
		int idEstado = 0;
		Iterator iterEstadosCIP = 
			EstadoCIP.getAllEstadosCIP(this.getSesion()).iterator();
		while (iterEstadosCIP.hasNext()) {
			EstadoCIP estadoCIP = (EstadoCIP) iterEstadosCIP.next();
			cargarRegistroEstadosCIP(dsEstado,idEstado,oidRegla,estadoCIP.getOID(),estadoCIP.getDescripcion(),false);
		}
		
		writeCliente(dsEmpresa);
		writeCliente(dsSector);
		writeCliente(dsPuesto);
		writeCliente(dsEstado);

	}

}
