package heartnew;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeartFrame extends JFrame{
    //原始心脏图
    EcgPanel canvas = new EcgPanel();
    //不同模型
    EcgPanel canvas2 = new EcgPanel();

    //左上部分
    TextField modelName = new TextField("Model");
    Button off = new Button("OFF");
    Button AAI = new Button("AAI");
    Button VDD = new Button("VDD");
    Button DDO = new Button("DDO");

    //右上部分
    //控制心脏频率
    public JSlider FrequencySlider = new JSlider(40, 60, 50);
    //控制间隔
    public JSlider PrIntervalSlider = new JSlider(5, 15, 10);

    public HeartFrame(String title){
        super(title);

        Box root = Box.createVerticalBox();
        this.setContentPane(root);

        if(true) {
            Box box = Box.createVerticalBox();
            root.add(box, "30px");
            box.add(new JLabel("Heart"), "50px");
            box.add(this.canvas, "1w");
            box.setPreferredSize(new Dimension(600,150));
        }

        if(true){
            Box box = Box.createVerticalBox();
            root.add(box, "30px");
            box.add(new JLabel("Model"), "50px");
            box.add(this.canvas2, "1w");
            box.setPreferredSize(new Dimension(600,150));
        }


        if(true){
            //组装左边选择部分
            Box lBox = Box.createVerticalBox();
            lBox.add(off);
            lBox.add(modelName);
            lBox.add(AAI);
            lBox.add(VDD);
            lBox.add(DDO);
            lBox.setPreferredSize(new Dimension(200,50));

            //组装右边选择部分
            Box rBox = Box.createVerticalBox();
            rBox.add(new JLabel("HeartChange"), "50px");

            Box fbox1 = Box.createVerticalBox();
            fbox1.add(new JLabel("Frequency"));
            fbox1.add(this.FrequencySlider, "1w");
            Box fbox2 = Box.createVerticalBox();
            fbox2.add(new JLabel("PrInterval"));
            fbox2.add(this.PrIntervalSlider, "1w");

            rBox.add(fbox1);
            rBox.add(fbox2);

            Box top = Box.createHorizontalBox();
            root.add(top, "30px");
            top.add(lBox);
            top.add(rBox);

        }


        FrequencySlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                onSettings();
            }
        });

        PrIntervalSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                onSettings();
            }
        });


    }





    private void onSettings()
    {
       //func.radiusSlider.setValue( canvas.radius);
        // 读取对话框的值，设到 曲线中
        canvas.frequency = (Integer) FrequencySlider.getValue();
        EcgData ecgData = new EcgData();
        //ecgData.frequency=(Integer)FrequencySlider.getValue();
        ecgData.prInterval=(Integer)PrIntervalSlider.getValue();

        canvas.setEcgData(ecgData);
        canvas.repaint(); // 更新曲线的绘制

    }
}
