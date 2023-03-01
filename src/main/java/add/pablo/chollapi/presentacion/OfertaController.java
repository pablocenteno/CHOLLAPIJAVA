package add.pablo.chollapi.presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import add.pablo.chollapi.dao.impl.OfertaDAOImpl;
import add.pablo.chollapi.daos.OfertaDao;
import add.pablo.chollapi.modelo.Oferta;
import add.pablo.chollapi.modelo.Producto;

public class OfertaController {
	OfertaDao ofertaDao;
	
	public OfertaController() {
		ofertaDao= new OfertaDAOImpl();
	}
	public void guardar(Oferta oferta) {
		ofertaDao.persist(oferta);
	}
	
	@Transactional
	public void crear_oferta(Oferta oferta){
		
		List<Oferta> ofertas = ofertaDao.findAll();
		boolean existe = false;
		for(Oferta o: ofertas) {
				if(o.equals(oferta) && o.getDisponible()==true &&oferta.getDisponible()==true) {
					System.out.println("Error, esa oferta ya existe");
					existe = true;
				}
		}
		if(existe== false) {
			ofertaDao.persist(oferta);
		}
	}
	
	 public List<Oferta> ultimas5(Producto producto){
		 
	     return ofertaDao.ultimas5_de_producto(producto);
	    }

	    public List<Oferta> ultimas10(){
	    	
	        return ofertaDao.ultimas10();
	    }
	
	
}
