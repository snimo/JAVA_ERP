package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEmpresaConciTar extends Operation {

	public TraerEmpresaConciTar() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EmpresaConciTar empresaconcitar = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			empresaconcitar = EmpresaConciTar.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			empresaconcitar = EmpresaConciTar.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetEmpresaConciTar = getDataSetEmpresaConciTar();
		if (empresaconcitar != null) {
			cargarRegistroEmpresaConciTar(datasetEmpresaConciTar, empresaconcitar);
		}
		writeCliente(datasetEmpresaConciTar);
	}

	private IDataSet getDataSetEmpresaConciTar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEmpresaConciTar");
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
		dataset.fieldDef(new Field("cuit", Field.STRING, 50));
		dataset.fieldDef(new Field("cod_comercio", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ult_nro_conci", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_emp_arch_tarj", Field.STRING, 10));
		dataset.fieldDef(new Field("tipo_asi_cob", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_asi_liqui", Field.STRING, 20));
		dataset.fieldDef(new Field("cod_emp_interfaz", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_docu_asi_cob", Field.STRING, 20));
		dataset.fieldDef(new Field("uni_conta_asi_cob", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_docu_asi_liq", Field.STRING, 20));
		dataset.fieldDef(new Field("uni_conta_asi_liq", Field.STRING, 20));
		return dataset;
	}

	private void cargarRegistroEmpresaConciTar(IDataSet dataset, EmpresaConciTar empresaConciTar) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_empresa", empresaConciTar.getOIDInteger());
		dataset.fieldValue("razon_social", empresaConciTar.getRazon_social());
		dataset.fieldValue("cuit", empresaConciTar.getCuit());
		dataset.fieldValue("cod_comercio", empresaConciTar.getCodComercio());
		dataset.fieldValue("activo", empresaConciTar.isActivo());
		dataset.fieldValue("ult_nro_conci", empresaConciTar.getUltNroConci());
		dataset.fieldValue("cod_emp_arch_tarj", empresaConciTar.getCodEmpArchImpTarj());
		dataset.fieldValue("tipo_asi_cob", empresaConciTar.getTipoAsiCob());
		dataset.fieldValue("tipo_asi_liqui", empresaConciTar.getTipoAsiLiq());
		dataset.fieldValue("cod_emp_interfaz", empresaConciTar.getCodEmpInterfaz());
		dataset.fieldValue("tipo_docu_asi_cob", empresaConciTar.getTipoDocuAsiCobranza());
		dataset.fieldValue("uni_conta_asi_cob", empresaConciTar.getUniContaAsiCobranza());
		dataset.fieldValue("tipo_docu_asi_liq", empresaConciTar.getTipoDocuAsiLiquidacion());
		dataset.fieldValue("uni_conta_asi_liq", empresaConciTar.getUnidadContaAsiLiq());		
	}
}
