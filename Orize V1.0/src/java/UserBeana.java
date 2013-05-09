



public class UserBeana {

  /*  @Ejb
    private UtilisateurDAO userDAO = new UtilisateurDAO();
    private List<Utilisateur> users;
    private String hide = "";
    private Utilisateur user = new Utilisateur();
    private Utilisateur userNew = new Utilisateur();
    private Utilisateur userToDelete = new Utilisateur();

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

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public List<Utilisateur> getUsers() {
        return userDAO.findAll();
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }

    public Utilisateur getUserNew() {
        return userNew;
    }

    public void setUserNew(Utilisateur userNew) {
        this.userNew = userNew;
    }

    public void delete(Utilisateur userToDelete) {

        userDAO.beginTransaction();
        userDAO.delete(userToDelete);
        userDAO.commit();
        users = userDAO.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur supprimé avec succès " + userToDelete.getUsername(), ""));

        System.out.println("Delete Utilisateur" + userToDelete.getUsername());
        userToDelete = new Utilisateur();


    }

    public String add() {
        if (userNew.getUsername().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username is empty", ""));
            System.out.println("Username Required");
            return ("");
        } else if (userNew.getPassword().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username is empty", ""));
            System.out.println("Password Required");
            return ("");
        } else {
            userDAO.beginTransaction();
            userDAO.save(userNew);
            userDAO.commit();
            System.out.println("Ajout Utilisateur");
            userNew = new Utilisateur();
            System.out.println("Utilisateur ajouté");

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur ajouté  avec succès ", ""));
            return ("dlg3.hide();");
        }
    }

    public void redirect() throws IOException {
        if(user.getId()==null){
            System.out.println("User is null");
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();

        extContext.redirect("login.xhtml?faces-redirect=true");
    }
        
    } 

    public String hideme() {
        try {
            if (userNew.getUsername().isEmpty() || userNew.getPassword().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "empty ", ""));

                return "";
            }
            return "dlg3.hide();";
        } catch (NullPointerException e) {
            return "dlg3.show();";
        }
    }

    public String connect() {

        List<Utilisateur> lu = userDAO.findByLoginAndPass(user.getUsername(), user.getPassword());
        System.out.println("user " + lu.size());
        if (lu.size() == 0) {
            return "";
        }
        user = lu.get(0);
        return "index.xhtml?faces-redirect=true";
    }*/
}
