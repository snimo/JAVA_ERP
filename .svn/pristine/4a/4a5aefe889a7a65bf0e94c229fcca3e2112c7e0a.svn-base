package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.AtributoEntidadSeleccionado;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ConceptoCtaContable;
import com.srn.erp.contabilidad.bm.CriterioSelCuenta;
import com.srn.erp.contabilidad.bm.EstructuraCompo;
import com.srn.erp.contabilidad.bm.GenerarValorCompoCriImpu;
import com.srn.erp.contabilidad.bm.ValoresAtriCriterioImpu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConceptoCtaContable extends Operation {

	private int secu = 0;
	private int oidCompoAGenerar = 0;

	public TraerConceptoCtaContable() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		ConceptoCtaContable conceptoctacontable = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			conceptoctacontable = ConceptoCtaContable.findByOid(oid,
					getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			conceptoctacontable = ConceptoCtaContable.findByCodigo(codigo,
					getSesion());
		}

		IDataSet datasetConceptoCtaContable = getDataSetConceptoCtaContable();
		IDataSet datasetCriterios = getDataSetCriterioSelCta();
		IDataSet datasetAtriSel = getDataSetAtriEntSel();
		IDataSet datasetValAtriCriImpu = getDataSetValAtriCriImpu();
		IDataSet datasetInfoValAtri = getDataSetInfoValAtriCriImpu();
		IDataSet datasetGenerarCompo = getDataSetGenerarValCompoCriImpu();

		if (conceptoctacontable != null) {
			cargarRegistroConceptoCtaContable(datasetConceptoCtaContable,
					conceptoctacontable.getOIDInteger(), conceptoctacontable
							.getCodigo(), conceptoctacontable.getDescripcion(),
					conceptoctacontable.getNickname(), conceptoctacontable
							.isActivo());
			Iterator iterCriteriosSelCta = conceptoctacontable
					.getCriteriosSelCuenta().iterator();
			while (iterCriteriosSelCta.hasNext()) {
				CriterioSelCuenta criterioSelCta = (CriterioSelCuenta) iterCriteriosSelCta
						.next();
				cargarRegistroCriterioSelCta(datasetCriterios, criterioSelCta);

				enviarInfoAtributos(datasetInfoValAtri, criterioSelCta);

				Iterator iterAtriEntSel = criterioSelCta.getAtributosEntSel()
						.iterator();
				while (iterAtriEntSel.hasNext()) {
					AtributoEntidadSeleccionado atriEntSel = (AtributoEntidadSeleccionado) iterAtriEntSel
							.next();
					cargarRegistroAtriEntSel(datasetAtriSel, atriEntSel);
				}

				Iterator iterValAtriCriImpu = criterioSelCta
						.getValoresAtriCriterioImpu().iterator();
				while (iterValAtriCriImpu.hasNext()) {
					ValoresAtriCriterioImpu valAtriCriImpu = (ValoresAtriCriterioImpu) iterValAtriCriImpu
							.next();
					cargarRegistroValAtriCriImpu(datasetValAtriCriImpu,
							valAtriCriImpu);
					
					// Traer los componentes de la estructura de la cuenta
					if (valAtriCriImpu.isGenerarCuenta()) {
						
						if (valAtriCriImpu.getCuenta_contable().getEstructura()!=null) {
							Iterator iterEstrucCompo = 
								valAtriCriImpu.getCuenta_contable().getEstructura().getEstrucComponenentes().iterator();
							while (iterEstrucCompo.hasNext()) {
								EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
								GenerarValorCompoCriImpu genValorCompoCriImpu = getGenerarValor(valAtriCriImpu,estrucCompo.getComponente());
								--oidCompoAGenerar;
								Integer oid = new Integer(oidCompoAGenerar);
								if (genValorCompoCriImpu!=null)
									oid = genValorCompoCriImpu.getOIDInteger(); 
								cargarRegistroGenerarValCompoCriImpu(datasetGenerarCompo,valAtriCriImpu,oid,estrucCompo.getComponente(),genValorCompoCriImpu);
							}
						}
					}
					
					
				}
			}

		}
		writeCliente(datasetConceptoCtaContable);
		writeCliente(datasetCriterios);
		writeCliente(datasetAtriSel);
		writeCliente(datasetValAtriCriImpu);
		writeCliente(datasetInfoValAtri);
		writeCliente(datasetGenerarCompo);
	}
	
	private GenerarValorCompoCriImpu getGenerarValor(ValoresAtriCriterioImpu valoresAtriCriImpu,
			Componente componente) throws BaseException {
		Iterator iterValoresCompo = valoresAtriCriImpu.getGenerarValoresCompo().iterator();
		while (iterValoresCompo.hasNext()) {
			GenerarValorCompoCriImpu generarValor = (GenerarValorCompoCriImpu) iterValoresCompo.next();
			if (generarValor.getComponente().getOID()==componente.getOID())
				return generarValor;  
		}
		return null;
	}

	private void enviarInfoAtributos(IDataSet dataset,
			CriterioSelCuenta criterioSelCta) throws BaseException {

		String nombreAtri1 = "";
		String nombreAtri2 = "";
		String nombreAtri3 = "";
		String nombreAtri4 = "";
		String nombreAtri5 = "";

		String nickname1 = "";
		String nickname2 = "";
		String nickname3 = "";
		String nickname4 = "";
		String nickname5 = "";

		Integer oidAtriEnt1 = new Integer(0);
		Integer oidAtriEnt2 = new Integer(0);
		Integer oidAtriEnt3 = new Integer(0);
		Integer oidAtriEnt4 = new Integer(0);
		Integer oidAtriEnt5 = new Integer(0);

		int i = 0;

		Iterator iterAtributos = criterioSelCta.getAtributosEntSel().iterator();
		while (iterAtributos.hasNext()) {
			++i;
			AtributoEntidadSeleccionado atriSel = (AtributoEntidadSeleccionado) iterAtributos
					.next();
			if (i == 1) {
				nombreAtri1 = atriSel.getAtributo_entidad().getNombre_logico();
				nickname1 = atriSel.getAtributo_entidad().getNombeNickName();
				oidAtriEnt1 = atriSel.getAtributo_entidad().getOIDInteger();
			} else if (i == 2) {
				nombreAtri2 = atriSel.getAtributo_entidad().getNombre_logico();
				nickname2 = atriSel.getAtributo_entidad().getNombeNickName();
				oidAtriEnt2 = atriSel.getAtributo_entidad().getOIDInteger();
			} else if (i == 3) {
				nombreAtri3 = atriSel.getAtributo_entidad().getNombre_logico();
				nickname3 = atriSel.getAtributo_entidad().getNombeNickName();
				oidAtriEnt3 = atriSel.getAtributo_entidad().getOIDInteger();
			} else if (i == 4) {
				nombreAtri4 = atriSel.getAtributo_entidad().getNombre_logico();
				nickname4 = atriSel.getAtributo_entidad().getNombeNickName();
				oidAtriEnt4 = atriSel.getAtributo_entidad().getOIDInteger();
			} else if (i == 5) {
				nombreAtri5 = atriSel.getAtributo_entidad().getNombre_logico();
				nickname5 = atriSel.getAtributo_entidad().getNombeNickName();
				oidAtriEnt5 = atriSel.getAtributo_entidad().getOIDInteger();
			}
		}

		cargarRegistroInfoValAtriCriImpu(dataset, new Integer(secu),
				new Integer(criterioSelCta.getAtributosEntSel().size()),
				nombreAtri1, nombreAtri2, nombreAtri3, nombreAtri4,
				nombreAtri5, nickname1, nickname2, nickname3, nickname4,
				nickname5, oidAtriEnt1, oidAtriEnt2, oidAtriEnt3, oidAtriEnt4,
				oidAtriEnt5);
	}

	private IDataSet getDataSetConceptoCtaContable() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConceptoCtaContable");
		dataset.fieldDef(new Field("oid_conc_ctca", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetGenerarValCompoCriImpu() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGenValCompoCriImpu");
		dataset.fieldDef(new Field("oid_gen_val_compo", Field.STRING, 30));
		dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_compo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_val_atri_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_atri_ent", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroGenerarValCompoCriImpu(IDataSet dataset,
													  ValoresAtriCriterioImpu valAtriCriImpu,
													  Integer oid,	
			                                          Componente componente,
			                                          GenerarValorCompoCriImpu generarValorCompo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_gen_val_compo", oid);
		dataset.fieldValue("oid_compo", componente.getOIDInteger());
		dataset.fieldValue("desc_compo", componente.getDescripcion());
		if (generarValorCompo!=null) {
		  dataset.fieldValue("oid_val_atri_ent", valAtriCriImpu.getOIDInteger());
		  dataset.fieldValue("oid_atri_ent", generarValorCompo.getAtributo_entidad().getOIDInteger());
		  dataset.fieldValue("desc_atri_ent", generarValorCompo.getAtributo_entidad().getNombre_logico());
		} else {
		  dataset.fieldValue("oid_val_atri_ent", valAtriCriImpu.getOIDInteger());
		  dataset.fieldValue("oid_atri_ent", 0);
		  dataset.fieldValue("desc_atri_ent", "");
		}
	}
	

	private IDataSet getDataSetCriterioSelCta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCriterioSelCta");
		dataset.fieldDef(new Field("oid_cri_sel_cta", Field.STRING, 30));
		dataset.fieldDef(new Field("oid_conc_cta", Field.STRING, 30));
		dataset.fieldDef(new Field("orden", Field.STRING, 50));
		dataset.fieldDef(new Field("criterio", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroConceptoCtaContable(IDataSet dataset,
			Integer oid_conc_ctca, String codigo, String descripcion,
			String nickname, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_conc_ctca", oid_conc_ctca);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("nickname", nickname);
		dataset.fieldValue("activo", activo);
	}

	private void cargarRegistroCriterioSelCta(IDataSet dataset,
			CriterioSelCuenta criterio) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cri_sel_cta", criterio.getOIDInteger());
		dataset.fieldValue("oid_conc_cta", criterio.getConcepto_cuenta()
				.getOIDInteger());
		dataset.fieldValue("orden", criterio.getOrden());
		dataset.fieldValue("criterio", criterio.getCriterio());
		dataset.fieldValue("activo", criterio.isActivo());
	}

	private IDataSet getDataSetAtriEntSel() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAtriEntSel");
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_sel", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cri_sel_cta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_atri_ent", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroAtriEntSel(IDataSet dataset,
			AtributoEntidadSeleccionado atriEntSel) throws BaseException {
		dataset.append();
		dataset.fieldValue("orden", atriEntSel.getOrden());
		dataset.fieldValue("oid_atri_ent_sel", atriEntSel.getOIDInteger());
		dataset.fieldValue("oid_cri_sel_cta", atriEntSel
				.getCriterio_seleccion_cta().getOIDInteger());
		dataset.fieldValue("oid_atri_ent", atriEntSel.getAtributo_entidad()
				.getOIDInteger());
		dataset.fieldValue("desc_atri_ent", atriEntSel.getAtributo_entidad()
				.getNombre_logico());
		dataset.fieldValue("activo", new Boolean(true));
	}

	private void cargarRegistroInfoValAtriCriImpu(IDataSet dataset,
			Integer oid, Integer cantAtri, String nomAtri1, String nomAtri2,
			String nomAtri3, String nomAtri4, String nomAtri5,
			String nickName1, String nickName2, String nickName3,
			String nickName4, String nickName5, Integer oidAtriEnt1,
			Integer oidAtriEnt2, Integer oidAtriEnt3, Integer oidAtriEnt4,
			Integer oidAtriEnt5) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("cant_atributos", cantAtri);
		dataset.fieldValue("nombre_atributo_1", nomAtri1);
		dataset.fieldValue("nombre_atributo_2", nomAtri2);
		dataset.fieldValue("nombre_atributo_3", nomAtri3);
		dataset.fieldValue("nombre_atributo_4", nomAtri4);
		dataset.fieldValue("nombre_atributo_5", nomAtri5);
		dataset.fieldValue("nickname_1", nickName1);
		dataset.fieldValue("nickname_2", nickName2);
		dataset.fieldValue("nickname_3", nickName3);
		dataset.fieldValue("nickname_4", nickName4);
		dataset.fieldValue("nickname_5", nickName5);
		dataset.fieldValue("oid_atri_ent_1", oidAtriEnt1);
		dataset.fieldValue("oid_atri_ent_2", oidAtriEnt2);
		dataset.fieldValue("oid_atri_ent_3", oidAtriEnt3);
		dataset.fieldValue("oid_atri_ent_4", oidAtriEnt4);
		dataset.fieldValue("oid_atri_ent_5", oidAtriEnt5);

	}

	private IDataSet getDataSetInfoValAtriCriImpu() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInfoAtriSel");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_atributos", Field.INTEGER, 50));
		dataset.fieldDef(new Field("nombre_atributo_1", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_atributo_2", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_atributo_3", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_atributo_4", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_atributo_5", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_1", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_2", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_3", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_4", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_5", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_atri_ent_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_5", Field.INTEGER, 0));

		return dataset;
	}

	private IDataSet getDataSetValAtriCriImpu() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresAtriCriterioImpu");
		dataset.fieldDef(new Field("oid_val_atri_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cri_sel_cta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atri_ent_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nickname_1", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_2", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_3", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_4", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname_5", Field.STRING, 50));
		dataset.fieldDef(new Field("tomar_cuenta", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 50));
		dataset.fieldDef(new Field("cod_ana_imp", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_ana_imp", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_atri_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_atri_1", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_atri_1", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_atri_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_atri_2", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_atri_2", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_atri_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_atri_3", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_atri_3", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_atri_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_atri_4", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_atri_4", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_atri_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_atri_5", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_atri_5", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroValAtriCriImpu(IDataSet dataset,
			ValoresAtriCriterioImpu valAtricriImpu) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_val_atri_ent", valAtricriImpu.getOIDInteger());
		dataset.fieldValue("oid_cri_sel_cta", valAtricriImpu
				.getCriterio_sel_cta().getOIDInteger());
		if (valAtricriImpu.getAtri_ent_1() != null)
			dataset.fieldValue("oid_atri_ent_1", valAtricriImpu.getAtri_ent_1()
					.getOIDInteger());
		else
			dataset.fieldValue("oid_atri_ent_1", new Integer(0));
		if (valAtricriImpu.getAtri_ent_2() != null)
			dataset.fieldValue("oid_atri_ent_2", valAtricriImpu.getAtri_ent_2()
					.getOIDInteger());
		else
			dataset.fieldValue("oid_atri_ent_2", new Integer(0));
		if (valAtricriImpu.getAtri_ent_3() != null)
			dataset.fieldValue("oid_atri_ent_3", valAtricriImpu.getAtri_ent_3()
					.getOIDInteger());
		else
			dataset.fieldValue("oid_atri_ent_3", new Integer(0));
		if (valAtricriImpu.getAtri_ent_4() != null)
			dataset.fieldValue("oid_atri_ent_4", valAtricriImpu.getAtri_ent_4()
					.getOIDInteger());
		else
			dataset.fieldValue("oid_atri_ent_4", new Integer(0));
		if (valAtricriImpu.getAtri_ent_5() != null)
			dataset.fieldValue("oid_atri_ent_5", valAtricriImpu.getAtri_ent_5()
					.getOIDInteger());
		else
			dataset.fieldValue("oid_atri_ent_5", new Integer(0));
		if (valAtricriImpu.getAtri_ent_1() != null)
			dataset.fieldValue("nickname_1", valAtricriImpu.getAtri_ent_1()
					.getNombeNickName());
		else
			dataset.fieldValue("nickname_1", "");
		if (valAtricriImpu.getAtri_ent_2() != null)
			dataset.fieldValue("nickname_2", valAtricriImpu.getAtri_ent_2()
					.getNombeNickName());
		else
			dataset.fieldValue("nickname_2", "");
		if (valAtricriImpu.getAtri_ent_3() != null)
			dataset.fieldValue("nickname_3", valAtricriImpu.getAtri_ent_3()
					.getNombeNickName());
		else
			dataset.fieldValue("nickname_3", "");
		if (valAtricriImpu.getAtri_ent_4() != null)
			dataset.fieldValue("nickname_4", valAtricriImpu.getAtri_ent_4()
					.getNombeNickName());
		else
			dataset.fieldValue("nickname_4", "");
		if (valAtricriImpu.getAtri_ent_5() != null)
			dataset.fieldValue("nickname_5", valAtricriImpu.getAtri_ent_5()
					.getNombeNickName());
		else
			dataset.fieldValue("nickname_5", "");
		dataset.fieldValue("tomar_cuenta", valAtricriImpu.getTomar_cuenta());
		if (valAtricriImpu.getCuenta_imputable() != null) {
			dataset.fieldValue("oid_ai", valAtricriImpu.getCuenta_imputable()
					.getOID());
			dataset.fieldValue("cod_ana_imp", valAtricriImpu
					.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
			dataset.fieldValue("desc_ana_imp", valAtricriImpu
					.getCuenta_imputable().getDescCuentaMasDescValCompo());
		} else {
			dataset.fieldValue("oid_ai", 0);
			dataset.fieldValue("cod_ana_imp", "");
			dataset.fieldValue("desc_ana_imp", "");
		}
		if (valAtricriImpu.getCuenta_contable() != null) {
			dataset.fieldValue("oid_ana_con", valAtricriImpu
					.getCuenta_contable().getOIDInteger());
			dataset.fieldValue("cod_ana_con", valAtricriImpu
					.getCuenta_contable().getCodigo());
			dataset.fieldValue("desc_ana_con", valAtricriImpu
					.getCuenta_contable().getDescripcion());
		} else {
			dataset.fieldValue("oid_ana_con", 0);
			dataset.fieldValue("cod_ana_con", "");
			dataset.fieldValue("desc_ana_con", "");
		}
		
		//
		if (valAtricriImpu.getVal_atri_1() != null) {
			dataset.fieldValue("oid_val_atri_1", valAtricriImpu.getVal_atri_1()
					.getOIDInteger());
			dataset.fieldValue("cod_val_atri_1", valAtricriImpu.getVal_atri_1()
					.getCodigo());
			dataset.fieldValue("desc_val_atri_1", valAtricriImpu
					.getVal_atri_1().getDescripcion());
		} else {
			dataset.fieldValue("oid_val_atri_1", new Integer(0));
			dataset.fieldValue("cod_val_atri_1", "");
			dataset.fieldValue("desc_val_atri_1", "");
		}
		if (valAtricriImpu.getVal_atri_2() != null) {
			dataset.fieldValue("oid_val_atri_2", valAtricriImpu.getVal_atri_2()
					.getOIDInteger());
			dataset.fieldValue("cod_val_atri_2", valAtricriImpu.getVal_atri_2()
					.getCodigo());
			dataset.fieldValue("desc_val_atri_2", valAtricriImpu
					.getVal_atri_2().getDescripcion());
		} else {
			dataset.fieldValue("oid_val_atri_2", new Integer(0));
			dataset.fieldValue("cod_val_atri_2", "");
			dataset.fieldValue("desc_val_atri_2", "");
			;
		}
		if (valAtricriImpu.getVal_atri_3() != null) {
			dataset.fieldValue("oid_val_atri_3", valAtricriImpu.getVal_atri_3()
					.getOIDInteger());
			dataset.fieldValue("cod_val_atri_3", valAtricriImpu.getVal_atri_3()
					.getCodigo());
			dataset.fieldValue("desc_val_atri_1", valAtricriImpu
					.getVal_atri_3().getDescripcion());
		} else {
			dataset.fieldValue("oid_val_atri_3", new Integer(0));
			dataset.fieldValue("cod_val_atri_3", "");
			dataset.fieldValue("desc_val_atri_3", "");
			;
		}
		if (valAtricriImpu.getVal_atri_4() != null) {
			dataset.fieldValue("oid_val_atri_4", valAtricriImpu.getVal_atri_4()
					.getOIDInteger());
			dataset.fieldValue("cod_val_atri_4", valAtricriImpu.getVal_atri_4()
					.getCodigo());
			dataset.fieldValue("desc_val_atri_4", valAtricriImpu
					.getVal_atri_4().getDescripcion());
		} else {
			dataset.fieldValue("oid_val_atri_4", new Integer(0));
			dataset.fieldValue("cod_val_atri_4", "");
			dataset.fieldValue("desc_val_atri_4", "");
			;
		}
		if (valAtricriImpu.getVal_atri_5() != null) {
			dataset.fieldValue("oid_val_atri_5", valAtricriImpu.getVal_atri_5()
					.getOIDInteger());
			dataset.fieldValue("cod_val_atri_5", valAtricriImpu.getVal_atri_5()
					.getCodigo());
			dataset.fieldValue("desc_val_atri_5", valAtricriImpu
					.getVal_atri_5().getDescripcion());
		} else {
			dataset.fieldValue("oid_val_atri_5", new Integer(0));
			dataset.fieldValue("cod_val_atri_5", "");
			dataset.fieldValue("desc_val_atri_5", "");
			;
		}

	}

}
