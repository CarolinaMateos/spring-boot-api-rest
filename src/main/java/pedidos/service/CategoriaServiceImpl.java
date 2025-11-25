package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.entities.Categoria;
import pedidos.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> encontrarTodos() {
		if(categoriaRepository.findAll().isEmpty()) {
			return null;
		}
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria encontrarUno(int idCategoria) {
		return categoriaRepository.findById(idCategoria).orElse(null);
	}

	@Override
	public Categoria crear(Categoria c) {
		try {
			c.setIdCategoria(0);
			return categoriaRepository.save(c);
		}catch(Exception e) {
			System.out.println("Error al insertar:" + e.getMessage());
			return null;
		}
	}

	@Override
	public Categoria update(Categoria c, int idCategoria) {
		Categoria siExiste = encontrarUno(idCategoria);
		if(siExiste != null) {
			c.setIdCategoria(idCategoria);
			return categoriaRepository.save(c);
		}else {
			return null;
		}
	}

	@Override
	public int delete(int idCategoria) {
		Categoria siExiste = encontrarUno(idCategoria);
		if(siExiste != null) {
			try {
				categoriaRepository.deleteById(idCategoria);
				return 1;
			}catch(Exception e) {
				System.out.println("Error al insertar:" + e.getMessage());
				return -1;
			}
		}else {
			return 0;
		}
	}

}
