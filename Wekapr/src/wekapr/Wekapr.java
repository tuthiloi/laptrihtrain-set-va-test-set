/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapr;

/**
 *
 * @author Lợii
 */
public class Wekapr {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
       
//         TODO code application logic here
//        MyKnowledgeModel model = new MyKnowledgeModel("D:\\weka\\Weka-3-8-5\\data\\iris.arff");
//        System.out.println(model);
//        model.saveData("D:\\data\\iris.arff");
//        model.saveData2CSV("D:\\data\\iris.csv");

//       MyAprioriModel model = new MyAprioriModel("D:\\weka\\Weka-3-8-5\\data\\weather.numeric.arff","-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1","-R 2-3");
//       model.mineAssociationRules();
       MyFPGrowthModel model =new MyFPGrowthModel("D:\\weka\\Weka-3-8-5\\data\\weather.nominal.arff","-P 2 -I -1 -N 10 -T 0 -C 0.7 -D 0.05 -U 1.0 -M 0.2","-N -R first-last");
      model.mineAssociationRule();
       System.out.println(model);
    }
    
}



