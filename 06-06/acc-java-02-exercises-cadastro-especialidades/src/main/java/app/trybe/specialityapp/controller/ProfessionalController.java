package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.commons.NoProfessionalsException;
import app.trybe.specialityapp.commons.ProfessionalCreatesWithIdException;
import app.trybe.specialityapp.commons.ProfessionalNotExistsException;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/professional")
public class ProfessionalController {

  @Autowired
  private ProfessionalService professionalService;

  /**
   * list all professionals.
   * 
   * @return list of professionals or an error.
   */
  @GET
  @Produces("application/json")
  @Path("/all")
  public Response findAll() {
    try {
      List<Professional> professionals = professionalService.findAll();
      return Response.status(Status.OK).entity(professionals).build();
    } catch (NoProfessionalsException e) {
      return Response.status(Status.NOT_FOUND)
        .entity(new ApplicationError(e.getMessage(), Status.NOT_FOUND)).build();
    }
  }

  /**
   * insert a new professional.
   * 
   * @param professional professional to be inserted.
   * @return message or error.
   */
  @POST
  @Consumes("application/json")
  @Produces("application/json")
  @Path("/add")
  public Response insert(Professional professional) {
    try {
      String created = professionalService.insert(professional);
      return Response.status(Status.CREATED).entity(created).build();
    } catch (ProfessionalCreatesWithIdException e) {
      return Response.status(Status.BAD_REQUEST)
        .entity(new ApplicationError(e.getMessage(), Status.BAD_REQUEST)).build();
    }
  }

  /**
   * edit a professional.
   * 
   * @param id the id.
   * @param professional the professional edits.
   * @return message or error.
   */
  @PUT
  @Path("/edit/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response edit(@PathParam("id") Integer id, Professional professional) {
    try {
      String updated = professionalService.edit(id, professional);
      return Response.status(Status.OK).entity(updated).build();
    } catch (ProfessionalNotExistsException e) {
      return Response.status(Status.NOT_FOUND)
        .entity(new ApplicationError(e.getMessage(), Status.NOT_FOUND)).build();
    }
  }

  /**
   * delete a professional.
   * 
   * @param id professional id.
   * @return message or error.
   */
  @DELETE
  @Path("/delete/{id}")
  @Produces("application/json")
  public Response delete(@PathParam("id") Integer id) {
    try {
      String deleted = professionalService.delete(id);
      return Response.status(Status.OK).entity(deleted).build();
    } catch (ProfessionalNotExistsException e) {
      return Response.status(Status.NOT_FOUND)
        .entity(new ApplicationError(e.getMessage(), Status.NOT_FOUND)).build();
    }
  }
}
