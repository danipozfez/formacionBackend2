package block5logging.block5logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;


@RestController
public class Controller {
    static Logger logger = LoggerFactory.getLogger(Controller.class);


    public String index() {
        logger.error("Mensaje a nivel de ERROR");
        logger.warn("Mensaje a nivel de WARNING");

        return "mira los mensajes";

    }
}
