package nl.yc2309.javahotel.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.yc2309.javahotel.domein.Account;
import nl.yc2309.javahotel.dto.LoginRequestDto;
import nl.yc2309.javahotel.dto.LoginResponseDto;
import nl.yc2309.javahotel.persistence.AccountService;

@RestController
public class AccountEndpoint {

	@Autowired
	private AccountService accountService;

	@PostMapping("login")
	public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
		// Check of als er een account is met die email en wachtwoord
		Optional<? extends Account> accountOptional = accountService.login(dto.getEmail(), dto.getWachtwoord());
		if (accountOptional.isEmpty()) {
			// Als er geen account is gevonden dan geven we reposonsedto terug die succes false heeft
			return new LoginResponseDto(false);
		}

		// Haal de gevonden account op uit de optional 
		Account account = accountOptional.get();

		// Geef een login response dto terug met de nieuwe token en de role van de account 
		return new LoginResponseDto(account.getToken(), account.getRole(), account.getVoornaam() + " " + account.getAchternaam());
	}

}
