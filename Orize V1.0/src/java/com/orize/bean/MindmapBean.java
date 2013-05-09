/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orize.bean;

import java.io.Serializable;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;
import com.orize.dao.GroupeDAO;
import com.orize.entity.Groupe;

import java.util.List;

@ManagedBean
@ViewScoped
public class MindmapBean implements Serializable {

    private MindmapNode root;
    private MindmapNode selectedNode;

    public MindmapBean() {
        super();


        Groupe groupe = (Groupe) new GroupeDAO().findByNom("Monde").get(0);
        List<Groupe> groupes = new GroupeDAO().findAll();
        root = new DefaultMindmapNode(groupe.getNom(), groupe.getObjectifs(), "92cff5", true);
        root.setSelectable(true);

        for (int j = 0; j < groupes.size(); j++) {
            if (groupes.get(j).getGroupe().getNom().equals(root.getLabel()) && !groupes.get(j).getStatu().toString().equals("Blocked")) {
                root.addNode(new DefaultMindmapNode(groupes.get(j).getNom(), groupes.get(j).getObjectifs(), "4291A6", true));

            }
        }

    }

    public void export() {
        Groupe groupe = (Groupe) new GroupeDAO().findByNom("Monde").get(0);
        List<Groupe> groupes = new GroupeDAO().findAll();

        for (int j = 0; j < groupes.size(); j++) {
            if (groupes.get(j).getGroupe().getNom().equals(root.getLabel()) && !groupes.get(j).getStatu().toString().equals("Blocked")) {
                root.addNode(new DefaultMindmapNode(groupes.get(j).getNom(), groupes.get(j).getObjectifs(), "4291A6", true));

            }
        }
    }

    

    public MindmapNode getRoot() {
        return root;
    }

    public MindmapNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void onNodeSelect(SelectEvent event) {
        MindmapNode node = (MindmapNode) event.getObject();

        //populate if not already loaded
        if (node.getChildren().isEmpty()) {

            List<Groupe> groupes = new GroupeDAO().findAll();
            for (int i = 0; i < groupes.size(); i++) {


                if (groupes.get(i).getGroupe().getNom().equals(node.getLabel())) {

                    node.addNode(new DefaultMindmapNode(groupes.get(i).getNom(), groupes.get(i).getObjectifs(), "82c542"));
                }
            }
        }
    }

    public void init() {
        this.init();
    }
}
