package app.trybe.specialityapp.service;

import app.trybe.specialityapp.commons.NoProfessionalsException;
import app.trybe.specialityapp.commons.ProfessionalCreatesWithIdException;
import app.trybe.specialityapp.commons.ProfessionalNotExistsException;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {

  @Autowired
  private ProfessionalRepository professionalRepository;

  public Professional findById(Integer id) {
    return professionalRepository.findById(id).get();
  }

  /**
   * list all professionals.
   * @return list of professionals or an error.
   * @throws NoProfessionalsException if there are no professionals.
   */
  public List<Professional> findAll() throws NoProfessionalsException {
    List<Professional> professionals = professionalRepository.findAll();
    if (professionals.isEmpty()) {
      throw new NoProfessionalsException();
    }

    return professionals;
  }

  /**
   * insert a new professional.
   * @param professional professional to be inserted.
   * @return message or error.
   * @throws ProfessionalCreatesWithIdException if the professional object has Id.
   */
  public String insert(Professional professional) throws ProfessionalCreatesWithIdException {
    if (professional.getId() != null) {
      throw new ProfessionalCreatesWithIdException();
    }
    professionalRepository.save(professional);
    return "Inserido";
  }

  /**
   * delete a existent professional.
   * @param id professional id.
   * @return message or error.
   * @throws ProfessionalNotExistsException if the professional does not exist.
   */
  public String delete(Integer id) throws ProfessionalNotExistsException {
    Optional<Professional> professional = professionalRepository.findById(id);
    if (professional.isEmpty()) {
      throw new ProfessionalNotExistsException("Não é possível deletar, o ID informado não existe");
    }
    professionalRepository.delete(professional.get());
    return "ID [" + id + "] removido";
  }

  /**
   * update a existent professional.
   * @param id professional id.
   * @return message or error.
   * @throws ProfessionalNotExistsException if the professional does not exist.
   */
  public String edit(Integer id, Professional professional) throws ProfessionalNotExistsException {
    Optional<Professional> professionalToUpdate = professionalRepository.findById(id);
    if (professionalToUpdate.isEmpty()) {
      throw new ProfessionalNotExistsException("Não é possível editar, o ID informado não existe");
    }
    professionalToUpdate.get().setName(professional.getName());
    professionalToUpdate.get().setSpeciality(professional.getSpeciality());
    professionalRepository.save(professionalToUpdate.get());
    return "ID [" + id + "] atualizado";
  }
}
