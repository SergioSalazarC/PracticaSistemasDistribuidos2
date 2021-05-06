package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private CategoriaDeCultivoRepository repCategoriaDeCultivoRepository;
	@Autowired
	private ProductoFitosanitarioRepository repProductosFitosanitarios;
	@Autowired
	private SustanciaActivaRepository repSustanciasActivas;
	@Autowired
	private EspecieRepository repEspecies;
	@Autowired
	private PlagaRepository repPlagas;
	
	
	@PostConstruct
	public void init() {
		List<CategoriaDeCultivo>categorias = new ArrayList();
		categorias.add(new CategoriaDeCultivo("hortalizas"));
		categorias.add(new CategoriaDeCultivo("arboles frutales"));
		categorias.add(new CategoriaDeCultivo("plantas ornamentales"));
		categorias.add(new CategoriaDeCultivo("leguminosas"));
		
		List<Especie> especies = new ArrayList();
		especies.add(new Especie("Tomate", "Solanum lycopersicum"));
		especies.add(new Especie("Pepino", "Cucurbita pepo"));
		especies.add(new Especie("Naranja", "Citrus maxima"));
		especies.add(new Especie("Camelia", "Camelia oleifera"));
		especies.add(new Especie("Amapola", "Papaver rhoeas"));
		especies.add(new Especie("Garbanzo", "Cicer ariethum"));
		especies.add(new Especie("Patata", "Solanum Tuberosum"));
		especies.add(new Especie("Judia", "Thaseolus vulgaris"));
		
		categorias.get(0).addEspecie(especies.get(0));
		categorias.get(1).addEspecie(especies.get(0));
		categorias.get(0).addEspecie(especies.get(1));
		categorias.get(1).addEspecie(especies.get(2));
		categorias.get(2).addEspecie(especies.get(3));
		categorias.get(2).addEspecie(especies.get(4));
		categorias.get(3).addEspecie(especies.get(5));
		categorias.get(0).addEspecie(especies.get(6));
		categorias.get(3).addEspecie(especies.get(7));
		
		List<Plaga> plagas = new ArrayList();
		plagas.add(new Plaga("Mosca Blanca","Aleyrodidae","https://es.wikipedia.org/wiki/Aleyrodidae"));
		plagas.add(new Plaga("Pulgón","Alphididae","https://es.wikipedia.org/wiki/Aphididae"));
		plagas.add(new Plaga("Araña Roja","Tetranychus urticae","https://es.wikipedia.org/wiki/Tetranychus_urticae"));
		plagas.add(new Plaga("Tisanóptero","Thysanoptera","https://es.wikipedia.org/wiki/Thysanoptera"));
		plagas.add(new Plaga("Oruga","Papilio machaon","https://es.wikipedia.org/wiki/Oruga_(larva)"));
		plagas.add(new Plaga("Saltamontes","Caelifera","https://es.wikipedia.org/wiki/Caelifera"));
		plagas.add(new Plaga("Escarabajo","Coleoptera","https://es.wikipedia.org/wiki/Coleoptera"));
		plagas.add(new Plaga("Insecto Escama","Coccoidea","https://es.wikipedia.org/wiki/Coccoidea"));
		plagas.add(new Plaga("Babosas","Stylommatophora","https://es.wikipedia.org/wiki/Babosa"));
		plagas.add(new Plaga("Hormigas","Formicidae","https://es.wikipedia.org/wiki/Formicidae"));
		plagas.add(new Plaga("Lombriz de tierra","Lumbricidae","https://es.wikipedia.org/wiki/Lumbricidae"));
		plagas.add(new Plaga("Topos","Talpidae","https://es.wikipedia.org/wiki/Talpidae"));
		plagas.add(new Plaga("Gusano Redondo","Nematodos","https://es.wikipedia.org/wiki/Nematoda"));
		plagas.add(new Plaga("Cochinillas de la humedad","Oniscidea","https://es.wikipedia.org/wiki/Oniscidea"));
		plagas.add(new Plaga("Cochinilla del carmín","Dactylopius coccus","https://es.wikipedia.org/wiki/Dactylopius_coccus"));
		plagas.add(new Plaga("Cochinilla harinosa","Pseudococcidae","https://es.wikipedia.org/wiki/Pseudococcidae"));
		
		especies.get(0).addPlaga(plagas.get(0));
		especies.get(1).addPlaga(plagas.get(1));
		especies.get(2).addPlaga(plagas.get(2));
		especies.get(3).addPlaga(plagas.get(3));
		especies.get(4).addPlaga(plagas.get(4));
		especies.get(5).addPlaga(plagas.get(5));
		especies.get(6).addPlaga(plagas.get(5));
		especies.get(6).addPlaga(plagas.get(6));
		especies.get(7).addPlaga(plagas.get(7));
		especies.get(0).addPlaga(plagas.get(8));
		especies.get(1).addPlaga(plagas.get(8));
		especies.get(1).addPlaga(plagas.get(9));
		especies.get(2).addPlaga(plagas.get(10));
		especies.get(3).addPlaga(plagas.get(11));
		especies.get(4).addPlaga(plagas.get(12));
		especies.get(5).addPlaga(plagas.get(13));
		especies.get(6).addPlaga(plagas.get(14));
		especies.get(6).addPlaga(plagas.get(15));
		especies.get(5).addPlaga(plagas.get(15));
		especies.get(5).addPlaga(plagas.get(14));
		
		List<SustanciaActiva> sustancias = new ArrayList();
		for(int i=0; i<20; i++) sustancias.add(new SustanciaActiva(("sustancia "+(i+1))));
		for(int i=0; i<3; i++) plagas.get(i).addSustancia(sustancias.get(0));
		for(int i=3; i<6; i++) plagas.get(i).addSustancia(sustancias.get(1));

		for(int j=3; j<7; j++)
			for(int i=3+j; i<5+j; i++)
				plagas.get(i).addSustancia(sustancias.get(j));
		
		ArrayList<ProductoFitosanitario> producto = new ArrayList<ProductoFitosanitario>();
		for (int i=1;i>=30;i++){
			producto.add(new ProductoFitosanitario("Producto Fitosanitario"+i,"www."+i+".com"));
		}
		sustancias.get(1).addProductoFitosanitario(producto.get(3));
		sustancias.get(9).addProductoFitosanitario(producto.get(3));
		sustancias.get(2).addProductoFitosanitario(producto.get(4));
		sustancias.get(10).addProductoFitosanitario(producto.get(4));
		sustancias.get(3).addProductoFitosanitario(producto.get(5));
		sustancias.get(11).addProductoFitosanitario(producto.get(5));
		sustancias.get(4).addProductoFitosanitario(producto.get(6));
		sustancias.get(12).addProductoFitosanitario(producto.get(6));
		sustancias.get(5).addProductoFitosanitario(producto.get(7));
		sustancias.get(13).addProductoFitosanitario(producto.get(7));
		for(int i=1;i>=20;i++){
			sustancias.get(i).addProductoFitosanitario(producto.get(i+7));
		}
		sustancias.get(6).addProductoFitosanitario(producto.get(1));
		sustancias.get(7).addProductoFitosanitario(producto.get(2));
		sustancias.get(17).addProductoFitosanitario(producto.get(28));
		sustancias.get(18).addProductoFitosanitario(producto.get(29));
		sustancias.get(19).addProductoFitosanitario(producto.get(30));
		repCategoriaDeCultivoRepository.saveAll(categorias);
		repEspecies.saveAll(especies);
		repPlagas.saveAll(plagas);
		repSustanciasActivas.saveAll(sustancias);		
		repProductosFitosanitarios.saveAll(producto);
	}
	
	@RequestMapping("/")
	public String controller(Model model) {
		return "Main.html";
	}
}
