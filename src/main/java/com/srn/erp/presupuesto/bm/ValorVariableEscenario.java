package com.srn.erp.presupuesto.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.da.DBValorVariableEscenario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ValorVariableEscenario extends ObjetoLogico {

	public ValorVariableEscenario() {
	}

	public static String					NICKNAME	= "pl.ValorVariableEscenario";

	private PeriodoPresupuestario	periodo;

	private ValorCompoPresu				valor_compo_1;

	private ValorCompoPresu				valor_compo_2;

	private ValorCompoPresu				valor_compo_3;

	private ValorCompoPresu				valor_compo_4;

	private ValorCompoPresu				valor_compo_5;

	private ValorCompoPresu				valor_compo_6;

	private ValorCompoPresu				valor_compo_7;

	private ValorCompoPresu				valor_compo_8;

	private ValorCompoPresu				valor_compo_9;

	private Money									valor;
	
	private VarEscenarioCab 			varEscenarioCab;

	public PeriodoPresupuestario getPeriodo() throws BaseException {
		supportRefresh();
		return periodo;
	}

	public void setPeriodo(PeriodoPresupuestario aPeriodo) {
		this.periodo = aPeriodo;
	}
	
	public VarEscenarioCab getVariableEscenario() throws BaseException {
		supportRefresh();
		return this.varEscenarioCab;
	}

	public void setVariableEscenario(VarEscenarioCab aVarEscenarioCab) {
		this.varEscenarioCab = aVarEscenarioCab;
	}
	

	public ValorCompoPresu getValor_compo_1() throws BaseException {
		supportRefresh();
		return valor_compo_1;
	}

	public void setValor_compo_1(ValorCompoPresu aValor_compo_1) {
		this.valor_compo_1 = aValor_compo_1;
	}

	public ValorCompoPresu getValor_compo_2() throws BaseException {
		supportRefresh();
		return valor_compo_2;
	}

	public void setValor_compo_2(ValorCompoPresu aValor_compo_2) {
		this.valor_compo_2 = aValor_compo_2;
	}

	public ValorCompoPresu getValor_compo_3() throws BaseException {
		supportRefresh();
		return valor_compo_3;
	}

	public void setValor_compo_3(ValorCompoPresu aValor_compo_3) {
		this.valor_compo_3 = aValor_compo_3;
	}

	public ValorCompoPresu getValor_compo_4() throws BaseException {
		supportRefresh();
		return valor_compo_4;
	}

	public void setValor_compo_4(ValorCompoPresu aValor_compo_4) {
		this.valor_compo_4 = aValor_compo_4;
	}

	public ValorCompoPresu getValor_compo_5() throws BaseException {
		supportRefresh();
		return valor_compo_5;
	}

	public void setValor_compo_5(ValorCompoPresu aValor_compo_5) {
		this.valor_compo_5 = aValor_compo_5;
	}

	public ValorCompoPresu getValor_compo_6() throws BaseException {
		supportRefresh();
		return valor_compo_6;
	}

	public void setValor_compo_6(ValorCompoPresu aValor_compo_6) {
		this.valor_compo_6 = aValor_compo_6;
	}

	public ValorCompoPresu getValor_compo_7() throws BaseException {
		supportRefresh();
		return valor_compo_7;
	}

	public void setValor_compo_7(ValorCompoPresu aValor_compo_7) {
		this.valor_compo_7 = aValor_compo_7;
	}

	public ValorCompoPresu getValor_compo_8() throws BaseException {
		supportRefresh();
		return valor_compo_8;
	}

	public void setValor_compo_8(ValorCompoPresu aValor_compo_8) {
		this.valor_compo_8 = aValor_compo_8;
	}

	public ValorCompoPresu getValor_compo_9() throws BaseException {
		supportRefresh();
		return valor_compo_9;
	}

	public void setValor_compo_9(ValorCompoPresu aValor_compo_9) {
		this.valor_compo_9 = aValor_compo_9;
	}

	public Money getValor() throws BaseException {
		supportRefresh();
		return valor;
	}

	public void setValor(Money aValor) {
		this.valor = aValor;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ValorVariableEscenario findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ValorVariableEscenario) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ValorVariableEscenario findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ValorVariableEscenario) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setValorCompoPresu(ValorCompoPresu valorCompo, Integer nroInternoCompo) {
		if (nroInternoCompo.intValue() == 1)
			this.setValor_compo_1(valorCompo);
		else if (nroInternoCompo.intValue() == 2)
			this.setValor_compo_2(valorCompo);
		else if (nroInternoCompo.intValue() == 3)
			this.setValor_compo_3(valorCompo);
		else if (nroInternoCompo.intValue() == 4)
			this.setValor_compo_4(valorCompo);
		else if (nroInternoCompo.intValue() == 5)
			this.setValor_compo_5(valorCompo);
		else if (nroInternoCompo.intValue() == 6)
			this.setValor_compo_6(valorCompo);
		else if (nroInternoCompo.intValue() == 7)
			this.setValor_compo_7(valorCompo);
		else if (nroInternoCompo.intValue() == 8)
			this.setValor_compo_8(valorCompo);
		else if (nroInternoCompo.intValue() == 9)
			this.setValor_compo_9(valorCompo);

	}

	public static ValorVariableEscenario getValorByComponentesPeriodos(
			HashTableDatos valorComponentesConNroInt,
			PeriodoPresupuestario periodo,
			VarEscenarioCab varEsceCab,
			ISesion aSesion) throws BaseException {
		return DBValorVariableEscenario.getValorByComponentesPeriodos(valorComponentesConNroInt, 
				                                                          periodo, 
				                                                          varEsceCab,
				                                                          aSesion);
	}
	
  public static List getValoresVarByEscenarioCab(VarEscenarioCab varEscenarioCab,
      ISesion aSesion) throws BaseException {
  	return DBValorVariableEscenario.getValoresVarByEscenarioCab(varEscenarioCab,aSesion);
  }
  
  public String getClave() throws BaseException {  	
  	StringBuffer clave = new StringBuffer("");
  	if (this.getPeriodo()!=null)
  		clave.append(this.getPeriodo().getOIDInteger().toString()+"_");
  	Iterator iterVarEsc =
  		this.getVariableEscenario().getVariablesEscenarioDetOrderByNroInt().iterator();
  	while (iterVarEsc.hasNext()) {
  		VarEscenarioDet varEscDet = (VarEscenarioDet) iterVarEsc.next();
  		ValorCompoPresu valorCompoPresu = this.getValorCompoPresu(varEscDet.getNroInternoValCompo());
  		clave.append(valorCompoPresu.getOIDInteger().toString()+"_");
  	}
  	return clave.toString();
  }
  
  public ValorCompoPresu getValorCompoPresu(Integer aNroInterno) throws BaseException {
  	if (aNroInterno.intValue()==1)
  		return this.getValor_compo_1();
  	else
    	if (aNroInterno.intValue()==2)
    		return this.getValor_compo_2();
    	else
      	if (aNroInterno.intValue()==3)
      		return this.getValor_compo_3();
      	else
        	if (aNroInterno.intValue()==4)
        		return this.getValor_compo_4();
        	else
          	if (aNroInterno.intValue()==5)
          		return this.getValor_compo_5();
          	else
            	if (aNroInterno.intValue()==6)
            		return this.getValor_compo_6();
            	else
              	if (aNroInterno.intValue()==7)
              		return this.getValor_compo_7();
              	else
                	if (aNroInterno.intValue()==8)
                		return this.getValor_compo_8();
                	else
                  	if (aNroInterno.intValue()==9)
                  		return this.getValor_compo_9();
                  	else
                  		return null;
  		
  }
	

}
