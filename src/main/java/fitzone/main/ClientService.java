/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitzone.main;

import fitzone.dao.ClientDao;
import fitzone.dao.IClientDao;
import fitzone.domain.Client;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mateo Velasco
 */
public class ClientService {
    public static IClientDao clientDao = new ClientDao();
    
    public static void main(String[] args) {
        System.out.println("**MENU DE OPCIONES**");
        Scanner input = new Scanner(System.in);
        String option = "";
        boolean loop = true;
        do{
            System.out.println("1. Listar Clientes");
            System.out.println("2. Buscar Cliente por ID");
            System.out.println("3. Agregar Cliente");
            System.out.println("4. Modificar Cliente");
            System.out.println("5. Eliminar Cliente");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            option = input.nextLine();
            System.out.println("");
            
            switch(option){
                case "1":
                    System.out.println("**LISTADO DE CLIENTES**");
                    listClients();
                    break;
                case "2":
                    System.out.println("**BÚSQUEDA DE CLIENTE POR ID**");
                    clientById(input);
                    break;
                case "3":
                    System.out.println("**AGREGAR CLIENTE**");
                    createClient(input);
                    break;
                case "4":
                    System.out.println("**MODIFICAR CLIENTE**");
                    updateClient(input);
                    break;
                case "5":
                    System.out.println("**ELIMINAR CLIENTE**");
                    deleteClient(input);
                    break;
                case "6":
                    System.out.println("Gracias por utilizar el sistema de FitZone");
                    loop = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta");
                    break;
            }
        }while(loop);
    }
    
    public static void listClients(){
        List<Client> listClients = clientDao.listClients();
        listClients.forEach(System.out::println);
        System.out.println("");
    }
    public static void clientById( Scanner idQuery){
        System.out.print("Ingrese el id del cliente que desea buscar: ");
        String search = idQuery.nextLine();
        Client c = new Client(Integer.parseInt(search));
        boolean clientExist = clientDao.findClientById(c);
        
        if(clientExist){
            System.out.println("Cliente encontrado: "+c);
        }else{
            System.out.println("Cliente no encontrado");
        }
        System.out.println("");
    }
    public static void createClient(Scanner data){
        System.out.print("Ingrese el nombre del nuevo cliente: ");
        String name = data.nextLine();
        System.out.print("Ingrese el apellido del nuevo cliente: ");
        String surname = data.nextLine();
        System.out.print("Ingrese la membresía del nuevo cliente: ");
        String membresy = data.nextLine();
        
        Client newClient = new Client(name, surname, membresy);
        boolean verification = clientDao.addClient(newClient);
        
        if(verification){
            System.out.println("Cliente agregado: "+newClient);
        }else{
            System.out.println("Error al agregar cliente");
        }
        System.out.println("");
    }
    public static void updateClient(Scanner newData){
        System.out.print("Ingrese el id del cliente a modificar: ");
        String idClient = newData.nextLine();
        System.out.print("Ingrese el nombre modificado: ");
        String name = newData.nextLine();
        System.out.print("Ingrese el apellido modificado: ");
        String surname = newData.nextLine();
        System.out.print("Ingrese la membresía modificada: ");
        String membresy = newData.nextLine();
        
        Client updateClient = new Client(Integer.parseInt(idClient), name, surname, membresy);
        boolean verification = clientDao.updateClient(updateClient);
        
        if(verification){
            System.out.println("Cliente modificado: "+updateClient);
        }else{
            System.out.println("Error al modificar el cliente");
        }
        System.out.println("");
    }
    public static void deleteClient(Scanner input){
        System.out.print("Ingrese el id del cliente que desea eliminar: ");
        String idClient = input.nextLine();
        
        Client deleteClient = new Client(Integer.parseInt(idClient));
        boolean verification = clientDao.deleteClient(deleteClient);
        
        if(verification){
            System.out.println("Cliente borrado");
        }else{
            System.out.println("Error al borrar el cliente");
        }
        System.out.println("");
    }
}
