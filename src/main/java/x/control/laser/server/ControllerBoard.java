package x.control.laser.server;

import x.control.laser.entity.Dto.lampDto;
import x.control.laser.enums.Deal;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public interface ControllerBoard {

    void openAll(boolean state) throws IOException;

    void openById(boolean state , Long id) throws IOException;


    void OpenOrClose(lampDto dto);
}
