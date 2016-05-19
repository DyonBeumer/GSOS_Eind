package nl.hu.fnt.gsos.rest;


import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/tracks")
public class RestController {
public static TrackService tf = new TrackService();
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Track> getTracks() {
		 
	return tf.getTracklist();

     }
	@GET
	@Path("/count")
	@Produces({MediaType.APPLICATION_JSON})
	public int getAfstand(){
 
		return tf.getTracklist().size();

     }
	@GET
	@Path("/{1}")
	@Produces({MediaType.APPLICATION_JSON})
	public Track getTrack(@PathParam("1") int id) {
		 return tf.getTracklist().get(id-1);
     }
	@PUT
	@Path("")
	@Produces({MediaType.APPLICATION_JSON})
	public String addTrack() {
		 
		tf.getTracklist().add(new Track("Testtrack"));
		return "track added";

     }
	@DELETE
	@Path("/{1}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteTrack(@PathParam("1") int id) {
		 
		tf.getTracklist().remove(id-1);
		return "track removed";

     }
}