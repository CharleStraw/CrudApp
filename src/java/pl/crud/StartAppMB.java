
package pl.crud;






import javax.faces.bean.ManagedBean;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;






@ManagedBean
public class StartAppMB{

 


  
    private int id;
  
    private String pesel;
   
    private String name;
 
    private String tele;
   
    private String email;
   
    private String pesel1;
    
    private String name1;
    
    private String tele1;
   
    private String email1;
    
   
    private String delete;
   
    private String update;
 
    private String peselWeb;

    final static Logger logger = Logger.getLogger(StartAppMB.class);

   
     
 
    
    
    public  void  addPerson(){
      
        
        
        
//        conect con= new conect();
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("peselDatabase1");
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      
      person per=new person();
      per.setPesel(pesel);
      per.setName(name);
      per.setTel(tele);
      per.setEmail(email);

     
      entityManager.getTransaction().begin();
      entityManager.persist(per);
    
      entityManager.getTransaction().commit();
      
      entityManager.close();
      entityManagerFactory.close();
      
     logger.debug(pesel + " hello  debug from add person");
      
        
    }
    
     public  void  readPerson(){
      
//        conect con= new conect();
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("peselDatabase1");
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      
      entityManager.getTransaction().begin();
      TypedQuery<person> query = entityManager.createQuery("select e from person e where e.name = :name", person.class);
      query.setParameter("name",name);
      person per = query.getSingleResult();
      
      name1=per.getName();
      email1=per.getEmail();
      pesel1=per.getPesel();
      tele1=per.getTel();
      
      
      System.out.println("pl.crud.StartAppMB.readPerson()" + per.getEmail() + per.getPesel()  + "udało się");
      entityManager.getTransaction().commit();
      
      entityManager.close();
      entityManagerFactory.close();
     }
      
 public void updatePerson(){
     
     
     
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("peselDatabase1");
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      
      entityManager.getTransaction().begin();
   
      TypedQuery<person> query = entityManager.createQuery("select e from person e where e.name = :name", person.class);
      query.setParameter("name",name);
      person per = query.getSingleResult();
      entityManager.merge(per).setEmail(email);
      
      
      
      delete="zaktualizowano osobę";
      
      System.out.println(" update Person method");
      entityManager.getTransaction().commit();
      
      entityManager.close();
      entityManagerFactory.close();
    
     
     
     
 }
        
   
    
     
     
     
     
    

    
     
     
     public  void  deletePerson(){
      
//        conect con= new conect();
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("peselDatabase1");
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      
      entityManager.getTransaction().begin();
   
      TypedQuery<person> query = entityManager.createQuery("select e from person e where e.name = :name", person.class);
      query.setParameter("name",name);
      person per = query.getSingleResult();
      entityManager.remove(per);
      
      delete="SKASOWANO OSOBĘ";
      
      System.out.println(" update Person method");
      entityManager.getTransaction().commit();
      
      entityManager.close();
      entityManagerFactory.close();
        
    }

    public int getId() {
        return id;
    }

    public String getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    public String getTele() {
        return tele;
    }

    public String getEmail() {
        return email;
    }

    public String getPesel1() {
        return pesel1;
    }

    public String getName1() {
        return name1;
    }

    public String getTele1() {
        return tele1;
    }

    public String getEmail1() {
        return email1;
    }

    public String getDelete() {
        return delete;
    }

    public String getUpdate() {
        return update;
    }

    public String getPeselWeb() {
        return peselWeb;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPesel1(String pesel1) {
        this.pesel1 = pesel1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public void setPeselWeb(String peselWeb) {
        this.peselWeb = peselWeb;
    }

      
     
     
     
     
     
    
}
