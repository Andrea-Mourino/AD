package service;

import config.HibernateConfig;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokedexService {

    public static void insertPokedex(Pokedex pokedexParaInsertar){
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.save(pokedexParaInsertar);
            transaccion.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static List <Pokedex> leerPokedex() {
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            List <Pokedex> listaPokedex = sesion.createQuery("from Pokedex", Pokedex.class).getResultList();
            return listaPokedex;

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static void actualizarPokedexNome (Pokedex pokedexParaActualizar, String nuevoNombre){
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            pokedexParaActualizar.setNome(nuevoNombre);
            sesion.update(pokedexParaActualizar);
            transaccion.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //esto es para eliminar solo un Pokedex
    public static void eliminarPokedexUno (Pokedex podekexParaEliminarUno) {
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.delete(podekexParaEliminarUno);
            transaccion.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //esto es para que en caso de que pida eliminar todos los Pokedex
    public static void eliminarPokedexTodos () {
        try (Session sesion = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaccion = sesion.beginTransaction();
            sesion.createQuery("DELETE from Pokedex").executeUpdate();
            transaccion.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
