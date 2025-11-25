package pedidos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.entities.Categoria;
import pedidos.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriasRestController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/")
	public ResponseEntity<?> verTodas(){
		List<Categoria> lista = categoriaService.encontrarTodos();
		if(lista != null) {
			return new ResponseEntity<List>(lista, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No hay categorias", HttpStatus.valueOf(404));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verCategoria(@PathVariable int id){
		Categoria categoria = categoriaService.encontrarUno(id);
		if(categoria != null) {
			return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No existe esa categoria", HttpStatus.valueOf(404));
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> nuevaCategoria(@RequestBody Categoria categoria) {
		if(categoriaService.crear(categoria) != null) {
			return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("No se ha podido crear la categoria", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
		if(categoriaService.update(categoria, id) != null) {
			return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("No se ha podido editar la categoria por que no existe",
					HttpStatus.valueOf(404));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarCategoria(@PathVariable int id) {
		switch (categoriaService.delete(id)) {
		case 1:
			return new ResponseEntity<String>("Categoria borrada con exito", HttpStatus.OK);
		case 0:
			return new ResponseEntity<String>("No se ha podido borrar la categoria por que no existe", HttpStatus.valueOf(404));
		default:
			return new ResponseEntity<String>("No se puede borrar la categoria", HttpStatus.BAD_REQUEST);
	}
	}
}
