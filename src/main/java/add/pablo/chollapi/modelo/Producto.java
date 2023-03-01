package add.pablo.chollapi.modelo;

import com.sun.istack.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;





@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	@Nullable
	private Long idFabricante;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="producto_oferta"
		, joinColumns={
			@JoinColumn(name="producto_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="oferta_id")
			}
		)
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	
	public Producto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public void anadirOferta(Oferta o)
    {
        ofertas.add(o);
        o.getProductos().add(this);
    }

    public void eliminarOferta(Oferta o)
    {
        ofertas.remove(o);
        o.getProductos().remove(this);
    }

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", idFabricante=" + idFabricante + ", ofertas=" + ofertas
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idFabricante, nombre, ofertas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id) && Objects.equals(idFabricante, other.idFabricante)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(ofertas, other.ofertas);
	}
}
