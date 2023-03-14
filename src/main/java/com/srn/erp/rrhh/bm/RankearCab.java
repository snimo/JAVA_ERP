package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class RankearCab extends ObjetoLogico {

	public RankearCab() {
	}

	public static String NICKNAME = "rh.RankearCab";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Boolean rank_por_ant_emp;
	private Money ptos_ant_emp;
	private String uniTiempoAntEmp;
	private Money pond_ant_emp;
	private Boolean rank_por_ant_pue;
	private Money ptos_ant_pue;
	private String ut_ant_pue;
	private Money pond_ant_pue;
	private Boolean rank_por_novedad;
	private Boolean rank_por_eval;
	private Integer eval_ult_meses;
	private Money eval_calif_punto;
	private Money eval_ponderacion;
	private Boolean cm_ant_req_emp;
	private Integer cm_cant_req_emp;
	private String cm_ut_req_emp;
	private Boolean cm_ant_req_pue;
	private Integer cm_cant_req_pue;
	private String cm_ut_req_pue;
	private Boolean cm_aplicar_eval;
	private Money cm_puntaje_eval;
	private Boolean cm_aplic_nov_1;
	private Integer cm_dias_nov_1;
	private Integer cm_ult_mes_nov_1;
	private String cm_motivos_1;
	private Boolean cm_aplic_nov_2;
	private Integer cm_dias_nov_2;
	private Integer cm_ult_mes_nov_2;
	private String cm_motivos_2;
	private Boolean cm_aplic_nov_3;
	private Integer cm_dias_nov_3;
	private Integer cm_ult_mes_nov_3;
	private String cm_motivos_3;
	private Boolean cm_aplic_nov_4;
	private Integer cm_dias_nov_4;
	private Integer cm_ult_mes_nov_4;
	private String cm_motivos_4;
	private Boolean cm_aplic_nov_5;
	private Integer cm_dias_nov_5;
	private Integer cm_ult_mes_nov_5;
	private String cm_motivos_5;
	private Boolean cm_aplic_nov_6;
	private Integer cm_dias_nov_6;
	private Integer cm_ult_mes_nov_6;
	private String cm_motivos_6;
	private Boolean cm_aplic_nov_7;
	private Integer cm_dias_nov_7;
	private Integer cm_ult_mes_nov_7;
	private String cm_motivos_7;
	private Boolean cm_aplic_nov_8;
	private Integer cm_dias_nov_8;
	private Integer cm_ult_mes_nov_8;
	private String cm_motivos_8;
	private Boolean cm_aplic_nov_9;
	private Integer cm_dias_nov_9;
	private Integer cm_ult_mes_nov_9;
	private String cm_motivos_9;
	private Boolean cm_aplic_nov_10;
	private Integer cm_dias_nov_10;
	private Integer cm_ult_mes_nov_10;
	private String cm_motivos_10;
	private Boolean aplicCalifGral;
	private Money ptosMinCalifGral;
	private Boolean cm_aplic_juegos_a;
	private Boolean cm_aplic_hor_car;
	private Boolean desapruebaSiSancRestanMas;
	private Boolean desapruebaSiNoveRestanMas;
	private Money ptosMaxDesapruebaSanc;
	private Money ptosMaxDesapruebaNov;

	private Boolean rankearPorSancion;
	private Boolean controlarEstDesa;

	private List rankNovedades = new ArrayList();
	private boolean readRankNovedades = true;

	private List condMinimasNecesarias = new ArrayList();
	private boolean readCondMinimasNecesarias = true;

	private List rankSanciones = new ArrayList();
	private boolean readSanciones = true;

	private List rankCondMinSanciones = new ArrayList();
	private boolean readCondMinSanciones = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public Boolean isAplicClasifGral() throws BaseException {
		supportRefresh();
		if (aplicCalifGral==null)
			return false;
		else
			return this.aplicCalifGral;
	}
	
	public Money getPtosMinCalifGral() throws BaseException {
		supportRefresh();
		return this.ptosMinCalifGral;
	}
	
	public boolean IsDesapruebaSiSancRestanMas() throws BaseException {
		this.supportRefresh();
		if (desapruebaSiSancRestanMas==null)
			return false;
		else
			return desapruebaSiSancRestanMas;
	}
	
	public void setDesapruebaSiSancRestanMas(Boolean desaprueba) throws BaseException {
		this.desapruebaSiSancRestanMas = desaprueba;
	}
	
	public boolean IsDesapruebaSiNoveRestanMas() throws BaseException {
		this.supportRefresh();
		if (desapruebaSiNoveRestanMas==null)
			return false;
		else
			return desapruebaSiNoveRestanMas;
	}
	
	public void setDesapruebaSiNoveRestanMas(Boolean desaprueba) throws BaseException {
		this.desapruebaSiNoveRestanMas = desaprueba;
	}
	
	public Money getPtosMaxDesapruebaSanc() throws BaseException {
		this.supportRefresh();
		return ptosMaxDesapruebaSanc;
	}
	
	public void setPtosMaxDesapruebaSanc(Money puntos) throws BaseException {
		this.ptosMaxDesapruebaSanc = puntos;
	}
	
	
	public Money getPtosMaxDesapruebaNov() throws BaseException {
		this.supportRefresh();
		return ptosMaxDesapruebaNov;
	}
	
	public void setPtosMaxDesapruebaNov(Money puntos) throws BaseException {
		this.ptosMaxDesapruebaNov = puntos;
	}
	
	public Boolean isAplicHoriCarrera() throws BaseException {
		supportRefresh();
		return this.cm_aplic_hor_car;
	}
	
	public void setAplicHoriCarrera(Boolean aAplicHoriCarrera) throws BaseException {
		this.cm_aplic_hor_car = aAplicHoriCarrera;
	}
	
	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setPtosMinCalifGral(Money aPtosMinCalifGral) {
		this.ptosMinCalifGral = aPtosMinCalifGral;
	}
	
	
	public void setAplicCaligGral(Boolean aAplicCaligGral) {
		this.aplicCalifGral = aAplicCaligGral;
	}
	

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public Boolean isControlarEstadoDesa() throws BaseException {
		supportRefresh();
		return this.controlarEstDesa;
	}
	
	public Boolean isAplicCMJuegosA() throws BaseException {
		supportRefresh();
		if (cm_aplic_juegos_a==null)
			return false;
		else
			return this.cm_aplic_juegos_a;
	}
	
	public void setAplicCMJuegosA(Boolean aAplicCMJuegosA) throws BaseException {
		this.cm_aplic_juegos_a = aAplicCMJuegosA;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public void setControlarEstadoDesa(Boolean aControlarEstadoDesa) {
		this.controlarEstDesa = aControlarEstadoDesa;
	}

	public Boolean isRankearPorSancion() throws BaseException {
		supportRefresh();
		return this.rankearPorSancion;
	}

	public void setRankearPorSancion(Boolean aRankearPorSancion) {
		this.rankearPorSancion = aRankearPorSancion;
	}

	public Boolean isRank_por_ant_emp() throws BaseException {
		supportRefresh();
		return rank_por_ant_emp;
	}

	public void setRank_por_ant_emp(Boolean aRank_por_ant_emp) {
		this.rank_por_ant_emp = aRank_por_ant_emp;
	}

	public Money getPtos_ant_emp() throws BaseException {
		supportRefresh();
		return ptos_ant_emp;
	}

	public void setPtos_ant_emp(Money aPtos_ant_emp) {
		this.ptos_ant_emp = aPtos_ant_emp;
	}

	public String getUnitiempoantemp() throws BaseException {
		supportRefresh();
		return uniTiempoAntEmp;
	}

	public void setUnitiempoantemp(String aUnitiempoantemp) {
		this.uniTiempoAntEmp = aUnitiempoantemp;
	}

	public Money getPond_ant_emp() throws BaseException {
		supportRefresh();
		return pond_ant_emp;
	}

	public void setPond_ant_emp(Money aPond_ant_emp) {
		this.pond_ant_emp = aPond_ant_emp;
	}

	public Boolean isRank_por_ant_pue() throws BaseException {
		supportRefresh();
		return rank_por_ant_pue;
	}

	public void setRank_por_ant_pue(Boolean aRank_por_ant_pue) {
		this.rank_por_ant_pue = aRank_por_ant_pue;
	}

	public Money getPtos_ant_pue() throws BaseException {
		supportRefresh();
		return ptos_ant_pue;
	}

	public void setPtos_ant_pue(Money aPtos_ant_pue) {
		this.ptos_ant_pue = aPtos_ant_pue;
	}

	public String getUt_ant_pue() throws BaseException {
		supportRefresh();
		return ut_ant_pue;
	}

	public void setUt_ant_pue(String aUt_ant_pue) {
		this.ut_ant_pue = aUt_ant_pue;
	}

	public Money getPond_ant_pue() throws BaseException {
		supportRefresh();
		return pond_ant_pue;
	}

	public void setPond_ant_pue(Money aPond_ant_pue) {
		this.pond_ant_pue = aPond_ant_pue;
	}

	public Boolean isRank_por_novedad() throws BaseException {
		supportRefresh();
		return rank_por_novedad;
	}

	public void setRank_por_novedad(Boolean aRank_por_novedad) {
		this.rank_por_novedad = aRank_por_novedad;
	}

	public Boolean isRank_por_eval() throws BaseException {
		supportRefresh();
		return rank_por_eval;
	}

	public void setRank_por_eval(Boolean aRank_por_eval) {
		this.rank_por_eval = aRank_por_eval;
	}

	public Integer getEval_ult_meses() throws BaseException {
		supportRefresh();
		if (eval_ult_meses==null)
			return 0;
		else
			return eval_ult_meses;
	}

	public void setEval_ult_meses(Integer aEval_ult_meses) {
		this.eval_ult_meses = aEval_ult_meses;
	}

	public Money getEval_calif_punto() throws BaseException {
		supportRefresh();
		return eval_calif_punto;
	}

	public void setEval_calif_punto(Money aEval_calif_punto) {
		this.eval_calif_punto = aEval_calif_punto;
	}

	public Money getEval_ponderacion() throws BaseException {
		supportRefresh();
		return eval_ponderacion;
	}

	public void setEval_ponderacion(Money aEval_ponderacion) {
		this.eval_ponderacion = aEval_ponderacion;
	}

	public Boolean isCm_ant_req_emp() throws BaseException {
		supportRefresh();
		return cm_ant_req_emp;
	}

	public void setCm_ant_req_emp(Boolean aCm_ant_req_emp) {
		this.cm_ant_req_emp = aCm_ant_req_emp;
	}

	public Integer getCm_cant_req_emp() throws BaseException {
		supportRefresh();
		return cm_cant_req_emp;
	}

	public void setCm_cant_req_emp(Integer aCm_cant_req_emp) {
		this.cm_cant_req_emp = aCm_cant_req_emp;
	}

	public String getCm_ut_req_emp() throws BaseException {
		supportRefresh();
		return cm_ut_req_emp;
	}

	public void setCm_ut_req_emp(String aCm_ut_req_emp) {
		this.cm_ut_req_emp = aCm_ut_req_emp;
	}

	public Boolean isCm_ant_req_pue() throws BaseException {
		supportRefresh();
		return cm_ant_req_pue;
	}

	public void setCm_ant_req_pue(Boolean aCm_ant_req_pue) {
		this.cm_ant_req_pue = aCm_ant_req_pue;
	}

	public Integer getCm_cant_req_pue() throws BaseException {
		supportRefresh();
		return cm_cant_req_pue;
	}

	public void setCm_cant_req_pue(Integer aCm_cant_req_pue) {
		this.cm_cant_req_pue = aCm_cant_req_pue;
	}

	public String getCm_ut_req_pue() throws BaseException {
		supportRefresh();
		return cm_ut_req_pue;
	}

	public void setCm_ut_req_pue(String aCm_ut_req_pue) {
		this.cm_ut_req_pue = aCm_ut_req_pue;
	}

	public Boolean isCm_aplicar_eval() throws BaseException {
		supportRefresh();
		return cm_aplicar_eval;
	}

	public void setCm_aplicar_eval(Boolean aCm_aplicar_eval) {
		this.cm_aplicar_eval = aCm_aplicar_eval;
	}

	public Money getCm_puntaje_eval() throws BaseException {
		supportRefresh();
		return cm_puntaje_eval;
	}

	public void setCm_puntaje_eval(Money aCm_puntaje_eval) {
		this.cm_puntaje_eval = aCm_puntaje_eval;
	}

	public Boolean isCm_aplic_nov_1() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_1;
	}

	public void setCm_aplic_nov_1(Boolean aCm_aplic_nov_1) {
		this.cm_aplic_nov_1 = aCm_aplic_nov_1;
	}

	public Integer getCm_dias_nov_1() throws BaseException {
		supportRefresh();
		return cm_dias_nov_1;
	}

	public void setCm_dias_nov_1(Integer aCm_dias_nov_1) {
		this.cm_dias_nov_1 = aCm_dias_nov_1;
	}

	public Integer getCm_ult_mes_nov_1() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_1;
	}

	public void setCm_ult_mes_nov_1(Integer aCm_ult_mes_nov_1) {
		this.cm_ult_mes_nov_1 = aCm_ult_mes_nov_1;
	}

	public String getCm_motivos_1() throws BaseException {
		supportRefresh();
		return cm_motivos_1;
	}

	public void setCm_motivos_1(String aCm_motivos_1) {
		this.cm_motivos_1 = aCm_motivos_1;
	}

	public Boolean isCm_aplic_nov_2() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_2;
	}

	public void setCm_aplic_nov_2(Boolean aCm_aplic_nov_2) {
		this.cm_aplic_nov_2 = aCm_aplic_nov_2;
	}

	public Integer getCm_dias_nov_2() throws BaseException {
		supportRefresh();
		return cm_dias_nov_2;
	}

	public void setCm_dias_nov_2(Integer aCm_dias_nov_2) {
		this.cm_dias_nov_2 = aCm_dias_nov_2;
	}

	public Integer getCm_ult_mes_nov_2() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_2;
	}

	public void setCm_ult_mes_nov_2(Integer aCm_ult_mes_nov_2) {
		this.cm_ult_mes_nov_2 = aCm_ult_mes_nov_2;
	}

	public String getCm_motivos_2() throws BaseException {
		supportRefresh();
		return cm_motivos_2;
	}

	public void setCm_motivos_2(String aCm_motivos_2) {
		this.cm_motivos_2 = aCm_motivos_2;
	}

	public Boolean isCm_aplic_nov_3() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_3;
	}

	public void setCm_aplic_nov_3(Boolean aCm_aplic_nov_3) {
		this.cm_aplic_nov_3 = aCm_aplic_nov_3;
	}

	public Integer getCm_dias_nov_3() throws BaseException {
		supportRefresh();
		return cm_dias_nov_3;
	}

	public void setCm_dias_nov_3(Integer aCm_dias_nov_3) {
		this.cm_dias_nov_3 = aCm_dias_nov_3;
	}

	public Integer getCm_ult_mes_nov_3() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_3;
	}

	public void setCm_ult_mes_nov_3(Integer aCm_ult_mes_nov_3) {
		this.cm_ult_mes_nov_3 = aCm_ult_mes_nov_3;
	}

	public String getCm_motivos_3() throws BaseException {
		supportRefresh();
		return cm_motivos_3;
	}

	public void setCm_motivos_3(String aCm_motivos_3) {
		this.cm_motivos_3 = aCm_motivos_3;
	}

	public Boolean isCm_aplic_nov_4() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_4;
	}

	public void setCm_aplic_nov_4(Boolean aCm_aplic_nov_4) {
		this.cm_aplic_nov_4 = aCm_aplic_nov_4;
	}

	public Integer getCm_dias_nov_4() throws BaseException {
		supportRefresh();
		return cm_dias_nov_4;
	}

	public void setCm_dias_nov_4(Integer aCm_dias_nov_4) {
		this.cm_dias_nov_4 = aCm_dias_nov_4;
	}

	public Integer getCm_ult_mes_nov_4() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_4;
	}

	public void setCm_ult_mes_nov_4(Integer aCm_ult_mes_nov_4) {
		this.cm_ult_mes_nov_4 = aCm_ult_mes_nov_4;
	}

	public String getCm_motivos_4() throws BaseException {
		supportRefresh();
		return cm_motivos_4;
	}

	public void setCm_motivos_4(String aCm_motivos_4) {
		this.cm_motivos_4 = aCm_motivos_4;
	}

	public Boolean isCm_aplic_nov_5() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_5;
	}

	public void setCm_aplic_nov_5(Boolean aCm_aplic_nov_5) {
		this.cm_aplic_nov_5 = aCm_aplic_nov_5;
	}

	public Integer getCm_dias_nov_5() throws BaseException {
		supportRefresh();
		return cm_dias_nov_5;
	}

	public void setCm_dias_nov_5(Integer aCm_dias_nov_5) {
		this.cm_dias_nov_5 = aCm_dias_nov_5;
	}

	public Integer getCm_ult_mes_nov_5() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_5;
	}

	public void setCm_ult_mes_nov_5(Integer aCm_ult_mes_nov_5) {
		this.cm_ult_mes_nov_5 = aCm_ult_mes_nov_5;
	}

	public String getCm_motivos_5() throws BaseException {
		supportRefresh();
		return cm_motivos_5;
	}

	public void setCm_motivos_5(String aCm_motivos_5) {
		this.cm_motivos_5 = aCm_motivos_5;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RankearCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RankearCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RankearCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RankearCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RankearCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RankearCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");

		if (this.isCm_aplic_nov_1() && (this.isCm_aplic_nov_1()!=null)) {
			if (this.getCm_motivos_1() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Novedad 1");
		}
		
		if (this.isCm_aplic_nov_2() && (this.isCm_aplic_nov_2()!=null)) {
			if (this.getCm_motivos_2() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Novedad 2");
		}
		
		if (this.isCm_aplic_nov_3() && (this.isCm_aplic_nov_3()!=null)) {
			if (this.getCm_motivos_3() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Novedad 3");
		}
		
		if (this.isCm_aplic_nov_4() && (this.isCm_aplic_nov_4()!=null)) {
			if (this.getCm_motivos_4() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Novedad 4");
		}
		
		if (this.isCm_aplic_nov_5() && (this.isCm_aplic_nov_5()!=null)) {
			if (this.getCm_motivos_5() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Novedad 5");
		}
		
		if (this.isCm_aplic_nov_6() && (this.isCm_aplic_nov_6()!=null)) {
			if (this.getCm_motivos_6() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Sanción 1");
		}
		
		if (this.isCm_aplic_nov_7() && (this.isCm_aplic_nov_7()!=null)) {
			if (this.getCm_motivos_7() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Sanción 2");
		}
		
		if (this.isCm_aplic_nov_8() && (this.isCm_aplic_nov_8()!=null)) {
			if (this.getCm_motivos_8() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Sanción 3");
		}
		
		if (this.isCm_aplic_nov_9() && (this.isCm_aplic_nov_9()!=null)) {
			if (this.getCm_motivos_9() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Sanción 4");
		}
		
		if (this.isCm_aplic_nov_10() && (this.isCm_aplic_nov_10()!=null)) {
			if (this.getCm_motivos_10() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Motivo de la Sanción 5");
		}
		
		
		
	}

	public void afterSave() throws BaseException {

		Iterator iterRankNovedades = this.rankNovedades.iterator();
		while (iterRankNovedades.hasNext()) {
			RankearNovedad rankNovedad = (RankearNovedad) iterRankNovedades.next();
			rankNovedad.save();
			rankNovedad = null;
		}
		iterRankNovedades = null;

		Iterator iterCondMinNecesarias = this.condMinimasNecesarias.iterator();
		while (iterCondMinNecesarias.hasNext()) {
			CondMinRankeador condMinRankeador = (CondMinRankeador) iterCondMinNecesarias.next();
			condMinRankeador.save();
			condMinRankeador = null;
		}
		iterCondMinNecesarias = null;

		Iterator iterSanciones = this.rankSanciones.iterator();
		while (iterSanciones.hasNext()) {
			SancionRankear sancionRankear = (SancionRankear) iterSanciones.next();
			sancionRankear.save();
			sancionRankear = null;
		}
		iterSanciones = null;

		Iterator iterCondMinSanciones = this.rankCondMinSanciones.iterator();
		while (iterCondMinSanciones.hasNext()) {
			CondMinSancion condMinSancion = (CondMinSancion) iterCondMinSanciones.next();
			condMinSancion.save();
			condMinSancion = null;
		}
		iterCondMinSanciones = null;

	}

	public List getRankNovedades() throws BaseException {
		if (this.readRankNovedades == true) {
			rankNovedades.addAll(RankearNovedad.getRankearNovedades(this, getSesion()));
			this.readRankNovedades = false;
			return rankNovedades;
		} else
			return rankNovedades;
	}

	public List getRankCondMinSancion() throws BaseException {
		if (this.readCondMinSanciones == true) {
			rankCondMinSanciones.addAll(CondMinSancion.getCondMinSanciones(this, getSesion()));
			this.readCondMinSanciones = false;
			return rankCondMinSanciones;
		} else
			return rankCondMinSanciones;
	}

	public void addRankNovedad(RankearNovedad aRankearNovedad) throws BaseException {
		this.rankNovedades.add(aRankearNovedad);
		aRankearNovedad.setRankear(this);
	}

	public void addRankSancion(SancionRankear aSancionRankear) throws BaseException {
		this.rankSanciones.add(aSancionRankear);
		aSancionRankear.setOid_rankear(this);
	}

	public void addCondMinSancion(CondMinSancion aCondMinSancion) throws BaseException {
		this.rankCondMinSanciones.add(aCondMinSancion);
		aCondMinSancion.setRankear(this);
	}

	public void addCondMinRankeador(CondMinRankeador aCondMinRank) throws BaseException {
		this.condMinimasNecesarias.add(aCondMinRank);
		aCondMinRank.setRankear(this);
	}

	public Boolean isCm_aplic_nov_6() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_6;
	}

	public void setCm_aplic_nov_6(Boolean aCm_aplic_nov_6) {
		this.cm_aplic_nov_6 = aCm_aplic_nov_6;
	}

	public Integer getCm_dias_nov_6() throws BaseException {
		supportRefresh();
		return cm_dias_nov_6;
	}

	public void setCm_dias_nov_6(Integer aCm_dias_nov_6) {
		this.cm_dias_nov_6 = aCm_dias_nov_6;
	}

	public Integer getCm_ult_mes_nov_6() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_6;
	}

	public void setCm_ult_mes_nov_6(Integer aCm_ult_mes_nov_6) {
		this.cm_ult_mes_nov_6 = aCm_ult_mes_nov_6;
	}

	public String getCm_motivos_6() throws BaseException {
		supportRefresh();
		return cm_motivos_6;
	}

	public void setCm_motivos_6(String aCm_motivos_6) {
		this.cm_motivos_6 = aCm_motivos_6;
	}

	public Boolean isCm_aplic_nov_7() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_7;
	}

	public void setCm_aplic_nov_7(Boolean aCm_aplic_nov_7) {
		this.cm_aplic_nov_7 = aCm_aplic_nov_7;
	}

	public Integer getCm_dias_nov_7() throws BaseException {
		supportRefresh();
		return cm_dias_nov_7;
	}

	public void setCm_dias_nov_7(Integer aCm_dias_nov_7) {
		this.cm_dias_nov_7 = aCm_dias_nov_7;
	}

	public Integer getCm_ult_mes_nov_7() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_7;
	}

	public void setCm_ult_mes_nov_7(Integer aCm_ult_mes_nov_7) {
		this.cm_ult_mes_nov_7 = aCm_ult_mes_nov_7;
	}

	public String getCm_motivos_7() throws BaseException {
		supportRefresh();
		return cm_motivos_7;
	}

	public void setCm_motivos_7(String aCm_motivos_7) {
		this.cm_motivos_7 = aCm_motivos_7;
	}

	public Boolean isCm_aplic_nov_8() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_8;
	}

	public void setCm_aplic_nov_8(Boolean aCm_aplic_nov_8) {
		this.cm_aplic_nov_8 = aCm_aplic_nov_8;
	}

	public Integer getCm_dias_nov_8() throws BaseException {
		supportRefresh();
		return cm_dias_nov_8;
	}

	public void setCm_dias_nov_8(Integer aCm_dias_nov_8) {
		this.cm_dias_nov_8 = aCm_dias_nov_8;
	}

	public Integer getCm_ult_mes_nov_8() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_8;
	}

	public void setCm_ult_mes_nov_8(Integer aCm_ult_mes_nov_8) {
		this.cm_ult_mes_nov_8 = aCm_ult_mes_nov_8;
	}

	public String getCm_motivos_8() throws BaseException {
		supportRefresh();
		return cm_motivos_8;
	}

	public void setCm_motivos_8(String aCm_motivos_8) {
		this.cm_motivos_8 = aCm_motivos_8;
	}

	public Boolean isCm_aplic_nov_9() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_9;
	}

	public void setCm_aplic_nov_9(Boolean aCm_aplic_nov_9) {
		this.cm_aplic_nov_9 = aCm_aplic_nov_9;
	}

	public Integer getCm_dias_nov_9() throws BaseException {
		supportRefresh();
		return cm_dias_nov_9;
	}

	public void setCm_dias_nov_9(Integer aCm_dias_nov_9) {
		this.cm_dias_nov_9 = aCm_dias_nov_9;
	}

	public Integer getCm_ult_mes_nov_9() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_9;
	}

	public void setCm_ult_mes_nov_9(Integer aCm_ult_mes_nov_9) {
		this.cm_ult_mes_nov_9 = aCm_ult_mes_nov_9;
	}

	public String getCm_motivos_9() throws BaseException {
		supportRefresh();
		return cm_motivos_9;
	}

	public void setCm_motivos_9(String aCm_motivos_9) {
		this.cm_motivos_9 = aCm_motivos_9;
	}

	public Boolean isCm_aplic_nov_10() throws BaseException {
		supportRefresh();
		return cm_aplic_nov_10;
	}

	public void setCm_aplic_nov_10(Boolean aCm_aplic_nov_10) {
		this.cm_aplic_nov_10 = aCm_aplic_nov_10;
	}

	public Integer getCm_dias_nov_10() throws BaseException {
		supportRefresh();
		return cm_dias_nov_10;
	}

	public void setCm_dias_nov_10(Integer aCm_dias_nov_10) {
		this.cm_dias_nov_10 = aCm_dias_nov_10;
	}

	public Integer getCm_ult_mes_nov_10() throws BaseException {
		supportRefresh();
		return cm_ult_mes_nov_10;
	}

	public void setCm_ult_mes_nov_10(Integer aCm_ult_mes_nov_10) {
		this.cm_ult_mes_nov_10 = aCm_ult_mes_nov_10;
	}

	public String getCm_motivos_10() throws BaseException {
		supportRefresh();
		return cm_motivos_10;
	}

	public void setCm_motivos_10(String aCm_motivos_10) {
		this.cm_motivos_10 = aCm_motivos_10;
	}

}
