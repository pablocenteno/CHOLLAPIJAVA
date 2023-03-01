package add.pablo.chollapi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import add.pablo.chollapi.daos.OfertaDao;
import add.pablo.chollapi.jpa.Utilidades;
import add.pablo.chollapi.modelo.Oferta;
import add.pablo.chollapi.modelo.Producto;

public class OfertaDAOImpl extends GenericDAOImpl<Oferta,Long> implements  OfertaDao {

	/*@Override
	public void crear_oferta(Oferta oferta) {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		List<Oferta> ofertas=  em.createQuery("select o "+"from Oferta o "+" where o.fecha like :fecha and o.precio like :precio and disponible = true")
				.setParameter(0, oferta.getFecha())
				.setParameter(1,oferta.getPrecio())
				.setParameter(2,oferta.getDisponible())
				.getResultList();
		
	}*/

	@Override
	public List<Oferta> ultimas5_de_producto(Producto prod) {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Oferta> tq=em.createQuery("SELECT o FROM Oferta o JOIN Producto p WHERE p.id = :idProc ORDER BY o.fecha desc", Oferta.class);
		tq.setParameter("idProc", prod.getId()).setMaxResults(5);

        return tq.getResultList();
	}

	@Override
	public List<Oferta> ultimas10() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Oferta> tq = em.createQuery("SELECT o FROM Oferta o ORDER BY o.fecha DESC", Oferta.class).setMaxResults(10);
				
		return tq.getResultList();
	}

}
