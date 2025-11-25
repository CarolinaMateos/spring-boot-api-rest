package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.entities.Producto;
import pedidos.repository.ProductoRepository;

@Service
public class ProductosImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> encontrarTodos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto encontrarUno(int idProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findById(idProducto).orElse(null);
	}

	@Override
	public Producto crear(Producto p) {
		try {
			p.setIdProducto(0);
			return productoRepository.save(p);
		} catch (Exception e) {
			System.out.println("Error al insertar:" + e.getMessage());
			return null;
		}
	}

	@Override
	public Producto update(Producto p, int idProducto){
		Producto siExiste = encontrarUno(idProducto);
		if(siExiste != null) {
			p.setIdProducto(idProducto);
			return productoRepository.save(p);
		}else {
			return null;
		}
	}

	@Override
	public int delete(int idProducto) {
		Producto SiExiste = encontrarUno(idProducto);
		if(SiExiste != null) {
			try {
				productoRepository.deleteById(idProducto);
				return 1;
			}catch(Exception e) {
				System.out.println("Error al insertar:" + e.getMessage());
				return -1;
				}
			} else {
			return 0;
		}
	}

	@Override
	public List<Producto> stockMenor(int stock) {
		if(stock >= 0) {
			return productoRepository.findByStockLessThan(stock);
		}else {
			return null;
		}
	}

	@Override
	public List<Producto> porCategoria(int idCategoria) {
		if(idCategoria >= 0) {
			return productoRepository.findByCategoria_IdCategoria(idCategoria);
		}else {
			return null;
		}
		
	}

	@Override
	public List<Producto> buscarPorNombre(String nombre) {
		return productoRepository.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public List<Producto> porCategoriaNombre(String nombreCategoria) {
		return productoRepository.findByCategoria_NombreIgnoreCase(nombreCategoria);
	}

}
