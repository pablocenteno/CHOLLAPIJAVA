package add.pablo.chollapi.daos;


import java.util.List;

import add.pablo.chollapi.modelo.Oferta;
import add.pablo.chollapi.modelo.Producto;

public interface OfertaDao extends GenericDAO<Oferta,Long>{

	
	public List<Oferta> ultimas5_de_producto(Producto prod);
	public List<Oferta> ultimas10();
}
