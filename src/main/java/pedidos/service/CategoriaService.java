package pedidos.service;

import java.util.List;

import pedidos.entities.Categoria;

public interface CategoriaService {
	List<Categoria> encontrarTodos();
	Categoria encontrarUno(int idCategoria);
	Categoria crear(Categoria c);
	Categoria update(Categoria c, int idCategoria);
	int delete(int idCategoria);
}
