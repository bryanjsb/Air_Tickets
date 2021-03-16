package example;

/**
 * @author bryan
 */

/*http://chuwiki.chuidiang.org/index.php?title=Ejemplo_de_servicios_REST_con_JSON_y_contenedor_JEE*/
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/service/")
public class service {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Data> getData() {
        List<Data> result = new LinkedList<>();
        result.add(new Data(1, "one"));
        result.add(new Data(2, "two"));
        return result;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Data getData(@PathParam("id") String id) {
        if ("1".equals(id)) {
            return new Data(1, "one");
        }
        if ("2".equals(id)) {
            return new Data(2, "two");
        }
        throw new WebApplicationException(404);
    }

}
