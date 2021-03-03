/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapr;

import weka.associations.Apriori;
import weka.core.Instances;

/**
 *
 * @author Lợii
 */
public class MyAprioriModel extends  MyKnowledgeModel{
    Apriori apriori;
    Instances newData;

    public MyAprioriModel() {
    }

    public MyAprioriModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
        this.apriori=new Apriori();
        
    } 

    MyAprioriModel(String dwekaWeka385datairisarff) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void mineAssociationRules() throws Exception{
        //lap du lieu
//        this.newData=removeData(this.dataset);
this.newData=converData(this.dataset);
        //thiet lap thong so cho model App
        apriori.buildAssociations(this.newData);
    }

    @Override
    public String toString() {
     return apriori.toString();
    }
    
}
 