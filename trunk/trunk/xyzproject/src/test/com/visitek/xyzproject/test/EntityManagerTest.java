package com.visitek.xyzproject.test;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.stat.Statistics;

import com.visitek.xyzproject.model.business.Role;
import com.visitek.xyzproject.model.business.User;

import com.visitek.xyzproject.model.entity.Project;

/**
 * @author Gavin King
 */
public class EntityManagerTest extends TestCase {

	public Class[] getAnnotatedClasses() {
		return new Class[]{
				User.class,
				Role.class,
				Project.class				
		};
	}

	public Map<Class, String> getCachedClasses() {
		Map<Class, String> result = new HashMap<Class, String>();
		result.put( User.class, "read-write" );
		return result;
	}

	public Map<String, String> getCachedCollections() {
		Map<String, String> result = new HashMap<String, String>();
		result.put( User.class.getName() + ".roles", "read-write, RegionName" );
		return result;
	}

	// EM TRANSACTION
//	public void testEntityManager() {
//
//		Item item = new Item( "Mouse", "Micro$oft mouse" );
//
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		em.persist( item );
//		assertTrue( em.contains( item ) );
//		em.getTransaction().commit();
//
//		assertFalse( em.contains( item ) );
//
//		em.getTransaction().begin();
//		item = (Item) em.createQuery( "from Item where descr like 'M%'" ).getSingleResult();
//		assertNotNull( item );
//		assertEquals( "Micro$oft mouse", item.getDescr() );
//		item.setDescr( "Micro$oft wireless mouse" );
//		assertTrue( em.contains( item ) );
//		em.getTransaction().commit();
//
//		assertFalse( em.contains( item ) );
//
//		em.getTransaction().begin();
//		item = (Item) em.find( Item.class, "Mouse" );
//		assertNotNull( item );
//		em.getTransaction().commit();
//
//		item = em.find( Item.class, "Mouse" );
//		assertFalse( em.contains( item ) );
//
//		item = (Item) em.createQuery( "from Item where descr like 'M%'" ).getSingleResult();
//		assertNotNull( item );
//		assertFalse( em.contains( item ) );
//
//		em.getTransaction().begin();
//		item = em.find( Item.class, "Mouse" );
//		assertNotNull( item );
//		assertTrue( em.contains( item ) );
//		assertEquals( "Micro$oft wireless mouse", item.getDescr() );
//		em.remove( item );
//		em.remove( item );//second should be a no-op
//		em.getTransaction().commit();
//
//		em.close();
//	}

	public void testExtendedEntityManager() {

		User User = new User( "Mouse" );

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist( User );
		assertTrue( em.contains( User ) );
		em.getTransaction().commit();

		assertTrue( em.contains( User ) );

		em.getTransaction().begin();
		User User1 = (User) em.createQuery( "select i from User i where descr like 'M%'" ).getSingleResult();
		assertNotNull( User1 );
		assertSame( User, User1 );
		
		assertTrue( em.contains( User ) );
		em.getTransaction().commit();

		assertTrue( em.contains( User ) );

		em.getTransaction().begin();
		User1 = em.find( User.class, "Mouse" );
		assertSame( User, User1 );
		em.getTransaction().commit();
		assertTrue( em.contains( User ) );

		User1 = em.find( User.class, "Mouse" );
		assertSame( User, User1 );
		assertTrue( em.contains( User ) );

		User1 = (User) em.createQuery( "select i from User i where descr like 'M%'" ).getSingleResult();
		assertNotNull( User1 );
		assertSame( User, User1 );
		assertTrue( em.contains( User ) );

		em.getTransaction().begin();
		assertTrue( em.contains( User ) );
		em.remove( User );
		em.remove( User ); //Second should be no-op
		em.getTransaction().commit();
		em.close();

	}

	public void testConfiguration() throws Exception {
		User user = new User( "Mouse");
		Role res = new Role("hrd");

		user.setRoles(new HashSet<Role>());
		user.addRole(res);
		
		
		Statistics stats = ( (HibernateEntityManagerFactory) factory ).getSessionFactory().getStatistics();
		stats.clear();
		stats.setStatisticsEnabled( true );

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist( res );
		em.persist( user );
		assertTrue( em.contains( user ) );

		em.getTransaction().commit();
		em.close();

		assertEquals( 1, stats.getSecondLevelCachePutCount() );
		assertEquals( 0, stats.getSecondLevelCacheHitCount() );

		em = factory.createEntityManager();
		em.getTransaction().begin();
		User second = em.find( User.class, user.getUsername() );
		assertEquals( 1, second.getRoles().size() );
		assertEquals( 1, stats.getSecondLevelCacheHitCount() );
		em.getTransaction().commit();
		em.close();

		em = factory.createEntityManager();
		em.getTransaction().begin();
		second = em.find( User.class, user.getUsername() );
		assertEquals( 1, second.getRoles().size() );
		assertEquals( 3, stats.getSecondLevelCacheHitCount() );
		em.remove( second );
		em.remove( second.getRoles().iterator().next() );
		em.getTransaction().commit();
		em.close();

		stats.clear();
		stats.setStatisticsEnabled( false );
	}

	public void testContains() throws Exception {
		/*
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Integer nonManagedObject = new Integer( 4 );
		try {
			em.contains( nonManagedObject );
			fail( "Should have raised an exception" );
		}
		catch (IllegalArgumentException iae) {
			//success
			if ( em.getTransaction() != null ) em.getTransaction().rollback();
		}
		finally {
			em.close();
		}
		em = factory.createEntityManager();
		em.getTransaction().begin();
		User User = new User();
		User.setDescr( "Mine" );
		User.setName( "Juggy" );
		em.persist( User );
		em.getTransaction().commit();
		em.getTransaction().begin();
		User = em.getReference( User.class, User.getName() );
		assertTrue( em.contains( User ) );
		em.remove( User );
		em.getTransaction().commit();
		em.close();
		*/
	}

	public void testClear() throws Exception {
		/*
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Wallet w = new Wallet();
		w.setBrand( "Lacoste" );
		w.setModel( "Minimic" );
		w.setSerial( "0100202002" );
		em.persist( w );
		em.flush();
		em.clear();
		assertFalse( em.contains( w ) );
		em.getTransaction().rollback();
		em.close();
		*/
	}

	public void testFlushMode() throws Exception {
		EntityManager em = factory.createEntityManager();
		em.setFlushMode( FlushModeType.COMMIT );
		assertEquals( FlushModeType.COMMIT, em.getFlushMode() );
		( (HibernateEntityManager) em ).getSession().setFlushMode( FlushMode.ALWAYS );

		assertNull( em.getFlushMode() );
		em.close();
	}

	public void testPersistNoneGenerator() throws Exception {
		/*
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Wallet w = new Wallet();
		w.setBrand( "Lacoste" );
		w.setModel( "Minimic" );
		w.setSerial( "0100202002" );
		em.persist( w );
		em.getTransaction().commit();
		em.getTransaction().begin();
		Wallet wallet = em.find( Wallet.class, w.getSerial() );
		assertEquals( w.getBrand(), wallet.getBrand() );
		em.remove( wallet );
		em.getTransaction().commit();
		em.close();
		*/
	}

	public void testSerializableException() throws Exception {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try {
			Query query = em.createQuery( "SELECT p FETCH JOIN p.roles FROM User p" );
			query.getSingleResult();
		}
		catch (IllegalArgumentException e) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			ObjectOutput out = new ObjectOutputStream( stream );
			out.writeObject( e );
			out.close();
			byte[] serialized = stream.toByteArray();
			stream.close();
			ByteArrayInputStream byteIn = new ByteArrayInputStream( serialized );
			ObjectInputStream in = new ObjectInputStream( byteIn );
			IllegalArgumentException deserializedException = (IllegalArgumentException) in.readObject();
			in.close();
			byteIn.close();
			assertNull( deserializedException.getCause().getCause() );
			assertNull( e.getCause().getCause() );
		}
		em.getTransaction().rollback();
		em.close();


		Exception e = new HibernateException( "Exception", new NullPointerException( "NPE" ) );
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream( stream );
		out.writeObject( e );
		out.close();
		byte[] serialized = stream.toByteArray();
		stream.close();
		ByteArrayInputStream byteIn = new ByteArrayInputStream( serialized );
		ObjectInputStream in = new ObjectInputStream( byteIn );
		HibernateException deserializedException = (HibernateException) in.readObject();
		in.close();
		byteIn.close();
		assertNotNull( "Arbitrary exceptions nullified", deserializedException.getCause() );
		assertNotNull( e.getCause() );
	}

	public void testIsOpen() throws Exception {
		EntityManager em = factory.createEntityManager();
		assertTrue( em.isOpen() );
		em.getTransaction().begin();
		assertTrue( em.isOpen() );
		em.getTransaction().rollback();
		em.close();
		assertFalse( em.isOpen() );
	}

	//EJB-9
//	public void testGet() throws Exception {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		User User = (User) em.get(User.class, "nonexistentone");
//		try {
//			User.getDescr();
//			em.getTransaction().commit();
//			fail("Object with wrong id should have failed");
//		}
//		catch (EntityNotFoundException e) {
//			//success
//			if (em.getTransaction() != null) em.getTransaction().rollback();
//		}
//		finally {
//			em.close();
//		}
//	}

	public EntityManagerTest() {
		super();
	}

	public EntityManagerTest(String arg0) {
		super( arg0 );
	}

}

