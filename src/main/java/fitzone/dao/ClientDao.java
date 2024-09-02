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
        PreparedStatement ps;
        ResultSet rs;
        
        Connection con = getConnection();
        var sql = "SELECT * FROM client WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
                client.setName(rs.getString("Name"));
                client.setSurname(rs.getString("Surname"));
                client.setMembresy(rs.getString("Membresy"));
                
                return true;
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
        return false;
    }

    @Override
    public boolean addClient(Client client) {
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "INSERT INTO client(Name, Surname, Membresy) "
                + "VALUES (?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setString(3, client.getMembresy());
            ps.execute();
            
            return true;
        }catch(Exception e){
            System.out.println("Error al añadir cliente: "+e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean updateClient(Client client) {
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "UPDATE client SET Name = ?, Surname = ?, Membresy = ?"
                + " WHERE id = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setString(3, client.getMembresy());
            ps.setInt(4, client.getId());
            ps.execute();
            
            return true;
        }catch(Exception e){
            System.out.println("Error al modificar clientes: "+e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteClient(Client client) {
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "DELETE FROM client WHERE id = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
            ps.execute();
            
            return true;
        }catch(Exception e){
            System.out.println("Error al borrar clientes: "+e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }
        }
        return false;
    }
    
//    public static void main(String[] args) {
//        IClientDao clientDao = new ClientDao();
        
        /*LIST CLIENTS*/
//        var clients = clientDao.listClients();
//        clients.forEach(System.out::println);
//        var client = new Client(2);

        /*LIST CLIENT BY ID*/
//        System.out.println("Cliente antes de la búsqueda: "+client);
//        var findClient = clientDao.findClientById(client);
//        if(findClient){
//            System.out.println("Cliente encontrado: "+client);
//        }else{
//            System.out.println("No se encontro registro: "+client.getId());
//        }

        /*CREATE CLIENT*/
//        var newClient = new Client("Danna","Carranco","300");
//        var addClient = clientDao.addClient(newClient);
//        if(addClient){
//            System.out.println("Cliente agregado: "+newClient);
//        }else{
//            System.out.println("No se agrego el cliente: "+newClient);
//        }
        
        /*UPDATE CLIENT*/
//        var modifyClient = new Client(4,"Alexandra","Vizuete","500");
//        var checkUpdate = clientDao.updateClient(modifyClient);
//        if(checkUpdate){
//            System.out.println("Cliente modificado: "+modifyClient);
//        }else{
//            System.out.println("No se modifico el cliente: "+modifyClient);
//        }

        /*DELETE CLIENTS*/
//        var deleteClient = new Client(4);
//        var deleteCheck = clientDao.deleteClient(deleteClient);
//        if(deleteCheck){
//            System.out.println("Cliente borrado: ");
//        }else{
//            System.out.println("No se borro el cliente: "+deleteClient);
//        }
//
//        System.out.println("");
//        var clients = clientDao.listClients();
//        clients.forEach(System.out::println);
//    }
}
