/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orize.bean;

import com.orize.dao.CommentaireDAO;
import com.orize.dao.GroupeDAO;
import com.orize.dao.ImageDAO;
import com.orize.dao.InscriptionDAO;
import com.orize.dao.ProfilDAO;
import com.orize.dao.ProjetDAO;
import com.orize.dao.PublicationDAO;
import com.orize.dao.UtilisateurDAO;
import com.orize.entity.Groupe;
import com.orize.entity.Profil;
import com.orize.entity.Commentaire;
import com.orize.entity.Image;
import com.orize.entity.Inscription;
import com.orize.entity.Projet;
import com.orize.entity.Publication;
import com.orize.entity.Utilisateur;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.jboss.weld.context.ejb.Ejb;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.MindmapNode;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FileUploadEvent;
import com.orize.dao.MembreProjetDAO;
import com.orize.dao.PlanningDAO;
import com.orize.dao.PublicationDAO1;
import com.orize.entity.MembreProjet;
import com.orize.entity.Planning;
import com.orize.entity.Publication1;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    @Ejb
    private UtilisateurDAO userDAO = new UtilisateurDAO();
    private List<Utilisateur> users;
    private String hide = "";
    private Utilisateur user = new Utilisateur();
    private Utilisateur userNew = new Utilisateur();
    private Utilisateur userToDelete = new Utilisateur();
    private Profil profil = new Profil();
    private MindmapNode selectedNode;
    private Groupe groupe = new Groupe();
    private Groupe groupenew = new Groupe();
    private List<Publication> publications;
     private List<Publication1> publications1;
    private List<Groupe> groupes = new ArrayList<Groupe>();
    private List<Inscription> inscrips;
    private Publication publication = new Publication();
    private Publication newpublication = new Publication();
    private Publication1 publication1 = new Publication1();
    private Publication1 newpublication1 = new Publication1();
    private List<Commentaire> commentaires;
    private Commentaire commentaire = new Commentaire();
    private CommentaireDAO commentDAO = new CommentaireDAO();
    private PublicationDAO publicationDAO = new PublicationDAO();
     private PublicationDAO1 publicationDAO1 = new PublicationDAO1();
    private GroupeDAO groupeDao = new GroupeDAO();
    private ImageDAO imageDAO = new ImageDAO();
    private String path;
    private Image image;
    private ProfilDAO profilDAO = new ProfilDAO();
    private Profil profilnew = new Profil();
    private Projet projet = new Projet();
    private Projet selectprojet = new Projet();
    private ProjetDAO projetDAO = new ProjetDAO();
    private List<Profil> membres = new ArrayList<Profil>();
    private List<Profil> membresselct = new ArrayList<Profil>();
    private String role;
    private MembreProjetDAO mpdao = new MembreProjetDAO();
    private MembreProjet membreprojet = new MembreProjet();
    private InscriptionDAO inscriptionDAO = new InscriptionDAO();
    private Inscription inscrit = new Inscription();
    private String hidden = "true";
    private Planning tache = new Planning();
    private List<Planning> taches ;
    private PlanningDAO planingDAO = new PlanningDAO();
    private List<Projet> projects ;

    public UserBean() {
    }

    public Utilisateur getUserToDelete() {
        return userToDelete;
    }

    public void setUserToDelete(Utilisateur userToDelete) {
        this.userToDelete = userToDelete;
    }

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<Planning> getTaches() {
        return taches;
    }

    public void setTaches(List<Planning> taches) {
        this.taches = taches;
    }
    

    public List<Projet> getProjects() {
        return projects;
    }

    public void setProjects(List<Projet> projects) {
        this.projects = projects;
    }

    
    public Projet getSelectprojet() {
        return selectprojet;
    }

    public void setSelectprojet(Projet selectprojet) {
        this.selectprojet = selectprojet;
    }

    public List<Profil> getMembres() {
        return membres;
    }

    public void setMembres(List<Profil> membres) {
        this.membres = membres;
    }

    public List<Profil> getMembresselct() {
        return membresselct;
    }

    public void setMembresselct(List<Profil> membresselct) {
        this.membresselct = membresselct;
    }

    public MindmapNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public Groupe getGroupenew() {
        return groupenew;
    }

    public void setGroupenew(Groupe groupenew) {
        this.groupenew = groupenew;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public List<Publication1> getPublications1() {
        return publications1;
    }

    public void setPublications1(List<Publication1> publications1) {
        this.publications1 = publications1;
    }

    public Publication1 getPublication1() {
        return publication1;
    }

    public void setPublication1(Publication1 publication1) {
        this.publication1 = publication1;
    }

    public Publication1 getNewpublication1() {
        return newpublication1;
    }

    public void setNewpublication1(Publication1 newpublication1) {
        this.newpublication1 = newpublication1;
    }

    public PublicationDAO1 getPublicationDAO1() {
        return publicationDAO1;
    }

    public void setPublicationDAO1(PublicationDAO1 publicationDAO1) {
        this.publicationDAO1 = publicationDAO1;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Publication getNewpublication() {
        return newpublication;
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNewpublication(Publication newpublication) {
        this.newpublication = newpublication;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public List<Utilisateur> getUsers() {
        return userDAO.findAll();
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }

    public Profil getProfilnew() {
        return profilnew;
    }

    public void setProfilnew(Profil profilnew) {
        this.profilnew = profilnew;
    }

    public Utilisateur getUserNew() {
        return userNew;
    }

    public void setUserNew(Utilisateur userNew) {
        this.userNew = userNew;
    }

    public List<Inscription> getInscrips() {
        return inscrips;
    }

    public void setInscrips(List<Inscription> inscrips) {
        this.inscrips = inscrips;
    }

    public Planning getTache() {
        return tache;
    }

    public void setTache(Planning tache) {
        this.tache = tache;
    }

    public String add() throws FileNotFoundException {



        try {
            userDAO.beginTransaction();
            userDAO.save(userNew);
            userDAO.commit();
            user = userDAO.findByLogin(this.userNew.getLogin()).get(0);
            profilnew.setUtilisateur(user);
            profilDAO.beginTransaction();
            profilDAO.save(profilnew);
            profilDAO.commit();
            profil = profilDAO.findByPseudo(profilnew.getPseudo()).get(0);
            insert_file(canFile, profil.getPseudo());
            userNew = new Utilisateur();
            profilnew = new Profil();
            path = "";
            canFile = "";



            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Porteur ajouté  avec succès ", ""));

        } catch (ExceptionInInitializerError e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Echec :Certains valeurs sont nulls ", ""));
        }
        return "../login.xhtml?faces-redirect=true";
    }

    public String modifProfil() throws FileNotFoundException {



        try {
            userDAO.beginTransaction();
            userDAO.merge(user);
            userDAO.commit();
            user = userDAO.findByLogin(this.user.getLogin()).get(0);
            profilnew.setUtilisateur(user);
            profilDAO.beginTransaction();
            profilDAO.merge(profil);
            profilDAO.commit();





            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Porteur ajouté  avec succès ", ""));

        } catch (ExceptionInInitializerError e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Echec :Certains valeurs sont nulls ", ""));
        }
        return "";
    }

    public void redirect() throws IOException {
        if (user.getId() == null) {
            System.out.println("User is null");
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();

            extContext.redirect("../login.xhtml?faces-redirect=true");
        }

    }

    public void signup() throws IOException {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("addProfil.xhtml?faces-redirect=true");
    }

    public void onNodeDblselect(SelectEvent event) throws IOException {
        this.selectedNode = (MindmapNode) event.getObject();
        groupe = groupeDao.findByNom(this.selectedNode.getLabel()).get(0);
        
        publications = publicationDAO.findByProperty("groupe", groupe);
        inscrips = new InscriptionDAO().findByTowProperty("profil", profil, "groupe", groupe);
        if (inscrips.isEmpty()) {
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            extContext.redirect("addpGroupe.xhtml?faces-redirect=true");
        } else {
            if (inscrips.get(0).getRole().equals("administrateur")) {
                hidden = "false";
            } else {
                hidden = "true";
            }
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            extContext.redirect("pGroupe.xhtml?faces-redirect=true");
        }
    }
    public void onNodeRightClick(SelectEvent event) throws IOException {
        this.selectedNode = (MindmapNode) event.getObject();
         ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            extContext.redirect("pGroupe.xhtml?faces-redirect=true");
    }
    
   public void test( )throws IOException {
       
        addMessage ("test");
        
   }
   public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
        
   

    public String groupa(Groupe group) throws IOException {
        groupe = group;
        publications = publicationDAO.findByProperty("groupe", groupe);
        inscrips = new InscriptionDAO().findByTowProperty("profil", profil, "groupe", groupe);
        if (inscrips.get(0).getRole().equals("administrateur")) {
            hidden = "false";
        } else {
            hidden = "true";
        }

        return "pGroupe.xhtml?faces-redirect=true";
    }
    
    
    public String connect() throws FileNotFoundException, IOException {

        List<Utilisateur> lu = userDAO.findByLoginAndPass(user.getLogin(), user.getPassword());
        System.out.println("user " + lu.size());
        if (lu.size() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login or password is not correct ", ""));

            return "";
        }
        user = lu.get(0);
        profil = (Profil) new ProfilDAO().findByProperty("utilisateur", user).get(0);
        retreive_image(profil.getPseudo());
        inscrips = new InscriptionDAO().findByProperty("profil", profil);
        for (int i = 0; i < inscrips.size(); i++) {
            groupes.add(inscrips.get(i).getGroupe());
        }
        return "/pages/acceuil.xhtml?faces-redirect=true";

    }

    public void comment(Publication publication) throws IOException {
        this.publication = publication;
        commentaires = commentDAO.findByProperty("publication", this.publication);
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("publication.xhtml?faces-redirect=true");
    }

     public void comment1(Publication1 publication1) throws IOException {
        this.publication1 = publication1;
        commentaires = commentDAO.findByProperty("publication1", this.publication);
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("publication.xhtml?faces-redirect=true");
    }
    public void commenter() {
        commentaire.setPublication(publication);
        commentaire.setProfil(profil);
        commentDAO.beginTransaction();
        commentDAO.save(commentaire);
        commentDAO.commit();
        commentaires = commentDAO.findByProperty("publication", this.publication);
        commentaire = new Commentaire();

    }

       public void commenter1() {
        commentaire.setPublication(publication1);
        commentaire.setProfil(profil);
        commentDAO.beginTransaction();
        commentDAO.save(commentaire);
        commentDAO.commit();
        commentaires = commentDAO.findByProperty("publication1", this.publication1);
        commentaire = new Commentaire();

    }

    public void publier() {
        newpublication.setGroupe(groupe);
        newpublication.setProfil(profil);
        publicationDAO.beginTransaction();
        String s = newpublication.getPublication();
        if (s.equals("")) {
            System.err.println("pub  vide");
        } else {
            publicationDAO.save(newpublication);
            publicationDAO.commit();
            publications = publicationDAO.findByProperty("groupe", this.groupe);
            newpublication = new Publication();
        }
    }
      public void publierprofil() {
          
        newpublication1.setProfil(profil);
        publicationDAO1.beginTransaction();
        String s = newpublication1.getPublication();
        if (s.equals("")) {
            System.err.println("pub  vide");
        } else {
            publicationDAO1.save(newpublication1);
            publicationDAO1.commit();
            publications1 = publicationDAO1.findByProperty("profil", this.profil);
            newpublication1 = new Publication1();
        }
    }

    public void saveGroup() {
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        groupenew.setGroupe(groupe);
        groupenew.setDtCreation(dateFormat.format(actuelle));
        groupenew.setDtModification(dateFormat.format(actuelle));
        groupeDao.beginTransaction();
        groupeDao.save(groupenew);
        groupeDao.commit();
        groupenew = new Groupe();

    }

    public void supGroup() throws IOException {
        publications.clear();
        inscrips.clear();
        groupes.clear();
        groupeDao.beginTransaction();
        groupeDao.delete(groupe);
        groupeDao.commit();

        inscrips = new InscriptionDAO().findByProperty("profil", profil);
        for (int i = 0; i < inscrips.size(); i++) {
            groupes.add(inscrips.get(i).getGroupe());
        }
        groupe = new Groupe();

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("acceuil.xhtml?faces-redirect=true");
    }

    public void modifGroup() throws IOException {
        publications.clear();
        inscrips.clear();
        groupes.clear();
        groupeDao.beginTransaction();
        groupeDao.merge(groupe);
        groupeDao.commit();

        inscrips = new InscriptionDAO().findByProperty("profil", profil);
        for (int i = 0; i < inscrips.size(); i++) {
            groupes.add(inscrips.get(i).getGroupe());
        }
        publications = publicationDAO.findByProperty("groupe", this.groupe);

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("pGroupe.xhtml?faces-redirect=true");
    }

    public void suppPublication(Publication publication1) throws IOException {
        publications.clear();
        publicationDAO.beginTransaction();
        publicationDAO.delete(publication1);
        publicationDAO.commit();

        publications = publicationDAO.findByProperty("groupe", this.groupe);
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("pGroupe.xhtml?faces-redirect=true");
    }

     public void suppPublication1(Publication1 publication1) throws IOException {
        publications1.clear();
        publicationDAO1.beginTransaction();
        publicationDAO1.delete(publication1);
        publicationDAO1.commit();

        publications1 = publicationDAO1.findByProperty("profil", this.profil);
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("pProfil.xhtml?faces-redirect=true");
    }
     
     
    public void suppCommentaire(Commentaire comment1) throws IOException {
        inscrips.clear();
        commentaires.clear();
        publications.clear();
        groupes.clear();
        commentDAO.beginTransaction();
        commentDAO.delete(comment1);
        commentDAO.commit();

        inscrips = new InscriptionDAO().findByProperty("profil", profil);
        for (int i = 0; i < inscrips.size(); i++) {
            groupes.add(inscrips.get(i).getGroupe());
        }
        publications = publicationDAO.findByProperty("groupe", this.groupe);
        commentaires = commentDAO.findByProperty("publication", this.publication);
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("publication.xhtml?faces-redirect=true");
    }

    public void insert_file(String name, String nom) throws FileNotFoundException {

        System.out.println(name);
        File file = new File(name);

        FileInputStream fis = new FileInputStream(file);
        //System.out.println(file.exists() + "!!");
        //InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
        }
        byte[] bytes = bos.toByteArray();
        nom = nom.replace(' ', '_');
        image = new Image();
        image.setDescreption(nom);
        image.setFile(bytes);
        image.setProfil(profil);
        System.out.println(image.getFile().toString());
        imageDAO.beginTransaction();
        imageDAO.save(image);
        imageDAO.commit();

    }
    private String canFile;
    private String path2 = "../images/avatars/avatar1.jpg";

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            System.out.println("path:");
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            File targetFolder = new File(extContext.getRealPath(event.getFile().getFileName()));
            //System.out.println(extContext.getRealPath("//img//" + event.getFile().getFileName()));
            InputStream inputStream = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(targetFolder);
            path = event.getFile().getFileName();
            path2 = event.getFile().getFileName();
            System.out.println("path:" + event.getFile().getFileName());
            System.out.println("Absolute path:" + targetFolder.getAbsolutePath());
            canFile = targetFolder.getAbsolutePath();
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retreive_image(String desc) throws FileNotFoundException, IOException {
        try {
            image = (Image) imageDAO.findByDescrep(desc).get(0);
            System.out.println("image:" + image.getDescreption());
            if (image.getId() != null) {
                ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
                File targetFolder = new File(extContext.getRealPath(desc + ".png"));
                File file = new File(desc + ".png");
                desc = desc.replace(' ', '_');
                path2 = desc + ".png";
                path2 = path2.replace(' ', '_');
                System.out.println("tar " + extContext.getRealPath(desc + ".png"));

                OutputStream out = new FileOutputStream(targetFolder);
                out.write(image.getFile());
                out.flush();
                out.close();
            }
        } catch (IndexOutOfBoundsException e) {
            path2 = "../images/avatars/avatar1.jpg";
        }
    }

    public void saveProjet() throws IOException {
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        projet.setGroupe(groupe);
        projet.setDtCreation(dateFormat.format(actuelle));
        projet.setDtModification(dateFormat.format(actuelle));
        projetDAO.beginTransaction();
        projetDAO.save(projet);
        projetDAO.commit();
        selectprojet = projetDAO.findByNom(this.projet.getNom()).get(0);
        inscrips = new InscriptionDAO().findByProperty("groupe", groupe);
        System.out.println(" je suis la");
        for (int i = 0; i < inscrips.size(); i++) {
            System.out.println(" je suis la");
            membres.add(inscrips.get(i).getProfil());
            System.out.println(membres.get(0).getNom());
        }
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("addProject.xhtml?faces-redirect=true");


    }

    public void onCarDrop(DragDropEvent ddEvent) {
        System.out.println(" jesuimoi");
        Profil prfl = ((Profil) ddEvent.getData());

        membresselct.add(prfl);
        membres.remove(prfl);
    }

    public void addmember() {
        System.out.println(" test addmembre");
        for (int i = 0; i < membresselct.size(); i++) {


            membreprojet.setProjet(selectprojet);
            membreprojet.setProfil(membresselct.get(i));
            membreprojet.setRole(role);
            mpdao.beginTransaction();
            mpdao.save(membreprojet);

            mpdao.commit();
            membreprojet = new MembreProjet();
        }

        membresselct.clear();
    }

    public void rejgroup() throws IOException {
        groupes.clear();
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        inscrit.setGroupe(groupe);
        inscrit.setProfil(profil);
        inscrit.setRole("membre");
        inscrit.setDtInscri(dateFormat.format(actuelle));
        inscriptionDAO.beginTransaction();
        inscriptionDAO.save(inscrit);
        inscriptionDAO.commit();
        inscrit = new Inscription();
        inscrips = inscriptionDAO.findByProperty("profil", profil);
        for (int i = 0; i < inscrips.size(); i++) {
            groupes.add(inscrips.get(i).getGroupe());
        }
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("pGroupe.xhtml?faces-redirect=true");

    }

    
    public void createTche(){
        tache.setProjet(selectprojet);
        planingDAO.beginTransaction();
        planingDAO.save(tache);
        planingDAO.commit();
        tache= new Planning();
    }
    
    public void projectList() throws IOException{
        System.out.println(" jesuila");
        projects = projetDAO.findByProperty("groupe", groupe);
         ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("lProject.xhtml?faces-redirect=true");
    }
    private ScheduleModel lazyEventModel;

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }
    

    public void slProject() throws IOException{
        System.out.println(" jesuilaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        taches = planingDAO.findByProperty("projet", selectprojet);
        System.out.println(" suilaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
       lazyEventModel = new LazyScheduleModel() {
			
			public void loadEvents() {
				clear();
                                for(int i=0; i<taches.size();i++){
                                    Date dt1 = new Date(taches.get(i).getDtDebut());
                                    Date dt2 = new Date(taches.get(i).getDtFin());
				addEvent(new DefaultScheduleEvent(taches.get(i).getNomTache(), dt1, dt2));
                                }

			}	
		}; 
         ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        extContext.redirect("pProject.xhtml?faces-redirect=true");
    }
    
    
}
