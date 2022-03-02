package heartnew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeartCurve extends JPanel {
    public int grain = 1;  // 线条的精细度 ( 粒度 )
    public int radius = 50; // 高度 ( 振幅 )
    public int radius2 = 60;
    public int period = 100; // X轴, 每100像素表示一个周期(2PI)

    private int []xPoints = new int[1000];
    private int []yPoints = new int[1000];
    private int []xPoints2 = new int[1000];
    private int []yPoints2 = new int[1000];
    private int []yCopyPoints = new int[2];

    public int interval = 10;

    private Timer timer;

    @Override
    protected void paintComponent(Graphics g)
    {
        // 请保留这一行调用
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        // 得到当前这个控件的宽度、高度
        int width = this.getWidth();
        int height = this.getHeight();

        // 底色设为白色
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, width, height);

        // 中线
        int center = height/2;
        g.setColor(Color.blue);
        g.drawLine(0, center, width, center);

        // 正弦曲线 （ 掌握思想即可:由多个小段连接而成，近似为一条曲线 )
        xPoints2[0]=0;
        yPoints2[0]=0;
        int x1 = 0;
        int y1 = 0;

        for(int i=0; i<width; i+= grain)
        {
            xPoints[i]=i;
            xPoints2[i+1]=i;
            int m =period;
            for(int j = 0;j<6;j++){
                int n =period*(j+1)+40*j;
                if(i>n && i< n+20){
                    yPoints[i]=(int)(-i * radius/20 + radius*n/20);
                    yPoints2[i+1]=(int)(-i * radius/20 + radius*n/20);
                }else if(i>n+20 && i< n+40){
                    yPoints[i]=(int)(i * radius/20 - radius*(40+n)/20);
                    yPoints2[i+1]=(int)(i * radius/20 - radius*(40+n)/20);
                }else if(i>n+40+interval && i< n+40+interval+20){
                    yPoints[i]=(int)(i * radius2/20 - radius2*(n+40+interval)/20);
                    yPoints2[i+1]=(int)(i * radius2/20 - radius2*(n+40+interval)/20);
                }else if(i>n+60+interval && i< n+80+interval){
                    yPoints[i]=(int)(-i * radius2/20 + radius2*(n+80+interval)/20);
                    yPoints2[i+1]=(int)(-i * radius2/20 + radius2*(n+80+interval)/20);
                }

                //g.drawPolyline(xPoints,yPoints,1000);
                g.drawLine(xPoints2[i], center+yPoints2[i], xPoints[i], center+yPoints[i]);
            }
        }

        timer = new Timer(100,new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                for(int i = 0; i < 999; i++){
                    yPoints[i] = yPoints[i+1];
                    yPoints2[i] = yPoints2[i+1];
                }
                repaint();
            }
        });

        timer.start();

    }
}

