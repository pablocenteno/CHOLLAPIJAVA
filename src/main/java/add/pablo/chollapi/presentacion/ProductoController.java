package add.pablo.chollapi.presentacion;

import add.pablo.chollapi.dao.impl.ProductoDAOImpl;
import add.pablo.chollapi.daos.ProductoDAO;

public class ProductoController {

	ProductoDAO productoDao;
	
	public ProductoController() {
		productoDao = new ProductoDAOImpl();
	}
}
