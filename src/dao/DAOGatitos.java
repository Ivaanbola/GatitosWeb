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
