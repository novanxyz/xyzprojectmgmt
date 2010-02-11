package com.visitek.xyzproject.test;



import javax.persistence.EntityManager;

import org.testng.annotations.Test;

import com.visitek.xyzproject.model.business.Role;
import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.service.RoleService;
import com.visitek.xyzproject.service.UserService;

/*
// For validation query in native SQL
@SqlResultSetMapping(
    name = "PriceSellerResult",
    columns = {
        @ColumnResult(name = "IP"),
        @ColumnResult(name = "SID")

    }
)
*/

public class PersistentStateTransitions extends EJB3IntegrationTest {

    protected void prepareSettings() {
        //dataSetLocation = "auction/test/basedata.xml";
        //beforeTestOperations.add(DatabaseOperation.CLEAN_INSERT);
    }

    /**
     * This test doesn't really need the EJB container, it starts a UserTransaction
     * manually and instantiates DAOs directly. However, the datasource is still
     * managed by the container. The EntityManagerFactory is also handled by the
     * container.
     */
    @Test(groups = "integration-persistence")
    public void withoutEJBContainer() throws Exception {

        // Start a unit of work (manually, no container)
        getUserTransaction().begin();
        EntityManager em = getEntityManagerFactory().createEntityManager();

        // Prepare the DAOs (manually, no Seam)
        
        
        
        
        RoleService roles = new RoleService();        
        Role role = roles.load(0L);
        
        UserService users = new UserService();
        User user = users.load(0L);
        
        user.addRole(role);        
        users.persist(user);
       

       // End the unit of work
        getUserTransaction().commit();
        em.close();


        // Direct SQL query for database state in auto-commit mode
        /*
        em = getEntityManagerFactory().createEntityManager();
        
        Object[] result = (Object[])
                em.createNativeQuery(
                        "select INITIAL_PRICE as IP," +
                        "       SELLER_ID as SID from ITEM where ITEM_ID = :itemId")
                        .setParameter("itemId", newItem.getId())
                        .getSingleResult();
        em.close();


        // Assert correctness of state
        assert result[0].getClass() == BigDecimal.class;
        assert result[0].equals(newItem.getInitialPrice().getValue());
        // The SQL resultset mapping returns a BigInteger
        assert result[1].equals(new BigInteger("1"));
        */
    }

    /**
     * This test looks up the DAOs as managed EJBs. The DAOs will have the
     * current persistence context injected automatically, the persistence
     * context is scoped and bound to the JTA transaction.
     */
    @Test(groups = "integration-persistence")
    public void withEJBContainer() throws Exception {

        // Start a unit of work (manually, no Seam)
        getUserTransaction().begin();

        // Prepare the DAOs (manually, no Seam)
        RoleService roles = lookupLocalBean(RoleService.class, "RoleServiceBean");                
        UserService users = lookupLocalBean(UserService.class, "UserServiceBean");
        
        Role role = roles.load(0L);
        User user = users.load(0L);
        
        user.addRole(role);        
        users.persist(user);

        /*
        

        // Prepare a user object
        User user = userDAO.findById(1l, false);

        // Make a new auction item persistent
        Calendar startDate = GregorianCalendar.getInstance();
        Calendar endDate = GregorianCalendar.getInstance();
        endDate.add(Calendar.DAY_OF_YEAR, 3);

        MonetaryAmount initialPrice =
            new MonetaryAmount(new BigDecimal(123), Currency.getInstance("USD"));
        MonetaryAmount reservePrice =
            new MonetaryAmount(new BigDecimal(333), Currency.getInstance("USD"));

        Item newItem =
            new Item( "Testitem", "Test Description", user,
                      initialPrice, reservePrice,
                      startDate.getTime(), endDate.getTime() );

        // Don't forget to take the return value, this is basically a merge()
        newItem = itemDAO.makePersistent(newItem);

        // End the unit of work
        


        // Direct SQL query for database state in auto-commit mode
        EntityManager em = getEntityManagerFactory().createEntityManager();
        Object[] result = (Object[])
                em.createNativeQuery(
                        "select INITIAL_PRICE as IP," +
                        "       SELLER_ID as SID from ITEM where ITEM_ID = :itemId")
                        .setParameter("itemId", newItem.getId())
                        .getSingleResult();
        em.close();


        // Assert correctness of state
        assert result[0].getClass() == BigDecimal.class;
        assert result[0].equals(newItem.getInitialPrice().getValue());
        // The SQL resultset mapping returns a BigInteger
        assert result[1].equals(new BigInteger("1"));
        */
        getUserTransaction().commit();
    }


}
