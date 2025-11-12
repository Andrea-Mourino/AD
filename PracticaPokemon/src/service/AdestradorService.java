package service;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdestradorService {


    public static void insertAdestrador(Adestrador adestradorParaInsertar){
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.save(adestradorParaInsertar);
            transaccion.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static List<Adestrador> leerAdestrador() {
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            List <Adestrador> listaAdestrador = sesion.createQuery("from Adestrador", Adestrador.class).getResultList();
            return listaAdestrador;

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static void actualizarAdestradorNome (Adestrador adestradorParaActualizar, String nuevoNombre){
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            adestradorParaActualizar.setNome(nuevoNombre);
            sesion.update(adestradorParaActualizar);
            transaccion.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void eliminarAdestradorUno (Adestrador adestradorParaEliminarUno) {
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.delete(adestradorParaEliminarUno);
            transaccion.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarAdestradorTodos () {
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.createQuery("DELETE from Adestrador").executeUpdate();
            transaccion.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
