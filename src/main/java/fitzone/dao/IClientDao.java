/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitzone.dao;

import java.util.List;
import fitzone.domain.Client;

/**
 *
 * @author Mateo Velasco
 */
public interface IClientDao {
    List<Client> listClients();
    boolean findClientById(Client client);
    boolean addClient(Client client);
    boolean updateClient(Client client);
    boolean deleteClient(Client client);
}
