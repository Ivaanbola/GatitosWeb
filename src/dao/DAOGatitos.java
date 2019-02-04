package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Singleton.DBConnection;
import modelo.Gatitos;

public class DAOGatitos {

	public static void insertar(Gatitos gatito) {
		Session sesion = DBConnection.getSession().openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.save(gatito);
		tx.commit();
		sesion.close();
	}

	public static void actualizar(Gatitos gatito) {

		Session sesion = DBConnection.getSession().openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.update(gatito);
		tx.commit();
		sesion.close();
	}

	public static void borrar(Gatitos gatito) {

		Session sesion = DBConnection.getSession().openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.delete(gatito);
		tx.commit();
		sesion.close();
	}

	public static Gatitos buscar(Integer id) {
		Gatitos gatito = null;

		Session sesion = DBConnection.getSession().openSession();
		Transaction tx = sesion.beginTransaction();
		gatito = (Gatitos) sesion.get(Gatitos.class, id);
		tx.commit();
		sesion.close();
		return gatito;
	}

	public static List<Gatitos> listarGatitos() {
		List<Gatitos> lista = null;

		Session sesion = DBConnection.getSession().openSession();
		Transaction tx = sesion.beginTransaction();
		lista = (List<Gatitos>) sesion.createCriteria(Gatitos.class).list();
		tx.commit();
		sesion.close();
		return lista;
	}

}
/*
	public static List<Gatitos> BuscarPorNombre(String nombre) {
		Session sesion = Conexion.getSesion().openSession();
		sesion.beginTransaction();

		Query q = sesion.createQuery("FROM Gatitos g WHERE g.nombre = :nombre");
		q.setParameter("nombre", nombre);
		List<Gatitos> result = q.list();

		sesion.getTransaction().commit();
		sesion.close();
		return result;
	} // mapeado

	public static List<Gatitos> todosMapeados() {
		Session sesion = Conexion.getSesion().openSession();
		sesion.beginTransaction();
		Query q = sesion.getNamedQuery("dameTodosPorRaza");
		q.setParameter("raza", "British");
		List<Gatitos> result = q.list();
		sesion.getTransaction().commit();
		sesion.close();
		return result;
	}

	public static List<Gatitos> obtenerTodos() {
		Session sesion = Conexion.getSesion().openSession();
		sesion.beginTransaction();

		Query q = sesion.createQuery("from Gatitos");
		List<Gatitos> result = q.list();
		sesion.getTransaction().commit();
		sesion.close();
		return result;
	}

	public static List<Gatitos> listar() { Session sesion =
  Conexion.getSesion().openSession(); sesion.beginTransaction();
  
  List<Gatitos> result =
  (List<Gatitos>)sesion.createCriteria(Gatitos.class).list(); //List<Gatitos>
  result = sesion.createSQLQuery("from modelo.Gatitos as cat").list();
  sesion.getTransaction().commit(); sesion.close(); return result; }
*/