package add.pablo.chollapi.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;



@Entity
@Table(name = "Oferta")
@NamedQuery(name="Oferta.findAll", query="SELECT o from Oferta o")
public class Oferta implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String url;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private Float precio;
	
	private Boolean disponible;
	
	@ManyToMany(mappedBy="ofertas", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Producto> productos = new ArrayList<Producto>();
	
	public Oferta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public void anadirProducto(Producto p) {
		productos.add(p);
		p.getOfertas().add(this);
	}

    public void eliminarProducto(Producto p) {
        productos.remove(p);
        p.getOfertas().remove(this);
        }

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", url=" + url + ", fecha=" + fecha + ", precio=" + precio + ", disponible="
				+ disponible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disponible, fecha, id, precio, productos, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		return Objects.equals(disponible, other.disponible) && Objects.equals(fecha, other.fecha)
				 && Objects.equals(precio, other.precio)
				&& Objects.equals(url, other.url);
	}
	
	
}
