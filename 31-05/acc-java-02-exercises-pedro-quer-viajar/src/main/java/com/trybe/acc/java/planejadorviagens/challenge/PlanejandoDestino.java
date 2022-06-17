package com.trybe.acc.java.planejadorviagens.challenge;

import com.trybe.acc.java.planejadorviagens.model.Country;
import com.trybe.acc.java.planejadorviagens.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanejandoDestino {

  @Autowired
  private CountryRepository countryRepository;

  /**
   * Implemente a inserção.
   */
  public void inserir() {
    countryRepository.save(new Country("BRASIL", "BRASILIA", null));
    countryRepository.save(new Country("ARGENTINA", "BUENOS AIRES", null));
    countryRepository.save(new Country("URUGUAI", "MONTEVIDEO", null));
    countryRepository.save(new Country("PANAMA", "CIDADE DO PANAMA", null));

  }

  /**
   * Implemente a atualização.
   */
  public void corrigir() {
    Country country = countryRepository.findByName("BRASIL").get(0);
    country.setDdi("+55");
    countryRepository.save(country);

    country = countryRepository.findByName("ARGENTINA").get(0);
    country.setDdi("+54");
    countryRepository.save(country);

    country = countryRepository.findByName("URUGUAI").get(0);
    country.setDdi("+598");
    countryRepository.save(country);

    country = countryRepository.findByName("PANAMA").get(0);
    country.setDdi("+507");
    countryRepository.save(country);

  }

  /**
   * Implemente a exclusão.
   */
  public void excluir() {
    Country country = countryRepository.findByName("PANAMA").get(0);
    countryRepository.delete(country);
  }
}
