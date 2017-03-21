
package services;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.AcademyRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Academy;
import form.AcademyForm;

@Service
@Transactional
public class AcademyService {

	// Managed repository

	@Autowired
	private AcademyRepository	academyRepository;


	// Supporting services
	
	@Autowired
	private Validator	validator;

	//Constructors
	public AcademyService() {
		super();

	}

	// Simple CRUD methods
	public Academy create() {
		Academy result;
		result = new Academy();
		
		result.setAvgStars(0.0);
		result.setFeeAmount(0.0);
		
		return result;
	}

	public Collection<Academy> findAll() {
		Collection<Academy> result;
		result = academyRepository.findAll();
		return result;
	}

	public Academy findOne(int id) {
		Academy result;
		result = academyRepository.findOne(id);
		return result;
	}

	public Academy save(Academy academy) {
		Academy result;
		
		String password = academy.getUserAccount().getPassword();
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String md5 = encoder.encodePassword(password, null);
		academy.getUserAccount().setPassword(md5);
		
		result = academyRepository.save(academy);
		
		return result;

	}

	public void delete(Academy academy) {
		academyRepository.delete(academy);
	}
	
	// Form methods ------------------------------------------------

		public AcademyForm generateForm() {
			AcademyForm result;

			result = new AcademyForm();
			return result;
		}
/*
		public AcademyForm generateForm(Academy academy) {
			AcademyForm result;

			result = new AcademyForm();

			result.setId(academy.getId());
			result.setUsername(academy.getUserAccount().getUsername());
			result.setPassword(academy.getUserAccount().getPassword());
			result.setPassword2(academy.getUserAccount().getPassword());
			result.setName(academy.getName());
			result.setAgreed(true);
			result.setIban(academy.getIban());
			result.setCity(academy.getCity());
			result.setAddress(academy.getAddress());
			result.setDescription(academy.getDescription());
			result.set

			return result;
		}
*/
		public Academy reconstruct(AcademyForm academyForm, BindingResult binding) {

			Academy result;

			String password;
			password = academyForm.getPassword();

			Assert.isTrue(academyForm.getPassword2().equals(password), "notEqualPassword");
			Assert.isTrue(academyForm.getAgreed(), "agreedNotAccepted");
			Assert.isTrue(validarCuentaBancaria(academyForm.getIban()), "badIban");

			if(academyForm.getId()==0){
				result = create();
			}else{
				result = academyRepository.findOne(academyForm.getId());
			}
			UserAccount userAccount;
			userAccount = new UserAccount();
			userAccount.setUsername(academyForm.getUsername());
			userAccount.setPassword(password);

			Authority authority;
			authority = new Authority();
			authority.setAuthority(Authority.ACADEMY);
			userAccount.addAuthority(authority);
			result.setUserAccount(userAccount);

			result.setName(academyForm.getName());
			result.setCity(academyForm.getCity());
			result.setAddress(academyForm.getAddress());
			result.setIban(academyForm.getIban());
			result.setDescription(academyForm.getDescription());
			result.setCif(academyForm.getCif());

			validator.validate(result, binding);

			return result;

		}
		

		public static Boolean validarCuentaBancaria(String cuenta){
			 
			String A = cuenta.substring(0, 1);
			String B = cuenta.substring(1, 2);
			
			List<String>letras = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
			Integer primero = 10+letras.indexOf(A);
			Integer segundo = 10+letras.indexOf(B);
			
			cuenta = primero.toString()+segundo.toString()+cuenta.substring(2);
			cuenta = cuenta.substring(6)+cuenta.substring(0, 6);
		
			BigInteger numero = new BigInteger(cuenta);
			BigInteger v = new BigInteger("97");
			BigInteger s = new BigInteger("1");
			BigInteger validador = numero.mod(v);
			
		    if (validador.compareTo(s)==0){
		        return true;
		    }else{
		        return false;
		    }
			
		}
		
		public Academy findByPrincipal() {
			Academy result;
			int userAccountId;

			userAccountId = LoginService.getPrincipal().getId();
			result = academyRepository.findByUserAccountId(userAccountId);

			return result;
		}
		
		public Double findAvgStars(Academy academy){
			Double result;
			result = academyRepository.fingAvgStars(academy);
			return result;
		}
		
		public void updateAvgStars(Academy academy){
			academy.setAvgStars(academyRepository.fingAvgStars(academy));
			save(academy);
		}
		
		public Academy encryptCreditCard(Academy academy) {
			Academy result = new Academy();
			
			result.setId(academy.getId());
			result.setUserAccount(academy.getUserAccount());
			result.setComments(academy.getComments());
			result.setName(academy.getName());
			result.setSocialIdentity(academy.getSocialIdentity());
			result.setCity(academy.getCity());
			result.setAddress(academy.getAddress());
			result.setDescription(academy.getDescription());
			result.setCif(academy.getCif());
			result.setIban("****************" + academy.getIban().substring(16));
			result.setAvgStars(academy.getAvgStars());
			result.setFeeAmount(academy.getFeeAmount());
			
			return result;
		}
	
}
