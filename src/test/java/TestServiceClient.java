import com.amgenz.persistence.swappiDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swappi.Planet;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void getPlanetSuccess() {
        swappiDao dao = new swappiDao();
        assertEquals("Tatooine", dao.getPlanet().getName());
    }
}
