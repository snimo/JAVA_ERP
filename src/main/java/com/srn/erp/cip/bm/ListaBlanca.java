package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.srn.erp.cip.da.DBListaBlanca;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ListaBlanca extends ObjetoLogico {

	private static ConcurrentHashMap<String, ConcurrentHashMap<Integer, Integer>> listaBlanca = null;
	
	public ListaBlanca() {
	}

	public static String NICKNAME = "cip.ListaBlanca";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private Puerta puerta;
	private Legajo legajo;
	private Integer nro_a_validar;
	private Integer nro_orden;
	private String tipo;
	private Boolean activo;

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public Integer getNro_a_validar() throws BaseException {
		supportRefresh();
		return nro_a_validar;
	}

	public void setNro_a_validar(Integer aNro_a_validar) {
		this.nro_a_validar = aNro_a_validar;
	}

	public Integer getNro_orden() throws BaseException {
		supportRefresh();
		return nro_orden;
	}

	public void setNro_orden(Integer aNro_orden) {
		this.nro_orden = aNro_orden;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
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

	public static ListaBlanca findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ListaBlanca) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ListaBlanca findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ListaBlanca) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(nro_a_validar, "Debe ingresar el Nro a Validar");
		Validar.noNulo(nro_orden, "Debe ingresar el Nro. de Orden");
		Validar.noNulo(tipo, "Debe ingresar el Tipo");
	}

	public static List getListaBlanca(Puerta puerta, int nroDesde, int nroHasta, ISesion aSesion) throws BaseException {
		return DBListaBlanca.getListaBlanca(puerta, nroDesde, nroHasta, aSesion);
	}
	
	public static synchronized List<ListaBlancaSimple> getLoteListaBlanca(String puerta, int nroDesde, int nroHasta, ISesion aSesion) throws BaseException {
	
		if(listaBlanca == null) generarListaBlanca(aSesion);
		
		List<ListaBlancaSimple> lista = new ArrayList<ListaBlancaSimple>();
		
		if(listaBlanca.containsKey(puerta))
		{
			ConcurrentHashMap<Integer, Integer> hashPuerta = listaBlanca.get(puerta);
			
			for(int i= nroDesde; i<=nroHasta; i++)
			{
				if(hashPuerta.containsKey(i))
				{
					ListaBlancaSimple lbs = new ListaBlancaSimple(puerta, i, hashPuerta.get(i));
					lista.add(lbs);
				}
			}
		}
		return lista;
	}
	

	public static  void regenerarListaBlanca(ISesion aSesion)  throws BaseException {
		listaBlanca = null;
		generarListaBlanca(aSesion);
	}
	
	
	public static void generarListaBlanca(ISesion aSesion) throws BaseException {

		
		HashTableDatos keyPuertas = new HashTableDatos();
		Iterator iterPue = Puerta.getPuertasActivas(aSesion).iterator();
		while (iterPue.hasNext()) {
			Puerta puerta = (Puerta) iterPue.next();
			keyPuertas.put(puerta.getOIDInteger(), puerta.getIdentifPuerta());
		}
		
		if (listaBlanca!=null) return;
		
		//System.out.println("INICIO CARGA LISTA BLANCA");
		
		listaBlanca = new ConcurrentHashMap<String, ConcurrentHashMap<Integer,Integer>>();
		
		List<ListaBlanca> lista = DBListaBlanca.getAllListaBlanca(aSesion);
		
		Iterator<ListaBlanca> itLista = lista.iterator();
		
		
		while(itLista.hasNext())
		{
			ListaBlanca lb = itLista.next();
			Puerta puerta = lb.getPuerta();
			
			String key = (String) keyPuertas.get(puerta.getOIDInteger());
			
			if (key==null) continue;
			
			if(!listaBlanca.containsKey(key))
			{
				listaBlanca.put(key, new ConcurrentHashMap<Integer, Integer>());
			}
			
			ConcurrentHashMap<Integer, Integer> hashPuerta = listaBlanca.get(key);
			
			hashPuerta.put(lb.getNro_orden(), lb.getNro_a_validar());
			
		}
		
		//System.out.println("FIN CARGA LISTA BLANCA");
		
		
		
	}
	

}
