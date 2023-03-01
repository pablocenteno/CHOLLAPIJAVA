package add.pablo.chollapi.presentacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;

import add.pablo.chollapi.dao.impl.OfertaDAOImpl;
import add.pablo.chollapi.daos.OfertaDao;
import add.pablo.chollapi.jpa.Utilidades;
import add.pablo.chollapi.modelo.Oferta;
import add.pablo.chollapi.modelo.Producto;


public class AppDao {
	   public static void main( String[] args )
	    {
		  
					
		
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				
				Producto prod = new Producto();
				prod.setNombre("cocacola");
				prod.setIdFabricante(23L);
				
			
				OfertaController oc = new OfertaController();
				
				
				List<Oferta> ofertass = oc.ultimas10();
				
				ProductoController pc = new ProductoController();
				
				Producto prod2 = new Producto();
				prod2.setNombre("agua");
				prod2.setIdFabricante(1L);
				
				pc.productoDao.persist(prod2);
				System.out.println(ofertass);
				ofertass= oc.ultimas5(prod);
			
				System.out.println(ofertass);
	    }
}
