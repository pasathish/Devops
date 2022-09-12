package ca.guusto.merchant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.guusto.merchant.model.Merchant;
import ca.guusto.merchant.model.MerchantShopping;

@SpringBootApplication
public class MerchantApplication {

	public static long sleep = 2;
	
	@Value( "${shopping-service-url-port}" )
	private String shoppingServiceUrlPort;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MerchantApplication.class, args);
	}

	// http://localhost:8081/v1/merchants
	
	@RestController
	@RequestMapping("/v1/merchants")
	public class MerchantController {
		
	  @Autowired
	  MerchantService merchantService;
	  
	  @Autowired
	  MerchantService restTemplate;
		
		@GetMapping()
		public ResponseEntity<Collection<Merchant>> findAll(){
			
			Collection<Merchant> models = merchantService.findAll();
			
			if(models != null) {
				return new ResponseEntity<>(merchantService.getShopping(models),
						HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}	

	@Service
	public class MerchantService {
		
		@Autowired
		private RestTemplate restTemplate;
		
		public List<Merchant> getShopping(Collection<Merchant> models) {
//			System.out.println(" --> "+ sleep);
//			sleep= sleep +10;
			return models
					.stream()
					.map(f -> {
						
//						try {
							
							MerchantShopping merchantShopping = restTemplate
									.getForObject("http://"+shoppingServiceUrlPort+"/v1/shopping/" 
											+ f.getId(),
									MerchantShopping.class);
								
								f.setShoppingOption(merchantShopping.getShoppingOption());
							
//							Thread.sleep(sleep);
//							System.out.print("");
//						} catch (InterruptedException e) {
//							System.out.print("");
//						}
						return f;
						
					}).collect(Collectors.toList());
		}
		
		
		public List<Merchant> findAll() {
			
			List<Merchant> list = new ArrayList<Merchant>();
			Boolean isCad = Boolean.TRUE;
			for (int i = 0; i < sleep; i++) {
				if(Boolean.TRUE.equals(isCad)) {
					list.add(new Merchant(Long.valueOf(i),"Merchant " + i, "CAD"));
					isCad = Boolean.FALSE;
				} else {
					list.add(new Merchant(Long.valueOf(i),"Merchant " + i, "USD"));
					isCad = Boolean.TRUE;
				}
			}
			
			return list;
			
			/*return List.of(
					new Merchant(1L,"Best Buy", "CAD"),
					new Merchant(2L,"Best Buy", "USD"),
					new Merchant(3L,"Butcher & Bullock", "CAD"),
					new Merchant(4L,"Butcher & Bullock", "USD"),
					new Merchant(5L,"Gap", "CAD"),
					new Merchant(6L,"Gap", "USD")
					);*/
		}
		
		
		
		
	}

}


