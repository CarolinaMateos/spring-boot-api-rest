package pedidos.service;

import java.util.List;

import pedidos.entities.Producto;

public interface ProductoService {
	List<Producto> encontrarTodos();
	Producto encontrarUno(int idProducto);
	Producto crear(Producto p);
	Producto update(Producto p, int idProducto);
	int delete(int idProducto);
	
	List<Producto> stockMenor(int stock);
	List<Producto> porCategoria(int idCategoria);
	List<Producto> porCategoriaNombre(String nombreCategoria);
	List<Producto> buscarPorNombre(String nombre);
	
}
