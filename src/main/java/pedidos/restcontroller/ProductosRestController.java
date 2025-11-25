package pedidos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.entities.Producto;
import pedidos.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductosRestController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/")
	public ResponseEntity<?> verTodos() {
		List<Producto> lista = productoService.encontrarTodos();
		if (lista != null) {
			return new ResponseEntity<List>(lista, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No hay productos", HttpStatus.valueOf(404));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> verProducto(@PathVariable int id) {
		Producto producto = productoService.encontrarUno(id);
		if (producto != null) {
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No existe ese producto", HttpStatus.valueOf(404));
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> nuevoProducto(@RequestBody Producto producto) {
		if (productoService.crear(producto) != null) {
			return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("No se ha podido crear el producto", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> modificarProducto(@RequestBody Producto producto, @PathVariable int id) {
		if (productoService.update(producto, id) != null) {
			return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("No se ha podido editar el producto por que no existe",
					HttpStatus.valueOf(404));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable int id) {
		switch (productoService.delete(id)) {
			case 1:
				return new ResponseEntity<String>("Producto borrado con exito", HttpStatus.OK);
			case 0:
				return new ResponseEntity<String>("No se ha podido borrar el producto por que no existe", HttpStatus.valueOf(404));
			default:
				return new ResponseEntity<String>("No se puede borrar el producto", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/stock-menor/{stock}")
	public ResponseEntity<?> buscarStock(@PathVariable int stock) {
		List<Producto> lista = productoService.stockMenor(stock);
		if(productoService.stockMenor(stock) != null) {
			if(productoService.stockMenor(stock).isEmpty()) {
				return new ResponseEntity<String>("No hay productos por debajo de ese stock", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List>(lista, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No se ha podido mostrar los productos, el numero debe ser un entero", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/por-categoria-id/{idCategoria}") //ENDPOINT 5 
	public ResponseEntity<?> buscarPorCategoria(@PathVariable int idCategoria) {
		List<Producto> lista = productoService.porCategoria(idCategoria);
		if(productoService.porCategoria(idCategoria) != null) {
			if(lista.isEmpty()) {
				return new ResponseEntity<String>("No hay productos en la categoria o no existe", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No se ha podido mostrar los productos, el id de la categoria debe ser un entero", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/por-categoria-nombre/{nombre}") //ENDPOINT 5 
	public ResponseEntity<?> buscarPorCategoriaNombre(@PathVariable String nombreCategoria) {
		List<Producto> lista = productoService.porCategoriaNombre(nombreCategoria);
		if(productoService.porCategoriaNombre(nombreCategoria) != null) {
			if(lista.isEmpty()) {
				return new ResponseEntity<String>("No hay productos en la categoria o no existe", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No se ha podido mostrar los productos, el id de la categoria debe ser un entero", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/por-nombre/{nombre}") //ENDPOINT 4
	  public List<Producto> search(@PathVariable String nombre) {
	    return productoService.buscarPorNombre(nombre);
	  }

}
