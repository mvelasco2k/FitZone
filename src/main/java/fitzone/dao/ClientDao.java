/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitzone.dao;

import static fitzone.conection.Conexion.getConnection;
import fitzone.domain.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateo Velasco
 */
public class ClientDao implements IClientDao{

    @Override
    public List<Client> listClients() {
        List<Client> clients = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        Connection con = getConnection();
        var sql = "SELECT * FROM client ORDER BY id";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                var client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("Name"));
                client.setSurname(rs.getString("Surname"));
                client.setMembresy(rs.getString("Membresy"));
                
                clients.add(client);
            }
        }catch(Exception e){
            System.out.println("Error al listar clientes: "+e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }
        }
        return clients;
    }

    @Override
    public boolean findClientById(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        System.out.println("**Listado de Clientes**");
        IClientDao clientDao = new ClientDao();
        var clients = clientDao.listClients();
        clients.forEach(System.out::println);
    }
}
