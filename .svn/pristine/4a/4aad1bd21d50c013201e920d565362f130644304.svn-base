package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.da.DBValorClasificadorEntidad;
import com.srn.erp.stock.bm.ExtensionProdGen;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValorClasifEntProdGen extends FactoryObjetoLogico {

  public FactoryValorClasifEntProdGen() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
	  	ValorClasifEntProdGen valorclasificadorentidad = (ValorClasifEntProdGen) objLog;
	    valorclasificadorentidad.setOID(db.getInteger(DBValorClasificadorEntidad.OID_VAL_CLASIF_ENT));
	    valorclasificadorentidad.setClasificador_entidad(ClasificadorEntidad.findByOidProxy(db.getInteger(DBValorClasificadorEntidad.OID_CLASIF_ENT),getSesion()));
	    valorclasificadorentidad.setOid_item(db.getInteger(DBValorClasificadorEntidad.OID_ITEM));
	    valorclasificadorentidad.setCodigo(db.getString(DBValorClasificadorEntidad.CODIGO));
	    valorclasificadorentidad.setDescripcion(db.getString(DBValorClasificadorEntidad.DESCRIPCION));
	    valorclasificadorentidad.setOid_item_padre(db.getInteger(DBValorClasificadorEntidad.OID_ITEM_PADRE));
	    valorclasificadorentidad.setActivo(db.getBoolean(DBValorClasificadorEntidad.ACTIVO));
	    valorclasificadorentidad.setOrden(db.getInteger(DBValorClasificadorEntidad.ORDEN));
	    valorclasificadorentidad.setTipo(db.getString(DBValorClasificadorEntidad.TIPO));
	    valorclasificadorentidad.setCodigoDesde(db.getString(DBValorClasificadorEntidad.CODIGO_DESDE));
	    valorclasificadorentidad.setCodigoHasta(db.getString(DBValorClasificadorEntidad.CODIGO_HASTA));
	    
	    valorclasificadorentidad.setExtensionProdGen(ExtensionProdGen.getExtensionProdGral(valorclasificadorentidad, this.getSesion()));
  }
}
