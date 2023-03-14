package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBAtriCompoPresu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class AtriCompoPresu extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AtriCompoPresu() {
	}

	public static String				NICKNAME							= "pl.AtriCompoPresu";

	private CompoPresupuestario	compo_presu;

	private String							tipo_atributo;

	private String							nombre_logico;

	private Integer							nro_orden;

	private CompoPresupuestario	compo_presu_atri;

	private Boolean							activo;

	private Boolean							obligatorio;
	
	private Integer 						nroInternoAtri;
	
	private String 							formato;

	public static final String	VALOR_TEXTO						= "TEXTO";

	public static final String	VALOR_TEXTO_EXTENDIDO	= "TEXTO_EXT";

	public static final String	VALOR_DECIMAL					= "DECIMAL";

	public static final String	VALOR_ENTERO					= "ENTERO";

	public static final String	VALOR_FECHA						= "FECHA";

	public static final String	VALOR_COMPO						= "COMPONENTE";
	
	public static final String	VALOR_COMPO_COD				= "COMPO_COD";
	
	public static final String	VALOR_COMPO_DESC			= "COMPO_DESC";
	
	public static final String NRO_INTERNO_ATRI = "NRO_INTERNO_ATRI";

	public CompoPresupuestario getCompo_presu() throws BaseException {
		supportRefresh();
		return compo_presu;
	}

	public Boolean isObligatorio() throws BaseException {
		supportRefresh();
		return this.obligatorio;
	}

	public void setObligatorio(Boolean aObligatorio) {
		this.obligatorio = aObligatorio;
	}

	public void setCompo_presu(CompoPresupuestario aCompo_presu) {
		this.compo_presu = aCompo_presu;
	}

	public String getTipo_atributo() throws BaseException {
		supportRefresh();
		return tipo_atributo;
	}

	public void setTipo_atributo(String aTipo_atributo) {
		this.tipo_atributo = aTipo_atributo;
	}
	
	public String getFormato() throws BaseException {
		supportRefresh();
		return this.formato;
	}

	public void setFormato(String aFormato) {
		this.formato = aFormato;
	}
	

	public String getNombre_logico() throws BaseException {
		supportRefresh();
		return nombre_logico;
	}

	public void setNombre_logico(String aNombre_logico) {
		this.nombre_logico = aNombre_logico;
	}
	
	public Integer getNroInternoAtri() throws BaseException {
		supportRefresh();
		return this.nroInternoAtri;
	}

	public void setNroInternoAtri(Integer aNroInternoAtri) {
		this.nroInternoAtri = aNroInternoAtri;
	}
	

	public Integer getNro_orden() throws BaseException {
		supportRefresh();
		return nro_orden;
	}

	public void setNro_orden(Integer aNro_orden) {
		this.nro_orden = aNro_orden;
	}

	public CompoPresupuestario getCompo_presu_atri() throws BaseException {
		supportRefresh();
		return compo_presu_atri;
	}

	public void setCompo_presu_atri(CompoPresupuestario aCompo_presu_atri) {
		this.compo_presu_atri = aCompo_presu_atri;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AtriCompoPresu findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AtriCompoPresu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AtriCompoPresu findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AtriCompoPresu) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(compo_presu, "Debe ingresar el componente presupuestario");
		Validar.noNulo(tipo_atributo, "Debe ingresar el tipo de Atributo");
		Validar.noNulo(nombre_logico, "Debe ingresar el Nombre Lógico");
		Validar.noNulo(nro_orden, "Debe ingresar el Nro. de Orden");
	}

	public static List getAtriCompoPresu(CompoPresupuestario compoPresu, ISesion aSesion) throws BaseException {
		return DBAtriCompoPresu.getAtributosCompoPresu(compoPresu, aSesion);
	}
	
	public static HashTableDatos getTiposAtributos() {
		HashTableDatos tiposAtri = new HashTableDatos();
		tiposAtri.put(VALOR_TEXTO, "Texto");
		tiposAtri.put(VALOR_TEXTO_EXTENDIDO,"Texto largo");
		tiposAtri.put(VALOR_DECIMAL,"Decimal");
		
		// Al entero se lo define como decimal a proposito para que sea simple cambiar de un tipo a otro
		// ademas si no tira error cuando devuelve los datos via XML
		tiposAtri.put(VALOR_ENTERO,"Entero");
		tiposAtri.put(VALOR_FECHA,"Fecha");
		tiposAtri.put(VALOR_COMPO,"Componente");
		return tiposAtri;  
	}
	
	public static HashTableDatos getPrefijosCampos() {
		HashTableDatos tiposAtri = new HashTableDatos();
		tiposAtri.put(VALOR_TEXTO, "val_tex_");
		tiposAtri.put(VALOR_TEXTO_EXTENDIDO,"val_tex_");
		tiposAtri.put(VALOR_DECIMAL,"val_num_");
		tiposAtri.put(VALOR_ENTERO,"val_num_");
		tiposAtri.put(VALOR_FECHA,"val_fec_");
		tiposAtri.put(VALOR_COMPO,"oid_val_com_");
		tiposAtri.put(VALOR_COMPO_COD,"cod_val_com_");
		tiposAtri.put(VALOR_COMPO_DESC,"desc_val_com_");
		return tiposAtri;  
	}
	
	public String getCampoTabla() throws BaseException {
			String prefijo = (String)AtriCompoPresu.getPrefijosCampos().get(this.getTipo_atributo());
			return prefijo+this.getNroInternoAtri();
	}
	
	public String getTipoCampo() throws BaseException {
		if (this.isCompoCodigoDescripcion())
			return Field.INTEGER;
		else
			if (this.isCompoDecimal())
				return Field.CURRENCY;
			else 
				if (this.isCompoEntero()) // El entero se define a proposito como currency para compatibilizar los numerso (NO CAMBIAR)
					return Field.CURRENCY;
				else
					if (this.isCompoFecha())
						return Field.DATE;
					else
						if (this.isCompoText() || this.isCompoTextoExtendido())
							return Field.STRING;
						else
							return Field.STRING;
  }
	
	public int getSizeCampo() throws BaseException {
		if (this.isCompoCodigoDescripcion())
			return 0;
		else
			if (this.isCompoDecimal())
				return 0;
			else
				if (this.isCompoEntero())
					return 0;
				else
					if (this.isCompoFecha())
						return 10;
					else
						if (this.isCompoText())
							return 50;
						else
							if (this.isCompoTextoExtendido())
								return 255;
						else
							return 255;
  }	
	
	
	public String getCampoCodigoCompo() throws BaseException {
		String prefijo = (String)AtriCompoPresu.getPrefijosCampos().get(VALOR_COMPO_COD);
		return prefijo+this.getNroInternoAtri();
  }
	
	public String getCampoDescCompo() throws BaseException {
		String prefijo = (String)AtriCompoPresu.getPrefijosCampos().get(VALOR_COMPO_DESC);
		return prefijo+this.getNroInternoAtri();
  }
	
	public static int getUltNroAtri(CompoPresupuestario compoPresu,String tipoAtri,ISesion aSesion) throws BaseException {
		return DBAtriCompoPresu.getUltimoNroInterno(aSesion,compoPresu,tipoAtri);
	}
	
	public boolean isCompoText() throws BaseException {
		if (this.getTipo_atributo().equals(AtriCompoPresu.VALOR_TEXTO))
			return true;
		else
			return false;
	}
	
	public boolean isCompoTextoExtendido() throws BaseException {
		if (this.getTipo_atributo().equals(AtriCompoPresu.VALOR_TEXTO_EXTENDIDO))
			return true;
		else
			return false;
	}
	
	public boolean isCompoDecimal() throws BaseException {
		if (this.getTipo_atributo().equals(AtriCompoPresu.VALOR_DECIMAL))
			return true;
		else
			return false;
	}
	
	public boolean isCompoCodigoDescripcion() throws BaseException {
		if (this.getTipo_atributo().equals(AtriCompoPresu.VALOR_COMPO))
			return true;
		else
			return false;
	}
	
	public boolean isCompoFecha() throws BaseException {
		if (this.getTipo_atributo().equals(AtriCompoPresu.VALOR_FECHA))
			return true;
		else
			return false;
	}
	
	public boolean isCompoEntero() throws BaseException {
		if (this.getTipo_atributo().equals(AtriCompoPresu.VALOR_ENTERO))
			return true;
		else
			return false;
	}
	
	public String getNombreCampoOid() {
		return "";
	}
	
	public String getNombreCampoCodigo() {
		return "";
	}
	
	public String getNombreCampoDescripcion() {
		return "";
	}
	
	
	

}
