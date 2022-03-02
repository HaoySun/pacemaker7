package demo;

import af.swing.LayoutBox;
import af.swing.layout.HLayout;
import af.swing.layout.VLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SettingDialog extends JDialog {

    //数据调节器控件
    //value初始值
    //step步长
    public JSpinner grainField = new JSpinner(new SpinnerNumberModel(1,1,5,1));
    public JSpinner radiusField = new JSpinner(new SpinnerNumberModel(50,20,80,5));
    public JSpinner periodField = new JSpinner(new SpinnerNumberModel(100,50,150,10));

    //JTextField userInput = new JTextField(10);

    JButton okButton = new JButton("确定");
    //JButton cancelButton = new JButton("取消");

    private boolean accepted = false;

    public SettingDialog(Window owner){
        //调用父类构造方法，进行初始化
        super(owner);

        //JPanel root = new JPanel();
        //this.setContentPane(root);
        //root.setLayout(new BorderLayout());

        LayoutBox root = new LayoutBox().layout(new VLayout(10));
        root.padding(15);
        this.setContentPane(root);

        if(true){
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            root.add(box, "30px");// 行高
            box.add(new JLabel("粒度"), "50px"); // 标签宽度
            box.add(this.grainField, "1w");	 // 控件宽度

            //JPanel panel =new JPanel();
            //root.add(panel,BorderLayout.CENTER);

            //JLabel label = new JLabel("请输入");
            //panel.add(label);

            //panel.add(userInput);

        }

        if( true ) {
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            root.add(box, "30px");
            box.add(new JLabel("半径"), "50px");
            box.add(this.radiusField, "1w");
        }
        if( true ) {
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            root.add(box, "30px");
            box.add(new JLabel("周期"), "50px");
            box.add(this.periodField, "1w");
        }


        //底部添加确认和取消按钮
        if(true){
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            root.add(box, "50px");
            box.padding(10, 0, 5, 0);

            box.add(new JLabel(), "1w"); // 左边放一个空的JLabel, 占位
            box.add( okButton);
            //JPanel panel =new JPanel();
            //root.add(panel,BorderLayout.SOUTH);

            //panel.add(okButton);
            //panel.add(cancelButton);
        }

        //点"确定"按钮时
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    accepted = true;
                    setVisible(true);//关闭对话框
            }
        });
    }

    public boolean exec(){
        this.setTitle("参数设置");
        this.setModal(true);//模态的，即阻塞模式
        this.setSize(350, 250);

        centerInOwner();

        //显示对话框，并阻塞等待
        this.setVisible(true);//显示对话框，并阻塞

        return accepted;//accepted为true的时候，表示用户点了确定，为false表示用户取消了操作

    }

    //显示在原窗口的中央
    private void centerInOwner(){
        // 获取原窗口的位置
        Rectangle ownerRect = this.getOwner().getBounds();

        // 显示在原窗口的中央
        int width = this.getWidth();
        int height = this.getHeight();
        int x = ownerRect.x + (ownerRect.width - width)/2;
        int y = ownerRect.y + (ownerRect.height - height)/2;
        this.setBounds(x,y, width, height);


    }

    ////测试对话框
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600,400);
        frame.setVisible(true);

        SettingDialog dia = new SettingDialog(frame);
        dia.exec();
    }



}
