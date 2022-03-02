package heartnew;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HeartTotalFrame extends JFrame{
    EcgPanel canvas = new EcgPanel();
    public JSlider FrequencySlider = new JSlider(40, 60, 50);
    public JSlider PrIntervalSlider = new JSlider(5, 15, 10);

    public HeartTotalFrame(String title){
        super(title);

        Box root = Box.createVerticalBox();
        this.setContentPane(root);

        if(true) {
            Box box = Box.createVerticalBox();
            root.add(box, "30px");
            box.add(new JLabel("周期"), "50px");
            box.add(this.canvas, "1w");
        }

        if(true) {
            Box box = Box.createVerticalBox();
            root.add(box, "30px");
            box.add(new JLabel("Frequency"), "50px");
            box.add(this.FrequencySlider, "1w");
        }

        if(true) {
            Box box = Box.createVerticalBox();
            root.add(box, "30px");
            box.add(new JLabel("PrInterval"), "50px");
            box.add(this.PrIntervalSlider, "1w");
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
