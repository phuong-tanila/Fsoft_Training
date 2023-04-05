package fa.training.restfulapi.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import fa.training.restfulapi.entities.Product;
import fa.training.restfulapi.entities.ProductImage;
import fa.training.restfulapi.hateoas.ProductModel;
import fa.training.restfulapi.services.EcommerceService;
import fa.training.restfulapi.storage.StorageService;

@RestController
@RequestMapping("/product")
public class ProductController extends CoreController {

	@Autowired
	private EcommerceService ecommerceService;
	@Autowired
	private StorageService storageService;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	Validator productValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(productValidator);
	}

	@GetMapping
	public List<ProductModel> index() {
		List<Product> res = ecommerceService.getProducts();
		List<ProductModel> output = new ArrayList<ProductModel>();
		res.forEach((p) -> {
			ProductModel pr = new ProductModel(p);
			pr.add(createHateoasLink(p.getId()));

			output.add(pr);
		});
		return output;
	}

	@PostMapping
	public Product create(@RequestBody @Valid Product product) {
		return ecommerceService.saveProduct(product);
	}

	@GetMapping("/{id}")
	public ProductModel view(@PathVariable("id") long id) {
		Optional<Product> optionalProduct = ecommerceService.getProduct(id);
		Product product = optionalProduct.get();

		ProductModel productModel = new ProductModel(product);
		productModel.add(createHateoasLink(product.getId()));

		return productModel;
	}

	@PostMapping(value = "/{id}")
	public Product edit(@PathVariable("id") long id, @RequestBody @Valid Product product) {

		Optional<Product> optionalUpdatedProduct = ecommerceService.getProduct(id);
		Product updatedProduct = optionalUpdatedProduct.get();

		if (updatedProduct == null) {
			return null;
		}

		updatedProduct.setName(product.getName());
		updatedProduct.setPrice(product.getPrice());
		updatedProduct.setDescription(product.getDescription());

		return ecommerceService.saveProduct(updatedProduct);
	}

	@GetMapping("/{id}/images")
	public List<ProductImage> viewImages(@PathVariable("id") String productId) {
		Session session = sessionFactory.openSession();
		List<ProductImage> list = session.createQuery("FROM ProductImage WHERE product_id = :product_id")
				.setLong("product_id", Long.parseLong(productId)).list();
		session.close();
		return list;
	}

	@GetMapping("/image/{id}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable("id") String id) {

		Session session = sessionFactory.openSession();
		ProductImage image = (ProductImage) session.get(ProductImage.class, Long.parseLong(id));

		session.close();

		// Relative path to StorageProperties.rootLocation
		String path = "product-images/" + image.getProductId() + "/";

		Resource file = storageService.loadAsResource(path + image.getPath());
		String mimeType = "image/png";
		try {
			mimeType = file.getURL().openConnection().getContentType();
		} catch (IOException e) {
			System.out.println("Can't get file mimeType. " + e.getMessage());
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, mimeType).body(file);
	}

	@PostMapping("/{id}/uploadimage")
	public String handleFileUpload(@PathVariable("id") String id, @RequestParam("file") MultipartFile file) {
		// Relative path to the rootLocation in storageService
		String path = "/product-images/" + id;
		String filename = storageService.store(file, path);
		return ecommerceService.addProductImage(id, filename);
	}

	// Todo: add delete method
}
