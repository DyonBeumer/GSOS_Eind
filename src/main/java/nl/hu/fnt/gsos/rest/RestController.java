package nl.hu.fnt.gsos.rest;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class RestController {
public static src.businesslogic.BusinessLogicController b = new src.businesslogic.BusinessLogicController();
	@GET
	@Path("{stad}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getTracks(@PathParam("stad") String stad) {

		return "";
     }
}