import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.alura.leilao.dao.LeilaoDao;
import br.com.alura.leilao.model.Leilao;;

public class HelloWordMockito {
    
    @Test
    void hello() {
        LeilaoDao mock = mock(LeilaoDao.class);
        List<Leilao> todos =  mock.buscarTodos();
        assertTrue(todos.isEmpty());
    }

}
