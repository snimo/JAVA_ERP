package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Utils.BaseException;

public class JornadaFichada {
	
	private CIPFichadaOficina fichadaEnt;
	private CIPFichadaOficina fichadaSal;
	private Legajo legajo;
	private List<CIPFichadaOficina> fichadasInt = new ArrayList<CIPFichadaOficina>();
	private Boolean ignorarUltEnt = false;
	private Boolean ignorarFinJornada = false;

	public CIPFichadaOficina getFichadaEnt() {
		return fichadaEnt;
	}

	public void setFichadaEnt(CIPFichadaOficina fichadaEnt) {
		this.fichadaEnt = fichadaEnt;
	}

	public CIPFichadaOficina getFichadaSal() {
		return fichadaSal;
	}

	public void setFichadaSal(CIPFichadaOficina fichadaSal) {
		this.fichadaSal = fichadaSal;
	}

	public List<CIPFichadaOficina> getFichadasInt() {
		return fichadasInt;
	}

	public void setFichadasInt(List<CIPFichadaOficina> fichadasInt) {
		this.fichadasInt = fichadasInt;
	}

	public Legajo getLegajo() {
		return legajo;
	}

	public void setLegajo(Legajo legajo) {
		this.legajo = legajo;
	}
	
	public Boolean isIgnorarUltEnt() {
		return ignorarUltEnt;
	}

	public void setIgnorarUltEnt(Boolean ignorarUltEnt) {
		this.ignorarUltEnt = ignorarUltEnt;
	}
	

	public Boolean isIgnorarFinJornada() {
		if(this.ignorarUltEnt == true)
			return true;
		
		return ignorarFinJornada;
	}

	public void setIgnorarFinJornada(Boolean ignorarFinJornada) {
		this.ignorarFinJornada = ignorarFinJornada;
	}
	
	public Date getFecHorEnt() throws BaseException{
		if(this.fichadaEnt != null)
			return this.fichadaEnt.getFec_hor();
					
		return null;			
	}
	
	public Date getFecHorSal() throws BaseException{
		if(this.fichadaSal != null)
			return this.fichadaSal.getFec_hor();
					
		return null;
	}
	

}
