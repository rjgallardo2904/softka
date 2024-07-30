package sofka.gallardo.AccountHolder.Controller;

import static org.mockito.Mockito.*;


import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sofka.gallardo.AccountHolder.Entity.ClientEntity;
import sofka.gallardo.AccountHolder.Enum.StateCustom;
import sofka.gallardo.AccountHolder.Service.Impl.ClientServiceImpl;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClientServiceImpl clientService;

    @Test
    public void testCrearClient() throws Exception {
        ClientEntity cliente = new ClientEntity(null, "Abc123", StateCustom.ACTIVO);
        ClientEntity nuevoCliente = new ClientEntity(1L, "Abc123", StateCustom.ACTIVO);

        when(clientService.createClient(any(ClientEntity.class))).thenReturn(nuevoCliente);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/client/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\":\"espe\",\n" +
                                "    \"genre\":\"OTROS\",\n" +
                                "    \"ege\": 25,\n" +
                                "    \"dni\":\"0550111348\",\n" +
                                "    \"address\": \"Ave\",\n" +
                                "    \"phone\":\"0963787859\",\n" +
                                "    \"password\":\"sdads\",\n" +
                                "    \"state\": \"ACTIVO\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(clientService).createClient(any(ClientEntity.class));
    }
}
