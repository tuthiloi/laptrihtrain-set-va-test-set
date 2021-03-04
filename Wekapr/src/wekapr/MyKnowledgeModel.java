/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapr;
import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.filters.unsupervised.instance.Resample;
/**
 *
 * @author Lợii
 */
public class MyKnowledgeModel {
     DataSource source;
    Instances dataset;
    String[] model_options;
    String[] data_options;
    Instances trainset;
    Instances testset;

    public MyKnowledgeModel() {
    }

//    public MyKnowledgeModel(DataSource source, Instances dataset) {
//        this.source = source;
//        this.dataset = dataset;
//    }

    public MyKnowledgeModel(String filename,
                     String m_opts,
                     String d_opts) throws Exception {
        this.source = new DataSource(filename) ;
        this.dataset = source.getDataSet();
        if(m_opts!=null){
            this.model_options=weka.core.Utils.splitOptions(m_opts);
        }if(d_opts!=null){
            this.model_options=weka.core.Utils.splitOptions(d_opts);
        }
//        this. model_options = weka.core.Utils.splitOptions(m_opts);
//        this. data_options = weka.core.Utils.splitOptions(d_opts);
    }

//    MyKnowledgeModel(String dwekaWeka385datairisarff) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public Instances removeData(Instances originalData) throws Exception {
        Remove remove = new Remove();
        remove.setOptions(data_options);
        remove.setInputFormat(originalData);
        return Filter.useFilter(originalData, remove);
    }
    
     public Instances converData(Instances originalData) throws Exception {
//         NumericToNominal n2n = new NumericToNominal();
         Remove remove=new Remove();
         remove.setOptions(data_options);
         remove.setInputFormat(originalData);
         return Filter.useFilter(originalData, remove);
     }
     
     public Instances convert2Binary(Instances originalData) throws Exception {
         NominalToBinary n2b = new NominalToBinary();
         n2b.setOptions(data_options);
         n2b.setBinaryAttributesNominal(true);
         n2b.setInputFormat(originalData);
         return Filter.useFilter(originalData, n2b);
     } 
     

    public void saveData(String filename) throws IOException {
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.print("Finished");
    }

    public void saveData2CSV(String filename) throws IOException {
        CSVSaver outData = new CSVSaver();
        outData.setFile(new File(filename));
        outData.setInstances(this.dataset);
        outData.writeBatch();
        System.out.println("Converted");
    } 
    public Instances divideTrainTest(Instances originalSet,double percent,boolean isTest) throws Exception{
        RemovePercentage rp=new RemovePercentage();
        rp.setPercentage(percent);
        rp.setInvertSelection(isTest);
        rp.setInputFormat(originalSet);
        return Filter.useFilter(originalSet, rp);
        
    }
    public Instances divideTrainTestR(Instances originalSet,double percent,boolean isTest) throws Exception{
        Resample rs= new Resample ();
        rs.setNoReplacement(true);
        rs.setInvertSelection(isTest);
        rs.setInputFormat(originalSet);
        return Filter.useFilter(originalSet, rs);
        
        
    }
    
    @Override
    public String toString() {
        return dataset.toSummaryString();
    }

    private void newRemove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}





