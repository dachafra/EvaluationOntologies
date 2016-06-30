package com.ontoeval.model;

import java.util.ArrayList;

/**
 * Created by dachafra on 11/05/16.
 */
public class OntologyVO {

    private String name;
    private ArrayList<String> terms;
    private ArrayList<String> relations;


    public OntologyVO(String name, ArrayList<String> terms, ArrayList<String> relations) {
        this.name = name;
        this.terms = terms;
        this.relations = relations;
    }

    public OntologyVO(String name) {
        this.name = name;
        this.terms = new ArrayList<String>();
        this.relations = new ArrayList<String>();
    }

    public OntologyVO() {
        this.name = "Example";
        this.terms = new ArrayList<String>();
        this.relations = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTerms() {
        return terms;
    }

    public void setTerms(ArrayList<String> terms) {
        this.terms = terms;
    }

    public ArrayList<String> getRelations() {
        return relations;
    }

    public void setRelations(ArrayList<String> relations) {
        this.relations = relations;
    }
}
