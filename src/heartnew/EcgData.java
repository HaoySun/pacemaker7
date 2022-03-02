package heartnew;

import java.util.ArrayList;

public class EcgData {
    //the middle value of chart
    public int middleNode = 100;//100中间线的点
    //avNode fixed Height
    public int avNode = 70;//70第一个波峰
    //saNode fixed Height
    public int saNode1 = 20;//20第二个波峰
    public int saNode2 = 120;//120第三个波峰
    //Heart Rate can adjust 0-220
    //public int frequency=20;
    //Heart Rate can adjust 0-550
    public int prInterval=10;
    //data set to input chart
    private ArrayList<Integer> dataSet = new ArrayList<Integer>();




    public ArrayList<Integer> getEcgSetData(){
        dataSet.clear();
       while (true){
           EcgSetData();
           //50
           if (dataSet.size()>50){
               dataSet.subList(0,50);
               break;
           }
       }
        return dataSet;
    }

    //27
    //20
    public void EcgSetData(){//27
        for (int i = 0; i< 27;i++){
            dataSet.add(middleNode);
        }
        dataSet.add(avNode);
        for (int i = 0; i< prInterval;i++){
            dataSet.add(middleNode);
        }
        dataSet.add(saNode1);
        dataSet.add(saNode2);
    }

    //public void setFrequency(int frequency) {this.frequency = frequency;}

    //public void setPrInterval(int prInterval) {this.prInterval = prInterval;}
}
