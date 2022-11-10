package edu.es.eoi;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.es.eoi.marketplace.entity.Articulo;
import edu.es.eoi.marketplace.entity.Usuario;
import edu.es.eoi.marketplace.service.ArticuloService;
import edu.es.eoi.marketplace.service.PedidoService;
import edu.es.eoi.marketplace.service.UsuarioService;

@SpringBootTest
class BackendAppTests {

	@Autowired
	static ArticuloService artService;
	
	@Autowired
	static UsuarioService usuService;
	
	@Autowired
	static PedidoService pedService;
	
	@Test
	void contextLoads() {
		
		System.out.println(Calendar.getInstance().get(0));
		
		Usuario user = new Usuario();
		user.setId(1);
		user.setNombre("david");
		user.setPassword("1234");
		
		Usuario user1 = new Usuario();
		user1.setNombre("paco");
		user1.setPassword("1111");
		
		Usuario user2 = new Usuario();
		user2.setNombre("marta");
		user2.setPassword("2222");
		
		Usuario user3 = new Usuario();
		user3.setNombre("ana");
		user3.setPassword("3333");
		
		Usuario user4 = new Usuario();
		user4.setNombre("andalucia");
		user4.setPassword("4444");
		
		
		usuService.createUsuario(user);
		usuService.createUsuario(user1);
		usuService.createUsuario(user2);
		usuService.createUsuario(user3);
		usuService.createUsuario(user4);
		
		
		Articulo articulo = new Articulo();
		articulo.setNombre("Patatas");
		articulo.setPrecio(2.25);
		articulo.setStock(12);
		
		Articulo articulo1 = new Articulo();
		articulo1.setNombre("Chocolate");
		articulo1.setPrecio(1.5);
		articulo1.setStock(23);
		
		Articulo articulo2 = new Articulo();
		articulo2.setNombre("Pan");
		articulo2.setPrecio(0.5);
		articulo2.setStock(12);
		
		Articulo articulo3 = new Articulo();
		articulo3.setNombre("Pollo");
		articulo3.setPrecio(3.75);
		articulo3.setStock(16);
		
		Articulo articulo4 = new Articulo();
		articulo4.setNombre("Manzana");
		articulo4.setPrecio(0.75);
		articulo4.setStock(7);
		
		artService.createArticulo(articulo);
		artService.createArticulo(articulo1);
		artService.createArticulo(articulo2);
		artService.createArticulo(articulo3);
		artService.createArticulo(articulo4);
		
		
	}

}
