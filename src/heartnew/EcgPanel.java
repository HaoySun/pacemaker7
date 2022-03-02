package heartnew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EcgPanel extends JPanel {
    public EcgPanel(){}

    //x-axis displacement controlled by timer Action
    private final int TEP = 5;
    //inital x-axis value
    private int xValue = 100;
    private int count = -1;

    public int frequency=50;

    //prepare the List to store x-axis data
    private List<Integer> x_axis = new ArrayList<Integer>();

    //prepare the List to store y-axis data
    private List<Integer> y_axis = new ArrayList<Integer>();

    public EcgData ecgData=new EcgData();

    public Timer timer;


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (count == frequency){//改变周期
            count = -1;
        }
        count++;
        //before every paint ecg chart clear entity panel
        g.clearRect(0,0,1200,200);
        g.setColor(Color.RED);

        if (xValue<=1100) {
            x_axis.add(xValue);
            xValue += TEP;
        }

        y_axis.add(singleYData(ecgData));

        if (xValue > 1100){
            //the length of x_axis 1100;
            y_axis.remove(0);
        }

        //prepare Array to paint chart
        int[] x_array = new int[301];//201
        int[] y_array = new int[301];

       for (int i = 0; i<x_axis.size() ;i++ ){
           x_array[i] = x_axis.get(i);
       }
        for (int i = 0; i<y_axis.size() ;i++ ){
            y_array[i] = y_axis.get(i);
        }

        //draw the ecg chart
        g.drawPolyline(x_array,y_array,y_axis.size());

        timer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //this method can automatic call the Panel about paint method
                repaint();
            }
        });

        timer.start();


    }

    public int singleYData(EcgData ecgData){
        ArrayList<Integer> ecgSetData = ecgData.getEcgSetData();
        Integer data1 = ecgSetData.get(count);
        return data1;
    }

    public EcgData getEcgData() {
        return ecgData;
    }

    public void setEcgData(EcgData ecgData) {
        this.ecgData = ecgData;
    }


}
