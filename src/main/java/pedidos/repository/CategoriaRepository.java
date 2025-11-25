package pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedidos.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
