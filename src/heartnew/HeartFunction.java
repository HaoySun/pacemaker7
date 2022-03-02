package heartnew;

import af.swing.LayoutBox;
import af.swing.layout.HLayout;
import af.swing.layout.VLayout;
import demo.SettingDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HeartFunction {
    public JSlider periodSlider = new JSlider(50, 150, 100);
    public JSlider radiusSlider = new JSlider(20, 80, 40);
    JButton okButton = new JButton("确定");

    public boolean accepted = false;
    JPanel root = new JPanel();

    public void HeartFunction(){

    }

    private void setCanvas(){
        if(true) {
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            this.root.add(box, "30px");
            box.add(new JLabel("周期"), "50px");
            box.add(this.periodSlider, "1w");
        }

        if(true) {
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            this.root.add(box, "30px");
            box.add(new JLabel("频率"), "50px");
            box.add(this.radiusSlider, "1w");
        }

        if(true){
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            this.root.add(box, "50px");
            box.padding(10, 0, 5, 0);

            box.add(new JLabel(), "1w"); // 左边放一个空的JLabel, 占位
            box.add( okButton);
            //JPanel panel =new JPanel();
            //root.add(panel,BorderLayout.SOUTH);

            //panel.add(okButton);
            //panel.add(cancelButton);
        }
    }

    public boolean exec(){
        this.root.setName("参数设置");
        //this.setModal(true);//模态的，即阻塞模式
        this.root.setSize(350, 250);

        centerInOwner();

        setCanvas();
        //显示对话框，并阻塞等待
        this.root.setVisible(true);//显示对话框，并阻塞

        return accepted;
    }

    private void centerInOwner(){
        // 获取原窗口的位置
        Rectangle ownerRect = this.root.getBounds();

        // 显示在原窗口的中央
        int width = this.root.getWidth();
        int height = this.root.getHeight();
        int x = ownerRect.x + (ownerRect.width - width)/2;
        int y = ownerRect.y + (ownerRect.height - height)/2;
        this.root.setBounds(x,y, width, height);


    }

    public static void main(String[] args) {

        HeartFunction dia = new HeartFunction();
        dia.exec();
    }

    public JPanel getRoot() {
        return this.root;
    }

    public void setRoot(JPanel root) {
        this.root = root;
    }
}
